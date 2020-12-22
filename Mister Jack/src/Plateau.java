import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {
    public District[] districts;
    District D1 = new District(); District D2 = new District(); District D3 = new District();
    District D4 = new District(); District D5 = new District(); District D6 = new District();
    District D7 = new District(); District D8 = new District(); District D9 = new District();
    public ArrayList<District> ligne1 = (ArrayList<District>) Arrays.asList(D1, D2, D3);
    public ArrayList<District> ligne2 = (ArrayList<District>) Arrays.asList(D4, D5, D6);
    public ArrayList<District> ligne3 = (ArrayList<District>) Arrays.asList(D7, D8, D9);
    public ArrayList<ArrayList<District>> plateauJeu =
            (ArrayList<ArrayList<District>>) Arrays.asList(ligne1, ligne2, ligne3);
}
