import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JOptionPane;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUI{

    private ArrayList<JTextField> textFields = new ArrayList<>();

    private JFrame mainFrame = new JFrame();

    private JPanel buttonPanel = new JPanel();
    
    private JButton loginButton = new JButton("Login");

    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");

    private Container contentPane = mainFrame.getContentPane();

    private JTextField usernameTextField = new JTextField(15);
    private JPasswordField passwordTextField = new JPasswordField(15);

    private String passwordString;
    private String usernameString;
    private String defaultData = "Enter input here!";

    GUI(){
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginButton.addActionListener(new loginButtonListener());

        textFields.add(usernameTextField);
        textFields.add(passwordTextField);

        textHider tHider = new textHider();

        usernameTextField.addFocusListener(tHider);
        passwordTextField.addFocusListener(tHider);

        setLoginFrame();   
    }

    private void setLoginFrame(){
        setLoginPane();
        mainFrame.setTitle("Login");
        mainFrame.setSize(240, 135);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setContentPane(contentPane);
        mainFrame.setVisible(true);
    }

    private void setLoginPane(){
        SpringLayout layout = new SpringLayout();

        setLoginPanelButtons();

        contentPane.removeAll();
        contentPane.setLayout(layout);
        contentPane.add(buttonPanel);
        contentPane.add(usernameLabel);
        contentPane.add(passwordLabel);
        contentPane.add(usernameTextField);
        contentPane.add(passwordTextField);

        contentPane.validate();

        layout.putConstraint(SpringLayout.NORTH, usernameLabel, 6, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, usernameLabel, 6, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 0, SpringLayout.NORTH, usernameLabel);
        layout.putConstraint(SpringLayout.WEST, usernameTextField, 6, SpringLayout.EAST, usernameLabel);

        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 12, SpringLayout.SOUTH, usernameLabel);
        layout.putConstraint(SpringLayout.WEST, passwordLabel, 0, SpringLayout.WEST, usernameLabel);

        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 12, SpringLayout.SOUTH, usernameLabel);
        layout.putConstraint(SpringLayout.WEST, passwordTextField, 0, SpringLayout.WEST, usernameTextField);
        
        layout.putConstraint(SpringLayout.WEST, buttonPanel, 30, SpringLayout.WEST, passwordTextField);
        layout.putConstraint(SpringLayout.NORTH, buttonPanel, 6, SpringLayout.SOUTH, passwordTextField);
    }

    private void setLoginPanelButtons(){
        buttonPanel.add(loginButton);
    }

    public void setMainFrame() {
        mainFrame.setTitle("Hardware Management System");
        mainFrame.setSize(960, 540);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    //As more text fields are added, add them to the textHider class

    private class loginButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(usernameTextField.getText().equals("") || String.valueOf(passwordTextField.getPassword()).equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Please ensure all test field are filled!",//Pane displayed when all 
                "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }else if(!usernameTextField.getText().equals("Testusername") || 
                    !String.valueOf(passwordTextField.getPassword()).equals("Testpassword")){
                JOptionPane.showMessageDialog(new JFrame(), "The password or username is invalid",//Pane displayed when all 
                "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "Welcome *User's name or username will be displayed here*",//Pane displayed when all 
                "Successful Login", JOptionPane.WARNING_MESSAGE);
            }
        } 
    }

    private class textHider implements FocusListener{

        JTextField src = new JTextField();

        @Override
        public void focusGained(FocusEvent event){
            src = (JTextField)event.getSource();
            if(src.getText().equals(defaultData)){
                for(JTextField field:textFields){
                    if(src == field){
                        field.setText("");
                    }
                }
            }
        }

        @Override
        public void focusLost(FocusEvent event) {
            src = (JTextField)event.getSource();
            if(src.getText().equals("")){
                for(JTextField field:textFields){
                    if(src == field){
                        field.setText(defaultData);
                    }
                }
            }
        } 
    }
}