import java.util.ArrayList;

public class Owner extends Person{

    private ArrayList<Double> Expenses;
    private String expensesName;
    private boolean Profit_Loss;
    private double totalExpenses;

    Owner(String Username, String Password, String Name, int idNumber, int Age,String Position, 
            String phoneNumber, String emailAddressString, String Address, ArrayList<Inventory> inventoryList,
            ArrayList<Customer> customersList, ArrayList<Double> Expenses, String expensesName, boolean Profit_Loss, 
            double totalExpenses) {
                super(Username, Password, Name, idNumber, Age, Position, phoneNumber, emailAddressString, Address, inventoryList,
                customersList);
        setExpenses(Expenses);
        setExpensesName(expensesName);
        setProfit_Loss(Profit_Loss);
        setTotalExpenses(totalExpenses);
    }

    public ArrayList<Double> getExpenses() {
        return Expenses;
    }

    void setExpenses(ArrayList<Double> expenses) {
        this.Expenses = expenses;
    }

    public String getExpensesName() {
        return expensesName;
    }

    void setExpensesName(String expensesName) {
        this.expensesName = expensesName;
    }

    public boolean getProfit_Loss(){
        return Profit_Loss;
    }

    void setProfit_Loss(boolean profit_Loss) {
        this.Profit_Loss = profit_Loss;
    }

    void calculateProfit_Loss(double totalExpenses, double income){
        if(totalExpenses > income){
            setProfit_Loss(false);
        }else{
            setProfit_Loss(true);
        }
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    void calculateTotalExpenses(ArrayList<Double> Expenses){
        setTotalExpenses(Expenses.stream().reduce((a,b)->a+b).get());
    }

    void addToInventory(ArrayList<Inventory> inventoryList){

    }

    void deleteItem(ArrayList<Inventory> inventoryList){

    }

    void refundItem(ArrayList<Inventory> inventoryList, ArrayList<Customer> customerList){

    }

    void deleteOrder(ArrayList<Customer> customerList){

    }
}