package traveltourism.management;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable { // Multithreading concept
    Thread thread;
    Splash(){
        //setSize(1200,600); // defining the size of the frame
        //setLocation(200,100);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT); // we cannot place image directly
        // on the frame
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);// placing image inside label
        add(image); // placing image on the frame

        setVisible(true);
        thread = new Thread(this);
        thread.start(); // calling run method internally
    }

    public void run(){
        try{
           Thread.sleep(7000); // taking hold for 7 seconds for the image
            setVisible(false);// closing frame after 7 seconds
            new Login();
        }catch (Exception e){

        }
    }
    public static void main(String[] args) {
        Splash frame = new Splash();

        int x = 1;
        for (int i = 1; i <=500 ; x+=7, i+=6) {
            // full screen is around 1500 width and 1000 length
            frame.setLocation(750-(x+i)/2,400-(i/2));// changing location with time to time
            frame.setSize(x+i,i);// changing size with time to time

            try{
                Thread.sleep(10);
            }catch (Exception e){

            }
        }
    }
}
