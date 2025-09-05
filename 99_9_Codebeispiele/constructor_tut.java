public class constructor_tut {
    public static void main(String[] args) {
        
        Dog myDog = new Dog();
        Dog yourDog = new Dog(3);

        System.out.println(myDog.getNumberOfLegs());
        System.out.println(yourDog.getNumberOfLegs());
    }

}
