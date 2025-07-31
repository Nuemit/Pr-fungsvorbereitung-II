package Modellierung.vorlesungsbeispiele;

public class Dog extends Animal{

    public boolean aufKatzenJagd = false;

    public Dog(String name) {
        this.setName(name);
        this.setFoodstate(Hungerstatus.SATT);
        this.setHealthystate(Gesundheit.GESUND);
    }

    public void setAufKatzenJagd(boolean jagdstatus) {
        this.aufKatzenJagd = jagdstatus;
    }

    public boolean istJagend() {
        return this.aufKatzenJagd;
    }


}