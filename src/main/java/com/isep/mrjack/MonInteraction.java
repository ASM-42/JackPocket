package com.isep.mrjack;

import javax.swing.*;

public class MonInteraction extends JFrame {


    public MonInteraction() { super("Fenêtre d'interaction"); }

    public void initInteraction() {
        Interaction pan = new Interaction();
        this.setContentPane(pan);
    }


/*
    public void messageAccueil() {
        JPanel textPanel = new JPanel();
        JButton message = new JButton ("coucou");
        textPanel.add(message);

    }
    */
}