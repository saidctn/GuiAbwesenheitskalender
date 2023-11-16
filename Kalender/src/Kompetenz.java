import java.util.ArrayList;

public class Kompetenz {
    private String kompetenz;
    private ArrayList<Mitglied> mitgliedsliste =new ArrayList<>();

    public Kompetenz(String kompetenz){
        this.kompetenz = kompetenz;
    }

    public void addMitglied(Mitglied mitglied) {
        mitgliedsliste.add(mitglied);
    }

    public void delMitglied(Mitglied mitglied) {
        if (mitgliedsliste.contains(mitglied)) {
            mitgliedsliste.remove(mitglied);
        }
    }

    public String getKompetenz() {
        return kompetenz;
    }


    public void setKompetenz(String kompetenz) {
        this.kompetenz = kompetenz;
    }

}
