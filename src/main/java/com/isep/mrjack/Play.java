package com.isep.mrjack;

import java.util.Random;
import java.util.Scanner;

public class Play extends Initialisation {
    int tourActuel;

    public void main(String[] args) {
        Initialisation Jeu = new Initialisation();
        MrJack joueurM;
        Enqueteur joueurE;
        JetonsAction jA1;JetonsAction jA2;JetonsAction jA3; JetonsAction jA4;
        Player player1 = new Player("name", 0) {};
        Player player2 = new Player("name", 0) {};
        Scanner scanner = new Scanner(System.in);
            String reponse1;
            System.out.println("Entrez le nom du premier joueur:");
            reponse1 = scanner.next();player1.setName(reponse1);
            System.out.println("Entrez le nom du second joueur:");
            reponse1 = scanner.next();player2.setName(reponse1);
            System.out.println
                    ("Joueur 1 souhaitez vous jouer com.isep.mrjack.MrJack ou Detective ?");
            reponse1 = scanner.next();
        if (reponse1 == "com.isep.mrjack.MrJack") {
            player1.setRole(0); joueurM = player1.setRoleMrJack(player1);
            player2.setRole(1); joueurE = player2.setRoleEnqueteur(player2);
                System.out.println(player1.getName() + " vous jouez com.isep.mrjack.MrJack" + player2.getName() + " vous jouez le Detetctive");
        }else {
            player2.setRole(0); joueurM = player2.setRoleMrJack(player1);
            player1.setRole(1); joueurE = player1.setRoleEnqueteur(player2);
            System.out.println(player2.getName() + " vous jouez com.isep.mrjack.MrJack" + player1.getName() + " vous jouez le Detetctive");}
        //Quel personnage va jouer com.isep.mrjack.MrJack?
        Random random1 = new Random(); int x = random1.nextInt(Jeu.getPioche().length);
        joueurM.setCoupable(Jeu.getPioche()[x]);
        removeElement(Jeu.getPioche(), x);
        //Première étape
        for (int tour = 0; tour<9; tour++){
            Random random2 = new Random();
            int action1 = random2.nextInt(2);
            int action2 = random2.nextInt(2);
            int action3 = random2.nextInt(2);
            int action4 = random2.nextInt(2);
            if (Jeu.getJetonsTemps(tour)[1] == 1){

            }


        }






        }

    }
