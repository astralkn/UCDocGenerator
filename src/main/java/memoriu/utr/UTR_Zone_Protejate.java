package memoriu.utr;

public enum UTR_Zone_Protejate implements UTR {
    ZP1("ZP1","Zona protejat Zona protejat nr. 01- strada traditional " +
            "comercial Calea Mosilor subzona Cp1c",80,2.5f,
            "- maximum 13 m, minimum 10 m."),
    ZP61("ZP61","Zona protejat Zona protejat nr. 61- parcelarea Maior Coravu," +
            " subzona L2b",40,1.8f,
            "- maximum 10 m, minimum 7 m."),
    ;

    private String name;
    private String denumire;
    private int POT;
    private float CUT;
    private String regimInaltime;

    UTR_Zone_Protejate(String name, String denumire, int POT, float CUT,
                       String regimInaltime) {
        this.name = name;
        this.denumire = denumire;
        this.POT = POT;
        this.CUT = CUT;
        this.regimInaltime = regimInaltime;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getPOT() {
        return POT;
    }

    public float getCUT() {
        return CUT;
    }

    public String getRegimInaltime() {
        return regimInaltime;
    }

    public String getDocumentation() {
        return "PUZ zona protejata";
    }

    @Override
    public String getName() {
        return name;
    }
}