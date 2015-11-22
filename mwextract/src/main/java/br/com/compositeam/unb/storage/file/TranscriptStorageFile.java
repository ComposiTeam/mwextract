package br.com.compositeam.unb.storage.file;

import java.util.Map;

import br.com.compositeam.unb.storage.TranscriptStorage;

public class TranscriptStorageFile extends OutputFile implements TranscriptStorage {

	public TranscriptStorageFile() {
		super("transcript.txt");
		// TODO Auto-generated constructor stub
	}

	public void storage(Map<String, String> data) {
		// TODO Auto-generated method stub
		for(String key : data.keySet()){
			write(key + " " + data.get(key));
		}
		this.close();
	}
	
	

}
