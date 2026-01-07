public class Handy extends HandyHersteller {
    private int besitzer = 1;

    public Handy(String marke, int besitzer) {
        super(marke);
        this.besitzer = besitzer;
    }

    @Override
    public String toString() {
        return "Die Anzahl der vorherigen Besitzer ist: "+ besitzer + super.toString();
    }
}
