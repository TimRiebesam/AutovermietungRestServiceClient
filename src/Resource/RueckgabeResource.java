package Resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Entities.Rueckgabe;
import Exception.ExceptionResponse;
import Exception.WebAppException;

public class RueckgabeResource extends Resource{

	public static final String URL = "http://localhost:8080/upp/api/Rueckgabe";

	public String url = URL;

	Gson gson = new GsonBuilder().create();
	
	public RueckgabeResource() {
		
	}
	
	public RueckgabeResource(String url) {
		this.url = url;
	}
	
	public Rueckgabe[] findAll() throws UnirestException, WebAppException {
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(this.url)
                .header("accept", "application/json")
                .basicAuth(username, password)
                .asString();
        
        System.out.println(httpResponse.getHeaders());
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
        return this.gson.fromJson(httpResponse.getBody(), Rueckgabe[].class);
    }
	
	public Rueckgabe findById(long id) throws UnirestException, WebAppException {
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
        return this.gson.fromJson(httpResponse.getBody(), Rueckgabe.class);
    }

}
