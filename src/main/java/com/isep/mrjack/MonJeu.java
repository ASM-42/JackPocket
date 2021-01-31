package com.isep.mrjack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonJeu extends JFrame {

  public MonJeu() {
    super("Mon jeu");
  }

  //instanciation du Plateau
  public void initJeu() {
    Plateau pan = new Plateau();
    this.setContentPane(pan);
  }

}
