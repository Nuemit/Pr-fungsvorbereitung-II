import java.util.Scanner;

public class schmeissen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt(); 
        sc.close();
        alterTest(age);
    }   


    public static void alterTest (int alter) throws ArithmeticException {
        if (alter < 18) {
            throw new ArithmeticException ("Du bist zu jung.");
        } else { 
            System.out.println("Du bist alt genug.");
        }
    }
}
