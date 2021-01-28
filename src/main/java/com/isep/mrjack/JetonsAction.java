package com.isep.mrjack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class JetonsAction {
    Initialisation jeu;
    Plateau plateau;
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

    public void bougerSherlock (Player player) {
        String[] place = new String[]{"Coco", "2"};
        String reponse1 = (String) JOptionPane.showInputDialog(null,
                "De combien de case souhaitez vous déplacer Sherlock?",
                "BougerToby",
                JOptionPane.QUESTION_MESSAGE, null, place, "Choisissez parmis les choix ci-dessous");

        if (reponse1.equals("Coco")){
            MoveDetective1(jeu.joueurE.getSherlock());
        }
        if (reponse1.equals("2")){
            MoveDetective2(jeu.joueurE.getSherlock());
        }
    }

    public void bougerToby (Player player) {
        String[] place = new String[]{"1", "2"};
        System.out.println("here1");
        String reponse1 = (String) JOptionPane.showInputDialog(null,
                "De combien de case souhaitez vous déplacer Toby?",
                "BougerToby",
                JOptionPane.QUESTION_MESSAGE, null, place, "Choisissez parmis les choix ci-dessous");
        System.out.println("here2");

        if (reponse1.equals("1")){
            MoveDetective1(jeu.joueurE.getToby());
        }
        if (reponse1.equals("2")){
            MoveDetective2(jeu.joueurE.getToby());
        }
    }

    public void bougerWatson (Player player) {
        System.out.println("Ayo");
        Object[] options = {"Yes, please",
                "No way!"};
        int reponse1 = JOptionPane.showOptionDialog(plateau,
                "Would you like green eggs and ham?",
                "A Silly Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == 1){
            MoveDetective1(jeu.joueurE.getWaston());
        }
        if (reponse1 == 2){
            MoveDetective2(jeu.joueurE.getWaston());
        }
    }

    public void MoveDetective1 (PersonnageDetective detective){
        District[] district = jeu.districts.values().toArray(new District[9]);
        District d = jeu.districts.get(detective.getPositionDetective().get(0));
        ArrayList<String> side = (ArrayList<String>) detective.getPositionDetective().get(1);
        //JButton place = new JButton();
        System.out.println("here3");

        //Si le detective est à gauche
        if (side.get(2).equals('G')){
            if (d == district[0]){
                plateau.detectiveVide1[0].setIcon(null);
                detective.setPositionDetective1(d.getHaut());
                plateau.detectiveVide2[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
                //plateau.detectivePanel1.add(place);
            }
            if (d == district[3]){
                plateau.detectiveVide1[1].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(0));
                plateau.detectiveVide1[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[6]){
                plateau.detectiveVide1[2].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(3));
                plateau.detectiveVide1[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
        //Si le detective est en haut
        if (side.get(2).equals('H')){
            if (d == district[0]){
                plateau.detectiveVide2[0].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(1));
                plateau.detectiveVide2[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[1]){
                plateau.detectiveVide2[1].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(2));
                plateau.detectiveVide2[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[2]){
                plateau.detectiveVide2[2].setIcon(null);
                detective.setPositionDetective1(d.getDroite());
                plateau.detectiveVide3[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
        //Si le detective est à droite
        if (side.get(2).equals('D')){
            if (d == district[2]){
                plateau.detectiveVide3[0].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(1));
                plateau.detectiveVide3[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[5]){
                plateau.detectiveVide3[1].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(2));
                plateau.detectiveVide3[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[8]){
                plateau.detectiveVide3[2].setIcon(null);
                detective.setPositionDetective1(d.getDroite());
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
        //Si le detective est en bas
        if (side.get(2).equals('B')){
            if (d == district[8]){
                plateau.detectiveVide4[2].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(7));
                plateau.detectiveVide4[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[7]){
                plateau.detectiveVide4[1].setIcon(null);
                detective.setPositionDetective0(jeu.districts.get(6));
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[6]){
                plateau.detectiveVide4[0].setIcon(null);
                detective.setPositionDetective1(d.getGauche());
                plateau.detectiveVide1[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
    }
    public void MoveDetective2 (PersonnageDetective detective){
        District[] district = jeu.districts.values().toArray(new District[9]);
        District d = jeu.districts.get(detective.getPositionDetective().get(0));
        ArrayList<String> side = (ArrayList<String>) detective.getPositionDetective().get(1);
        //JButton place = new JButton();

        //Si le detective est à gauche
        if (side.get(2).equals('G')){
            if (d == district[0]){
                plateau.detectiveVide1[0].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(1), jeu.districts.get(1).getHaut())));
                plateau.detectiveVide2[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
                //plateau.detectivePanel1.add(place);
            }
            if (d == district[3]){
                plateau.detectiveVide1[1].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(0), jeu.districts.get(0).getHaut())));
                plateau.detectiveVide2[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[6]){
                plateau.detectiveVide1[2].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(0), jeu.districts.get(0).getGauche())));
                plateau.detectiveVide1[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
        //Si le detective est en haut
        if (side.get(2).equals('H')){
            if (d == district[0]){
                plateau.detectiveVide2[0].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getHaut())));
                plateau.detectiveVide2[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[1]){
                plateau.detectiveVide2[1].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(2), jeu.districts.get(2).getDroite())));
                plateau.detectiveVide3[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[2]){
                plateau.detectiveVide2[2].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(5), jeu.districts.get(5).getDroite())));
                plateau.detectiveVide3[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
        //Si le detective est à droite
        if (side.get(2).equals('D')){
            if (d == district[2]){
                plateau.detectiveVide3[0].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(8), jeu.districts.get(8).getDroite())));
                plateau.detectiveVide3[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[5]){
                plateau.detectiveVide3[1].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(8), jeu.districts.get(8).getBas())));
                plateau.detectiveVide4[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[8]){
                plateau.detectiveVide3[2].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(7), jeu.districts.get(7).getBas())));
                plateau.detectiveVide4[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
        //Si le detective est en bas
        if (side.get(2).equals('B')){
            if (d == district[8]){
                plateau.detectiveVide4[2].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(6), jeu.districts.get(6).getBas())));
                plateau.detectiveVide4[0].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[7]){
                plateau.detectiveVide4[1].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(6), jeu.districts.get(6).getGauche())));
                plateau.detectiveVide1[2].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
            if (d == district[6]){
                plateau.detectiveVide4[0].setIcon(null);
                detective.setPositionDetective(new ArrayList<>(Arrays.asList(jeu.districts.get(3), jeu.districts.get(3).getGauche())));
                plateau.detectiveVide1[1].setIcon(new ImageIcon(getClass().getResource(String.valueOf(detective.getImage()))));
            }
        }
    }




    public void rotationDistrict () {
        String district;
        String sens;
        String tour;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println
                ("Quel com.isep.mrjack.District souhaitez-vous déplacer? (ex : D1, D2...");
        district = scanner1.next();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println
                ("Dans quel sens (horaire ou anti-horaire) souhaitez vous le deplacer ?");
        sens = scanner2.next();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println
                ("Voulez - vous le déplacer d'un quart de tour ou d'un demi tour ?");
        tour = scanner3.next();
        District d = jeu.districts.get(district);
        if (sens == "horaire") {
            if (tour == "quart") {
                d.swapQuartHoraire();
            }
            if (tour == "demi") {
                d.swapQuartHoraire();
                d.swapQuartHoraire();
            }
        }
        if (sens == "antihoraire") {
            if (tour == "quart") {
                d.swapQuartAntihoraire();
            }
            if (tour == "demi") {
                d.swapQuartAntihoraire();
                d.swapQuartAntihoraire();
            }
        }
    }
    public void echangeDistrict(){
        String district1;
        String district2;

        Scanner scanner1 = new Scanner(System.in);
        System.out.println
                ("Quel est le premier district que souhaitez-vous déplacer? (ex : D1, D2...");
        district1 = scanner1.next();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println
                ("Quel est le second district que souhaitez-vous déplacer? (ex : D1, D2...");
        district2 = scanner2.next();
        District d1 = jeu.districts.get(district1);
        District d2 = jeu.districts.get(district2);
        District temp = d1;
        jeu.districts.put(district1, d2);
        jeu.districts.put(district2, temp);
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

        public void faireAction(String typeAction1, Player player){
        if (typeAction1 == "Rotation"){
            rotationDistrict();
        }
        if (typeAction1 == "Sherlock"){
            bougerSherlock(player);
        }
        if (typeAction1 == "Watson"){
            bougerWatson(player);
        }
        if (typeAction1 == "Toby"){
            bougerToby(player);
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


    public void Action(int action, Player player) {
        if (action == 1){
            faireAction(typeAction1, player);
        }
        if (action == 2){
            faireAction(typeAction2, player);
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
