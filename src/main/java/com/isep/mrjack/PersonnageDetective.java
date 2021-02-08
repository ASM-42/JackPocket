package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PersonnageDetective {
    Initialisation jeu;
    private ArrayList<Object> positionDetective;// = new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite()));
    //  (ArrayList<com.isep.mrjack.District>) Arrays.asList(D1, D1.getGauche());
    //[com.isep.mrjack.District, Gauche/Droite...]
    public List<PersonnagePlateau> suspectVisibles = new LinkedList<PersonnagePlateau>();
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


    public List<PersonnagePlateau> SuspectsVision(Initialisation jeu){
        List<PersonnagePlateau>suspectsNow = new LinkedList<>();
        int indice = jeu.districts.get(positionDetective.get(0)).getIndice();
        Object[] side = (Object[]) positionDetective.get(1);

        if (side[2].equals('G')){
            if ((boolean) jeu.districts.get(positionDetective.get(0)).getGauche()[0] == false){
                suspectsNow.add(jeu.districts.get(positionDetective.get(0)).getPersonnage());
                if((boolean) jeu.districts.get(positionDetective.get(0)).getDroite()[0] == false) {
                    indice+=1;
                    String Dx = String.format("D%s", indice+1);
                    District district = jeu.districts.get(Dx);
                    if ((boolean) district.getGauche()[0] == false){
                        suspectsNow.add(district.getPersonnage());
                        if ((boolean) district.getDroite()[0] == false){
                            indice+=1;
                            Dx = String.format("D%s", indice+1);
                            district = jeu.districts.get(Dx);
                            if ((boolean) district.getGauche()[0] == false){
                                suspectsNow.add(district.getPersonnage());
                            }
                        }
                    }
                }
            }
        }
        if (side[2].equals('H')) {
            if ((boolean) jeu.districts.get(positionDetective.get(0)).getHaut()[0] == false) {
                suspectsNow.add(jeu.districts.get(positionDetective.get(0)).getPersonnage());
                if ((boolean) jeu.districts.get(positionDetective.get(0)).getBas()[0] == false) {
                    indice += 3;
                    String Dx = String.format("D%s", indice+1);
                    District district = jeu.districts.get(Dx);
                    if ((boolean) district.getHaut()[0] == false) {
                        suspectsNow.add(district.getPersonnage());
                        if ((boolean) district.getBas()[0] == false) {
                            indice +=3;
                            Dx = String.format("D%s", indice+1);
                            district = jeu.districts.get(Dx);
                            if ((boolean) district.getHaut()[0] == false) {
                                suspectsNow.add(district.getPersonnage());
                            }
                        }
                    }
                }
            }
        }
        if (side[2].equals('B')) {
            if ((boolean) jeu.districts.get(positionDetective.get(0)).getBas()[0] == false) {
                suspectsNow.add(jeu.districts.get(positionDetective.get(0)).getPersonnage());
                if ((boolean) jeu.districts.get(positionDetective.get(0)).getHaut()[0] == false) {
                    indice -= 3;
                    String Dx = String.format("D%s", indice+1);
                    District district = jeu.districts.get(Dx);
                    if ((boolean) district.getBas()[0] == false) {
                        suspectsNow.add(district.getPersonnage());
                        if ((boolean) district.getHaut()[0] == false) {
                            indice -=3;
                            Dx = String.format("D%s", indice+1);
                            district = jeu.districts.get(Dx);
                            if ((boolean) district.getBas()[0] == false) {
                                suspectsNow.add(district.getPersonnage());
                            }
                        }
                    }
                }
            }
        }
        if (side[2].equals('D')){
            if ((boolean) jeu.districts.get(positionDetective.get(0)).getDroite()[0] == false){
                suspectsNow.add(jeu.districts.get(positionDetective.get(0)).getPersonnage());
                if((boolean) jeu.districts.get(positionDetective.get(0)).getGauche()[0] == false) {
                    indice-=1;
                    String Dx = String.format("D%s", indice+1);
                    District district = jeu.districts.get(Dx);
                    if ((boolean) district.getDroite()[0] == false){
                        suspectsNow.add(district.getPersonnage());
                        if ((boolean) district.getGauche()[0] == false){
                            indice-=1;
                            Dx = String.format("D%s", indice+1);
                            district = jeu.districts.get(Dx);
                            if ((boolean) district.getDroite()[0] == false){
                                suspectsNow.add(district.getPersonnage());
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<suspectsNow.size(); i++){
            suspectsNow.get(i).setVisible(true);
        }
        /* Début récurrence
        if (panel == 'H'){
            for (int i=0; i<2; i++){
                //Dx = jeu.districts.get(String.format("D%s", x));
                if ((boolean) Dx.getHaut()[0] == false){
                    this.suspectVisibles.add(Dx.getPersonnage());
                }
                Dx = jeu.districts.get(String.format("D%s", x+=3));
                if ((boolean) Dx.getBas()[0] == true){ break; }
            }
        }
        if (panel == 'G'){
            for (int i=0; i<2; i++){
                //Dx = jeu.districts.get(String.format("D%s", x));
                if ((boolean) Dx.getGauche()[0] == false){
                    this.suspectVisibles.add(Dx.getPersonnage());
                }
                Dx = jeu.districts.get(String.format("D%s", x+=1));
                if ((boolean) Dx.getDroite()[0] == true){ break; }
            }
        }
        if (panel == 'D'){
            for (int i=0; i<2; i++){
                //Dx = jeu.districts.get(String.format("D%s", x));
                if ((boolean) Dx.getDroite()[0] == false){
                    this.suspectVisibles.add(Dx.getPersonnage());
                }
                Dx = jeu.districts.get(String.format("D%s", x-=1));
                if ((boolean) Dx.getGauche()[0] == true){ break; }
            }
        }
        if (panel == 'B'){
            for (int i=0; i<2; i++){
                //Dx = jeu.districts.get(String.format("D%s", x));
                if ((boolean) Dx.getBas()[0] == false){
                    this.suspectVisibles.add(Dx.getPersonnage());
                }
                Dx = jeu.districts.get(String.format("D%s", x-=3));
                if ((boolean) Dx.getHaut()[0] == true){ break; }
            }
        }*/
        return suspectsNow;
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
