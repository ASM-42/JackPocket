public class PersonnageDetective extends Detective {
    public int position;
    public int suspectVisibles;

    public PersonnageDetective(String name, int role, int nbSabliers, int position) {
        super(name, role, nbSabliers);
        this.position = position;
    }
    int Vision(){
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
}
