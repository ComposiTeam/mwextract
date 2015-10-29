package br.com.compositeam.unb.storage.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class OutputFile {
	
	PrintWriter writer;
	
	public OutputFile(String file){
		try {
			this.writer = new PrintWriter(file, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String text){
		writer.println(text);
	}
	
	public void close(){
		this.writer.close();
	}
}
