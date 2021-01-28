package com.isep.mrjack;

public class Enqueteur extends Player {
    public int nbSabliers;
    public PersonnageDetective Waston;
    public PersonnageDetective Toby;
    public PersonnageDetective Sherlock;

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