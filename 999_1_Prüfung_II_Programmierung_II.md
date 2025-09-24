# "Programmierung II" - Programmiersprache: Java
## Aufgabe 1: Standardmethoden
### Wie heißt die Basisiklasse in Java, von welcher alle anderen Klassen in Java spezielle Standardmethoden erben?
### Gegeben ist das folgende Klassendiagramm (achten Sie auf Kursivschrift):
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


### Geben Sie wieder die Klasse Player (s. o.). Sie erbt die Methode toString() von der Klasse Participant und überschreibt diese. Implementeiren Sie die toString() Methode für die Klasse Player. Es sollen die Werte alle Attribute von Player eingestzt werden, falls möglich unter Nutzung der Methode(n) der Klasse Participant. (Hinweis: Gehen Sie davon aus, dass Participant geeignet implementierbar ist.)

### Beispielausgabe: Player Berger Nr. 1 spielt für Deutschland im Spiel Deutschland gegen Frankreich. 



### Gegeben ist wieder die Klasse Player (s. Punkt 2). Sie erbt die Methode equals() von der Klasse Participant und überschreibt diese. Sie können davon ausgehen, dass die Klasse Participant die Methode equals() von der Basisklasse erbt und korrekt überschreibt. 

### Implementieren Sie die equals() Methode für die Klasse Player. Es sollen nur die Werte der Instanzattribute number und game verglichen werden. 


## Aufgabe 2: Vererbung, abstrakte Klasse, Interface, Polymorphismus 
### Abstrakte Klassen und Interfaces sind sich sehr ähnlich, aber nicht gleich. Beschreiben Sie detailliert und in Fachsprache, welche der angegebenen Konzepte wie in abstrakten Klassen und wie in Interfaces vorkommen, so dass die Gemeinsamkeiten und Unterschiede klar ersichtlich sind. 

| Konzepte      | Abrstrakte Klasse | Interface |
| ------------- | ----------------- | --------- |
| Methoden      | ----------------- | --------- |
| Konstruktoren | ----------------- | --------- |


### Erklären Sie den Unterschied zwischen Vererbungswiederverwendung und Nutzungswiederverwendung, indem Sie auf den Zweck eingehen und festlegen, ob abstrakte Klassen oder Interfaces als Implementierungkonzept besser geeignet sind. 

|------- | Vererbungswiederverwendung | Nutzungswiederverwendung |
| Zweck  | -------------------------- | ------------------------ |
| Implementierungskonzept | --- | --- | 


### Gegeben ist folgendes Klassendiagramm ( achten Sie auf Kursivschrift):

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


### Programmieren Sie für die Klasse Participant den Klassenkopf
### Programmieren Sie für die Klasse Referee den Klassenkopf 


### Welche der aufgeführten Anweisungen sind für das Klassendiagramm unter Punkt 3 richtig? Lesen Sie die Anweisungen von oben nach unten. Begründen Sie Ihre Antwort für nicht Korrekte Anweisungen. 

| Programmstück | Richtig (ok) / falsch | Begründung für falsche Anweisungen |
| Participant p1, p2; | --- | --- |
| Comparable player; | --- | --- |
| p1 = new Participant(); | --- | --- |
| p2 = new Referee(); | --- | --- |
| p2.participate(); | --- | --- |
| player = new Player(); | --- | --- |
| player.run(); | --- | --- |
| p2.whistle(); | --- | --- |

## Aufgabe 3: Aufzählungen

## Aufgabe 5: Objektverwaltung und Collection - API 

### Wann ist eine Objektverwaltung erforderlich? 
### Auf welche beiden Arten kann eine Objektverwaltung implementiert werden? 
### Implementieren (erweitern) Sie die bisherige Klasse Player nun so, dass das Attribut number bei der Objekterzeugung fortlaufend beginnend mit 1 nummeriert wird. Das Geheimnisprinzip soll eingehalten werden. Die als nächstes zu vergebende Nummer ist von außen zugreifbar (lesbar), sie kann aber nicht verändert werden. (Sie müssen nur die neuen und zu verändernden Programmabschnitte programmieren.)

```java 
public class Player {
    // Attribute

    // Konstruktoren und Java-Verwaltungsmethoden

    // Setter und Getter
}
```

### Java bietet für den Einsatz in der Collection-API die beiden Interfaces Comparable und Comparator an. Wofür wird Comparable und wofür Comparator eingesetzt?

| Interface | Einsatz für ... | 
| java.lang.Comparable | --- | 
| java.lang.Comparator | --- | 

### Die Klasse Player soll das Interface Comparable für das Attribut number implementieren. Achten Sie dabei auf Typsicherheit. Ergänzen Sie den vorgegebenen Programmcode entsprechend. (s. Hinweise aus der API)

```java 
public class Player {

    // Attribute
    // Konstruktoren und Java-Verwaltungsmetoden
    // Setter / Getter 
    // compareTo()
}
```

### Gegeben ist die Klasse Team. Die Implementierung 





