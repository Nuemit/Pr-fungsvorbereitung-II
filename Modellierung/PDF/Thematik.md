# PII Objektorientierung Wiederholung
- Komplexe Datentypen
  - Klassen
  - Arrays

### Klassen und Arrays Können
- Bei der Variablen-Definition wie einfache Datentypen eingesetzt werden
- Den Datentyp einer lokalen Variable bilden.
- Den Datentyp der Elemente eines Arrays bilden 
- Den Datentyp eines Attributes einer anderen Klasse bilden.

### Zugriff auf Objekte
- Zugriff auf Attribute und Methoden eines Objektes erfolgen mit einem `.` also einem ***Member-Zugriffsoperator***
  - Aufgrund dessen, das Objekte immer per Referenz angesprochen werden, übernimmt Java die *Dereferenzierung* also die Auflösung der Referenz, so dass das Objekt angesprochen wird.

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


### Dereferenzierung
... Bedeutet, dass mit Hilfe einer Referenz auf den Wert einer Variablen zugegriffen wird. Dies erfolgt in Java mittels des ***Member-Zugriffsoperator*** bei Objekten und Ihren *Attributen / Methoden*, des `[]` Operators bei Arrays und ihren Elementen. Außerdem kommt es bei der Dereferenzierung zum Absturz mit einer NullpointerException, wenn keine Adresse vorhanden ist, d.h. wenn die Referenzvariable den Wert null hat.

**Beispiel:**
- Stellen wir uns vor, wir haben ein Objekt `Auto`.
- Das **Objekt** `Auto` wird nicht direkt in einer Variable (z.B. `Auto meinAuto;`) gespeichert, sondern irgendwo im Speicher des Computers (der sogenannte "Heap").
- Die **Variable** `meinAuto` speichert dann nicht das __Objekt__ `Auto`, sondern nur den ***Verweis*** zu diesem `Auto` im Speicher. Das wird als ***Referenz*** bezeichnet.

### Objektorientierte Verwaltungsmethoden
Verwaltungsmethoden sind Methoden die es uns Ermöglichen:
- Objekte zu erstellen (Konstruktoren)
- Auf den Zustand von Objekten zu zugreifen (Getter)
- Den Zustand von Objekten zu ändern (Setter)
- Das Verhalten von Objekten zu Steuern (Business-Logik-Methoden)
- Objekte darzustellen oder zu vergleichen (`toString()`, `equals()`, `hashcode()`)

Sie bilden die Schnittstelle, über die andere Teile eines Programms mit den Objekten interagieren, deren Daten kapseln und ihre Integrität wahren. Das Konzept der Kapselung (Daten und die darauf operierenden Methoden sind zusammen in einem Objekt gebündelt und der Zugriff auf die Daten ist kontrolliert) ist hierbei von Zentraler bedeutung.

- Konstruktoren (Im Beispiel sind zwei Konstruktoren, somit sind die Konstruktoren überladen)
```java
public class Beispiel {
    public Beispiel() { // Default-Konstruktor
        this(null);
    }
    public Beispiel(String attribut) { // Initialisierungskonstruktor
        this.methode(attribut);
    }
}
```
- Getter-Methoden (Zugriffsmethoden / Accessors)
- Setter-Methoden (Mutator-Methoden / Mutators)
- Business-Logik-Methoden / Verhaltensmethoden
- `toString()`-Methode
- `equals()`- und `hashCode()`-Methode

### Arrays
