package com.zerofiltre.parkingbot.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zerofiltre.parkingbot.model.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class ParkingServiceTest {

  public static final String REGISTRATION_NUMBER = "AZ-458-56";
  private static final String CAR_REGISTRATION_NUMBER = "FJ-IROE-45";
  private static final String BICYCLE_REGISTRATION_NUMBER = "KD-JFI-45";

  ParkingService parkingService = new ParkingService();


  @Test
  void givenAVehicle_processIncomingVehicle_generatesTicketWithRightTime() {
    //given : Soit un véhicule a l'entrée du parking avec une plaque d'immatriculation X
    Vehicle vehicle = new Vehicle();
    vehicle.setRegistrationNumber(REGISTRATION_NUMBER);
    Date now = new Date();

    //when : Enregistrer le véhicule
    Ticket ticket = parkingService.processIncomingVehicle(vehicle);

    //then:
    //génère un ticket,
    assertThat(ticket).isNotNull();

    //associé au véhicule de plaque x,
    Vehicle registeredVehicle = ticket.getVehicle();
    assertThat(registeredVehicle).isNotNull();
    String registeredRegistrationNumber = registeredVehicle.getRegistrationNumber();
    assertThat(registeredRegistrationNumber).isEqualTo(REGISTRATION_NUMBER);

    //avec comme date d'entrée la date actuelle à 30 secondes près
    Date date = ticket.getEnteringTime();
    assertThat(date).isNotNull();
    Date nowPlus30Seconds = new Date(now.getTime() + 30 * 1000);
    assertThat(date).isBeforeOrEqualTo(nowPlus30Seconds);
  }

  // Soit un véhicule enregistré dans le parking

  // faire sortir ce véhicule

  // engendre la définition d'une heure de sortie > l'heure d'entrée
  // et d'un prix

  @Test
  void givenARegisterdVehicle_processExitingVehicle_generatesTicketWithHourAndPrice(){

    // Soit un véhicule à l'entrée du parking avec une plaque d'immatriculation
    Vehicle vehicle = new Vehicle();
    vehicle.setRegistrationNumber(REGISTRATION_NUMBER);
    Ticket ticket = new Ticket();
    ticket.setVehicle(vehicle);
    Date now = new Date();
    long nowMinus1Hour = now.getTime() - 60 * 60 * 1000;
    Date enteringTime = new Date(nowMinus1Hour);
    ticket.setEnteringTime(enteringTime);



    // when
    Ticket exitTicket = parkingService.processExitingVehicle(ticket);

    // then
    assertThat(exitTicket).isNotNull();
    Date exitTime = exitTicket.getExitTime();
    assertThat(exitTime).isNotNull();
    assertThat(exitTime).isAfter(ticket.getEnteringTime());
    assertThat(exitTicket.getAmount()).isNotEqualTo(0);

  }

  // Soit un véhicule, enregistré dans le parking

  // faire sortir ce véhicule

  // engendre la définition du prix approprié selon les règles suivantes :
  // 0.08 € /min pour une CITADINE
  // 0.02 € /min pour un BICYCLE (2 ROUES)
  // 0.05 € /min pour un type inconnu (choix par défaut)

  @Test
  void givenARegisteredVehicle_processExitingVehicle_generatesTheRightPrice(){
    // Given: Soit un véhicule à l'entrée du parking avec une plaque d'immatriculation
    Vehicle vehicle = new Vehicle();
    vehicle.setRegistrationNumber(REGISTRATION_NUMBER);
    Ticket ticket = new Ticket();
    ticket.setVehicle(vehicle);

    Vehicle car = new Car();
    car.setRegistrationNumber(CAR_REGISTRATION_NUMBER);

    Vehicle bicycle = new Bicycle();
    bicycle.setRegistrationNumber(BICYCLE_REGISTRATION_NUMBER);

    Ticket carTicket = new Ticket();
    carTicket.setVehicle(car);

    Ticket bicycleTicket = new Ticket();
    bicycleTicket.setVehicle(bicycle);


    Date now = new Date();
    long nowMinus1Hour = now.getTime() - 60 * 60 * 1000;
    Date enteringTime = new Date(nowMinus1Hour);

    ticket.setEnteringTime(enteringTime);
    carTicket.setEnteringTime(enteringTime);
    bicycleTicket.setEnteringTime(enteringTime);

    // then
    Ticket exitVehicleTicket = parkingService.processExitingVehicle(ticket);
    Ticket exitCarTicket = parkingService.processExitingVehicle(carTicket);
    Ticket exitBicycleTicket = parkingService.processExitingVehicle(bicycleTicket);

    // then
    assertThat(exitVehicleTicket).isNotNull();
    assertThat(exitCarTicket).isNotNull();
    assertThat(exitBicycleTicket).isNotNull();


    assertThat(exitVehicleTicket.getAmount()).isEqualTo(3);
    assertThat(exitCarTicket.getAmount()).isEqualTo(4.8);
    assertThat(exitBicycleTicket.getAmount()).isEqualTo(1.2);

  }



}
