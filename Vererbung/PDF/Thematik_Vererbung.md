# PII Vererbung
### Begriffsbestimmung
Vererbung basiert auf den Folgerungen daraus, das ein Hausarzt auch ein Arzt ist. 

**Folgerung 1:** Das heißt wenn der Arzt über die **Eigenschaften (Variablen)** arbeitetImKrankenhaus, machtForschung, hatFachrichtung beschrieben werden kann, kann Hausarzt auch über diese Eigenschaften beschrieben werden.

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

**Folgerung 2:** Wenn Arzt die **Verhaltensweisen (Methoden)** patientenBehandeln(), diagnoseStellen(), medikamenteVerschreiben() aufweist. Hat auch Hausarzt diese Verhaltensweisen. (Beispiele folgen)

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

**Ober-/Unterklasse:** Ganz nach dem Satz "Jedes X (Hausarzt) ist auch ein Y (Arzt)", so wird X (Hausarzt) die Variablen und Methoden von Y (Arzt) besitzen. Somit ist X (Hausarzt) eine **Unterklasse** und da Y (Arzt) die Variablen und Methoden weitergibt, die **Oberklasse** in dieser Konstellation.


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
 

**Abgeleitete Klassen**
* Erben **keine** Klassen-Attribute und Instanz-Methoden ihrer Oberklasse. (static)
* Erben **alle** Instanz-Attribute und Instanz-Methoden ihrer Oberklasse. (non static)
* Dabei Erben abgeleitete Klassen aber auch nur die **erreichbaren** Instanz-Attribute und Instanz-Methoden ihrer Oberklasse. (static)


**public, protected, private**
Bei public und protected, sind bei der Vererbung die Attribute (Variablen) und Methoden immer zugänglich. Wenn ein private Member (Variable oder Methode) zur Verfügung stehen soll, muss dieser zu protected umdefiniert werden. Das Geheimnisprinzip hat damit keine Probleme, **trotzdem** muss Setter und Getter vorhanden sein.

Private Attribute und Methoden sind nur in der eigenen Klasse erreichbar. Nur über Setter und Getter. 


#### Verdecken & Überschreiben von Membern
Verdeckte Attribute sind Attribute einer Oberklasse, die durch die abgeleitete Klasse neu deklariert werden. 
```java 
public class Arzt {
    public static final String H = "HNO-Arzt";
    protected int alter; 
}

public class Hausarzt extends Arzt {
    public static final String H = "Hausarzt";
    protected int alter;

    public void geburtstagHaben() {
        alter++;
    }
}
```
Im Beispiel verdeckt das Klassenattribut "H" von Hausarzt das Klassenattribut von Arzt. Selbes gilt für alter. 

Attribute heißen verdeckt, da in der abgeleiteten Klasse das eigene Attribut das weiter oben (in der Oberklasse) definierte Attribut unsichtbar macht.

```java 
public class Arzt {
    public static final String H = "HNO-Arzt";
    protected int alter; 
}

public class Hausarzt extends Arzt {
    public static final String H = "Hausarzt";
    protected int alter;

    public void geburtstagHaben() {
        super.alter++;
    }
}
```
Wenn man trotzdem auf das Attribut von Arzt zugreifen möchte, macht man das mittels **super**.
**super** verweist direkt auf die Oberklasse und ist vergleichbar mit this. Auch hier gilt. Das Attribut aus der Oberklasse muss erreichbar sein. 

```java 
public class Arzt {
    public static final String H = "HNO-Arzt";
    protected int alter; 
}

public class Hausarzt extends Arzt {
    public static final String H = "Hausarzt";
    protected int alter;

    public void geburtstagHaben() {
        ((Arzt)this).alter++;
    }
}
```
Mittels Casting kann man auch auf Verdeckte Attribute zugreifen. Dafür muss man ((Klassentyp)this).Attribut verwenden. Damit kann man auch auf weiter entfernte Attribute zugreifen. 

#### Überschreiben von Instanz-Methoden
```java 
public class Arzt {
    public void patientBehandeln() {
        // behandle immer Konservativ
    }
}
public class Chirurg extends Arzt {
    public void patientBehandeln() {
        // andere Behandlungsmethode
    }
}
```
Überschriebene Methoden definieren eine geerbte Methode in der Klasse neu. Diese **müssen** den gleichen Namen, Parameter und Rückgabetyp haben. In der Sichtbarkeit darf nur vergrößert werden und nicht verringert. 

#### Typsicherheit beim Überschreiben
Invarianz, Kovarianz, Kontravarianz

Invarianz: Der Typ muss genau gleich übereinstimmen.   
```java 
class Arzt {}
class Hausarzt extends Arzt {}

public class Klinik {
    Arzt arzt; // invarianter Typ

    public void setArzt(Arzt arzt) {
        this.arzt = arzt; // nur Arzt erlaubt
    }
}

public class Main {
    public static void main(String[] args) {
        Klinik klinik = new Klinik();
        Hausarzt hausarzt = new Hausarzt();
    }
}
```
Kovarianz: Der Typ kann ein Untertyp der Oberklasse sein, solange die Unterklasse eine Klasse des Ursprünglichen Typs ist.
```java 
class Arzt {}
class Hausarzt extends Arzt {}

class Klinik {
    public Arzt getArzt() {
        return new Arzt();
    }
}

class HausarztKlinik extends Klinik {
    @Override
    public Hausarzt getArzt() { // Kovarianz: Rückgabetyp ist Untertyp
        return new Hausarzt();
    }
}
```
Kontravarianz: Der Typ kann die Oberklasse des Datentyps sein.
```java 
class Arzt {}
class Hausarzt extends Arzt {}

class Klinik {
    public Arzt getArzt() {
        return new Arzt();
    }
}

class HausarztKlinik extends Klinik {
    @Override
    public Hausarzt getArzt() { // Kovarianz: Rückgabetyp ist 
        return new Arzt();
    }
}
```

Zusammenfassung in der pptx: PII_03_Vererbung.pdf auf Seite 36.

#### Konstruktoren
In einer Unterklasse kann man den Initialisierungskonstruktor der Oberklasse aufrufen. Das passiert mittels **super()**. Dieser Aufruf muss im Initialisierungskonstruktor am anfang stehen. Das könnte z. B. so aussehen: 
```java 
public class Arzt {
    protected boolean arbeitetImKrankenhaus;

    public Arzt (boolean krankenhaus) {
        this.arbeitetImKrankenhaus = krankenhaus;
    }
}

public class Hausarzt extends Arzt {
    protected boolean machtHausbesuche; 

    public Hausarzt (boolean krankenhaus, boolean hausbesuche) {
        super(krankenhaus);
        this.machtHausbesuche = hausbesuche; 
    }
}
```

### Vererbung bei der Modellierung
Man muss durch folgende Schritte gehen: 
- 0. Modelliere Gegenstände, Lebewesen, ... als Klassen 
- 1. Finde Klassen mit gleichen Eigenschaften und Verhalten 
    - Ziel ist es eine Oberklasse zu finden
- 2. Modelliere eine Oberklasse mit diesen Eigenschaften (Attribute) und Verhalten (Methoden)
- 3. Entscheide, ob abgeleitete Klassen weitere Eigenschaften haben
    - Ergänze Unterklassen mit Eigenschaften die nicht in der Oberklasse gegeben sind
- 4. Entscheide, ob abgeleitete Klassen spezifisches Verhalten haben
    - Ergänze Unterklassen mit Verhalten die nicht in der Oberklasse gegeben ist
- 5. Finde abgeleitete Klasse mit spezifischen gleichen Eigenschaften / Verhalten  
    - Ergänze weitere Klassen in der Vererbungshierarchie 
