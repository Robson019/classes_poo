package list08Q4;

public class Apartment extends Realty {
    private String buildingName;

    public Apartment(String street, String number, String district, String city, String state, String CEP, double price, boolean isHired, boolean isFurnished, String buildingName) {
        super(street, number, district, city, state, CEP, price, isHired, isFurnished);
        setBuildingName(buildingName);
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
