package memoriu.utr;

public class UTRCustom implements UTR {
    private String name;
    private String description;
    private String POT;
    private String CUT;
    private String RH;
    private String documentation;

    public UTRCustom(String name, String description, String POT, String CUT, String RH) {
        this.name = name;
        this.description = description;
        this.POT = POT;
        this.CUT = CUT;
        this.RH = RH;
    }

    @Override
    public String getDenumire() {
        return description;
    }

    @Override
    public int getPOT() {
        return Integer.parseInt(POT);
    }

    @Override
    public float getCUT() {
        return Integer.parseInt(CUT);
    }

    @Override
    public String getRegimInaltime() {
        return RH;
    }

    @Override
    public String getDocumentation() {
        return documentation;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPOT(String POT) {
        this.POT = POT;
    }

    public void setCUT(String CUT) {
        this.CUT = CUT;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}
