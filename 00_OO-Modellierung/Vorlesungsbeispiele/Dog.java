public class Dog {
    
    private String name;

    public Dog() {
        this(null);
    }

    public Dog(String name) {
        this.setName(name);
    }
    
    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Utillity
    public void bark() {
        System.out.println("Wuff");
    }

    public void eat() {
        System.out.println("Mampf Mampf");
    }

    public void chaseCat() {
        System.out.println("HUIIIII");
    }
}