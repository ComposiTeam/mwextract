package br.com.compositeam;

import java.util.List;

import br.com.compositeam.department.DepartmentPage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String cod = "650";
    	List disciplines = new DepartmentPage(cod).getDisciplines();
    	for(Object ob: disciplines){
    		System.out.println(ob.toString());
    	}
        System.out.println( "Hello World!" );
        
    }
}
