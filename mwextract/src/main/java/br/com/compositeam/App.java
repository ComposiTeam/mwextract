package br.com.compositeam;

import java.util.List;

import br.com.compositeam.department.DepartmentPage;
import br.com.compositeam.department.TextSave;
import br.com.compositeam.businessmodel.model.Discipline;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	TextSave textSave = new TextSave();
    	String[] codes = {"650","383"};
    	for(String cod : codes){
	    	DepartmentPage department = new DepartmentPage(cod, textSave);
	    	department.getDisciplines();
    	}
        
    }
}
