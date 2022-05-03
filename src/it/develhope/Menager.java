package it.develhope;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menager extends User{

    private Cinema cinema;
    private Scanner input = new Scanner(System.in);


    public Menager(String nome, String cognome, String email) {
        super(nome, cognome, email);
    }
    public void setCinema(Cinema cinema){

        this.cinema=cinema;
    }

    public void mostraPosti() {
        System.out.println("Posti disponibili: " + (this.cinema.MAX_PLACES - this.cinema.getPrenotazione().size()));
    }
    public void prenotaPosto() {
        List<Prenotazione> prenotazione = this.cinema.getPrenotazione();
        if (this.cinema.MAX_PLACES - prenotazione.size() > 0) {
            String name, surname, mail;
            System.out.printf("nome: ");
            input.nextLine();
            name = input.nextLine();

            System.out.printf("cognome: ");
            surname = input.nextLine();
            System.out.printf("email: ");
            mail = input.nextLine();
            prenotazione.add(new Prenotazione(new User(name, surname, mail), this.cinema));

            System.out.println("Posto prenotato");
        } else {
            System.out.println("Non ci sono posti disponibili");
        }
        this.cinema.setPrenotazione(prenotazione);

    }
    public void cancellaPrenotazione() {
        List<Prenotazione> prenotazione = this.cinema.getPrenotazione();
        System.out.printf("Inserisci nome:");
        String name = input.nextLine();

        System.out.printf("Inserisci cognome:");
        String cognome = input.nextLine();
        System.out.printf("Inserisci email:");
        String email = input.nextLine();
        User user = new User(name, cognome, email);

        for (Prenotazione pre : prenotazione) {
            if (pre.getUser().equals(user)) {
                prenotazione.remove(pre);
                System.out.println("Prenotazione cancellata");
                break;
            } else
                System.out.println("Non ci sono prenotazioni con quel nome");

        }
        this.cinema.setPrenotazione(prenotazione);
     }
    public void stampa(){
        List<Prenotazione> prenotazione = this.cinema.getPrenotazione();
        if(prenotazione.size()>0)
            for (Prenotazione pren:prenotazione)
                pren.stampa();
        else System.out.println("Nessuna prenotazione");
    }

    public void mostraMenu() {
        int choice = 0;
        do {
            System.out.println("CINEMA: "+this.cinema.getId()+"\nGESTITO DA: "+this.toString());
            System.out.println("----------------------------------\n" +
                    "1. Posti disponibili\n" +
                    "2. Prenota un posto\n" +
                    "3. Cancella prenotazione\n" +
                    "4. Stampa prenotazioni\n" +
                    "5. Esci");

            try {
                choice = input.nextInt();

                switch (choice) {
                    case 5:
                        break;
                    case 1:
                        this.mostraPosti();
                        break;
                    case 2:
                        this.prenotaPosto();
                        break;
                    case 3:
                        this.cancellaPrenotazione();
                        break;
                    case 4:
                        this.stampa();
                        break;
                    default:
                        System.out.println("Scelta non valida");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Richiesti solo interi");
                input.nextLine();
            }
        } while (choice != 5);

    }

}
