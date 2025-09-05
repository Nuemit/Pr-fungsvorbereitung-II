# Cast

Sobald ein Objekt erstellt wurde, kann man seinen **dynamischen Typ nicht mehr ändern**. Man kann aber mit einem Cast eine **neue Referenzvariable** erstellen, deren statischer Typ sich vom ursprünglichen unterscheidet, während sie auf dasselbe Objekt verweist.

## Upcasting

Upcasting ist der Vorgang, bei dem ein Objekt einer Unterklasse als eine Instanz ihrer Oberklasse behandelt wird. Es ist eine implizite (automatische) Konvertierung, weil die Unterklasse immer alle Eigenschaften und Methoden ihrer Oberklasse besitzt. Es gibt also keine Möglichkeit, dass Informationen verloren gehen.

## Downcast

Downcasting ist der Vorgang, bei dem ein Objekt von einem Oberklassentyp zu einem spezifischeren Unterklassentyp konvertiert wird. Dieser Vorgang ist **nicht automatisch** möglich, da der Compiler nicht garantieren kann, dass das Objekt zur Laufzeit tatsächlich vom Unterklassentyp ist. Daher muss ein **expliziter Cast**, der Laufzeit überprüft wird, verwendet werden, der dem Compiler signalisiert, dass der Programmierer die Verantwortung für die Korrektheit der Konvertierung übernimmt.

Wenn die Konvertierung fehlschlägt, weil das Objekt nicht tatsächlich vom angegebenen Untertyp ist, tritt eine `ClassCastException` zur Laufzeit auf.

```Java
// Upcast: Ein Rattenhoernchen-Objekt wird als Tier gespeichert.
Tier meinFigur = new Rattenhoernchen(12, "Scrat");

// Downcast: Die Tier-Variable wird wieder in einen Rattenhoernchen-Typ konvertiert.
// Das ist möglich, weil das Objekt dahinter tatsächlich ein Rattenhoernchen ist.
Rattenhoernchen deinFigur = (Rattenhoernchen) meinFigur;

// Jetzt kannst du auf spezifische Methoden der Rattenhoernchen-Klasse zugreifen.
deinFigur.nuesseSammeln();
```

## Doch wie hoch oder tief kann man casten?

Zum Erklären benutze ich eine Gedankenbild. Stell dir ein Hochhaus vor. Jede Etage sind deine Klassen und das Hochhaus symbolisiert die Vererbungshierarchie. Das Dachgeschoss jedes Hochhaus wird immer `Object`sein, da jede Klasse davon erbt. Nun müssen wir, um die Höhe des Hochhauses zu kennen, bestimmen was unser Erdgeschoss ist. Die Regel ist: wenn der dynamische Typ = statischer Typ ist, ist es das Erdgeschoss.<br>
Beispiel, wir haben die Vererbungshierarchie: (Object) &rarr; Tier &rarr; ZweiBein &rarr; Rattenhoernchen &rarr; (mehrere Unterklassen z.B. GrauesRattenhoernchen, BlauesRattenhoernchen, RotesRattenhoernchen, etc.)<br><br>

`Rattenhoernchen ratte = new Rattenhoernchen` ergibt ein Erdgeschoss und das Haus wäre jetzt 3 Etagen hoch ((Object) &rarr; Tier &rarr; ZweiBein).

`Tier tier = new Tier`hätte nur eine Etage, nämlich Object als Dachgeschoss. <br><br>

Tier hat jetzt sozusagen Kelleretagen (ZweiBein &rarr; Rattenhoernchen &rarr; (mehrere Unterklassen z.B. GrauesRattenhoernchen, BlauesRattenhoernchen, RotesRattenhoernchen, etc.)) und auch Rattenhoernchen hat einen Keller mit mehreren Unterklassen.

### Doch warum darf man nicht tiefer als Erdgeschoss casten?

Wenn du zum Beispiel `GrauesRattenhoernchen grau = new Rattenhoernchen()` schreibst, versuchst du, ein allgemeines Objekt (`Rattenhoernchen`) in eine spezifische Variable (`GrauesRattenhoernchen`) zu zwängen. Der Compiler stoppt das, weil er die **Typsicherheit** gewährleisten muss.

### Die "Ist-ein"-Beziehung

Die "Ist-ein"-Beziehung ist eine fundamentale Regel, die besagt, dass eine Unterklasse eine spezialisierte Version ihrer Oberklasse ist. Ein `GrauesRattenhoernchen` **ist ein** `Rattenhoernchen`, aber ein `Rattenhoernchen` ist nicht zwangsläufig ein `GrauesRattenhoernchen`. Es kann auch ein `BraunesRattenhoernchen` oder ein `WeissesRattenhoernchen` sein. 

* **Der Compiler sieht es so:** Wenn du `GrauesRattenhoernchen grau = new Rattenhoernchen()` schreibst, verlangst du vom Compiler, dass er etwas akzeptiert, das nicht wahr sein muss. Er muss garantieren, dass die Variable `grau` auf ein Objekt zeigt, das die spezifischen Eigenschaften eines `GrauesRattenhoernchen` besitzt.
* **Der Compiler verweigert die Zuweisung:** Da das Objekt auf der rechten Seite nur als generisches `Rattenhoernchen` erstellt wurde, kann der Compiler nicht wissen, ob es auch wirklich ein `GrauesRattenhoernchen` ist. Um Typsicherheitsfehler zu vermeiden, blockiert er die Zuweisung und wirft einen Kompilierungsfehler.


## Warum equals() mit getClass() und nicht instaceOf()

Wenn dein Lehrer darauf besteht, `getClass()` anstelle von `instanceof` zu verwenden, folgt er einem bestimmten Designprinzip, das als **Klassen-Identität** (class identity) oder **strikte Gleichheit** bekannt ist.

### Der Unterschied

1.  **`instanceof` (Typ-Kompatibilität):** Dieser Operator prüft, ob das übergebene Objekt eine Instanz der eigenen Klasse **oder einer ihrer Unterklassen** ist.

      * **Beispiel:** Ein `Rattenhoernchen` ist auch `instanceof Tier`. Eine `equals`-Methode in der `Tier`-Klasse, die `instanceof` verwendet, würde `Tier` und `Rattenhoernchen` als gleichwertige Typen betrachten (bis sie die Felder vergleicht).

2.  **`getClass()` (Klassen-Identität):** Diese Methode gibt die genaue Klasse eines Objekts zurück.

      * **Beispiel:** `tierObjekt.getClass()` gibt `Tier.class` zurück, während `rattenhoernchenObjekt.getClass()` `Rattenhoernchen.class` zurückgibt. Eine `equals`-Methode, die `getClass()` verwendet, würde nur dann fortfahren, wenn beide Objekte exakt denselben Typ haben.

## Warum man `getClass()`

Die `equals()`-Methode in Java ist ein hervorragendes Beispiel für Polymorphie, Upcasting und Downcasting.

* Der Parameter der Methode (`Object obj`) akzeptiert jeden Typ von Objekt, was durch einen **impliziten Upcast** ermöglicht wird.
* Der `getClass()`-Operator ist die empfohlene Methode, um die Gleichheit von Objekten zu prüfen, da er sicherstellt, dass die Objekte exakt den gleichen Typ haben und die **Symmetrie** der `equals`-Methode gewährleistet.
* Nachdem `getClass()` die Gleichheit der Klassen bestätigt hat, ist ein **Downcast** (`(Rattenhoernchen) obj;`) sicher. Dieser Downcast ist erforderlich, um auf die spezifischen Felder der Unterklasse zuzugreifen, da der Compiler den Parameter `obj` nur als allgemeinen `Object`-Typ sieht.

**Vorteile von `getClass()`:**

  * **Symmetrie:** Es garantiert, dass die `equals`-Methode symmetrisch ist. Wenn `a.equals(b)` wahr ist, muss auch `b.equals(a)` wahr sein. Mit `instanceof` kann das bei Vererbung ein Problem sein.
  * **Strikte Gleichheit:** Es stellt sicher, dass Objekte nur dann als gleich gelten, wenn sie wirklich dieselbe Klasse haben. Dies vermeidet unerwartete Vergleiche zwischen einem Objekt der Oberklasse und einem der Unterklasse, die möglicherweise nicht die gleichen Felder besitzen.

### Beispiel für die `equals`-Methode mit `getClass()`

```java
public class Rattenhoernchen {
    private String name;
    private int alter;

    @Override
    public boolean equals(Object obj) {
        // Prüft, ob 'obj' null ist oder nicht exakt denselben Klassentyp hat
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        // Sicherer Downcast, da der Typ bereits geprüft wurde
        Rattenhoernchen other = (Rattenhoernchen) obj;

        // Vergleiche die Felder
        return this.name.equals(other.name) && this.alter == other.alter;
    }
}
```

Zusammenfassend lässt sich sagen, dass der Gebrauch von `getClass()` eine **strengere** Definition von Gleichheit erzwingt. Beide Ansätze (`instanceof` und `getClass()`) haben ihre Berechtigung, aber für die meisten Fälle und um das `equals`-Vertrag einzuhalten, ist `getClass()` die sicherere und empfohlene Methode.

## Zeitstrahl einer `equals()``

**1. Objekt-Erstellung**
Das Objekt wird im Speicher erzeugt.

`Tier meinFigur = new Rattenhoernchen();`
* **Statischer Typ von `meinFigur`**: `Tier`
* **Dynamischer Typ von `meinFigur`**: `Rattenhoernchen`

---

**2. Parameterübergabe an `equals(Object obj)`**
Die Variable `meinFigur` wird als Argument an die Methode `equals` übergeben.

* Der Parameter `obj` der Methode erhält eine Referenz auf dasselbe Objekt. 
* **Statischer Typ des Parameters `obj`**: `Object` (Der Compiler behandelt es als den allgemeinsten Typ.)
* **Dynamischer Typ des Parameters `obj`**: `Rattenhoernchen` (Das Objekt selbst ändert seinen Typ nicht.)

---

**3. Innerhalb der `equals`-Methode**
Die Methode beginnt mit der Ausführung.

`if (this.getClass() == obj.getClass()) { ... }`

* `obj.getClass()` gibt `Rattenhoernchen.class` zurück, da der dynamische Typ des Objekts `Rattenhoernchen` ist.
* Die Bedingung ist wahr, weil beide Klassen übereinstimmen.

---

**4. Downcast**
Eine neue Variable wird erzeugt, um die spezifischen Felder des Objekts zugänglich zu machen.

`Rattenhoernchen other = (Rattenhoernchen) obj;`

* **Statischer Typ von `obj`**: Bleibt `Object`.
* **Dynamischer Typ von `obj`**: Bleibt `Rattenhoernchen`.
* **Statischer Typ von `other`**: `Rattenhoernchen` (Explizit deklariert.)
* **Dynamischer Typ von `other`**: `Rattenhoernchen` (Zeigt auf das gleiche Objekt wie `obj`.)

Der Zeitstrahl zeigt also, dass sich der dynamische Typ des Objekts nie ändert. Was sich ändert, ist, wie der Compiler und die Variablen das Objekt in verschiedenen Phasen sehen.

## Warum Downcast in `equals()`

Wenn ein eine Referenzvariable nicht den gleichen statischen Typ hat, wie die Klasse in der equals() benutzt wird, kann man nicht auf alle Klassenattribute zugreifen. Deshalb wird Downgecastet, um sicher zu stellen, das alle Felder/Attribute miteinander verglichen werden können.

### Beispiel:

Klasse Tier hat die Attribute [int age] und [String name]<br>
Klasse Nilpferd hat die geerbten Attribute von Tier und [int gewicht]<br><br>

Würde man nun eine Referenzvariable erstellen wie: `Tier hippo = new Nilpferd`, und in der `equals()`nicht downcasten könnte man nur auf die Tier attribute zugreifen und somit wäre die `equals()`nicht mehr brauchbar.<br>
Nun wird eine neue Referenzvariable erstellt mit der man `hippo`downcastet: `Nilpferd dickeshippo = (Nilpferd) hippo`. Jetzt kann man mit `dickeshippo` auf alle Attribute zugegriffen und eine sichere `equals()`durchgeführt werden.


## Parameterübergabe

Eine Parameterübergabe ist im Grunde nichts anderes, als wenn eine neue, lokale Referenzvariable für die Methode erstellt wird, die dann auf dasselbe Objekt verweist wie die ursprüngliche Referenz.

Stellen Sie sich das so vor: Ihr Hauptprogramm hat eine Variable (z.B. `meinFigur`), die wie ein Schlüssel zu einem Haus ist. Wenn Sie `meinFigur` an eine Methode übergeben, wird eine Kopie dieses Schlüssels gemacht und der Methode gegeben. Die Methode hat jetzt einen eigenen, lokalen Schlüssel (`obj`), der aber zum selben Haus führt. 

Weil beide Variablen (der ursprüngliche Schlüssel und der Kopie-Schlüssel) auf dasselbe Objekt im Speicher zeigen, können Sie mit beiden dasselbe Haus betreten und die Möbel darin umstellen. Der einzige Unterschied ist, dass der neue Schlüssel (`obj`) nur so lange gültig ist, wie die Methode läuft.

### Das große Ganze

* Eine **Parameterübergabe** in einer Methode erzeugt eine neue, lokale Referenzvariable, die eine Kopie der ursprünglichen Referenz ist. Beide Referenzen zeigen auf dasselbe Objekt im Speicher.
* Das Objekt selbst behält immer seinen dynamischen Typ.
* Die **Typ-Sicherheit** in Java wird durch die strikte Unterscheidung zwischen dem statischen (Compiler-Sicht) und dem dynamischen (Laufzeit-Sicht) Typ aufrechterhalten. Der Compiler schützt den Code, indem er nur Operationen auf dem statischen Typ zulässt, während die JVM zur Laufzeit das volle Potenzial des dynamischen Typs nutzt.




