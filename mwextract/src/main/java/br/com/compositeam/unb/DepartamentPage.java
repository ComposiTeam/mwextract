package br.com.compositeam.unb;

import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DepartamentPage extends UnbPage {
	
	private String url_part = "https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_dep.aspx?cod=";

	private Map<String,String> data;
	
	public DepartamentPage(String code){
		url_part += code;
		System.out.println(url_part);
		setUrl(url_part);
	}
	
	
	public void getData(){
		Elements table = getTableMiddle();
		Elements lines = table.select("tr");
		for(int i = 1; i < lines.size(); i++){
			Element td = lines.get(i).child(2);
			System.out.println(td.text());
		}
	}
}
