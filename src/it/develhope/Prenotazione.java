package it.develhope;
import java.util.Objects;

/**
 * represent a booking object
 *
 * @author Tania Ielpo
 */

public class Prenotazione {
    private Cinema cinema;  //cinema booked
    private User user; //the one who booked


    public Prenotazione(User user, Cinema cinema){

        this.user=user;
        this.cinema=cinema;
    }

    public void stampa(){
        System.out.println("CLIENTE\n"+
                "NOME: " +this.user.getNome()+
                "\nCOGNOME: "+ this.user.getCognome()+
                "\nEMAIL: "+this.user.getEmail());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean equals(Prenotazione o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return Objects.equals(user, o.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
