public class customException_tut {

    public static void main(String[] args) throws AgeLessThenZeroException {
        validateAge(-1);
    }

    private static void validateAge (int age) throws AgeLessThenZeroException {
        if (age < 0) {
            throw new AgeLessThenZeroException("Oh no Something went wrong.");
        }
    }
}