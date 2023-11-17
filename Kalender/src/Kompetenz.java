import java.util.ArrayList;

public class Kompetenz {
    private int ID;
    private String kompetenzname;
    private ArrayList<Mitglied> mitgliedsliste =new ArrayList<>();

    public Kompetenz(String kompetenz){
        this.kompetenzname = kompetenz;
    }

    public void addMitglied(Mitglied mitglied) {
        mitgliedsliste.add(mitglied);
    }

    public void delMitglied(Mitglied mitglied) {
        if (mitgliedsliste.contains(mitglied)) {
            mitgliedsliste.remove(mitglied);
        }
    }

    public String getKompetenzname() {
        return kompetenzname;
    }


    public void setKompetenz(String kompetenz) {
        this.kompetenzname = kompetenz;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
