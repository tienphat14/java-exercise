package streamapi;

public class Address {
    private final Integer flatNumber;
    private final Integer streetNumber;
    private final String buildingName;
    private final String streetName;
    private final String postCode;

    public Address(Integer flatNumber, Integer streetNumber, String buildingName, String streetName, String postCode) {
        this.flatNumber = flatNumber;
        this.streetNumber = streetNumber;
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.postCode = postCode;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPostCode() {
        return postCode;
    }
}
