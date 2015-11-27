package br.com.compositeam.unb;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.compositeam.unb.storage.DepartamentStorage;
import br.com.compositeam.unb.storage.file.DepartamentStorageFile;

public class DepartamentPage extends UnbPage {
	
	private String url_part = "https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_dep.aspx?cod=";

	private Map<String,String> data;
	
	private DepartamentStorage storage;
	
	public DepartamentPage(String code,DepartamentStorage storage){
		url_part += code;
		System.out.println(url_part);
		setUrl(url_part);
		this.storage = storage;
		data = new HashMap<String, String>();
		
	}
	public DepartamentPage(String code){
		this(code,new DepartamentStorageFile());
	}
	
	
	public void getData(){
		Elements table = getTableMiddle();
		Elements lines = table.select("tr");
		for(int i = 1; i < lines.size(); i++){
			Element td2 = lines.get(i).child(0);
			Element td1 = lines.get(i).child(1);
			Element td = lines.get(i).child(2);
			System.out.println(td2.text());
			System.out.println(td1.text());
			System.out.println(td.text());
			data.put(td2.text(), td1.text() + "," + td.text());
		}
	}
	
	public void save(){
		this.storage.saveDepartament(data);
	}
}
