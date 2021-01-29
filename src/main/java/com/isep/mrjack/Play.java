package com.isep.mrjack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Play {
    int tourActuel;

    public static void main(String[] args){
        Initialisation Jeu = new Initialisation();
        String action;
        MrJack joueurM;
        Enqueteur joueurE;
        JetonsAction jA1 = Jeu.jeton1;
        JetonsAction jA2 = Jeu.jeton2;
        JetonsAction jA3 = Jeu.jeton3; JetonsAction jA4 = Jeu.jeton4;
        JetonsAction[] jetonsActionTour = {jA1, jA2, jA3, jA4};
        Player player1 = new Player("name", 0) {};
        Player player2 = new Player("name", 0) {};
        Scanner scanner = new Scanner(System.in);
            String reponse1;
            out.println("Entrez le nom du premier joueur:");
            reponse1 = scanner.next();player1.setName(reponse1);
            out.println("Entrez le nom du second joueur:");
            reponse1 = scanner.next();player2.setName(reponse1);
            out.println
                    (player1.getName() + " souhaitez vous jouer MrJack ou Detective ?");
            reponse1 = scanner.next();
        if (reponse1 == "MrJack") {
            player1.setRole(0); joueurM = player1.setRoleMrJack(player1); joueurM.setName(player1.getName());
            player2.setRole(1); joueurE = player2.setRoleEnqueteur(player2); joueurE.setName((player2.getName()));
                out.println(player1.getName() + " vous jouez MrJack \n" + player2.getName() + " vous jouez le Detective");
        }else {
            player2.setRole(0); joueurM = player2.setRoleMrJack(player2); joueurM.setName(player2.getName());
            player1.setRole(1); joueurE = player1.setRoleEnqueteur(player1); joueurE.setName(player1.getName());
            out.println(player2.getName() + " vous jouez MrJack \n" + player1.getName() + " vous jouez le Detective");}
        //Quel personnage va jouer MrJack?
        Random random1 = new Random(); int x = random1.nextInt(Jeu.getPioche().length);
        joueurM.setCoupable(Jeu.getPioche()[x]);
        out.println("Seul " + joueurM.getName() + " à accès a cette information \n");
        out.println("Mr Jack est Madame" );
        //removeElement(Jeu.getPioche(), x);
        //Première étape
        for (int tour = 0; tour<9; tour++){
            Random random2 = new Random();
            int actionR1 = random2.nextInt(2);
            int actionR2 = random2.nextInt(2);
            int actionR3 = random2.nextInt(2);
            int actionR4 = random2.nextInt(2);
            String[] jetonsTourActions =
                    {jetonsActionTour[0].getAction1()[actionR1], jetonsActionTour[1].getAction1()[actionR2],
                            jetonsActionTour[2].getAction1()[actionR3],jetonsActionTour[3].getAction1()[actionR4]};
            //L'enqueteur commence, tours impairs
            if (Jeu.getJetonsTemps(tour)[1] == 1){
                out.println
                        ("Enqueteur choisissez une action entre. \n Rotation\nJoker\nWatson\nAlibi");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(actionR1, joueurE);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(actionR2, joueurE);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(actionR3, joueurE);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(actionR4, joueurE);}

                for(int j=0; j<3; j++) {
                    out.println
                            ("MrJack choisissez une action.");
                    action = scanner.next();
                    if (action == "Rotation") {Jeu.jeton1.faireAction("Rotation", joueurE);}
                    if (action == "jeton 2") {Jeu.jeton2.Action(actionR2, joueurM);}
                    if (action == "jeton 3") {Jeu.jeton3.Action(actionR3, joueurM);}
                    if (action == "jeton 4") {Jeu.jeton4.Action(actionR4, joueurM);}
                }
                out.println
                        ("Enqueteur choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(actionR1, joueurE);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(actionR2, joueurE);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(actionR3, joueurE);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(actionR4, joueurE);}
            }
        //MrJack commence, tours pairs
            else{if (Jeu.getJetonsTemps(tour)[1] == 0){
                out.println
                        ("Mrack choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(1-actionR1, joueurM);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(1-actionR2, joueurM);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(1-actionR3, joueurM);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(1-actionR4, joueurM);}

                for(int j=0; j<3; j++) {
                    out.println
                            ("Enqueteur choisissez une action.");
                    action = scanner.next();
                    if (action == "jeton 1") {Jeu.jeton1.Action(1-actionR1, joueurE);}
                    if (action == "jeton 2") {Jeu.jeton2.Action(1-actionR2, joueurE);}
                    if (action == "jeton 3") {Jeu.jeton3.Action(1-actionR3, joueurE);}
                    if (action == "jeton 4") {Jeu.jeton4.Action(1-actionR4, joueurE);}
                }
                out.println
                        ("MrJack choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(1-actionR1, joueurM);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(1-actionR2, joueurM);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(1-actionR3, joueurM);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(1-actionR4, joueurM);}
            }}
        //Appel a témoins
            if (joueurM.getCoupable().isVisible() == false){
                out.println("Mister Jack n'est pas visible");
                ArrayList<PersonnagePlateau> suspect = Jeu.SuspectsVisibles(joueurE);
                for (int p=0; p<suspect.size(); p++){
                   Jeu.findPersonnage(suspect.get(p)).turn();
                }
                joueurM.setNbSabliers(joueurM.getNbSabliers()+1);
            }
            else{
                out.println("Mister Jack est visible");
                ArrayList<PersonnagePlateau> suspects = Jeu.SuspectsVisibles(joueurE);
                ArrayList<PersonnagePlateau> innocents = Jeu.innocents(suspects);
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
            }

        }
        }

    }
