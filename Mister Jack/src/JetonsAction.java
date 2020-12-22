

import java.util.Scanner;
public class JetonsAction  {
    public String typeAction1;
    public String typeAction2;
    public String [] jetons;

    PersonnageDetective Watson;
    PersonnageDetective Tobby;
    PersonnageDetective Sherlock;

    public JetonsAction(String typeAction, String typeAction2) {
        this.typeAction1 = typeAction1;
        this.typeAction2 = typeAction2;
    }

    public void piocherAlibi (){

    }

    public void bougerSherlock () {
        String reponse1;
        Scanner scanner = new Scanner (System.int);
        System.out.println
                ("Voulez vous déplacer le détective d'un seul espace (tapez 1) ou de deux espaces (tapez 2) ?");
        reponse1 = scanner.next();
        if (reponse1.equals(1)){
            Sherlock.MoveDetective1(Sherlock.getPositionDetective());
        }
        if (reponse1.equals(2)){
            Sherlock.MoveDetective2(Sherlock.getPositionDetective());
        }
    }

    public void bougerTobby () {
        String reponse1;
        Scanner scanner = new Scanner (System.int)
        System.out.println
                ("Voulez vous déplacer le détective d'un seul espace (tapez 1) ou de deux espaces (tapez 2) ?");
        reponse1 = scanner.next();
        if (reponse1.equals(1)){
            Tobby.MoveDetective1(Tobby.getPositionDetective());
        }
        if (reponse1.equals(2)){
            Tobby.MoveDetective2(Tobby.getPositionDetective());
        }
    }

    public void bougerWatson () {
        String reponse1;
        Scanner scanner = new Scanner (System.int)
        System.out.println
                ("Voulez vous déplacer le détective d'un seul espace (tapez 1) ou de deux espaces (tapez 2) ?");
        reponse1 = scanner.next();
        if (reponse1.equals(1)){
            Watson.MoveDetective1(Watson.getPositionDetective());
        }
        if (reponse1.equals(2)){
            Watson.MoveDetective2(Watson.getPositionDetective());
        }
    }

    public void rotationDistrict () {

    }

    public void echangeDistrict() {

    }

    public void Joker (Player player) {

        String reponse1;
        String reponse2;
        Scanner scanner = new Scanner (System.int);

        if (player.getRole() == 1) //Detective
            System.out.println ("Quel detective voulez vous déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            Watson.MoveDetective1(Watson.getPositionDetective());
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock.getPositionDetective());
        if (reponse1.equals("Tobby"))
            Tobby.MoveDetective1(Tobby.getPositionDetective());

        if (player.getRole() == 0) //MrJack
            System.out.println ("Voulez vous déplacer un detective, si non tapez non si oui tapez le nom du detective à déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            Watson.MoveDetective1(Watson.getPositionDetective());
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock.getPositionDetective());
        if (reponse1.equals("Tobby"))
            Tobby.MoveDetective1(Tobby.getPositionDetective());

    }


}
