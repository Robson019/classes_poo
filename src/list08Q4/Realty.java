package list08Q4;

public class Realty {
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;
    private String CEP;
    private double price;
    private boolean isHired;
    private boolean isFurnished;

    public Realty(String street, String number, String district, String city, String state, String CEP, double price, boolean isHired, boolean isFurnished) {
        setStreet(street);
        setNumber(number);
        setDistrict(district);
        setCity(city);
        setState(state);
        setCEP(CEP);
        setPrice(price);
        setHired(isHired);
        setFurnished(isFurnished);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        if (CEP.length() != 10) {
            System.out.println("[ERROR] Invalid CEP");
            this.CEP = null;
        } else {
            this.CEP = CEP;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public void setFurnished(boolean furnished) {
        isFurnished = furnished;
    }
}
