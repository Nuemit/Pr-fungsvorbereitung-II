public class Box <T> {
    private T value;

    public Box (T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Box <String> stringBox = new Box<>("Hallo");
        String s = stringBox.getValue();

        Box <Integer> intBox = new Box<>(42);
        int i = intBox.getValue();

        System.out.println(i);
        System.out.println(s);
    }
}
