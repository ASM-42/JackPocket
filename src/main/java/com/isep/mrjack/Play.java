package com.isep.mrjack;


import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.out;

public class Play {
    int tourActuel;

    public static void main(String[] args){

        //GRAPHIQUE
        MonJeu jeu = new MonJeu();
        jeu.setSize(new Dimension(1080, 650)); //(largeur, hauteur)
        jeu.initJeu();
        jeu.setVisible(true);

        MonInteraction interaction = new MonInteraction();
        interaction.setSize(new Dimension(400, 1000));
        interaction.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        interaction.setLocation((3*dim.width/4)-39,1);
        interaction.texte.setText("Bonjour");





        Initialisation Jeu = new Initialisation();
        String action;
        MrJack joueurM;
        Enqueteur joueurE;
        JetonsAction jA1 = Jeu.jeton1;
        JetonsAction jA2 = Jeu.jeton2;
        JetonsAction jA3; JetonsAction jA4;
        Player player1 = new Player("name", 0) {};
        Player player2 = new Player("name", 0) {};


        interaction.setMod("Entrez le nom du premier joueur:");
        out.println("Je suis la");
        interaction.zoneEcriture.setText("ex: Amandine");
        player1.setName(interaction.input);
        interaction.setMod("Entrez le nom du second joueur:");
        player2.setName(interaction.input);
        interaction.setMod
           (player1.getName() + " souhaitez vous jouer MrJack ou Detective ?");
        if (interaction.input == "MrJack") {
            player1.setRole(0); joueurM = player1.setRoleMrJack(player1);
            player2.setRole(1); joueurE = player2.setRoleEnqueteur(player2);
            interaction.setMod(player1.getName() + " vous jouez MrJack " + player2.getName() + " vous jouez le Detetctive");
        }
        else {
            player2.setRole(0); joueurM = player2.setRoleMrJack(player1);
            player1.setRole(1); joueurE = player1.setRoleEnqueteur(player2);
            interaction.setMod(player2.getName() + " vous jouez MrJack1 " + player1.getName() + " vous jouez le Detetctive");}
        //Quel personnage va jouer MrJack?
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int x = rnd.nextInt(Jeu.pioche.size());
        joueurM.setCoupable(Jeu.personnages.get(Jeu.pioche.get(x)));
        //removeElement(Jeu.getPioche(), x);
        //Première étape
        for (int tour = 0; tour<9; tour++){
            Random random2 = new Random();
            int action1 = random2.nextInt(2);
            int action2 = random2.nextInt(2);
            int action3 = random2.nextInt(2);
            int action4 = random2.nextInt(2);
            //L'enqueteur commence, tours impairs*

            /*
            if (Jeu.getJetonsTemps(tour)[1] == 1){
                interaction.texte.setText
                        ("Enqueteur choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(action1, joueurE);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(action2, joueurE);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(action3, joueurE);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(action4, joueurE);}

                for(int j=0; j<3; j++) {
                    interaction.texte.setText
                            ("MrJack choisissez une action.");
                    action = scanner.next();
                    if (action == "jeton 1") {Jeu.jeton1.Action(action1, joueurM);}
                    if (action == "jeton 2") {Jeu.jeton2.Action(action2, joueurM);}
                    if (action == "jeton 3") {Jeu.jeton3.Action(action3, joueurM);}
                    if (action == "jeton 4") {Jeu.jeton4.Action(action4, joueurE);}
                }
                interaction.texte.setText
                        ("Enqueteur choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(action1, joueurE);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(action2, joueurE);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(action3, joueurE);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(action4, joueurE);}
            }
        //MrJack commence, tours pairs
            else{if (Jeu.getJetonsTemps(tour)[1] == 0){
                interaction.texte.setText
                        ("Mrack choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(1-action1, joueurM);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(1-action2, joueurM);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(1-action3, joueurM);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(1-action4, joueurM);}

                for(int j=0; j<3; j++) {
                    interaction.texte.setText
                            ("Enqueteur choisissez une action.");
                    action = scanner.next();
                    if (action == "jeton 1") {Jeu.jeton1.Action(1-action1, joueurE);}
                    if (action == "jeton 2") {Jeu.jeton2.Action(1-action2, joueurE);}
                    if (action == "jeton 3") {Jeu.jeton3.Action(1-action3, joueurE);}
                    if (action == "jeton 4") {Jeu.jeton4.Action(1-action4, joueurE);}
                }
                interaction.texte.setText
                        ("MrJack choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(1-action1, joueurM);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(1-action2, joueurM);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(1-action3, joueurM);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(1-action4, joueurM);}
            }}
        //Appel a témoins
            if (joueurM.getCoupable().isVisible() == false){
                interaction.texte.setText("Mister Jack n'est pas visible");
                ArrayList<PersonnagePlateau> suspect = Jeu.SuspectsVisibles(joueurE);
                for (int p=0; p<suspect.size(); p++){
                   Jeu.findPersonnage(suspect.get(p)).turn();
                }
                joueurM.setNbSabliers(joueurM.getNbSabliers()+1);
            }
            else{
                interaction.texte.setText("Mister Jack est visible");
                ArrayList<PersonnagePlateau> suspects = Jeu.SuspectsVisibles(joueurE);
                List<PersonnagePlateau> innocents = Jeu.innocents(suspects);
                for (int i=0; i<innocents.size(); i++){
                    Jeu.findPersonnage(innocents.get(i)).turn();
                }
            }
            if (joueurM.getNbSabliers() == 6){
                out.printf(joueurM.getName() + "a gagné en jouant MrJack");
                break;
            }
            if (Jeu.innocents(Jeu.SuspectsVisibles(joueurE)).size() == 8){
                out.printf(joueurE + "a gagné en jouant l'enqueteur");
                break;
            }*/

        }
        }
        }
