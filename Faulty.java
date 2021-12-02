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

    public class Faulty extends Inventory{
    private int faultyAmount;
    private String listFaulty;

    Faulty(String Name, int Quantity, Double Price, int faultyAmount) {
        //inherit from Inventory Class
        super(Name, Quantity, Price);
        this.faultyAmount= faultyAmount;
    }


    public int getFaultyAmount() {
        return faultyAmount;
    }

    void setFaultyAmount(int faultyAmount) {
        this.faultyAmount = faultyAmount;
    }

    // Override toString
    public String toString(){
        return Name +" "+ Quantity +" "+ Price+ " " + faultyAmount;

    }
}
