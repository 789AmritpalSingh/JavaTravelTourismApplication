package traveltourism.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JLabel usernameDetailLabel,hotelNameLabel,numberOfTotalPerson,daysDetailLabel,acDetailLabel, idNameLabel,idNumberDetailLabel,
            phoneNumberLabel,priceDetailLabel,foodDetailLabel;
    JButton back;
    String username;
    ViewBookedHotel(String username){
        this.username = username;

        setBounds(400,200,1000,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("View Booked Hotel Details");
        text.setFont(new Font("Arial",Font.BOLD,20));
        text.setBounds(60,0,400,30);
        add(text);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30,50,150,25);
        add(usernameLabel);

        usernameDetailLabel = new JLabel();
        usernameDetailLabel.setBounds(220,50,150,25);
        add(usernameDetailLabel);

        JLabel hotelLabel = new JLabel("Hotel Name");
        hotelLabel.setBounds(30,90,150,25);
        add(hotelLabel);

        hotelNameLabel = new JLabel();
        hotelNameLabel.setBounds(220,90,150,25);
        add(hotelNameLabel);

        JLabel totalPersonLabel = new JLabel("Total Persons");
        totalPersonLabel.setBounds(30,130,150,25);
        add(totalPersonLabel);

        numberOfTotalPerson = new JLabel();
        numberOfTotalPerson.setBounds(220,130,150,25);
        add(numberOfTotalPerson);

        JLabel daysLabel = new JLabel("Total Days");
        daysLabel.setBounds(30,170,150,25);
        add(daysLabel);

        daysDetailLabel = new JLabel();
        daysDetailLabel.setBounds(220,170,150,25);
        add(daysDetailLabel);

        JLabel acLabel = new JLabel("AC/Non AC");
        acLabel.setBounds(30,210,150,25);
        add(acLabel);

        acDetailLabel = new JLabel();
        acDetailLabel.setBounds(220,210,150,25);
        add(acDetailLabel);

        JLabel foodLabel = new JLabel("Food Included?");
        foodLabel.setBounds(30,250,150,25);
        add(foodLabel);

        foodDetailLabel = new JLabel();
        foodDetailLabel.setBounds(220,250,150,25);
        add(foodDetailLabel);

        JLabel idLabel = new JLabel("Id");
        idLabel.setBounds(30,290,150,25);
        add(idLabel);

        idNameLabel = new JLabel();
        idNameLabel.setBounds(220,290,150,25);
        add(idNameLabel);

        JLabel idNumberLabel = new JLabel("Id Number");
        idNumberLabel.setBounds(30,330,150,25);
        add(idNumberLabel);

        idNumberDetailLabel = new JLabel();
        idNumberDetailLabel.setBounds(220,330,150,25);
        add(idNumberDetailLabel);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(30,370,150,25);
        add(phoneLabel);

        phoneNumberLabel = new JLabel();
        phoneNumberLabel.setBounds(220,370,150,25);
        add(phoneNumberLabel);

        JLabel priceLabel = new JLabel("Total Cost");
        priceLabel.setBounds(30,410,150,25);
        add(priceLabel);

        priceDetailLabel = new JLabel();
        priceDetailLabel.setBounds(220,410,150,25);
        add(priceDetailLabel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(130,460,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet resultSet = c.statement.executeQuery(query);

            while(resultSet.next()){
                usernameDetailLabel.setText(resultSet.getString("username"));
                idNameLabel.setText(resultSet.getString("id"));
                idNumberDetailLabel.setText(resultSet.getString("number"));
                hotelNameLabel.setText(resultSet.getString("name"));
                priceDetailLabel.setText(resultSet.getString("price"));
                phoneNumberLabel.setText(resultSet.getString("phone"));
                numberOfTotalPerson.setText(resultSet.getString("persons"));
                foodDetailLabel.setText(resultSet.getString("food"));
                acDetailLabel.setText(resultSet.getString("ac"));
                daysDetailLabel.setText(resultSet.getString("days"));

            }
        }catch (Exception e){
        }

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
    public static void main(String[] args) {
        new ViewBookedHotel("Amritpal");
    }
}
