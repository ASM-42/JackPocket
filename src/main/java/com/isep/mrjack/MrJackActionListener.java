package com.isep.mrjack;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public final class MrJackActionListener {
  private MrJackActionListener() {
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

  public static ActionListener createMoveDtectiveAL(JButton button) {
    return new MoveDetectiveActionListener(button);
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

    private String[] images = {};

    public PiocherAlibiActionListener(JButton button) {
      this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      int n = (int) Math.floor(Math.random() * 300);
      String image = images[n];
      this.button.setIcon(new ImageIcon(getClass().getResource("/images/alibi/" + image)));
    }
  }


  private static class MoveDetectiveActionListener implements ActionListener {
    JButton button;

    public MoveDetectiveActionListener(JButton button) {
      this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      this.button.setIcon(null);
      button.setIcon(null);
    }
  }

///
}
