package traveltourism.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel usernameLabel2, nameLabel2;
    JComboBox comboId;
    JTextField numberTf, countryTf, addressTf,emailTf,phoneTf;

    JRadioButton male, female;

    JButton add, back;
    AddCustomer(String username){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30,50,150,25);
        add(usernameLabel);

        usernameLabel2 = new JLabel();
        usernameLabel2.setBounds(220,50,150,25);
        add(usernameLabel2);// we are making label for username instead of text field because
        // we want it to be uneditable and text field is editable

        JLabel idLabel = new JLabel("Id");
        idLabel.setBounds(30,90,150,25);
        add(idLabel);

        comboId = new JComboBox(new String[] {"Passport","Aadhaar Card","Pan Card","Ration Card"});
        comboId.setBounds(220,90,150,25);
        comboId.setBackground(Color.white);
        add(comboId);

        JLabel numberLabel = new JLabel("Id number");
        numberLabel.setBounds(30,130,150,25);
        add(numberLabel);

        numberTf = new JTextField();
        numberTf.setBounds(220,130,150,25);
        add(numberTf);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30,170,150,25);
        add(nameLabel);

        nameLabel2 = new JLabel();
        nameLabel2.setBounds(220,170,150,25);
        add(nameLabel2);// we are making label for username instead of text field because
        // we want it to be uneditable and text field is editable and JLabel is not editable

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(30,210,150,25);
        add(genderLabel);

        male = new JRadioButton("Male");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300,210,70,25);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg = new ButtonGroup(); // Button group will allow to only select one item at a time
        bg.add(male);
        bg.add(female);

        JLabel countryLabel = new JLabel("Country");
        countryLabel.setBounds(30,250,150,25);
        add(countryLabel);

        countryTf = new JTextField();
        countryTf.setBounds(220,250,150,25);
        add(countryTf);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(30,290,150,25);
        add(addressLabel);

        addressTf = new JTextField();
        addressTf.setBounds(220,290,150,25);
        add(addressTf);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(30,330,150,25);
        add(emailLabel);

        emailTf = new JTextField();
        emailTf.setBounds(220,330,150,25);
        add(emailTf);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(30,370,150,25);
        add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(220,370,150,25);
        add(phoneTf);

        add =new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet resultSet= c.statement.executeQuery("select * from account where username = '"+username+"'");
            while(resultSet.next()){
                usernameLabel2.setText(resultSet.getString("username"));
                nameLabel2.setText(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String username = usernameLabel2.getText();
            String id = (String)comboId.getSelectedItem();// we are type casting in String because we cannot store it
            // in String as it returns object
            String number = numberTf.getText();
            String name = nameLabel2.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            String country = countryTf.getText();
            String address = addressTf.getText();
            String phone = phoneTf.getText();
            String email = emailTf.getText();

            try{
                Conn c = new Conn();
                String query = "insert into customer values ('"+username+"','"+id+"','"+number+"','"+name+"'," +
                        "'"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details added Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("Amritpal");
    }
}
