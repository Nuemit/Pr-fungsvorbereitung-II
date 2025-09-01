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
Wenn man den gesamten Inhalt des Enums ausgeben möchte, kann man das mit dem **.value** machen. 

```java
// z.B. in der main Methode oder einer anderen Methode
for (Day Wochentag : Day.values()) {
    System.out.println(Wochentag);
}

// mit .values wird ein Array erstellt, welches das Enum als Inhalt hat.
```


Enums können auch verschiedene Werte hinter einer Aufzählung haben. Das würde dann z. B. so ausshene: 

```java 
public enum Cereals {

    CAPTAIN_CRUNCH(50, 2.90),
    FROOT_LOOPS(60, 1.90),
    REESES_PUFFS(100, 1.0),
    COCA_PUFFS(75, 0.5);

    //Final damit die Werte nicht veränderbar sind.
    final int levelOfDeliciousness;
    final double price;

    Cereals (int levelOfDeliciousness, double price) {
        this.levelOfDeliciousness = levelOfDeliciousness;
        
    }
}

// Um diese Abzurufen könnte das in einer main Methode so aussehen: 

public class EnumTutorial {
    public static void main(Strin[] agrs) {

      System.out.println(Cereals.FROOT_LOOPS.levelOfDeliciousness);  

      // Im Terminal würde jetzt 60 stehen.
    }
}
```
#### Switch Ausdruck
Switch-Anweisungen (Switch Statement) wird durch Lambdaartige Notation, Multi Constant Case und Switch-Ausdrücke (Switch Expression) erweitert.

Lambdaartige Notation:
```java
public enum Day {MON, TUE, WED, THUR, FRI, SAT, SUN}

public void appointDay() {
    switch (whichDay) {
        case MON -> System.out.println("Monday");
        case TUE -> System.out.println("Tuesday");
        cas WED, THUR, FRI -> System.out.println("Wochentag");
        case SAT, SUN -> System.out.prinln("Weekend"); 
        // Break nichtmehr notwendig, weil eine Fall-Through Semantik herrscht.
        // ALLE Konstanten des Enums müssen aufgeführt werden oder Default muss verwendet werden! Sonst Comp. Fehler!
    }
}
```
Was macht **yield** und was macht den Einsatz davon in Switch-Case Anwendungen interessant?

yield kann genommen werden um den Wert einer case-Klausel zurückzugeben. Wenn man z. B. die Anzahl der Buchstaben von einem Wochentag zurückgeben möchte. 

```java 
int anzahlBuchstaben;

public void zaehleBuchstaben {
    anzahlBuchstaben = switch (day) {
        case MON -> { System.out.println("Montag");
        yield 6; }

        default -> { 
            yield 0;
        }
    }
}
// yield muss dann aber wenn einmal benutzt in jeder Switch-Anweisung vorkommen! 
```
 
Switch-Ausdrücke kann man auch mit Objekten verwenden. Außerdem ist sind Switch-Ausdrücke in der Lage mittels **Pattern Matching** Typentests (Test ob Int, String, NULL, ...) zu machen und diese dann auch direkt an Variablen zu binden. 

#### Zu den Grundlegenden Klassen in Java zählen auch String, StringBuilder, StringBuffer diese sind in einem Anderen Foliensatz behandelt worden. 

#### Collection-Framework ist in einem anderen Foliensatz 

#### I/O-Framework ist in einem anderen Foliensatz


### Packages
- Ab Java 9 -> 21. September 2017
- Dienen zu Vermeidung von Namenskonflikten 
- Dienen zur Strukturierung eines Programms bzw. der Klassen 
- Dienen zur einfachen Verbreitung zusammengehöriger Klassen 

#### Packages & File-Systems
Packages spiegeln die Verzeichnisstruktur wieder, in der die Klassen abgelegt sind. Innerhalb eines Package müssen die Namen eindeutig zugewiesen sein. 
Die Package Struktur wird mit Punkten getrennt angegeben. Das könnte z. B. so aussehen: 

projekt.teil1.teil1_1.Klasse_x


#### Packages & Namenskonflikte
Package-Namen müssen weltweit eindeutig sein, so das Packages mit dem umgekehrten Domain-Namen der Ersteller Firma beginnen sollten. Innerhalb der Firma, ist die Firma selbst für eine eigenständige Struktur zuständig. Innerhalb des Projekts selbst, sind die daran beteiligten Mitarbeiter verantwortlich. 

Bsp Package Name: 

de.thb.abteilung.projektname.programmstruktur

oder 

de.thb.fim.projektname.umgebung

fim = Fachbereich Informatik

- Packages werden grundsätzlich kleingeschrieben und beinhalten keine Sonderzeichen
- Packages der Sprache Java beginnen mit dem reservierten Schlüsselwort java und bei Extensions mit javax
- Basis-Packages der Sprache Java sehen dann so aus z. B.: java.lang

#### Package-Angabe - Definition
Vor jedem Kommentar und den Import-Klauseln in der ersten Zeile wird der Name des Packages als Konstrukt angebeben. Damit liegt eine Klasse dann in diesem Package. Package-Name und die Ordnerstruktur, in der die Klasse liegt, muss übereinstimmen.

```java 
package de.thb.fim.iceage.charaktere;
```

Mit dem Package wird die Zugehörigkeit einer Klasse zu einem Package beschrieben. Der Package-Name muss immer eindeutig sein. 

#### Import-Klausel - Definition
Durch eine Import-Klausel können Klassen anderer Packages innerhalb einer Klasse bekannt gemacht werden. Hierbei kann ein zu importierende Klasse explizit angegeben werden, oder alle Klassen eines Packages importiert werden. Die Import-Klausel steht vor der Klassen-Definition. 

```java 
// Import von Klassen mit expliziter Angabe
import java.awt.Color; 
// Import aller Klassen des Package "Utilities"
// Sollte aber vermieden werden, da Abhängigkeit ungenau.
import java.util.*;
```

Mit Import kann man **eine einzelne** Klasse oder **alle Klassen** eines Package innerhalb der importierenden Klasse bekannt gemacht werden.


### Programmierhinweise
