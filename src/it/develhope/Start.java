package it.develhope;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        ListaPrenotazioni prenotazioni=new ListaPrenotazioni();
        Scanner in= new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Posti disponibili\n" +
                    "2. Prenota un posto\n" +
                    "3. Cancella prenotazione\n" +
                    "4. Esci");
            choice=in.nextInt();
            switch (choice){
                case 4: 
                    break;
                case 1:
                    prenotazioni.mostraPosti();
                    break;
                case 2: 
                    prenotazioni.prenotaPosto();
                    break;
                case 3: 
                    prenotazioni.cancellaPrenotazione();
                    break;
                default:
                    System.out.println("Scelta non valida");
            }

        }while(choice!=0);
        
    }

}
