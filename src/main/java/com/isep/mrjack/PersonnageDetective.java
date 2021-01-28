package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonnageDetective {
    Initialisation jeu;
    Plateau plateau;
    private ArrayList<Object> positionDetective;// = new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite()));
    //  (ArrayList<com.isep.mrjack.District>) Arrays.asList(D1, D1.getGauche());
    //[com.isep.mrjack.District, Gauche/Droite...]
    private ArrayList<PersonnagePlateau> suspectVisibles;
    private int nbSuspectVisibles;
    public int nbSabliers;
    public String image;

    public String getImage() {
        return image;
    }

    public PersonnageDetective(ArrayList<Object> positionDetective,
                               String image, Initialisation jeu) {
        //super(name, role);
        this.positionDetective = positionDetective;
        this.jeu = jeu;
        this.suspectVisibles = SuspectsVision(positionDetective);
        this.nbSuspectVisibles = suspectVisibles.size();
        this.image = image;
    }


    public ArrayList<PersonnagePlateau> SuspectsVision(ArrayList<Object> positionDetective){
        District Dx = (District) positionDetective.get(0);
        ArrayList<Integer> side = (ArrayList<Integer>) positionDetective.get(1);
        while (side.get(0) != 1){
            suspectVisibles.add(Dx.getPersonnage());
            nbSuspectVisibles += 1;}
        return suspectVisibles;
    }

    public void setPositionDetective(ArrayList<Object> positionDetective) {
        this.positionDetective = positionDetective;
    }

    public void setPositionDetective0(District e) {
        this.positionDetective.set(0, e);
    }

    public void setPositionDetective1(Object[] e) {
        this.positionDetective.set(1, e);
    }

    public ArrayList<PersonnagePlateau> getSuspectVisibles() {
        return suspectVisibles;
    }

    public void setSuspectVisibles(ArrayList<PersonnagePlateau> suspectVisibles) {
        this.suspectVisibles = suspectVisibles;
    }

    public ArrayList<Object> getPositionDetective() {
        return positionDetective;
    }

    public int getNbSuspectVisibles() {
        return nbSuspectVisibles;
    }

    public void setNbSuspectVisibles(int nbSuspectVisibles) {
        this.nbSuspectVisibles = nbSuspectVisibles;
    }

    public int getNbSabliers() {
        return nbSabliers;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
    }


}
