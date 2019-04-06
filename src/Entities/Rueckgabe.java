package Entities;

import java.io.Serializable;

public class Rueckgabe implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
    
    private Object buchung;
    
    private String schadensMeldung;
    
    private String rueckgabeDatum; 
    
    private String rueckgabeOrt;
    
    private int gesamtZufriedenheit;
    
    private int fahrzeugZufriedenheit;
    
    private String kommentar;
    
    public Rueckgabe(){
        
    }
    
    public Rueckgabe(Object buchung, String schadensMeldung, String rueckgabeOrt, int gesamtZufriedenheit, int fahrzeugZufriedenheit, String kommentar, String rueckgabeDatum){
        this.schadensMeldung = schadensMeldung;
        this.rueckgabeDatum = rueckgabeDatum;
        this.rueckgabeOrt = rueckgabeOrt;
        this.gesamtZufriedenheit = gesamtZufriedenheit;
        this.fahrzeugZufriedenheit = fahrzeugZufriedenheit;
        this.kommentar = kommentar;
        this.buchung = buchung;
    }

    public long getId() {
        return id;
    }
    
    public Object getBuchung(){
        return buchung;
    }
    
    public void setBuchung(Object buchung){
        this.buchung = buchung;
    }

    public String getSchadensMeldung() {
        return schadensMeldung;
    }

    public void setSchadensMeldung(String schadensMeldung) {
        this.schadensMeldung = schadensMeldung;
    }

    public String getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(String rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public String getRueckgabeOrt() {
        return rueckgabeOrt;
    }

    public void setRueckgabeOrt(String rueckgabeOrt) {
        this.rueckgabeOrt = rueckgabeOrt;
    }

    public int getGesamtZufriedenheit() {
        return gesamtZufriedenheit;
    }

    public void setGesamtZufriedenheit(int gesamtZufriedenheit) {
        this.gesamtZufriedenheit = gesamtZufriedenheit;
    }

    public int getFahrzeugZufriedenheit() {
        return fahrzeugZufriedenheit;
    }

    public void setFahrzeugZufriedenheit(int fahrzeugZufriedenheit) {
        this.fahrzeugZufriedenheit = fahrzeugZufriedenheit;
    }
    
    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
