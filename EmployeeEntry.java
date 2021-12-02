import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;

public class EmployeeEntry extends JFrame
{
    private JTextField  txtName;       //name
    //private JTextField  txtbudget;        //budget
    private JTextField  txtUName;       //Username
    private JPasswordField  txtPassword;        //password
    //private JTextField  txtIDNum;       //ID Number
    private JTextField  txtAge;        //age
    private JTextField  txtPos;       //Position
    private JTextField  txtPhNum;        //Phone number
    private JTextField  txteAddr;       //email address
    private JTextField  txtAddr;        //address
    private JButton     cmdAdd;
    private JButton     cmdClose;
    public static final Color LIGHT_YELLOW_COLOR = new Color(255,255,200);
    public static final Color LIGHT_BLUE_COLOR = new Color(51,153,255);
    
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Inventory> items = new ArrayList<Inventory>();

    private Double Salary = 0.0;
    //private String IDNumber = "";

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private EmployeeMngScreen eListing;
    private EmployeeEntry EEntry;
  
    public EmployeeEntry(EmployeeMngScreen eListing)
    {
        this.eListing = eListing;
        EEntry = this;

        setTitle("Entering new Employee");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Name * :")); 
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("UserName * :")); 
        txtUName = new JTextField(20);
        pnlDisplay.add(txtUName);
        pnlDisplay.add(new JLabel("Password * [Must be at least 5 characters long]:")); 
        txtPassword = new JPasswordField(20);
        pnlDisplay.add(txtPassword);
        pnlDisplay.add(new JLabel("Age * :")); 
        txtAge = new JTextField(20);
        pnlDisplay.add(txtAge);
        pnlDisplay.add(new JLabel("Position * [Employee or Owner]:")); 
        txtPos = new JTextField(20);
        pnlDisplay.add(txtPos);
        pnlDisplay.add(new JLabel("Address:")); 
        txtAddr = new JTextField(20);
        pnlDisplay.add(txtAddr);
        pnlDisplay.add(new JLabel("Email Address:")); 
        txteAddr = new JTextField(20);
        pnlDisplay.add(txteAddr);
        pnlDisplay.add(new JLabel("Phone Number:")); 
        txtPhNum = new JTextField(20);
        pnlDisplay.add(txtPhNum);
        pnlDisplay.add(new JLabel("Required *"));
        pnlDisplay.setLayout(new GridLayout(12,2));
       
        cmdAdd      = new JButton("Add Employee");
        cmdClose   = new JButton("Close");

        
        cmdClose.setBackground(LIGHT_BLUE_COLOR);
        cmdAdd.setBackground(LIGHT_BLUE_COLOR);

        cmdClose.addActionListener(new CloseButtonListener());
        cmdAdd.addActionListener(new AddButtonListener());
        pnlCommand.setBackground(LIGHT_YELLOW_COLOR);
        pnlDisplay.setBackground(LIGHT_YELLOW_COLOR);

        pnlCommand.add(cmdAdd);
        pnlCommand.add(cmdClose);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            EEntry.setVisible(false);
        }

    }

    public String createIDNum(String numfile, String pos)
    {
        Scanner numscan = null;
        String p = pos.toUpperCase();
        String idnumber = "";
        try
        {
            numscan = new Scanner(new File(numfile));
            while(numscan.hasNext())
            {
                String num = numscan.next();
                int inum = Integer.parseInt(num);
                if(p.equals("EMPLOYEE"))
                {
                    if (inum <= 9)
                    {
                        idnumber = "EMP00"+ inum;
                    }else if ((inum >= 10) && (inum <=99))
                    {
                        idnumber = "EMP0"+ inum;
                    }else if ((inum > 99) && (inum <1000))
                    {
                        idnumber = "EMP"+ inum;
                    }
                }else if(p.equals("OWNER"))
                {
                    if (inum <= 9)
                    {
                        idnumber = "OWN00"+ inum;
                    }else if ((inum >= 10) && (inum <=99))
                    {
                        idnumber = "OWN0"+ inum;
                    }else if ((inum > 99) && (inum <1000))
                    {
                        idnumber = "OWN"+ inum;
                    }
                }
                File filename = new File(numfile);
                Writer fileWriter = null;
                BufferedWriter bufferedWriter = null;
                try
                {
                    fileWriter = new FileWriter(filename);
                    bufferedWriter = new BufferedWriter(fileWriter);
                    inum++;
                    String line = String.valueOf(inum);
                    bufferedWriter.write(line);

            
                }catch (IOException e)
                {
                System.err.println("Error writing the file : ");
                e.printStackTrace();
                } finally
                    {
                        if (bufferedWriter != null && fileWriter != null) 
                        {
                            try 
                            {
                                bufferedWriter.close();
                                fileWriter.close();
                            }catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                        }
                    }

                   
            }

            numscan.close();
        }catch(IOException ioe)
            {
            JOptionPane.showMessageDialog(EEntry, "Problem creating Employee ID");
            }
		    catch(NumberFormatException nfe)
		    {}

            return idnumber;
    }

    private class AddButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
           //
            //String IDnum = txtIDNum.getText();
            String age = txtAge.getText();
            //String pos = txtPos.getText();
            String addr = txtAddr.getText();
            String eAddr = txteAddr.getText();
            String phNum = txtPhNum.getText();
            try
            {
                String name = txtName.getText();
                String Uname = txtUName.getText();
                String password = txtPassword.getPassword().toString();
                String pos = txtPos.getText();
                String IDnum = createIDNum("2140/NumberofEmployees.txt",pos);
                Integer iage = Integer.valueOf(age);
                if(addr.equals(""))
                {
                    addr = "NA";
                }
                if(eAddr.equals(""))
                {
                    eAddr = "NA";
                }
                if(phNum.equals(""))
                {
                    phNum = "NA";
                }
                if(name.equals("") || password.equals("") || pos.equals("") || Uname.equals(""))
                {
                    throw new RequiredFieldException("Fill required Fields");
                }
                eListing.addEmployee(new Employee(Uname, password, name, IDnum, iage, pos, phNum, eAddr, addr, items, customers, Salary));
                EEntry.setVisible(false);
                JOptionPane.showMessageDialog(eListing, "Employee Added!");
            }catch (NumberFormatException nfe) 
            {
                JOptionPane.showMessageDialog(EEntry, "Please enter a valid age");
            }catch(NullPointerException npe)
            {
                JOptionPane.showMessageDialog(EEntry, "Please enter a valid required");
            }catch(RequiredFieldException rfe)
            {
                JOptionPane.showMessageDialog(EEntry, "Please ensure all required fields are filled");
            }
            
        }

    }


}