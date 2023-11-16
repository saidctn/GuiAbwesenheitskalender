import java.util.ArrayList;

public class Mitglied {
   protected static int id;
    private String vorname;
    private String nachname;
    private String lieblingsfarbe;
    private ArrayList<Kompetenz> kompetenzliste = new ArrayList<>();
    private ArrayList<Abwesenheit> abwesenheitsliste = new ArrayList<>();

    Mitglied(String vorname,String nachname, String lieblingsfarbe){
        this.lieblingsfarbe = lieblingsfarbe;
        this.vorname = vorname;
        this.nachname = nachname;
    }
    public void addAbwesenheit(Abwesenheit a){
        abwesenheitsliste.add(a);
    }

    public void delAbwesenheit(Abwesenheit a){
        if (abwesenheitsliste.contains(a)){
            abwesenheitsliste.remove(a);
        }
    }

    public void addKompetenz(Kompetenz k){
        kompetenzliste.add(k);
    }
    public void delKompetenz(Kompetenz k){
        if (kompetenzliste.contains(k)) {
            kompetenzliste.remove(k);
        }
    }

    public ArrayList<Kompetenz> getKompetenzliste() {
        return kompetenzliste;
    }

    public String getLieblingsfarbe() {
        return lieblingsfarbe;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setLieblingsfarbe(String lieblingsfarbe) {
        this.lieblingsfarbe = lieblingsfarbe;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }
}
