public class TestMonate {
    public static void main(String[] args) {
        System.out.println(Monate.januar);


        for (Monate monat : Monate.values()) {
            StringBuffer sb = new StringBuffer();
            sb.append("Der Monat heißt: ").append(monat).append(" ");
            sb.append("Die Zahl dazu ist: ").append(monat.zahl);
            System.out.println(sb.toString());
        }   
    }
}
