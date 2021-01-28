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


    public PersonnageDetective(ArrayList<Object> positionDetective,
                                String image, Initialisation jeu) {
        //super(name, role);
        this.positionDetective = positionDetective;
        this.jeu = jeu;
        this.suspectVisibles = SuspectsVision(positionDetective);
        this.nbSuspectVisibles = suspectVisibles.size();
        this.image = image;
    }


    public void MoveDetective1 (){
        District[] district = jeu.districts.values().toArray(new District[9]);
        District d = jeu.districts.get(positionDetective.get(0));
        ArrayList<String> side = (ArrayList<String>) positionDetective.get(1);
        //JButton place = new JButton();
        System.out.println("here3");

        //Si le detective est à gauche
        if (side.get(2).equals('G')){
            if (d == district[0]){
                plateau.detectiveVide1[0].setIcon(null);
                positionDetective.set(1, d.getHaut());
                plateau.detectiveVide2[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
                //plateau.detectivePanel1.add(place);
            }
            if (d == district[3]){
                plateau.detectiveVide1[1].setIcon(null);
                positionDetective.set(0, jeu.districts.get(0));
                plateau.detectiveVide1[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[6]){
                plateau.detectiveVide1[2].setIcon(null);
                positionDetective.set(0, jeu.districts.get(3));
                plateau.detectiveVide1[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en haut
        if (side.get(2).equals('H')){
            if (d == district[0]){
                plateau.detectiveVide2[0].setIcon(null);
                positionDetective.set(0, jeu.districts.get(1));
                plateau.detectiveVide2[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[1]){
                plateau.detectiveVide2[1].setIcon(null);
                positionDetective.set(0, jeu.districts.get(2));
                plateau.detectiveVide2[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[2]){
                plateau.detectiveVide2[2].setIcon(null);
                positionDetective.set(1, d.getDroite());
                plateau.detectiveVide3[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est à droite
        if (side.get(2).equals('D')){
            if (d == district[2]){
                plateau.detectiveVide3[0].setIcon(null);
                positionDetective.set(0, jeu.districts.get(1));
                plateau.detectiveVide3[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[5]){
                plateau.detectiveVide3[1].setIcon(null);
                positionDetective.set(0, jeu.districts.get(2));
                plateau.detectiveVide3[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[8]){
                plateau.detectiveVide3[2].setIcon(null);
                positionDetective.set(1, d.getDroite());
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en bas
        if (side.get(2).equals('B')){
            if (d == district[8]){
                plateau.detectiveVide4[2].setIcon(null);
                positionDetective.set(0, jeu.districts.get(7));
                plateau.detectiveVide4[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[7]){
                plateau.detectiveVide4[1].setIcon(null);
                positionDetective.set(0, jeu.districts.get(6));
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[6]){
                plateau.detectiveVide4[0].setIcon(null);
                positionDetective.set(1, d.getGauche());
                plateau.detectiveVide1[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
    }

    public void MoveDetective2 (PersonnageDetective detective){
        District[] district = jeu.districts.values().toArray(new District[9]);
        District d = jeu.districts.get(positionDetective.get(0));
        ArrayList<String> side = (ArrayList<String>) positionDetective.get(1);
        //JButton place = new JButton();

        //Si le detective est à gauche
        if (side.get(2).equals('G')){
            if (d == district[0]){
                plateau.detectiveVide1[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(1), jeu.districts.get(1).getHaut())));
                plateau.detectiveVide2[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
                //plateau.detectivePanel1.add(place);
            }
            if (d == district[3]){
                plateau.detectiveVide1[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(0), jeu.districts.get(0).getHaut())));
                plateau.detectiveVide2[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[6]){
                plateau.detectiveVide1[2].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(0), jeu.districts.get(0).getGauche())));
                plateau.detectiveVide1[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en haut
        if (side.get(2).equals('H')){
            if (d == district[0]){
                plateau.detectiveVide2[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getHaut())));
                plateau.detectiveVide2[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[1]){
                plateau.detectiveVide2[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())));
                plateau.detectiveVide3[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[2]){
                plateau.detectiveVide2[2].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(5), jeu.districts.get(5).getDroite())));
                plateau.detectiveVide3[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est à droite
        if (side.get(2).equals('D')){
            if (d == district[2]){
                plateau.detectiveVide3[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(8), jeu.districts.get(8).getDroite())));
                plateau.detectiveVide3[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[5]){
                plateau.detectiveVide3[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(8), jeu.districts.get(8).getBas())));
                plateau.detectiveVide4[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[8]){
                plateau.detectiveVide3[2].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(7), jeu.districts.get(7).getBas())));
                plateau.detectiveVide4[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
        //Si le detective est en bas
        if (side.get(2).equals('B')){
            if (d == district[8]){
                plateau.detectiveVide4[2].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(6), jeu.districts.get(6).getBas())));
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[7]){
                plateau.detectiveVide4[1].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(6), jeu.districts.get(6).getGauche())));
                plateau.detectiveVide1[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
            if (d == district[6]){
                plateau.detectiveVide4[0].setIcon(null);
                setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(3), jeu.districts.get(3).getGauche())));
                plateau.detectiveVide1[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(image))));
            }
        }
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
