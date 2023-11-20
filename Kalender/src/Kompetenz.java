import java.util.ArrayList;

public class Kompetenz {
    private int ID;
    private String kompetenzname;


    public Kompetenz(String kompetenz){
        this.kompetenzname = kompetenz;
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
