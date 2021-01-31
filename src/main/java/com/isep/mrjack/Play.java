package com.isep.mrjack;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

import static java.lang.System.out;

public class Play {
    int tourActuel;

    public static void main(String[] args){

        Plateau plateau = new Plateau();
        Initialisation Jeu = plateau.Jeu;
        String action;
        JetonsAction jA1 = Jeu.jeton1;
        JetonsAction jA2 = Jeu.jeton2;
        JetonsAction jA3; JetonsAction jA4;
        Player player1 = new Player("name", 0) {};
        Player player2 = new Player("name", 0) {};
        String[] roles = new String[]{"MrJack", "Enqueteur"};
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int coupable = rnd.nextInt(Jeu.pioche.size());


        //GRAPHIQUE
        JFrame parent = new JFrame();
        parent.setAlwaysOnTop(true);
        //parent.setSize(400, 1000);
        JButton button1 = new JButton();



        button1.setText("Lancer une partie");
        parent.add(button1);
        //parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.setContentPane(button1);
        parent.pack();
        parent.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                parent.dispose();

                String nomJoueur1 = JOptionPane.showInputDialog(
                        "Entrez le nom du premier joueur:", "Joueur1");
                player1.setName(nomJoueur1);
                String nomJoueur2 = JOptionPane.showInputDialog
                        ("Entrez le nom du second joueur:", "Joueur2");
                player2.setName(nomJoueur2);


                String role = (String) JOptionPane.showInputDialog(null,
                        player1.getName()+ " souhaitez vous jouer MrJack ou Detective ?",
                        "Joueurs", JOptionPane. QUESTION_MESSAGE, null, roles, roles[0]);

                if (role == "MrJack") {
                    player1.setRole(0);
                    player2.setRole(1);
                    Jeu.joueurM.setName(player1.getName());
                    Jeu.joueurE.setName(player2.getName());
                    JOptionPane.showMessageDialog(null,
                            player1.getName() + " vous jouez MrJack, et "
                                    + player2.getName() + " vous jouez l'enqueteur",
                            "Joueurs",
                            JOptionPane.PLAIN_MESSAGE);
                }if (role == "Enqueteur"){
                    player2.setRole(0);
                    player1.setRole(1);
                    Jeu.joueurM.setName(player2.getName());
                    Jeu.joueurE.setName(player1.getName());
                    JOptionPane.showMessageDialog(null,
                            player2.getName() + " vous jouez MrJack, et "
                                    + player1.getName() + " vous jouez l'enqueteur",
                            "Joueurs",
                            JOptionPane.PLAIN_MESSAGE);
                }


                JOptionPane.showMessageDialog(null,
                        "Le jeu va commencer, nous attribuons à un personnage aléatoire à Mr Jack",
                        "Play",
                        JOptionPane.PLAIN_MESSAGE);

                JOptionPane.showMessageDialog(null,
                        "Seul MrJack ne peux avoir accès à l'information suivante",
                        "Play",
                        JOptionPane.PLAIN_MESSAGE);

                //Quel personnage va jouer MrJack?

                JOptionPane.showMessageDialog(null,
                        "Vous êtes " + Jeu.pioche.get(coupable),
                        "Mr Jack",
                        JOptionPane.PLAIN_MESSAGE,
                        new ImageIcon(new ImageIcon(getClass().getResource(String.format("/images/cartes_alibi/%s.png", Jeu.personnages.get(Jeu.pioche.get(coupable)).carte))).getImage().getScaledInstance(70,130, Image.SCALE_DEFAULT))
                );
                Jeu.joueurM.setCoupable(Jeu.personnages.get(Jeu.pioche.get(coupable)));
                Jeu.pioche.remove(coupable);

                MonJeu jeu = new MonJeu();
                jeu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jeu.setSize(new Dimension(1080, 650)); //(largeur, hauteur)
                jeu.initJeu();
                jeu.setVisible(true);

                JOptionPane.showMessageDialog(null,
                        "Veuillez cliquer sur le premier jeton temps",
                        "Mr Jack",
                        JOptionPane.PLAIN_MESSAGE);

            }
        });



        //Première étape
        for (int tour = 0; tour<9; tour++){
            Random random2 = new Random();
            int actionR1 = random2.nextInt(2);
            int actionR2 = random2.nextInt(2);
            int actionR3 = random2.nextInt(2);
            int actionR4 = random2.nextInt(2);


            /*String[][] jetonsTour =
                    new String[][]{Jeu.jeton1.quelleAction(actionR1), Jeu.jeton2.quelleAction(actionR2),
                            Jeu.jeton4.quelleAction(actionR3),Jeu.jeton4.quelleAction(actionR4),};


            String s = (String)JOptionPane.showInputDialog(null,
                    "Quelle action souhaitez vous jouer",
                    "Action Detective",
                    JOptionPane.QUESTION_MESSAGE, null, jetonsTour, jetonsTour[0]);
*/
            //L'enqueteur commence, tours impairs*

            /*
            if (Jeu.getJetonsTemps(tour)[1] == 1){
                interaction.texte.setText
                        ("Enqueteur choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(action1, //joueurE);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(action2, //joueurE);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(action3, //joueurE);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(action4, //joueurE);}

                for(int j=0; j<3; j++) {
                    interaction.texte.setText
                            ("MrJack choisissez une action.");
                    action = scanner.next();
                    if (action == "jeton 1") {Jeu.jeton1.Action(action1, joueurM);}
                    if (action == "jeton 2") {Jeu.jeton2.Action(action2, joueurM);}
                    if (action == "jeton 3") {Jeu.jeton3.Action(action3, joueurM);}
                    if (action == "jeton 4") {Jeu.jeton4.Action(action4, //joueurE);}
                }
                interaction.texte.setText
                        ("Enqueteur choisissez une action.");
                action = scanner.next();
                if (action == "jeton 1"){ Jeu.jeton1.Action(action1, //joueurE);}
                if (action == "jeton 2"){ Jeu.jeton2.Action(action2, //joueurE);}
                if (action == "jeton 3"){ Jeu.jeton3.Action(action3, //joueurE);}
                if (action == "jeton 4"){ Jeu.jeton4.Action(action4, //joueurE);}
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
                    if (action == "jeton 1") {Jeu.jeton1.Action(1-action1, //joueurE);}
                    if (action == "jeton 2") {Jeu.jeton2.Action(1-action2, //joueurE);}
                    if (action == "jeton 3") {Jeu.jeton3.Action(1-action3, //joueurE);}
                    if (action == "jeton 4") {Jeu.jeton4.Action(1-action4, //joueurE);}
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
                ArrayList<PersonnagePlateau> suspect = Jeu.SuspectsVisibles(//joueurE);
                for (int p=0; p<suspect.size(); p++){
                   Jeu.findPersonnage(suspect.get(p)).turn();
                }
                joueurM.setNbSabliers(joueurM.getNbSabliers()+1);
            }
            else{
                interaction.texte.setText("Mister Jack est visible");
                ArrayList<PersonnagePlateau> suspects = Jeu.SuspectsVisibles(//joueurE);
                List<PersonnagePlateau> innocents = Jeu.innocents(suspects);
                for (int i=0; i<innocents.size(); i++){
                    Jeu.findPersonnage(innocents.get(i)).turn();
                }
            }
            if (joueurM.getNbSabliers() == 6){
                out.printf(joueurM.getName() + "a gagné en jouant MrJack");
                break;
            }
            if (Jeu.innocents(Jeu.SuspectsVisibles(//joueurE)).size() == 8){
                out.printf(//joueurE + "a gagné en jouant l'enqueteur");
                break;
            }*/

        }
        }
        }
