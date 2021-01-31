package com.isep.mrjack;

import javax.swing.*;
import java.util.ArrayList;


public class District {
    //déclaration des attributs de DISTRICT
    private String orientation; //"up" = personnages, "down" pas de personnage
    private Object[] Gauche = {false, true, 'G'}; // 0 vide, 1 mur   0 accessible, 1 non accessible    G lettre coté
    private Object[] Haut = {false, true, 'H'};
    private Object[] Droite = {false, true, 'D'};
    private Object[] Bas = {false, true, 'B'};
    private ArrayList<Object[]> cotes;
    private final PersonnagePlateau personnage;
    private int indice;
    private int angle;
    private final String[] images;
    public String imageActive;

     //constucteur de DISTRICT
    public District(PersonnagePlateau personnage, String[] images) {
        this.orientation = "up";
        this.personnage = personnage;
        this.angle = 0;
        this.images = images;
        this.imageActive = this.images[0];
    }
    
    //PLUSIEURS MÉTHODES DE CLASSE
    
    //retourner un district
    public void turn (Plateau plateau) {
        if (this.orientation.equals("up")){
            orientation = "down";
            personnage.setVisible(false);
            personnage.setStatut("innocent");
            imageActive = images[1];
            plateau.district[this.indice].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", this.imageActive+"_"+this.angle))));
        }
    }
    //tourner un district d'un quart de tour dans le sens horaire
    public void swapQuartHoraire(){
        boolean temp1 = (boolean) Gauche[0]; boolean temp2 = (boolean) Gauche[1];
        Gauche[0] = Haut[0]; Gauche[1] = Haut[1];
        Haut[0] = Droite[0]; Haut[1] = Droite[1];
        Droite[0] = Bas[0]; Droite[1] = Bas[1];
        Bas[0] = temp1; Bas[1] = temp2;
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
    //tourner un district d'un quart de tour dans le sens anti-horaire 
    public void swapQuartAntihoraire(){
        boolean temp1 = (boolean) Gauche[0]; boolean temp2 = (boolean) Gauche[1];
        Gauche[0] = Bas [0]; Gauche[1] = Bas [1];
        Bas[0] = Droite[0]; Bas[1] = Droite[1];
        Droite[0] = Haut[0]; Droite[1] = Haut[1];
        Haut[0] = temp1; Haut[0] = temp2;
        Haut[2]='H'; Gauche[2]='G'; Droite[2]='D'; Bas[2]='B';
        switch (this.angle) {
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

     //GETTERS ET SETTERS DE DISTRICT

    public Object[] getGauche() {
        return Gauche;
    }

    public void setGauche(Object[] gauche) {
        Gauche[0] = gauche[0];
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

    public void setImages(String image) {
        this.images[1] = image;
    }
}
