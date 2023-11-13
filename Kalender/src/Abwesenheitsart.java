public class Abwesenheitsart {
    private String name;
    private int urlaubsanspruch;
    private int resturlaub;
    public Abwesenheitsart(String name,int urlaubsanspruch, int resturlaub){
        this.name = name;
        this.urlaubsanspruch = urlaubsanspruch;
        this.resturlaub = resturlaub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrlaubsanspruch() {
        return urlaubsanspruch;
    }

    public void setResturlaub(int resturlaub) {
        this.resturlaub = resturlaub;
    }

    public int getResturlaub() {
        return resturlaub;
    }

    public void setUrlaubsanspruch(int urlaubsanspruch) {
        this.urlaubsanspruch = urlaubsanspruch;
    }
}
