package Entities;

/**
 *
 * @author rapht
 */
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password1;
    private String password2;

    private String vorname;
    private String nachname;
    private String email;
    private String tel;
    private String strasse;
    private String plz;
    private String ort;

public User(){

}
public User (String username, String password1,
    String vorname, String nachname, String email,
    String tel, String strasse, String plz, String ort){
    this.username = username;
    this.password1 = password1;
    this.vorname = vorname;
    this.nachname = nachname;
    this.email = email;
    this.tel = tel;
    this.strasse = strasse;
    this.plz = plz;
    this.ort = ort;
}

@Override
public String toString(){
return "username" + username + "\n" +
                        "password1" + password1 + "\n" +
                        "vorname: " + vorname + "\n" + 
    			"nachname: " + nachname + "\n" + 
    			"email: " + email + "\n" + 
    			"tel: " + tel + "\n" + 
    			"strasse: " + strasse + "\n" +
    			"plz: " + plz + "\n" +
                        "ort: " + ort;
}

public String getUsername(){
    return username;
}
public String getPassword1(){
    return password1;
}
public void setPassword1(String password1){
    this.password1 = password1;
}
public String getVorname(){
    return vorname;
}
public void setVorname(String vorname){
    this.vorname = vorname;
}
public String getNachname(){
    return nachname;
}
public void setNachname(String nachname){
    this.nachname = nachname;
}
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}
public String getTel(){
    return tel;
}
public void setTel(){
    this.tel = tel;
}
public String getStrasse(){
    return strasse;
}
public void setStrasse(String strasse){
    this.strasse = strasse;
}
public String getPlz(){
    return plz;
}
public void setPlz(String plz){
    this.plz = plz;
}
public String getOrt(){
    return ort;
}
public void setOrt(String ort){
    this.ort = ort;
}
}