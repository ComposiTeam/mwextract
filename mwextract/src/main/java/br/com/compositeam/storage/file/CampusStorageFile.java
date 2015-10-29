package br.com.compositeam.storage.file;

import java.util.Map;

import br.com.compositeam.storage.CampusStorage;

public class CampusStorageFile extends OutputFile  implements CampusStorage{

	public CampusStorageFile(){
		super("campus.txt");
	}
	public void saveCampus(Map<String, String> data) {
		for(String key: data.keySet()){
			write(key + " " + data.get(key));
		}
		this.close();
	}

	

	
	

}
