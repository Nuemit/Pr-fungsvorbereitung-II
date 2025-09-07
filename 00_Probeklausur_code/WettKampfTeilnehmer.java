import java.time.LocalDate;
import java.util.Objects;

public class WettKampfTeilnehmer extends Sportler implements Comparable<WettKampfTeilnehmer> {

    private int startnummer;
    private static int anzTeilnehmer = 0;
    
    public WettKampfTeilnehmer (String nName, LocalDate gbDate, int nStartnummer) {
        super(nName,gbDate);
        this.setStartnummer(nStartnummer);
        anzTeilnehmer++;
    }

    @Override
    public int compareTo(WettKampfTeilnehmer o) {
        return Integer.compare(this.startnummer, o.getStartnummer());
    }

    public int getAnzahlTeilnehmer() {
        return anzTeilnehmer;
    }

    public int getStartnummer() {
        return this.startnummer;
    }
    
    private void setStartnummer(int nStartnummer) {
        this.startnummer = Math.abs(nStartnummer);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString())
        .append("\nStartnummer: ")
        .append(this.getStartnummer());

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) 
            return true;

        if (obj == null || obj.getClass() != this.getClass()) 
            return false;

        WettKampfTeilnehmer oth = (WettKampfTeilnehmer) obj;

        return this.getStartnummer() == oth.getStartnummer();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getStartnummer());
    } 
}
