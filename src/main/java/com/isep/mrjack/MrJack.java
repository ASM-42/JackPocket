package com.isep.mrjack;

public class MrJack extends Player {
    public int nbSabliers;
    public final PersonnagePlateau coupable ;

    public MrJack(String name, PersonnagePlateau coupable) {
        //déclaration des attributs de MrJack
        super(name);
        this.coupable = coupable;
        coupable.setStatut("guilty");
    }

    //getters et setters
    
    public int getNbSabliers() {
        return nbSabliers;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
    }

    public PersonnagePlateau getCoupable() {
        return coupable;
    }

}
