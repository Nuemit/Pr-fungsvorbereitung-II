public class enum_tut {
    public static void main (String Args[]) { 
        // Einzelner Auszug
        // System.out.println(day.MON.guterTag);
        
        // Kompletter Auzug von dem Kompletten Enum als Array
        for (day tage: day.values()) {
            //System.out.println(tage);
            //System.out.println(tage.guterTag);

            System.out.println(tage + ": " + tage.guterTag);
        }
    }
}
