public class MrJack extends Player{

    public int nbSabliers;
    public PersonnagePlateau coupable ;

    public MrJack(String name, int role, int nbSabliers, PersonnagePlateau coupable) {
        super(name, role);
        this.nbSabliers = nbSabliers;
        this.coupable = coupable;
    }

}
