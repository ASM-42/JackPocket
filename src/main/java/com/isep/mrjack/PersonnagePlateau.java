package com.isep.mrjack;

import javax.swing.*;

public class PersonnagePlateau{
    public int[] position;
    public String nomP;
    public String carte;
    private boolean visible = false;
    private int sabliers;
    public String statut = "innocent"; //coupable ou non



    public PersonnagePlateau(String nomP, int sabliers, String imageAlibi) {
        this.nomP = nomP;
        this.sabliers = sabliers;
        this.carte = imageAlibi;
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

    public String getCarte() {
        return carte;
    }
}
