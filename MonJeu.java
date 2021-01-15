import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonJeu extends JFrame {


    public MonJeu() {
        super("Mon jeu");
    }

    public void initJeu() {
        Plateau pan = new Plateau();
        this.setContentPane(pan);
    }

    public void rotateDistrict(JButton[] boutons) {
        // Tourner de 90° la tile n
        
    }

    public ActionListener retournerDistrict() {

    }
    
 /*           district1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            district1.setIcon(new ImageIcon("/Users/soso/IdeaProjects/MisterJackPocket/src/3_Chem.png"));
        }
    }); */



}