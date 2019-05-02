package memoriu.property;

public class PropertyAct {

    private String type;
    private String numberAndIssueDate;
    private String issuer;

    public PropertyAct(String type, String numberAndIssueDate, String issuer) {
        this.type = type;
        this.numberAndIssueDate = numberAndIssueDate;
        this.issuer = issuer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberAndIssueDate() {
        return numberAndIssueDate;
    }

    public void setNumberAndIssueDate(String numberAndIssueDate) {
        this.numberAndIssueDate = numberAndIssueDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
