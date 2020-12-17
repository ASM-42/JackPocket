import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
public class District {
    private String orientation; //"up" = personnages, "down" pas de personnage
    private ArrayList<Integer> Position1; // 0 vide, 1 mur    0 accessible, 1 non accessible aux detectives
    private ArrayList<Integer> Position2;
    private ArrayList<Integer> Position3;
    private ArrayList<Integer> Position4;
    private ArrayList<ArrayList<Integer>> cotés;
    private PersonnagePlateau personnage;

    public void turn () {
        System.out.println("I'm going to switch");
        if (orientation == "up");
            orientation = "down";
            personnage.setVisible(false);
    }

    public District(String orientation, ArrayList<ArrayList<Integer>> cotés,
                    ArrayList<Integer> Position1, ArrayList<Integer> Position2, ArrayList<Integer> Position3,
                    ArrayList<Integer> Position4) {
        this.orientation = "up";
        this.Position1 = Position1;
        Position1.add(1); Position1.add(1);
        this.Position2 = Position2;
        Position2.add(0); Position2.add(0);
        this.Position3 = Position3;
        Position3.add(0); Position3.add(0);
        this.Position4 = Position4;
        Position4.add(0); Position4.add(0);
        this.cotés = cotés;
        cotés.add(Position1); cotés.add(Position2); cotés.add(Position3); cotés.add(Position4);

    }

    public String getOrientation() {
        return orientation; }

    public void setOrientation(String orientation) {
        this.orientation = orientation; }

    public ArrayList<Integer> getPosition1() {
        return Position1; }

    public void setPosition1(ArrayList<Integer> position1) {
        Position1 = position1; }

    public ArrayList<Integer> getPosition2() {
        return Position2; }

    public void setPosition2(ArrayList<Integer> position2) {
        Position2 = position2; }

    public ArrayList<Integer> getPosition3() {
        return Position3; }

    public void setPosition3(ArrayList<Integer> position3) {
        Position3 = position3; }

    public ArrayList<Integer> getPosition4() {
        return Position4; }

    public void setPosition4(ArrayList<Integer> position4) {
        Position4 = position4; }

    public ArrayList<ArrayList<Integer>> getCotés() {
        return cotés; }

    public PersonnagePlateau getPersonnage() {
        return personnage; }

}
