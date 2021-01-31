package com.isep.mrjack;

public class MrJack extends Player {
    public int nbSabliers;
    public PersonnagePlateau coupable ;

    public MrJack(String name) {
        super(name);
    }

    public int getNbSabliers() {
        return nbSabliers;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
    }

    public PersonnagePlateau getCoupable() {
        return coupable;
    }

    public void setCoupable(PersonnagePlateau coupable) {
        this.coupable = coupable;
        coupable.setStatut("guilty");
    }
}
