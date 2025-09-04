import java.util.LinkedList;
import java.util.List;

public class Methoden {

    public static void main(String[] args) {
        List<String> namen = new LinkedList<>();

        namen.add("Amir");
        namen.add("Anna");
        namen.add("John");
        namen.add("Max");
        namen.add("Komiker");

        namen.forEach(name -> System.out.println(name));
    }
}