package traveltourism.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField usernameTf,nameTf,questionTf,answerTf,passwordTf;
    JButton search,retrieve,back;
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40,20,100,25);
        usernameLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(usernameLabel);

        usernameTf = new JTextField();
        usernameTf.setBounds(220,20,150,25);
        usernameTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(usernameTf);

        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40,60,100,25);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(nameLabel);

        nameTf = new JTextField();
        nameTf.setBounds(220,60,150,25);
        nameTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nameTf);

        JLabel questionLabel = new JLabel("Security Question");
        questionLabel.setBounds(40,100,150,25);
        questionLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(questionLabel);

        questionTf = new JTextField();
        questionTf.setBounds(220,100,150,25);
        questionTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(questionTf);

        JLabel answerLabel = new JLabel("Answer");
        answerLabel.setBounds(40,140,150,25);
        answerLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(answerLabel);

        answerTf = new JTextField();
        answerTf.setBounds(220,140,150,25);
        answerTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answerTf);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40,180,150,25);
        passwordLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(passwordLabel);

        passwordTf = new JTextField();
        passwordTf.setBounds(220,180,150,25);
        passwordTf.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passwordTf);

        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                String query = "select * from account where username = '"+usernameTf.getText()+"'";
                Conn c = new Conn();

                ResultSet resultSet = c.statement.executeQuery(query);// if entered username matches with
                // username value stored in the database then all the rest of the fields will be returned in
                // the text field
                while(resultSet.next()){
                    nameTf.setText(resultSet.getString("name"));
                    questionTf.setText(resultSet.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==retrieve){
            try{
                String query = "select * from account where answer = '"+answerTf.getText()+"' AND username = '"+usernameTf.getText()+"'";
                // if entered answer and username matches,execute  the query which retrieves password
                Conn c = new Conn();

                ResultSet resultSet = c.statement.executeQuery(query);
                while(resultSet.next()){
                    passwordTf.setText(resultSet.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new ForgetPassword();
    }
}
