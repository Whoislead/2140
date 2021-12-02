import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.NumberFormatter;




public class ManageInventory{

  JFrame InvenWindow = new JFrame("Update Inventory");  
  JPanel panel = new JPanel();

  JButton ad = new JButton("Add to Inventory");
  JButton del = new JButton("Remove from Inventory");
  JButton change = new JButton("Change Inventory Information ");
  JButton enter = new JButton("Submit");
  JButton exit = new JButton("Close");

  JLabel namelbl = new JLabel("Enter item name: ");  
  JLabel qtylbl = new JLabel("Enter item quantity: ");
  JLabel cstlbl = new JLabel("Enter price of item: ");
  JLabel prevlbl = new JLabel("Enter the data you would like to change: ");
  JLabel crntlbl = new JLabel("Enter the new data:  ");


  JTextField nametxt = new JTextField(25);
  JTextField qtytxt = new JTextField(15);
  JTextField csttxt = new JTextField(15);
  JTextField prevtxt = new JTextField(25);
  JTextField crnttxt = new JTextField(25);

  Inventory invty = new Inventory();



  ManageInventory(){

    panel.add(ad);
    panel.add(del);
    panel.add(change);
    panel.add(namelbl);
    panel.add(nametxt);
    panel.add(qtylbl);
    panel.add(qtytxt);
    panel.add(cstlbl);
    panel.add(csttxt);
    panel.add(prevlbl);
    panel.add(prevtxt);
    panel.add(crntlbl);
    panel.add(crnttxt);
    panel.add(enter);
    panel.add(exit);


    InvenWindow.add(panel);
    InvenWindow.setSize(750, 500);
    InvenWindow.setVisible(true);
    InvenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   

    ButtonListener myButtonListener = new ButtonListener();
    ad.addActionListener (myButtonListener);
    del.addActionListener (myButtonListener);
    change.addActionListener (myButtonListener);
    enter.addActionListener (myButtonListener);
    exit.addActionListener (myButtonListener);
       
  
  
  }

  public class ButtonListener implements ActionListener{
    String n =  nametxt.getText();
    public void actionPerformed(ActionEvent evnt) {
      Object Source = evnt.getSource(); 
      if (Source == ad){
        String a =  nametxt.getText();
        int b = Integer.parseInt(qtytxt.getText());
        double c = Double.parseDouble(csttxt.getText());
        

        if (invty.addItem(a, b, c)){
          JOptionPane.showMessageDialog(new JFrame(),"Successfully Updated!", "Unsuccessful",JOptionPane.WARNING_MESSAGE);  
        }
      }else if (Source == del){
        
       
        if (invty.removeItem(n)){
          JOptionPane.showMessageDialog(new JFrame(),"Deletion Completed!","Unsuccessful",JOptionPane.WARNING_MESSAGE); 
        }

      }else if (Source == change){
        String m = prevtxt.getText();
        String o = crnttxt.getText();

        if (invty.removeItem(n)){
          JOptionPane.showMessageDialog(new JFrame(),"Update Completed!","Unsuccessful",JOptionPane.WARNING_MESSAGE);
        } 

      }
    }

  }

     
}

// public class GUIproject {
//     public static void main(String[] args) throws IOException {
//         //Creating panels, buttons and labels
//         JFrame window = new JFrame("Remove Faulty Items");
//         JPanel panel = new JPanel();
//         panel.setLayout(new GridBagLayout());
//         GridBagConstraints c= new GridBagConstraints();
//         JLabel nameLabel= new JLabel("Enter item name: ");
//         JLabel quantityLabel = new JLabel("Enter quantity of item: ");
//         JLabel priceLabel = new JLabel("Enter price of item: ");
//         JLabel faulty_amountLabel  = new JLabel("Enter amount of faulty item: ");
//         JButton addBtn = new JButton();
//         JButton deleteBtn = new JButton();


// //      ### Formatter for Quantity and Faulty AMount
//         NumberFormat format1 = NumberFormat.getInstance();
//         NumberFormatter formatter1 = new NumberFormatter(format1);
//         formatter1.setValueClass(Integer.class);
//         formatter1.setMinimum(0);
//         formatter1.setMaximum(Integer.MAX_VALUE);
//         formatter1.setAllowsInvalid(false);

//         // If you want the value to be committed on each keystroke instead of focus lost
//         formatter1.setCommitsOnValidEdit(true);
//         JFormattedTextField quantityField = new JFormattedTextField(formatter1);
//         JFormattedTextField f_aFeld = new JFormattedTextField(formatter1);
//         JFormattedTextField priceField = new JFormattedTextField(formatter1);
//         priceField.setColumns(25);
//         quantityField.setColumns(25);
//         f_aFeld.setColumns(25);

//         JTextField nameField= new JTextField(" ", 25);
//         addBtn.setText("Add Faulty Items");
//         deleteBtn.setText("Back to Menu");

//         //Adding color to buttons
//         addBtn.setBackground(new Color(255, 213, 132));
//         deleteBtn.setBackground(new Color(255, 8, 56));

//         //Add buttons and Fields to panels

//         c.insets= new Insets(10,25,0,15);
// //        panel.add(exportBtn);
//         c.gridx= 0;
//         c.gridy=2;
//         panel.add(nameLabel,c);
//         c.gridx= 1;
//         c.gridy=2 ;
//         panel.add(nameField,c);
//         c.gridx= 0;
//         c.gridy=3;
//         panel.add(quantityLabel,c);
//         c.gridx= 1;
//         c.gridy= 3;
//         panel.add(quantityField,c);
//         c.gridx= 0;
//         c.gridy= 4;
//         panel.add(priceLabel,c);
//         c.gridx= 1;
//         c.gridy= 4;
//         panel.add(priceField,c);
//         c.gridx= 0;
//         c.gridy= 5;
//         panel.add(faulty_amountLabel,c);
//         c.gridx= 1;
//         c.gridy= 5;
//         panel.add(f_aFeld,c);
//         c.gridx= 1;
//         c.gridy= 6;
//         panel.add(addBtn);
//         panel.add(deleteBtn);
//         window.add(panel);
//         window.setSize(750, 500);
//         window.setLocationRelativeTo(null);
//         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         window.setVisible(true);
//         BufferedWriter bw = new BufferedWriter(new FileWriter("FaultyItem.txt"));
//         ArrayList<String> faultytxt= new ArrayList<>();

//         //Add action listeners
//         addBtn.addActionListener(new ActionListener(){
//             @Override
//             public void actionPerformed(ActionEvent e)
//             { Boolean click=true;
//                 try{
//                 bw.write(String.valueOf(LocalDate.now()));
//                 bw.write(" Faulty Inventory for the Date");
//                 faultytxt.add(nameField.getText());
//                 faultytxt.add(quantityField.getText());
//                 faultytxt.add(String.valueOf(Double.parseDouble(priceField.getText())));
//                 faultytxt.add(f_aFeld.getText());
//                 bw.newLine();
//                 bw.write(String.valueOf(faultytxt));
//                 nameField.setText("");
//                 priceField.setText("");
//                 quantityField.setText("");
//                 f_aFeld.setText(" ");
//                 JOptionPane.showMessageDialog(new JFrame(), "Item successfully added to Faulty List",//Pane displayed when all
//                         "Process Successful", JOptionPane.WARNING_MESSAGE);
//                 bw.close();
//             }catch(Exception ex){
//                 JOptionPane.showMessageDialog(new JFrame(), "Process Unsuccessful, Please try again",//Pane displayed when all
//                             "Process Failed", JOptionPane.WARNING_MESSAGE);
//             } click =true;}
//         });
//         // Add Action Listener to return to Menu
//         deleteBtn.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {

//             }
//         });
//     }
// }