public enum country {
    DE ("Deutschland"),
    FR ("Frankreich");

    final String name;

    country (String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
    
}
