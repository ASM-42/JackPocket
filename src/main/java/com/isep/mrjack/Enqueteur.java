package com.isep.mrjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Enqueteur extends Player {
    public PersonnageDetective Waston;
            //= new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get("D3"), jeu.districts.get("D3").getBas())), "/images/jet_detec/Watson.png", jeu);
    public PersonnageDetective Toby;
            //= new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get("D8"), jeu.districts.get("D8").getBas())), "/images/jet_detec/Tobby.png", jeu);
    public PersonnageDetective Sherlock;
            //= new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get("D1"), jeu.districts.get("D1").getGauche())), "/images/jet_detec/Holmes.png", jeu);

    public Enqueteur(String name) {
        super(name);
        //this.jeu = jeu;
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