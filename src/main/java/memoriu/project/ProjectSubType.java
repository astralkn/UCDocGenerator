package memoriu.project;

public enum ProjectSubType {
    PUD("Plan urbanistic de detaliu"),
    PUZ("Plan urbanistic zonal"),
    PUG("Plan urbanistic general"),
    DTAC("Documentatie tehnica pentru obtinerea autorizatiei de construire"),
    DTAD("Documentatie tehnica pentru obtinerea autorizatiei de demolare");

    private String name;

    ProjectSubType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
