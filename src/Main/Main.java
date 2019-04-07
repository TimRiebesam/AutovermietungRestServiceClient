package Main;

import com.mashape.unirest.http.exceptions.UnirestException;

import Entities.Auto;
import Entities.Rueckgabe;
import Entities.Buchung;
import Exception.WebAppException;
import Resource.AutoResource;
import Resource.BuchungResource;
import Resource.RueckgabeResource;


public class Main {

	public static void main(String[] args) throws UnirestException, WebAppException {

		//Zum Testen müssen übergebene Parameter entsprechend angepasst werden

		//Return eine Rückgabe
		RueckgabeResource rueckgabeResource = new RueckgabeResource();
		Rueckgabe rueckgabe = rueckgabeResource.findById(1);
		System.out.println(rueckgabe);


		//Ein Auto zurückgeben zum Testen
		AutoResource autoResource = new AutoResource();
		 Auto auto = autoResource.findById(2);
		System.out.println(auto.toString());


        //Eine Buchunge zurückgeben
        BuchungResource buchungResource = new BuchungResource();
        Buchung buchung = buchungResource.findById(3);
        System.out.println(buchung);


	}

}
