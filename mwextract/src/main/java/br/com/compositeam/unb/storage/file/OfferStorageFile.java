package br.com.compositeam.unb.storage.file;

import java.util.Map;

import br.com.compositeam.unb.storage.OfferStorage;

public class OfferStorageFile extends OutputFile implements OfferStorage {

	public OfferStorageFile() {
		super("offer.txt");
		// TODO Auto-generated constructor stub
	}

	public void save(Map<String, String> data) {
		// TODO Auto-generated method stub
		for(String key: data.keySet()){
			write(key + " " + data.get(key));
		}
		this.close();
	}

}
