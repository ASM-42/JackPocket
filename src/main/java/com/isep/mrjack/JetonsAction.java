package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;


public class JetonsAction {
    Initialisation jeu;
    public String typeAction1;
    public String typeAction2;
    public String image1;
    public String image2;
    public String[] action1 ;
    public String[] action2 ;



    public JetonsAction(String[] action1, String[] action2, Initialisation jeu) {
        this.jeu = jeu;
        this.action1 = action1;
        this.action2 = action2;
        this.typeAction1 = action1[0]; this.image1 = action2[0];
        this.typeAction2 = action1[1]; this.image2 = action2[1];
    }

    public void piocherAlibi (Player joueur, Plateau plateau){
        PersonnagePlateau carte = jeu.personnages.get(jeu.pioche.get(0));
        if (joueur.getRole() == 0){
            JOptionPane.showMessageDialog(null,
                    "Seul MrJack ne peux avoir accès à l'information suivante",
                    "Alibi",
                    JOptionPane.PLAIN_MESSAGE);
            jeu.joueurM.setNbSabliers(
                    jeu.joueurM.getNbSabliers() + carte.getSabliers());
            //System.out.println(String.valueOf(jeu.personnages.get(0).getCarte()));
            JOptionPane.showMessageDialog(null,
                    "Le personnage est " + jeu.pioche.get(0)
                            +".\n Vous avez maintenant "+jeu.joueurM.getNbSabliers()+" sabliers.",
                    "Mr Jack",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(new ImageIcon(getClass().getResource(String.format("/images/cartes_alibi/%s.png", jeu.personnages.get(jeu.pioche.get(0)).carte))).getImage().getScaledInstance(70,130, Image.SCALE_DEFAULT)));
        }
        else {
            JOptionPane.showMessageDialog(null,
                     jeu.pioche.get(0)+" est innocent. \n Mr Jack est privé de "+carte.getSabliers()+" sabliers.",
                    "Enqueteur",
                    JOptionPane.PLAIN_MESSAGE,
            new ImageIcon(new ImageIcon(getClass().getResource(String.format("/images/cartes_alibi/%s.png", jeu.personnages.get(jeu.pioche.get(0)).carte))).getImage().getScaledInstance(70,130, Image.SCALE_DEFAULT)));
            carte.setStatut("innocent");
            jeu.findPersonnage(carte).turn(plateau);
        }
        jeu.pioche.remove(0);
    }


    public void bougerSherlock (Plateau plateau) {
        Object[] options = {1,2};
        int reponse1 = JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Sherlock?",
                "Bouger Sherlock",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/BougerSherlock.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION){
            jeu.joueurE.getSherlock().MoveDetective1(plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION){
            jeu.joueurE.getSherlock().MoveDetective2(plateau);
        }
    }

    public void bougerToby (Plateau plateau) {
        Object[] options = {1, 2};
        int reponse1 = JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Toby?",
                "Bouger Toby",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/BougerToby.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION){
            jeu.joueurE.getToby().MoveDetective1(plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION){
            jeu.joueurE.getToby().MoveDetective2(plateau);
        }
    }

    public void bougerWatson (Plateau plateau) {
        Object[] options = {'1', '2'};
        char reponse1 = (char) JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Watson?",
                "Bouger Watson",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/BougerWatson.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION){
            jeu.joueurE.getWaston().MoveDetective1(plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION){
            jeu.joueurE.getWaston().MoveDetective2(plateau);
        }
    }



    public void rotationDistrict (Plateau plateau) {
        Object[] options = {"D1","D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        String d1= (String) JOptionPane.showInputDialog(null,
                 " Quel District souhaitez-vous déplacer?",
                "Rotation", JOptionPane. QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                options, options[0]);
        Object[] options2 = {"Horaire", "Anti-Horaire"};
        String sens = (String) JOptionPane.showInputDialog(null,
                "Dans quel sens (horaire ou anti-horaire) souhaitez vous le deplacer ?",
                "Rotation "+d1, JOptionPane. QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                options2, options2[0]);
        Object[] options3 = {"Quart de Tour", "Demi Tour"};
        String choixSens = (String) JOptionPane.showInputDialog(null,
                "Voulez - vous le déplacer d'un quart de tour ou d'un demi tour ?",
                "Rotation "+d1+" sens "+sens, JOptionPane. QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                options3, options3[0]);
        District d = jeu.districts.get(d1);
        if (sens.equals("Horaire")) {
            if (choixSens.equals("Quart de Tour")) {
                d.swapQuartHoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
            if (choixSens.equals("Demi Tour")) {
                d.swapQuartHoraire(); d.swapQuartHoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
        }
        if (sens.equals("Anti-Horaire")) {
            if (choixSens.equals("Quart de Tour")) {
                d.swapQuartAntihoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
            if (choixSens.equals("Demi Tour")) {
                d.swapQuartAntihoraire();d.swapQuartAntihoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive+"_"+d.getAngle()))));
            }
        }
    }
    public void echangeDistrict(Plateau plateau){
        String[] options = {"D1","D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        String d1= (String) JOptionPane.showInputDialog(null,
                "Selectionnez le premier district que vous souhaitez déplacer :",
                "Echange Districts", JOptionPane. QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Echange.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT))
                , options, options[0]);
        jeu.removeElementString(options, jeu.index(options, d1));
        String d2= (String) JOptionPane.showInputDialog(null,
                "Selectionnez le second district que vous souhaitez déplacer",
                "Echange Districts", JOptionPane. QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Echange.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                options, options[0]);
        District temp = jeu.districts.get(d1);
        int indiceD1 = jeu.districts.get(d1).getIndice();
        jeu.districts.replace(d1, jeu.districts.get(d2));
        jeu.districts.replace(d2, temp);
        jeu.districts.get(d2).setIndice(jeu.districts.get(d1).getIndice()); jeu.districts.get(d1).setIndice(indiceD1);
        plateau.district[jeu.districts.get(d1).getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", jeu.districts.get(d1).imageActive+"_"+jeu.districts.get(d1).getAngle()))));
        plateau.district[jeu.districts.get(d2).getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", jeu.districts.get(d2).imageActive+"_"+jeu.districts.get(d2).getAngle()))));
    }
    public void Joker (Player player, Plateau plateau) {
        if (player.getRole() == 1){ //Detective

            ImageIcon icon = new ImageIcon("About16.gif");
            JButton button = new JButton();
            //TextIcon text = new TextIcon(button, "Maybe");
            //CompoundIcon compound =
              //      new CompoundIcon(CompoundIcon.Axis.X_AXIS, button.getIconTextGap(), icon, text);

            ImageIcon[] buttons = {
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Holmes.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Watson.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
            };
            int rc = JOptionPane.showOptionDialog(null, "Quel détective souhaitez vous déplacer?",
                    "Joker", JOptionPane.WARNING_MESSAGE, 0,
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Joker.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                    buttons, buttons[2]);
            if (rc == 0){
                jeu.joueurE.getSherlock().MoveDetective1(plateau);
            }
            if (rc == 1){
                jeu.joueurE.getWaston().MoveDetective1(plateau);
            }
            if (rc == 2){
                jeu.joueurE.getToby().MoveDetective1(plateau);
            }
        }
        if (player.getRole() == 0){ //MrJack
            String[] buttons = { "Sherlock", "Watson", "Toby", "Aucun" };
            int rc = JOptionPane.showOptionDialog(null, "Quel détective souhaitez vous déplacer?",
                    "Joker", JOptionPane.WARNING_MESSAGE, 0,
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Joker.png")).getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT)),
                    buttons, buttons[2]);
            if (rc == 0){
                jeu.joueurE.getSherlock().MoveDetective1(plateau);
            }
            if (rc == 1){
                jeu.joueurE.getWaston().MoveDetective1(plateau);
            }
            if (rc == 2){
                jeu.joueurE.getToby().MoveDetective1(plateau);
            }
        }
    }

        public void faireAction(String typeAction1, Player player, Plateau plateau){
        if (typeAction1.equals("Rotation")){
            rotationDistrict(plateau);
        }
        if (typeAction1.equals("Sherlock")){
            bougerSherlock(plateau);
        }
        if (typeAction1.equals("Watson")){
            bougerWatson(plateau);
        }
        if (typeAction1.equals("Toby")){
            bougerToby(plateau);
        }
        if (typeAction1.equals("Echange")){
            echangeDistrict(plateau);
        }
        if (typeAction1.equals("Joker")){
            Joker(player, plateau);
        }
        if (typeAction1.equals("Carte Alibi")){
            piocherAlibi(player, plateau);
        }
    }


    public String getTypeAction1() {
        return typeAction1;
    }

    public String quelleAction(int r){
        if (r==1){
            return action1[0];
        }
        return action1[1];
    }

    public String quelleActionImage(int r){
        if (r==1){
            return action2[0];
        }
        return action2[1];
    }


    public void Action(int action, Player player, Plateau plateau) {
        if (action == 1){
            faireAction(typeAction1, player, plateau);
        }
        if (action == 2){
            faireAction(typeAction2, player, plateau);
        }}

    public void setTypeAction1(String typeAction1) {
        this.typeAction1 = typeAction1;
    }

    public String getTypeAction2() {
        return typeAction2;
    }

    public void setTypeAction2(String typeAction2) {
        this.typeAction2 = typeAction2;
    }

    public void setJeu(Initialisation jeu) {
        this.jeu = jeu;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String[] getAction1() {
        return action1;
    }

    public String[] getAction2() {
        return action2;
    }
}
