package br.com.compositeam.unb.storage.file;

import java.util.Map;

import br.com.compositeam.unb.storage.DepartamentStorage;

public class DepartamentStorageFile extends OutputFile implements DepartamentStorage {

	public DepartamentStorageFile() {
		super("departament");
	}

	@Override
	public void saveDepartament(Map<String, String> data) {
		for(String key: data.keySet()){
			write(key + " " + data.get(key));
		}
		this.close();
	}

}
