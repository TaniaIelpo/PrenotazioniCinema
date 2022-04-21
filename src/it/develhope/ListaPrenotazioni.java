package it.develhope;

public class ListaPrenotazioni {

    final private int MAX=10;
    private int count=0;

    public ListaPrenotazioni() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void mostraPosti(){
        System.out.println("Posti disponibili: "+(this.MAX-this.count));
    }
    public void prenotaPosto(){
        if(this.MAX-this.count>0) {
            count++;
            System.out.println("Posto prenotato");
        }
        else{
            System.out.println("Non ci sono posti disponibili");
        }
    }
    public void cancellaPrenotazione(){
        count--;
        System.out.println("Prenotazione cancellata");
    }
}
