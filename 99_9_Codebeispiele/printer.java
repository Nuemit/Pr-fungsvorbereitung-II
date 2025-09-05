public class printer <T> {
    T thingToPrint;

    public printer (T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print () {
        System.out.println(thingToPrint);
    }
}