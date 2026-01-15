public class Saebelzahntiger implements Jaeger, tieren {
    @Override
    public void jagen() {
        System.out.println("Er jagt.");
    }
    @Override
    public void zaehneputzen() {
        System.out.println("Er putzt sich die Zähne.");
    }


    // Methode von tieren
    @Override 
    public void machtLaut() {
        System.out.println("Brüllt!");
    }

    public static void main(String[] args) {
        Saebelzahntiger dieter = new Saebelzahntiger();

        dieter.jagen();
        dieter.zaehneputzen();
        dieter.machtLaut();

    }
}