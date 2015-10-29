package br.com.compositeam.unb;

import java.util.Map;

import org.junit.Test;

import br.com.compositeam.unb.storage.CampusStorage;

public class DepartamentPageTest {
	
	@Test
	public void getAll(){
		DepartamentPage depart = new DepartamentPage("4");
		depart.getData();
	}

}
