public class StringBuffer_tut {
    private String name;
    private int alter;

    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return this.name;
    }
    public void setAlter (int alter) {
        this.alter = alter;
    }
    public int getAlter () {
        return this.alter;
    }

    public StringBuffer_tut (String name, int alter) {
        setName(name);
        setAlter(alter);
    }

    public static void main(String[] args) {
        StringBuffer_tut p1 = new StringBuffer_tut("Eric", 24);

        System.out.println(p1.toString());
    }

    @Override
    public String toString () {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: ").append( name);
        sb.append(", Alter: ").append( alter);
        return sb.toString();
    }
}
