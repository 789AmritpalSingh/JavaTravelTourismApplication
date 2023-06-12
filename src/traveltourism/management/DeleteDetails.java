package traveltourism.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {

    JLabel usernameDetailLabel,idDetailLabel,idNumberDetailLabel, nameLabelDetail,genderDetailLabel,
            countryDetailLabel,addressLabelDetail, phoneLabelDetail,emailDetailLabel;
    JButton delete;
    String username;
    DeleteDetails(String username){
        this.username = username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30,50,150,25);
        add(usernameLabel);

        usernameDetailLabel = new JLabel();
        usernameDetailLabel.setBounds(220,50,150,25);
        add(usernameDetailLabel);

        JLabel idLabel = new JLabel("Id");
        idLabel.setBounds(30,110,150,25);
        add(idLabel);

        idDetailLabel = new JLabel();
        idDetailLabel.setBounds(220,110,150,25);
        add(idDetailLabel);

        JLabel idNumberLabel = new JLabel("Id Number");
        idNumberLabel.setBounds(30,170,150,25);
        add(idNumberLabel);

        idNumberDetailLabel = new JLabel();
        idNumberDetailLabel.setBounds(220,170,150,25);
        add(idNumberDetailLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30,230,150,25);
        add(nameLabel);

        nameLabelDetail = new JLabel();
        nameLabelDetail.setBounds(220,230,150,25);
        add(nameLabelDetail);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(30,290,150,25);
        add(genderLabel);

        genderDetailLabel = new JLabel();
        genderDetailLabel.setBounds(220,290,150,25);
        add(genderDetailLabel);

        JLabel countryLabel = new JLabel("Country");
        countryLabel.setBounds(500,50,150,25);
        add(countryLabel);

        countryDetailLabel = new JLabel();
        countryDetailLabel.setBounds(690,50,150,25);
        add(countryDetailLabel);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(500,110,150,25);
        add(addressLabel);

        addressLabelDetail = new JLabel();
        addressLabelDetail.setBounds(690,110,150,25);
        add(addressLabelDetail);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(500,170,150,25);
        add(phoneLabel);

        phoneLabelDetail = new JLabel();
        phoneLabelDetail.setBounds(690,170,150,25);
        add(phoneLabelDetail);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(500,230,150,25);
        add(emailLabel);

        emailDetailLabel = new JLabel();
        emailDetailLabel.setBounds(690,230,150,25);
        add(emailDetailLabel);

        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        delete.setBounds(350,350,100,25);
        delete.addActionListener(this);
        add(delete);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600,400,600,200);
        add(image2);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet resultSet = c.statement.executeQuery(query);

            while(resultSet.next()){
                usernameDetailLabel.setText(resultSet.getString("username"));
                idDetailLabel.setText(resultSet.getString("id"));
                idNumberDetailLabel.setText(resultSet.getString("number"));
                nameLabelDetail.setText(resultSet.getString("name"));
                genderDetailLabel.setText(resultSet.getString("gender"));
                countryDetailLabel.setText(resultSet.getString("country"));
                addressLabelDetail.setText(resultSet.getString("address"));
                phoneLabelDetail.setText(resultSet.getString("phone"));
                emailDetailLabel.setText(resultSet.getString("email"));

            }
        }catch (Exception e){
        }

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Conn c = new Conn();
            c.statement.executeUpdate("delete from account where username = '"+username+"' ");
            c.statement.executeUpdate("delete from customer where username = '"+username+"' ");
            c.statement.executeUpdate("delete from bookpackage where username = '"+username+"' ");
            c.statement.executeUpdate("delete from bookhotel where username = '"+username+"' ");

            JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
            System.exit(0);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new DeleteDetails("");
    }
}
