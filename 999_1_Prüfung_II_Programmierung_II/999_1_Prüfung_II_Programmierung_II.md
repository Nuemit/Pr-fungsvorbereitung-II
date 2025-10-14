# "Programmierung II" - Programmiersprache: Java
## Aufgabe 1: Standardmethoden
### 1. Wie heißt die Basisiklasse in Java, von welcher alle anderen Klassen in Java spezielle Standardmethoden erben?
### 2. Gegeben ist das folgende Klassendiagramm (achten Sie auf Kursivschrift):
#### Klasse 1: Player
- number: int 
- name: String 
- country: String 

- compareTo()
- equals()
- toString()

Player -> Participant

#### Klasse 2: Participant (Kursiv)
- game: String 

- participate()
- run()
- equals()
- toString()


Implementieren Sie den Initialisierungskonstruktor der Klasse Player, so dass alle Attribute initialisiert werden und das Schlüsselwort super sinnvoll eingesetzt wird. (Hinweis: Gehen Sie davon aus, dass Participant geeignet implementiert ist.)


### 3. Geben Sie wieder die Klasse Player (s. o.). Sie erbt die Methode toString() von der Klasse Participant und überschreibt diese. Implementeiren Sie die toString() Methode für die Klasse Player. Es sollen die Werte alle Attribute von Player eingestzt werden, falls möglich unter Nutzung der Methode(n) der Klasse Participant. (Hinweis: Gehen Sie davon aus, dass Participant geeignet implementierbar ist.)

#### Beispielausgabe: Player Berger Nr. 1 spielt für Deutschland im Spiel Deutschland gegen Frankreich. 



### 4. Gegeben ist wieder die Klasse Player (s. Punkt 2). Sie erbt die Methode equals() von der Klasse Participant und überschreibt diese. Sie können davon ausgehen, dass die Klasse Participant die Methode equals() von der Basisklasse erbt und korrekt überschreibt. 

### 5. Implementieren Sie die equals() Methode für die Klasse Player. Es sollen nur die Werte der Instanzattribute number und game verglichen werden. 


## Aufgabe 2: Vererbung, abstrakte Klasse, Interface, Polymorphismus 
### 1. Abstrakte Klassen und Interfaces sind sich sehr ähnlich, aber nicht gleich. Beschreiben Sie detailliert und in Fachsprache, welche der angegebenen Konzepte wie in abstrakten Klassen und wie in Interfaces vorkommen, so dass die Gemeinsamkeiten und Unterschiede klar ersichtlich sind. 

| Konzepte      | Abrstrakte Klasse | Interface |
| ------------- | ----------------- | --------- |
| Methoden      | ----------------- | --------- |
| Konstruktoren | ----------------- | --------- |


### 2. Erklären Sie den Unterschied zwischen Vererbungswiederverwendung und Nutzungswiederverwendung, indem Sie auf den Zweck eingehen und festlegen, ob abstrakte Klassen oder Interfaces als Implementierungkonzept besser geeignet sind. 

| ------- | Vererbungswiederverwendung | Nutzungswiederverwendung |
| Zweck  | -------------------------- | ------------------------ |
| Implementierungskonzept | --- | --- | 


### 3. Gegeben ist folgendes Klassendiagramm ( achten Sie auf Kursivschrift):

#### Klasse 1: 
<< interface >>
java.lang.Comparable
- compareTo()


#### Klasse 2:
Player
- number
- name 
- country 
- comparaTo()

Zeigt mit gestricheltem Pfeil auf Comparable und Participant


#### Klasse 3:
Paricipant
- game
- participate()
- run()


#### Klasse 4:
Referee
- whistle()


### 4. Programmieren Sie für die Klasse Participant den Klassenkopf
### Programmieren Sie für die Klasse Referee den Klassenkopf 


### 5. Welche der aufgeführten Anweisungen sind für das Klassendiagramm unter Punkt 3 richtig? Lesen Sie die Anweisungen von oben nach unten. Begründen Sie Ihre Antwort für nicht Korrekte Anweisungen. 

| Programmstück | Richtig (ok) / falsch | Begründung für falsche Anweisungen |
|---|---|---|
| Participant p1, p2; | --- | --- |
| Comparable player; | --- | --- |
| p1 = new Participant(); | --- | --- |
| p2 = new Referee(); | --- | --- |
| p2.participate(); | --- | --- |
| player = new Player(); | --- | --- |
| player.run(); | --- | --- |
| p2.whistle(); | --- | --- |

## Aufgabe 3: Aufzählungen
### 1. In Java gibt es ein spezielles Konzept / Sprachelement für Aufzählungen.

#### a) Welches Konzept / Sprachelement bietet Java für die Definition von Aufzählungen?

#### b) Welche drei Ziele / Eigenschaften sind mit diesem Konzept verbunden? 

### 2. Implementieren Sie die Aufzählung namens **Country** für die Länderkürzeln DE und FR. Außerdem hat Country ein Instanzattribut vom Typ String. Dies soll für die beiden Länder mit den Namen (Deutschland und Frankreich) durch einen Konstruktor initialisiert werden und durch die toString() - Methode zur Verfügung stehen.


### 3. Wie kann in einer anderen Klasse auf Werte der Aufzählung z. B. des Länderkürzel DE zugegriffen werden. Implementieren Sie nur den Zugriff.

### 4. Was müssen Sie in der Klasse Player ändern, um die Aufzählung namens Country einzusetzen. Beachten Sie, dass die Klasse Player das Geheimnisprinzip umsetzt. (Schreiben Sie nur den geänderten Code auf.)


## Aufgabe 4: Exception Handling
### 1. Schreiben Sie die Java-Schlüsselworte für Exception Handling auf und beschreiben Sie deren Funktion.

| Schlüsselwort | Funktion |
| ------------- | -------- |
| ------------- | -------- |
| ------------- | -------- |
| ------------- | -------- |

### 2. Welche Klasse ist die Oberklasse für ...?
| Welche Oberklasse ist die Oberklasse für ... ||
| ------------- | -------- |
| alle Exceptions      | -------- |
| checked Exceptions   | -------- |
| unchecked Exceptions | -------- |

### 3. Gegeben sind die Methode toDo und die checked Exception YetNoException. Programmieren / ergänzen Sie die Methode toDo so, dass die YetNoException mit der Fehlermeldung "Not possible now." geworfen wird.

### 4. Gegeben ist die Klasse TestExHa. Beim Ausführen dieser Klasse können folgende zwei Exceptions auftreten: 
- java.lang.ArithmeticException
- java.lang.ArrayIndexOutOfBoundsException

Setzen Sie Exception Handling unter Verwendung jeweils **beider** Exceptions so ein, dass einmal Ausgabe a und einmal Ausgabe b erfolgt.

Die Ausgabe sollen als Standardfehlerausgaben (Bezeichnung in der API: "standard" error output stream.) erfolgen.

Setzen Sie einmal einen Multi-Catch-Block ein und einmal nicht.

```java
public class TestExHa {
    public static void main (String Args[]) {
        int array [] = {1, 2, 3, 4};

        for (int i = 3; i > -2; i--) {
            System.out.println(array[i + 1] / i);
        }
    }
}
```

Ausgabe a:
```java
java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
2
3
java.lang.ArithmeticException: / by zero
-1
```
Ausgabe b:
```java
java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
```

## Aufgabe 5: Objektverwaltung und Collection - API 

### 1. Wann ist eine Objektverwaltung erforderlich? 

### 2. Auf welche beiden Arten kann eine Objektverwaltung implementiert werden? 

### 3. Implementieren (erweitern) Sie die bisherige Klasse Player nun so, dass das Attribut number bei der Objekterzeugung fortlaufend beginnend mit 1 nummeriert wird. Das Geheimnisprinzip soll eingehalten werden. Die als nächstes zu vergebende Nummer ist von außen zugreifbar (lesbar), sie kann aber nicht verändert werden. (Sie müssen nur die neuen und zu verändernden Programmabschnitte programmieren.)

```java 
public class Player {
    // Attribute

    // Konstruktoren und Java-Verwaltungsmethoden

    // Setter und Getter
}
```

### 4. Java bietet für den Einsatz in der Collection-API die beiden Interfaces Comparable und Comparator an. Wofür wird Comparable und wofür Comparator eingesetzt?

| Interface | Einsatz für ... | 
| java.lang.Comparable | --- | 
| java.lang.Comparator | --- | 

### 5. Die Klasse Player soll das Interface Comparable für das Attribut number implementieren. Achten Sie dabei auf Typsicherheit. Ergänzen Sie den vorgegebenen Programmcode entsprechend. (s. Hinweise aus der API)

```java 
public class Player {

    // Attribute
    // Konstruktoren und Java-Verwaltungsmetoden
    // Setter / Getter 
    // compareTo()
}
```

### 6. Gegeben ist die Klasse Team. Die Implementierung ist nicht Typsicher, sodass beliebige Objekte in einer ArrayList gesammelt werden können. 
#### a) Erstellen Sie daraus eine typsichere Klasse, in der ArrayList so eingesetzt wird, dass nur Spieler(players) vom Typ Player zu einer Mannschaft (Team) gehören. (Sie können im Quellcode ändern.)
#### b) Erweitern Sie die Klasse Team, um die beiden in den Kommentaren geforderten Sortier-Methoden (s. folgende Seite). Implementieren Sie die Methoden typsicher und verwenden Sie in der Methode sortPlayersByName einen Lambda-Ausdruck. Zum Sortieren haben Sie Hinweise zur API.

```java 
import java.util.ArrayList;
import java.util.Collectioins;

public class Team {
    
    private ArrayListPlayers;

    public Team() {
        players = new ArrayList();
    }

    public void add (Object o) {
        players.add(o);
    }
    public Object getPlayer (int index) {
        return players.get(index);
    }

    /**
     * method sortPlayers sorts players according to the natural ordering
     * @return a sorted ArrayList
     * */





    /** 
     * method sortPlayersByName sorts players by name 
     * @return a sorted ArrayList
     * */




}
```


#### Informationen aus der Java-API
Die Klasse Collections bietet u.a. die folgenden Methoden: 
- ```public static <T extends> Comparable<? super T>> void sort(List<T> list)```
    - Sorts the specified list into ascending order, according to the natural ordering of its elemtns. All elements in the list must implement the Comparable interface.
    - Parameters: list - the list to be sorted
- ```public static <T> void sort (List<T> list, Comparator<? super T> c)```
    - Sorts the specified list according to the order induced by the specified comparator. 
    - Parameters: 
        - list - the list to be sorted. 
        - c - the comparator to determine the order of the list.

Das Interface Comparable definiert eine abstrakte Methode: 
- int compareTo (T o)
    - Parameters: o - the object to be compared.
    - Returns: a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

Das Interface Comparator definiert eine abstrakte Methode:
- int compare (T o1, T o2) 
    - Parameters: 
        - o1 - the first object to be compared.
        - o2 - the second object to be compared.
    - Returns: a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

Die Klasse String bietet u. a. die folgende Methode: 
- public int compareTo (String another String) 
    - Compares two strings lexicographically. 
    - Parameters: anotherString - the String to be compared.
    - Returns: the value 0 if the argurment string is equal to this string; a calue less then 0 if this string is lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically greater than the string argument.
    





