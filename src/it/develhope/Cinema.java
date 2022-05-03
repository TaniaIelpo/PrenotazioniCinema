package it.develhope;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Cinema
 *
 * @author Tania
 */

public class Cinema {

    private Menager menager;  //who manages the cinema

    private String id;  //cinema name
    final int MAX_PLACES = 10;
    private List<Prenotazione> prenotazione = new ArrayList<>(); //cinema bookings

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

    /**
     * returns cinema bookings list
     * @return prenotazione a list of bookings
     */

    public List<Prenotazione> getPrenotazione() {
        return prenotazione;
    }

    /**
     * assign a list of cinema bookings
     * @param prenotazione list of bookings
     */

    public void setPrenotazione(List<Prenotazione> prenotazione) {
        this.prenotazione = prenotazione;
    }
}
