package Modellierung.vorlesungsbeispiele;

public class Tester {

    public static void main(String[] args) {
        Dog Barky = new Dog("Barky");
        System.out.println("%s ist".formatted(Barky.getName()));
        Barky.printFoodstate();
        System.out.println("und");
        Barky.printHealthstate();
        
    }
}
