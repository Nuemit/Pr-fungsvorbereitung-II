public class exception_tut {
    public static void main(String[] args) {
        try {
            int myInt = Integer.parseInt("pants");
        } 
        catch (NumberFormatException | NullPointerException e) {
            System.out.println("Nicht möglich");
        }
        // Wird immer ausgeführt.
        finally {
            System.out.println("In the Finally block");
        }
    }
}