package br.com.compositeam;
import java.util.logging.Logger;

import br.com.compositeam.model.Discipline;


public class FacadeDiscipline {
	
	private final static Logger LOG = Logger.getLogger(FacadeDiscipline.class.getName());
	
	private Discipline discipline;
	
	public Discipline getDiscipline(){
		Discipline d = new Discipline(" ","");
		return d;
	}
	
	public static Discipline getDiscipline(String discipline){
		Discipline d = null;
		String[] text = discipline.split(" ", 2);
		LOG.info("text: " + text.length);
		if(text.length == 2){
			String cod = text[0];
			LOG.info("Code find in the line: " + cod);
			String name = text[1];
			LOG.info("Name find in the line: " + name);
			d = new Discipline(cod, name);
		}else{
			d = new Discipline(" ", " ");
		}
		return d;
	}

}
