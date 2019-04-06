package Main;

import com.mashape.unirest.http.exceptions.UnirestException;

import Entities.Rueckgabe;
import Exception.WebAppException;
import Resource.RueckgabeResource;

public class Main {
	
	public static void main(String[] args) throws UnirestException, WebAppException {
		
		//Return eine Rückgabe
		RueckgabeResource rueckgabeResource = new RueckgabeResource();
		Rueckgabe rueckgabe = rueckgabeResource.findById(1600);
		System.out.println(rueckgabe);
		
		//Return alle Rückgaben
		System.out.println(findAllRueckgabe());
	}

	public static String findAllRueckgabe() throws UnirestException, WebAppException{
		RueckgabeResource rueckgabeResource = new RueckgabeResource();
		String rueckgabenAsString = "";
		
		try{
			Rueckgabe[] rueckgaben = rueckgabeResource.findAll();

			if (rueckgaben != null) {
				for (Rueckgabe rueckgabe : rueckgaben) {
					rueckgabenAsString = rueckgabenAsString + "\n" + rueckgabe.toString();
				}
			}
		}
		catch(NullPointerException nle){
			return "Kein Ergebnis gefunden!";  
		}
		catch(WebAppException e){
			System.err.println("Es ist eine WebAppException "
					+ "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
					+ "\n\n");
		}
		return rueckgabenAsString;
	}

}
