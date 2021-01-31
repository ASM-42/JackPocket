package com.isep.mrjack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class District {
    private String orientation; //"up" = personnages, "down" pas de personnage
    private Object[] Gauche = {0, true, 'G'}; // 0 vide, 1 mur   0 accessible, 1 non accessible    G lettre coté
    private Object[] Haut = {0, true, 'H'};
    private Object[] Droite = {0, true, 'D'};
    private Object[] Bas = {1, true, 'B'};
    private ArrayList<Object[]> cotes;
    private PersonnagePlateau personnage;
    private int indice;
    private int angle;
    private String[] images;
    public String imageActive;

    public District(PersonnagePlateau personnage, String[] images) {
        this.orientation = "up";
        this.personnage = personnage;
        this.angle = 0;
        this.images = images;
        this.imageActive = this.images[0];
    }

    public void turn () {
        if (orientation == "up");
            orientation = "down";
            personnage.setVisible(false);
            personnage.setStatut("innocent");
    }
    public void swapQuartHoraire(){
        Object[] temp = Gauche;
        Gauche = Bas;
        Bas = Droite;
        Droite = Haut;
        Haut = temp;
        Haut[2]='H'; Gauche[2]='G'; Droite[2]='D'; Bas[2]='B';
        switch (this.angle){
            case 0:
                this.angle = 270;
                break;
            case 270:
                this.angle = 180;
                break;
            case 180:
                this.angle = 90;
                break;
            case 90:
                this.angle = 0;
                break;
        }
    }

    public void swapQuartAntihoraire(){
        Object[] temp = Gauche;
        Gauche = Haut; Haut[2]='H';
        Haut = Droite;
        Droite = Bas;
        Bas = temp;
        Haut[2]='H'; Gauche[2]='G'; Droite[2]='D'; Bas[2]='B';
        switch (this.angle){
            case 0:
                this.angle = 90;
                break;
            case 90:
                this.angle = 180;
                break;
            case 180:
                this.angle = 270;
                break;
            case 270:
                this.angle = 0;
                break;
        }

    }


    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Object[] getGauche() {
        return Gauche;
    }

    public void setGauche(Object[] gauche) {
        Gauche = gauche;
    }

    public Object[] getHaut() {
        return Haut;
    }

    public void setHaut(Object[] haut) {
        Haut = haut;
    }

    public Object[] getDroite() {
        return Droite;
    }

    public void setDroite(Object[] droite) {
        Droite = droite;
    }

    public Object[] getBas() {
        return Bas;
    }

    public void setBas(Object[] bas) {
        Bas = bas;
    }

    public ArrayList<Object[]> getCotes() {
        return cotes;
    }

    public void setCotes(ArrayList<Object[]> cotes) {
        this.cotes = cotes;
    }

    public PersonnagePlateau getPersonnage() {
        return personnage;
    }

    public void setPersonnage(PersonnagePlateau personnage) {
        this.personnage = personnage;
    }

    public void setIndice(int i) {
        if(i == 0){ Droite[1] = false; Bas[1] = false;}
        if(i == 1){ Droite[1] = false; Bas[1] = false; Gauche[1] = false;}
        if(i == 2){ Gauche[1] = false; Bas[1] = false;}
        if(i == 3){ Droite[1] = false; Bas[1] = false; Haut[1] = false;}
        if(i == 4){ Droite[1] = false; Bas[1] = false; Gauche[1] = false; Haut[1] = false;}
        if(i == 5){ Gauche[1] = false; Bas[1] = false; Haut[1] = false;}
        if(i == 6){ Droite[1] = false; Haut[1] = false;}
        if(i == 7){ Droite[1] = false; Haut[1] = false; Gauche[1] = false;}
        if(i == 8){ Gauche[1] = false; Haut[1] = false;}
        this.indice = i;
    }

    public int getIndice() {
        return indice;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
