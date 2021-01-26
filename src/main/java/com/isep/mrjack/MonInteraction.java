package com.isep.mrjack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MonInteraction extends JFrame
{
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JTextArea texte = new JTextArea();
    JTextField zoneEcriture = new JTextField(30);
    JButton jb = new JButton("Enter");

    public MonInteraction()
    {
        setTitle("Interaction");
        setVisible(true);
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        texte.setText("Bonjour et bienvenue dans Mister Jack Pocket \n");
        texte.append("Qui êtes vous?");
        texte.setBounds(40,30,200,40);
        panel.add(texte);
        panel.add(zoneEcriture);
        zoneEcriture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = zoneEcriture.getText();
            }});
        panel.add(jb);
        jb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = zoneEcriture.getText();
            }
        });
        zoneEcriture.setBounds(10, 10, 10, 3);
        panel.add(label);
        add(panel);

    }

    public static void main(String[] args)
    {
        MonInteraction t = new MonInteraction();

    }

}