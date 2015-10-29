package br.com.compositeam.unb;

import org.junit.Test;

import br.com.compositeam.unb.storage.file.OfferStorageFile;

public class OfferPageTest {
	
	@Test
	public void test(){
		OfferPage offer = new OfferPage("650");
		offer.extractData();
	}
	
	@Test 
	public void output(){
		OfferPage offer = new OfferPage("650", new OfferStorageFile());
		offer.extractData();
		offer.save();
	}

}
