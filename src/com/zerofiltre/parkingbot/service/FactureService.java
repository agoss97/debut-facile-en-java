package com.zerofiltre.parkingbot.service;

import com.zerofiltre.parkingbot.model.Facture;
import com.zerofiltre.parkingbot.model.Personne;

import java.util.Date;

public class FactureService {
    public Facture personneCommandFacture(Personne personne){
        Facture facture = new Facture();
        Date now = new Date();
        facture.setPersonne(personne);
        facture.setClientNumber("CO2036");
        facture.setDateOrder(now);

        return facture;
    }
}
