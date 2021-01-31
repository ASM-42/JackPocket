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
        JButton button1 = new JButton();
        button1.setBackground(Color.white);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        parent.setLocation(dim.width/2-parent.getSize().width/2, dim.height/2-parent.getSize().height/2);



        button1.setText("<HTML>Bienvenue dans notre version (presque complète) du Jeu Mr Jack Pocket <P>"+"  Lancer une partie <P> <P> <P> Par Amandine, Solène et Safia");
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
                            Jeu.joueurM.getName() + " vous jouez MrJack, et "
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
        //MrJackActionListener

    }
}

