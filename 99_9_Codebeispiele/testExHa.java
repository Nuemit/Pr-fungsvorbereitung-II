public class testExHa {
    public static void main (String Args[]) {
        int array [] = {1, 2, 3, 4};

        // Ausgabe a)
        for (int i = 3; i > -2 ; i--) {
            try {
            System.out.println(array[i + 1] / i);
            }
            catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println(e);
            }
        }
        System.out.println("");
        System.out.println("Leerzeile");
        System.out.println("");

        // Ausgabe b)
        try {
            for (int i = 3; i > -2; i--) {
                System.out.println(array[i + 1] / i);
            }
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}    

