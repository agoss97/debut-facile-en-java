package com.zerofiltre.parkingbot.model.service;

import com.zerofiltre.parkingbot.model.Ticket;
import com.zerofiltre.parkingbot.model.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkingServiceTest {
    public static final String REGISTRATION_NUMBER = "AZ-OIS-8888";
    private ParkingService parkingService = new ParkingService();

    // soit un véhicule à l'entrée du parking avec une plaque
    // d'immatriculation x

    // Enregistrer ce vehicule

    // génère un ticket
    // associé au véhicule de plaque x
    // avec comme date d'entrée la date actuelle à 30 secondes près

    @Test
    void givenAVehicle_processTncommingVehicle_generatesTicketWithRightTime() {

        // given
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(REGISTRATION_NUMBER);
        Date now = new Date();

        // when
        Ticket ticket = parkingService.processIncommingVehicle(vehicle);

        // then
        assertThat(ticket).isNotNull();
        Vehicle registeredVehicle = ticket.getVehicle();
        assertThat(registeredVehicle).isNotNull();
        String registeredRegistrationNumber = registeredVehicle.getRegistrationNumber();
        assertThat(registeredRegistrationNumber).isEqualTo(REGISTRATION_NUMBER);

        Date date = ticket.getEnteringTime();
        assertThat(date).isNotNull();
        Date nowPlus30Seconds = new Date(now.getTime() + 30 * 1000);
        assertThat(date).isBeforeOrEqualTo(nowPlus30Seconds);

    }
}
