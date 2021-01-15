import java.util.ArrayList;

public class PersonnageDetective extends Initialisation{
    private ArrayList<Object> positionDetective;
          //  (ArrayList<District>) Arrays.asList(D1, D1.getGauche());
                                        //[District, Gauche/Droite...]
    private ArrayList<Object> suspectVisibles;
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

    public ArrayList<Object> SuspectsVision(ArrayList<Object> positionDetective){
        District Dx = (District) positionDetective.get(0);
        ArrayList<Integer> side = (ArrayList<Integer>) positionDetective.get(1);
        while (side.get(0) != 1){
            suspectVisibles.add(Dx.getPersonnage());
            nbSuspectVisibles += 1;}
        return suspectVisibles;
    }

    public ArrayList<Object> getPositionDetective() {
        return positionDetective;
    }

    public PersonnageDetective(/*String name, int role*/ int nbSabliers, ArrayList<Object> positionDetective,
                                                         ArrayList<Object> suspectVisibles, int nbSuspectVisibles) {
        //super(name, role);
        this.positionDetective = positionDetective;
        this.suspectVisibles = suspectVisibles;
        this.nbSuspectVisibles = suspectVisibles.size();
        this.nbSabliers = nbSabliers;
    }


    public void setPositionDetective(ArrayList<Object> positionDetective) {
        this.positionDetective = positionDetective;
    }

    public ArrayList<Object> getSuspectVisibles() {
        return suspectVisibles;
    }

    public void setSuspectVisibles(ArrayList<Object> suspectVisibles) {
        this.suspectVisibles = suspectVisibles;
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
