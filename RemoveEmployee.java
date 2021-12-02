import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RemoveEmployee extends JFrame
{
    private JTextField  txtID;       //name
    private JButton     cmdDelete;
    private JButton     cmdClose;
    private JButton     cmdClearAll;
    public static final Color LIGHT_YELLOW_COLOR = new Color(255,255,200);
    public static final Color LIGHT_BLUE_COLOR = new Color(51,153,255);
    


    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private EmployeeMngScreen eListing;
    private RemoveEmployee REScreen;
  
    public RemoveEmployee(EmployeeMngScreen eListing)
    {
        this.eListing = eListing;
        REScreen = this;

        setTitle("Deleting Employee...");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Enter ID of Employee to be deleted: ")); 
        txtID = new JTextField(10);
        pnlDisplay.add(txtID);
        pnlDisplay.setLayout(new GridLayout(3,4));
       
        cmdDelete      = new JButton("Delete");
        cmdClose   = new JButton("Close");

        cmdClose.addActionListener(new CloseButtonListener());
        cmdDelete.addActionListener(new DeleteButtonListener());

        
        cmdClose.setBackground(LIGHT_BLUE_COLOR);
        cmdDelete.setBackground(LIGHT_BLUE_COLOR);

        pnlCommand.setBackground(LIGHT_YELLOW_COLOR);
        pnlDisplay.setBackground(LIGHT_YELLOW_COLOR);

        pnlCommand.add(cmdDelete);
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
            REScreen.setVisible(false);
        }

    }

    private class DeleteButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            String eid = txtID.getText();
            try
            {

                int edx = eListing.findEmployee(eid);
                if(edx >=0)
                {
                    int ans = JOptionPane.showConfirmDialog(REScreen, "Are you sure you want to remove Employee with ID#" +eid+ " ?", "Delete Employee?", 0);
                    if(ans == 0)
                    {
                        eListing.removeEmployee(edx);
                        REScreen.setVisible(false);
                        JOptionPane.showMessageDialog(eListing, "Employee Removed!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(REScreen, "Employee with ID# " +eid+ " not found");
                }
            }catch (NumberFormatException nfe) 
            {
                JOptionPane.showMessageDialog(REScreen, "Please enter a valid ID Number");
            }
            
        }

    }


}