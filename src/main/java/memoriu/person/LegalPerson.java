package memoriu.person;

import memoriu.address.Address;

public class LegalPerson extends Person {

    private String uniqueID;
    private String registrationID;
    private Address address;

    public LegalPerson(String name, String uniqueID, String registrationID, Address address) {
        this.setName(name);
        this.uniqueID = uniqueID;
        this.registrationID = registrationID;
        this.address = address;
    }

    public LegalPerson() {
        this.setName("");
        this.uniqueID = "";
        this.registrationID = "";
    }



    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
