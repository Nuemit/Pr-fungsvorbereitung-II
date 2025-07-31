# Prüfungsvorbereitung-II
Ergänzend zu den Inhalten innerhalb dieses repos findet ihr alle Inhalte im Offenen Buch von Rheinwerk:
- [Java ist auch eine Insel](https://openbook.rheinwerk-verlag.de/javainsel/index.html)

## 00_OO-Modellierung
Benutzt die Vorlesungsfolien `PII_01_OOWiederholung_OOJAVA.pdf` und `PII_02_OOModellierung.pdf`
- Komplexe Datentypen
  - Wiederholung
  - Vertiefung
- Standard-Operationen von Objekten
  - Wiederholung

### Komplexe Datentypen
Komplexe Datentypen werden in Java als Referenztypen bezeichnet, weil sie "per Referenz" verarbeitet werden. Es können Objekte erzeugt werden die als Referenz einen Komplexen Datentyp haben.

**Konstruktoren** gehören zu den OO-Verwaltungsmethoden. Er bekommt die zu setztenden *Werte* der "Attribute/Eigenschaften" übergeben.

**Was sind Attribute?**
- Attribut
  - **Kann auch** Klassenattribut **oder** statisches Attribut **genannt werden!**
  - Attribute die in einer Klasse festgelegt sind, gelten für **ALLE** Objekte dieser Klasse. Man könnte z.B. sagen das alle Autos eines Modells 4 Reifen haben, somit wäre `AnzahlReifen` immer gleich 4.
  - in Java code wäre das:
```java
public class Auto {
    // Klassenattribut
    public static final int ANZAHL_REIFEN = 4; // gilt für alle Autos!
    public static int maxVelocity = 250; // gilt immernoch für alle Autos, kann aber verändert werden!
}
```
**Was sind Instanzattribute?**
- Sollte der Kontext klar sein, wird dies auch einfach nur Attribut genannt -.-
- Kann auch **Objektattribut** heißen
- Jedes Objekt einer Klasse, kann ihre eigenen Werte Haben. Gibt es z.B. die Klasse Hund, können wir Objekte der klasse Hund mit verschiedenen Namen erstellen.
```java
public class Hund {
    // Instanzattribut
    private String name; 
    
    public Hund(String doggoname) {
        this.name = doggoname;
    }
}

public class Mainclass {
    public static void main(String[] args*) {
        Hund barky = new Hund("Barky"); // Objekt mit name = Barky
        Hund gustav = new Hund("Gustav"); // Objekt mit name = Gustav
    }
}
```

*Tabelle 1: Zusammengefasste Informationen zu Attributen*
| Merkmal | Attribut / Klassenattribut / Statisches Attribut | Instanzattribut / Objektattribut |
| :--- | :--- | :--- |
| Zugehörigkeit | Gehört zur Klasse selbst | Gehört zu jener Instanz einer Klasse |
| Speicherung | Nur einmal im Speicher für die Gesammte Klasse | Für jede Instanz seperat im Speicher |
| Zugriff | Über den Klassennahmen  (z.B. `Auto.ANZAHL_REIFEN`) | über die Instanz (z.B. `barky.name`) |
| Werte | Ein Wert für alle Instanzen dieser Klasse | Jede Instanz hat eigenen Wert |
| Schlüsselwort | `static` | | 