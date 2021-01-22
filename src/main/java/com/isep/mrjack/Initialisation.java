package com.isep.mrjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Initialisation {

    //Détectives
    public ArrayList<PersonnagePlateau> SuspectsVisibles(Enqueteur player){
        ArrayList<PersonnagePlateau> suspects = new ArrayList<>(player.getSherlock().getSuspectVisibles());
        for (int w=0; w<player.Waston.getSuspectVisibles().size(); w++){
            suspects.add(player.Waston.getSuspectVisibles().get(w));
        }
        for (int t=0; t<player.Toby.getSuspectVisibles().size(); t++){
            suspects.add(player.Toby.getSuspectVisibles().get(t));
        }
        for (int i=0; i<suspects.size(); i++){
            for(int j=0; j<suspects.size(); j++){
                if (suspects.get(i) == suspects.get(j)){
                    suspects.remove(j);
                }}
        }
        return suspects;
    }





    //Création des cartes personnages et de la pioche
    PersonnagePlateau Madame;
    PersonnagePlateau JohnPizer;
    PersonnagePlateau JeremyBert;
    PersonnagePlateau InspLestrade;
    PersonnagePlateau WilliamGull;
    PersonnagePlateau JosephLane;
    PersonnagePlateau JohnSmith;
    PersonnagePlateau SgtGoodley;
    PersonnagePlateau MissStealthy;
    PersonnagePlateau[] pioche;
    PersonnagePlateau[] personnages;

    public PersonnagePlateau[] getPersonnages() {
        return personnages;
    }

    public ArrayList<PersonnagePlateau> innocents(ArrayList<PersonnagePlateau> suspects){
        ArrayList<PersonnagePlateau> innocents = new ArrayList<>();
        for (int x=0; x< personnages.length; x++){
            if(suspects.contains(personnages[x]) == false){
                innocents.add(personnages[x]);
            }
        }
        return innocents;
    }

    public static void removeElement(PersonnagePlateau[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }

    //Création des Districts et du com.isep.mrjack.Plateau de Jeu

    District D1;
    District D2;
    District D3;
    District D4;
    District D5;
    District D6;
    District D7;
    District D8;
    District D9;
    ArrayList<District> All;


    public void CreationPlateau (){
        ArrayList<District> Plateau = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<10; i++){
            int indice = random.nextInt(All.size());
            Plateau.add(All.get(indice));
            All.get(indice).setIndice(i);
            All.remove(indice);}
    }

    ArrayList<District> ligne1 = new ArrayList<District>(Arrays.asList(D1, D2, D3));
    ArrayList<District> ligne2 = new ArrayList<District>(Arrays.asList(D4, D5, D6));
    ArrayList<District> ligne3 = new ArrayList<District>(Arrays.asList(D7, D8, D9));
    public ArrayList<ArrayList<District>> plateauJeu =
            new ArrayList<ArrayList<District>>(Arrays.asList(ligne1, ligne2, ligne3));

    public District findPersonnage (PersonnagePlateau personnage){
        District d = D1;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; i++){
                if (plateauJeu.get(i).get(j).getPersonnage() == personnage){
                    d = plateauJeu.get(i).get(j);
                }   }   }
        return d;
    }

    //Création et com.isep.mrjack.Initialisation des jetons Actions
    JetonsAction jeton1;
    JetonsAction jeton2;
    JetonsAction jeton3;
    JetonsAction jeton4;


    //Création Jetons Temps
    int[] jetonT1;
    int[] jetonT2;
    int[] jetonT3;
    int[] jetonT4;
    int[] jetonT5;
    int[] jetonT6;
    int[] jetonT7;
    int[] jetonT8;
    int[][] jetonsTemps;

    public int[] getJetonsTemps(int tour) {
        return jetonsTemps[tour];
    }

    public District getD1() {
        return D1;
    }

    public void setD1(District d1) {
        D1 = d1;
    }

    public District getD2() {
        return D2;
    }

    public void setD2(District d2) {
        D2 = d2;
    }

    public District getD3() {
        return D3;
    }

    public void setD3(District d3) {
        D3 = d3;
    }

    public District getD4() {
        return D4;
    }

    public void setD4(District d4) {
        D4 = d4;
    }

    public District getD5() {
        return D5;
    }

    public void setD5(District d5) {
        D5 = d5;
    }

    public District getD6() {
        return D6;
    }

    public void setD6(District d6) {
        D6 = d6;
    }

    public District getD7() {
        return D7;
    }

    public void setD7(District d7) {
        D7 = d7;
    }

    public District getD8() {
        return D8;
    }

    public void setD8(District d8) {
        D8 = d8;
    }

    public District getD9() {
        return D9;
    }

    public void setD9(District d9) {
        D9 = d9;
    }

    public ArrayList<District> getLigne1() {
        return ligne1;
    }

    public void setLigne1(ArrayList<District> ligne1) {
        this.ligne1 = ligne1;
    }

    public ArrayList<District> getLigne2() {
        return ligne2;
    }

    public void setLigne2(ArrayList<District> ligne2) {
        this.ligne2 = ligne2;
    }

    public ArrayList<District> getLigne3() {
        return ligne3;
    }

    public void setLigne3(ArrayList<District> ligne3) {
        this.ligne3 = ligne3;
    }

    public ArrayList<ArrayList<District>> getPlateauJeu() {
        return plateauJeu;
    }

    public void setPlateauJeu(ArrayList<ArrayList<District>> plateauJeu) {
        this.plateauJeu = plateauJeu;
    }

    public PersonnagePlateau getMadame() {
        return Madame;
    }

    public void setMadame(PersonnagePlateau madame) {
        Madame = madame;
    }

    public PersonnagePlateau getJohnPizer() {
        return JohnPizer;
    }

    public void setJohnPizer(PersonnagePlateau johnPizer) {
        JohnPizer = johnPizer;
    }

    public PersonnagePlateau getJeremyBert() {
        return JeremyBert;
    }

    public void setJeremyBert(PersonnagePlateau jeremyBert) {
        JeremyBert = jeremyBert;
    }

    public PersonnagePlateau getInspLestrade() {
        return InspLestrade;
    }

    public void setInspLestrade(PersonnagePlateau inspLestrade) {
        InspLestrade = inspLestrade;
    }

    public PersonnagePlateau getWilliamGull() {
        return WilliamGull;
    }

    public void setWilliamGull(PersonnagePlateau williamGull) {
        WilliamGull = williamGull;
    }

    public PersonnagePlateau getJosephLane() {
        return JosephLane;
    }

    public void setJosephLane(PersonnagePlateau josephLane) {
        JosephLane = josephLane;
    }

    public PersonnagePlateau getJohnSmith() {
        return JohnSmith;
    }

    public void setJohnSmith(PersonnagePlateau johnSmith) {
        JohnSmith = johnSmith;
    }

    public PersonnagePlateau getSgtGoodley() {
        return SgtGoodley;
    }

    public void setSgtGoodley(PersonnagePlateau sgtGoodley) {
        SgtGoodley = sgtGoodley;
    }

    public PersonnagePlateau getMissStealthy() {
        return MissStealthy;
    }

    public void setMissStealthy(PersonnagePlateau missStealthy) {
        MissStealthy = missStealthy;
    }

    public PersonnagePlateau[] getPioche() {
        return pioche;
    }

    public void setPioche(PersonnagePlateau[] pioche) {
        this.pioche = pioche;
    }

    public JetonsAction getJeton1() {
        return jeton1;
    }

    public void setJeton1(JetonsAction jeton1) {
        this.jeton1 = jeton1;
    }

    public JetonsAction getJeton2() {
        return jeton2;
    }

    public void setJeton2(JetonsAction jeton2) {
        this.jeton2 = jeton2;
    }

    public JetonsAction getJeton3() {
        return jeton3;
    }

    public void setJeton3(JetonsAction jeton3) {
        this.jeton3 = jeton3;
    }

    public JetonsAction getJeton4() {
        return jeton4;
    }

    public void setJeton4(JetonsAction jeton4) {
        this.jeton4 = jeton4;
    }

    public int[] getJetonT1() {
        return jetonT1;
    }

    public void setJetonT1(int[] jetonT1) {
        this.jetonT1 = jetonT1;
    }

    public int[] getJetonT2() {
        return jetonT2;
    }

    public void setJetonT2(int[] jetonT2) {
        this.jetonT2 = jetonT2;
    }

    public int[] getJetonT3() {
        return jetonT3;
    }

    public void setJetonT3(int[] jetonT3) {
        this.jetonT3 = jetonT3;
    }

    public int[] getJetonT4() {
        return jetonT4;
    }

    public void setJetonT4(int[] jetonT4) {
        this.jetonT4 = jetonT4;
    }

    public int[] getJetonT5() {
        return jetonT5;
    }

    public void setJetonT5(int[] jetonT5) {
        this.jetonT5 = jetonT5;
    }

    public int[] getJetonT6() {
        return jetonT6;
    }

    public void setJetonT6(int[] jetonT6) {
        this.jetonT6 = jetonT6;
    }

    public int[] getJetonT7() {
        return jetonT7;
    }

    public void setJetonT7(int[] jetonT7) {
        this.jetonT7 = jetonT7;
    }

    public int[] getJetonT8() {
        return jetonT8;
    }

    public void setJetonT8(int[] jetonT8) {
        this.jetonT8 = jetonT8;
    }

    public Initialisation() {
        Madame = new PersonnagePlateau(2);
        JohnPizer = new PersonnagePlateau( 1);
        JeremyBert = new PersonnagePlateau(1);
        InspLestrade = new PersonnagePlateau( 0);
        WilliamGull = new PersonnagePlateau(1);
        JosephLane = new PersonnagePlateau(1);
        JohnSmith = new PersonnagePlateau(1);
        SgtGoodley = new PersonnagePlateau(0);
        MissStealthy = new PersonnagePlateau(1);
        pioche = new PersonnagePlateau[]{Madame, JohnPizer, JeremyBert, InspLestrade, WilliamGull, JosephLane, JohnSmith, SgtGoodley, MissStealthy};
        personnages = new PersonnagePlateau[]{Madame, JohnPizer, JeremyBert, InspLestrade, WilliamGull, JosephLane, JohnSmith, SgtGoodley, MissStealthy};

        D1 = new District(Madame, "/images/district/Madame.png");
        D2 = new District(JeremyBert, "/images/district/J_Bert.png");
        D3 = new District(JohnPizer, "/images/district/J_Pizzer.png");
        D4 = new District(InspLestrade, "/images/district/I_Lestrada.png");
        D5 = new District(WilliamGull, "/images/district/W_Gull.png");
        D6 = new District(JosephLane, "/images/district/J_Lane.png");
        D7 = new District(JohnSmith, "/images/district/J_Smith.png");
        D8 = new District(SgtGoodley, "/images/district/S_Goodley.png");
        D9 = new District(MissStealthy, "/images/district/M_Stealthy.png");
        All = new ArrayList<District>(Arrays.asList(D1, D2, D3, D4, D5, D6, D7, D8, D9));


        jeton1 = new JetonsAction("Sherlock", "Carte Alibi", this);
        jeton2 = new JetonsAction("Watson", "Toby", this);
        jeton3 = new JetonsAction("Rotation", "Joker", this);
        jeton4 = new JetonsAction("Rotation", "Echange", this);

        jetonT1 = new int[]{1, 1};
        jetonT2 = new int[]{2, 0};
        jetonT3 = new int[]{3, 1};
        jetonT4 = new int[]{4, 0};
        jetonT5 = new int[]{5, 1};
        jetonT6 = new int[]{6, 0};
        jetonT7 = new int[]{7, 1};
        jetonT8 = new int[]{8, 0};
        jetonsTemps = new int[][]{jetonT1, jetonT2, jetonT3, jetonT4, jetonT5, jetonT6, jetonT7, jetonT8};

    }
}
