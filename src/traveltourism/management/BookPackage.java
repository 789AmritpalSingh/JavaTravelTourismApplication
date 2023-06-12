package traveltourism.management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//Class to book the package , i.e. gold, silver or bronze package
public class BookPackage extends JFrame implements ActionListener {

    JLabel usernameDetailLabel,idNameLabel, idNumberDetailLabel,phoneNumberDetailLabel,
    totalPriceDetailLabel;
    Choice choicePackage;

    JButton checkPrice, bookPackage, back;
    JTextField personTf;
    String username;
    BookPackage(String username){
        this.username = username;

        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("Book Package");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40,70,100,20);
        usernameLabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(usernameLabel);

        usernameDetailLabel = new JLabel();
        usernameDetailLabel.setBounds(250,70,200,20);
        add(usernameDetailLabel);

        JLabel selectPackageLabel = new JLabel("Select Package");
        selectPackageLabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        selectPackageLabel.setBounds(40,110,150,20);
        add(selectPackageLabel);

        choicePackage = new Choice();
        choicePackage.add("Gold Package");
        choicePackage.add("Silver Package");
        choicePackage.add("Bronze Package");
        choicePackage.setBounds(250,110,200,20);
        add(choicePackage);

        JLabel totalPersonsLabel = new JLabel("Total Persons");
        totalPersonsLabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        totalPersonsLabel.setBounds(40,150,150,25);
        add(totalPersonsLabel);

        personTf = new JTextField("1");
        personTf.setBounds(250,150,200,25);
        add(personTf);

        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        idLabel.setBounds(40,190,150,20);
        add(idLabel);

        idNameLabel = new JLabel();
        idNameLabel.setBounds(250,190,200,25);
        add(idNameLabel);

        JLabel idNumberLabel = new JLabel("Id Number");
        idNumberLabel.setBounds(40,230,150,25);
        idNumberLabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(idNumberLabel);

        idNumberDetailLabel = new JLabel();
        idNumberDetailLabel.setBounds(250,230,150,25);
        add(idNumberDetailLabel);

        JLabel phoneNumberLabel = new JLabel("Phone");
        phoneNumberLabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        phoneNumberLabel.setBounds(40,270,150,20);
        add(phoneNumberLabel);

        phoneNumberDetailLabel = new JLabel();
        phoneNumberDetailLabel.setBounds(250,270,200,25);
        add(phoneNumberDetailLabel);

        JLabel totalPriceLabel = new JLabel("Total Price");
        totalPriceLabel.setBounds(40,310,150,25);
        totalPriceLabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(totalPriceLabel);

        totalPriceDetailLabel = new JLabel();
        totalPriceDetailLabel.setBounds(250,310,150,25);
        add(totalPriceDetailLabel);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet resultSet = c.statement.executeQuery(query);

            while(resultSet.next()){
                usernameDetailLabel.setText(resultSet.getString("username"));
                idNameLabel.setText(resultSet.getString("id"));
                idNumberDetailLabel.setText(resultSet.getString("number"));
                phoneNumberDetailLabel.setText(resultSet.getString("phone"));
                totalPriceDetailLabel.setText(resultSet.getString(""));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.white);
        checkPrice.setBounds(60,380,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.white);
        bookPackage.setBounds(200,380,120,25);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);

        setVisible(true);
    }
    public static void main(String[] args) {
        new BookPackage("Amritpal");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==checkPrice){
            String pack = choicePackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 200;
            }else if (pack.equals("Silver Package")){
                cost += 400;
            }else{
                cost += 600;
            }
            int persons = Integer.parseInt(personTf.getText());
            cost *= persons;
            totalPriceDetailLabel.setText("$ "+cost);
        }
        else if(e.getSource()==bookPackage){
            try{
                Conn c = new Conn();
                c.statement.executeUpdate("insert into bookpackage values('"+usernameDetailLabel.getText()+"', '"+choicePackage.getSelectedItem()+"'," +
                        "'"+personTf.getText()+"', '"+idNameLabel.getText()+"', '"+idNumberDetailLabel.getText()+"'," +
                        "'"+phoneNumberDetailLabel.getText()+"', '"+totalPriceDetailLabel.getText()+"')");

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
