package com.isep.mrjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Enqueteur extends Player {
    public int nbSabliers;
    public Initialisation jeu;
    public PersonnageDetective Waston
            = new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())), "/image/jet_detec/Waston");
    public PersonnageDetective Toby
            = new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(7), jeu.districts.get(7).getBas())), "/image/jet_detec/Toby");;
    public PersonnageDetective Sherlock
            = new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(0), jeu.districts.get(0).getGauche())), "/image/jet_detec/Holmes");;

    public Enqueteur(String name) {
        super(name);
    }

    public int getNbSabliers() {
        return nbSabliers;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
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
