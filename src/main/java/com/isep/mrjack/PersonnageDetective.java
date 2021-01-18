package com.isep.mrjack;

import java.util.ArrayList;

public class PersonnageDetective extends Initialisation{
    private ArrayList<Object> positionDetective;
          //  (ArrayList<com.isep.mrjack.District>) Arrays.asList(D1, D1.getGauche());
                                        //[com.isep.mrjack.District, Gauche/Droite...]
    private ArrayList<PersonnagePlateau> suspectVisibles;
    private int nbSuspectVisibles = suspectVisibles.size() +1;
    public int nbSabliers;


    public void MoveDetective1 (ArrayList positionDetective){
        if (positionDetective.get(0) == D1){
            if (positionDetective.get(1) == D1.getGauche())
                positionDetective.set(1, D1.getHaut());
            if (positionDetective.get(1) == D1.getHaut()){
                positionDetective.set(0, D2);
                positionDetective.set(1, D2.getHaut());}
            }

        else if (positionDetective.get(0) == D2){
            positionDetective.set(0, D3);
            positionDetective.set(1, D3.getHaut());
        }

        else if (positionDetective.get(0) == D3){
            if (positionDetective.get(1) == D3.getHaut())
                positionDetective.set(1, D3.getDroite());
            if (positionDetective.get(1) == D3.getDroite()){
                positionDetective.set(0, D6);
                positionDetective.set(1, D6.getDroite());}
        }

        else if (positionDetective.get(0) == D4){
            positionDetective.set(0, D1);
            positionDetective.set(1, D1.getGauche());}

        else if (positionDetective.get(0) == D6){
            positionDetective.set(0, D9);
            positionDetective.set(1, D9.getDroite());
        }

        else if (positionDetective.get(0) == D7){
            if (positionDetective.get(1) == D7.getGauche()){
                positionDetective.set(0, D4);
                positionDetective.set(1, D4.getGauche()); }
            if (positionDetective.get(1) == D7.getBas())
                positionDetective.set(0, D7.getGauche());
            }

        else if (positionDetective.get(0) == D8){
            positionDetective.set(0, D7);
            positionDetective.set(1, D7.getBas());
        }

        else if (positionDetective.get(0) == D9){
            if (positionDetective.get(1) == D9.getDroite())
                positionDetective.set(1, D9.getBas());
            if (positionDetective.get(1) == D9.getBas()){
                positionDetective.set(0, D8);
                positionDetective.set(1, D8.getBas());}
        }
    }

    public void MoveDetective2 (ArrayList<Object> positionDetective){
        if (positionDetective.get(0) == D1){
            if (positionDetective.get(1) == D1.getGauche()){
                positionDetective.set(0, D2);
                positionDetective.set(1, D2.getHaut());}
            if (positionDetective.get(1) == D1.getHaut()){
                positionDetective.set(0, D3);
                positionDetective.set(1, D3.getHaut());}
        }

        else if (positionDetective.get(0) == D2){
            positionDetective.set(0, D3);
            positionDetective.set(1, D3.getDroite());
        }

        else if (positionDetective.get(0) == D3){
            if (positionDetective.get(1) == D3.getHaut()){
                positionDetective.set(0, D6);
                positionDetective.set(1, D6.getDroite());}
            if (positionDetective.get(1) == D3.getDroite()){
                positionDetective.set(0, D9);
                positionDetective.set(1, D9.getDroite());}
        }

        else if (positionDetective.get(0) == D4){
            positionDetective.set(0, D1);
            positionDetective.set(1, D1.getHaut());}

        else if (positionDetective.get(0) == D6){
            positionDetective.set(0, D9);
            positionDetective.set(1, D9.getBas());
        }

        else if (positionDetective.get(0) == D7){
            if (positionDetective.get(1) == D7.getGauche()){
                positionDetective.set(0, D1);
                positionDetective.set(1, D1.getGauche()); }
            if (positionDetective.get(1) == D7.getBas()){
                positionDetective.set(0, D4);
                positionDetective.set(1, D4.getGauche()); }
        }

        else if (positionDetective.get(0) == D8){
            positionDetective.set(0, D7);
            positionDetective.set(1, D7.getGauche());
        }

        else if (positionDetective.get(0) == D9){
            if (positionDetective.get(1) == D9.getDroite()){
                positionDetective.set(0, D8);
                positionDetective.set(1, D8.getBas());}
            if (positionDetective.get(1) == D9.getBas()){
                positionDetective.set(0, D7);
                positionDetective.set(1, D7.getBas());}
        }
    }

    public ArrayList<PersonnagePlateau> SuspectsVision(ArrayList<Object> positionDetective){
        District Dx = (District) positionDetective.get(0);
        ArrayList<Integer> side = (ArrayList<Integer>) positionDetective.get(1);
        while (side.get(0) != 1){
            suspectVisibles.add(Dx.getPersonnage());
            nbSuspectVisibles += 1;}
        return suspectVisibles;
    }

    public void setPositionDetective(ArrayList<Object> positionDetective) {
        this.positionDetective = positionDetective;
    }

    public ArrayList<PersonnagePlateau> getSuspectVisibles() {
        return suspectVisibles;
    }

    public void setSuspectVisibles(ArrayList<PersonnagePlateau> suspectVisibles) {
        this.suspectVisibles = suspectVisibles;
    }

    public ArrayList<Object> getPositionDetective() {
        return positionDetective;
    }

    public PersonnageDetective(/*String name, int role*/ int nbSabliers, ArrayList<Object> positionDetective, int nbSuspectVisibles) {
        //super(name, role);
        this.positionDetective = positionDetective;
        this.suspectVisibles = SuspectsVision(this.positionDetective);
        this.nbSuspectVisibles = suspectVisibles.size();
        this.nbSabliers = nbSabliers;
    }



    public int getNbSuspectVisibles() {
        return nbSuspectVisibles;
    }

    public void setNbSuspectVisibles(int nbSuspectVisibles) {
        this.nbSuspectVisibles = nbSuspectVisibles;
    }

    public int getNbSabliers() {
        return nbSabliers;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
    }


}