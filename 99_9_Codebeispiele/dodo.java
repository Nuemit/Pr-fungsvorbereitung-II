public class dodo extends tiere {
    @Override
    public void gibLaut() {
        System.out.println("Ton.");
    }
    @Override
    public void bewegen() {
        System.out.println("Ein Schritt nach vorne.");
    }
    @Override
    public void fressen() {
        System.out.println("Dodo isst.");
    }

    public static void main(String[] args) {
        dodo peter = new dodo();

        peter.gibLaut();
        peter.bewegen();
        peter.fressen();
    }
}
