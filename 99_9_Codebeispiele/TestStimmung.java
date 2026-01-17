public class TestStimmung {
    public static void main (String Args[]) {
        System.out.println(Stimmung.gut);

        //
        for (Stimmung laune : Stimmung.values()) {
            System.out.println(laune);
            System.out.println(laune.wert);
        }
    }
}
