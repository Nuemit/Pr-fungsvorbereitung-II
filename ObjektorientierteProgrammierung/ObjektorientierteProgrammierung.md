# PII Objektorientierte Programmierung in der Praxis
### Grundlegende Klassen in Java
#### Objekt- und Wrapper-Klassen
- Alles was aus einer Klasse erzeugt wird, ist ein Objekt.
- Ein Objekt ist eine Instanz einer Klasse -> ein "Ding" mit Konkreten Eigenschaften (Variablen) und Verhaltensweisen (Methoden).
```java
class Arzt {
    String name; 

    Arzt (String name) {
        this.name = name;
    }

    void patientBeraten {
        System.out.println(name + " berät Patienten");
    }
}


public class main {
    public static void main (String Args[]) {
        Arzt arzt1 = new Arzt("Dr. Müller");

        arzt1.patientBeraten;
    }
}
```
Das Objekt Arzt1 mit dem Namen Dr. Müller wurde jetzt erzeugt und kann auch auf die Methoden von Arzt zugreifen.


Wrapper-Klassen sind Klassen, welche Primitive Datentypen in Objekte packen. 
Primitive Datentypen und ihre dazugehörigen Wrapperklassen sind: 
| Primitiver Datentyp       | Wrapperklasse |
|---------------------------|---------------|
| byte                      | Byte          |
| short                     | Short         |
| int                       | Int           |
| long                      | Long          |
| float                     | Float         |
| double                    | Double        |
| char                      | Char          |
| boolean                   | Boolean       |





### Packages
### Programmierhinweise