package memoriu.building;

public class Building {
    private String footprint;
    private String totalArea;
    private String buildingMaterial;
    private String buildingCurrentState;

    public String getFootprint() {
        return footprint;
    }

    public void setFootprint(String footprint) {
        this.footprint = footprint;
    }

    public String getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(String totalArea) {
        this.totalArea = totalArea;
    }

    public String getBuildingMaterial() {
        return buildingMaterial;
    }

    public void setBuildingMaterial(String buildingMaterial) {
        this.buildingMaterial = buildingMaterial;
    }

    public String getBuildingCurrentState() {
        return buildingCurrentState;
    }

    public void setBuildingCurrentState(String buildingCurrentState) {
        this.buildingCurrentState = buildingCurrentState;
    }

    public String getBuildingInformations(){
        return "Cladire din " + buildingMaterial + " in stare " + buildingCurrentState +",  amprenta la sol: " +  footprint + " mp, suprafata construita desfasurata de: " + totalArea + "mp.";
    }
}
