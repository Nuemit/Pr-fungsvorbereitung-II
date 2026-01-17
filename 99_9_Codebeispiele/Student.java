
import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student>{
    private int matrikelNummer;
    private String name;

    public Student (int matrikelNummer, String name) {
        setName(name);
        setMatrikelNummer(matrikelNummer);
    }

    public int getMatrikelNummer () {
        return matrikelNummer;
    }

    public void setMatrikelNummer (int matrikelNummer) {
        this.matrikelNummer = matrikelNummer;
    }

    public String getName () {
        return name;
    }
 
    public void setName (String name) {
        this.name = name;
    }

    @Override
    public int compareTo (Student other) {
        return Integer.compare(this.getMatrikelNummer(), other.getMatrikelNummer());
    }

    @Override
    public int compare (Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

    @Override 
    public String toString () {
        return "Student " + name + " mit der Matrikelnummer: " + matrikelNummer;
    }

}
