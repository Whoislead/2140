import java.util.ArrayList;

public class Employee extends Person{

    private double Salary;

    Employee(String Username, String Password, String Name, int idNumber, int Age, String Position,
            String phoneNumber, String emailAddressString, String Address, ArrayList<Inventory> inventoryList,
            ArrayList<Customer> customersList, double Salary) {
        super(Username, Password, Name, idNumber, Age, Position, phoneNumber, emailAddressString, Address, inventoryList,
                customersList);
        setSalary(Salary);
    }
    
    public double getSalary() {
        return Salary;
    }

    void setSalary(double salary) {
        Salary = salary;
    }
}