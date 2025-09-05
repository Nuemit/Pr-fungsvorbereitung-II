public class wrapper {
    public static void main(String[] args) {
        int zahl = 5;

        // Wrapper -  Klasse (Object)
        Integer zahlObject = Integer.valueOf(zahl);

        // Ausgabe im Terminal 
        // Primitive Zahl ausgeben
        System.out.println("Primitive Zahl: " + zahl);

        // Wrapper - Klasse im Terminal ausgeben
        System.out.println("Wrapper: " + zahlObject.toString());

    }
    
}
