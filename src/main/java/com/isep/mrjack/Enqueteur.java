package com.isep.mrjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Enqueteur extends Player {
    Initialisation jeu;
    public PersonnageDetective Waston
            = new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())), "/image/jet_detec/Waston", jeu);
    public PersonnageDetective Toby
            = new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())), "/image/jet_detec/Toby", jeu);
    public PersonnageDetective Sherlock
            = new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())),"/image/jet_detec/Holmes", jeu);

    public Enqueteur(String name, Initialisation jeu) {
        super(name);
        this.jeu = jeu;
        Waston.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())));
        Toby.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(7), jeu.districts.get(7).getBas())));
        Sherlock.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(0), jeu.districts.get(0).getGauche())));

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