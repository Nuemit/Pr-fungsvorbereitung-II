public class auto_konstrukt {
    public static void main(String[] args) {
        
        // Aufruf Defaultkonstruktor
        auto a1 = new auto();

        // Aufruf Initialisierungskonstruktor
        auto a2 = new auto("BMW", 2024);


        System.out.println(a1.getMarke());
        System.out.println(a2.getMarke());

        System.out.println(a1.equals(a2));

    }
}
