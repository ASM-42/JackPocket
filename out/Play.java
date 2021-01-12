import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Play {

    int tourActuel;

//Création des Districts et du Plateau de Jeu
    District[] districts;
    District D1 = new District(); District D2 = new District(); District D3 = new District();
    District D4 = new District(); District D5 = new District(); District D6 = new District();
    District D7 = new District(); District D8 = new District(); District D9 = new District();
    ArrayList<District> ligne1 = (ArrayList<District>) Arrays.asList(D1, D2, D3);
    ArrayList<District> ligne2 = (ArrayList<District>) Arrays.asList(D4, D5, D6);
    ArrayList<District> ligne3 = (ArrayList<District>) Arrays.asList(D7, D8, D9);
    ArrayList<ArrayList<District>> plateauJeu =
            (ArrayList<ArrayList<District>>) Arrays.asList(ligne1, ligne2, ligne3);

    public Play() {
        Player player1 = new Player("name", 0) {};Player player2 = new Player("name", 0) {};
        String reponse1;Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du premier joueur:");
        reponse1 = scanner.next();player1.setName(reponse1);
        System.out.println("Entrez le nom du second joueur:");
        reponse1 = scanner.next();player2.setName(reponse1);
        System.out.println
                ("Joueur 1 souhaitez vous jouer MrJack ou Detective ?");
        reponse1 = scanner.next();
        if (reponse1 == "MrJack") {
            player1.setRole(0);player2.setRole(1);
            System.out.println(player1.getName() + "vous jouez MrJack" + player2.getName() + "vous jouez le Detetctive");
        }else {
            player1.setRole(1);player2.setRole(0);
            System.out.println(player2.getName() + "vous jouez MrJack" + player1.getName() + "vous jouez le Detetctive");}

    }

        public static void main (String[]args){

//Création des cartes personnages et de la pioche
            PersonnagePlateau Madame = new PersonnagePlateau(2);
            PersonnagePlateau JohnPizer = new PersonnagePlateau(1);
            PersonnagePlateau JeremyBert = new PersonnagePlateau(1);
            PersonnagePlateau InspLestrade = new PersonnagePlateau(0);
            PersonnagePlateau WilliamGull = new PersonnagePlateau(1);
            PersonnagePlateau JosephLane = new PersonnagePlateau(1);
            PersonnagePlateau JohnSmith = new PersonnagePlateau(1);
            PersonnagePlateau SgtGoodley = new PersonnagePlateau(0);
            PersonnagePlateau MissStealthy = new PersonnagePlateau(1);
            ArrayList<PersonnagePlateau> pioche = new ArrayList<>();
            pioche.add(Madame);
            pioche.add(JohnPizer);
            pioche.add(JeremyBert);
            pioche.add(InspLestrade);
            pioche.add(WilliamGull);
            pioche.add(JosephLane);
            pioche.add(JohnSmith);
            pioche.add(SgtGoodley);
            pioche.add(MissStealthy);

//Creéation et Initialisation des jetons Actions
            JetonsAction jeton1 = new JetonsAction("Sherlock", "Carte Alibi");
            JetonsAction jeton2 = new JetonsAction("Watson", "Tobby");
            JetonsAction jeton3 = new JetonsAction("Rotation", "Joker");
            JetonsAction jeton4 = new JetonsAction("Rotation", "Echange");


//Jeu

        }

    }