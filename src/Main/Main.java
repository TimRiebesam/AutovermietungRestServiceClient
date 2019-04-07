package Main;

import com.mashape.unirest.http.exceptions.UnirestException;

import Entities.Rueckgabe;
import Exception.WebAppException;
import Resource.RueckgabeResource;

public class Main {
	
	public static void main(String[] args) throws UnirestException, WebAppException {
		
		//Beispiel: Return einer Rückgabe
//		RueckgabeResource rueckgabeResource = new RueckgabeResource();
//		Rueckgabe rueckgabe = rueckgabeResource.findById(1600);
//		System.out.println(rueckgabe);
		
		try {
			RueckgabeExampleInOneFile.getRueckgabe();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
