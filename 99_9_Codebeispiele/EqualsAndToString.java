public class EqualsAndToString {
    public static void main(String[] args) {
        
        Dog myDog = new Dog();
        myDog.setName("Barthi");
        myDog.setAge(10);
        myDog.setBreed("Braque");
        myDog.setColor("Black");
        myDog.setNumberOfLegs(4);
        
        Dog yourDog = new Dog();
        yourDog.setName("Brutus");

        if (myDog.equals(yourDog)) {
            System.out.println("The Dogs are equal");
        } else {
            System.out.println("There not equal");
        }
        System.out.println(myDog.hashCode());
    }
}
