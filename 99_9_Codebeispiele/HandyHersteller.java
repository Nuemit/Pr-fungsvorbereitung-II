

public class HandyHersteller {
    protected String marke = "Apple";

    public HandyHersteller (String marke) {
        this.marke = marke;
    }
    @Override
    public String toString() {
        return "Der Handyhersteller ist: " + marke;
    }
}
