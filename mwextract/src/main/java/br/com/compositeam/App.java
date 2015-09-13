package br.com.compositeam;

import java.util.List;

import br.com.compositeam.department.DepartmentPage;
import br.com.compositeam.businessmodel.model.Discipline;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	FacadeDiscipline facede = new FacadeDiscipline();
    	String[] codes = {"650","383"};
    	for(String cod : codes){
	    	List disciplines = new DepartmentPage(cod).getDisciplines();
	    	for(Object ob: disciplines){
	    		System.out.println(ob.toString());
	    		Discipline d = (Discipline)ob;
	    		facede.save(d);
	    	}
    	}
        System.out.println( "Hello World!" );
        
    }
}
