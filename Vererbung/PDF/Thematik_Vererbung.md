# PII Vererbung
### Begriffsbestimmung
Vererbung basiert auf den Folgerungen daraus, das ein Hausarzt auch ein Arzt ist. 

**Folgerung 1:** Das heißt wenn der Arzt über die **Eigenschaften (Variablen)** arbeitetImKrankenhaus, machtForschung, hatFachrichtung beschrieben werden kann, kann X auch über diese Eigenschaften beschrieben werden.

```java
// Klassenkopf kann vorerst Ignoriert werden
public class Hausarzt extends Arzt {
    // Neue Eigenschaft / Variable vom Hausarzt
    public boolean machtHausbesuche;

    // Hausarzt hat mit "this" die Eigenschaft von Arzt benutzt
    this.arbeitetImKrankenhaus;
    this.machtForschung;
    this.hatFachrichtung;
}

public class Arzt {
    // Eigenschaft / Variable die der Arzt besitzt
    public boolean arbeitetImKrankenhaus;
    public boolean machtForschung;
    public boolean hatFachrichtung;
}
```

**Folgerung 2:** Wenn Y die **Verhaltensweisen (Methoden)** patientenBehandeln(), diagnoseStellen(), medikamenteVerschreiben() aufweist. Hat auch X diese Verhaltensweisen. (Beispiele folgen)

```java
//Klassenkopf kann voerst Ignoriert werden
public class Hausarzt extends Arzt {
    // Verhaltensweise / Methode von Hausarzt
    public void patientBeraten() {} 
}

public class Arzt {
    // Verhaltensweise / Methode von Arzt
    public void patientBehandeln() {}
    public void diagnoseStellen() {}
    public void medikamentVerschreiben() {}
}

public class Vererbung {
    public static void main(String[] Args) {
        // Objekterzeugung - DrSommer ist vom Objekt Hausarzt
        Hausarzt DrSommer = new Hausarzt();

        // DrSommer benutzt die Methode die die Klasse Hausarzt besitzt
        DrSommer.patientBeraten();

        // DrSommer ist durch die Vererbung zu Arzt in der Lage die Methode von Arzt zu benutzen 
        DrSommer.patientBehandeln();
    }
}

```


**Grundlage des Prinzips der Vererbung:** Ist die Beobachtung das **ZWEI** Klassen X (Hausarzt) und Y (Arzt) beide Folgerungen und somit "Jedes X (Hausarzt) ist auch ein Y (Arzt)" ausweisen können. 

**Ober-/Unterklasse:** Ganz nach dem Satz "Jedes X (Hausarzt) ist auch ein Y (Arzt)", wird X (Hausarzt) die Variablen und Methoden von Y (Arzt) besitzen. Somit ist X (Hausarzt) eine **Unterklasse** und da Y (Arzt) die Variablen und Methoden weitergibt, die **Oberklasse** in dieser Konstellation.


**Einfach-/Mehrfachvererbung:** In Java ist es über den oben gezeigten Weg möglich zwischen zwei Klassen **einfach** zu vererben. Mehrfachvererbung ist über diesen Weg **nicht** möglich.

Vererbung ist nicht auf zwei Klassen begrenzt. Theoretisch ist auch eine Vererbungskette wie folgend aussehen: Arzt <- Hausarzt <- NotdienstHausarzt 

### Vererbung in Java
#### Definition
**Klassenkopf**
Der Klassenkopf gibt an, von wo man eine Klasse benutzen darf, den Namen der Klasse und ob die Klasse von anderen Klassen erbt und die Klasse vorgegebene Schnittstellen erfüllt. 

Beispiele für Klassen wären:
```java
// Klasse ist von außerhalb möglich
public class Arzt {}
public class Hausarzt extends Arzt {}

// Klassen können auch den Klassenkopf private oder protected haben

// Klasse ist von außerhalb nicht sichtbar
private class Arzt {}
// Klasse ist von außeralb nicht sichtbar
protected class Hausarzt {} 
```

Der Begriff **extends** wird im Klassenkopf verwendet um die Klasse anzugeben, von welcher die Eigenschaften (Variablen) und Methoden geerbt werden. (Wie oben genannt nur von einer Klasse. **Einfachvererbung!**)

Mit extends darf:
- darf nur **eine** Klasse angegeben werden 
- die auch abstract sein kann 
- aber nicht als **final** definiert sein darf
```java
// Diese Klasse, als Beispiel, darf nicht abgleitet werden. Verantwortlich dafür ist das Final.
public final class Patient {} 
```

#### Erreichbarkeit & Sichtbarkeit

**Klassenmember (static):** 
**Definition:** Variablen und Methoden die zur Klasse selbst gehören, nicht zu einer Instanz (Object) gehören.
**Zugriff:** Findet über die Klasse selbst statt (Arzt.variable oder Arzt.methode()). 
**Instanzmember (non static):**
**Definition:** Variablen und Methoden die zu einer Instanz (Object) gehören. 
**Zugriff:** Findet über Object.variable oder Object.methode() statt.
Jede Instanz erhält eigene Werte dieser Variablen.
 



### Vererbung bei der Modellierung
