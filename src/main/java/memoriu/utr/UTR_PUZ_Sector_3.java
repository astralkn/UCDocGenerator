package memoriu.utr;

public enum UTR_PUZ_Sector_3 implements UTR{
    M2("M2","subzona mixtă cu clădiri având regim de construire continuu sau " +
            "discontinuu şi înălţimi maxime de P+14 niveluri" +
            "cu accente înalte;",70,3.5f,
            "Parter + 14 Etaje"),
    M3("M3","SUBZONA MIXTA SITUATA IN AFARA LIMITELOR ZONEI PROTEJATE, " +
            "cu cladiri avand regim de construire continuu sau discontinuu si inaltimi " +
            "maxime de P+4;",60,2.5f,
            "Parter + 4 Etaje"),
    ;

    private String name;
    private String denumire;
    private int POT;
    private float CUT;
    private String regimInaltime;
    UTR_PUZ_Sector_3(String name, String denumire, int POT, float CUT,
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
        return "Plan urbanistic zonal coordonator Sector 3";
    }

    @Override
    public String getName() {
        return name;
    }


    public static UTR getUTRbyName(String name) {
        for (UTR r: UTR_PUZ_Sector_3.values()
        ) {
            if (r.getName().equals(name)){
                return r;
            }
        }

        return null;
    }
}