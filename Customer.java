import java.util.ArrayList;

public class Customer {
    
    private String Name;
    private String Address;
    private String emailAddress;
    private String phoneNumber;
    private String idNum;
    private ArrayList<Order> Orders;

    Customer(String Name, String Address, String emailAddress, String phoneNumber, String idNum, ArrayList<Order> Orders){
        this.Name = Name;
        this.Address = Address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.idNum = idNum;
        this.Orders = Orders;
    }

    public String getName() {
        return Name;
    }

    void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    void setAddress(String address) {
        Address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getIdNum() {
        return idNum;
    }

    void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    void setOrders(ArrayList<Order> orders) {
        this.Orders = orders;
    }
}
