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


### Vererbung in Java



### Vererbung bei der Modellierung
