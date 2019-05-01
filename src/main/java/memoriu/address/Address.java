package memoriu.address;

public class Address {
    private String county;
    private String city;
    private String district;
    private String street;
    private String streetNumber;
    private String block;
    private String stairNumber;
    private String story;
    private String apartment;
    private String camera;

    public Address(String county, String city, String district, String street
            , String streetNumber, String block, String stairNumber, String story, String apartment, String camera) {
        this.county = county;
        this.city = city;
        this.district = district;
        this.street = street;
        this.streetNumber = streetNumber;
        this.block = block;
        this.stairNumber = stairNumber;
        this.story = story;
        this.apartment = apartment;
        this.camera = camera;
    }

    public Address(String county, String city, String district, String street
            , String streetNumber) {
        this.county = county;
        this.city = city;
        this.district = district;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public Address() {
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStairNumber() {
        return stairNumber;
    }

    public void setStairNumber(String stairNumber) {
        this.stairNumber = stairNumber;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return city + ", " + district + ", " +
                street + ", " + streetNumber + county;
    }
}
