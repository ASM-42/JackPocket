public class PersonnagePlateau extends MrJack {
    public int[] position;
    public boolean visible;
    public String statut;

    public PersonnagePlateau(String name, int role, int nbSabliers, PersonnagePlateau coupable, int[] position, boolean visible, String statut) {
        super(name, role, nbSabliers, coupable);
        this.position = position;
        this.visible = visible;
        this.statut = statut;
    }

}
