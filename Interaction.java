import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interaction extends JPanel {


    public Interaction() {
        super(new GridLayout());
       // this.add
    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.BLUE);
        g.drawString("BIENVENUE SUR MISTER JACK POCKET", 50, 50);

        g.setColor(Color.red);
      //  g.drawString("Hello", 100, 100);
    }
}