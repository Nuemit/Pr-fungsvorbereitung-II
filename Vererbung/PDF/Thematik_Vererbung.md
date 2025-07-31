# PII Vererbung
### Begriffsbestimmung
Vererbung basiert auf den Folgerungen daraus, das ein X auch ein Y ist. 

**Folgerung 1:** Das heißt wenn Y über die **Eigenschaften (Variablen)** a, b, c beschrieben werden kann, kann X auch über diese Eigenschaften beschrieben werden.

```java
// Klassenkopf kann vorerst Ignoriert werden
public class Hausarzt extends Arzt {
    // Neue Eigenschaft / Variable vom Hausarzt
    public boolean machtHausbesuche;

    // Hausarzt hat mit "this" die Eigenschaft von Arzt benutzt
    this.arbeitetImKrankenhaus;
}

public class Arzt {
    // Eigenschaft / Variable die der Arzt besitzt
    public boolean arbeitetImKrankenhaus;
}
```

**Folgerung 2:** Wenn Y die **Verhaltensweisen (Methoden)** a(), b(), c() aufweist. Hat auch X diese Verhaltensweisen. (Beispiele folgen)

```java
//Klassenkopf kann voerst Ignoriert werden
public class Hausarzt extends Arzt {
    // Verhaltensweise / Methode von Hausarzt
    public void patientBeraten() {
    //Inhalt    
    }
}

public class Arzt {
    // Verhaltensweise / Methode von Arzt
    public void patientBehandeln() {
        //Inhalt
    }
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


**Grundlage des Prinzips der Vererbung:** Ist die Beobachtung das **ZWEI** Klassen X und Y beide Folgerungen und somit "Jedes X ist auch ein Y" ausweisen können. 

**Ober-/Unterklasse:** Ganz nach dem Satz "Jedes X ist auch ein Y", wird X die Variablen und Methoden von Y besitzen. Somit ist X eine **Unterklasse** und da Y die Variablen und Methoden weitergibt, die **Oberklasse** in dieser Konstellation.


### Vererbung in Java



### Vererbung bei der Modellierung
