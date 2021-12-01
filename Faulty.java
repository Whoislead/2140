import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;
import java.io.File;
import java.lang.*;
import java.util.ArrayList;


public class Faulty extends Inventory{
    private int faultyAmount;
    private String listFaulty;

    Faulty(String Name, int Quantity, Double Price, int faultyAmount) {
        super(Name, Quantity, Price);
        this.faultyAmount= faultyAmount;
    }


    public int getFaultyAmount() {
        return faultyAmount;
    }

    void setFaultyAmount(int faultyAmount) {
        this.faultyAmount = faultyAmount;
    }


    public String toString(){
        return Name +" "+ Quantity +" "+ Price+ " " + faultyAmount;

    }
}

class Main {
    public static void main(String[] args) {
        Faulty obj1 = new Faulty("Bolts", 7, 50.00, 3 );
        Faulty obj2 = new Faulty("Screw Driver", 12, 1500.00, 2);
        Faulty obj3 = new Faulty("Hammer", 25, 2050.00,6);
        Faulty obj4 = new Faulty("Nails", 500, 60.00, 50);
        ArrayList<Faulty> FaultyItems = new ArrayList<Faulty>();
        FaultyItems.add(obj1);
        FaultyItems.add(obj2);
        FaultyItems.add(obj3);
        FaultyItems.add(obj4);
        System.out.println(FaultyItems);
/*
     ########## Listing the Faulty items and their cost for generating document
        for(Faulty i: FaultyItems){
            System.out.println(i);
        }
        for(int i=0; i<Items.length; i++){
        if((FaultyItems.get(0).Name.equals(Items.get(0).Names)) && (FaultyItems.get(0).Price.equals(Items.get(0).Price))){
           int finalQ= FaultyItems.get(0).faultyAmount - Items.get(0).Quantity;
           Inventory obj1= new Inventory(Bolts, final, 60.0)
       Item.set(0, obj1)
          }
        System.out.println("Faulty Items removed")
        }
    ########### Write the Array list into a File import java.time
       try {
      FileWriter myWriter = new FileWriter("faultyItems.txt");
      myWriter.write("This is faulty inventory " + LocalDate.now());
      for(Faulty i : FaultyItems){
        myWriter.write(i + System.lineSeparator());
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred, please try again");
      e.printStackTrace();
    }
*/
    }

}