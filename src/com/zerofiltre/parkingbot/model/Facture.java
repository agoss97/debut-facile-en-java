package com.zerofiltre.parkingbot.model;

import java.util.Date;

public class Facture {
    private String clientNumber;
    private Personne personne;
    private Date dateOrder;

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "clientNumber='" + clientNumber + '\'' +
                ", personne=" + personne +
                ", dateOrder='" + dateOrder + '\'' +
                '}';
    }
}
