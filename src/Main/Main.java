package Main;

import com.mashape.unirest.http.exceptions.UnirestException;

import Entities.Rueckgabe;
import Exception.WebAppException;
import Resource.RueckgabeResource;

public class Main {
	
	public static void main(String[] args) throws UnirestException, WebAppException {
		RueckgabeResource rueckgabeResource = new RueckgabeResource();
		Rueckgabe rueckgabe = rueckgabeResource.findById(1400);
		System.out.println(rueckgabe.getKommentar());
		
		Rueckgabe[] rueckgaben = rueckgabeResource.findAll();
		for(Rueckgabe r : rueckgaben) {
			System.out.println(r.getKommentar());
		}
	}

	public static void mediaFindAll() throws UnirestException, WebAppException{
		// Alle Medias vom Server abrufen und anzeigen
		System.out.println("================");
		System.out.println("Alle Medien");
		System.out.println("================");
		System.out.println();

		RueckgabeResource rueckgabeResource = new RueckgabeResource();

		try{
			Rueckgabe[] rueckgaben = rueckgabeResource.findAll();

			if (rueckgaben != null) {
				for (Rueckgabe rueckgabe : rueckgaben) {
					System.out.println(rueckgabe.getId());
					System.out.println(rueckgabe.getKommentar());
				}
			}
		}
		catch(NullPointerException nle){
			System.out.println("Nix gefunden!!!");  

			System.out.println();
		}
		catch(WebAppException e){
			System.err.println("Es ist eine WebAppException "
					+ "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
					+ "\n\n");
		}
	}

}
