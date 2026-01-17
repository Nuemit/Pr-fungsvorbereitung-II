public enum Stimmung {
    gut (1),
    schlecht (0),
    mittelmaeßig (-1);

    final int wert;
    Stimmung (int wert) {
        this.wert = wert;
    }
}
