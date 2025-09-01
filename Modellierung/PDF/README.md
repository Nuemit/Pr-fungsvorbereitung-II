# PII Objektorientierung Wiederholung
- Komplexe Datentypen
  - Klassen
  - Arrays

## Klassen und Arrays Können
- Bei der Variablen-Definition wie einfache Datentypen eingesetzt werden
- Den Datentyp einer lokalen Variable bilden.
- Den Datentyp der Elemente eines Arrays bilden 
- Den Datentyp eines Attributes einer anderen Klasse bilden.

## Zugriff auf Objekte
- Zugriff auf Attribute und Methoden eines Objektes erfolgen mit einem `.` also einem ***Member-Zugriffsoperator***
  - Aufgrund dessen, das Objekte immer per Referenz angesprochen werden, übernimmt Java die *Dereferenzierung* also die Auflösung der Referenz, so dass das Objekt angesprochen wird.

## Komplexe Datentypen
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
    // gilt für alle Autos!
    public static final int ANZAHL_REIFEN = 4; 
    // gilt immernoch für alle Autos, kann aber verändert werden!
    public static int maxVelocity = 250; 
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


## Dereferenzierung
... Bedeutet, dass mit Hilfe einer Referenz auf den Wert einer Variablen zugegriffen wird. Dies erfolgt in Java mittels des ***Member-Zugriffsoperator*** bei Objekten und Ihren *Attributen / Methoden*, des `[]` Operators bei Arrays und ihren Elementen. Außerdem kommt es bei der Dereferenzierung zum Absturz mit einer NullpointerException, wenn keine Adresse vorhanden ist, d.h. wenn die Referenzvariable den Wert null hat.

**Beispiel:**
- Stellen wir uns vor, wir haben ein Objekt `Auto`.
- Das **Objekt** `Auto` wird nicht direkt in einer Variable (z.B. `Auto meinAuto;`) gespeichert, sondern irgendwo im Speicher des Computers (der sogenannte "Heap").
- Die **Variable** `meinAuto` speichert dann nicht das __Objekt__ `Auto`, sondern nur den ***Verweis*** zu diesem `Auto` im Speicher. Das wird als ***Referenz*** bezeichnet.
- Die *Dereferenzierung* ist nun der Prozess, bei dem die JVM dieser Referenz folgt um zum tatsächlichen Objekt im Speicher zu gelangen. Java macht das immer Automatisch für den Programmierer. Immer wenn jetzt der ***Member-Zugriffsoperator*** `.` genutzt wird um auf ein Attribut oder eine Methode eines Objekts zuzugreifen, findet im Hintergrund eine Dereferenzierung statt. 

```java
// Beispiel Auto
public class Auto {
    String farbe = "rot"; // ein Attribut
    void fahren() {       // Eine Methode
        System.out.println("Brumm Brumm");
    }
}

public class Main {
    public static void main(String[] args) {
        /** 1. Ein Auto-Objekt wird erstellt.
         *      'meinAuto' speichert deine REFERENZ auf dieses Objekt.
         */
        Auto meinAuto = new Auto(); 

        /** 2. Dereferenzierung findet hier statt
         *  Java folgt der Referenz in 'meinAuto', 
         *  findet das Objekt und greift auf 'farbe' zu.
         */
        System.out.println(meinAuto.farbe);

        // Genau das Selbe nur mit einer Methode
        meinAuto.fahren();

        // Beispiel für Nullpointer
        Auto deinAuto = null;
        deinAuto.fahren() // Wirft eine NullPointerException.
    }
}

```

## Objektorientierte Verwaltungsmethoden
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

## Call By Value / Referenz
### Value
Wenn etwas mit *Call by Value* übergeben wird, wird eine **Kopie** des *Wertes* an die Methode weitergegeben. Die Methode arbeitet dann nur mit dieser Kopie. Was auch immer die Methode mit der Kopie macht, hat keine Auswirkung auf das **Original** außerhalb der Methode.

In Java werden primitive Datentypen (wie `int`, `double`, `boolean`, `char`) immer per ***Call by Value*** übergeben, ein Beispiel:

```java
public class CallByValue {

    /** Zahl ist hier eine Kopie des Wertes der Übergeben wird. */
    public static void erhoeheZahl(int zahl) {
        zahl += 10;
        System.out.println("In der Methode: " + Zahl);
    }

    
    public static void main(String[] args) {
        int originalZahl = 5;

        // Gibt 5 aus
        System.out.println("Vor dem Aufruf der Methode: " + originalZahl);

        // Gibt 15 aus
        // Original wird nicht verändert.
        erhoeheZahl(originalZahl);

        // Gibt 5 aus
        System.out.println("Nach dem Aufruf: " + originalZahl);
    }
}
```

**Ausgabe**
> Vor dem Aufruf 5
  In der Methode 15
  Nach dem Aufruf 5

Wie man erkennen kann, ändert sich der Wert von `originalZahl` nicht, da die Methode `erhoeheZahl()` mit einer Kopie arbeitet.

### Referenz
Bei *Call by Reference* wird nicht der Wert selbst übergeben, sondern der "Verweis" (Speicherreferenz) auf den Ursprünglichen wert. Die Methode verändert somit keine Kopie, sondern direkt das "Original".

Java verwendet aber nie "reines" *Call by Reference* im Sinne, dass die Referenz selbst überschrieben wird. Stattdessen verwendet Java eine Mischform, die oft als ***Call by Value for Reference*** bezeichnet wird. Das bedeutet Konkret, das eine Kopie der Referenz übergeben wird, diese Kopie der Adresse zeigt aber immernoch dasselbe Originalobjekt im Speicher an und die Methode kann über diese Kopie der Referenz das Originalobjekt manipulieren. somit sieht ein Beispiel dafür so aus:

```java
public class CallByReferenz {

    // Arrays sind Objekte, also wird hier callByReference verwendet.
    public static void changeArrayIndex1(String[] arrayObject) {
        arrayObject[1] = "OnePiece"; 
    }

    public static void main(String[] args) {
        String[] array = new String[3]; 
        array[0] = "Hallo";
        array[1] = "Welt";
        array[2] = "- JUHUUUU!";
        
        for(String n: array) {  // Ausgabe: "Hallo Welt - JUHUUUU"
            System.out.print(n + " ")
        }

        changeArrayIndex1(array);
        
        for(String n: array) { // Ausgabe: "Hallo OnePiece - JUHUUUU"
            System.out.print(n + " ")
        }
    }
}
```
**Ausgabe**
Vor dem Aufruf
> "Hallo Welt - JUHUUUU!"

Nach dem aufruf
> "Hallo OnePiece - JUHUUUU!

# Instanz- und Klassen-Member
Merksatz: Non-Static bedeutet Instanz, Static bedeutet Klassen-Member.

Instanz-Member gehören immer einem Individuellem Objekt (z.B. einem Objekt der Klasse Hund), jedes Objekt hat seine eigene Instanz. Für Klassen Member gilt, das alle Objekte von einer Klasse sich diese Klassen-Member teilen. 

```java
public class Shepperd extends Dog {
    public static final String RACE = "Shepperd";   // Klassen-Member
    private static int population = 25;             // Klassen-Member
    private String name;    // Instanz-Member
    private int age;        // Instanz-Member

    public Shepperd(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
``` 

In Unserem Beispiel, ist jedes Objekt der Klasse Shepperd mit dem String `RACE = "Shepperd"` ausgestattet und hat eine population von 25, diese sind **Klassen-Member**. Der Name und das Alter hingegen, sind **Instanz-Member**, da sie für jedes Objekt individuell gelten.

## Im Javainsel Buch vom Rheinwerk Verlag steht zu Statischen Variablen:
Die Belegung einer statischen Variablen wird bei dem Klassenobjekt gespeichert und nicht bei einem Exemplar der Klasse. Wie wir aber gesehen haben, kann jedes Exemplar einer Klasse auch auf die statischen Variablen der Klasse zugreifen. Da eine statische Variable aber nur einmal pro Klasse vorliegt, führt dies dazu, dass mehrere Objekte sich eine Variable teilen. [Sektion im Buch](https://openbook.rheinwerk-verlag.de/javainsel/06_003.html) Abschnitt 6.3.5

# Standard Operationen von Objekten in Java
Wenn in Java eine eigene Klasse erstellt wird, erbt diese Klasse standardmäßig von der Klasse `java.lang.Object`. Diese `Object`-Klasse stellt einige grundlegende Methoden zur Verfügung, die für jedes Objekt in Java existieren. Sie werden hier als "Standardoperationen" bezeichnet, weil sie das grundlegende Verhalten von Objekten definieren. 

Die Methoden, die laut den Vorlesungen für uns am Wichtigsten sind, lauten `equals()`, `hashCode()`, `toString()`, `clone()` und `finalize()`. Wobei `finalize` wirklich veraltet ist und **nicht** mehr verwerndet werden soll!

Die beiden Methoden `equals()` und `hashCode()` sind eng miteinander verknüpft und sollten immer zusammen implementiert werden. Sie definieren, wann zwei Objekte als gleichwertig betrachtet werden.

## Clone
Die `clone()` Methode dient dazu, eine Kopie eines Objekts zu erstellen. um sie zu verwenden muss man das `Clonable-Marker-Interface` Implementieren. `Object.clone()` erstellt standardmäßig eine **flache** Kopie. dies bedeutet, dass nur primitive Typen direkt kopiert werden. Referenzen auf andere Objekte werden nur kopiert, nicht die Objekte selbst. Die Original- und die Kloininstanz teilen sich somit dieselben referenzierten Objekte (Siehe Oben unter Referenz, welche Problematik einhergehen kann).

Die richtige Implementierung mit einer tiefen Kopie, wie wir sie für Komplexe Objekte brauchen, erzwingt es, dass `clonable` Interface zu implementieren und die Methode `clone()` zu überschreiben. Das ist mitunter ein Grund, warum die Methode als problematisch angesehen wird.

```java
class Adresse implements Cloneable {
    String stadt;
    
    @Override public Adresse clone() throws CloneNotSupportedException {
        return (Adresse) super.clone();
    }
}

class Person implements Cloneable {
    String name;
    Adresse adresse;

    @Override
    public Person clone() throws CloneNotSupportedException {
        // Schritt 1: Flache Kopie erstellen
        Persone cloned = (Person) super.clone();

        // Schritt 2: Die referenzierten Objekte tief kopieren
        // Dies ist entscheident für eine Tiefe Kopie!
        cloned.adresse = this.adresse.clone();

        return cloned;
    }
}
```
Aufgrund der Komplexität und der Tatsache, dass `clone()` eine `protected` Methode ist, die eine speziellee Ausnahme wirft, wird heute oft empfohlen, stattdessen Kopierkonstruktoren oder Fabrikmethoden zu verwenden

### Kopierkonstruktoren
Ein Kopierkonstruktor ist ein Konstruktor, der ein Objekt derselben klasse als Argument akzeptiert. Er dient dazu, eine neue Instanz zu erstellen, indem er die Werte des übergebenen Objekts kopiert.

**Beispiel**
```java
class Adresse {
    String stadt;
    String strasse;

    // Normaler konstruktor
    public Adresse(String stadt, String strasse) {
        this.stadt = stadt;
        this.strasse = strasse;
    }

    // Kopierkonstruktor
    public Adresse(Adresse andereAdresse) {
        this.stadt = andereAdresse.stadt;
        this.strasse = andereAdresse.strasse;w
    }
}

// Klasse für Person
class Person {
    String name;
    int alter;
    Adresse adresse; // Referenz auf ein anderes Objekt

    // Standard-Konstruktor
    public Person(String name, int alter, Adresse adresse) {
        this.name = name;
        this.alter = alter;
        this.adresse = adresse;
    }

    // Kopierkonstruktor für Person
    // Dieser Konstruktor erstellt eine TIEFE Kopie der referenzierten Objekte.
    public Person(Person anderePerson) {
        this.name = anderePerson.name;
        this.alter = anderePerson.alter;
        // WICHTIG: Hier wird der Kopierkonstruktor der Adresse aufgerufen,
        // um eine neue, unabhängige Adresse zu erstellen.
        this.adresse = new Adresse(anderePerson.adresse);
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", alter=" + alter +
               ", adresse=" + adresse +
               '}';
    }
}
```
Kopierkonstruktoren werden immer aufgerufen um eine neue Referenz zu schaffen, so werden seperate Instanzen erstellt.‚


## equals
IN der Theorie vergleicht die `equals()` Methode zwei Objekte auf "Gleichheit". Die Standardimplementierung von `Object.equals()` vergleicht nur die Referenzen der Objekte (also, ob sie auf dieselbe Speicheradresse zeigen). Dies ist oft nicht das gewünschte Verhalten. In den allermeisten Fällen, möchte man, dass Objekte als gleichwertig gelten, wenn ihre Zustände (die Attribute eines Objekts) gleich sind, unabhängig davon, ob es sich um dieselbe Instanz handelt.

So würde eine "Falsche" implementierung aussehen, Sie dient nur zu Referenzzwecken.
**Falsche Implementierung**
```java
class Person {
    private String name;
    private int alter;

    // ... Konstruktor, Getter, Setter ....
}

// Test
Person p1 = new Person("Alice", 30);
Person p2 = new Person("Alice", 30);

// Dieser Vergleich wäre ohne eine Überschreibung falsch, da er 'false' zurückgibt.
// Die Objekte sind nicht dieselben, auch wenn ihr Inhalt gleich ist.
if (p1.equals(p2))
    // Wird nicht ausgeführt.
```

### Für eine Richtige Implementierung:
Man muss die `equals()`-Methode überschreiben, um die Gleichheit basierend auf den Attributen des Objekts zu definieren. Die Regeln, die dabei befolgt werden müssen, sind streng:
**Regeln**
* Die Implementierung mus Reflexiv sein, dass bedeutet `x.equals(x)` muss `true` sein!
* Symmetrisch: wenn `x.equals(y) == true` muss auch `y.equals(x) == true` sein.
* Transitiv: Wenn `x.equals(y) == true` und `y.equals(z) == true` muss auch `x.equals(z) == true` sein.
* Konsistent: Mehrmalige Aufrufe von `x.equals(y)` müssen das selbe Ergebnis liefern.
* `null`-Vergleich: `x.equals(null)` muss immer `false` sein.

eine Konkrete Implementierung einer `equals` Methode, sieht zum Beispiel so aus:
***Richtige Implementierung***
```java
@Override
public boolean equals(Object o) {
    // 1. Prüfen wir auf Identität!
    if(this == o) return true;
    
    // 2. Prüfen wir auf Null und unterschiedliche Klassen!
    if(o == null) || getClass() != o.getClass()) return false;

    // Casten auf den richtigen typ.
    Person oP = (Person) o;

    // 3. Vergleich der verschiedenen Attribute!
    // Bei primitiven Typen mit ==
    // Bei Objekten mit equals()
    return this.alter == oP.alter && Object.equals(this.name, oP.name);
}
```

## hashCode
Die Theorie hinter der `hashCode()` Methode ist, dass die Methode eine ganze Zahl (Einen Hash-Code) zurück gibt. Sie soll hauptsächlich in Hash-basierten Datenstrukturen wie `HashMap` und `HashSet` verwendet werden. Der Hash-Code hilft, Objekte effizient in diesen Strukturen zu finden. Die wichtigste Regel lautet:  **Wenn zwei Objekte nach `equals()` gleich sind, MÜSSEN sie denselben Hash-Code haben!**

Die Tabelle zur Berechnung von Hash-Codes
|Typ|Zugeordnete Integer-Werte|
|:---|:----------------------|
|boolean|(field ? 0 : 1)|
|byte, char, short, int | (int) field |
|long| (int) (field >>>32) und (int) (field & 0xFFFFFFFF)|
|float| ((field==0.0F) ? 0 : Float.floatToIntBits(field)) |
|double| ((field==0.0) ? 0L : Double.doubleToLongBits(field)) und anschließende Behandlung wie bei long |
|Referenz | ((field==null) ? 0 : field.hashCode()) |

Der Hash-Code sollte aus den gleichen Attributen berechnet werden, die auch im `equals()` Vergleich verwendet werden.
**Beispielimplementierung von Person(siehe oben)**
```java
// ...
@Override
public int hashCode() {
    // für die Berechnung ist die Standardbibliothek java.util.Objects.hash() der einfachste und sicherste weg.
    return Objects.hash(name, alter);
}
```
## toString
Die Theorie: Die `toString()` Methode liefert eine String-Repräsentation eines Objekts. Die Standardimplementierung gibt den klassennamen und den Hash-Code des Objekts zurück, was selten nützlich ist. `toString()` wird häufig zu Debugging zwecken und zur Protokollierung verwendet.

**Beispielimplementierung**
```java
@Override
public String toString() {
    return "Person{\n"+
        "name='"+ this.name+ "\'\n" +
        "alter="+ this.alter + "\n" +
        "}"
}
```

## finalize
Die `finalize()` Methode sollte vom Garbage Collector aufgerufen werden, bevor ein Objekt aus dem Speicher entfernt wird. Sie war als Mechanismus gedacht, um Ressourcen freizugeben (File-Handles oder Netzwerkverbindungen).

Problematik:
Die Verwendung von `finalize()` ist **Stark veraltet** und wird **nicht mehr empfohlen**, da sie in Java 9 als veraltet (`@Deprecated`) markiert und in neueren Versionen entfernt wurde.
* Unzuverlässig: Es gibt keine Garantie, dass `finalize()` jemals aufgerufen wird.
* Performance: Die verwendung von `finalize()`kann die Leistung des Garbage Collctors **erheblich** beeinträchtigen
* Sicherheitsrisiken: Objekte können durch `finalize()` wiederbelebt werden, was zu leaks führen kann.

Die Moderne:
Die mittlerweile Moderne Lösung dafür ist die `try-with-resources` anweisung für die automatische freigabe von Ressourcen zu benutzen, die das `AutoCloseable`-Interface implementieren. Dieses Konstrukt stellt sicher, dass eine Ressource am Ende des try-Blocks freigegeben wird, unabhängig davon, ob der Block normal oder durch eine Ausnahme beendet wird.

Ein Beispiel dafür sieht so aus:
```java
public static void main(String[] args) {
        // Deklaration der Ressource direkt im try-Block
        try (BufferedReader br = new BufferedReader(new FileReader("beispiel.txt"))) {
            String zeile;
            while ((zeile = br.readLine()) != null) {
                System.out.println(zeile);
            }
        } catch (IOException e) {
            // Automatischer Aufruf von br.close() bei jeder Ausnahme oder normalem Verlassen des Blocks
            e.printStackTrace();
        }
    }
```

Wir haben hier mal eine schöne Darstellung von Gemini erstellen lassen, um das Ressourcen Management mit `AutoCloseable` zu veranschaulichen.

**Java von Gemini**
```java
class MeineRessource implements AutoCloseable {
    
    public MeineRessource() {
        System.out.println("Ressource wird geöffnet.");
    }
    
    public void tuEtwas() {
        System.out.println("Ressource ist in Gebrauch.");
    }
    
    @Override
    public void close() {
        System.out.println("Ressource wird geschlossen.");
    }
}

public class EigeneRessourceBeispiel {
    public static void main(String[] args) {
        // Die eigene Ressource wird automatisch geschlossen
        try (MeineRessource res = new MeineRessource()) {
            res.tuEtwas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

# Lernziele aus der VL
## Wie kann das Geheimnisprinzip umgesetzt werden?
<details>
    <summary>Antwort</summary>

    
    Mittels Setter und Getter, dafür müssen die Variablen `private` sein.
    
</details>

## Welche OO-Verwaltungsmethoden gibt es?
## Wie kann this auf zwei unterschiedliche Arten verwendet werden?
## Wie sollte ein guter Initialisierungskonstruktor implementiert werden?
## Wie sollten Konstruktoren überladen werden? Welche Rolle spielt this dabei?
## Was bedeutet dereferenzieren?
## Wann kommt es beim Dereferenzieren zu einer NullPointerException?
## Welche Java Standard-Operationen gibt es?
## Wie heißt der neue Datentyp, d. h. die neue Klasse, der für alle Objekte gilt?
## Wie wird equals gut programmiert? Was fordert der Contract der API dazu?
## Was erfordert der Contract der API zusätzlich, wenn equals programmiert ist?
## Was soll in toString inhaltlich zurückgegeben werden?