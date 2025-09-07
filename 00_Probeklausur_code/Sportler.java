import java.time.LocalDate;

public class Sportler {

    private String name;
    private LocalDate geburtsdatum;

    public Sportler() {
        this(null, null);
    }
    public Sportler(String nName, LocalDate gbDatum) {
        this.setGeburtsDatum(gbDatum);
        this.setName(nName);
    }

    public void setName(String nName) {
        this.name = nName;
    }

    public void setGeburtsDatum(LocalDate gbDatum) {
        this.geburtsdatum = gbDatum;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getGeburtsDatum() {
        return this.geburtsdatum;
    }

   @Override
   public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("Name: ")
    .append(this.name)
    .append("\nGeburtsdatum: ")
    .append(this.geburtsdatum.toString());

    return sb.toString();
   } 
}
