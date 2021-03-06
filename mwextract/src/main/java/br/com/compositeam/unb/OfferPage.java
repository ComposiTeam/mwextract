package br.com.compositeam.unb;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.compositeam.unb.storage.OfferStorage;
import br.com.compositeam.unb.storage.file.OfferStorageFile;



public class OfferPage extends UnbPage {
	
	protected static final Logger logger = Logger.getLogger(OfferPage.class.getName());
	
	private String url_part  = "https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_dis.aspx?cod=";
	
	private Map<String,String> data;
	
	private OfferStorage storage;
	
	public OfferPage(String cod, OfferStorage storage){
		url_part += cod;
		logger.info(url_part);
		setUrl(url_part);
		data = new HashMap<String, String>();
		this.storage = storage;
	}
	
	public OfferPage(String cod){
		this(cod, new OfferStorageFile());
	}
	
	

	public void extractData(){
		Document doc = this.getDocument();
		Elements table = doc.select("table ~ table").eq(2).select("table").eq(2);
		Elements lines = table.select("tr");
		for(int i = 1; i < lines.size(); i++){
			Element td = lines.get(i).child(0);
			System.out.println(td.text());
			Element td1 = lines.get(i).child(1);
			System.out.println(td1.text());
			data.put(td.text(), td1.text());
		}
	}



	@Override
	public void save() {
		this.storage.save(data);
	}
	
	

}
