# Abstrakte Klassen

## Was ist abstract
- Das Schlüsselwort `abstract` ist ein Modifikator für Klassen und Methoden, genauer geasagt ein **Nicht-Zugriffsmodifikator**.

- `abstract` macht aus einer [**concrete Class** - "nomrale" Klasse] &rarr; eine [**abstract Class** - abstrakte Klasse].


## Abstrakte Klasse

Eine Klasse, die mit dem Schlüsselwort abstract deklariert wird:

- Sie kann **nicht** initialisiert werden und dient daher als Bauplan für andere Klassen.

- Sie kann `abstracte` und `concrete` Methoden beinhalten
    - Abstracte Methoden müssen bei Subklassen implementiert werden.
    - Normale (konkrete) Methoden besitzen einen vollständigen Methodenrumpf (Implementierung). Wenn eine Klasse diese Methoden an eine Unterklasse vererbt, kann diese die Methode nutzen, wie sie ist, oder sie überschreiben, um ihr Verhalten anzupassen.

- `abstracte` Methode:
    - Besitzt keine Implementierung (Methoden-Inhalt) &rarr; werden nicht befüllt und besitzen auch keine `{}`.
    - Muss von Unerklassen implementiert werden.
    - 


