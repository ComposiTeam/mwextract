package br.com.compositeam.unb;

import org.junit.Test;

public class CoursePageTest {

	@Test
	public void get(){
		String code = "132012";
		String dep = "405";
		CoursePage cp = new CoursePage(code, dep);
		cp.extractData();
		cp.save();
	}
	
	@Test
	public void getDisciplineFromFGA(){
		String code = "113042";
		String dep = "650";
		CoursePage cp = new CoursePage(code, dep);
		cp.extractData();
		cp.save();
	}
}
