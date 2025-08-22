# Polymorphie

Sie haben vollkommen recht, mein Fehler\! Die Methode `versteckeEichel()` kann in diesem Beispiel **nicht** über die Variable `meinFigur` aufgerufen werden. Ihre Beobachtung ist absolut korrekt.

-----

### Der Grund für den Fehler

Der Grund für den Fehler "Symbol nicht gefunden" liegt in der **späten Bindung** und dem **statischen Typ** der Variable:

1.  **Statischer Typ:** Die Variable `meinFigur` ist als Typ `Tier` deklariert (`Tier meinFigur;`). Der Compiler überprüft den Code zum Zeitpunkt der Kompilierung (statisch). Er sieht nur, dass `meinFigur` eine Referenz auf ein **allgemeines `Tier`** ist.
2.  **Fehlende Methode:** Die Methode `versteckeEichel()` ist nur in der Unterklasse `Rattenhoernchen` definiert, nicht aber in der Oberklasse `Tier`. Da der Compiler nur den statischen Typ `Tier` kennt, kann er die Methode `versteckeEichel()` auf dieser Ebene nicht finden.

Das Verhalten des Programms wird zwar zur Laufzeit dynamisch bestimmt (späte Bindung), aber der **Zugriff** auf Methoden und Attribute wird bereits zur Kompilierungszeit vom Compiler auf Basis des **statischen Typs** geprüft.

### So würde es funktionieren

Um die Methode `versteckeEichel()` aufrufen zu können, müssen Sie eine Variable vom Typ `Rattenhoernchen` verwenden.

```java
public class Main {
    public static void main(String[] args) {
        // Deklaration als Rattenhoernchen-Typ
        Rattenhoernchen scrat = new Rattenhoernchen(12, "Scrat");

        scrat.lautGeben();
        scrat.schlafen();
        scrat.bewegen();
        scrat.versteckeEichel(); // ✅ Funktioniert, weil der Typ Rattenhoernchen ist
    }
}
```

Alternativ könnten Sie einen **Type Cast** (Typumwandlung) durchführen, um dem Compiler zu versichern, dass das Objekt in `meinFigur` tatsächlich ein `Rattenhoernchen` ist:

```java
public class Main {
    public static void main(String[] args) {
        Tier meinFigur = new Rattenhoernchen(12, "Scrat");

        // ... andere Methodenaufrufe ...

        // ✅ Funktioniert durch Type Cast
        ((Rattenhoernchen) meinFigur).versteckeEichel(); 
    }
}
```

Diese zweite Methode ist jedoch riskant, da sie zu einem Laufzeitfehler (`ClassCastException`) führt, wenn die Variable `meinFigur` zum Zeitpunkt des Aufrufs kein `Rattenhoernchen`-Objekt enthält.

---
---
---

Genau diese Frage bringt uns zum Kern der **Polymorphie**. Der Grund, warum Sie `Tier meinFigur = new Rattenhoernchen();` machen sollten, liegt in der **Flexibilität** und der **Erweiterbarkeit** Ihres Codes.

Sie haben Recht, Sie können über die Variable `meinFigur` nicht direkt auf die **spezifischen Methoden** der `Rattenhoernchen`-Klasse zugreifen. Aber das ist nicht der Sinn der Sache.

-----

### Der wahre Wert von Polymorphie

Der Wert liegt darin, dass Sie **generischen Code** schreiben können, der mit **allen** `Tier`-Objekten (Hund, Katze, Rattenhörnchen, etc.) funktioniert.

Stellen Sie sich vor, Sie haben ein Array mit verschiedenen Tier-Objekten.

```java
Tier[] tiere = new Tier[3];
tiere[0] = new Hund();
tiere[1] = new Katze();
tiere[2] = new Rattenhoernchen();
```

Jetzt können Sie eine einzige Schleife schreiben, die für jedes Tier in diesem Array die gleiche Methode aufruft:

```java
for (Tier t : tiere) {
    t.machGeräusch(); // Jedes Tier macht sein spezifisches Geräusch!
}
```

Die Ausgabe wäre:

```
Wuff!
Miau!
LautGeben
```

### Die zwei Sichtweisen

1.  **Sichtweise der Entwicklerin:** Sie können eine Methode (z.B. `machGeräusch()`) aufrufen, ohne zu wissen, ob es sich um einen Hund, eine Katze oder ein Rattenhörnchen handelt. Ihr Code ist schlank und muss nicht für jede neue Tierart angepasst werden. Das ist das Prinzip der **Polymorphie**.

2.  **Sichtweise des Laufzeitsystems:** Zur Laufzeit (späte Bindung) schaut das Programm auf den **tatsächlichen Objekttyp** in der Schleife. Bei `tiere[0]` sieht es, dass es ein `Hund` ist, und führt die `machGeräusch()`-Methode des `Hundes` aus. Bei `tiere[1]` macht es dasselbe mit der `Katze`.

Sie verwenden also den allgemeinen Typ `Tier`, um eine Gruppe von Objekten zu verwalten, die alle ein ähnliches **Verhalten** (die Methoden der `Tier`-Klasse) haben. Das ist viel effizienter, als für jede einzelne Unterklasse eine eigene Variable und eigene Logik zu schreiben. Polymorphie trennt das **"Was"** (die allgemeine Aktion wie `machGeräusch()`) vom **"Wie"** (der spezifischen Implementierung).


---
---
---

Ja, das ist **absolut korrekt**! 🎯 Sie haben das Konzept der Polymorphie mit später Bindung perfekt verstanden.

---

### Ihre Zusammenfassung in zwei Punkten:

1.  **Späte Bindung und Polymorphie:** Wenn Sie `Tier meinFigur = new Rattenhoernchen();` schreiben, können Sie auf alle Methoden zugreifen, die in der `Tier`-Klasse existieren. Zur **Laufzeit** entscheidet Java, welche **Implementierung** aufgerufen wird. Wenn die Methode in `Rattenhoernchen` überschrieben wurde, wird diese spezifische Version ausgeführt. Das ist die Essenz der **späten Bindung**.

2.  **Statische Typüberprüfung:** Der **Compiler** sieht die Variable `meinFigur` nur als vom Typ `Tier`. Methoden, die ausschließlich in der Unterklasse `Rattenhoernchen` existieren (wie `versteckeEichel()`), sind dem Compiler zum Kompilierungszeitpunkt unbekannt. Deshalb gibt es den Fehler "**Symbol nicht gefunden**", bevor das Programm überhaupt startet.

Es ist, als würden Sie einen Anwalt einstellen, um allgemeine Rechtsfragen zu klären. Er kann alle Aufgaben ausführen, die in der Stellenbeschreibung "Anwalt" stehen. Wenn dieser Anwalt aber auf Immobilienrecht spezialisiert ist, kann er auch diese speziellen Aufgaben erledigen. Allerdings können Sie ihn nicht für einen Fall beauftragen, der nur für Spezialisten im Immobilienrecht vorgesehen ist, ohne vorher ausdrücklich seine Spezialisierung zu bestätigen (in Java wäre das der Type Cast).

---
---
---
Genau! Sie haben einen der wichtigsten und oft verwirrendsten Aspekte der Objektorientierten Programmierung (OOP) erfasst. 🧠 Sie sprechen von der Unterscheidung zwischen **statischem Typ** und **dynamischem Typ**.

### Statischer Typ (Ebene der Referenz)

Der **statische Typ** ist der Typ der Variable, die Sie deklarieren. Der Compiler sieht diesen Typ, wenn er Ihren Code überprüft. 

* Beispiel: `Tier meinFigur;`
* Hier ist `Tier` der statische Typ.

Der Compiler nutzt den statischen Typ, um zu prüfen, ob ein Methodenaufruf überhaupt gültig ist. Er weiß nur, welche Methoden die Klasse `Tier` hat, und verbietet Ihnen, Methoden aufzurufen, die nur in Unterklassen existieren.

### Dynamischer Typ (Ebene des Objekts)

Der **dynamische Typ** ist der tatsächliche Typ des Objekts, das sich zur Laufzeit in der Variable befindet.

* Beispiel: `new Rattenhoernchen();`
* Hier ist `Rattenhoernchen` der dynamische Typ.

Zur Laufzeit verwendet das Programm den dynamischen Typ, um zu bestimmen, welche Methode tatsächlich ausgeführt wird (die `machGeräusch()` von der Katze oder die vom Hund). Das ist das Prinzip der **späten Bindung** und der **Polymorphie**.

---

### Die Kombinationen

Ihre Beobachtung ist perfekt: Die Kombination dieser beiden Ebenen ist der Schlüssel zum Verständnis.

1.  **Gleicher statischer und dynamischer Typ:**
    * `Rattenhoernchen meinFigur = new Rattenhoernchen();`
    * Die Variable kann nur Rattenhörnchen-Objekte speichern. Sie können alle Methoden von `Rattenhoernchen` (und seinen Superklassen) aufrufen. Es gibt keine Polymorphie in diesem Sinne, da der Typ immer feststeht.

2.  **Unterschiedlicher statischer und dynamischer Typ:**
    * `Tier meinFigur = new Rattenhoernchen();`
    * Die Variable kann jedes `Tier`-Objekt speichern. Sie können nur Methoden aufrufen, die in der `Tier`-Klasse definiert sind. Das tatsächliche Verhalten wird jedoch zur Laufzeit vom `Rattenhoernchen`-Objekt bestimmt. Genau hier entfaltet sich die **Polymorphie**.

Ihre Erkenntnis ist ein großer Schritt, da sie die Grundlage für flexiblen und erweiterbaren Java-Code bildet.