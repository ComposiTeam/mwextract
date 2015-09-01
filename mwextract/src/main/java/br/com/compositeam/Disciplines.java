package br.com.compositeam;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Disciplines {
	
	private String url = "https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_dis.aspx?cod=650";
	
	public Disciplines(){
		
	}
	
	public void getAll(){
		Document doc;
		try {
			doc = Jsoup.connect(url).validateTLSCertificates(false).get();
			String title = doc.title();
			System.out.println(title);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
