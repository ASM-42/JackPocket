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
import java.util.Random;


public final class MrJackActionListener {

  private MrJackActionListener() {
  }

  public static ActionListener createJetonTPair(JButton button) {
    return new JetonTempsPair(button);
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



  private static class JetonTempsPair implements ActionListener {
    JButton button;

    public JetonTempsPair(JButton button) {
      this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      Initialisation Jeu = new Initialisation();
      Plateau plateau = new Plateau();
      Random random2 = new Random();
      int actionR1 = random2.nextInt(2);
      int actionR2 = random2.nextInt(2);
      int actionR3 = random2.nextInt(2);
      int actionR4 = random2.nextInt(2);
      ArrayList<String> jetonsTourActions =
              new ArrayList<>(Arrays.asList(Jeu.jetonsActionTour[0].quelleAction(actionR1), Jeu.jetonsActionTour[1].quelleAction(actionR2),
                      Jeu.jetonsActionTour[2].quelleAction(actionR3),Jeu.jetonsActionTour[3].quelleAction(actionR4)));
      String[] jetonsTourImage =
              new String[]{Jeu.jetonsActionTour[0].quelleActionImage(actionR1), Jeu.jetonsActionTour[1].quelleActionImage(actionR2),
                      Jeu.jetonsActionTour[2].quelleActionImage(actionR3),Jeu.jetonsActionTour[3].quelleActionImage(actionR4),};

      for (int i=0; i<Jeu.jetonsActionTour.length; i++){
        plateau.jetAction[i].setIcon(new ImageIcon(getClass().getResource(jetonsTourImage[i])));
        plateau.jetAction[i].setBackground(Color.GREEN);
      }

      String Action1E = (String)JOptionPane.showInputDialog(null,
              "Enqueteur quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, new ArrayList[]{jetonsTourActions}, "Choisissez parmis les choix ci-dessous");
      int j1E = jetonsTourActions.indexOf(Action1E);
      Jeu.jetonsActionTour[j1E].faireAction(Action1E, Jeu.joueurE);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j1E);
      jetonsTourActions.remove(j1E);
      plateau.jetAction[j1E].setBackground(Color.RED);


      String Action2M= (String)JOptionPane.showInputDialog(null,
              "MrJack quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, new ArrayList[]{jetonsTourActions}, "Choisissez parmis les choix ci-dessous");
      int j2M = jetonsTourActions.indexOf(Action2M);
      Jeu.jetonsActionTour[j2M].faireAction(Action2M, Jeu.joueurM);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j2M);
      jetonsTourActions.remove(j2M);
      plateau.jetAction[j2M].setBackground(Color.RED);

      String Action3M= (String)JOptionPane.showInputDialog(null,
              "MrJack quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, new ArrayList[]{jetonsTourActions}, "Choisissez parmis les choix ci-dessous");
      int j3M = jetonsTourActions.indexOf(Action3M);
      Jeu.jetonsActionTour[j3M].faireAction(Action3M, Jeu.joueurM);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j3M);
      jetonsTourActions.remove(j3M);
      plateau.jetAction[j3M].setBackground(Color.RED);

      String Action4E= (String)JOptionPane.showInputDialog(null,
              "Enqueteur quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, new ArrayList[]{jetonsTourActions}, "Choisissez parmis les choix ci-dessous");
      int j4E = jetonsTourActions.indexOf(Action4E);
      Jeu.jetonsActionTour[j4E].faireAction(Action4E, Jeu.joueurE);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j4E);
      jetonsTourActions.remove(j4E);
      plateau.jetAction[j4E].setBackground(Color.RED);


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
