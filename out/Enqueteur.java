public class Enqueteur extends Player{
    public int nbSabliers;
    public PersonnageDetective Waston;
    public PersonnageDetective Tobby;
    public PersonnageDetective Sherlock;

    public Detective(String name, int role, int nbSabliers) {
        super(name, role);
        this.nbSabliers = nbSabliers;
    }

}
