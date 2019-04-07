package Entities;

import java.io.Serializable;
import java.util.Date;

public class Buchung implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

    private Object user;
    private Object auto;
    private Date startDatum;
    private Date endDatum;  
    private double buchungPreis;
    private String buchungAbholort;

	// Konstruktoren
	public Buchung() {

	}

public Buchung(Object auto, Object user, Date startDatum, Date endDatum, double buchungPreis, String buchungAbholort){
        this.startDatum = new Date();
        this.endDatum = new Date();
        this.buchungPreis = buchungPreis;
        this.buchungAbholort = buchungAbholort;
        this.auto = auto;
        this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public Object getAuto() {
        return auto;
    }

    public void setAuto(Object auto) {
        this.auto = auto;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public Date getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(Date endDatum) {
        this.endDatum = endDatum;
    }

    public double getBuchungPreis() {
        return buchungPreis;
    }

    public void setBuchungPreis(double buchungPreis) {
        this.buchungPreis = buchungPreis;
    }

    public String getBuchungAbholort() {
        return buchungAbholort;
    }

    public void setBuchungAbholort(String buchungAbholort) {
        this.buchungAbholort = buchungAbholort;
    }

	
	
@Override
    public String toString() {
    	return "Id: " + id + "\n" +
                        "Kunde: " + user + "\n" + 
                        "Fahrzeug: " + auto + "\n" + 
    			"Rückgabedatum: " + startDatum + "\n" + 
    			"Rückgabeort: " + endDatum + "\n" + 
    			"Preis: " + buchungPreis + "\n" + 
    			"Abholort: " + buchungAbholort + "\n";
    }

}// end of class
