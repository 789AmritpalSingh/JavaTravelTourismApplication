package traveltourism.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {

    JButton create, back;
    JTextField usernameTf, nameTf, passwordTf,answerTf;
    Choice security;
    SignUp(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial",Font.BOLD,14));
        usernameLabel.setBounds(50,20,125,25);
        p1.add(usernameLabel);

        usernameTf = new JTextField();
        usernameTf.setBounds(190,20,180,25);
        usernameTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(usernameTf);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial",Font.BOLD,14));
        nameLabel.setBounds(50,60,125,25);
        p1.add(nameLabel);

        nameTf = new JTextField();
        nameTf.setBounds(190,60,180,25);
        nameTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nameTf);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial",Font.BOLD,14));
        passwordLabel.setBounds(50,100,125,25);
        p1.add(passwordLabel);

        passwordTf = new JTextField();
        passwordTf.setBounds(190,100,180,25);
        passwordTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passwordTf);

        JLabel securityLabel = new JLabel("Security Question");
        securityLabel.setFont(new Font("Arial",Font.BOLD,14));
        securityLabel.setBounds(50,140,125,25);
        p1.add(securityLabel);

        security = new Choice();// for creating a drop-down box
        security.add("Fav Character from the Boys");
        security.add("Most Important thing in your life");
        security.add("Your Hometown");
        security.add("Your dream");
        security.setBounds(190,140,180,25);
        p1.add(security);

        JLabel securityAnswer = new JLabel("Answer");
        securityAnswer.setFont(new Font("Arial",Font.BOLD,14));
        securityAnswer.setBounds(50,180,125,25);
        p1.add(securityAnswer);

        answerTf = new JTextField();
        answerTf.setBounds(190,180,180,25);
        answerTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answerTf);

        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Arial",Font.BOLD,14));
        create.setBounds(180,250,100,30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setBounds(80,250,100,30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == create){ // picking the values from the text field and inserting data in the database
             String username = usernameTf.getText();
             String name = nameTf.getText();
             String password = passwordTf.getText();
             String securityQuestion = security.getSelectedItem();
             String answer = answerTf.getText();

             String query = "insert into account values('"+username+"','"+name+"','"+password+"', '"+securityQuestion+"', '"+answer+"')";

             try{
                 Conn c = new Conn();
                 c.statement.executeUpdate(query);

                 JOptionPane.showMessageDialog(null,"Account Created Successfully");
                 setVisible(false);
                 new Login();
             }catch (Exception ae){
                 ae.printStackTrace();
             }
         }
         else if(e.getSource() == back){
            setVisible(false); // closing the frame on click of the back button
            new Login(); // opening the login form on click of back button
         }
    }
    public static void main(String[] args) {
        new SignUp();
    }

}
