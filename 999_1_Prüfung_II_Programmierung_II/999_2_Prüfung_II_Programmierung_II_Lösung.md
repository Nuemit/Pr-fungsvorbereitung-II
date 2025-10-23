# "Programmierung II" - Programmiersprache: Java - LÖSUNG 
## Aufgabe 1: Standardmethoden
### 1. Wie heißt die Basisklasse in Java, von welcher alle anderen Klassen in Java spezielle Standardmethoden erben? 
- java.util.Object;
---
### 2. Gegeben ist das folgende Klassendiagramm (achten Sie auf Kursivschrift):
```java 
public class Player {
    // Variablen
    int number;
    String name;
    String country;

    // Methoden
    compareTo();
    equals();
    toString();
}

// Player zeigt auf Participant
// Participant ist Kursiv

public class Participant {
    // Variablen
    String game;

    // Methoden
    participate();
    run();
    equals();
    toString();
}
```
#### Implementieren Sie den Initialisierungskonstruktor der Klasse Player so, dass alle Attribute initialisiert werden und das Schlüsselword super sinnvoll eingesetzt wird. (Hinweis: Gehen Sie davon aus, dass Participant geeignet implementiert ist.)

```java
public class Player extends Participant{

    public Player (String game,int number, String name, String country) {
        super(game);
        this.number = number;
        this.name   = name;
        this.country = country;
    }

}
```
---
### 3. Gegeben Sind wieder die Klasse Player (siehe oben). Sie erbt die Methode toString() von der Klasse Participant und überschreibt diese. Implementieren Sie die toString() Methode für die Klasse Player. Es sollen die Werte alle Attribute von Player eingesetzt werden, falls möglich unter Nutzung der Methode(n) der Klasse Participan. (Hinweis: Gehen Sie davon aus, dass Participant geeignet implementierbar ist.)
- Beispielausgabe: Player Berger Nr 1 spielt für Deutschland im Spiel Deutschland gegen Frankreich.
```java
public class Player extends Participant {

    @Override
    public String toString () {
        return "Player " + name + " Nr " + number + " spielt für " + country + " im Spiel " + super.toString();
    }
}
```
---
### 4. Geben Sie wieder die Klasse Player (siehe Punkt 2). Sie erbt die Methode equals() von der Klasse Participant und überschreibt diese. Sie können davon ausgeben, dass die Klasse Participant die Methode equals() von der Basisklasse erbt und korrekt überschreibt.

