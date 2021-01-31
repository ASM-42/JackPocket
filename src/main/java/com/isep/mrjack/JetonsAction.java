package com.isep.mrjack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class JetonsAction {
    Initialisation jeu;
    public String typeAction1;
    public String typeAction2;
    public String image1;
    public String image2;
    public String[] action1 = new String[]{typeAction1, typeAction2};
    public String[] action2 = new String[]{image1, image2};



    public JetonsAction(String[] action1, String[] action2, Initialisation jeu) {
        this.jeu = jeu;
        this.action1 = action1;
        this.action2 = action2;
        this.typeAction1 = action1[0]; this.image1 = action2[0];
        this.typeAction2 = action1[1]; this.image2 = action2[1];
    }

    public void piocherAlibi (Player joueur){
        MrJack joueurM = (MrJack) joueur;
        PersonnagePlateau carte = jeu.personnages.get(jeu.pioche.get(0));
        if (joueur.getRole() == 0){
            piocherAlibiMrJack(joueurM, carte); }
        else {
            carte.setStatut("innocent");
            jeu.findPersonnage(carte).turn();
        }
        jeu.pioche.remove(0);
    }

    public void piocherAlibiMrJack(MrJack joueurM, PersonnagePlateau personnagePlateau){
        joueurM.setNbSabliers(
                joueurM.getNbSabliers() + personnagePlateau.getSabliers());
    }

    public void bougerSherlock (Player player, Plateau plateau) {
        Object[] options = {1,2};
        int reponse1 = (int) JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Sherlock?",
                "BougerWatson",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION){
            jeu.joueurE.getSherlock().MoveDetective1(jeu.joueurE.getSherlock(), plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION){
            jeu.joueurE.getSherlock().MoveDetective2(jeu.joueurE.getSherlock().getPositionDetective(), plateau);
        }
    }

    public void bougerToby (Player player, Plateau plateau) {
        Object[] options = {1, 2};
        int reponse1 = (int) JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Toby?",
                "BougerWatson",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION){
            jeu.joueurE.getToby().MoveDetective1(jeu.joueurE.getToby(), plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION){
            jeu.joueurE.getToby().MoveDetective2(jeu.joueurE.getToby().getPositionDetective(), plateau);
        }
    }

    public void bougerWatson (Player player, Plateau plateau) {
        Object[] options = {'1', '2'};
        char reponse1 = (char) JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Watson?",
                "BougerWatson",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION){
            jeu.joueurE.getWaston().MoveDetective1(jeu.joueurE.getWaston(), plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION){
            jeu.joueurE.getWaston().MoveDetective2(jeu.joueurE.getWaston().getPositionDetective(), plateau);
        }
    }



    public void rotationDistrict (Plateau plateau) {
        Object[] options = {"D1","D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        String d1= (String) JOptionPane.showInputDialog(null,
                 " Quel District souhaitez-vous déplacer?",
                "Joueurs", JOptionPane. QUESTION_MESSAGE, null, options, options[0]);
        Object[] options2 = {"Horaire", "Anti-Horaire"};
        String sens = (String) JOptionPane.showInputDialog(null,
                "Dans quel sens (horaire ou anti-horaire) souhaitez vous le deplacer ?",
                "Rotation", JOptionPane. QUESTION_MESSAGE, null, options2, options2[0]);
        Object[] options3 = {"Quart de Tour", "Demi Tour"};
        String choixSens = (String) JOptionPane.showInputDialog(null,
                "Voulez - vous le déplacer d'un quart de tour ou d'un demi tour ?",
                "Rotation", JOptionPane. QUESTION_MESSAGE, null, options3, options3[0]);
        District d = jeu.districts.get(d1);
        if (sens == "Horaire") {
            if (choixSens == "Quart de Tour") {
                d.swapQuartHoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
            if (choixSens == "Demi Tour") {
                d.swapQuartHoraire(); d.swapQuartHoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
        }
        if (sens == "Anti-Horaire") {
            if (choixSens == "Quart de Tour") {
                d.swapQuartAntihoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
            if (choixSens == "Demi Tour") {
                d.swapQuartAntihoraire();d.swapQuartAntihoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
        }
    }
    public void echangeDistrict(){
        Object[] options = {"D1","D2", "D3", "D4", "D4", "D5", "D6", "D7", "D8", "D9"};
        String d1= (String) JOptionPane.showInputDialog(null,
                " Quel District souhaitez-vous déplacer?",
                "Joueurs", JOptionPane. QUESTION_MESSAGE, null, options, options[0]);
        String d2= (String) JOptionPane.showInputDialog(null,
                " Quel District souhaitez-vous déplacer?",
                "Joueurs", JOptionPane. QUESTION_MESSAGE, null, options, options[0]);
        District temp = jeu.districts.get(d1);
        jeu.districts.replace(d1, jeu.districts.get(d2));
        jeu.districts.replace(d2, temp);



    }
    public void Joker (Player player) {
        String reponse1;
        String reponse2;
        Scanner scanner = new Scanner (System.in);
/*
        if (player.getRole() == 1) //Detective

            System.out.println ("Quel detective voulez vous déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            player.getSherlock().MoveDetective1(joueurE.getSherlock());
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock);
        if (reponse1.equals("Toby"))
            Toby.MoveDetective1(Toby);

        if (player.getRole() == 0) //com.isep.mrjack.MrJack
            System.out.println ("Voulez vous déplacer un detective, si non tapez non si oui tapez le nom du detective à déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            Watson.MoveDetective1(Watson);
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock);
        if (reponse1.equals("Toby"))
            Toby.MoveDetective1(Toby);

*/
    }

        public void faireAction(String typeAction1, Player player, Plateau plateau){
        if (typeAction1 == "Rotation"){
            rotationDistrict(plateau);
        }
        if (typeAction1 == "Sherlock"){
            bougerSherlock(player, plateau);
        }
        if (typeAction1 == "Watson"){
            bougerWatson(player, plateau);
        }
        if (typeAction1 == "Toby"){
            bougerToby(player, plateau);
        }
        if (typeAction1 == "Echange"){
            echangeDistrict();
        }
        if (typeAction1 == "Joker"){
            Joker(player);
        }
    }


    public String getTypeAction1() {
        return typeAction1;
    }

    public String quelleAction(int r){
        if (r==1){
            return action1[0];
        }
        return action1[1];
    }

    public String quelleActionImage(int r){
        if (r==1){
            return action2[0];
        }
        return action2[1];
    }


    public void Action(int action, Player player, Plateau plateau) {
        if (action == 1){
            faireAction(typeAction1, player, plateau);
        }
        if (action == 2){
            faireAction(typeAction2, player, plateau);
        }}

    public void setTypeAction1(String typeAction1) {
        this.typeAction1 = typeAction1;
    }

    public String getTypeAction2() {
        return typeAction2;
    }

    public void setTypeAction2(String typeAction2) {
        this.typeAction2 = typeAction2;
    }

    public void setJeu(Initialisation jeu) {
        this.jeu = jeu;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String[] getAction1() {
        return action1;
    }

    public void setAction1(String[] action1) {
        this.action1 = action1;
    }

    public String[] getAction2() {
        return action2;
    }

    public void setAction2(String[] action2) {
        this.action2 = action2;
    }
}
