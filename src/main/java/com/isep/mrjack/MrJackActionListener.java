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

  public static ActionListener createJetonTPair(JButton button, Initialisation Jeu, Plateau plateau) {

    return new JetonTempsPair(button, Jeu, plateau);
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
    Initialisation Jeu;
    Plateau plateau;


    public JetonTempsPair(JButton button, Initialisation Jeu, Plateau plateau) {
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
      String[] jetonsTourActions =
              {Jeu.jetonsActionTour[0].getAction1()[actionR1], Jeu.jetonsActionTour[1].getAction1()[actionR2],
                      Jeu.jetonsActionTour[2].getAction1()[actionR3],Jeu.jetonsActionTour[3].getAction1()[actionR4]};
      String[] jetonsTourImage =
              new String[]{Jeu.jetonsActionTour[0].getAction2()[actionR1], Jeu.jetonsActionTour[1].getAction2()[actionR2],
                      Jeu.jetonsActionTour[2].getAction2()[actionR3],Jeu.jetonsActionTour[3].getAction2()[actionR4]};

      for (int i=0; i<Jeu.jetonsActionTour.length; i++){
        plateau.jetAction[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource(jetonsTourImage[i])).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT)));
        plateau.jetAction[i].setBackground(Color.GREEN);
      }
      //for (int i =0; i<jetonsTourActions.length; i++){ System.out.println(jetonsTourActions[i]);}
      //Jeu.SuspectsVisibles(Jeu.joueurE, plateau);

      String Action1E = (String)JOptionPane.showInputDialog(null,
              "Enqueteur quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, jetonsTourActions, "Choisissez parmis les choix ci-dessous");

      int j1E = Jeu.index(jetonsTourActions, Action1E);
      Jeu.jetonsActionTour[j1E].faireAction(Action1E, Jeu.joueurE, plateau);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j1E);
      Jeu.removeElementString(jetonsTourActions, j1E);
      //jetonsTourActions = Jeu.removeElementString(jetonsTourActions, j1E);
      plateau.jetAction[j1E].setBackground(Color.RED);
      //for (int z =0; z<jetonsTourActions.length; z++){ System.out.println(jetonsTourActions[z]);}


      String Action2M= (String)JOptionPane.showInputDialog(null,
              "MrJack quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, jetonsTourActions, "Choisissez parmis les choix ci-dessous");
      int j2M = Jeu.index(jetonsTourActions, Action2M);
      Jeu.jetonsActionTour[j2M].faireAction(Action2M, Jeu.joueurM, plateau);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j2M);
      jetonsTourActions = Jeu.removeElementString(jetonsTourActions, j2M);
      plateau.jetAction[j2M].setBackground(Color.RED);
      //for (int k=0; k<jetonsTourActions.length; k++){ System.out.println(jetonsTourActions[k]);}



      String Action3M= (String)JOptionPane.showInputDialog(null,
              "MrJack quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, jetonsTourActions, "Choisissez parmis les choix ci-dessous");
      int j3M = Jeu.index(jetonsTourActions, Action3M);
      Jeu.jetonsActionTour[j3M].faireAction(Action3M, Jeu.joueurM, plateau);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j3M);
      jetonsTourActions = Jeu.removeElementString(jetonsTourActions, j3M);
      plateau.jetAction[j3M].setBackground(Color.RED);
      //for (int h =0; h<jetonsTourActions.length; h++){ System.out.println(jetonsTourActions[h]);}

      String Action4E= (String)JOptionPane.showInputDialog(null,
              "Enqueteur quelle action souhaitez vous jouer",
              "Action Detective",
              JOptionPane.QUESTION_MESSAGE, null, jetonsTourActions, "Choisissez parmis les choix ci-dessous");
      int j4E = Jeu.index(jetonsTourActions, Action4E
      );
      Jeu.jetonsActionTour[j4E].faireAction(Action4E, Jeu.joueurE, plateau);
      Jeu.jetonsActionTour = Jeu.removeElement(Jeu.jetonsActionTour, j4E);
      jetonsTourActions = Jeu.removeElementString(jetonsTourActions, j4E);
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
