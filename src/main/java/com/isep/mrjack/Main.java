package com.isep.mrjack;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String args[]) {

        MonJeu jeu = new MonJeu();
        jeu.setSize(new Dimension(1080, 650)); //(largeur, hauteur)
        jeu.initJeu();
        jeu.setVisible(true);

        MonInteraction interaction = new MonInteraction();
        interaction.setSize(new Dimension(400, 1000));
        interaction.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        interaction.setLocation(3*dim.width/4,1);
        interaction.initInteraction();


        Player player1 = new Player("name", 0) {};
        Player player2 = new Player("name", 0) {};
        String reponse1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du premier joueur:");
        reponse1 = scanner.next();player1.setName(reponse1);
        System.out.println("Entrez le nom du second joueur:");
        reponse1 = scanner.next();player2.setName(reponse1);
        System.out.println
                ("Joueur 1 souhaitez vous jouer com.isep.mrjack.MrJack ou Detective ?");
        reponse1 = scanner.next();
        if (reponse1 == "com.isep.mrjack.MrJack") {
            player1.setRole(0);player2.setRole(1);
            System.out.println(player1.getName() + "vous jouez com.isep.mrjack.MrJack" + player2.getName() + "vous jouez le Detetctive");
        }else {
            player1.setRole(1);player2.setRole(0);
            System.out.println(player2.getName() + "vous jouez com.isep.mrjack.MrJack" + player1.getName() + "vous jouez le Detetctive");}




//Création des cartes personnages et de la pioche
        PersonnagePlateau Madame = new PersonnagePlateau(2);
        PersonnagePlateau JohnPizer = new PersonnagePlateau(1);
        PersonnagePlateau JeremyBert = new PersonnagePlateau(1);
        PersonnagePlateau InspLestrade = new PersonnagePlateau(0);
        PersonnagePlateau WilliamGull = new PersonnagePlateau(1);
        PersonnagePlateau JosephLane = new PersonnagePlateau(1);
        PersonnagePlateau JohnSmith = new PersonnagePlateau(1);
        PersonnagePlateau SgtGoodley = new PersonnagePlateau(0);
        PersonnagePlateau MissStealthy = new PersonnagePlateau(1);
        ArrayList<PersonnagePlateau> pioche = new ArrayList<>();
        pioche.add(Madame);
        pioche.add(JohnPizer);
        pioche.add(JeremyBert);
        pioche.add(InspLestrade);
        pioche.add(WilliamGull);
        pioche.add(JosephLane);
        pioche.add(JohnSmith);
        pioche.add(SgtGoodley);
        pioche.add(MissStealthy);

//Creéation et com.isep.mrjack.Initialisation des jetons Actions
//        JetonsAction jeton1 = new JetonsAction("Sherlock", "Carte Alibi");
//        JetonsAction jeton2 = new JetonsAction("Watson", "Tobby");
//        JetonsAction jeton3 = new JetonsAction("Rotation", "Joker");
//        JetonsAction jeton4 = new JetonsAction("Rotation", "Echange");


    }

}
