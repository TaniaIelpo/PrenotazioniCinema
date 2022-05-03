package it.develhope;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Test of application
 *
 * @author Tania Ielpo
 */

public class Start {

    public static void main(String[] args) {

        //creation of the cinema list
        CinemaList cinemaList = new CinemaList();
        //creation of a cinema
        Cinema cinema1=new Cinema("Iris");
        //creation of a manager
        Menager menager = new Menager("Tania", "Ielpo", "taniaie@tiscali.it");
        //attribution of a menager to the cinema
        cinema1.setMenager(menager);
        //attribution of a cinema to the menager
        menager.setCinema(cinema1);
        //initialization of the cinema list by adding the created cinema
        cinemaList.add(cinema1);
        Scanner in = new Scanner(System.in);

        //management choice menu

        /**
         * the menu allows you to add a new cinema,
         * manage an existing one or exit the application
         */

        int choice = 0;
        do {
            System.out.println("----------------------------------\n" +
                    "[1] Aggiungi un nuovo cinema\n" +
                    "[2] Gestisci un cinema gia presente\n"+
                    "[3] Esci");
            try {
                choice = in.nextInt();
                switch (choice) {
                    case 1:

                        //by creating a new cinema we create a new manager who will manage it
                        System.out.println("Inserisci il nome del cinema:");
                        in.nextLine();
                        String nomeCinema=in.nextLine();

                        System.out.println("CHI GESTIRA' QUESTO CINEMA?");
                        System.out.printf("Nome: ");
                        String nome = in.nextLine();
                        System.out.printf("Cognome: ");
                        String cognome = in.nextLine();
                        System.out.printf("email: ");
                        String email = in.nextLine();

                        menager = new Menager(nome, cognome, email);
                        Cinema cinemaNuovo = new Cinema(nomeCinema);
                        cinemaNuovo.setMenager(menager);
                        cinemaList.add(cinemaNuovo);

                        menager.setCinema(cinemaNuovo);

                        break;
                    case 2:

                        //managing a cinema already present we will open the manager menu
                        // after various checks on the insertion of the input data
                        if (cinemaList.getCinemaList().size() > 0) {
                            System.out.println("----------------------\n" +
                                    "LISTA DEI CINEMA:");
                            for (Cinema cinema : cinemaList.getCinemaList()) {
                                System.out.println(cinema.getId());
                            }
                            System.out.println("Inserisci il nome del cinema da gestire");
                            in.nextLine();
                            String scelta = in.nextLine();

                            Cinema cinemaScelto = null;
                            boolean isPresent=false;
                            for (Cinema cinema : cinemaList.getCinemaList()) {
                                if (cinema.getId().equals(scelta)) {
                                    cinemaScelto = cinema;
                                    isPresent = true;
                                }
                            }
                            if(isPresent) { //check if the text in input corresponds to a cinema in the list
                                menager = cinemaScelto.getMenager();
                                menager.mostraMenu();
                            }
                            else{
                                System.out.println("Cinema non presente");
                            }
                        } else { // the cinema list is empty
                            System.out.println("Nessun Cinema Presente!!!!");
                        }

                        break;
                    case 3:
                        break;
                    default:

                        System.out.println("Scelta non valida");
                }
            } catch (InputMismatchException ime) { //exception if the text entered for the menu is not integer
                System.out.println("Richiesti solo interi");
                in.nextLine();

            }
        } while (choice != 3);

    }

}
