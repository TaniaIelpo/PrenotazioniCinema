package it.develhope;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a Cinema list
 *
 * @author Tania Ielpo
 */

public class CinemaList {

    private List<Cinema> cinemaList;

    public CinemaList(){
        cinemaList=new ArrayList<>();
    }

    public void add(Cinema cinema){
        cinemaList.add(cinema);
    }

    public List<Cinema> getCinemaList() {
        return cinemaList.stream().toList();
    }
}
