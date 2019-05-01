package memoriu.property;

import memoriu.address.Address;
import memoriu.building.Building;
import memoriu.person.Person;
import memoriu.project.utilities.Utilities;
import memoriu.utr.UTR;

import java.util.ArrayList;

public class Property {
    private ArrayList<Person> owners;
    private ArrayList<Utilities> utilities;
    private String surface;
    private String cadastralNumber;
    private ArrayList<Building>buildings;
    private Address address;
    private ArrayList<UTR> UTRS;
    private ArrayList<UTR> newUTRS;
    private PropertyAct[] propertyActs;

    public Property() {
        owners = new ArrayList<Person>();
        utilities = new ArrayList<Utilities>();
        buildings = new ArrayList<Building>();
        UTRS = new ArrayList<UTR>();
        newUTRS = new ArrayList<UTR>();
    }

    public ArrayList<Person> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<Person> owners) {
        this.owners = owners;
    }

    public ArrayList<Utilities> getUtilities() {
        return utilities;
    }

    public void setUtilities(ArrayList<Utilities> utilities) {
        this.utilities = utilities;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<UTR> getUTRS() {
        return UTRS;
    }

    public void setUTRS(ArrayList<UTR> UTRS) {
        this.UTRS = UTRS;
    }

    public PropertyAct[] getPropertyActs() {
        return propertyActs;
    }

    public void setPropertyActs(PropertyAct[] propertyActs) {
        this.propertyActs = propertyActs;
    }

    public void addOwner(Person person){
        owners.add(person);
    }

    public void addUtilitie(Utilities utilities){
        this.utilities.add(utilities);
    }

    public void addBuilding(Building building){
        buildings.add(building);
    }

    public void addUTR(UTR utr){
        UTRS.add(utr);
    }

    public void addNewUTR(UTR utr){
        newUTRS.add(utr);
    }



    public ArrayList<UTR> getNewUTRS() {
        return newUTRS;
    }

    public void setNewUTRS(ArrayList<UTR> newUTRS) {
        this.newUTRS = newUTRS;
    }
}
