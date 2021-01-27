package com.isep.mrjack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class District extends Object {
    private String orientation; //"up" = personnages, "down" pas de personnage
    private Object[] Gauche = {1, 1, 'G'}; // 0 vide, 1 mur   0 accessible, 1 non accessible    G lettre coté
    private Object[] Haut = {0, 1, 'H'};
    private Object[] Droite = {0, 1, 'D'};
    private Object[] Bas = {0, 1, 'B'};
    private ArrayList<Object[]> cotes;
    private PersonnagePlateau personnage;
    private int indice;
    private int angle;
    public String image;

    public District(PersonnagePlateau personnage, String image) {
        this.orientation = "up";
        this.personnage = personnage;
        this.angle = 0;
        this.image = image;
    }
            /*
    public void rotationImage (){
        if (angle == 0){

        }
    }
    */

/*
    public District(String orientation, ArrayList<Object> gauche, ArrayList<Object> haut, ArrayList<Object> droite,
                    ArrayList<Object> bas, ArrayList<ArrayList<Object>> cotes, PersonnagePlateau personnage, int indice) {
        this.orientation = orientation;
        Gauche = gauche;
        Haut = haut;
        Droite = droite;
        Bas = bas;
        this.cotes = cotes;
        this.personnage = personnage;
        this.indice = indice;
    }
*/
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
        if (angle == 260){ angle = 0;}
        else{angle += 90;}
    }

    public void swapQuartAntihoraire(){
        Object[] temp = Gauche;
        Gauche = Haut;
        Haut = Droite;
        Droite = Bas;
        Bas = temp;
        if (angle == 0){ angle = 260;}
        if (angle == 260){ angle = 180;}
        if (angle == 180){ angle = 90;}
        if (angle == 90){ angle = 0;}
    }



    /*
    public com.isep.mrjack.District(String orientation, ArrayList<ArrayList<Integer>> cotés,
                    ArrayList<Integer> Gauche, ArrayList<Integer> Haut, ArrayList<Integer> Droite,
                    ArrayList<Integer> Bas) {
        this.orientation = "up";
        this.Gauche = Gauche;
        Gauche.add(1); Gauche.add(1);
        this.Haut = Haut;
        Haut.add(0); Haut.add(0);
        this.Droite = Droite;
        Droite.add(0); Droite.add(0);
        this.Bas = Bas;
        Bas.add(0); Bas.add(0);
        this.cotés = cotés;
        cotés.add(Gauche); cotés.add(Haut); cotés.add(Droite); cotés.add(Bas);

    }*/

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

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
