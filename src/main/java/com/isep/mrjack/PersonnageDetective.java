package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonnageDetective {
    Initialisation jeu;
    private ArrayList<Object> positionDetective;// = new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite()));
    //  (ArrayList<com.isep.mrjack.District>) Arrays.asList(D1, D1.getGauche());
    //[com.isep.mrjack.District, Gauche/Droite...]
    private ArrayList<PersonnagePlateau> suspectVisibles ;
    public int nbSabliers;
    public String image;



    public String getImage() {
        return image;
    }

    public PersonnageDetective(ArrayList<Object> positionDetective,
                               String image, Initialisation jeu) {
        this.positionDetective = positionDetective;
        //setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get("D3"), jeu.districts.get("D3").getBas())));
        this.jeu = jeu;
        this.image = image;
    }

    public void MoveDetective1 (Plateau plateau){
        District d = jeu.districts.get(positionDetective.get(0));
        Object[] side = (Object[]) positionDetective.get(1);

        //Si le detective est à gauche
        if (side[2].equals('G')){
            if (d.getIndice() == 0){
                plateau.detectiveVide1[0].setIcon(null);
                positionDetective.set(1, d.getHaut());
                plateau.detectiveVide2[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 3){
                plateau.detectiveVide1[1].setIcon(null);
                positionDetective.set(0, String.format("D%s", 1));
                plateau.detectiveVide1[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 6){
                plateau.detectiveVide1[2].setIcon(null);
                positionDetective.set(0, String.format("D%s", 4));
                plateau.detectiveVide1[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en haut
        if (side[2].equals('H')){
            if (d.getIndice() == 0){
                plateau.detectiveVide2[0].setIcon(null);
                positionDetective.set(0, String.format("D%s", 2));
                plateau.detectiveVide2[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 1){
                plateau.detectiveVide2[1].setIcon(null);
                positionDetective.set(0, String.format("D%s", 3));
                plateau.detectiveVide2[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 2){
                plateau.detectiveVide2[0].setIcon(null);
                positionDetective.set(1, d.getDroite());
                plateau.detectiveVide3[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est à droite
        if (side[2].equals('D')){
            if (d.getIndice() == 2){
                plateau.detectiveVide3[0].setIcon(null);
                positionDetective.set(0, String.format("D%s", 6));
                plateau.detectiveVide3[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 5){
                plateau.detectiveVide3[1].setIcon(null);
                positionDetective.set(0, String.format("D%s", 9));
                plateau.detectiveVide3[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 8){
                plateau.detectiveVide3[2].setIcon(null);
                positionDetective.set(1, d.getBas());
                plateau.detectiveVide4[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en bas
        if (side[2].equals('B')){
            if (d.getIndice() == 8){
                plateau.detectiveVide4[2].setIcon(null);
                positionDetective.set(0, String.format("D%s", 8));
                plateau.detectiveVide4[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 7){
                plateau.detectiveVide4[1].setIcon(null);
                positionDetective.set(0, String.format("D%s", 7));
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 6){
                plateau.detectiveVide4[0].setIcon(null);
                positionDetective.set(1, d.getGauche());
                plateau.detectiveVide1[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
    }

    public void MoveDetective2 (Plateau plateau){
        District d = jeu.districts.get(positionDetective.get(0));
        Object[] side = (Object[]) positionDetective.get(1);

        //Si le detective est à gauche
        if (side[2].equals('G')){
            if (d.getIndice() == 0){
                plateau.detectiveVide1[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 2), jeu.districts.get(String.format("D%s", 2)).getHaut())));
                plateau.detectiveVide2[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 3){
                plateau.detectiveVide1[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 1), jeu.districts.get(String.format("D%s", 1)).getHaut())));
                plateau.detectiveVide2[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 6){
                plateau.detectiveVide1[2].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 1), jeu.districts.get(String.format("D%s", 1)).getGauche())));
                plateau.detectiveVide1[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en haut
        if (side[2].equals('H')){
            if (d.getIndice() == 0){
                plateau.detectiveVide2[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 3), jeu.districts.get(String.format("D%s", 3)).getHaut())));
                plateau.detectiveVide2[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 1){
                plateau.detectiveVide2[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 3), jeu.districts.get(String.format("D%s", 3)).getDroite())));
                plateau.detectiveVide3[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 2){
                plateau.detectiveVide2[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 6), jeu.districts.get(String.format("D%s", 6)).getDroite())));
                plateau.detectiveVide3[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est à droite
        if (side[2].equals('D')){
            if (d.getIndice() == 2){
                plateau.detectiveVide3[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 9), jeu.districts.get(String.format("D%s", 9)).getDroite())));
                plateau.detectiveVide3[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 5){
                plateau.detectiveVide3[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 9), jeu.districts.get(String.format("D%s", 9)).getBas())));
                plateau.detectiveVide4[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 8){
                plateau.detectiveVide3[2].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 8), jeu.districts.get(String.format("D%s", 8)).getBas())));
                plateau.detectiveVide4[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en bas
        if (side[2].equals('B')){
            if (d.getIndice() == 8){
                plateau.detectiveVide4[2].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 7), jeu.districts.get(String.format("D%s", 7)).getBas())));
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 7){
                plateau.detectiveVide4[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 7), jeu.districts.get(String.format("D%s", 7)).getGauche())));
                plateau.detectiveVide1[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d.getIndice() == 6){
                plateau.detectiveVide4[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(String.format("D%s", 4), jeu.districts.get(String.format("D%s", 4)).getGauche())));
                plateau.detectiveVide1[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
    }

    public ArrayList<PersonnagePlateau> SuspectsVision(ArrayList<Object> positionDetective){
        District Dx = (District) positionDetective.get(0);
        Object[] side = (Object[]) positionDetective.get(1);
        int mur = (Integer) side[0];
        while (mur != 1){
            suspectVisibles.add(Dx.getPersonnage());}
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


    public int getNbSabliers() {
        return nbSabliers;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
    }


}
