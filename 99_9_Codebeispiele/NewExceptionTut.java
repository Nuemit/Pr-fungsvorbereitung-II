public class NewExceptionTut {
    public static void main(String[] args) throws AgeLessThenZeroException{
        int eins = -5;
        int zwei = 4;
        rechnen(eins,zwei);
    }

    public static int rechnen (int eins, int zwei) throws AgeLessThenZeroException{
        int ergebnis = eins + zwei;
        
        if (ergebnis < 0) throw new AgeLessThenZeroException("Kann nicht Negativ sein.");
        return ergebnis;
    }


}
