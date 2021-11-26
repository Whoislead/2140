import java.util.ArrayList;

public class Order {
    
    private String employeeName;
    private String employeeID;
    private ArrayList<Double> price;
    private ArrayList<Integer> Quantity;
    private ArrayList<String> itemname;

    Order(String employeeName, String employeeID, ArrayList<Double> price, ArrayList<Integer> Quantity, ArrayList<String> itemName){
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.price = price;
        this.Quantity = Quantity;
        this.itemname = itemName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    void setPrice(ArrayList<Double> price) {
        this.price = price;
    }

    public ArrayList<Integer> getQuantity() {
        return Quantity;
    }

    void setQuantity(ArrayList<Integer> quantity) {
        Quantity = quantity;
    }

    public ArrayList<String> getItemname() {
        return itemname;
    }

    void setItemname(ArrayList<String> itemname) {
        this.itemname = itemname;
    }
}