import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUI{
    private JFrame mainFrame = new JFrame();

    private JButton loginButton = new JButton("Login");
    private JButton orderButton = new JButton("Order");
    private JButton customerDataButton = new JButton("<html><center>"+"Customer Data"+"<br>"+"Collection"+"</center></html>");
    private JButton manageInventoryButton = new JButton("Mangage Inventory");
    private JButton manageEmployeeButton = new JButton("Manage Employee");
    private JButton employeeButton = new JButton("Employee");
    private JButton ownerButton = new JButton("Owner");
    private JButton backButton = new JButton("Back");

    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel menuLabel = new JLabel();
    private JLabel testLabel = new JLabel();

    private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Inventory> items = new ArrayList<Inventory>();

    private SpringLayout layout = new SpringLayout();

    private Container contentPane = mainFrame.getContentPane();

    private JTextField usernameTextField = new JTextField(15);
    private JPasswordField passwordTextField = new JPasswordField(15);
    
    menuBack mBack = new menuBack();
    manageEmployeeButtonListener mEMp = new manageEmployeeButtonListener();
    employeeMenuBack_ownerMenuBack emp_ownBack = new employeeMenuBack_ownerMenuBack();
    manageInventoryButtonListener mInv = new manageInventoryButtonListener();
    orderButtonListener orderListener = new orderButtonListener();

    GUI(){
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        contentPane.setLayout(layout);

        employeeButton.addActionListener(new employeeButtonListener());
        ownerButton.addActionListener(new ownerButtonListener());
        // customerDataButton.addActionListener(l);
        manageInventoryButton.addActionListener(mInv);
        manageEmployeeButton.addActionListener(mEMp);
        orderButton.addActionListener(orderListener);


        File efile = new File("2140/EmployeeCredentials.txt");
        try
        {
            efile.createNewFile();
        }catch(IOException ioe)
        {}

        loadData();

        setLoginFrame();   
    }

    public void loadData()
	{
		clearData();    
        this.employees = loadEmployees("2140/EmployeeCredentials.txt", this.customers, this.items);

	}

    public void clearData()
        {
            employees.clear();
        //customers.clear();
        }

    public ArrayList<Employee> loadEmployees(String efile, ArrayList<Customer> customers, ArrayList<Inventory> items)
	{
		Scanner escan = null;
		ArrayList<Employee> elist = new ArrayList<Employee>();
        try
		{
            escan  = new Scanner(new File(efile));
            while(escan.hasNextLine())
			{
				String [] nextLine = escan.nextLine().split(";");
				String Uname = nextLine[0];
                String password = nextLine[1];
                String name = nextLine[2];
                String IDnum = nextLine[3];
				int iage = Integer.parseInt(nextLine[4]);
                String pos = nextLine[5];
                String phNum = nextLine[6];
                String eAddr = nextLine[7];
                String addr = nextLine[8];
                double Salary = Double.parseDouble(nextLine[9]);
				Employee e = new Employee(Uname, password, name, IDnum, iage, pos, phNum, eAddr, addr, items, customers, Salary);
				elist.add(e);
			}

			escan.close();
            
		}
		catch(IOException e)
		{}
		catch(NumberFormatException nfe)
		{}

		return elist;

	}

    private void removeListeners(JButton button, ActionListener[] actLst){
        for(ActionListener act:actLst){
            button.removeActionListener(act);
        }
    }

    private void setLoginFrame(){
        setLoginPane();
        mainFrame.setTitle("Hardware Management System");
        mainFrame.setSize(480, 270);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setContentPane(contentPane);
        mainFrame.setVisible(true);
    }

    private void setLoginPane(){
        removeListeners(backButton, backButton.getActionListeners());
        loginButton.addActionListener(new loginButtonListener());

        contentPane.removeAll();
        contentPane.setLayout(layout);
        contentPane.add(loginButton);
        contentPane.add(usernameLabel);
        contentPane.add(passwordLabel);
        contentPane.add(usernameTextField);
        contentPane.add(passwordTextField);

        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 6, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, usernameTextField, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, usernameLabel, 0, SpringLayout.NORTH, usernameTextField);
        layout.putConstraint(SpringLayout.EAST, usernameLabel, -6, SpringLayout.WEST, usernameTextField);

        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 6, SpringLayout.SOUTH, usernameTextField);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, passwordTextField, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 0, SpringLayout.NORTH, passwordTextField);
        layout.putConstraint(SpringLayout.EAST, passwordLabel, -6, SpringLayout.WEST, passwordTextField);
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, loginButton, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 6, SpringLayout.SOUTH, passwordTextField);
    }

    private void setMainMenu(){
        mainFrame.setVisible(false);
        mainFrame.setTitle("Main Menu");
        menuLabel.setText("Main Menu");
        menuLabel.setSize(50,50);        

        removeListeners(backButton, backButton.getActionListeners());
        backButton.addActionListener(mBack);
        backButton.setText("Log Out");

        contentPane.removeAll();
        contentPane.add(menuLabel);
        contentPane.add(backButton);
        contentPane.add(employeeButton);
        contentPane.add(ownerButton);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, menuLabel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, menuLabel, 12, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, employeeButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.EAST, employeeButton, -6, SpringLayout.WEST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, ownerButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.WEST, ownerButton, 6, SpringLayout.EAST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, backButton, 12, SpringLayout.SOUTH, ownerButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backButton, 0, SpringLayout.HORIZONTAL_CENTER, menuLabel);

        mainFrame.setVisible(true);
    }

    private void setEmployeeMenu(){
        mainFrame.setVisible(false);
        mainFrame.setTitle("Employee Menu");
        menuLabel.setText("Employee Menu");

        removeListeners(backButton, backButton.getActionListeners());
        backButton.addActionListener(emp_ownBack);
        backButton.setText("Back");

        contentPane.removeAll();
        contentPane.add(menuLabel);
        contentPane.add(backButton);
        contentPane.add(orderButton);
        contentPane.add(customerDataButton);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, menuLabel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, menuLabel, 12, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, orderButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.EAST, orderButton, -6, SpringLayout.WEST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, customerDataButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.WEST, customerDataButton, 6, SpringLayout.EAST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, backButton, 12, SpringLayout.SOUTH, customerDataButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backButton, 0, SpringLayout.HORIZONTAL_CENTER, menuLabel);

        mainFrame.setVisible(true);
    }

    private void setOwnerMenu(){
        mainFrame.setVisible(false);
        mainFrame.setTitle("Owner Menu");
        menuLabel.setText("Owner Menu");

        removeListeners(backButton, backButton.getActionListeners());
        backButton.addActionListener(emp_ownBack);
        backButton.setText("Back");

        contentPane.removeAll();
        contentPane.add(menuLabel);
        contentPane.add(backButton);
        contentPane.add(manageInventoryButton);
        contentPane.add(manageEmployeeButton);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, menuLabel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, menuLabel, 12, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, manageInventoryButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.EAST, manageInventoryButton, -6, SpringLayout.WEST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, manageEmployeeButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.WEST, manageEmployeeButton, 6, SpringLayout.EAST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, backButton, 12, SpringLayout.SOUTH, manageEmployeeButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backButton, 0, SpringLayout.HORIZONTAL_CENTER, menuLabel);

        mainFrame.setVisible(true);
    }

    private boolean notCredentials(String user, String pass){
        for(Employee emp: employees){
            if((user+pass).equals(emp.getUsername()+emp.getPassword()) ){
                return false;
            }
        }
        return true;
    }

    private boolean notCredentials(String pass){
        for(Employee emp: employees){
            if((pass+"Owner").equals(emp.getPassword()+emp.getPosition())){
                return false;
            }
        }
        return true;
    }

    private class loginButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(usernameTextField.getText().equals("") || String.valueOf(passwordTextField.getPassword()).equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Please ensure all text field are filled!",//Pane displayed when all 
                "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }else if(notCredentials(usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()))){
                JOptionPane.showMessageDialog(new JFrame(), "The password or username is invalid",//Pane displayed when all 
                "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(new JFrame(), "Welcome " + usernameTextField.getText(),//Pane displayed when all 
                "Successful Login", JOptionPane.WARNING_MESSAGE);
                usernameTextField.setText("");
                passwordTextField.setText("");
                setMainMenu();
            }
        } 
    }

    private class employeeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setEmployeeMenu();
            
        }
        
    }

    private class ownerButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(false);
            mainFrame.setTitle("Owner Login");
            menuLabel.setText("Owner Login");
            contentPane.removeAll();
            contentPane.setLayout(layout);

            removeListeners(loginButton, loginButton.getActionListeners());
            loginButton.addActionListener(new managerLoginButtonListener());

            removeListeners(backButton, backButton.getActionListeners());
            backButton.addActionListener(emp_ownBack);
            backButton.setText("Back");

            contentPane.add(loginButton);
            contentPane.add(backButton);
            contentPane.add(menuLabel);
            contentPane.add(passwordLabel);
            contentPane.add(passwordTextField);
        
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, menuLabel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
            layout.putConstraint(SpringLayout.NORTH, menuLabel, 12, SpringLayout.NORTH, contentPane);

            layout.putConstraint(SpringLayout.NORTH, passwordTextField, 6, SpringLayout.SOUTH, menuLabel);
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, passwordTextField, 0, SpringLayout.HORIZONTAL_CENTER, menuLabel);
    
            layout.putConstraint(SpringLayout.NORTH, passwordLabel, 0, SpringLayout.NORTH, passwordTextField);
            layout.putConstraint(SpringLayout.EAST, passwordLabel, -6, SpringLayout.WEST, passwordTextField);
            
            layout.putConstraint(SpringLayout.EAST, loginButton, -6, SpringLayout.HORIZONTAL_CENTER, menuLabel);
            layout.putConstraint(SpringLayout.NORTH, loginButton, 6, SpringLayout.SOUTH, passwordTextField);

            layout.putConstraint(SpringLayout.WEST, backButton, 6, SpringLayout.HORIZONTAL_CENTER, menuLabel);
            layout.putConstraint(SpringLayout.NORTH, backButton, 6, SpringLayout.SOUTH, passwordTextField);
            mainFrame.setVisible(true);
        }
        
    }

    private class managerLoginButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(String.valueOf(passwordTextField.getPassword()).equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Please ensure that the password is entered!",//Pane displayed when all 
                "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }else if(notCredentials(String.valueOf(passwordTextField.getPassword()))){
                JOptionPane.showMessageDialog(new JFrame(), "The password or username is invalid",//Pane displayed when all 
                "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(new JFrame(), "Welcome",//Pane displayed when all 
                "Successful Login", JOptionPane.WARNING_MESSAGE);
                passwordTextField.setText("");
                setOwnerMenu();
            }
        }

    }

    private class menuBack implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setLoginFrame();
            
        }
        
    }

    private class employeeMenuBack_ownerMenuBack implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setMainMenu();
            
        }
        
    }

    private class customerDataButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }

    private class manageInventoryButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ManageInventory();
            
        }
        
    }

    private class manageEmployeeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new EmployeeMngScreen(employees);
            
        }
        
    }

    private class orderButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            OrderorDeleteJFrame odmenu = new OrderorDeleteJFrame();
            odmenu.show();
        }
    }
}