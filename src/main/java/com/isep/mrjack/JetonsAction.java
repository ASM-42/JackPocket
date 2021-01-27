package com.isep.mrjack;

import java.util.Scanner;
import java.util.Random;
public class JetonsAction {
    Initialisation jeu;
    public String typeAction1;
    public String typeAction2;
    public String image1;
    public String image2;
    public String[] action1 = new String[]{typeAction1, image1};
    public String[] action2 = new String[]{typeAction1, image2};

    PersonnageDetective Watson;
    PersonnageDetective Toby;
    PersonnageDetective Sherlock;

    public JetonsAction(String[] action1, String[] action2, Initialisation jeu) {
        this.jeu = jeu;
        this.action1 = action1;
        this.action2 = action2;
        this.typeAction1 = action1[0]; this.image1 = action1[1];
        this.typeAction2 = action2[0]; this.image2 = action2[1];
    }

    public void piocherAlibi (Player joueur){
        MrJack joueurM = new MrJack(joueur.getName());
        PersonnagePlateau carte = jeu.personnages.get(jeu.pioche.get(0));
        if (joueur.getRole() == 0){
            piocherAlibiMrJack(joueurM, carte); }
        else {
            carte.setStatut("innocent");
            jeu.findPersonnage(carte).turn();
        }
        jeu.pioche.remove(0);
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
            Sherlock.MoveDetective1(Sherlock);
        }
        if (reponse1.equals(2)){
            Sherlock.MoveDetective2(Sherlock);
        }
    }

    public void bougerToby () {
        String reponse1;
        Scanner scanner = new Scanner (System.in);
        System.out.println
                ("Voulez vous déplacer le détective d'un seul espace (tapez 1) ou de deux espaces (tapez 2) ?");
        reponse1 = scanner.next();
        if (reponse1.equals(1)){
            Toby.MoveDetective1(Toby);
        }
        if (reponse1.equals(2)){
            Toby.MoveDetective2(Toby);
        }
    }

    public void bougerWatson () {
        String reponse1;
        Scanner scanner = new Scanner (System.in);
        System.out.println
                ("Voulez vous déplacer le détective d'un seul espace (tapez 1) ou de deux espaces (tapez 2) ?");
        reponse1 = scanner.next();
        if (reponse1.equals(1)){
            Watson.MoveDetective1(Watson);
        }
        if (reponse1.equals(2)){
            Watson.MoveDetective2(Watson);
        }
    }

    public void rotationDistrict () {
        String district;
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
        District d = jeu.districts.get(district);
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

        Scanner scanner1 = new Scanner(System.in);
        System.out.println
                ("Quel est le premier district que souhaitez-vous déplacer? (ex : D1, D2...");
        district1 = scanner1.next();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println
                ("Quel est le second district que souhaitez-vous déplacer? (ex : D1, D2...");
        district2 = scanner2.next();
        District d1 = jeu.districts.get(district1);
        District d2 = jeu.districts.get(district2);
        District temp = d1;
        jeu.districts.put(district1, d2);
        jeu.districts.put(district2, temp);
    }
    public void Joker (Player player) {
        String reponse1;
        String reponse2;
        Scanner scanner = new Scanner (System.in);

        if (player.getRole() == 1) //Detective
            System.out.println ("Quel detective voulez vous déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            Watson.MoveDetective1(Watson);
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock);
        if (reponse1.equals("Toby"))
            Toby.MoveDetective1(Toby);

        if (player.getRole() == 0) //com.isep.mrjack.MrJack
            System.out.println ("Voulez vous déplacer un detective, si non tapez non si oui tapez le nom du detective à déplacer ?");
        reponse1 = scanner.next();
        if (reponse1.equals("Watson"))
            Watson.MoveDetective1(Watson);
        if (reponse1.equals("Sherlock"))
            Sherlock.MoveDetective1(Sherlock);
        if (reponse1.equals("Toby"))
            Toby.MoveDetective1(Toby);

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

    public String[] quelleAction(int r){
        if (r==1){
            return action1;
        }
        return action2;
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
