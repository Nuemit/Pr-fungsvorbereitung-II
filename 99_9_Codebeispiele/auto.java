import java.util.Objects;

public class auto {
    private String marke;
    private int baujahr;

    // Defaultkonstruktor da () leer.
    public auto () {
        setMarke("Unbekannt");
        setBaujahr(0);
    }

    // Initialisierungskonstruktor
    public auto (String marke, int baujahr) {
        setMarke(marke);
        setBaujahr(baujahr);
    }

    // Setter und Getter
    public void setMarke (String marke) {
        this.marke = marke;
    }
    public String getMarke () {
        return marke;
    }

    public void setBaujahr (int baujahr) {
        this.baujahr = baujahr;
    }
    public int getBaujahr () {
        return baujahr;
    }

    // Equals 
    @Override
    public boolean equals (Object obj) {
        // Auf gleichheit prüfen
        if (this == obj) {
            return true;
        }
        // Auf NULL prüfen
        if (obj == null) {
            return false;
        }
        // Auf Klasse prüfen
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        // In das gewünschte Objekt Casten, da Objekt übergeben wird und erst zu Auto werden muss.
        auto other = (auto) obj;

        // Inhalt der einzelnen Variablen im Objekt prüfen.
        return  Objects.equals(other.getBaujahr(),  this.getBaujahr())   &&
                Objects.equals(other.getMarke(),    this.getMarke());

    }

    // hashCode muss implementiert werden, wenn man equals implementiert
    @Override
    public int hashCode () {
        int hcw = 17;
        final int hcm = 59;

        hcw = hcm * hcw     + this.getBaujahr()
                            + this.getMarke().hashCode();
        return hcw;
    }
}
