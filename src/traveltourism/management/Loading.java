package traveltourism.management;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    JProgressBar bar;
    String username;

    @Override
    public void run() {
        try{
            for (int i = 1; i <=101 ; i++) { // we are running till 101 because, otherwise else condition will never execute value will never be
                // greater than 100, if we set 100
                int max = bar.getMaximum(); // 100
                int value = bar.getValue(); // gives the current value of progress bar

                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }else{ // if value crossed 100
                  setVisible(false);
                  new Dashboard(username);
                  // new class object
                }
                Thread.sleep(50);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username = username;
        t = new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Railway",Font.BOLD,35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, Please Wait...");
        loading.setBounds(230,130,150,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Railway",Font.BOLD,16));
        add(loading);

        JLabel usernameLabel = new JLabel("Welcome "+ username);
        usernameLabel.setBounds(20,310,400,40);
        usernameLabel.setForeground(Color.red);
        usernameLabel.setFont(new Font("Railway",Font.BOLD,16));
        add(usernameLabel);

        t.start();

        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
