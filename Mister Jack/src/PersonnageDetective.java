import java.util.ArrayList;
import java.util.Arrays;

public class PersonnageDetective extends Plateau{
    private ArrayList<Object> positionDetective = (ArrayList<Object>) Arrays.asList(D1, D1.getGauche()); //[District, Gauche/Droite...]
    private ArrayList<String> suspectVisibles;
    private int nbSuspectVisibles;
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

    public void MoveDetective2 (ArrayList positionDetective){
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

    public Vision(Detective detective, ){
        Visibilite=0;

        if (Position=Dx[0]) {
            if (Dx[0][0]=1) {
                Visibilite=0;
            }
            if (Dx[0][0]=0) {
                while (Dx[0][0]!= 1) {
                    Dx= Dx+1;       //Vers la droite
                    Visibilite=Dx;
                }
            }

        }
        if (Position=Dx[1])  {
            if (Dx[1][0]=1){
                Visibilite=0;
            }
            if (Dx[1][0]=0){
                while (Dx[1][0]!= 1) {
                    Dx= Dx+3; //Vers le bas
                    Visibilite=Dx;
                }

            }
        }
        if (Position=Dx[2]) {
            if (Dx[2][0]=1){
                Visibilite=0;
            }
            if (Dx[2][0]=0) {
                while (Dx[2][0]!= 1) {
                    Dx= Dx-1;       //Vers la gauche
                    Visibilite=Dx;
                }
            }
        }
        if (Position=Dx[3]) {
            if (Dx[3][0]=1){
                Visibilite=0;
            }
            if (Dx[3][0]=0) {
                while (Dx[3][0]!= 1) {
                    Dx= Dx-3;       //Vers le haut
                    Visibilite=Dx;
                }
            }
        }
    }
    public ArrayList<Object> getPositionDetective() {
        return positionDetective;
    }

    public PersonnageDetective(/*String name, int role*/ int nbSabliers, ArrayList<Object> positionDetective,
                               ArrayList<String> suspectVisibles, int nbSuspectVisibles) {
        //super(name, role);
        this.positionDetective = positionDetective;
        this.suspectVisibles = suspectVisibles;
        this.nbSuspectVisibles = suspectVisibles.size();
        this.nbSabliers = nbSabliers;
    }


    public void setPositionDetective(ArrayList<Object> positionDetective) {
        this.positionDetective = positionDetective;
    }

    public ArrayList<String> getSuspectVisibles() {
        return suspectVisibles;
    }

    public void setSuspectVisibles(ArrayList<String> suspectVisibles) {
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
