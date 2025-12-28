package com.zerofiltre.parkingbot;

public class ParkingBot {

    /**
     * Ceci est la fonction principale d'un programme JAVA
     * @param args Représente les données passées en paramètre lors du lancement du programme
     */
    public static void main(String[] args) {
        sayHello(args[0]);
    }

    /**
     * Permet d'accueillir et de présenter les services à l'utilisateur potentiel du parking
     * @param arg Représente le nom de l'utilisateur potentiel
     */
    private static void sayHello(String arg) {
        String welcomeMessage = "Hello " + arg + ", bienvenue dans mon Parking Java";
        String services = "Nous offrons les services suivants : Gardinages, Laverie, ...";
        String warning = "Dépéchez-vous, il n'y aura bientôt plus de place";
        System.out.println(welcomeMessage);
        System.out.println(services);
        System.out.println(warning.toUpperCase());
    }
}
