package Resource;

import Entities.Buchung;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Entities.Rueckgabe;
import Exception.ExceptionResponse;
import Exception.WebAppException;

public class BuchungResource extends Resource{

	public static final String URL = "http://localhost:8080/upp/api/Buchung";

	public String url = URL;

	Gson gson = new GsonBuilder().create();
	
	public BuchungResource() {
		
	}
	
	public BuchungResource(String url) {
		this.url = url;
	}
	
	public Buchung[] findAll() throws UnirestException, WebAppException {
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(url)
                .header("accept", "application/json")
                .basicAuth(username, password)
                .asString();
        
        System.out.println(httpResponse.getBody());
        
        // Exception werfen, wenn der Server einen Fehler meldet
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);

            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Fehlerdaten empfangen
        }

        // Antwortdaten zurückgeben
        return this.gson.fromJson(httpResponse.getBody(), Buchung[].class);
    }
	
	public Buchung findById(long id) throws UnirestException, WebAppException {
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(this.url+"/"+id)
                .header("accept", "application/json")
                .basicAuth(username, password)
                .asString();
        
        // Exception werfen, wenn der Server einen Fehler meldet
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);

            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Fehlerdaten empfangen
        }

        // Antwortdaten zurückgeben
        return this.gson.fromJson(httpResponse.getBody(), Buchung.class);
    }

}
