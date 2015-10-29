package br.com.compositeam.unb;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.compositeam.storage.DisciplineStorage;
import br.com.compositeam.storage.file.DisciplineStorageFile;

public class DisciplinePage extends UnbPage {

	private Map<String,String> data;
	private String url_part = "https://matriculaweb.unb.br/matriculaweb/graduacao/disciplina.aspx?cod=";
	private DisciplineStorage storage;
	
	public DisciplinePage(String code, DisciplineStorage storage){
		super();
		url_part += code;
		setUrl(url_part);
		data = new HashMap<String, String>();
		this.storage = storage;
	}
	
	public DisciplinePage(String code){
		this(code,new DisciplineStorageFile());
	}
	
	public void extractData(){
		Elements table = getTableMiddle();
		Elements lines = table.select("tr");
		for(int i = 1; i < lines.size(); i++){
			Element td1 = lines.get(i).child(0);
			Element td = lines.get(i).child(1);
			data.put(remove(td1.text()), td.text());
			System.out.println(td.text());
		}
	}
	
	public Map<String, String> getData(){
		return this.data;
	}
	
	private String remove(String text){
		String t = text.replace(":", "");
		return t;
	}
	
	public void save(){
		this.storage.save(data);
	}
}
