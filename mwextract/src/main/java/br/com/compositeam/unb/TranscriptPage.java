package br.com.compositeam.unb;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.compositeam.unb.storage.TranscriptStorage;
import br.com.compositeam.unb.storage.file.TranscriptStorageFile;

public class TranscriptPage {
	
	private String id;
	private String password;
	private Document document;
	Map<String,String> data;
	private TranscriptStorage storage;
	
	public TranscriptPage(String id,String password,TranscriptStorage storage){
		this.id = id;
		this.password = password;
		this.data = new HashMap<String, String>();
		this.storage = storage;
	}
	public TranscriptPage(String id, String password){
		this(id,password, new TranscriptStorageFile());
	}
	
	private void get(){
		try {
			Connection.Response loginForm = Jsoup.connect("https://wwwsec.serverweb.unb.br/matriculaweb/graduacao/sec/login.aspx")
					.validateTLSCertificates(false)
			        .method(Connection.Method.GET)
			        .execute();
			for(String key: loginForm.cookies().keySet()){
				System.out.println("Key: " + key + " Value " + loginForm.cookies().get(key));
			}
			System.out.println("------------------------------------------------------------------");
			Connection.Response logined = Jsoup.connect("https://wwwsec.serverweb.unb.br/matriculaweb/graduacao/sec/login.aspx")
					.validateTLSCertificates(false)
					.method(Connection.Method.POST)
			        .data("inputMatricula", this.id)
			        .data("inputSenha", this.password)
			        .data("login:_ctl0", "++++Enviar++++")
			        .cookies(loginForm.cookies())
			        .execute();
			System.out.println(logined.body());
			System.out.println("-------------------------------------------------------------------------");
			for(String key: loginForm.cookies().keySet()){
				logined.cookie(key, loginForm.cookies().get(key));
			}
			
			for(String key: logined.cookies().keySet()){
				System.out.println("Key: " + key + " Value " + logined.cookies().get(key));
			}
			System.out.println("------------------------------------------------------------------");
			document  = Jsoup.connect("https://wwwsec.serverweb.unb.br/matriculaweb/graduacao/sec/he.aspx")
					.validateTLSCertificates(false)
			        .data("inputMatricula", "11/0030559")
			        .data("inputSenha", "japz1217")
			        .cookies(logined.cookies())
			        .post();
			
			System.out.println(document.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void extractData(){
		this.get();
		Elements table = document.select("table").eq(1);
		Elements trs = table.select("tr");
		String semester = "";
		System.out.println(" Periodos -------------------------------------------------------------");
		for(int i = 3; i< trs.size(); i++){
			Element tr = trs.get(i);
			Elements tds = tr.select("td");
			int size = Math.min(tds.size(), 3);
			for(int j = 0; j < size; j++){
				Element td = tds.get(j);
				if(td.hasAttr("colspan")){
					String colspan = td.attr("colspan");
					if(Integer.parseInt(colspan) == 9){
						semester = getPeriod(td.text());
						data.put(semester, "");
						System.out.println(semester);
					}
				}else{
					if(data.get(semester).length() == 0){
						data.put(semester, td.text());
					}else{
						data.put(semester, data.get(semester) + "," + td.text());
					}
				}
				
			}
			
		}
		for(String key : data.keySet()){
			System.out.println("key " + key + "Value" + data.get(key));
		}
	}
	
	public void save(){
		this.storage.save(data);
	}
	
	private String getPeriod(String text){
		String period = text.substring(9);
		return period;
	}

}
