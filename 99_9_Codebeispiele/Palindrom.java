
public class Palindrom {
    public static void main(String[] args) {
        String s = "Anna";
        System.out.println(isPalindrom(s));    
    }

    public static boolean isPalindrom(String s) {
        String b = s.toLowerCase();

        char [] eins = b.toCharArray();
        char [] zwei = b.toCharArray(); 

        if (eins.length < 1) return false;

        for (int i = 0; i < eins.length; i++) {
            zwei[i] = eins[eins.length-1-i];
        }

        for (int j = 0; j < eins.length; j++) {
            if (eins[j] != zwei[j]) return false;
        }

        return true;
    }
}