package com.isep.mrjack;

import java.util.*;

public class Initialisation {

  //Détectives
  public ArrayList<PersonnagePlateau> SuspectsVisibles(Enqueteur player) {
    ArrayList<PersonnagePlateau> suspects = new ArrayList<>(player.getSherlock().getSuspectVisibles());
    for (int w = 0; w < player.Waston.getSuspectVisibles().size(); w++) {
      suspects.add(player.Waston.getSuspectVisibles().get(w));
    }
    for (int t = 0; t < player.Toby.getSuspectVisibles().size(); t++) {
      suspects.add(player.Toby.getSuspectVisibles().get(t));
    }
    for (int i = 0; i < suspects.size(); i++) {
      for (int j = 0; j < suspects.size(); j++) {
        if (suspects.get(i) == suspects.get(j)) {
          suspects.remove(j);
        }
      }
    }
    return suspects;
  }


  List<String> pioche = new LinkedList<>();
  Map<String, PersonnagePlateau> personnages = new HashMap<>();


  public List<PersonnagePlateau> innocents(List<PersonnagePlateau> suspects) {
    List<PersonnagePlateau> innocents = new ArrayList<>();
    for (PersonnagePlateau perso : personnages.values()) {
      if (!suspects.contains(perso)) {
        innocents.add(perso);
      }
    }
    return innocents;
  }

  public static void removeElement(PersonnagePlateau[] arr, int removedIdx) {
    System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
  }

  //Création des Districts et du com.isep.mrjack.Plateau de Jeu

  Map<String, District> districts = new HashMap<>();


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
          if (district.getPersonnage() == personnage)
              d = district;
      }
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
    List<String> nomsPersonnages = List.of("Madame", "JohnPizer", "JeremyBert", "InspLestrade", "WilliamGull", "JosephLane",
            "JohnSmith", "SgtGoodley", "MissStealthy");
    int[] sabliers = {2, 1, 1, 0, 1, 1, 1, 0, 1};
    for (int i = 0; i < sabliers.length; i++) {
      PersonnagePlateau perso = new PersonnagePlateau(sabliers[i]);
      pioche.add(nomsPersonnages.get(i));
      personnages.put(nomsPersonnages.get(i), perso);
    }
    Collections.shuffle(pioche);
    System.out.printf("Size of pioche: %d\n", pioche.size());

    List<String> imagesPersonnages = List.of("Madame", "J_Bert", "J_Pizzer", "I_Lestrada", "W_Gull", "J_Lane", "J_Smith", "S_Goodley", "M_Stealthy");
    List<String> nomsDistricts = List.of("D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9");
    for (int i = 0; i < imagesPersonnages.size(); i++) {
      String nomPerso = nomsPersonnages.get(i);
      District d = new District(personnages.get(nomPerso), String.format("/images/district/%s.png", imagesPersonnages.get(i)));
      this.districts.put(nomsDistricts.get(i), d);
    }


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
