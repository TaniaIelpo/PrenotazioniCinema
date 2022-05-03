package it.develhope;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cinema {

    private Menager menager;

    private String id;
    final int MAX_PLACES = 10;
    private List<Prenotazione> prenotazione = new ArrayList<>();

    public Cinema(String id) {
        this.id = id;
    }

    public Menager getMenager() {
        return menager;
    }

    public void setMenager(Menager menager) {
        this.menager = menager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Prenotazione> getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(List<Prenotazione> prenotazione) {
        this.prenotazione = prenotazione;
    }
}
