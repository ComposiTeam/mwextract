package br.com.compositeam.storage.file;

import java.util.Map;

import br.com.compositeam.storage.DisciplineStorage;

public class DisciplineStorageFile extends OutputFile implements DisciplineStorage {

	public DisciplineStorageFile() {
		super("discipline.txt");
		// TODO Auto-generated constructor stub
	}

	public void save(Map<String, String> data) {
		// TODO Auto-generated method stub
		for(String key : data.keySet()){
			write(key + ": " + data.get(key));
		}
		this.close();
	}
	
	

}
