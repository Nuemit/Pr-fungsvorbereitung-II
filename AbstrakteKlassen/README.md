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



```Java
//Code 1.2
public class MainAbstractClasses {
    public static void main(String[] args) {

        /*
        Wenn eine Class abstract ist, kann man kein Objekt daraus erzeugen
        ABER man kann SubClasses von dieser Class erstellen

        Animal myAnimal = new Animal() somit nicht

        SubClasses müssen Methoden der abstract MAinClass implementieren
         */

        //MainClass Animal ist abstract
        Cat myCat = new Cat(); //Cat extends Animal

        //erzwungene Methode der SubClass durch die abstract MainClass
        myCat.makeNoise();

        /*
        Unterschiede zu Interfaces:
        Interfaces besitzen auch abstract Methods, können aber mehrfach vererbt werden
        man nutz abstract Class, um ein Gerüst zu bauen

         */

        myCat.eat();

    }
}
```



## Notizen
Ein "Nicht-Zugriffsmodifikator" in Java ist ein Schlüsselwort, das die Zugriffsebene einer Klasse, eines Feldes oder einer Methode nicht steuert, sondern andere Eigenschaften und Funktionen verleiht.

---

In der Programmierungspraxis bedeutet der Begriff "eine abstrakte Methode implementieren" immer, dass Sie zwei Dinge tun müssen:

Die Methode in der Unterklasse hinzufügen (indem Sie die gleiche Methoden-Signatur verwenden).

Den Code-Block (die Implementierung) für diese Methode schreiben.

Denken Sie an eine abstrakte Methode als ein Versprechen oder eine leere Vorlage. Die Superklasse gibt das Versprechen: "Jede Klasse, die von mir erbt, muss diese Methode haben und ihr einen Sinn geben."

Das Einlösen dieses Versprechens – also das Implementieren – umfasst den gesamten Prozess: Sie müssen die Methode in Ihre Klasse einfügen und sie mit der notwendigen Logik füllen.



