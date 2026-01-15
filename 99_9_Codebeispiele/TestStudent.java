import java.util.*;

public class TestStudent {
    public static void main(String Args[]) {
        List <Student> students = new ArrayList<>();
        students.add(new Student(01,"Tim"));
        students.add(new Student(02,"Jonas"));
        students.add(new Student(03,"Eric"));

        // Sortieren nach Comparable
        Collections.sort(students);
        System.out.println("Studenten sortiert nach Matrikelnummer: ");
        students.forEach(System.out::println);

        // Sortiert nach CompareTo nach Namen
        Collections.sort(students, Comparator.comparing(Student::getName));
        System.out.println("\nSortiert nach Name: ");
        students.forEach(System.out::println);
    }
}
