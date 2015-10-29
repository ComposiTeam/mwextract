package br.com.compositeam.unb;

import org.junit.Test;

import br.com.compositeam.unb.UnbPage;

public class UnbPageTest {
	
	@Test
	public void testTabelaMeio(){
		UnbPage unb = new UnbPage("https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_campus.aspx");
		unb.getCenter();
		
	}
	
	@Test
	public void testTabelaMiddle(){
		UnbPage unb = new UnbPage("https://matriculaweb.unb.br/matriculaweb/graduacao/oferta_campus.aspx");
		unb.getTableMiddle();
		
	}
	
	

}
