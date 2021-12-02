public class Inventory {
  private String Name;
  private int Quantity;
  private double Price;
  


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


  public Double getPrice() {
    return Price;
  }

  void setPrice(double price) {
    this.Price = price;
  }

  public String toString(){
    String result = this.Name + " has a quantity of  " + this.Quantity + " and is sold for " + this.Price() + "each";
    return result;
  }

 

  public boolean addItem(String itemname, int amount, double cost){

    File stock = new File("Inventory.txt");
    if (stock.exists()) {
      try{
        FileWriter addinfo = new FileWriter("Inventory.txt");
        Inventory iteminfo = new  Inventory(itemname, amount, cost)
        addinfo.write( iteminfo.toString())
        addinfo.close()
        return true 
      } catch (IOException e) {
        System.out.println("ERROR!");
        e.printStackTrace();
      }
    }        

    return false
    }

    public boolean removeItem(String itemname){  
      File stock = new File("Inventory.txt");
      if (stock.exists() && stock.canRead()) {
        File temp = new File("AlternateInventory.txt");
        BufferedReader read = new BufferedReader(new FileReader(stock));
        BufferedWriter change = new BufferedWriter(new FileWriter(temp);

        String currentLine;

        while((currentLine = read.readLine()) != null) {
          if(currentLine.contains(itemname)) continue;

          change.write(currentLine);
        }
        change.close(); 
        read.close(); 
        boolean successful = temp.renameTo(stock);
        return successful;   

      }

      return false;
  
    }

  public boolean changeInfo(String oldData, String newData){

    File updateFile = new File ("Inventory.txt");

    if (updateFile.exists() && updateFile.canRead()) { 

      BufferedReader read = new BufferedReader(new FileReader(updateFile));
      FileWriter newFile = new Filewriter(updateFile);
      String aLine = read.readLine();

      while (aLine != null){
        String previous = "" + aLine + System.lineSeparator();
        line = reader.readLine();
      }

      String changedinfo = previous.replaceAll(oldData, newData);
      newfile.write(changedinfo);


      read.close();
      newFile.close();
       
    }


    return false;

  }


}
