package Modellierung.vorlesungsbeispiele;

public abstract class Animal {
    
    public enum Hungerstatus {SATT, HUNGRIG, APPETIT, FRESSEND}
    public enum Gesundheit {GESUND, KRANK, TOD}
    
    private String name;
    private Hungerstatus foodstate;
    private Gesundheit healthystate;

    public void setHealthystate(Gesundheit healthystate) {
        this.healthystate = healthystate;
    }

    public void setFoodstate(Hungerstatus status) {
        this.foodstate = status;
    }

    public void printFoodstate() {
        System.out.println(this.foodstate.toString());
    }

    public void printHealthstate() {
        System.out.println(this.healthystate.toString());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}