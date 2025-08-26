# Polymorphie

# Schreibteil

## Was ist Polymorphie

Der Kern der Polymorphie ist die Fähigkeit, eine Referenzvariable eines allgemeinen Typs (z.B. Tier) zu verwenden, um ein Objekt eines spezifischeren Typs (z.B. Hund oder Katze) zu halten. <br>
Vereinfacht gesagt, eine Superklasse stellt Methoden bereit, die von Unterklassen geerbt werden. Wenn nun diese geerbten Methoden auf die Unterklasse zugeschnitten wird entsteht Polymorphie, da das gleiche nur anders genutzt wird.<br>
Ein Beispiel:
Superklasse Tier(allgemeiner Typ) mit der Methode `lautGeben()` bestückt wird nur mit `System.out.println("lautGeben")`(&larr; hört sich noch sehr allgemein an) gefüllt.

Unterklassen, die von Tier erben sind **Katze, Hund und Kuh**(spezifischer Typ). Alle diese Unterklassen besitzen nun die vererbte Methode `lautGeben()` und spezifizieren diese:<br>
`lautGeben()` bei der **Katze** beinhaltet nun `System.out.println("Miau")`<br>
`lautGeben()` bei der **Hund** beinhaltet nun `System.out.println("Wuff")`<br>
`lautGeben()` bei der **Kuh** beinhaltet nun `System.out.println("Muuh")`<br>

Man sieht nun deutlich das immer wieder die gleiche Methode anders genutzt wird.

```Java
public class BeispielEins{
    public static void main(String[] args) {
      //Tier <- Referenzvariable
        Tier bengalkatze = new Katze();
        Tier schäferhund = new Hund();
        Tier zwergzebu = new Kuh();

        bengalkatze.lautGeben();
        schäferhund.lautGeben();
        zwergzebu.lautGeben();
    }
}

class Tier{
    public void lautGeben(){
        System.out.println("lautGeben");
    }
}

class Katze extends Tier{
    @Override // -> Methode wird überschrieben und spezifiziert
    public void lautGeben(){
        System.out.println("Miau");
    }
}

class Hund extends Tier{
    @Override
    public void lautGeben(){
        System.out.println("Wuff");
    }
}

class Kuh extends Tier{
    @Override
    public void lautGeben(){
        System.out.println("Muuh");
    }
}
```


Der Compiler sieht nur den allgemeinen Typ und seine Methoden, aber zur Laufzeit wird die Methode der tatsächlichen Objektinstanz(des speziellem Typs) aufgerufen. Dieser Prozess wird späte Bindung genannt.


## Späte Bindung

Um späte Bindung zu erklären wird das Beispiel aus dem Folien von Frau Schmidt benutzt.
<br>
Der Code besteht aus den Klassen Tier, ZweiBeiner, Rattenhörnchen mit der folgenden Vererbungshierarchie:

**Tier** <br><br>
&darr; *vererbt an* <br><br>
**ZweiBeiner** <br><br>
&darr; *vererbt an* <br><br>
**Rattenhoernchen**

```Java
public class Tier {
    int alter;
    String name;

    public Tier(int alter, String name) {
        this.alter = alter;
        this.name = name;
    }

    public Tier(){}

    public void bewegen(){
        System.out.println("Bewegen");
    }

    public void fressen(){
        System.out.println("Fressen");
    }

    public void schlafen(){
        System.out.println("Schlafen");
    }

    public void lautGeben(){
        System.out.println("LautGeben");
    }
}
-------------------------------------------------------
public class ZweiBeiner extends Tier {
    public ZweiBeiner(int alter, String name) {
        super(alter, name);
    }

    public ZweiBeiner() {}

    @Override
    public void bewegen(){
        System.out.println("Zwei Beine bewegen");
    }
}
-------------------------------------------------------
public class Rattenhoernchen extends ZweiBeiner {
    public Rattenhoernchen(int alter, String name){
        super(alter, name);
    }

    public Rattenhoernchen(){}

    @Override
    public void lautGeben() {
        System.out.println("Rattenhoernchen squiieet");
    }

    public void versteckeEichel(){
        System.out.println("Rattenhoernchen versteckt Eichel");
    }
}
```
In der Folie wird nun mithilfe einer Main-Klasse gefragt, was passieren wird, wenn diese ausgeführt wird.

```Java
public class Main {
    public static void main(String[] args) {
        Tier meinFigur;

        meinFigur = new Rattenhoernchen(12, "Scrat");

        meinFigur.lautGeben();
        meinFigur.schlafen();
        meinFigur.bewegen();

        meinFigur.versteckeEichel();
    }
}

```

`Tier meinFigur;` eine Variable wird deklariert. Der allgemeine Typ (oder auch statischer Typ genannt) ist hier `Tier`.<br>
`meinFigur = new Rattenhoernchen(12, "Scrat");`die Variable wird einem neuen Objekt zugewiesen. Der spezifische Typ (oder auch dynamische Typ genannt, da er zur Laufzeit bestimmt wird) ist hier `Rattenhoernchen`.<br><br>

Nun werden einzelne Methoden von `meinFigur` aufgerufen und gefragt welcher Methodenaufruf funktioniert oder der Compiler einen Fehler findet. <br><br>

**Wie geht der Compiler vor?**<br> 
Der Compiler kennt den statischen Typ seit wir ihn als Code geschrieben haben. Den dynamischen Typ guckt sich der Compiler erst an, wenn das Programm ausgeführt wird. Dem entsprechend kennt der Compiler alle Methoden aus `Tier`(statischer Typ) und guckt sich beim Ausführen erst die Methoden des dynamischen Typs (`Rattenhoernchen`) an. Wenn nun der Compiler eine überschriebene Methode, der vererbten Methoden des statischen Typs findet, nimmt er diese. Wenn er aber eine Methode nicht findet geht er in der Vererbungs-Hierarchie nach oben und sucht dort weiter. Falls es gar keine überschriebene Methode gibt nutzt er einfach die aus dem statischen Typ `Tier`.<br>
**Wichtig**, der Compiler kennt nur die Methoden des statischen Typs. Wenn der dynamische Typ noch andere Methoden besitzt, außer die vererbten des statischen Typs, kennt der Compiler diese nicht. Der statische Typ setzt quasi einen Rahmen in der sich der Compiler bewegt und nach Methoden suchen kann.<br><br>


> **Gehen wir die einzelnen Methodenaufrufe durch:**<br><br>
>
>`meinFigur.lautGeben();` &larr; der Compiler sucht jetzt nach der Methode in Rattenhörnchen und findet die überschriebene lautGeben() Methode, somit ist die Ausgabe im Terminal: "Rattenhoernchen squiieet".<br><br>
>
>`meinFigur.schlafen();`&larr; der Compiler finde sowohl in Rattenhoernchen als auch in ZweiBeiner keine überschriebene Methode und nimmt dadurch die Methode aus Tier. Die Ausgabe im Terminal ist: "Schlafen".<br><br>
>
> `meinFigur.bewegen();` &larr; der Compiler findet keine überschriebene Methode in Rattenhoernchen und geht die Vererbungs-Hierarchie eine Stufe nach oben. Im ZweiBeiner finde er die überschriebene Methode bewegen() und gibt sie aus: "Zwei Beine bewegen".<br><br>
>
> `meinFigur.versteckeEichel();`&larr; der Compiler kennt nur alle Methoden aus dem statischen Typ Tier und weiß somit nichts mit diesem Methodenaufruf anzufangen, daher wirft er einen Fehler namens "cannot find symbol"



 




---
---
---

























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