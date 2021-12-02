import javax.lang.model.element.Name;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.NumberFormat;
import java.time.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;


public class GUIproject {
    public static void main(String[] args) throws IOException {
        //Creating panels, buttons and labels
        JFrame window = new JFrame("Remove Faulty Items");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c= new GridBagConstraints();
        JLabel nameLabel= new JLabel("Enter item name: ");
        JLabel quantityLabel = new JLabel("Enter quantity of item: ");
        JLabel priceLabel = new JLabel("Enter price of item: ");
        JLabel faulty_amountLabel  = new JLabel("Enter amount of faulty item: ");
        JButton addBtn = new JButton();
        JButton deleteBtn = new JButton();


//      ### Formatter for Quantity and Faulty AMount
        NumberFormat format1 = NumberFormat.getInstance();
        NumberFormatter formatter1 = new NumberFormatter(format1);
        formatter1.setValueClass(Integer.class);
        formatter1.setMinimum(0);
        formatter1.setMaximum(Integer.MAX_VALUE);
        formatter1.setAllowsInvalid(false);

        // If you want the value to be committed on each keystroke instead of focus lost
        formatter1.setCommitsOnValidEdit(true);
        JFormattedTextField quantityField = new JFormattedTextField(formatter1);
        JFormattedTextField f_aFeld = new JFormattedTextField(formatter1);
        JFormattedTextField priceField = new JFormattedTextField(formatter1);
        priceField.setColumns(25);
        quantityField.setColumns(25);
        f_aFeld.setColumns(25);

        JTextField nameField= new JTextField(" ", 25);
        addBtn.setText("Add Faulty Items");
        deleteBtn.setText("Back to Menu");

        //Adding color to buttons
        addBtn.setBackground(new Color(255, 213, 132));
        deleteBtn.setBackground(new Color(255, 8, 56));

        //Add buttons and Fields to panels

        c.insets= new Insets(10,25,0,15);
//        panel.add(exportBtn);
        c.gridx= 0;
        c.gridy=2;
        panel.add(nameLabel,c);
        c.gridx= 1;
        c.gridy=2 ;
        panel.add(nameField,c);
        c.gridx= 0;
        c.gridy=3;
        panel.add(quantityLabel,c);
        c.gridx= 1;
        c.gridy= 3;
        panel.add(quantityField,c);
        c.gridx= 0;
        c.gridy= 4;
        panel.add(priceLabel,c);
        c.gridx= 1;
        c.gridy= 4;
        panel.add(priceField,c);
        c.gridx= 0;
        c.gridy= 5;
        panel.add(faulty_amountLabel,c);
        c.gridx= 1;
        c.gridy= 5;
        panel.add(f_aFeld,c);
        c.gridx= 1;
        c.gridy= 6;
        panel.add(addBtn);
        panel.add(deleteBtn);
        window.add(panel);
        window.setSize(750, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        BufferedWriter bw = new BufferedWriter(new FileWriter("FaultyItem.txt"));
        ArrayList<String> faultytxt= new ArrayList<>();

        //Add action listeners
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            { Boolean click=true;
                try{
                bw.write(String.valueOf(LocalDate.now()));
                bw.write(" Faulty Inventory for the Date");
                faultytxt.add(nameField.getText());
                faultytxt.add(quantityField.getText());
                faultytxt.add(String.valueOf(Double.parseDouble(priceField.getText())));
                faultytxt.add(f_aFeld.getText());
                bw.newLine();
                bw.write(String.valueOf(faultytxt));
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
                f_aFeld.setText(" ");
                showMessageDialog(new JFrame(), "Item successfully added to Faulty List",//Pane displayed when all
                        "Process Successful", JOptionPane.WARNING_MESSAGE);
                bw.close();
            }catch(Exception ex){
                    showMessageDialog(new JFrame(), "Process Unsuccessful, Please try again",//Pane displayed when all
                            "Process Failed", JOptionPane.WARNING_MESSAGE);
            } click =true;}
        });
        // Add Action Listener to return to Menu
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }}
