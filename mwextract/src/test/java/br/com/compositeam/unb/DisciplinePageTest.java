package br.com.compositeam.unb;

import org.junit.Test;

public class DisciplinePageTest {
	
	@Test
	public void test(){
		DisciplinePage dis = new DisciplinePage("208175");
		dis.extractData();
		for(String key: dis.getData().keySet()){
			System.out.println("Key: " + key + " Value " + dis.getData().get(key));
		}
	}
	
	@Test
	public void output(){
		DisciplinePage dis = new DisciplinePage("208175");
		dis.extractData();
		dis.save();
	}

}
