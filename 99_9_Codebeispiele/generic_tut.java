import java.util.ArrayList;
import java.util.List;

public class generic_tut {
    public static void main(String[] args) {
        
        // Wichtig die <> hinter printer zu schreiben. Das erste <Integer> gibt den Typ an der in printer.java dann als T genommen wird. Hinter dem zweiten kann das ohne Inhalt hin, da reicht nur <>.
        printer <Integer> printer = new printer <>(23);
        printer.print();

        printer <Double> doublePrinter = new printer <>(33.5);
        doublePrinter.print();

        shout("Eric", 24);

        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(4);
        printList(intList);
    }

    // Generic Method
    public static <T, V> void shout (T thingToShout, V otherThingToShout) {
        System.out.println( thingToShout + "!!!!!!!");
        System.out.println( otherThingToShout + "!!!!!!!");
    }

    // <?> ist ein Wildcard. Wenn man nicht weiß welchen Inhalt es bekommen soll, macht man es so.
    public static void printList (List<?> myList) {
        System.out.println(myList);

    }

}
