/**
 * Class that provides all aspects of an address
 */
public class Address {

    public static Object getState;
    private int streetNum;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    
    // Constructor passive
    public Address() {
    }

    // Constructor strict
    public Address(int streetNum, String streetName, String city, String state, String zipCode) {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // set street only
    public void setStreetAddress( String newAddress) {
        //split the new address into an array of string
        String[] temp = newAddress.split(" ");
        String newStName = "";
        this.streetNum = Integer.parseInt(temp[0]);

        // create a string for the street name
        for (int i = 1; i < temp.length; i++) {
            newStName = temp[1];
            if (i != temp.length -2) {
                newStName += " ";
            }
        }
        this.streetName = newStName;
    }

    // Getters / setters
    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void printAddress() {
        System.out.println(streetNum + " " + streetName + ", " + city + ", " + state + ", " + zipCode);
    }
}
