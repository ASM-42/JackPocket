package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;


public class JetonsAction {
    //déclaration des attributs de DISTRICT
    Initialisation jeu;
    public String typeAction1;
    public String typeAction2;
    public String image1;
    public String image2;
    public String[] action1;
    public String[] action2;


    //constructeur des jetonsAction
    public JetonsAction(String[] action1, String[] action2, Initialisation jeu) {
        this.jeu = jeu;
        this.action1 = action1;
        this.action2 = action2;
        this.typeAction1 = action1[0];
        this.image1 = action2[0];
        this.typeAction2 = action1[1];
        this.image2 = action2[1];
    }

    
    //JetonAction pour piocher un Alibi
    public void piocherAlibi(Player joueur, Plateau plateau) {
        PersonnagePlateau carte = jeu.personnages.get(jeu.pioche.get(0));
        if (joueur.getRole() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seul MrJack n'a accès à l'information suivante",
                    "Alibi",
                    JOptionPane.PLAIN_MESSAGE);
            jeu.joueurM.setNbSabliers(
                    jeu.joueurM.getNbSabliers() + carte.getSabliers());
            //System.out.println(String.valueOf(jeu.personnages.get(0).getCarte()));
            JOptionPane.showMessageDialog(null,
                    "Le personnage est " + jeu.pioche.get(0)
                            + ".\n Vous avez maintenant " + jeu.joueurM.getNbSabliers() + " sabliers.",
                    "Mr Jack",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(new ImageIcon(getClass().getResource(String.format("/images/cartes_alibi/%s.png", jeu.personnages.get(jeu.pioche.get(0)).carte))).getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT)));
        } else {
            JOptionPane.showMessageDialog(null,
                    jeu.pioche.get(0) + " est innocent. \n Mr Jack est privé de " + carte.getSabliers() + " sabliers.",
                    "Enqueteur",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(new ImageIcon(getClass().getResource(String.format("/images/cartes_alibi/%s.png", jeu.personnages.get(jeu.pioche.get(0)).carte))).getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT)));
            carte.setStatut("innocent");
            jeu.findPersonnage(carte).turn(plateau);
        }
        jeu.pioche.remove(0);
    }


    //JetonAction pour bouger Sherlock de 1 ou 2 cases
    public void bougerSherlock(Plateau plateau) {
        Object[] options = {1, 2};
        int reponse1 = JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Sherlock?",
                "Bouger Sherlock",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/BougerSherlock.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION) {
            jeu.joueurE.getSherlock().MoveDetective1(plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION) {
            jeu.joueurE.getSherlock().MoveDetective2(plateau);
        }
    }

    //JetonAction pour bouger Toby de 1 ou 2 cases
    public void bougerToby(Plateau plateau) {
        Object[] options = {1, 2};
        int reponse1 = JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Toby?",
                "Bouger Toby",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/BougerToby.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION) {
            jeu.joueurE.getToby().MoveDetective1(plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION) {
            jeu.joueurE.getToby().MoveDetective2(plateau);
        }
    }
    
    
    //JetonAction pour bouger Watson de 1 ou 2 cases
    public void bougerWatson(Plateau plateau) {
        Object[] options = {'1', '2'};
        char reponse1 = (char) JOptionPane.showOptionDialog(plateau,
                "De combien de case souhaitez vous déplacer Watson?",
                "Bouger Watson",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/BougerWatson.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (reponse1 == JOptionPane.YES_OPTION) {
            jeu.joueurE.getWaston().MoveDetective1(plateau);
        }
        if (reponse1 == JOptionPane.NO_OPTION) {
            jeu.joueurE.getWaston().MoveDetective2(plateau);
        }
    }

    //JetonAction pour faire une rotation de District dans un sens sens horaire ou anti-horaire
    //et d'un demi tour ou d'un quart de tour
    public void rotationDistrict(Plateau plateau) {
        // choix des districts à bouger
        Object[] options = {"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        String d1 = (String) JOptionPane.showInputDialog(null,
                " Quel District souhaitez-vous tourner?",
                "Rotation", JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                options, options[0]);
        // choix du sens horaire ou anti-horaire
        Object[] options2 = {"Horaire", "Anti-Horaire"};
        String sens = (String) JOptionPane.showInputDialog(null,
                "Dans quel sens (horaire ou anti-horaire) souhaitez vous le deplacer ?",
                "Rotation " + d1, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                options2, options2[0]);
        // choix d'un quart de tour ou d'un demi tour
        Object[] options3 = {"Quart de Tour", "Demi Tour"};
        String choixSens = (String) JOptionPane.showInputDialog(null,
                "Voulez - vous le déplacer d'un quart de tour ou d'un demi tour ?",
                "Rotation " + d1 + " sens " + sens, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Rotation.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                options3, options3[0]);
        District d = jeu.districts.get(d1);
        //pour le choix du sens horaire
        if (sens.equals("Horaire")) {
            //choix de quart de tour
            if (choixSens.equals("Quart de Tour")) {
                d.swapQuartHoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive + "_" + d.getAngle()))));
            }
            //choix de demi tour
            if (choixSens.equals("Demi Tour")) {
                d.swapQuartHoraire();
                d.swapQuartHoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive + "_" + d.getAngle()))));
            }
        }
        //pour le choix du sens anti-horaire
        if (sens.equals("Anti-Horaire")) {
            //choix de quart de tour
            if (choixSens.equals("Quart de Tour")) {
                d.swapQuartAntihoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive + "_" + d.getAngle()))));
            }
            //choix de demi tour
            if (choixSens.equals("Demi Tour")) {
                d.swapQuartAntihoraire();
                d.swapQuartAntihoraire();
                plateau.district[d.getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", d.imageActive + "_" + d.getAngle()))));
            }
        }
    }

    //JetonAction pour faire un échange de District
    public void echangeDistrict(Plateau plateau) {
        //choix du premier district
        String[] options = {"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        String d1 = (String) JOptionPane.showInputDialog(null,
                "Selectionnez le premier district que vous souhaitez déplacer :",
                "Echange Districts", JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Echange.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))
                , options, options[0]);
        //on enlève ce premier district
        jeu.removeElementString(options, jeu.index(options, d1));
        //choix du deuxième district
        String d2 = (String) JOptionPane.showInputDialog(null,
                "Selectionnez le second district que vous souhaitez déplacer",
                "Echange Districts", JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Echange.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                options, options[0]);
        District temp = jeu.districts.get(d1);
        int indiceD1 = jeu.districts.get(d1).getIndice();
        jeu.districts.replace(d1, jeu.districts.get(d2));
        jeu.districts.replace(d2, temp);
        jeu.districts.get(d2).setIndice(jeu.districts.get(d1).getIndice());
        jeu.districts.get(d1).setIndice(indiceD1);
        plateau.district[jeu.districts.get(d1).getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", jeu.districts.get(d1).imageActive + "_" + jeu.districts.get(d1).getAngle()))));
        plateau.district[jeu.districts.get(d2).getIndice()].setIcon(new ImageIcon(getClass().getResource(String.format("/images/district/%s.png", jeu.districts.get(d2).imageActive + "_" + jeu.districts.get(d2).getAngle()))));
    }
    
    
    //JetonAction "Joker" = déplacer soit Watson, soit Toby soit Holmes
    public void Joker(Player player, Plateau plateau) {
        //Si le joueur est l'enqueteur
        if (player.getRole() == 1) {

            ImageIcon[] buttons = {
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Holmes.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Watson.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
            };
           
            int rc = JOptionPane.showOptionDialog(null, "Quel détective souhaitez vous déplacer?",
                    "Joker", JOptionPane.WARNING_MESSAGE, 0,
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Joker.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                    buttons, buttons[2]);
            if (rc == 0) {
                jeu.joueurE.getSherlock().MoveDetective1(plateau);
            }
            if (rc == 1) {
                jeu.joueurE.getWaston().MoveDetective1(plateau);
            }
            if (rc == 2) {
                jeu.joueurE.getToby().MoveDetective1(plateau);
            }
        }
        //Si le joueur est MrJack
        if (player.getRole() == 0) { //MrJack
            ImageIcon[] buttons = {
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Holmes.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Watson.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Tobby.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_detec/Aucun.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))
            };
            int rc = JOptionPane.showOptionDialog(null, "Quel détective souhaitez vous déplacer?",
                    "Joker", JOptionPane.WARNING_MESSAGE, 0,
                    new ImageIcon(new ImageIcon(getClass().getResource("/images/jet_action/Joker.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)),
                    buttons, buttons[2]);
            if (rc == 0) {
                jeu.joueurE.getSherlock().MoveDetective1(plateau);
            }
            if (rc == 1) {
                jeu.joueurE.getWaston().MoveDetective1(plateau);
            }
            if (rc == 2) {
                jeu.joueurE.getToby().MoveDetective1(plateau);
            }
        }
    }

 
    public void faireAction(String typeAction1, Player player, Plateau plateau) {
        if (typeAction1.equals("Rotation")) {
            rotationDistrict(plateau);
        }
        if (typeAction1.equals("Sherlock")) {
            bougerSherlock(plateau);
        }
        if (typeAction1.equals("Watson")) {
            bougerWatson(plateau);
        }
        if (typeAction1.equals("Toby")) {
            bougerToby(plateau);
        }
        if (typeAction1.equals("Echange")) {
            echangeDistrict(plateau);
        }
        if (typeAction1.equals("Joker")) {
            Joker(player, plateau);
        }
        if (typeAction1.equals("Carte Alibi")) {
            piocherAlibi(player, plateau);
        }
    }


    // getters et setters
    public String getTypeAction1() {
        return typeAction1;
    }


    public String quelleActionImage(int r) {
        if (r == 1) {
            return action2[0];
        }
        return action2[1];
    }


    public void Action(int action, Player player, Plateau plateau) {
        if (action == 1) {
            faireAction(typeAction1, player, plateau);
        }
        if (action == 2) {
            faireAction(typeAction2, player, plateau);
        }
    }

    public String getAction1(int a) {
        if (a == 0) {
            return action1[0];
        } else {
            return action1[1];
        }
    }

    public String getAction2(int a) {
        if (a == 0) {
            return action2[0];
        } else {
            return action2[1];
        }
    }
}
