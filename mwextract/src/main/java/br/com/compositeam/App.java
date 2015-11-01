package br.com.compositeam;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import br.com.compositeam.unb.TranscriptPage;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	TranscriptPage t = new TranscriptPage("11/0030559", "japz1217");
    	t.extractData();
    	t.save();
    	
//    	try {
//			Connection.Response loginForm = Jsoup.connect("https://wwwsec.serverweb.unb.br/matriculaweb/graduacao/sec/login.aspx")
//					.validateTLSCertificates(false)
//			        .method(Connection.Method.GET)
//			        .execute();
//			for(String key: loginForm.cookies().keySet()){
//				System.out.println("Key: " + key + " Value " + loginForm.cookies().get(key));
//			}
//			System.out.println("------------------------------------------------------------------");
//			Connection.Response logined = Jsoup.connect("https://wwwsec.serverweb.unb.br/matriculaweb/graduacao/sec/login.aspx")
//					.validateTLSCertificates(false)
//					.method(Connection.Method.POST)
//			        .data("inputMatricula", "11/0030559")
//			        .data("inputSenha", "japz1217")
//			        .data("login:_ctl0", "++++Enviar++++")
//			        .cookies(loginForm.cookies())
//			        .execute();
//			System.out.println(logined.body());
//			System.out.println("-------------------------------------------------------------------------");
//			for(String key: loginForm.cookies().keySet()){
//				logined.cookie(key, loginForm.cookies().get(key));
//			}
//			
//			for(String key: logined.cookies().keySet()){
//				System.out.println("Key: " + key + " Value " + logined.cookies().get(key));
//			}
//			System.out.println("------------------------------------------------------------------");
//			Document document = Jsoup.connect("https://wwwsec.serverweb.unb.br/matriculaweb/graduacao/sec/he.aspx")
//					.validateTLSCertificates(false)
//			        .data("inputMatricula", "11/0030559")
//			        .data("inputSenha", "japz1217")
//			        .cookies(logined.cookies())
//			        .post();
//			
//			System.out.println(document.html());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
    }
}
