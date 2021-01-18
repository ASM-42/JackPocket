package com.isep.mrjack;

import java.util.ArrayList;

public class District extends Object {
    private String orientation; //"up" = personnages, "down" pas de personnage
    private ArrayList<Integer> Gauche; // 0 vide, 1 mur    0 accessible, 1 non accessible aux detectives
    private ArrayList<Integer> Haut;
    private ArrayList<Integer> Droite;
    private ArrayList<Integer> Bas;
    private ArrayList<ArrayList<Integer>> cotés;
    private PersonnagePlateau personnage;
    private int indice;

    public District() {
        this.orientation = "up";
        this.Gauche = new ArrayList<>();
        Gauche.add(1); Gauche.add(1);
        this.Haut =  new ArrayList<>();
        Haut.add(0); Haut.add(0);
        this.Droite =  new ArrayList<>();
        Droite.add(0); Droite.add(0);
        this.Bas =  new ArrayList<>();
        Bas.add(0); Bas.add(0);
        this.cotés =  new ArrayList<>();
        cotés.add(Gauche); cotés.add(Haut); cotés.add(Droite); cotés.add(Bas);

    }

    public District(String orientation, ArrayList<Integer> gauche, ArrayList<Integer> haut, ArrayList<Integer> droite,
                    ArrayList<Integer> bas, ArrayList<ArrayList<Integer>> cotés, PersonnagePlateau personnage, int indice) {
        this.orientation = orientation;
        Gauche = gauche;
        Haut = haut;
        Droite = droite;
        Bas = bas;
        this.cotés = cotés;
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
        ArrayList<Integer> temp = Gauche;
        Gauche = Bas;
        Bas = Droite;
        Droite = Haut;
        Haut = temp;
    }

    public void swapQuartAntihoraire(){
        ArrayList<Integer> temp = Gauche;
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

    public ArrayList<Integer> getGauche() {
        return Gauche;
    }

    public void setGauche(ArrayList<Integer> gauche) {
        Gauche = gauche;
    }

    public ArrayList<Integer> getHaut() {
        return Haut;
    }

    public void setHaut(ArrayList<Integer> haut) {
        Haut = haut;
    }

    public ArrayList<Integer> getDroite() {
        return Droite;
    }

    public void setDroite(ArrayList<Integer> droite) {
        Droite = droite;
    }

    public ArrayList<Integer> getBas() {
        return Bas;
    }

    public void setBas(ArrayList<Integer> bas) {
        Bas = bas;
    }

    public ArrayList<ArrayList<Integer>> getCotés() {
        return cotés;
    }

    public void setCotés(ArrayList<ArrayList<Integer>> cotés) {
        this.cotés = cotés;
    }

    public PersonnagePlateau getPersonnage() {
        return personnage;
    }

    public void setPersonnage(PersonnagePlateau personnage) {
        this.personnage = personnage;
    }

}