package traveltourism.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomerPersonalDetails extends JFrame implements ActionListener {

    JLabel usernameLabel2, nameLabel2;
    JComboBox comboId;
    JTextField idTf,numberTf, countryTf, addressTf,emailTf,phoneTf, genderTf;

    JRadioButton male;

    JButton add, back;
    UpdateCustomerPersonalDetails(String username) {
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Arial", Font.PLAIN, 20));
        add(text);

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

        idTf = new JTextField();
        idTf.setBounds(220,90,150,25);
        add(idTf);

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

        genderTf = new JTextField();
        genderTf.setBounds(220,210,150,25);
        add(genderTf);

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

        add =new JButton("Update");
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,100,200,350);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet resultSet= c.statement.executeQuery("select * from customer where username = '"+username+"'");
            while(resultSet.next()){
                usernameLabel2.setText(resultSet.getString("username"));
                nameLabel2.setText(resultSet.getString("name"));
                idTf.setText(resultSet.getString("id"));
                numberTf.setText(resultSet.getString("number"));
                genderTf.setText(resultSet.getString("gender"));
                countryTf.setText(resultSet.getString("country"));
                addressTf.setText(resultSet.getString("address"));
                phoneTf.setText(resultSet.getString("phone"));
                emailTf.setText(resultSet.getString("email"));
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
            String id = idTf.getText();// we are type casting in String because we cannot store it
            // in String as it returns object
            String number = numberTf.getText();
            String name = nameLabel2.getText();
            String gender = genderTf.getText();
            String country = countryTf.getText();
            String address = addressTf.getText();
            String phone = phoneTf.getText();
            String email = emailTf.getText();

            try{
                Conn c = new Conn();
                String query = "update customer set username= '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = " +
                        "'"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateCustomerPersonalDetails("Amritpal");
    }
}
