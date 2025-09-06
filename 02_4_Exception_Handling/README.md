# Exception Handling
Wenn programme nicht auf Ausnahmesituationen reagieren können, so führt das zu einem Programmabsturz. Behandlung von Ausnahmen mit den Sprachkonstrukten (z.B. `if`) für den Normalfall haben sich ***nicht*** bewährt. Daher wurde in Java eine zu `C++` ähnliche Behandlungsmöglichkeit von Ausnahmen eingebaut, das sogenannte ***Exception Handling***

Die Vorteile von Exception Handling sind unter anderem:
- Die Ausnahmebehandlung ist an einer speziellen Stelle des Codes zusammengefasst und nicht über den gesamten Code verstreut.
- Man Programmiert immer erst den Normalfall (*Happy Path*) und dann die Ausnahmesituation. Auch wenn es hierführ (z.B. bei der Methode `equals()`) ausnahmen gibt.


## Themen
1. Begriffe
1. Throwable
1. Error
1. Exception
1. Anweisungen
1. Ausnahmen Deklarieren
1. Ausnahmen Signalisieren
1. Ausnahmen Erzeugen
1. Checked und Unchecked Exceptions

## Begriffe
|Begriff|Erklärung|
|:-------|:--------|
|Exception|Signal, das meldet, dass irgendeine Ausnahmebedingung aufgetreten ist.|
|`throws`|Wird im Methodenkopf verwendet, um zu deklarieren, dass eine Methode eine oder mehrere geprüfte Ausnahmen auslösen kann. Dies delegiert die Verantwortung für die Behandlung der Ausnahme an den aufrufenden Code.|
|`throw`|Wird verwendet, um eine Ausnahme explizit auszulösen (zu "werfen"). Du verwendest es, um ein neues Exception-Objekt zu erstellen und es in die Aufrufkette zu werfen.|
|catch|behandeln der ausnahme, d.h. alle Aktionen durchzuführen, die notwendig sind, um einen normalen Zustand wiederherzustellen.|
|Error|Repräsentiert schwerwiegende, nicht behebbare Probleme, (z.B. `OutOfMemoryError`, `StackOverflowError`).|
|Checked Exception| Ausnahmen, die der Compiler dazu zwingt, sie zu Behandeln. Sie treten bei Bedingungen auf, die außerhalb der Kontrolle des Programms liegen (z.B. Dateisystemfehler). Wenn eine Methode eine geprüfte Ausnahme auslösen kann, muss sie diese entweder im Methodenkopf deklariert weren (mittels `throws`) oder sie muss in einem `try-catch` Block behandelt werden.|
|Unchecked Exception| Ausnahmen, die der Compiler nicht zur Behandlung zwingt. Sie repräsentieren in der Regel Programmierfehler, wie z.B. ungültige Argumente oder logische Fehler. Ungeprüfte Ausnahmen gehören zu `java.lang.RuntimeException` und ihren Unterklassen.|
|`try-catch-finally`||
|`try`| Der Codeblock, der eine Ausnahme auslösen könnte.|
|`catch`| Der Codeblock, der ausgeführt wird, wenn eine Ausnahme im `try` Block auftritt. Er fängt spezifische Ausnahmen ab und ermöglicht es, darauf zu reagieren. Man kann mehrere `catch` Blöcke haben, um verschiedene Ausnahmen zu behandeln.|
|`finally`| Ein Optionaler Codeblock, der immer ausgeführt wird. Egal ob eine Ausnahme auftritt oder nicht. Er wird häufig verwendet, um Ressourcen freizugeben|

***Beispiel: `throws-throw`***
```java
// `throws`: Methode deklariert, dass sie eine Ausnahme auslösen kann
public void checkAlter(int alter) throws IllegalArgumentException {
    // `throw`: wirft eine neue Ausnahme, wenn die Bedingung nicht erfüllt ist
    if (alter < 0) {
        throw new IllegalArgumentException("Alter kann nicht negativ sein.");
    }
}
```

***Beispiel: `try-catch`*** 
```java
try {
    // code der eine Exception auslösen könnte
    int result = 10 / 0; // ArithmeticException wird geworfen.
} catch (ArithmeticException e) {
    // Exception Behandlung: gibt eine Meldung aus
    System.out.println("Eine Ausnahme ist aufgetreten: " + e.getMessage());
} catch (Exception e) {
    // Unbekannte Ausnahme:
    e.printStackTrace();
} finally {
    System.out.println("Programm wird fortgesetzt");
}
```

***Beispiel: `try-with-rescources`***
```java
try (Scanner scanner = new Scanner(System.in)) {
    String input = scanner.nextLine();
    System.out.println("Eingabe: " + input);
} catch (Exception e) {
    e.printStackTrace();
}
// Der Scanner wird hier automatisch geschlossen
```

***Beispiel: Eigene Exceptions schreiben***
```java
public class UnzureichendesGuthabenException extends Exception {
    public UnzureichendesGuthabenException(String message) {
        super(message);
    }
}
```

## Throwable
**Klasse:** `java.lang.Throwable`<br>
Eine Exception ist bei Java ein Objekt, einer Unteklasse von `java.lang.Throwable`. <br>
Ein Objekt der Klasse `Throwable` enthält in seiner Definition eine `String`-Nachricht. Diese Variable wird von allen `Exception` Klassen geerbt. Es wird verwendet um eine für Menschen lesbare Fehlermeldung aufzunehmen.<br>
Die Fehlermeldung die mitgegeben wird, wird beim Erzeugen eines `Exception`-Objekts gesetztt. Die Meldung kann mit der Methode `getMessage()` ausgelesen werden. Die meisten Exceptions der API enthalten nur diese eine Meldung. Manche enthalten aber auch andere Daten.

### Unterklassen
**Klasse:** `java.lang.Error` *Unchecked-Exceptions*<br>
Die Exceptions der Klasse `Error` weisen üblicherweise auf Bindeprobleme beim dynamischen Laden oder auf Probleme der Virtuellen Maschine hin. Häufig sind sie nicht zu beheben. Es wird nicht erwartet, dass diese Exceptions abgefangen werden.<br>
Häufige Errors:
- `ThreadDeath`
- `LinkageError`
- `VirtualMachineError`
- `RuntimeException`
<br>

**Klasse:** `java.lang.Exception` *Checked-Exceptions*<br>
Diese Exceptions sind häufig zu beheben. Daher müssen die meisten Unterklassen von Exception abgefangen werden. In den Vorlesungen wird erklärt, dass wir nur im Allgemeinen von diesen Exceptions sprechen werden.

## Error

## Exception
### Exceptions Propagieren
Exceptions werden durch die "Blockstruktur" hochpropagiert ("hochgegeben") und laufen dann den Methodenaufruf-Stack hoch.
- Wird eine Exception nicht durch den Codeblock abgefangen, die die Exception erzeuigt hat, wird sie an den nächst höheren Codeblock propagiert. (Also wenn der Code, in einer Methode ist, wird die Exception an die Methode gegeben, dann an die Methode die sie aufruft, dann an die Klasse, usw.. <br> ist der Code in einer tieferen struktur (z.B. schleife) wird sie an den schleifenkopf übergeben, dann an die Methode...)
- Wird sie nirgendwo in der Methode abgefangen geht die Propagation an die aufrunde Methode über, wo sie erneut durch die gesamte Blockstruktur propagiert wird.
- Wird die Exception überhaupt nicht abgefangen, wird sie irgendwann in der Main Methode ankommen, welches den Java-Interpreter zum Abbruch bringt, die ausgabe ist eine Fehlermeldung sowie ein `StackTrace`.
- Dies gilt für Exceptions die nicht abgefangen werden müssen. Das wirkt sich natürlich auf den angegebenen Pfad der entsprechenden Fehlermeldung aus.

**Bemerkung**
Das Wichtigste ist: Jede nicht behandelte Ausnahme wandert den Aufruf-Stack hoch, bis sie gefangen wird oder das Programm abstürzt. Das gilt vor allem für die ungeprüften Ausnahmen (RuntimeExceptions), die du nicht explizit fangen musst, aber solltest, um Abstürze zu vermeiden.

**Notiz:**
Das war die Erklärung aus den Folien, wenn wir das mal verbildlichen sieht die Geschichte ungefähr so aus:
1. Jede Methode, die du in deinem Code aufrufst, ist wie ein kleiner Eimer, der auf einen größeren Eimer gestellt wird, der wiederum auf einen noch größeren Eimer gestellt wird. Das ist der sogenannte Methodenaufruf-Stack (oder "Call Stack"). Die `Main` Methode ist dabei der größte Eimer ganz unten.
1. Jetzt entsteht in einem der kleinen Eimer ganz oben eine Ausnahme ("loch"), nun passiert folgendes:
   1. Das Loch entsteht: In deinem Code gibt es eine Anweisung, die eine Ausnahme auslöst. wenn du diese Ausnahme nicht **Sofort in der Methode in der sie entstanden ist, mit einem `try-catch` fängst**, fängt der Eimer an zu lecken.
   1. Wasser Tropft nach unten: der kleine Eimer kann das Problem nicht beheben, also wird die Ausnahme "hochpropagiert", an den nächst größeren Eimer darunter. Das ist die Methode die den kleinen Eimer aufgerufen hat.
   1. Die Kette der Eimer: Dieser Prozess wiederholt sich. Tropft das Wasser von der zweiten Methoden weiter, geht es zur dritten, dann zur vierten usw. bis es schließlich den Größten Eimer, die `Main` Methode, erreicht.

## Anweisungen
**Grundkonzept der Behandlung von Ausnahmen** erfolgt in Java nach dem Schema:
* Ausprobieren - `try`
* Auffangen - `catch`
* Seiteneffekte beseitigen - `finally`

Die Schreibweise sieht folgendermaßen aus:
**Standardmäßig** 
```java
try { //folge von Anweisungen

} catch (xException e) { // optionale Reaktion

} catch (xyException e) { // optionale Reaktion

} finally { // optionale abschließende Maßnahmen

}
```
**Multicatch**
```java
try { //folge von Anweisungen

} catch (xException | yException e) { // optionale Reaktion

} finally { // optionale abschließende Maßnahmen

}
```

### `try`
- Die `try` Klausel stellt den Codeblock bereit in dem eine Exception auftreten kann
- Die `try` Klauses selbst macht nichts, außer dass sie bei Exceptions eine ggf. vorhandene `catch`-Klausel aktiviert.
- Ein `try`-Block kann nicht für sich alleine stehen. Es muss entweder ein `catch`- Block oder ein `finally`-Block folgen
- Es darf kein anderer Code zwischen dem `try`-Block und seinem `catch`-Block oder seinem `finally`-Block stehen.
### `catch`
- Auf einen `try` Block können keine, eine oder mehrere `catch` Klauseln folgen.
- Jede `catch` Klausel hat ein Argument, ähnlich wie bei Methodenargumenten. Dieses Argument muss vom Typ `Throwable` bzw. einer ***Unterklasse*** sein. Das Argument ist nur innerhalb dieses `catch`-Block gültig.
- Tritt eine Exception ein, wird die erste `catch`Klausel ausgeführt die ein Argument des entsprechendnen Typs hat.
- Der Code innerhalb des `catch` Blocks soll alle Arbeiten erledigen die notwendig sind, um die Ausnahmebedingungen zu beheben.
### `finally`
- Die `finally` Klausel wird generell eingesetzt, um nach der `try-catch` Klausel aufzuräumen
- Die `finally` Klausel wird garantiert durchgeführt.
- Im **Normalfall**, wird der `try`-Block bis zum Ende abgearbeitet udn dann mit dem `finally` Block weitergemacht.
- Ist Optional.

## Ausnahmen Deklarieren

## Ausnahmen Signalisieren

## Ausnahmen Erzeugen

## Checked und Unchecked Exceptions

# Fragen aus der Vorlesung
## Wozu ist allgemein Exception Handling gut?
<details>
    <summary>Antwort</summary>

</details>

## Wozu dienen throw und throws?
<details>
    <summary>Antwort</summary>

</details>

## Wozu dienen try, catch finally?
<details>
    <summary>Antwort</summary>

</details>

## Wann sollte man eine Exception abfangen und wann weiterpropagieren?• Wie können eigene Exceptions (sowohl checked als auch unchecked)definiert werden?
<details>
    <summary>Antwort</summary>

</details>

## Wie können eigene Exceptions ausgelöst werden?
<details>
    <summary>Antwort</summary>

</details>

## Was ist der Unterschied zwischen checked und unchecked Exceptions?• Wann sollte man eine checked Exception einsetzen und wann eineunchecked Exception?
<details>
    <summary>Antwort</summary>

</details>
