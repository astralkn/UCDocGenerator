package memoriu.project.utilities;

public enum Utilities {
    WATER("Alimentare cu apa"),
    SEWAGE("Canalizare"),
    GAS("Alimentare cu gaze"),
    ELECTICITY("Alimentare cu energie electrica");

    private String name;

    Utilities(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
