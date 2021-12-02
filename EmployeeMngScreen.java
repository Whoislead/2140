import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.ObjectOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.util.Comparator;
import java.util.Collections;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;


public class EmployeeMngScreen extends JFrame
{
    private JButton     cmdAddEmployee;
    private JButton     cmdClose;
    private JButton     cmdSortName;
    private JButton     cmdDeleteEmployee;
    private JButton     cmdEditEmployee;
    private JButton     cmdSaveEmployeeinfo;

    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Inventory> items = new ArrayList<Inventory>();
  
    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private ArrayList<Employee> elist;
    private EmployeeMngScreen EScreen;
    //private RemoveEmployee REScreen;
    //private EditEmployee   EDEScreen;
    private  JScrollPane scrollPane;
    public static final Color LIGHT_BLUE_COLOR = new Color(51,153,255);
    public static final Color LIGHT_YELLOW_COLOR = new Color(255,255,200);


    private JTable table;
    private DefaultTableModel model;

   
    public EmployeeMngScreen(ArrayList<Employee> elist) 
    {
        
        EScreen = this;
        setTitle("Managing Employee Details");

        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

        this.elist = elist;
        String[] columnNames=  {"ID Number",
                "Name",
                "Age",
                "Phone Number",
                "Address",
                "Email Address",};
        model=new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        showTable(elist);
        


        table.setPreferredScrollableViewportSize(new Dimension(500, elist.size()*15 +50));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);
       
        pnlDisplay.add(scrollPane);

        cmdAddEmployee  = new JButton("Add/Create Employee");
        cmdSortName  = new JButton("Sort by Name");
        cmdClose   = new JButton("Close");
        cmdDeleteEmployee = new JButton("Delete Employee");
        cmdEditEmployee = new JButton("Edit/Update Employee");
        cmdSaveEmployeeinfo = new JButton("Save ALL Changes Made");

        cmdSortName.setBackground(LIGHT_BLUE_COLOR);
        cmdClose.setBackground(LIGHT_BLUE_COLOR);
        cmdAddEmployee.setBackground(LIGHT_BLUE_COLOR);
        cmdDeleteEmployee.setBackground(LIGHT_BLUE_COLOR);
        cmdEditEmployee.setBackground(LIGHT_BLUE_COLOR);
        cmdSaveEmployeeinfo.setBackground(LIGHT_BLUE_COLOR);

        pnlCommand.setBackground(LIGHT_YELLOW_COLOR);
        pnlDisplay.setBackground(LIGHT_YELLOW_COLOR);
        table.setBackground(LIGHT_YELLOW_COLOR);

        cmdClose.addActionListener(new CloseButtonListener());
        cmdAddEmployee.addActionListener(new AddEmployeeButtonListener());
        cmdSortName.addActionListener(new SortNameButtonListener());
        cmdDeleteEmployee.addActionListener(new DeleteEmployeeButtonListener());
        cmdEditEmployee.addActionListener(new EditEmployeeButtonListener());
        cmdSaveEmployeeinfo.addActionListener(new SaveChangesButtonListener());


        JLabel commandtitle = new JLabel("Choose One of the Option Below: ");
        
        

        pnlCommand.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.weighty = 1.0;
        c.gridy = 0;
        c.insets = new Insets(5,5,0,5);
        pnlCommand.add(commandtitle,c);

        c.fill = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 1;
        pnlCommand.add(cmdSortName,c);

       

        c.fill = GridBagConstraints.NORTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        pnlCommand.add(cmdAddEmployee,c);


        c.fill = GridBagConstraints.NORTH;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        pnlCommand.add(cmdEditEmployee,c);

        c.fill = GridBagConstraints.NORTH;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        pnlCommand.add(cmdDeleteEmployee,c);

        c.fill = GridBagConstraints.NORTH;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        pnlCommand.add(cmdSaveEmployeeinfo,c);
        

        c.fill = GridBagConstraints.NORTH;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,5,5,0);
        pnlCommand.add(cmdClose,c);

        

        
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showTable(ArrayList<Employee> elist)
    {
        if (elist.size()>0)
        {
            for (int i = 0; i < elist.size(); i++)
            {
                addToTable(elist.get(i));
            } 
        }

    }

    private void addToTable(Employee e)
    { 
        String[] item={""+ e.getIdNumber(),""+e.getName(),""+ e.getAge(), ""+e.getPhoneNumber(), ""+e.getAddress(), ""+e.getEmailAddress()};
        model.addRow(item);        

    }


    public void addEmployee(Employee e)
    {
        elist.add(e);
        addToTable(e);

    }

    public int findEmployee(String eid)
	{
		int edx =-1;
		int currdx=0;
		while ((currdx<elist.size())&&(edx==-1))
		{
			if (elist.get(currdx).getIdNumber().equals(eid))
				edx = currdx;
			currdx++;

		}

		return edx;
	}

    public void removeEmployee(int edx)
    {
        model.setRowCount(0);
        elist.remove(edx);
        showTable(elist); 
    }
    

    public void updateEmployeeinfo(int edx, String name, int age, String addr, String eaddr, String phnum)
    {
        model.setRowCount(0);
        String currname = elist.get(edx).getName();
        String curraddr = elist.get(edx).getAddress();
        String curreaddr = elist.get(edx).getEmailAddress();
        String currphnum = elist.get(edx).getPhoneNumber();
        if (name.equals(""))
			name = currname;
        elist.get(edx).setName(name);
        if (addr.equals(""))
			addr = curraddr;
        if (eaddr.equals(""))
			eaddr = curreaddr;
        if (phnum.equals(""))
			phnum = currphnum;
        elist.get(edx).setName(phnum);   
        elist.get(edx).setName(eaddr);
        elist.get(edx).setAddress(addr);
        elist.get(edx).setName(name);
        elist.get(edx).setAge(age);
        showTable(elist);
    }

    private class SortNameButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            model.setRowCount(0);
            Collections.sort(elist, new EmpNameComparator());
            showTable(elist);
        }

    }

    private class AddEmployeeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            new EmployeeEntry(EScreen);
        }

    }

    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {   
            EScreen.setVisible(false);
        }

    }
    

    private class DeleteEmployeeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            new RemoveEmployee(EScreen);
        }

    }

    private class EditEmployeeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            new EditEmployee(EScreen);
        }

    }

    private class SaveChangesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                saveFile(elist,"2140/EmployeeCredentials.txt");
                JOptionPane.showMessageDialog(EScreen, "Changes have been saved!");
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(EScreen, ex.getMessage());
            }
        }

    }

    public static void saveFile(ArrayList<Employee> empls, String file) 
    {
 
        File filename = new File(file);
        Writer fileWriter = null;
        BufferedWriter bufferedWriter = null;
 
        try 
        {
 
            fileWriter = new FileWriter(filename);
            bufferedWriter = new BufferedWriter(fileWriter);
 
            for (Employee empl : empls) 
            {
                String line = empl.getUsername() + ";"+ empl.getPassword() + ";" + empl.getName() + ";" + empl.getIdNumber() + ";" + empl.getAge() + ";" + empl.getPosition() + ";" + empl.getPhoneNumber() + ";" + empl.getEmailAddress() + ";" + empl.getAddress() + ";" + empl.getSalary();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
 
            }
 
        } catch (IOException e) {
            System.err.println("Error writing the file : ");
            e.printStackTrace();
        } finally {
 
            if (bufferedWriter != null && fileWriter != null) {
                try {
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
    }

}