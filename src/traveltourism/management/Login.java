package traveltourism.management;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signUp,password;
    JTextField usernameTf,passwordTf;

    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);// changing the color for whole panel


        JPanel p1 = new JPanel(); // creating panel for separating frame
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null); // we have use setLayout to null  to make setBounds function work
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(60,20,100,25);
        usernameLabel.setFont(new Font("Arial",Font.PLAIN,20));
        p2.add(usernameLabel);

        usernameTf = new JTextField();
        usernameTf.setBounds(60,60,300,30);
        usernameTf.setBorder(BorderFactory.createEmptyBorder());// removing the border around the text field
        p2.add(usernameTf);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(60,110,100,25);
        passwordLabel.setFont(new Font("Arial",Font.PLAIN,20));
        p2.add(passwordLabel);

        passwordTf = new JTextField();
        passwordTf.setBounds(60,150,300,30);
        passwordTf.setBorder(BorderFactory.createEmptyBorder());// removing the border around the text field
        p2.add(passwordTf);

        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);// setting text as white for button
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);

        signUp = new JButton("Sign Up");
        signUp.setBounds(230,200,130,30);
        signUp.setBackground(new Color(133,193,233));
        signUp.setForeground(Color.WHITE);// setting text as white for button
        signUp.setBorder(new LineBorder(new Color(133,193,233)));
        signUp.addActionListener(this);
        p2.add(signUp);

        password = new JButton("Forget Password");
        password.setBounds(130,250,130,30);
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.WHITE);// setting text as white for button
        password.setBorder(new LineBorder(new Color(133,193,233)));
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.RED);// setting text color as red
        p2.add(text);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try{
                String username = usernameTf.getText();
                String pass = passwordTf.getText();

                String query = "select * from account where username= '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);

                if(resultSet.next()){ // if username and password matches
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch (Exception ae){
                ae.printStackTrace();
            }

        }else if(e.getSource()== signUp){
            setVisible(false);
            new SignUp();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
