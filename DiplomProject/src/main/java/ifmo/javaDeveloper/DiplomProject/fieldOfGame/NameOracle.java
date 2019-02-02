package ifmo.javaDeveloper.DiplomProject.fieldOfGame;

public class NameOracle {
    private String name;
    private int lengthName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLengthName() {
        return name.length ();
    }

    public void setLengthName(int lengthName) {
        this.lengthName = lengthName;
    }
}
