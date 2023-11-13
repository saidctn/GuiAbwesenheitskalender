import java.util.Date;

public class Abwesenheit{
    private Date startDatum;
    private Date endDatum;
    private String status;
    private Abwesenheitsart art;

    public Abwesenheit(Abwesenheitsart art, Date startDatum, Date endDatum){
        this.art = art;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        System.out.println("start : "+this.startDatum);
        System.out.println("ende : "+ this.endDatum);

    }

    public Date getEndDatum() {
        return endDatum;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public String getStatus() {
        return status;
    }

    public void setEndDatum(Date endDatum) {
        this.endDatum = endDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
