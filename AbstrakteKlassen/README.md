# Abstrakte Klassen

## Was ist abstract
- Das Schlüsselwort `abstract` ist ein Modifikator für Klassen und Methoden, genauer gesagt ein **Nicht-Zugriffsmodifikator**.

- `abstract` macht aus einer [**concrete Class** - "normale" Klasse] &rarr; eine [**abstract Class** - abstrakte Klasse].


## Abstrakte Klasse

Eine Klasse, die mit dem Schlüsselwort abstract deklariert wird:

- Sie kann **nicht** initialisiert werden und dient daher als Bauplan für andere Klassen.

- Sie kann `abstracte` und `concrete` Methoden beinhalten
    
    - `abstracte` Methode:
        - Besitzt keine Implementierung (Methoden-Inhalt) &rarr; werden nicht befüllt und besitzen kein `{}`.
        - Muss von Unterklassen implementiert werden.

    - `concrete`Methoden:
        - Werden normal vererbt.
        
```Java
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




