package br.com.compositeam.unb;

import org.junit.Test;

import br.com.compositeam.unb.storage.file.CampusStorageFile;

public class CampusPageTest {
	
	@Test
	public void lines(){
		CampusPage campus = new CampusPage();
		campus.extractData();
		campus.printData();
	}
	
	@Test
	public void output(){
		CampusPage campus = new CampusPage(new CampusStorageFile());
		campus.extractData();
		campus.save();
	}

}
