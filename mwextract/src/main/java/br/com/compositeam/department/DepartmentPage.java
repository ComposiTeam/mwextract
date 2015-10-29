package br.com.compositeam.department;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.compositeam.businessmodel.model.Discipline;

public class DepartmentPage {
	
	private static String URL = "https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_dis.aspx?cod=";
	
	private String cod;
	
	private SaveDiscipline saveDiscipline;
	
	public DepartmentPage(String cod,SaveDiscipline saveDiscipline){
		setCod(cod);
		setSaveDiscipline(saveDiscipline);
	}
	
	private void setSaveDiscipline(SaveDiscipline saveDiscipline){
		if(saveDiscipline == null){
			throw new NullPointerException("Save disiciple cannot be Null");
		}
		this.saveDiscipline = saveDiscipline;
	}
	
	public void setCod(String cod){
		if(cod == null){
			throw new NullPointerException("It cannot be Null");
		}
		this.cod = cod;
	}

	private String getURL(){
		if(cod != null){
			return URL + cod;
		}
		throw new NullPointerException("It is need a cod to get the departament page");
	}
	
	private Elements linesOfTable(Document doc){
		Elements center = doc.getElementsByTag("center");
		Elements table = center.select("table.FrameCinza");
		Elements trs = table.select("tr");
		return trs;
	}
	
	private Document getDocument(){
		Document doc = null;
		try {
			doc = Jsoup.connect(getURL()).validateTLSCertificates(false).get();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return doc;
	}
	public void getDisciplines(){
		Document doc = getDocument();
		Elements lines = linesOfTable(doc);
		for(int i = 1; i < lines.size(); i++){
			String disciplineText = getDiscipline(lines.get(i));
			saveDiscipline.save(disciplineText);
		}
		
	}
	
	private String getDiscipline(Element tr){
		String discipline = "";
		Element td = tr.after("td");
		discipline += td.text();
		return discipline;
	}
	

}
