package memoriu.utr;

public enum UTR_PUZ_Sector_2 implements UTR {
    ;

    private String name;
    private String denumire;
    private int POT;
    private float CUT;
    private String regimInaltime;

    UTR_PUZ_Sector_2(String name, String denumire, int POT, float CUT,
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
        return null;
    }

    @Override
    public String getName() {
        return name;
    }


    public static UTR getUTRbyName(String name) {
        for (UTR r: UTR_PUZ_Sector_2.values()
        ) {
            if (r.getName().equals(name)){
                return r;
            }
        }

        return null;
    }
}
