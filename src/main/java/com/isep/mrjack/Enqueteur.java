package com.isep.mrjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Enqueteur extends Player {
    public Initialisation jeu;
    public PersonnageDetective Sherlock
            = new PersonnageDetective(new ArrayList<Object>(Arrays.asList(jeu.districts.get(0), jeu.districts.get(0).getGauche())), "/image/jet_detec/Holmes.png");
    public PersonnageDetective Waston
            = new PersonnageDetective(new ArrayList<Object>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())), "/image/jet_detec/Waston.png");
    public PersonnageDetective Toby
            = new PersonnageDetective(new ArrayList<Object>(Arrays.asList(jeu.districts.get(7), jeu.districts.get(7).getBas())), "/image/jet_detec/Toby.png");

    public Enqueteur(Player player) {
        super(player.getName());
    }

    public PersonnageDetective getWaston() {
        return Waston;
    }

    public void setWaston(PersonnageDetective waston) {
        Waston = waston;
    }

    public PersonnageDetective getToby() {
        return Toby;
    }

    public void setToby(PersonnageDetective toby) {
        Toby = toby;
    }

    public PersonnageDetective getSherlock() {
        return Sherlock;
    }

    public void setSherlock(PersonnageDetective sherlock) {
        Sherlock = sherlock;
    }


}
