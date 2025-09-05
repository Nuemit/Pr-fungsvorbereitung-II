public class AgeLessThenZeroException extends Exception {
    // Konstruktor um Nachricht mit ausgeben zu können
    public AgeLessThenZeroException (String message) {
        super(message);
    }

    // Defaultkonstruktor 
    public AgeLessThenZeroException () {}

    // Konstruktor um Gründe mit auszugeben 
    public AgeLessThenZeroException (Throwable cause) {
        super(cause);
    }

    public AgeLessThenZeroException (String message, Throwable cause) {
        super(message, cause);
    }
}
