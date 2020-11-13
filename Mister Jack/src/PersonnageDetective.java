public class PersonnageDetective extends Detective {
    public int position;
    public int suspectVisibles;

    public PersonnageDetective(String name, int role, int nbSabliers, int position) {
        super(name, role, nbSabliers);
        this.position = position;
    }
}
