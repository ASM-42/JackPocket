package com.isep.mrjack;

import javax.swing.*;

public class PersonnagePlateau{
    public int[] position;
    public String nomP;
    public ImageIcon carte;
    private boolean visible;
    private int sabliers;
    public String statut; //coupable ou non

    public PersonnagePlateau(String nomP, int sabliers) {
        this.nomP = nomP;
        this.sabliers = sabliers;
    }

    public PersonnagePlateau(int nbSabliers, boolean visible, String statut){
        this.visible = visible;
        this.statut = statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public boolean isVisible() {
        return visible;
    }

    public int getSabliers() {
        return sabliers;
    }

    public void setSabliers(int sabliers) {
        this.sabliers = sabliers;
    }

    public String getStatut() {
        return statut;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
