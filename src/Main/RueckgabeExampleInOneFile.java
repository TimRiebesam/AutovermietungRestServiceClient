package Main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import Entities.Rueckgabe;
import Exception.ExceptionResponse;
import Exception.WebAppException;

public class RueckgabeExampleInOneFile {
	
	public static void getRueckgabe() throws Exception{
		
		Gson gson = new GsonBuilder().create();
		
        HttpResponse<String> httpResponse = Unirest.get("http://localhost:8080/upp/api/Rueckgabe/1600")
                .header("accept", "application/json")
                .basicAuth("tim123", "123456")
                .asString();
        
        try {
            ExceptionResponse er = gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);

            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
        	
        }

        Rueckgabe rueckgabe = gson.fromJson(httpResponse.getBody(), Rueckgabe.class);
		
        System.out.println(rueckgabe);
	}
	
}
