package it.develhope;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        CinemaList cinemaList = new CinemaList();
        Cinema cinema1=new Cinema("Iris");
        Menager menager = new Menager("Tania", "Ielpo", "taniaie@tiscali.it");
        cinema1.setMenager(menager);
        menager.setCinema(cinema1);
        cinemaList.add(cinema1);
        Scanner in = new Scanner(System.in);

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
                            if(isPresent) {
                                menager = cinemaScelto.getMenager();
                                menager.mostraMenu();
                            }
                            else{
                                System.out.println("Cinema non presente");
                            }
                        } else {
                            System.out.println("Nessun Cinema Presente!!!!");
                        }

                        break;
                    case 3:
                        break;
                    default:

                        System.out.println("Scelta non valida");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Richiesti solo interi");
                in.nextLine();

            }
        } while (choice != 3);

    }

}
