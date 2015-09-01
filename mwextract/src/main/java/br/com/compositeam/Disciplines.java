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
			Element form = doc.getElementById("FormPesquisa");
			Element table = form.after("table");
			System.out.println(table);
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

}
