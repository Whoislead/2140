import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
//     private static ArrayList<Employee> Employees = new ArrayList<Employee>();
//     private static ArrayList<Inventory> Items = new ArrayList<Inventory>();
//     private static ArrayList<Owner> Owners = new ArrayList<Owner>();
//     private static ArrayList<Customer> Customers = new ArrayList<Customer>();

    // static File employeeCredentialsFile = new File("EmployeeCredentials.dat");
    public static void main(String[] args){
        // try {
        //     Scanner sc = new Scanner(employeeCredentialsFile);//scanner used to catch lines of string in file
        //     while(sc.hasNextLine()){//while loop to catch entire lines of string 
        //        String employeeString[] = sc.nextLine().split(";");//string array which stores individual aspects of a promter by splitting the line with a ";" delimiter
        //        employeeCredentials.add();//Adding individual promoters to arraylist
        //     }
        //     sc.close();//closing scanner
        //  }catch(FileNotFoundException fnf){
   
        //  }
        new GUI();
    }
}