public class GUI {
    public class GUIproject {
    public static void main(String[] args) {
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
        JButton exportBtn = new JButton();
        JButton submitBtn = new JButton();
        JButton cancelBtn = new JButton();
        JTextField nameField= new JTextField(" ", 25);
        JTextField quantityField= new JTextField(" ", 25);
        JTextField priceField= new JTextField(" ", 25);
        JTextField f_aFeld= new JTextField(" ", 25);
        addBtn.setText("Add Faulty Items");
        deleteBtn.setText("Delete Faulty Items");
        exportBtn.setText("Export Faulty List");
        submitBtn.setText("Submit");
        cancelBtn.setText("Cancel");

        //Adding color to buttons
        addBtn.setBackground(new Color(32, 178, 170));
        deleteBtn.setBackground(new Color(255, 8, 56));
        exportBtn.setBackground(new Color(255, 213, 132));
        submitBtn.setBackground(new Color(72, 218, 10));
        cancelBtn.setBackground(new Color(255, 8, 56));

        //Add buttons and Fields to panels

        c.insets= new Insets(10,25,0,15);
        panel.add(addBtn);
        panel.add(deleteBtn);
        panel.add(exportBtn);
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
        panel.add(submitBtn,c);
        c.gridx= 1;
        c.gridy= 7;
        panel.add(cancelBtn,c);
        window.add(panel);
        window.setSize(750, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
