package Polymorphie.src;

public class BeispielEins{
    public static void main(String[] args) {
        Tier bengalkatze = new Katze();
        Tier schäferhund = new Hund();
        Tier zwergzebu = new Kuh();

        bengalkatze.lautGeben();
        schäferhund.lautGeben();
        zwergzebu.lautGeben();
    }
}

class Tier{
    public void lautGeben(){
        System.out.println("lautGeben");
    }
}

class Katze extends Tier{
    @Override
    public void lautGeben(){
        System.out.println("Miau");
    }
}

class Hund extends Tier{
    @Override
    public void lautGeben(){
        System.out.println("Wuff");
    }
}

class Kuh extends Tier{
    @Override
    public void lautGeben(){
        System.out.println("Muuh");
    }
}