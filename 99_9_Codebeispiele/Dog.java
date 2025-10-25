import java.util.Objects;

public class Dog {
    private String name;
    private int age;
    private String breed;
    private String color;
    private int numberOfLegs;

    // Default Konstruktor / no args Konstruktor () sind leer
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Dog () {
        setNumberOfLegs(4);
    }

    // Initialisierungs Konstruktor
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Dog (int numberOfLegs) {
        setNumberOfLegs(numberOfLegs);
    } 

    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return this.name;
    }
    public void setBreed (String breed) {
        this.breed = breed;
    }
    public String getBreed () {
        return this.breed;
    }
    public void setColor (String color) {
        this.color = color;
    }
    public String getColor () {
        return this.color;
    }
    public void setNumberOfLegs (int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
    public int getNumberOfLegs () {
        return this.numberOfLegs;
    }
    public void setAge (int age) {
        this.age = age;
    }
    public int getAge () {
        return this.age;
    }
    @Override
    public String toString () {
        return "This is a " + this.age + " year old Dog." + "His name is " +this.name +".";
    }
    @Override
    public boolean equals (Object obj) {
        // 1. Checking if this passed in Object is the same as the Object, the code is currently running on.
        if (this == obj) {
            return true;
        } 
        // 2. Checking if the passed in Object is null. 
        if (obj == null) {
            return false;
        }
        // 3. Checking if the passed in Object is in the same Class as the Object, the code is currently running on. 
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        // 4. We know that the passed in Object has 1. not the same Storage ID, 2. is not NULL, 3. is in the same class. 
        // Know we check into detail if the passed in class is true equal to the 2. object.
        Dog other = (Dog) obj;

        return  Objects.equals(this.getName(),          other.getName())    && 
                Objects.equals(this.getAge(),           other.getAge())     &&
                Objects.equals(this.getBreed(),         other.getBreed())   &&
                Objects.equals(this.getColor(),         other.getColor())   &&
                Objects.equals(this.getNumberOfLegs(),  other.getNumberOfLegs());
    }
    @Override
    public int hashCode() {
        int hashCodeWert = 17;
        final int hashMulti = 59;
        hashCodeWert = hashCodeWert * hashMulti + this.getName().hashCode()
                                                + this.getAge()
                                                + this.getBreed().hashCode()
                                                + this.getColor().hashCode()
                                                + this.getNumberOfLegs();
        return hashCodeWert;
    }



}
