public class poly {
    public static void main(String[] args) {
        tier t1 = new hund();
        tier t2 = new katze();
        tier t3 = new katze();
        tier t4 = new tier();

        // Array von Objekten erschaffen
        tier [] tiere = {t1, t2, t3, t4};

        // Beispiel für Polymorphism - alle rufen die selbe Methode auf, dafür gibt es verschiedene Ergebnisse
        for (tier t : tiere) {
            t.geraeusch();
        }
        
    }
}
