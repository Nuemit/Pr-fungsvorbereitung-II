# PII Objektorientierte Programmierung in der Praxis
### Grundlegende Klassen in Java
#### Objekt- und Wrapper-Klassen
- Alles was aus einer Klasse erzeugt wird, ist ein Objekt.
- Ein Objekt ist eine Instanz einer Klasse -> ein "Ding" mit Konkreten Eigenschaften (Variablen) und Verhaltensweisen (Methoden).
```java
class Arzt {
    String name; 

    Arzt (String name) {
        this.name = name;
    }

    void patientBeraten {
        System.out.println(name + " berät Patienten");
    }
}


public class main {
    public static void main (String Args[]) {
        Arzt arzt1 = new Arzt("Dr. Müller");

        arzt1.patientBeraten;
    }
}
```
Das Objekt Arzt1 mit dem Namen Dr. Müller wurde jetzt erzeugt und kann auch auf die Methoden von Arzt zugreifen.


Wrapper-Klassen sind Klassen, welche Primitive Datentypen in Objekte packen. 
Primitive Datentypen und ihre dazugehörigen Wrapperklassen sind: 
| Primitiver Datentyp       | Wrapperklasse |
|---------------------------|---------------|
| byte                      | Byte          |
| short                     | Short         |
| int                       | Integer       |
| long                      | Long          |
| float                     | Float         |
| double                    | Double        |
| char                      | Character     |
| boolean                   | Boolean       |

Warum braucht man soetwas wie Wrapper-Klassen?
Es gibt Java Collections. Diese können nur mit Objecten Arbeiten. Um dennoch mit den Collections arbeiten zu können sind diese Wrapper-Klassen da. Diese machen den Primitiven Datentyp in ein Objekt. 

Wie man ein int in ein Int "umwandelt".
```java
public class Main {
    public static void main (String Args[]) {
        // primitiver Datentyp 
        int zahl = 5;


        // Wrapper-Klasse (Objekt)
        Integer zahlObjekt = Integer.valueOf(zahl);


        // Ausgabe im Terminal
        System.out.println("Primitivezahl: " + zahl); 
        // Ausgabe: Primitivezahl 5
        System.out.println("Wrapper: " + zahlObjekt.toString())
        // Ausgabe: Wrapper 5 
    }
}
```

Zusammenfassung: 
- Ein Objekt ist eine Instanz einer Klasse
- Wrapper-Klassen machen primitive Datentypen zu Objekten, damit sie in Collections gespeichert und mit Methoden bearbeitet werden können. 

#### Aufzählungen - Enumerations
- Primitive Datentypen
    - können nur einzelne Werte Darstellen
    - und keine Wertemengen
- Aufzählungstypen
    - fassen einzelne Werte unter einem Gesichtspunkt zusammen
    - und dienen somit zur Definition von Wertemengen

Beispiele für Aufzählungstypen wären:
- Day
    - Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
- Monate
    - Januar, Februar, März, April, Mai, Juni, Juli, August, September, Oktober, November, Dezember

Um eine Aufzählung umzusetzen nimmt man ein Interface.
Das würde für Wochentage so aussehen: 
```java 
public interface Day {
    public static final int MON  = 1;
    public static final int TUE  = 2;
    public static final int WEN  = 3;
    public static final int THUR = 4;
    public static final int FRI  = 5;
    public static final int SAT  = 6;
    public static final int SUN  = 0;
}
```
Aufzählungen lassen sich als Konstante Klassenvariablen (static) festlegen.

Es gibt nur folgende Probleme: 
- Kein eigener Typ
    - es können unerlaubte Werte übergeben werden
    - es können unterschiedliche Aufzählungen miteinander verglichen werden   
- Aufzählungsreihenfolge
    - ist nicht immer zu bestimmen oder spielt keine Rolle

Ab dem 30. September 2005 mit Java 5.0 wurden Enums eingeführt. Diese sind in der Lage die grade genannten Probleme zu lösen. 

Enums werden wie normale Klassen erstellt. Der Klassenkopf hat dann anstatt "class", "enum" dort stehen. 
Das sieht dann wie folgend aus:

```java 
public enum Day {MON, TUE, WED, THUR, FRI, SAT, SUN}
```
Damit kann man Aufzählungen definieren. Die Werte sind dann standardmäßig Konstant (daher groß geschrieben). Ein Enum wird in einer eigenen Datei gespeichert. Ähnlich wie Klassen und Interfaces. Bsp.: day.java 

Um mit einem Enum zu arbeiten kann man das wie folgend machen: 
```java 
// Wir haben das Enum day - day.java
public enum Day {MON, TUE, WED, THUR, FRI, SAT, SUN}

// Wir haben die Klasse date - date.java 
public class Date {
    public void appointDay() {
        // Der Name des Enums wird als Datentyp für die Variable genommen.
        Day whichDay;
        // Zuweisung eines Wertes (In einem Enum Konstant) an die Variable whichDay 
        whichDay = Day.MON;


        // Vergleich der Werte aus dem Enum (Durch whichDay = Day.MON ist es aber aktuell auf MON festgelegt.)
        switch (whichDay) {
            case MON:
            // Code 
            break;
            case TUE:
            // Code 
            break;
            ...
            ...
        }
    }
}
```
Enums kann man auch mit Funktionen erweitern. Das könnte dann so aussehen: 

```java
// Ausschnitt des Enums Day, das Enum entält Monday - Sunday

// Instanzmethode (non static)
public boolean isWeekend() {
    return this == SAT || this == SUN 
}
```






### Packages
### Programmierhinweise
