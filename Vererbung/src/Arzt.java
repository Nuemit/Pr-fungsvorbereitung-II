package Vererbung.src;

public abstract class Arzt {

    private boolean machtHB;

    public void patientBeraten() {
        System.out.println("berate Patient");
    }

    public void setMachtHB(boolean machthb) {
        this.machtHB = machtHB;
    }

}
