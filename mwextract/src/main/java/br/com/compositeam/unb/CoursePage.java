package br.com.compositeam.unb;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.compositeam.unb.storage.CourseStorage;
import br.com.compositeam.unb.storage.file.CourseStorageFile;

public class CoursePage extends UnbPage {
	
	Map<String,String> data; 
	CourseStorage storage;
	

	protected static final Logger logger = Logger.getLogger(OfferPage.class.getName());
	
	private String url_part  = "https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_dados.aspx?cod=";
	private String url_final = "&dep=";
	
	public CoursePage(String code, String dep,CourseStorage storage ){
		url_part += code + url_final + dep;
		System.out.println("URL " +url_part);
		setUrl(url_part);
		data = new HashMap<String, String>();
		this.storage = storage;
	}
	
	public CoursePage(String code, String dep){
		this(code,dep,new CourseStorageFile());
	}
	
	public void extractData(){
		Document doc = getDocument();
		Elements table = doc.select("table").eq(7);
		Elements trs = table.select("tr[bgcolor^=#FFFFFF]");
		for(int j = 0; j < trs.size(); j++){
//			System.out.println("-----------------------------INICIO " + j + "----------------------------");
//			System.out.println(trs.get(j).html());
//			System.out.println("------------------------------FIM------------------------------");
			Elements tds = trs.get(j).select("td");
			String course = "";
			for(int i = 0; i < tds.size(); i++){
				Element td = tds.get(i);
//				System.out.println("I:" + i + td.html());
				if(i == 0){
					System.out.println("Name of class " + getNameClass(td));
					course = getNameClass(td);
					data.put(course, "");
				}
				if(i == 1){
					System.out.println("Numeber of Vagas " + getNumberOfVagas(td));
					System.out.println("Ocupadas " + getNumberOfVagasOcupadas(td));
					System.out.println("Restantes " + getNumberOfVagasRestantes(td));
					String tudo = data.get(course);
					tudo += getNumberOfVagas(td) + "," + getNumberOfVagasOcupadas(td) + ","+ getNumberOfVagasRestantes(td); 
					data.put(course, tudo);
				}
				if(i == 21 || i == 12){
					String tudo = data.get(course);
					String horarios = getHorarios(td);
					if(horarios != null){
						tudo += "," + horarios;
						data.put(course, tudo);
					}
				}
				if(i == 27 || i == 36){
					String professor = getProfessor(td);
					System.out.println("Professor: " + professor);
					if(professor != null ){
						String tudo = data.get(course);
						tudo += professor;
						data.put(course, tudo);
					}
				}
			}
		}
//		for(String cl : data.keySet()){
//			System.out.println(cl + " " + data.get(cl));
//		}
	}
	
	public void save(){
		storage.save(data);
	}
	
	private String getProfessor(Element html) {
		String professor = html.text();
		if(professor.contains("SEX")){
			return null;
		}
		return professor;
	}

	private String getNameClass(Element el){
		Elements font = el.select("font").eq(0);
		return font.text();
	}
	
	private String getNumberOfVagas(Element el){
		return el.select("tr:eq(0) > td:eq(2)").text();
	}
	
	private String getNumberOfVagasOcupadas(Element el){
		return el.select("tr:eq(1) > td:eq(2)").text();
	}
	
	private String getNumberOfVagasRestantes(Element el){
		return el.select("tr:eq(2) > td:eq(2)").text();
	}
	
	private String getHorarios(Element el){
		HashMap<String,String> times = new HashMap<String, String>(); 
		Elements divs = el.select("div:gt(0)");
		String day = "";
		for(Element d: divs){
			Elements bs = d.select("b");
			for(int i = 0; i < bs.size();i++){
				Element b = bs.get(i);
				if(i == 0){
					day = b.text();
					times.put(day, " ");
				}else{
					String partText = times.get(day);
					partText += b.text().trim();
					times.put(day, partText);
				}
			}
		}
		if(times.size() == 0){
			return null;
		}
		String result = "" + times.size() + ",";
		for(String test : times.keySet()){
			System.out.println("key: " + test + " " + times.get(test));
			result += test + times.get(test) + ",";
		}
		return result;
	}
}
