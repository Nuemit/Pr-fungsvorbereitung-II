
import java.util.ArrayList;
import java.util.LinkedList;

public class linkedlist_tut {
    public static void main(String[] args) {
        LinkedList<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("Eric");
        namesLinkedList.add("Paul");
        namesLinkedList.add("Ringo");
        System.out.println(namesLinkedList.get(2));
        namesLinkedList.add(1, "Jerry");

        // String [] names = new String[4];
        ArrayList<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("Eric");
        namesArrayList.add("Paul");
        namesArrayList.add("Tom");
        System.out.println(namesArrayList.get(2));
        namesArrayList.add(1, "Tim");
    }
}
