
/**
 *
 * @author rapht
 */
package Resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Entities.User;
import Exception.ExceptionResponse;
import Exception.WebAppException;

public class UserResource extends User{

	public static final String URL = "http://localhost:8080/upp/api/User";

	public String url = URL;

	Gson gson = new GsonBuilder().create();
	
	public UserResource() {
		
	}
	
	public UserResource(String url) {
		this.url = url;
	}
	
	public User[] findAll() throws UnirestException, WebAppException {
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
        return this.gson.fromJson(httpResponse.getBody(), Rueckgabe[].class);
    }
	
	public User findByUsername(String username) throws UnirestException, WebAppException {
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(this.url+"/"+username)
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
        return this.gson.fromJson(httpResponse.getBody(), User.class);
    }

}
