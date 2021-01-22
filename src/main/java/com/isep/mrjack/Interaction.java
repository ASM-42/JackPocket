package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interaction extends JPanel {


    public Interaction() {
        super(new GridLayout());
        this.fenetreInteraction();
    }

    public void fenetreInteraction() {

        JPanel hautPanel = new JPanel(); //(new GridLayout(8, 9));
        hautPanel.setLayout(null);
        JButton btnMrJackPocket = new JButton("Mr Jack Pocket");
        btnMrJackPocket.setBounds(10, 20, 160, 30);
        hautPanel.add (btnMrJackPocket);

        JButton btnEnqueteur = new JButton("Enqueteur");
        btnEnqueteur.setBounds(300, 20, 160, 30);
        hautPanel.add (btnEnqueteur);


        //hautPanel.add (new JCheckBox("Check me"));
        hautPanel.add (new JTextField("Edit me"));

        this.add(hautPanel);

    }
}