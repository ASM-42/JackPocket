public class PersonnagePlateau{
    public int[] position;
    private boolean visible;
    private int sabliers;
    public String statut; //coupable ou non

    public PersonnagePlateau(int sabliers) {
        this.sabliers = sabliers;
    }

    public PersonnagePlateau(int nbSabliers, boolean visible, String statut){
        this.visible = visible;
        this.statut = statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
