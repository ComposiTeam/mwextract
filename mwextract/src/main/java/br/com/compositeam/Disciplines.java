package br.com.compositeam;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Disciplines {
	
	private String url = "https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_dis.aspx?cod=650";
	
	public Disciplines(){
		
	}
	
	public void getAll(){
		Document doc;
		try {
			doc = Jsoup.connect(url).validateTLSCertificates(false).get();
			Elements center = doc.getElementsByTag("center");
			Elements table = center.select("table.FrameCinza");
			Elements trs = table.select("tr");
			for(int i = 1; i < trs.size(); i++){
				System.out.println(getDiscipline(trs.get(i)));
			}
//			System.out.println(trs.get(0));
//			Elements tables = doc.getElementsByTag("table");
//			for(Element element : tables){
//				System.out.println(element.html());
//			}
			String title = doc.title();
			System.out.println(title);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getDiscipline(Element tr){
		String discipline = "";
		Element tdCodigo = tr.after("td");
		discipline += tdCodigo.text();
		return discipline;
	}

}
