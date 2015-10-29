package br.com.compositeam.unb;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.compositeam.storage.CampusStorage;

public class CampusPage extends UnbPage {

	private CampusStorage storage;
	
	private Map<String,String> data;
	
	public CampusPage(CampusStorage storage){
		super("https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_campus.aspx");
		this.storage = storage;
		data = new HashMap<String, String>();
	}
	public CampusPage() {
		this(null);
	}
	
	public void getData(){
		Elements table = getTableMiddle();
		Elements lines = table.select("tr");
		for(int i = 1; i < lines.size(); i++){
			Element td = lines.get(i).child(1);
			Elements link = td.select("a");
			String href = link.attr("href");
			String code = getCodeFromLink(href);
			data.put(code, td.text());
		}
	}
	
	public void printData(){
		for(String key : data.keySet()){
			System.out.println("Key: " + key + " Value " + data.get(key));
		}
	}
	
	
	
	private String getCodeFromLink(String link){
		String code = link.substring(20);
		return code;
	}
	
	public void save(){
		this.storage.saveCampus(data);
	}
	
	

}
