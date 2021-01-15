package com.isep.mrjack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonJeu extends JFrame {

    public MonJeu() {
        super("Mon jeu");
    }

    public void initJeu() {
        Plateau pan = new Plateau();
        this.setContentPane(pan);
    }

    public void rotateDistrict(JButton[] boutons) {
        // Tourner de 90° la tile n

    }

    public static ActionListener createActionListener(JButton button) {
        return new MrJackActionListener(button);
    }

    public static class MrJackActionListener implements ActionListener {
        JButton button;
        public MrJackActionListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.button.setIcon(new ImageIcon(getClass().getResource("/images/district/3_Chem.png")));
        }
    }

    
 /*           district1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            district1.setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/3_Chem.png"));
        }
    }); */



}