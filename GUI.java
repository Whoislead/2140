import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUI{
    private JFrame mainFrame = new JFrame();

    private JButton loginButton = new JButton("Login");
    private JButton orderButton = new JButton("Order");
    private JButton customerDataButton = new JButton("<html><center>"+"Customer Date"+"<br>"+"Collection"+"</center></html>");
    private JButton addInventoryButton = new JButton("Add To Inventory");
    private JButton deleteInventoryButton = new JButton("Delete From Inventory");
    private JButton addEmployeeButton = new JButton("Add Employee");
    private JButton removeEmployeeButton = new JButton("Remove Employee");
    private JButton employeeButton = new JButton("Employee");
    private JButton ownerButton = new JButton("Owner");
    private JButton backButton = new JButton("Back");

    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel menuLabel = new JLabel();

    private SpringLayout layout = new SpringLayout();

    private Container contentPane = mainFrame.getContentPane();

    private JTextField usernameTextField = new JTextField(15);
    private JPasswordField passwordTextField = new JPasswordField(15);

    private String passwordString;
    private String usernameString;
    private String defaultData = "Enter input here!";

    menuBack mBack = new menuBack();

    employeeMenuBack_ownerMenuBack emp_ownBack = new employeeMenuBack_ownerMenuBack();

    GUI(){
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        contentPane.setLayout(layout);

        loginButton.addActionListener(new loginButtonListener());
        employeeButton.addActionListener(new employeeButtonListener());
        ownerButton.addActionListener(new ownerButtonListener());
        // customerDataButton.addActionListener(l);
        // addInventoryButton.addActionListener(l);
        // addEmployeeButton.addActionListener(l);
        // deleteInventoryButton.addActionListener(l);
        // removeEmployeeButton.addActionListener(l);

        setLoginFrame();   
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
        contentPane.removeAll();
        contentPane.setLayout(layout);
        contentPane.add(loginButton);
        contentPane.add(usernameLabel);
        contentPane.add(passwordLabel);
        contentPane.add(usernameTextField);
        contentPane.add(passwordTextField);

        contentPane.validate();

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
        contentPane.add(addInventoryButton);
        contentPane.add(removeEmployeeButton);
        contentPane.add(addEmployeeButton);
        contentPane.add(deleteInventoryButton);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, menuLabel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, menuLabel, 12, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, addInventoryButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.EAST, addInventoryButton, -6, SpringLayout.WEST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, deleteInventoryButton, 6, SpringLayout.SOUTH, menuLabel);
        layout.putConstraint(SpringLayout.WEST, deleteInventoryButton, 6, SpringLayout.EAST, menuLabel);

        layout.putConstraint(SpringLayout.NORTH, addEmployeeButton, 6, SpringLayout.SOUTH, addInventoryButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, addEmployeeButton, 0, SpringLayout.HORIZONTAL_CENTER, addInventoryButton);

        layout.putConstraint(SpringLayout.NORTH, removeEmployeeButton, 6, SpringLayout.SOUTH, deleteInventoryButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, removeEmployeeButton, 0, SpringLayout.HORIZONTAL_CENTER, deleteInventoryButton);

        layout.putConstraint(SpringLayout.NORTH, backButton, 12, SpringLayout.SOUTH, removeEmployeeButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backButton, 0, SpringLayout.HORIZONTAL_CENTER, menuLabel);

        mainFrame.setVisible(true);
    }

    private class loginButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // if(usernameTextField.getText().equals("") || String.valueOf(passwordTextField.getPassword()).equals("")){
            //     JOptionPane.showMessageDialog(new JFrame(), "Please ensure all test field are filled!",//Pane displayed when all 
            //     "Invalid Input", JOptionPane.WARNING_MESSAGE);
            // }else if(!usernameTextField.getText().equals("Testusername") || 
            //         !String.valueOf(passwordTextField.getPassword()).equals("Testpassword")){
            //     JOptionPane.showMessageDialog(new JFrame(), "The password or username is invalid",//Pane displayed when all 
            //     "Invalid Input", JOptionPane.WARNING_MESSAGE);
            // }else{
            //     JOptionPane.showMessageDialog(new JFrame(), "Welcome *User's name or username will be displayed here*",//Pane displayed when all 
            //     "Successful Login", JOptionPane.WARNING_MESSAGE);
            // }
            setMainMenu();
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
            setOwnerMenu();
            
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

    private class addInventoryButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }

    private class addEmployeeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }

    private class deleteInventoryButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }

    private class removeEmployeeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }
}