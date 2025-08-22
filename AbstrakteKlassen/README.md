# Abstrakte Klassen

## Was ist abstract
- Das Schlüsselwort `abstract` ist ein Modifikator für Klassen und Methoden, genauer gesagt ein **Nicht-Zugriffsmodifikator**.



## Abstrakte Klasse

Eine Klasse, die mit dem Schlüsselwort abstract deklariert wird:

- Sie kann **nicht** initialisiert werden und dient daher als Bauplan für andere Klassen.

- Sie kann `abstract` und `concrete` Methoden beinhalten
    
    - `abstract` Methode:
        - Besitzt keine Implementierung (Methoden-Inhalt) &rarr; werden nicht befüllt und besitzen kein `{}`.
        - Muss von Unterklassen implementiert werden.

    - `concrete`Methoden:
        - Werden normal vererbt. 

## Unterschiede zu Interfaces:

1. **Implementierung von Methoden**

- Ein Interface darf keine Implementierung für Methoden enthalten (außer default und static Methoden). Es definiert ausschließlich Methoden-Signaturen.  

- Klassen, die ein Interface implementieren, müssen jede dieser Methoden selbst implementieren.

- Eine abstrakte Klasse kann sowohl abstrakte Methoden (ohne Implementierung) als auch konkrete Methoden (mit Implementierung) enthalten.

2. **Mehrfache Vererbung**

- Ein Interface ermöglicht Mehrfachvererbung. Eine Klasse kann beliebig viele Interfaces implementieren (implements InterfaceA, InterfaceB, InterfaceC). Dies ist die Hauptmethode, um in Java Polymorphie zu erreichen, da Java keine Mehrfachvererbung von Klassen erlaubt. Eine Klasse kann nur von einer einzigen abstrakten Klasse erben.
  

## Beispiel Code
Code 1.0 zeigt die abstracte Klasse **Animal** mit einer abstracten Methode und einer normalen befüllten Methode.

```Java
//Code 1.0
public abstract class Animal {
    int age;
    String name;

    //abstracte Methode, die in Unterklassen implementiert werden müssen
    public abstract void makeNoise();
    //keine {} nach der Methode

    //konkrete Methode, die normal vererbt wird
    public void eat(){
        System.out.println("munch munch");
    };
}
```

Code 1.1 zeigt die SubClass (Unterklasse) **Cat**, die von Animal erbt.
```Java
//Code 1.1
public  class Cat extends Animal{


    @Override // <- ist nicht unbedingt notwendig aber best practice
    public void makeNoise() { //geerbte Methode wird hier implementiert
        System.out.println("meow");
    }
}
```

Code 1.2 zeigt die Main in der Cat initialisiert wird und ihre Methoden anwendet.

```Java
//Code 1.2 
public class MainAbstractClasses {
    public static void main(String[] args) {

        Cat myCat = new Cat(); 

        myCat.makeNoise(); //"meow"

        myCat.eat(); //"munch munch"

    }
}
```

## Prog Fragen

1. Was bedeutet Polymorphie?
    - siehe 
2. Was muss bei der Konvertierung von Referenzvariablen beachtet werden?
3. Können Referenzvariablen in einfache Datentypen konvertiert werden?
4. Können einfache Datentypen in Java in Referenzvariablen konvertiert werden?
5. Welche Rolle spielt die Klasse Object in Java?
6. Was ist eine abstrakte Methode?
7. Was sind die Eigenschaften von abstrakten Klassen?
8. Benötigt eine abstrakte Klasse eine abstrakte Methode und warum ist das so?




## Notizen
Ein "Nicht-Zugriffsmodifikator" in Java ist ein Schlüsselwort, das die Zugriffsebene einer Klasse, eines Feldes oder einer Methode nicht steuert, sondern andere Eigenschaften und Funktionen verleiht.

---

In der Programmierungspraxis bedeutet der Begriff "eine abstrakte Methode implementieren" immer, dass Sie zwei Dinge tun müssen:

Die Methode in der Unterklasse hinzufügen (indem Sie die gleiche Methoden-Signatur verwenden).

Den Code-Block (die Implementierung) für diese Methode schreiben.

Denken Sie an eine abstrakte Methode als ein Versprechen oder eine leere Vorlage. Die Superklasse gibt das Versprechen: "Jede Klasse, die von mir erbt, muss diese Methode haben und ihr einen Sinn geben."

Das Einlösen dieses Versprechens – also das Implementieren – umfasst den gesamten Prozess: Sie müssen die Methode in Ihre Klasse einfügen und sie mit der notwendigen Logik füllen.



