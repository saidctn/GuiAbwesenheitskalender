import java.util.ArrayList;

public class Kompetenz {
    private int id;
    private String kompetenz;
    private int anzahlBeteiligte;
    private ArrayList<Mitglied> mitgliedsliste =new ArrayList<>();

    public Kompetenz(int id, String kompetenz){
        this.id =id;
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

    public int getAnzahlBeteiligte() {
        return anzahlBeteiligte;
    }

    public int getId() {
        return id;
    }

    public String getKompetenz() {
        return kompetenz;
    }

    public void setAnzahlBeteiligte(int anzahlBeteiligte) {
        this.anzahlBeteiligte = anzahlBeteiligte;
    }

    public void setKompetenz(String kompetenz) {
        this.kompetenz = kompetenz;
    }

    public void setId(int id) {
        this.id = id;
    }
}
