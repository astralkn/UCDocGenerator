package memoriu.person;

import memoriu.address.Address;

public class PrivatePerson extends Person{
    private String uniqueID;
    private Address address;

    public PrivatePerson() {
        this.setName("");
        this.uniqueID = "";
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
