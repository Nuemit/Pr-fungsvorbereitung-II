# Collection Framework
Dieses Youtube [Video](https://m.youtube.com/watch?v=viTHc_4XfCA&pp=ygUaamF2YSBjb2xsZWN0aW9ucyBmcmFtZXdvcms%3D) geht sehr gut darauf ein was das Collection Framework anbietet um mit Datenstrukturen zu arbeiten. *Nuemit* bezieht sich grundlegend viel auf dieses Video in dieser aufarbeitung.

Die Vorlesungsthemen die Abgebildet werden lauten:
- **Begriffsbildung**
- **Collection-API**
- **Collections & Iteration**
- **Vergleich von Objekten**
  - **Interface Comparable**
  - **Interface COmparator**

Wenn über Collections geredet wird, müssen wir über Datenstrukturen reden. Die Relevantesten sind vermutlich `List, Linked-List, Arrays, Binäre-Bäume, Hashtables und Hashmaps`

## Grundlegende Erläuterung nach Prof
Bei einer Objektverwaltung weiß man vor der Implementierung nicht immer genau, wie viele Objekte angelegt werden, so entstehen Probleme wenn man neue Objekte hinzufügen möchte. Ein Weiterer Punkt der Betohnt wird ist, dass man auch ab und zu, objekte aus einer Liste, löschen möchte.

Hier kommt das Collection Framework ins Spiel, `Collectoins` sind **Container**, die Elemente eines Typs aufnehmen. Sie haben keine feste Größe und können daher eine beliebige anzahl an Elementen aufnehmen. Zudem bietet das Framework eine vielzahl an Methoden um Objekte zu verwalten.

**Zusammenfassung**
- Unbestimmte Größe
- Beliebiger Datentyp
- Methoden zur Objektverwaltung

### Definition Framework nach Prof
- Jedes Framework gibt einen Bestimmten Aufbau, bestimmte Abläufe und bestimmte Nutzungsmöglichkeiten vor, das nennt man "Software ARchitektur".

Das Collection Framework bietet:
- Interfaces
- Algorithmen
- Standard-Implementierungen

Und gibt in vielen Kommentaren an, welche "Verträge / Contracts" bei der Implementierung eingehalten werden müssen.

# Grundlegendes
Das `Collection` Framework bietet die folgenden "Interfaces" in dieser Hierarchie an:

- `Iterable`
  - `Collection`
    - **Sets**
      - HashSet
      - TreeSet
      - LinkedHashSet
    - **Lists**
      - ArrayList
      - LinkedList
    - **Queues**
      - PriorityQueue

Dabei ist es Wichtig zu erwähnen, das diese in die untergruppen von `java.util.List`, `java.util.Set` und `java.util.Map` einzuteilen sind.

`java.util.List` Beschreibt eine Reihung von Objekten.

`java.util.Set` ist mit Mathemathischen Mengen zu vergleichen, in den ein Element oder Objekt nur einmal vorkommen darf.

`java.util.Map` sind Schlüssel- oder Element- Paare, so dass jedes Objekt unter einem Namen oder Schlüssel zu referenzieren ist.

![Eine Übersicht in UML](Interfaces_collection_api.png)

Wir gehen davon aus, das folgende Klassen eine rolle in der Klausur spieln können:
* ArrayList
* LinkedList
* HashSet
* TreeSet

Alles was die TypSicherheit von `Generics` betrifft findet ihr [Hier](/Generics)