package com.isep.mrjack;

import java.util.ArrayList;
import java.util.Arrays;

public class District extends Object {
    private String orientation; //"up" = personnages, "down" pas de personnage
    private ArrayList<Object> Gauche = new ArrayList<Object>(Arrays.asList(1, 1, 'G')); // 0 vide, 1 mur   0 accessible, 1 non accessible    G lettre coté
    private ArrayList<Object> Haut;
    private ArrayList<Object> Droite;
    private ArrayList<Object> Bas;
    private ArrayList<ArrayList<Object>> cotes;
    private PersonnagePlateau personnage;
    private int indice;
    private int angle;

    public District(PersonnagePlateau personnage) {
        this.orientation = "up";
        this.Haut =  new ArrayList<Object>(Arrays.asList(0, 1, 'H'));
        this.Droite =  new ArrayList<Object>(Arrays.asList(0, 1, 'D'));
        this.Bas =  new ArrayList<Object>(Arrays.asList(0, 1, 'B'));
        this.cotes =  new ArrayList<>();
        cotes.add(Gauche); cotes.add(Haut); cotes.add(Droite); cotes.add(Bas);
        this.personnage = personnage;
        this.angle = 90;

    }

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

    public void turn () {
        if (orientation == "up");
            orientation = "down";
            personnage.setVisible(false);
            personnage.setStatut("innocent");
    }
    public void swapQuartHoraire(){
        ArrayList<Object> temp = Gauche;
        Gauche = Bas;
        Bas = Droite;
        Droite = Haut;
        Haut = temp;
    }

    public void swapQuartAntihoraire(){
        ArrayList<Object> temp = Gauche;
        Gauche = Haut;
        Haut = Droite;
        Droite = Bas;
        Bas = temp;
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

    public ArrayList<Object> getGauche() {
        return Gauche;
    }

    public void setGauche(ArrayList<Object> gauche) {
        Gauche = gauche;
    }

    public ArrayList<Object> getHaut() {
        return Haut;
    }

    public void setHaut(ArrayList<Object> haut) {
        Haut = haut;
    }

    public ArrayList<Object> getDroite() {
        return Droite;
    }

    public void setDroite(ArrayList<Object> droite) {
        Droite = droite;
    }

    public ArrayList<Object> getBas() {
        return Bas;
    }

    public void setBas(ArrayList<Object> bas) {
        Bas = bas;
    }

    public ArrayList<ArrayList<Object>> getCotes() {
        return cotes;
    }

    public void setCotes(ArrayList<ArrayList<Object>> cotes) {
        this.cotes = cotes;
    }

    public PersonnagePlateau getPersonnage() {
        return personnage;
    }

    public void setPersonnage(PersonnagePlateau personnage) {
        this.personnage = personnage;
    }

}
