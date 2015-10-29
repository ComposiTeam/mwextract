package br.com.compositeam.unb;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UnbPage {
	
	private String url;
	
	
	public UnbPage(String url){
		setUrl(url);
	}
	
	protected UnbPage(){
		
	}
	
	protected void setUrl(String url){
		if(url == null){
			throw new NullPointerException();
		}
		this.url = url;
	}
	
	private String getUrl(){
		return this.url;
	}
	
	public Elements getCenter(){
		Document doc = getDocument();
		Elements center = doc.getElementsByTag("center");
		System.out.println(center.html());
		return center;
	}
	
	public Elements getTableMiddle(){
		Document doc = getDocument();
		Elements table = doc.select("table ~ table").eq(2).select("table").eq(1);
		return table;
	}
	
	protected Document getDocument(){
		Document doc = null;
		try {
			doc = Jsoup.connect(getUrl()).validateTLSCertificates(false).get();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return doc;
	}
	
	

}
