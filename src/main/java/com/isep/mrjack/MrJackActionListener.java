package com.isep.mrjack;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public final class MrJackActionListener {

  private MrJackActionListener() {
  }

  public static ActionListener createJetonT1(JButton button, Initialisation Jeu, Plateau plateau) {

    return new JetonTemps1(button, Jeu, plateau);
  }

  public static ActionListener createJetonT2(JButton button, Initialisation Jeu, Plateau plateau) {

    return new JetonTemps2(button, Jeu, plateau);
  }

  public static ActionListener createReturnDistrictAL(JButton button) {
    return new ReturnDistrictActionListener(button);
  }

  public static ActionListener createRotateDistrictAL(JButton button) {
    return new RotateDistrictActionListener(button);
  }

  public static ActionListener createReturnJetonTempsAL(JButton button) {
    return new ReturnJetonTempsActionListener(button);
  }

  public static ActionListener createPiocherAlibiAL(JButton button) {
    return new PiocherAlibiActionListener(button);
  }

  public static ActionListener createMoveDetectiveAL(JButton button, JPanel panel) {
    return new MoveDetectiveActionListener(button, panel);
  }

  public static ActionListener createEchangeDistrictAL(JButton button) {
    return new EchangeDistrictActionListener(button);
  }



  private static class JetonTemps1 implements ActionListener {
    JButton button;
    Initialisation Jeu;
    Plateau plateau;


    public JetonTemps1(JButton button, Initialisation Jeu, Plateau plateau) {
      this.button = button;
      this.Jeu = Jeu;
      this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      Random random2 = new Random();
      int actionR1 = random2.nextInt(2);
      int actionR2 = random2.nextInt(2);
      int actionR3 = random2.nextInt(2);
      int actionR4 = random2.nextInt(2);

      List<String> actionsPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction1(actionR1), Jeu.jetonsActionTour[1].getAction1(actionR2),
              Jeu.jetonsActionTour[2].getAction1(actionR3), Jeu.jetonsActionTour[3].getAction1(actionR4));
      List<String> imagesPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction2(actionR1), Jeu.jetonsActionTour[1].getAction2(actionR2),
              Jeu.jetonsActionTour[2].getAction2(actionR3), Jeu.jetonsActionTour[3].getAction2(actionR4));
      ImageIcon[] boutonAction = new ImageIcon[4];
      for (int i=0; i<actionsPourLeTour.size(); i++){
        plateau.jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT)));
        plateau.jetAction[i].setBackground(Color.GREEN);
        boutonAction[i] = new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      }
      Jeu.SuspectsVisibles(plateau);

      int rc = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);
      String Action1E = actionsPourLeTour.get(rc);
      switch (actionsPourLeTour.get(rc)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurE, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurE, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      plateau.jetAction[actionsPourLeTour.indexOf(Action1E)].setBackground(Color.RED);
      boutonAction[rc] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);

      int rc2 = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);

      String Action2M = actionsPourLeTour.get(rc2);
      switch (actionsPourLeTour.get(rc2)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action2M)].setBackground(Color.RED);
      boutonAction[rc2] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int rc3 = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);

      String Action3M = actionsPourLeTour.get(rc3);
      switch (actionsPourLeTour.get(rc3)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action3M)].setBackground(Color.RED);
      boutonAction[rc3] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int rc4 = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);

      String Action4E = actionsPourLeTour.get(rc4);
      switch (actionsPourLeTour.get(rc4)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurE, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurE, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action4E)].setBackground(Color.RED);
      boutonAction[rc4] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);

      Jeu.appelTemoins(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }

      // TOUR PAIR

      JOptionPane.showMessageDialog(null,
              "Second Tour",
              "Second Tour",
              JOptionPane.ERROR_MESSAGE);
      for (int i=0; i<Jeu.SuspectsVisibles(plateau).size(); i++){
        Jeu.SuspectsVisibles(plateau).get(i).setVisible(false);
      }
      actionsPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction1(1-actionR1), Jeu.jetonsActionTour[1].getAction1(1-actionR2),
              Jeu.jetonsActionTour[2].getAction1(1-actionR3), Jeu.jetonsActionTour[3].getAction1(1-actionR4));
      imagesPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction2(1-actionR1), Jeu.jetonsActionTour[1].getAction2(1-actionR2),
              Jeu.jetonsActionTour[2].getAction2(1-actionR3), Jeu.jetonsActionTour[3].getAction2(1-actionR4));
      for (int i=0; i<actionsPourLeTour.size(); i++){
        plateau.jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(75,75, Image.SCALE_DEFAULT)));
        plateau.jetAction[i].setBackground(Color.GREEN);
        boutonAction[i] = new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      }
      Jeu.SuspectsVisibles(plateau);

      int jpair = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              plateau.jetTemps[1].getIcon(),
              boutonAction, boutonAction[0]);
      String Action1M = actionsPourLeTour.get(jpair);
      switch (actionsPourLeTour.get(jpair)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action1M)].setBackground(Color.RED);
      boutonAction[jpair] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int jpair2 = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.PLAIN_MESSAGE, 0,
              plateau.jetTemps[1].getIcon(),
              boutonAction, boutonAction[0]);

      String Action2E = actionsPourLeTour.get(jpair2);
      switch (actionsPourLeTour.get(jpair2)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurE, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurE, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action2E)].setBackground(Color.RED);
      boutonAction[rc2] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int jpair3 = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              plateau.jetTemps[1].getIcon(),
              boutonAction, boutonAction[0]);

      String Action3E = actionsPourLeTour.get(jpair3);
      switch (actionsPourLeTour.get(jpair3)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action3E)].setBackground(Color.RED);
      boutonAction[jpair3] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int jpair4 = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              plateau.jetTemps[1].getIcon(),
              boutonAction, boutonAction[0]);

      String Action4M = actionsPourLeTour.get(jpair4);
      switch (actionsPourLeTour.get(jpair4)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action4M)].setBackground(Color.RED);
      boutonAction[jpair4] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      Jeu.appelTemoins(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }

      JOptionPane.showMessageDialog(null,
              "Veuillez cliquer sur le troisème jeton temps",
              "Mr Jack",
              JOptionPane.PLAIN_MESSAGE);
    }
  }




  private static class JetonTemps2 implements ActionListener {
    JButton button;
    Initialisation Jeu;
    Plateau plateau;


    public JetonTemps2(JButton button, Initialisation Jeu, Plateau plateau) {
      this.button = button;
      this.Jeu = Jeu;
      this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      Random random2 = new Random();
      int actionR1 = random2.nextInt(2);
      int actionR2 = random2.nextInt(2);
      int actionR3 = random2.nextInt(2);
      int actionR4 = random2.nextInt(2);

      List<String> actionsPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction1(actionR1), Jeu.jetonsActionTour[1].getAction1(actionR2),
              Jeu.jetonsActionTour[2].getAction1(actionR3), Jeu.jetonsActionTour[3].getAction1(actionR4));
      List<String> imagesPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction2(actionR1), Jeu.jetonsActionTour[1].getAction2(actionR2),
              Jeu.jetonsActionTour[2].getAction2(actionR3), Jeu.jetonsActionTour[3].getAction2(actionR4));
      ImageIcon[] boutonAction = new ImageIcon[4];

      JOptionPane.showMessageDialog(null,
              "Troisème Tour",
              "Troisème Tour",
              JOptionPane.ERROR_MESSAGE);
      for (int i=0; i<actionsPourLeTour.size(); i++){
        plateau.jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT)));
        plateau.jetAction[i].setBackground(Color.GREEN);
        boutonAction[i] = new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      }
      Jeu.SuspectsVisibles(plateau);

      int rc = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);
      String Action1E = actionsPourLeTour.get(rc);
      switch (actionsPourLeTour.get(rc)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurE, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurE, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      plateau.jetAction[actionsPourLeTour.indexOf(Action1E)].setBackground(Color.RED);
      boutonAction[rc] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);

      int rc2 = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);

      String Action2M = actionsPourLeTour.get(rc2);
      switch (actionsPourLeTour.get(rc2)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action2M)].setBackground(Color.RED);
      boutonAction[rc2] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int rc3 = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);

      String Action3M = actionsPourLeTour.get(rc3);
      switch (actionsPourLeTour.get(rc3)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action3M)].setBackground(Color.RED);
      boutonAction[rc3] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int rc4 = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              this.button.getIcon(),
              boutonAction, boutonAction[0]);

      String Action4E = actionsPourLeTour.get(rc4);
      switch (actionsPourLeTour.get(rc4)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurE, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurE, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action4E)].setBackground(Color.RED);
      boutonAction[rc4] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);

      Jeu.appelTemoins(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }

      // TOUR PAIR

      JOptionPane.showMessageDialog(null,
              "Quatrème Tour",
              "Quatrème Tour",
              JOptionPane.ERROR_MESSAGE);
      actionsPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction1(1-actionR1), Jeu.jetonsActionTour[1].getAction1(1-actionR2),
              Jeu.jetonsActionTour[2].getAction1(1-actionR3), Jeu.jetonsActionTour[3].getAction1(1-actionR4));
      imagesPourLeTour = List.of(Jeu.jetonsActionTour[0].getAction2(1-actionR1), Jeu.jetonsActionTour[1].getAction2(1-actionR2),
              Jeu.jetonsActionTour[2].getAction2(1-actionR3), Jeu.jetonsActionTour[3].getAction2(1-actionR4));
      for (int i=0; i<actionsPourLeTour.size(); i++){
        plateau.jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(75,75, Image.SCALE_DEFAULT)));
        plateau.jetAction[i].setBackground(Color.GREEN);
        boutonAction[i] = new ImageIcon(new ImageIcon(getClass().getResource(imagesPourLeTour.get(i))).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      }
      Jeu.SuspectsVisibles(plateau);

      int jpair = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              plateau.jetTemps[3].getIcon(),
              boutonAction, boutonAction[0]);
      String Action1M = actionsPourLeTour.get(jpair);
      switch (actionsPourLeTour.get(jpair)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action1E)].setBackground(Color.RED);
      boutonAction[jpair] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int jpair2 = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.PLAIN_MESSAGE, 0,
              plateau.jetTemps[3].getIcon(),
              boutonAction, boutonAction[0]);

      String Action2E = actionsPourLeTour.get(jpair2);
      switch (actionsPourLeTour.get(jpair2)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurE, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurE, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action2M)].setBackground(Color.RED);
      boutonAction[rc2] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int jpair3 = JOptionPane.showOptionDialog(null, "Enqueteur quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              plateau.jetTemps[3].getIcon(),
              boutonAction, boutonAction[0]);

      String Action3 = actionsPourLeTour.get(jpair3);
      switch (actionsPourLeTour.get(jpair3)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action3M)].setBackground(Color.RED);
      boutonAction[jpair3] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }
      int jpair4 = JOptionPane.showOptionDialog(null, "MrJack quelle action souhaitez vous jouer",
              "Action Enqueteur", JOptionPane.WARNING_MESSAGE, 0,
              plateau.jetTemps[3].getIcon(),
              boutonAction, boutonAction[0]);

      String Action4M = actionsPourLeTour.get(jpair4);
      switch (actionsPourLeTour.get(jpair4)){
        case "Sherlock":
          Jeu.jeton1.bougerSherlock(plateau);
          break;
        case "Carte Alibi":
          Jeu.jeton1.piocherAlibi(Jeu.joueurM, plateau);
          break;
        case "Watson":
          Jeu.jeton2.bougerWatson(plateau);
          break;
        case "Toby" :
          Jeu.jeton2.bougerToby(plateau);
          break;
        case "Rotation":
          Jeu.jeton3.rotationDistrict(plateau);
          break;
        case "Joker":
          Jeu.jeton3.Joker(Jeu.joueurM, plateau);
          break;
        case "Echange":
          Jeu.jeton4.echangeDistrict(plateau);
          break;
      }

      plateau.jetAction[actionsPourLeTour.indexOf(Action4M)].setBackground(Color.RED);
      boutonAction[jpair4] = new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
      Jeu.SuspectsVisibles(plateau);
      Jeu.appelTemoins(plateau);
      if (Jeu.joueurM.getNbSabliers() >= 6){
        JOptionPane.showMessageDialog(null,
                "Mr Jack à gagné!",
                "Mr Jack",
                JOptionPane.PLAIN_MESSAGE);
      }

      JOptionPane.showMessageDialog(null,
              "Veuillez cliquer sur le cinquième jeton temps",
              "Mr Jack",
              JOptionPane.PLAIN_MESSAGE);
    }
  }

  

  private static class ReturnDistrictActionListener implements ActionListener {
    JButton button;

    public ReturnDistrictActionListener(JButton button) {
      this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      this.button.setIcon(new ImageIcon(getClass().getResource("/images/district/3_Chem.png")));
    }
  }


  private static class RotateDistrictActionListener implements ActionListener {
    JButton button;

    public RotateDistrictActionListener(JButton button) {
      this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Hello!");
      try {
        BufferedImage image = ImageIO.read(getClass().getResource("/images/district/J_Lane.png"));
        Image rotated_image = rotateImageByDegrees(image, 90);
        this.button.setIcon(new ImageIcon(rotated_image));
        // graphics.drawImage;
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
      ;

    }

    public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

      double rads = Math.toRadians(angle);
      double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
      int w = img.getWidth();
      int h = img.getHeight();
      int newWidth = (int) Math.floor(w * cos + h * sin);
      int newHeight = (int) Math.floor(h * cos + w * sin);

      BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2d = rotated.createGraphics();
      g2d.rotate(rads);
      g2d.drawImage(img, 0, 0, new ImageObserver() {
        @Override
        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
          return false;
        }
      });
      g2d.setColor(Color.RED);
      g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
      g2d.dispose();

      return rotated;
    }

  }


  private static class ReturnJetonTempsActionListener implements ActionListener {
    JButton button;

    public ReturnJetonTempsActionListener(JButton button) {
      this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      this.button.setIcon(new ImageIcon(getClass().getResource("/images/jet_temps/Sablier.png")));
    }
  }




  private static class PiocherAlibiActionListener implements ActionListener {
    JButton button;

    public PiocherAlibiActionListener(JButton button) { this.button = button;}

    @Override
    public void actionPerformed(ActionEvent e) {
      String []images = {
              "/images/cartes_alibi/InspLestrade-alibi.png", "/images/cartes_alibi/JeremyBert-alibi.png", "/images/cartes_alibi/JohnPizer-alibi.png",
              "/images/cartes_alibi/JohnPizer-alibi.png", "/images/cartes_alibi/JosephLane-alibi.png", "/images/cartes_alibi/Madame-alibi.png",
              "/images/cartes_alibi/MissStealthy-alibi.png", "/images/cartes_alibi/SgtGoodley-alibi.png", "/images/cartes_alibi/WilliamGull-alibi.png"};

      int n = (int) Math.floor(Math.random() * 300);
      String image = images[n];
      this.button.setIcon(new ImageIcon(getClass().getResource("/images/alibi/" + image)));
    }
  }




  private static class MoveDetectiveActionListener implements ActionListener {
    JButton bouton;
    JPanel panel;

    public MoveDetectiveActionListener(JButton bouton, JPanel panel) { this.bouton = bouton;}

    @Override
    public void actionPerformed(ActionEvent e) {
      //faire ici le setIcon(null)
      bouton.setIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")));
      panel.add(bouton);
    }
  }



  private static class EchangeDistrictActionListener implements ActionListener {
    JButton button;

    public EchangeDistrictActionListener(JButton button) {
      this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

      this.button.setIcon(new ImageIcon(getClass().getResource("")));

    }
  }






}
