package br.com.compositeam.unb.storage.file;

import java.util.Map;

import br.com.compositeam.unb.storage.CourseStorage;

public class CourseStorageFile extends OutputFile implements CourseStorage {
	
	public CourseStorageFile() {
		super("course.txt");
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
