package traveltourism.management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//Class to book the package , i.e. gold, silver or bronze package
public class BookHotel extends JFrame implements ActionListener {

    JLabel usernameDetailLabel, idNameLabel, idNumberDetailLabel, phoneNumberDetailLabel,
            totalPriceDetailLabel;
    Choice choiceHotel, choiceAc, choiceFood;

    JButton checkPrice, bookHotel, back;
    JTextField personTf, daysTf;
    String username;

    BookHotel(String username) {
        this.username = username;

        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40, 70, 100, 20);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(usernameLabel);

        usernameDetailLabel = new JLabel();
        usernameDetailLabel.setBounds(250, 70, 200, 20);
        add(usernameDetailLabel);

        JLabel selectPackageLabel = new JLabel("Select Hotel");
        selectPackageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        selectPackageLabel.setBounds(40, 110, 150, 20);
        add(selectPackageLabel);

        choiceHotel = new Choice();
        choiceHotel.setBounds(250, 110, 200, 20);
        add(choiceHotel);

        try { // instead of hardcoding the hotel names, we have stored them in the database
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from hotel");
            while (rs.next()) {
                choiceHotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel totalPersonsLabel = new JLabel("Total Persons");
        totalPersonsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        totalPersonsLabel.setBounds(40, 150, 150, 25);
        add(totalPersonsLabel);

        personTf = new JTextField("1");
        personTf.setBounds(250, 150, 200, 25);
        add(personTf);

        JLabel daysLabel = new JLabel("No. of Days");
        daysLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        daysLabel.setBounds(40, 190, 150, 25);
        add(daysLabel);

        daysTf = new JTextField("1");
        daysTf.setBounds(250, 190, 200, 25);
        add(daysTf);

        JLabel acLabel = new JLabel("AC/Non AC");
        acLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        acLabel.setBounds(40, 230, 150, 25);
        add(acLabel);

        choiceAc = new Choice();
        choiceAc.add("AC");
        choiceAc.add("Non AC");
        choiceAc.setBounds(250, 230, 200, 25);
        add(choiceAc);

        JLabel foodLabel = new JLabel("Food Included");
        foodLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        foodLabel.setBounds(40, 270, 150, 25);
        add(foodLabel);

        choiceFood = new Choice();
        choiceFood.add("Yes");
        choiceFood.add("No");
        choiceFood.setBounds(250, 270, 200, 25);
        add(choiceFood);

        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        idLabel.setBounds(40, 310, 150, 20);
        add(idLabel);

        idNameLabel = new JLabel();
        idNameLabel.setBounds(250, 310, 200, 25);
        add(idNameLabel);

        JLabel idNumberLabel = new JLabel("Id Number");
        idNumberLabel.setBounds(40, 350, 150, 25);
        idNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(idNumberLabel);

        idNumberDetailLabel = new JLabel();
        idNumberDetailLabel.setBounds(250, 350, 150, 25);
        add(idNumberDetailLabel);

        JLabel phoneNumberLabel = new JLabel("Phone");
        phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        phoneNumberLabel.setBounds(40, 390, 150, 20);
        add(phoneNumberLabel);

        phoneNumberDetailLabel = new JLabel();
        phoneNumberDetailLabel.setBounds(250, 390, 200, 25);
        add(phoneNumberDetailLabel);

        JLabel totalPriceLabel = new JLabel("Total Price");
        totalPriceLabel.setBounds(40, 430, 150, 25);
        totalPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalPriceLabel);

        totalPriceDetailLabel = new JLabel();
        totalPriceDetailLabel.setBounds(250, 430, 150, 25);
        add(totalPriceDetailLabel);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            while (resultSet.next()) {
                usernameDetailLabel.setText(resultSet.getString("username"));
                idNameLabel.setText(resultSet.getString("id"));
                idNumberDetailLabel.setText(resultSet.getString("number"));
                phoneNumberDetailLabel.setText(resultSet.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.white);
        checkPrice.setBounds(60, 490, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.white);
        bookHotel.setBounds(200, 490, 120, 25);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 600, 300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookHotel("Amritpal");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkPrice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery("select * from hotel where name='" + choiceHotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroomincluded"));

                    int persons = Integer.parseInt((personTf.getText()));
                    int days = Integer.parseInt(daysTf.getText());

                    String acSelected = choiceAc.getSelectedItem();
                    String foodSelected = choiceFood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acSelected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("Yes") ? food : 0;
                        total += cost; //cost is cost per person per day
                        total = total * persons * days;
                        totalPriceDetailLabel.setText("$" + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }

      else if (e.getSource() == bookHotel) {
                try {
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into bookhotel values('" + usernameDetailLabel.getText() + "', '" + choiceHotel.getSelectedItem() + "'," +
                            "'" + personTf.getText() + "','"+ daysTf.getText()+"', '"+choiceAc.getSelectedItem()+"','"+choiceFood.getSelectedItem()+"'," +
                            " '" + idNameLabel.getText() + "', '" + idNumberDetailLabel.getText() + "'," +
                            "'" + phoneNumberDetailLabel.getText() + "', '" + totalPriceDetailLabel.getText() + "')");

                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            } else {
                setVisible(false);
            }
        }
    }
