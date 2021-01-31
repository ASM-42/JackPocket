package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;

public class Plateau extends JPanel {



    public Plateau() {
        super(new BorderLayout());
        this.panelMilieu();
        this.panelGauche();
        this.panelHaut();
        this.panelDroite();
        this.panelBas();
    }

    Initialisation Jeu = new Initialisation();

    JButton[] district = new JButton[9];
    private void panelMilieu() {

        // *** CONSTRUIT L'AREA DU MILIEU
        JPanel plateauPanel = new JPanel(new GridLayout(3, 3, 0, 0));
                              //liste de 9 boutons qui correspondent aux 9 district
        for (int i = 0; i < district.length; i++) {
            district[i] = new JButton("");
            plateauPanel.add(district[i]);
            district[i].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", Jeu.districts.get(Jeu.nomsDistricts.get(i)).imageActive+"_"+Jeu.districts.get(Jeu.nomsDistricts.get(i)).getAngle()))));
        }
        this.add(plateauPanel, BorderLayout.CENTER);
    }



    // *** CONSTRUIT L'AREA DU GAUCHE ***
    JPanel detectivePanel1 = new JPanel(new GridLayout(3, 1, 0, 0));
    JButton[] detectiveVide1 = new JButton[3];
    private void panelGauche() {
        JPanel gauchePanel = new JPanel(new GridLayout());

        //panel pour les boutons jetonsTemps
        JPanel surfaceGauche = new JPanel(new GridLayout(8, 1, 0, 0));
        JButton[] jetTemps = new JButton[8];                      //liste de 8 boutons qui correspondent aux 8 jetonsTemps
        for (int i = 0; i < jetTemps.length; i++) {
            jetTemps[i] = new JButton("");
            if (i == 0) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/1.png"))); }
            if (i == 1) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/2.png"))); }
            if (i == 2) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/3.png"))); }
            if (i == 3) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/4.png"))); }
            if (i == 4) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/5.png"))); }
            if (i == 5) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/6.png"))); }
            if (i == 6) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/7.png"))); }
            if (i == 7) { jetTemps[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/8.png"))); }
            jetTemps[i].addActionListener(MrJackActionListener.createJetonTPair(jetTemps[i], Jeu, this));

            surfaceGauche.add(jetTemps[i]);
        }

        //panel pour les boutons jetDetective

        for (int i = 0; i < detectiveVide1.length; i++) {
            detectiveVide1[i] = new JButton("");
            if (i == 0) { detectiveVide1[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Holmes.png"))); }
            detectivePanel1.add(detectiveVide1[i]);
        }

        //rajouter les 2 panels créé au gauchePanel
        gauchePanel.add(surfaceGauche);
        gauchePanel.add(detectivePanel1);
        this.add(gauchePanel, BorderLayout.LINE_START);
    }


    // *** CONSTRUIT L'AREA EN HAUT ***
    JPanel detectivePanel2 = new JPanel(new GridLayout(1, 3, 0, 0));
    JButton[] detectiveVide2 = new JButton[3];
    private void panelHaut() {

        for (int i = 0; i < detectiveVide2.length; i++) {
            detectiveVide2[i] = new JButton("");
            detectiveVide2[i].setPreferredSize(new Dimension(40, 40));
            detectivePanel2.add(detectiveVide2[i]);
        }
        this.add(detectivePanel2, BorderLayout.PAGE_START);
    }


    // *** CONSTRUIT L'AREA À DROITE ***
    JPanel detectivePanel3 = new JPanel(new GridLayout(3, 1, 0, 0));
    JButton[] detectiveVide3 = new JButton[3];
    JPanel surfaceDroite = new JPanel(new GridLayout(4, 1, 0, 0));
    JButton[] jetAction = new JButton[4];
    private void panelDroite() {
        JPanel droitePanel = new JPanel(new GridLayout());

        //panel pour les boutons jetDetective

        for (int i = 0; i < detectiveVide3.length; i++) {
            detectiveVide3[i] = new JButton("");
            if (i == 0) {
                detectiveVide3[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Watson.png")));
            }
            detectivePanel3.add(detectiveVide3[i]);
        }

        //panel pour les jetAction
//        JPanel surfaceDroite = new JPanel(new GridLayout(4, 1, 0, 0));

        for (int i = 0; i < jetAction.length; i++) {
            jetAction[i] = new JButton("");
            if (i == 0) { jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/PiocheAlibi.png")).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT))); }
            if (i == 1) { jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/BougerToby.png")).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT))); }
            if (i == 2) { jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Joker.png")).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT))); }
            if (i == 3) { jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png")).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT))); }
            surfaceDroite.add(jetAction[i]);
        }

        //rajouter les 3 panels créés au droitePanel
        droitePanel.add(detectivePanel3);
        droitePanel.add(surfaceDroite);
        this.add(droitePanel, BorderLayout.LINE_END);
    }


    // *** CONSTRUIT L'AREA EN BAS ***
    JPanel detectivePanel4 = new JPanel(new GridLayout(1, 3, 0, 0));
    JButton[] detectiveVide4 = new JButton[3];
    private void panelBas() {

        for (int i = 0; i < detectiveVide4.length; i++) {
            detectiveVide4[i] = new JButton("");
            if (i == 1) {
                detectiveVide4[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")));
            }
            detectivePanel4.add(detectiveVide4[i]);
        }
        this.add(detectivePanel4, BorderLayout.PAGE_END);
    }
}

