# Generics
Generics gehören unmittelbar mit dem Collection Framework zusammen.

## Prog Fragen

**1. Wofür verwendet man Generics?**

- Generics werden verwendet, um typsicheren und wiederverwendbaren Code zu schreiben, der mit unterschiedlichen Datentypen flexibel umgehen kann, ohne dass man für jeden Typ eine eigene Klasse oder Methode erstellen muss. Sie ermöglichen es dem Compiler, Typsicherheit zur Kompilierzeit zu überprüfen, reduzieren die Notwendigkeit von explizitem Casten und verhindern Laufzeitfehler, die durch falsche Typumwandlungen entstehen könnten.

**2. Was versteht man unter generischen Klassen bzw. generischen Typen?**

- Generische Klasse/Generisches Interface
    - ... besitzt unbekannte Typen, die durch Typvariablen zu definieren sind
    - ... kann über die Typvariablen die Typen von Attributen bestimmen
    - ... kann über Typvariablen die Ausprägung von generischen Typen bestimmen
    - ... kann über die Typvariablen die Parametertypen von Methoden bestimmen
    - ... kann über Typvariablen die Rückgabetypen von Methoden bestimmen
    - ... kann über Typvariablen Typkonvertierung bestimmen


- Generischer Typ
    - ... ist eine spezielle Ausprägung einer generischen Klasse bzw. Interfaces
    - ... ist durch die Belegung der Typvariablen durch konkrete Typen (Typargumente) definiert
    - ... legt fest, welche Objekte hinzugefügt/verwaltet werden dürfen
    - ... gibt ausschließlich Objekte des verwalteten Typs zurück
    - ... ermöglicht es dem Compiler eine generische Klasse zu kompilieren
    - ... wird von der Java Virtual Machine (JVM) als normale Klasse angesehen

**3. Was versteht man unter Typsicherheit?**

- Die Typisierung soll sicherstellen, dass nur Objekte des korrekten Typs (etwa Integer, String, ... oder selbstdefinierte Klassen wie CD, Song, Gericht, ...) eingefügt werden können.

- Typsicherheit bedeutet:
    - Die Methoden einer Klasse schreibt die zu verwendenden Parametertypen vor.
    - Eine Klasse gibt ausschließlich passende Typen zurück, ohne eine Typkonvertierung vornehmen zu müssen.
<br><br>


**4. Wie sieht die Syntax bei der Instanziierung eines Generics aus?**

`Klasse<Typ> objekt = new Klasse<Typ>();`

**5. Was passiert bei der Übersetzung einer Generics-Instanziierung?**

Bei der Übersetzung einer Generics-Instanziierung führt der Java-Compiler einen Prozess namens **Type Erasure** durch. Dieser Prozess ist der Schlüssel zur Abwärtskompatibilität von Java Generics.


#### Was ist Type Erasure?

Type Erasure bedeutet, dass der Compiler alle generischen Typinformationen (`<String>`, `<Integer>`) aus dem Code entfernt, nachdem er die Typsicherheit überprüft hat.

1.  **Typ-Überprüfung zur Kompilierungszeit**: Bevor der Code übersetzt wird, prüft der Compiler, ob die Typen korrekt verwendet werden. Zum Beispiel stellt er sicher, dass man in eine `List<String>` keine `Integer`s einfügen kann. Dadurch werden Laufzeitfehler (`ClassCastException`) verhindert.
2.  **Entfernung der generischen Informationen**: Nach dieser Überprüfung werden alle generischen Typen entfernt. Der Compiler ersetzt die generischen Typen durch ihre **oberen Grenzen**. Wenn kein Typ gebunden ist (z. B. `<T>`), wird er durch **`Object`** ersetzt. Wenn ein Typ begrenzt ist (z. B. `<T extends Number>`), wird er durch die angegebene obere Grenze (in diesem Fall `Number`) ersetzt.
3.  **Hinzufügen von Type-Casts**: Um die Typsicherheit aufrechtzuerhalten, fügt der Compiler an den entsprechenden Stellen, wo Objekte aus einer Collection geholt werden, automatische **Type-Casts** ein.

#### Beispiel: Vor und nach der Übersetzung

**Java-Quellcode:**

```java
List<String> namen = new ArrayList<>();
namen.add("Max");
String name = namen.get(0);
```

**Bytecode (nach Type Erasure):**

```java
List namen = new ArrayList();
namen.add("Max");
String name = (String)namen.get(0);
```

Für die JVM existieren Generics also nicht. Die JVM kennt nur die "rohen" Typen wie `List` und `Object`. Dies stellt sicher, dass generischer Code mit älteren Java-Versionen ohne Generics kompatibel ist.
<br><br>

**6. Wie können Typvariablen eingeschränkt werden?**

Mit Typebounds
– ... wird die Belegung einer Typvariablen eingeschränkt
– ... kann man sicher sein kann, dass der Typparameter auch die passenden Methoden für die interne Verwaltung anbietet


**7. Was versteht man unter einer Wildcard? -- 8. Wofür verendet man eine Wildcard?**

- Eine **Wildcard** `<?>` in Java ist ein Platzhalter für einen unbekannten Typ in generischen Typ-Parametern. Sie ermöglicht es Ihnen, flexiblen Code zu schreiben, der mit einer breiteren Palette von verwandten Typen arbeiten kann, ohne die Typsicherheit zu verlieren.

- Verwendungszweck von Wildcards
    - Wildcards sind entscheidend für die Lösung eines Problems, das bei der Vererbung von generischen Typen auftritt. Da `List<String>` nicht als Untertyp von `List<Object>` gilt, würde man ohne Wildcards für jeden spezifischen Typ separate Methoden schreiben müssen.

- Wildcards ermöglichen es, Methoden und Klassen so zu entwerfen, dass sie mit unterschiedlichen generischen Instanzen interagieren können.


**9. Was muss man bei der Varianz von Wildcard-Typen beachten?**

Generische Typen und Vererbung in Java können komplex sein, da sie sich nicht immer so verhalten, wie man es von der normalen Vererbung gewohnt ist. Die wichtigste Regel lautet: **Vererbung bei generischen Typen gilt nicht für die Typ-Parameter selbst.**

-----

### Was Sie wissen müssen

#### 1\. Keine Vererbung von Typ-Parametern

Wenn Sie eine Klasse `Klasse<T>` haben und `Klasse<String>` instanziieren, ist `Klasse<String>` **keine Unterklasse** von `Klasse<Object>`, obwohl `String` eine Unterklasse von `Object` ist. Dies würde die Typsicherheit untergraben und ist daher nicht erlaubt.

```java
// Dies ist NICHT möglich und führt zu einem Compiler-Fehler!
ArrayList<Object> objList = new ArrayList<String>(); 
```

-----

#### 2\. Wildcards als Lösung 🃏

Um mit der Inkompatibilität umzugehen, verwendet man **Wildcards (`?`)**. Sie ermöglichen es, die Typparameter so zu definieren, dass sie eine gewisse Flexibilität haben.

  * **Oberbegrenzte Wildcard (`? extends T`)**:

      * Diese Wildcard definiert eine Obergrenze. Sie erlaubt eine Liste von `T` oder jeder Unterklasse von `T`. Sie können Elemente **lesen**, aber nicht **schreiben**. Dies wird auch als **kovariantes** Verhalten bezeichnet.

    <!-- end list -->

    ```java
    // Erlaubt eine Liste von 'Number' oder jeder Unterklasse (z.B. Integer, Double)
    List<? extends Number> liste = new ArrayList<Integer>(); 
    ```

  * **Unterbegrenzte Wildcard (`? super T`)**:

      * Diese Wildcard definiert eine Untergrenze. Sie erlaubt eine Liste von `T` oder jeder Oberklasse von `T`. Sie können Elemente **schreiben**, aber nicht **lesen**. Dies wird auch als **kontravariantes** Verhalten bezeichnet.

    <!-- end list -->

    ```java
    // Erlaubt eine Liste von 'Integer' oder jeder Oberklasse (z.B. Number, Object)
    List<? super Integer> liste = new ArrayList<Number>(); 
    ```

Eine gute Eselsbrücke ist das **PECS-Prinzip (Producer Extends, Consumer Super)**. Wenn Sie Daten aus einer Collection **entnehmen (produzieren)**, verwenden Sie `extends`. Wenn Sie Daten in eine Collection **einfügen (konsumieren)**, verwenden Sie `super`.

Klar, hier eine genauere Erklärung zum Lesen und Schreiben bei generischen Typen.

-----

### Was bedeutet "Lesen" und "Schreiben"?

In diesem Kontext:

  * **Lesen** ➡️ bedeutet, ein Element aus einer generischen Collection zu holen. Zum Beispiel `liste.get(0)`.
  * **Schreiben** ➡️ bedeutet, ein Element in eine generische Collection einzufügen. Zum Beispiel `liste.add("wert")`.

-----

### Beispiel: Oberbegrenzte Wildcard (`? extends T`)

**`? extends Number`**: Diese Wildcard sagt, dass die Liste Objekte vom Typ `Number` oder einer seiner **Unterklassen** (z.B. `Integer`, `Double`) enthalten darf.

#### Lesen (Erlaubt) ✅

Sie können Elemente aus der Liste **lesen**, da Sie wissen, dass jedes Element mindestens ein `Number`-Objekt sein wird.

```java
List<? extends Number> liste = new ArrayList<Integer>();
Number n = liste.get(0); // OK, Sie wissen, dass es sich um eine Number handelt
```

#### Schreiben (Nicht erlaubt) ❌

Sie können **keine** Elemente in die Liste schreiben, weil der Compiler nicht weiß, welcher genaue Typ in der Liste ist.

```java
// Das ist NICHT möglich und führt zu einem Compiler-Fehler!
List<? extends Number> liste = new ArrayList<Integer>();
liste.add(2.5); // Falsch: Sie könnten versuchen, einen Double in eine Liste von Integers zu schreiben
```

-----

### Beispiel: Unterbegrenzte Wildcard (`? super T`)

**`? super Integer`**: Diese Wildcard sagt, dass die Liste Objekte vom Typ `Integer` oder einer seiner **Oberklassen** (z.B. `Number`, `Object`) enthalten darf.

#### Schreiben (Erlaubt) ✅

Sie können Elemente vom Typ `Integer` (oder einer seiner Unterklassen) in die Liste **schreiben**. Der Compiler weiß, dass jeder Container in dieser Liste groß genug ist, um einen `Integer` aufzunehmen.

```java
List<? super Integer> liste = new ArrayList<Number>();
liste.add(10); // OK, ein Integer passt in eine Liste von Numbers
```

#### Lesen (Nicht erlaubt) ❌

Sie können **keine** Elemente aus der Liste **lesen** (außer als `Object`), da Sie nicht wissen, um welche Oberklasse es sich handelt. Es könnte eine Liste von `Number` oder `Object` sein, aber Sie können nicht sicher sein.

```java
// Dies ist NICHT möglich und führt zu einem Compiler-Fehler!
List<? super Integer> liste = new ArrayList<Number>();
Integer i = liste.get(0); // Falsch: könnte eine Number sein, die kein Integer ist
```

Zusammenfassend: Die Regeln für das Lesen und Schreiben sind dazu da, die **Typsicherheit** zu gewährleisten.

Ja, die von Ihnen in der Vorlesung verwendeten Begriffe sind korrekt. In der Java-Welt werden diese Konzepte oft so vereinfacht dargestellt.

-----

### C\<T\> als Invarianz 🔒

  * **Bedeutung:** Eine generische Klasse wie `C<T>` ist standardmäßig **invariant**. Das bedeutet, dass die Vererbung zwischen den Typen nicht auf die generische Klasse übertragen wird.
  * **Grund:** `ArrayList<String>` und `ArrayList<Object>` sind zwei völlig unterschiedliche, inkompatible Typen. Sie können die eine nicht der anderen zuweisen, auch wenn `String` eine Unterklasse von `Object` ist. Dies ist der Standard in Java, um die Typsicherheit zu garantieren.

### C\<?\> als Bivarianz ↕️

  * **Bedeutung:** `C<?>`, auch als "unbounded wildcard" (unbegrenzter Joker) bekannt, verhält sich wie ein **bivariater Typ**. Das bedeutet, dass `C<?>` sowohl zu `C<String>` als auch zu `C<Number>` kompatibel ist.
  * **Einschränkung:** Obwohl Sie eine `List<String>` einer `List<?>` zuweisen können, sind die Operationen auf dieser Liste stark eingeschränkt. Sie können keine Elemente hinzufügen (schreiben), da der Compiler den genauen Typ nicht kennt. Sie können Elemente nur als `Object` lesen.
  * **Verwendung:** Die `?` Wildcard wird verwendet, wenn Sie einen generischen Typ als Parameter übergeben, dessen exakte Typinformation für die Operation irrelevant ist. Zum Beispiel, um eine Methode zu erstellen, die die Größe jeder Art von Liste ausgibt:
    ```java
    public void printSize(List<?> liste) {
        System.out.println(liste.size());
    }
    ```
    Diese Methode funktioniert mit `List<String>`, `List<Integer>` usw. Sie ist flexibel und dennoch typsicher, weil der Compiler nur das zulässt, was für alle möglichen Typen funktioniert (in diesem Fall das Abrufen der Größe).