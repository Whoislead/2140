import java.util.jar.Attributes.Name;

public class Person {
    protected String Username;
    protected String Password;
    protected String Name;
    protected int idNumber;
    protected int Age;
    protected String Position;
    protected String phoneNumber;
    protected String emailAddress;
    protected ArrayList<Inventory> inventoryList;
    protected ArrayList<Customers> customerList;
    //Customer and Inventory ArrayList to be added when implemented
    Person(String Username, String Password, String Name, int idNumber, int Age, String Position, String phoneNumber, String emailAddresString){
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Age = Age;
        this.Position = Position;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddresString;
    }

    public String getUsername() {
        return Username;
    }

    protected void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    protected void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}