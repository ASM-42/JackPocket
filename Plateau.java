import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plateau extends JPanel implements ActionListener {


    public Plateau() {
        super(new BorderLayout());
        this.panelMilieu();
        this.panelGauche();
        this.panelHaut();
        this.panelDroite();
        this.panelBas();
    }


    private void panelMilieu() {

        // *** CONSTRUIT L'AREA DU MILIEU
        JPanel plateauPanel = new JPanel(new GridLayout(3, 3, 0, 0));

        JButton[] district = new JButton[9];                      //liste de 9 boutons qui correspondent aux 9 district
        for (int i = 0; i < district.length; i++) {
            district[i] = new JButton("");
            plateauPanel.add(district[i]);
            if (i == 0) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/W_Gull.png")); }
            if (i == 1) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/J_Bert.png")); }
            if (i == 2) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/M_Stealthy.png")); }
            if (i == 3) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/J_Smith.png")); }
            if (i == 4) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/J_Pizzer.png")); }
            if (i == 5) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/I_Lestrada.png")); }
            if (i == 6) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/J_lane.png")); }
            if (i == 7) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/Madame.png")); }
            if (i == 8) { district[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/S_Goodley.png")); }

            int finalI = i;
            district[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    district[finalI].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesDistrict/3_Chem.png"));
                }
            });
        }
        this.add(plateauPanel, BorderLayout.CENTER);
    }



    // *** CONSTRUIT L'AREA DU GAUCHE ***
    private void panelGauche() {
        JPanel gauchePanel = new JPanel(new GridLayout());

        //panel pour les boutons jetonsTemps
        JPanel surfaceGauche = new JPanel(new GridLayout(8, 1, 0, 0));
        JButton[] jetTemps = new JButton[8];                      //liste de 8 boutons qui correspondent aux 8 jetonsTemps
        for (int i = 0; i < jetTemps.length; i++) {
            jetTemps[i] = new JButton("");
            if (i == 0) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/1.png")); }
            if (i == 1) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/2.png")); }
            if (i == 2) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/3.png")); }
            if (i == 3) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/4.png")); }
            if (i == 4) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/5.png")); }
            if (i == 5) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/6.png")); }
            if (i == 6) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/7.png")); }
            if (i == 7) { jetTemps[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetTemps/8.png")); }
            surfaceGauche.add(jetTemps[i]);
        }

        //panel pour les boutons jetDetective
        JPanel detectivePanel1 = new JPanel(new GridLayout(3, 1, 0, 0));
        JButton[] detectiveVide = new JButton[3];
        for (int i = 0; i < detectiveVide.length; i++) {
            detectiveVide[i] = new JButton("");
            if (i == 0) { detectiveVide[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetDetec/Holmes.png")); }
            detectivePanel1.add(detectiveVide[i]);
        }

        //rajouter les 2 panels créé au gauchePanel
        gauchePanel.add(surfaceGauche);
        gauchePanel.add(detectivePanel1);
        this.add(gauchePanel, BorderLayout.LINE_START);
    }


    // *** CONSTRUIT L'AREA EN HAUT ***
    private void panelHaut() {
        JPanel detectivePanel2 = new JPanel(new GridLayout(1, 3, 0, 0));
        JButton[] detectiveVide2 = new JButton[3];
        for (int i = 0; i < detectiveVide2.length; i++) {
            detectiveVide2[i] = new JButton("");
            detectivePanel2.add(detectiveVide2[i]);
        }
        this.add(detectivePanel2, BorderLayout.PAGE_START);
    }


    // *** CONSTRUIT L'AREA À DROITE ***
    private void panelDroite() {
        JPanel droitePanel = new JPanel(new GridLayout());

        //panel pour les boutons jetDetective
        JPanel detectivePanel3 = new JPanel(new GridLayout(3, 1, 0, 0));
        JButton[] detectiveVide3 = new JButton[3];
        for (int i = 0; i < detectiveVide3.length; i++) {
            detectiveVide3[i] = new JButton("");
            if (i == 0) {
                detectiveVide3[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetDetec/Watson.png"));
            }
            detectivePanel3.add(detectiveVide3[i]);
        }

        //panel pour les jetAction
        JPanel surfaceDroite = new JPanel(new GridLayout(4, 1, 0, 0));
        JButton[] jetAction = new JButton[4];
        for (int i = 0; i < jetAction.length; i++) {
            jetAction[i] = new JButton("");
            if (i == 0) { jetAction[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetAction/Alibi.png")); }
            if (i == 1) { jetAction[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetAction/Echange.png")); }
            if (i == 2) { jetAction[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetAction/Joker.png")); }
            if (i == 3) { jetAction[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetAction/Rotation.png")); }
            surfaceDroite.add(jetAction[i]);
        }

        //panel pour la pioche
        JPanel piochePanel = new JPanel(new GridLayout(3, 1, 0, 0));
        JButton Alibi = new JButton("Pioche un Alibi");
        piochePanel.add(Alibi);

        //rajouter les 3 panels créés au droitePanel
        droitePanel.add(detectivePanel3);
        droitePanel.add(surfaceDroite);
        droitePanel.add(piochePanel);
        this.add(droitePanel, BorderLayout.LINE_END);


    }


    // *** CONSTRUIT L'AREA EN BAS ***
    JPanel detectivePanel4 = new JPanel(new GridLayout(1, 3, 0, 0));
    private void panelBas() {
        JButton[] detectiveVide4 = new JButton[3];
        for (int i = 0; i < detectiveVide4.length; i++) {
            detectiveVide4[i] = new JButton("");
            if (i == 2) {
                detectiveVide4[i].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetDetec/Tobby.png"));
            }
            detectivePanel4.add(detectiveVide4[i]);
        }
        this.add(detectivePanel4, BorderLayout.PAGE_END);
    }

 /*   public void deplacementTobby (int place, JPanel lePanel, ImageIcon imageIcon) {

        detectiveVide4[place].setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/imagesJetDetec/Tobby.png"));
    }
*/

    @Override
    public void actionPerformed(ActionEvent e) {

    }



/*
        // *** POUR FAIRE UNE ACTION SUR UN DISTRICT ***
        for (int i = 0; i < district.length; i++) {
        district[].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                district.setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/3_Chem.png"));
            }
        }); }


        public void actionPerformed(ActionEvent e {
            setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/3_Chem.png");

        }

        }
    }

    public void populateCenter(JButton[] buttons) {
        for (JButton bu : buttons) {
            center.add(bu);
        }
    }


*/

}





