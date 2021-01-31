package com.isep.mrjack;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Initialisation {


  public  int removeDuplicateElements(ArrayList<PersonnagePlateau> arr, int n){
    if (n==0 || n==1){
      return n;
    }
    ArrayList<PersonnagePlateau> temp = new ArrayList<>();
    int j = 0;
    for (int i=0; i<n-1; i++){
      if (arr.get(i) != arr.get(i + 1)){
        temp.set(j++, arr.get(i));
      }
    }
    temp.set(j++, arr.get(n - 1));
    for (int i=0; i<j; i++){
      arr.set(i, temp.get(i));
    }
    return j;
  }

  //Détectives
  public ArrayList<PersonnagePlateau> SuspectsVisibles(Enqueteur player, Plateau plateau) {
    ArrayList<PersonnagePlateau> suspects = new ArrayList<>(player.getSherlock().getSuspectVisibles());
    for (int w = 0; w < player.Waston.getSuspectVisibles().size(); w++) {
      suspects.add(player.Waston.getSuspectVisibles().get(w));
    }
    for (int t = 0; t < player.Toby.getSuspectVisibles().size(); t++) {
      suspects.add(player.Toby.getSuspectVisibles().get(t));
    }
    removeDuplicateElements(suspects, suspects.size());
    for (int i = 0; i < suspects.size(); i++) {
      findPersonnage(personnages.get(suspects.get(i))).turn(plateau);
    }
    return suspects;
  }

  public List<PersonnagePlateau> innocents(List<PersonnagePlateau> suspects) {
    List<PersonnagePlateau> innocents = new ArrayList<>();
    for (PersonnagePlateau perso : personnages.values()) {
      if (!suspects.contains(perso)) {
        innocents.add(perso);
      }
    }
    return innocents;
  }

  List<String> pioche = new LinkedList<>();
  Map<String, PersonnagePlateau> personnages = new HashMap<>();

  public int index(String[] table, String e){
    for(int i=0; i<table.length; i++){
      if(table[i] == e){
        return i;
      }
    }
    return 1;
  }


  public JetonsAction[] removeElement(JetonsAction[] arr, int removedIdx) {
    System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    return arr;
  }

  public String[] removeElementString(String[] arr, int removedIdx) {
    System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    return arr;
  }


  //Création des Districts et du com.isep.mrjack.Plateau de Jeu

  List<String> imagesPlateau = new LinkedList<>();
  List<String> nomsDistricts;

  Map<String, District> districts = new HashMap<>(9);


//  public void CreationPlateau() {
//    ArrayList<District> Plateau = new ArrayList<>();
//    Random random = new Random();
//    for (int i = 0; i < 10; i++) {
//      int indice = random.nextInt(All.size());
//      Plateau.add(All.get(indice));
//      All.get(indice).setIndice(i);
//      All.remove(indice);
//    }
//  }

  public District findPersonnage(PersonnagePlateau personnage) {
      District d = null;
      for(District district: districts.values()) {
          if (district.getPersonnage() == personnage){
              d = district;}
      }
      return d;
  }

  //Création et com.isep.mrjack.Initialisation des jetons Actions
  JetonsAction jeton1;
  JetonsAction jeton2;
  JetonsAction jeton3;
  JetonsAction jeton4;
  JetonsAction[] jetonsActionTour;


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


  MrJack joueurM;
  Enqueteur joueurE;
  PersonnageDetective Watson;
  PersonnageDetective Toby;
  PersonnageDetective Sherlock;
  /*Plateau plateau;

  public void initJeu() {
    this.setContentPane(plateau);
  }
*/
  public Initialisation() {
    List<String> nomsPersonnages = List.of("Madame", "Jeremy Bert","John Pizzer", "Inspecteur Lestrade", "William Gull", "Joseph Lane",
            "John Smith", "Sergent Goodley", "Miss Stealthy");
    List<String> imagesAlibi = List.of("Madame-alibi", "JohnPizer-alibi", "JeremyBert-alibi", "InspLestrade-alibi","WilliamGull-alibi","JosephLane-alibi",
            "JohnSmith-alibi", "SgtGoodley-alibi", "MissStealthy-alibi");
    int[] sabliers = {2, 1, 1, 0, 1, 1, 1, 0, 1};
    for (int i = 0; i < sabliers.length; i++) {
      PersonnagePlateau perso = new PersonnagePlateau(nomsPersonnages.get(i), sabliers[i], imagesAlibi.get(i));
      pioche.add(nomsPersonnages.get(i));
      personnages.put(nomsPersonnages.get(i), perso);
    }
    Collections.shuffle(pioche);

    List<String> imagesD = List.of("Madame", "J_Bert", "J_Pizzer", "I_Lestrada", "W_Gull", "J_Lane", "J_Smith", "S_Goodley", "M_Stealthy");
    nomsDistricts = List.of("D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9");
    for (int i = 0; i < imagesD.size(); i++) {
      String nomPerso = nomsPersonnages.get(i);
      imagesPlateau.add(imagesD.get(i));
      District d = new District(personnages.get(nomPerso), new String[]{imagesD.get(i), "3_Chem"});
      d.setIndice(i);
      if (i == 0){ d.swapQuartHoraire();}
      if (i == 2){ d.swapQuartAntihoraire();}
      if (nomPerso == "J_Lane"){d.setImages("4_Chem");}
      this.districts.put(nomsDistricts.get(i), d);
    }
    //Collections.shuffle(nomsDistricts);
    //Collections.shuffle(imagesPlateau);


    jeton1 = new JetonsAction(new String[]{"Sherlock","Carte Alibi"}, new String[]{"/images/jet_action/BougerSherlock.png", "/images/jet_action/PiocheAlibi.png"}, this);
    jeton2 = new JetonsAction(new String[]{"Watson", "Toby"}, new String[]{"/images/jet_action/BougerWatson.png", "/images/jet_action/BougerToby.png"}, this);
    jeton3 = new JetonsAction(new String[]{"Rotation", "Joker"}, new String[]{"/images/jet_action/Rotation.png", "/images/jet_action/Joker.png"}, this);
    jeton4 = new JetonsAction(new String[]{"Rotation", "Echange"}, new String[]{"/images/jet_action/Rotation.png", "/images/jet_action/Echange.png"}, this);
    jetonsActionTour = new JetonsAction[] {jeton1, jeton2, jeton3, jeton4};

    jetonT1 = new int[]{1, 1};
    jetonT2 = new int[]{2, 0};
    jetonT3 = new int[]{3, 1};
    jetonT4 = new int[]{4, 0};
    jetonT5 = new int[]{5, 1};
    jetonT6 = new int[]{6, 0};
    jetonT7 = new int[]{7, 1};
    jetonT8 = new int[]{8, 0};
    jetonsTemps = new int[][]{jetonT1, jetonT2, jetonT3, jetonT4, jetonT5, jetonT6, jetonT7, jetonT8};

    joueurM = new MrJack("nameM");



    Watson = new PersonnageDetective(new ArrayList<Object>(Arrays.asList("D3", this.districts.get("D3").getDroite())), "/images/jet_detec/Watson.png", this);
    Toby = new PersonnageDetective(new ArrayList<Object>(Arrays.asList("D8", this.districts.get("D8").getBas())), "/images/jet_detec/Tobby.png", this);
    Sherlock = new PersonnageDetective(new ArrayList<Object>(Arrays.asList("D1", this.districts.get("D1").getGauche())), "/images/jet_detec/Holmes.png", this);


    joueurE = new Enqueteur("nameE", Watson, Toby, Sherlock);


  }
}
