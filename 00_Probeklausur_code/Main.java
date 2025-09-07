import java.sql.Time;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        WettKampfTeilnehmer n = new WettKampfTeilnehmer("tim", LocalDate.of(1999,3,24),1);
        WettKampfTeilnehmer a = new WettKampfTeilnehmer("tim", LocalDate.of(1999,3,24),1);
        WettKampfTeilnehmer b = new WettKampfTeilnehmer("Eric", LocalDate.of(1999,3,24),3);
        

        System.out.println("toSTring(): " + n.toString());
        System.out.println("equals n,b: " + n.equals(b)); 
        System.out.println("equals n,a: " + n.equals(a));
        System.out.println("Hashcode: " + n.hashCode());
        System.out.println("Wettkampfteilnehmerzahl: " + n.getAnzahlTeilnehmer());
    }
}
