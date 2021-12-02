import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.awt.GridBagConstraints;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import org.w3c.dom.Text;

public class ManageInventory{

  JFrame InvenWindow = new JFrame("Update Inventory");  
  JPanel panel = new JPanel();

  JButton ad = new JButton("Add to Inventory");
  JButton del = new JButton("Remove from Inventory");
  JButton change = new JButton("Change Inventory Information ");
  JButton enter = new JButton("Submit");
  JButton faultyBtn = new JButton("Add Faulty Inventory");
  JButton exit = new JButton("Close");

  JLabel namelbl = new JLabel("Enter item name: ");  
  JLabel qtylbl = new JLabel("Enter item quantity: ");
  JLabel cstlbl = new JLabel("Enter price of item: ");
  JLabel prevlbl = new JLabel("Enter the data you would like to change: ");
  JLabel crntlbl = new JLabel("Enter the new data:  ");

  GridBagConstraints c = new GridBagConstraints();

  JTextField nametxt = new JTextField(25);
  JTextField qtytxt = new JTextField(25);
  JTextField csttxt = new JTextField(25);
  JTextField prevtxt = new JTextField(25);
  JTextField crnttxt = new JTextField(25);

  Inventory invty = new Inventory();

  ManageInventory(){
    panel.setLayout(new GridBagLayout());

    ad.setBackground(new Color(32, 178,170));
    del.setBackground(new Color(255, 8, 56));
    change.setBackground(new Color(32, 178,170));
    enter.setBackground(new Color(232, 175,70));
    exit.setBackground(new Color(255, 8, 56));
    faultyBtn.setBackground(new Color(232, 175,70));
    c.insets = new Insets(10, 25, 0, 15);
    panel.add(ad);
    panel.add(del);
    panel.add(change);
    c.gridx = 0;
    c.gridy = 2;
    panel.add(namelbl,c);
    c.gridx = 1;
    c.gridy = 2;
    panel.add(nametxt,c);
    c.gridx = 0;
    c.gridy = 3;
    panel.add(qtylbl,c);
    c.gridx = 1;
    c.gridy = 3;
    panel.add(qtytxt,c);
    c.gridx = 0;
    c.gridy = 4;
    panel.add(cstlbl,c);
    c.gridx = 1;
    c.gridy = 4;
    panel.add(csttxt,c);
    c.gridx = 0;
    c.gridy = 5;
    panel.add(prevlbl,c);
    c.gridx = 1;
    c.gridy = 5;
    panel.add(prevtxt,c);
    c.gridx = 0;
    c.gridy = 6;
    panel.add(crntlbl,c);
    c.gridx = 1;
    c.gridy = 6;
    panel.add(crnttxt,c);
    c.gridx = 0;
    c.gridy = 7;
    panel.add(enter,c);
    c.gridx = 1;
    c.gridy = 7;
    panel.add(exit,c);
    c.gridx = 1;
    c.gridy = 8;
    panel.add(faultyBtn,c);
    c.gridx= 1;
    c.gridy= 9;

    InvenWindow.add(panel);
    InvenWindow.setSize(1000, 500);
    InvenWindow.setLocationRelativeTo(null);
    InvenWindow.setVisible(true);
    InvenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   
    nametxt.setText("");
    qtytxt.setText("");
    csttxt.setText("");
    prevtxt.setText("");
    crnttxt.setText("");

    ButtonListener myButtonListener = new ButtonListener();
    ad.addActionListener (myButtonListener);
    del.addActionListener (myButtonListener);
    change.addActionListener (myButtonListener);
    enter.addActionListener (myButtonListener);
    faultyBtn.addActionListener(myButtonListener);
    exit.addActionListener (myButtonListener);
       
  }

  private class ButtonListener implements ActionListener{
    String n =  nametxt.getText();
    public void actionPerformed(ActionEvent evnt) {
      Object Source = evnt.getSource(); 
      if (Source == ad){
        if(nametxt.getText().equals("") || qtytxt.getText().equals("") || csttxt.getText().equals("")){
          JOptionPane.showMessageDialog(new JFrame(),"Please ensure all text fields are filled", "Unsuccessful",JOptionPane.WARNING_MESSAGE);
        }else{
          String a =  nametxt.getText();
          int b = Integer.parseInt(qtytxt.getText());
          double c = Double.parseDouble(csttxt.getText());
          
          if (invty.addItem(a, b, c)){
            JOptionPane.showMessageDialog(new JFrame(),"Successfully Updated!", "Unsuccessful",JOptionPane.WARNING_MESSAGE);  
          }
          namelbl.setText("");
          qtylbl.setText("");
          cstlbl.setText("");

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

      }else if(Source == exit){
        InvenWindow.dispose();
      }else if(Source == faultyBtn){
          new FaultyItems();
      }
    }
  }    
}