package com.isep.mrjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Enqueteur extends Player {
    
    //déclaration des attributs de ENQUETEUR
    public static final int role = 1;
    public PersonnageDetective Waston;
            //= new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get("D3"), jeu.districts.get("D3").getBas())), "/images/jet_detec/Watson.png", jeu);
    public PersonnageDetective Toby;
            //= new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get("D8"), jeu.districts.get("D8").getBas())), "/images/jet_detec/Tobby.png", jeu);
    public PersonnageDetective Sherlock;
            //= new PersonnageDetective(new ArrayList<>(Arrays.asList(jeu.districts.get("D1"), jeu.districts.get("D1").getGauche())), "/images/jet_detec/Holmes.png", jeu);

    
    //constucteur de ENQUETEUR
    public Enqueteur(String name, PersonnageDetective Watson, PersonnageDetective Toby, PersonnageDetective Sherlock) {
        super(name);
        this.Waston = Watson;
        this.Toby = Toby;
        this.Sherlock = Sherlock;
        //this.role = 1;
        //this.jeu = jeu;
    }

    
    //GETTERS ET SETTERS DE DISTRICT
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

    //@Override
    public int getRole() {
        return role;
    }
}
