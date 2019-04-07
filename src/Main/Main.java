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
	
	 public static String findAllBuchungen() throws UnirestException, WebAppException{
			BuchungResource buchungResource = new BuchungResource();
			String buchungenAsString = "";

			try{
				Buchung[] buchungen = buchungResource.findAll();

				if (buchungen != null) {
					for (Buchung buchung : buchungen) {
						buchungenAsString = buchungenAsString + "\n" + buchung.toString();
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
			return buchungenAsString;
		}

		public static String findAllRueckgabe() throws UnirestException, WebAppException{
			RueckgabeResource rueckgabeResource = new RueckgabeResource();
			String rueckgabenAsString = "";

			try{
				Rueckgabe[] rueckgaben = rueckgabeResource.findAll();
	        //Eine Buchunge zurückgeben
	        BuchungResource buchungResource = new BuchungResource();
	        Buchung buchung = buchungResource.findById(3);
	        System.out.println(buchung);

				if (rueckgaben != null) {
					for (Rueckgabe rueckgabe : rueckgaben) {
						rueckgabenAsString = rueckgabenAsString + "\n" + rueckgabe.toString();
					}
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			return rueckgabenAsString;
		}


		public static String findAllAutos() throws UnirestException, WebAppException{
			AutoResource autoResource = new AutoResource();
			String autosAsString = "";

			try{
				Auto[] autos = autoResource.findAll();

				if (autos != null) {
					for (Auto auto : autos) {
						autosAsString = autosAsString + "\n" + auto.toString();
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
			return autosAsString;
		}

}
