package com.zerofiltre.parkingbot;

import com.zerofiltre.parkingbot.model.Facture;
import com.zerofiltre.parkingbot.model.Personne;
import com.zerofiltre.parkingbot.model.Ticket;
import com.zerofiltre.parkingbot.model.Vehicle;
import com.zerofiltre.parkingbot.service.FactureService;
import com.zerofiltre.parkingbot.service.ParkingService;

public class ParkingBot {


  /**
   * Ceci est la méthode Main
   *
   * @param args : Tableau de données entrées lors du lancement de l'application
   */
  public static void main(String[] args) {

    Ticket ticket = getTicket();

    Facture facture = getFacture();

    System.out.println(ticket);
    System.out.println(facture);
  }

  private static Facture getFacture() {
    Personne personne = new Personne();
    personne.setName("Cyr");
    personne.setAge(28);

    FactureService factureService = new FactureService();
    Facture facture = factureService.personneCommandFacture(personne);
    return facture;
  }

  private static Ticket getTicket() {
    Vehicle vehicle = new Vehicle();
    vehicle.setCategory("CITADINE");
    vehicle.setRegistrationNumber("LS-324-PM");

    ParkingService parkingService = new ParkingService();
    Ticket ticket = parkingService.processIncomingVehicle(vehicle);
    return ticket;
  }


}
