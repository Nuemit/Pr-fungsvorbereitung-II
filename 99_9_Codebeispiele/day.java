public enum day {
    MON(false, "Montag"),
    DIE(false,"Dienstag"),
    MIT(false,"Bergfest"),
    DON(false,"Fieze_Freitag"),
    FRE(true,"Freitag"),
    SAM(true,"Wochenende"),
    SON(true,"Sonntag");

    final String spitzname;
    final boolean guterTag;
    

    day (boolean guterTag, String spitzname) {
        this.guterTag = guterTag;
        this.spitzname = spitzname;
    }


}