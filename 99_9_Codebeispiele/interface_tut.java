import java.awt.Color;

public class interface_tut implements fahrzeug {
    public interface_tut() {

    }
    private Color autoFarbe = Color.green;

    @Override
    public void fahren () {
        System.out.println("Brum Brum");
    }
    @Override
    public void aendereFarbe (Color x) {
        this.autoFarbe = x;
    }
}
