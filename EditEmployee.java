import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class EditEmployee extends JFrame
{
    private JTextField  txtName;       //name
    //private JTextField  txtUName;       //Username
    //private JPasswordField  txtPassword;        //password
    private JTextField  txtIDNum;       //ID Number
    private JTextField  txtAge;        //age
    private JTextField  txtPos;       //Position
    private JTextField  txtPhNum;        //Phone number
    private JTextField  txteAddr;       //email address
    private JTextField  txtAddr;        //address
    private JButton     cmdEdit;
    private JButton     cmdClose;
    private JButton     cmdClearAll;
    public static final Color LIGHT_YELLOW_COLOR = new Color(255,255,200);
    public static final Color LIGHT_BLUE_COLOR = new Color(51,153,255);
    
    //ArrayList<Venue> venues = new ArrayList<Venue>();
	//Ministry mny = new Ministry("HEALTH",2 );

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private EmployeeMngScreen eListing;
    private EditEmployee EEScreen;
  
    public EditEmployee(EmployeeMngScreen eListing)
    {
        this.eListing = eListing;
        EEScreen = this;

        setTitle("Updating Employee Information...");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Enter ID of Employee to be updated *: ")); 
        txtIDNum = new JTextField(10);
        pnlDisplay.add(txtIDNum);
        pnlDisplay.add(new JLabel("Enter new name or leave blank to keep original name of Employee: "));
        txtName = new JTextField(10);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("Enter new age or original age of Employee *: ")); 
        txtAge = new JTextField(20);
        pnlDisplay.add(txtAge);
        pnlDisplay.add(new JLabel("Enter new address or leave blank to keep original address of Employee: ")); 
        txtAddr = new JTextField(20);
        pnlDisplay.add(txtAddr);
        pnlDisplay.add(new JLabel("Enter new email address or leave blank to keep original email address of Employee: ")); 
        txteAddr = new JTextField(20);
        pnlDisplay.add(txteAddr);
        pnlDisplay.add(new JLabel("Enter new phone number or leave blank to keep original phone Number of Employee: :")); 
        txtPhNum = new JTextField(20);
        pnlDisplay.add(txtPhNum);
        pnlDisplay.add(new JLabel("Required *"));
        pnlDisplay.setLayout(new GridLayout(8,4));
       
        cmdEdit      = new JButton("Edit/Update");
        cmdClose   = new JButton("Close");
    
        cmdClose.setBackground(LIGHT_BLUE_COLOR);
        cmdEdit.setBackground(LIGHT_BLUE_COLOR);

        cmdClose.addActionListener(new CloseButtonListener());
        cmdEdit.addActionListener(new EditButtonListener());

        pnlCommand.setBackground(LIGHT_YELLOW_COLOR);
        pnlDisplay.setBackground(LIGHT_YELLOW_COLOR);

        pnlCommand.add(cmdEdit);
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
            EEScreen.setVisible(false);
        }

    }

    private class EditButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            String name = txtName.getText();
            String IDnum = txtIDNum.getText();
            String age = txtAge.getText();
            String addr = txtAddr.getText();
            String eAddr = txteAddr.getText();
            String phNum = txtPhNum.getText();
            try
            {
                int iage = Integer.valueOf(age);
                int edx = eListing.findEmployee(IDnum);
                if(edx >=0)
                {
                    int ans = JOptionPane.showConfirmDialog(EEScreen, "Are you sure you want to edit the information of Employee with ID#" +IDnum+ " ?", "Edit Employee?", 0);
                    if(ans == 0)
                    {
                        eListing.updateEmployeeinfo(edx, name, iage, addr, eAddr, phNum);
                        EEScreen.setVisible(false);
                        JOptionPane.showMessageDialog(eListing, "Employee Information Updated!");
                    }
                }else
                {
                    JOptionPane.showMessageDialog(EEScreen, "Employee with ID# " +IDnum+ " not found");
                }
            }catch (NumberFormatException nfe) 
            {
                JOptionPane.showMessageDialog(EEScreen, "Please ensure you have entered a valid age");
            }catch (NullPointerException npe)
            {
                JOptionPane.showMessageDialog(EEScreen, "Please ensure all fields are filled");
            }
            
        }

    }
}