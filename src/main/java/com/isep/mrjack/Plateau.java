package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class Plateau extends JPanel {


    public Plateau() {
        super(new BorderLayout());
        this.panelMilieu();
        this.panelGauche();
        this.panelHaut();
        this.panelDroite();
        this.panelBas();
    }


    private void panelMilieu() {

        // *** CONSTRUIT L'AREA DU MILIEU
        JPanel plateauPanel = new JPanel(new GridLayout(3, 3, 0, 0));

        JButton[] district = new JButton[9];                      //liste de 9 boutons qui correspondent aux 9 district
        for (int i = 0; i < district.length; i++) {
            district[i] = new JButton("");
            plateauPanel.add(district[i]);
            //ImageIcon icon = new ImageIcon(new ImageIcon("tonImage.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

            if (i == 0) {
                district[i].setBounds(0,0,10,10);
                district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/J_Bert.png")));
            }
            if (i == 1) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/J_Bert.png")));
                //district[i].setSize(new Dimension(20,20));
            }
            if (i == 2) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/M_Stealthy.png"))); }
            if (i == 3) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/J_Smith.png"))); }
            if (i == 4) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/J_Pizzer.png"))); }
            if (i == 5) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/I_Lestrada.png"))); }
            if (i == 6) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/J_lane.png"))); }
            if (i == 7) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/Madame.png"))); }
            if (i == 8) { district[i].setIcon(new ImageIcon(getClass().getResource("/images/district/S_Goodley.png"))); }

            district[i].addActionListener(MrJackActionListener.createReturnDistrictAL(district[i]));
        }

        this.add(plateauPanel, BorderLayout.CENTER);
    }



    // *** CONSTRUIT L'AREA DU GAUCHE ***
    // *** CONSTRUIT L'AREA EN BAS ***
    JPanel detectivePanel1 = new JPanel(new GridLayout(1, 3, 0, 0));
    JButton[] detectiveVide1 = new JButton[3];
    private void panelGauche() {
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
            surfaceGauche.add(jetTemps[i]);
        }

        //Detective


        for (int i = 0; i < detectiveVide1.length; i++) {
            detectiveVide1[i] = new JButton("");
            if (i == 2) {
                detectiveVide1[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")));
            }
            detectivePanel1.add(detectiveVide1[i]);
        }
        this.add(detectivePanel1, BorderLayout.LINE_START);
        this.add(surfaceGauche);
    }

    // *** CONSTRUIT L'AREA EN HAUT ***
    JPanel detectivePanel2 = new JPanel(new GridLayout(1, 3, 0, 0));
    JButton[] detectiveVide2 = new JButton[3];
    private void panelHaut() {

        for (int i = 0; i < detectiveVide2.length; i++) {
            detectiveVide2[i] = new JButton("");
            if (i == 2) {
                detectiveVide2[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")));
            }
            detectivePanel2.add(detectiveVide2[i]);
        }
        this.add(detectivePanel2, BorderLayout.PAGE_START);
    }

    // *** CONSTRUIT L'AREA À DROITE ***
    JPanel detectivePanel3 = new JPanel(new GridLayout(1, 3, 0, 0));
    JButton[] detectiveVide3 = new JButton[3];
    private void panelDroite() {

        for (int i = 0; i < detectiveVide3.length; i++) {
            detectiveVide3[i] = new JButton("");
            if (i == 2) {
                detectiveVide3[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")));
            }
            detectivePanel3.add(detectiveVide3[i]);
        }

        //panel pour les jetAction
        JPanel surfaceDroite = new JPanel(new GridLayout(4, 1, 0, 0));
        JButton[] jetAction = new JButton[4];
        for (int i = 0; i < jetAction.length; i++) {
            jetAction[i] = new JButton("");
            if (i == 0) { jetAction[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_action/Alibi.png"))); }
            if (i == 1) { jetAction[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_action/Echange.png"))); }
            if (i == 2) { jetAction[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_action/Joker.png"))); }
            if (i == 3) { jetAction[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png"))); }
            surfaceDroite.add(jetAction[i]);
        }

        //panel pour la pioche
        JPanel piochePanel = new JPanel(new GridLayout(3, 1, 0, 0));
        JButton Alibi = new JButton("Pioche un Alibi");
        piochePanel.add(Alibi);


        this.add(detectivePanel3, BorderLayout.LINE_END);
        this.add(surfaceDroite);
        this.add(piochePanel);
    }

    // *** CONSTRUIT L'AREA EN BAS ***
    JPanel detectivePanel4 = new JPanel(new GridLayout(1, 3, 0, 0));
    JButton[] detectiveVide4 = new JButton[3];
    private void panelBas() {

        for (int i = 0; i < detectiveVide4.length; i++) {
            detectiveVide4[i] = new JButton("");
            if (i == 2) {
                detectiveVide4[i].setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")));
            }
            detectivePanel4.add(detectiveVide4[i]);
        }
        this.add(detectivePanel4, BorderLayout.PAGE_END);

    }
}

