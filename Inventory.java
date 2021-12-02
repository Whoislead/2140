public class Inventory {
  private String Name;
  private int Quantity;
  private double Price;
  
   public Inventory(){
    this.Price = 0;
  }

  public Inventory(String Name, int Quantity, double Price){
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


  public double getPrice() {
    return Price;
  }

  void setPrice(double price) {
    this.Price = price;
  }

  public String toString(){
    String result = "There are " + this.Quantity + this.Name +  " and each is sold for $ " + this.Price+".\n";
    return result;
  }

  

  public boolean addItem(String itemname, int amount, double cost){

    File stock = new File("Inventory.txt");
    if (stock.exists()) {
      try{
        FileWriter addinfo = new FileWriter("Inventory.txt");
        Inventory iteminfo = new  Inventory(itemname, amount, cost);
        addinfo.write( iteminfo.toString());
        addinfo.close();
        return true; 
      } catch (IOException e) {
        System.out.println("ERROR!");
        e.printStackTrace();
      }
    }        

    return false;
  }

  public boolean removeItem(String itemname){  
    File stock = new File("Inventory.txt");
    if (stock.exists() && stock.canRead()) {
      try{
        File temp = new File("AlternateInventory.txt");
        BufferedReader read = new BufferedReader(new FileReader(stock));
        BufferedWriter change = new BufferedWriter(new FileWriter(temp));

        String currentLine;

        while((currentLine = read.readLine()) != null) {
          if(currentLine.contains(itemname)) continue;

          change.write(currentLine);
        }

        change.close(); 
        read.close(); 
        boolean successful = temp.renameTo(stock);
        return successful;  

      }catch (IOException e) {
        System.out.println("ERROR!");
        e.printStackTrace();
      } 

    }

    return false;
  
  }

  public boolean changeInfo(String oldData, String newData){

    File updateFile = new File ("Inventory.txt");

    if (updateFile.exists() && updateFile.canRead()) { 
      try {
        BufferedReader read = new BufferedReader(new FileReader(updateFile));
        FileWriter newFile = new FileWriter(updateFile);
        String aLine = read.readLine();
        String previous = "";

        while (aLine != null){
          previous = previous + aLine + System.lineSeparator();
          aLine = read.readLine();
        }

        String changedinfo = previous.replaceAll(oldData, newData);
        newFile.write(changedinfo);


       read.close();
       newFile.close();
      }
      catch (IOException e) {
        System.out.println("ERROR!");
        e.printStackTrace();
      }

    }
    return false;

  }

}
