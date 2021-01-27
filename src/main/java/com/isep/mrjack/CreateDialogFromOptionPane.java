package com.isep.mrjack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateDialogFromOptionPane extends JFrame {



    public static void main(String[] args) {
        JFrame parent = new JFrame();
        parent.setAlwaysOnTop(true);
        //parent.setSize(400, 1000);
        JButton button1 = new JButton();

        button1.setText("Lancer une partie");
        parent.add(button1);
        //parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.setContentPane(button1);
        parent.pack();
        parent.setVisible(true);

        button1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parent.dispose();
                String nomJoueur1 = JOptionPane.showInputDialog(
                        "Entrez le nom du premier joueur:", "Amandine");
                //player1.setName(nomJoueur1)
                String nomJoueur2 = JOptionPane.showInputDialog
                        ("Entrez le nom du second joueur:", "Solene");
                String role1 = JOptionPane.showInputDialog(
                        nomJoueur1 + " souhaitez vous jouer MrJack ou Detective ?");








            }
        });

    }
}