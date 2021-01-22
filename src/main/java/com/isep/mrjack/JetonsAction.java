package com.isep.mrjack;

import java.util.Scanner;
import java.util.Random;
public class JetonsAction extends Initialisation {
    public String typeAction1;
    public String typeAction2;

    PersonnageDetective Watson;
    PersonnageDetective Toby;
    PersonnageDetective Sherlock;

    public JetonsAction(String typeAction1, String typeAction2) {
        this.typeAction1 = typeAction1;
        this.typeAction2 = typeAction2;
    }
///
    public void piocherAlibi (Player joueur){
        Random random = new Random();
        MrJack joueurM = new MrJack(joueur.getName());
        int x = random.nextInt(pioche.length);
        PersonnagePlateau carte = pioche[x];
        if (joueur.getRole() == 0){
            piocherAlibiMrJack(joueurM, carte); }
        else {
            carte.setStatut("innocent");
            findPersonnage(pioche[x]).turn();
        }
        removeElement(pioche, x);
    }

    public void piocherAlibiMrJack(MrJack joueurM, PersonnagePlateau personnagePlateau){
        joueurM.setNbSabliers(
                joueurM.getNbSabliers() + personnagePlateau.getSabliers());
    }

    public void bougerSherlock () {
        String reponse1;
        Scanner scanner = new Scanner (System.in);
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

    public void bougerToby () {
        String reponse1;
        Scanner scanner = new Scanner (System.in);
        System.out.println
                ("Voulez vous déplacer le détective d'un seul espace (tapez 1) ou de deux espaces (tapez 2) ?");
        reponse1 = scanner.next();
        if (reponse1.equals(1)){
            Toby.MoveDetective1(Toby.getPositionDetective());
        }
        if (reponse1.equals(2)){
            Toby.MoveDetective2(Toby.getPositionDetective());
        }
    }

    public void bougerWatson () {
        String reponse1;
        Scanner scanner = new Scanner (System.in);
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
        String district;
        District d = D1;
        String sens;
        String tour;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println
                ("Quel com.isep.mrjack.District souhaitez-vous déplacer? (ex : D1, D2...");
        district = scanner1.next();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println
                ("Dans quel sens (horaire ou anti-horaire) souhaitez vous le deplacer ?");
        sens = scanner2.next();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println
                ("Voulez - vous le déplacer d'un quart de tour ou d'un demi tour ?");
        tour = scanner3.next();
        if (district == "D1") {d = D1;}if (district == "D2") {d = D2;}if (district == "D3") {d = D3;}
        if (district == "D4") {d = D4;}if (district == "D5") {d = D5;}if (district == "D6") {d = D6;}
        if (district == "D7") {d = D7;}if (district == "D8") {d = D8;}if (district == "D9") {d = D9;}
        if (sens == "horaire") {
            if (tour == "quart") {
                d.swapQuartHoraire();
            }
            if (tour == "demi") {
                d.swapQuartHoraire();
                d.swapQuartHoraire();
            }
        }
        if (sens == "antihoraire") {
            if (tour == "quart") {
                d.swapQuartAntihoraire();
            }
            if (tour == "demi") {
                d.swapQuartAntihoraire();
                d.swapQuartAntihoraire();
            }
        }
    }
    public void echangeDistrict(){
        String district1;
        String district2;
        District d1 = D1;
        District d2 = D2;
        District temp = d1;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println
                ("Quel est le premier district que souhaitez-vous déplacer? (ex : D1, D2...");
        district1 = scanner1.next();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println
                ("Quel est le second district que souhaitez-vous déplacer? (ex : D1, D2...");
        district2 = scanner2.next();
        if (district1 == "D1") {d1 = D1;}if (district1 == "D2") {d1 = D2;}if (district1 == "D3") {d1 = D3;}
        if (district1 == "D4") {d1 = D4;}if (district1 == "D5") {d1 = D5;}if (district1 == "D6") {d1 = D6;}
        if (district1 == "D7") {d1 = D7;}if (district1 == "D8") {d1 = D8;}if (district1 == "D9") {d1 = D9;}

        if (district2 == "D1") {d2 = D1;}if (district2 == "D2") {d2 = D2;}if (district2 == "D3") {d2 = D3;}
        if (district2 == "D4") {d2 = D4;}if (district2 == "D5") {d2 = D5;}if (district2 == "D6") {d2 = D6;}
        if (district2 == "D7") {d2 = D7;}if (district2 == "D8") {d2 = D8;}if (district2 == "D9") {d2 = D9;}
        temp = d1; d1 = d2; d2 = d1;
    }
    public void Joker (Player player) {
        String reponse1;
        String reponse2;
        Scanner scanner = new Scanner (System.in);

        if (player.getRole() == 1) //Detective
            System.out.println ("Quel detective voulez vous déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            Watson.MoveDetective1(Watson.getPositionDetective());
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock.getPositionDetective());
        if (reponse1.equals("Toby"))
            Toby.MoveDetective1(Toby.getPositionDetective());

        if (player.getRole() == 0) //com.isep.mrjack.MrJack
            System.out.println ("Voulez vous déplacer un detective, si non tapez non si oui tapez le nom du detective à déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            Watson.MoveDetective1(Watson.getPositionDetective());
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock.getPositionDetective());
        if (reponse1.equals("Toby"))
            Toby.MoveDetective1(Toby.getPositionDetective());

    }

    public void faireAction(String typeAction1, Player player){
        if (typeAction1 == "Rotation"){
            rotationDistrict();
        }
        if (typeAction1 == "Sherlock"){
            bougerSherlock();
        }
        if (typeAction1 == "Watson"){
            bougerWatson();
        }
        if (typeAction1 == "Toby"){
            bougerToby();
        }
        if (typeAction1 == "Echange"){
            echangeDistrict();
        }
        if (typeAction1 == "Joker"){
            Joker(player);
        }
    }


    public String getTypeAction1() {
        return typeAction1;
    }

    public void Action(int action, Player player) {
        if (action == 1){
            faireAction(typeAction1, player);
        }
        if (action == 2){
            faireAction(typeAction2, player);
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

    public PersonnageDetective getWatson() {
        return Watson;
    }

    public void setWatson(PersonnageDetective watson) {
        Watson = watson;
    }

    public PersonnageDetective getToby() {
        return Toby;
    }

    public void setToby(PersonnageDetective toby) {
        Toby = toby;
    }

    public PersonnageDetective getSherlock() {
        return Sherlock;
    }

    public void setSherlock(PersonnageDetective sherlock) {
        Sherlock = sherlock;
    }
}
