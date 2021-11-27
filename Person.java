import java.util.ArrayList;

public class Person {

    protected String Username;
    protected String Password;
    protected String Name;
    protected int idNumber;
    protected int Age;
    protected String Position;
    protected String Address;
    protected String phoneNumber;
    protected String emailAddress;
    protected ArrayList<Inventory> inventoryList;
    protected ArrayList<Customer> customerList;
    //Customer and Inventory ArrayList to be added when implemented

    Person(String Username, String Password, String Name, int idNumber, int Age, 
            String Position, String phoneNumber, String emailAddressString, String Address,
            ArrayList<Inventory> inventoryList, ArrayList<Customer> customersList){
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Age = Age;
        this.Position = Position;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddressString;
        this.inventoryList = inventoryList;
        this.customerList = customersList;
    }

    public String getUsername() {
        return Username;
    }

    void setUsername(String username) {
        this.Username = username;
    }

    public String getAddress() {
        return Address;
    }

    void setAddress(String address) {
        this.Address = address;
    }

    public String getPassword() {
        return Password;
    }

    void setPassword(String password) {
        this.Password = password;
    }

    public String getName() {
        return Name;
    }

    void setName(String name) {
        this.Name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return Age;
    }

    void setAge(int age) {
        this.Age = age;
    }

    public String getPosition() {
        return Position;
    }

    void setPosition(String position) {
        this.Position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    void setCustomerList(ArrayList<Customer> customers) {
        this.customerList = customerList;
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    void orderItem(ArrayList<Inventory> inventoryList, ArrayList<Customer> customerList){

    }
}