import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class GUI {

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



  GUI(){

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
        String n =  nametxt.getText();
       
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
