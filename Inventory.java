public class Inventory {
    
    private String Name;
    private int Quantity;
    private Double Price;
    private int faultyAmount;

    Inventory(String Name, int Quantity, Double Price){
        this.Name = Name;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    void setName(String name) {
        this.Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    void setQuantity(int quantity) {
        this.Quantity = quantity-faultyAmount;
    }

    public Double getPrice() {
        return Price;
    }

    void setPrice(Double price) {
        this.Price = price;
    }

}
