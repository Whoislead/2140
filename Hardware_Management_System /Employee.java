import java.util.ArrayList;

public class Employee extends Person{

    private double Salary;
    private String Address;

    Employee(String Username, String Password, String Name, int idNumber, int Age, int Income, String Position,
            String phoneNumber, String emailAddresString, ArrayList<Inventory> inventoryList,
            ArrayList<Customer> customersList, double Salary, String Address) {
        super(Username, Password, Name, idNumber, Age, Income, Position, phoneNumber, emailAddresString, inventoryList,
                customersList);
        setSalary(Salary);
        setAddress(Address);
    }
    
    public double getSalary() {
        return Salary;
    }

    void setSalary(double salary) {
        Salary = salary;
    }

    public String getAddress() {
        return Address;
    }

    void setAddress(String address) {
        Address = address;
    }
}