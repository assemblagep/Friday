package infrastructure.spring.model;

public class Address {
    String street;
    String number;

    public Address() {
    }

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }


    public void setStreet(String weather) {
        this.street = weather;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
