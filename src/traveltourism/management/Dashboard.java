package traveltourism.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonDetails,viewPersonalDetails,updatePersonalDetails,checkPackages,bookPackage, viewPackage,viewHotels,
            viewBookedHotel, destinations, bookHotel, deletePersonalDetails,payments, notepad,calculator,about;
    Dashboard(String username){
        this.username = username;
       // setBounds(0,0,1600,1000); --> if you dont know the size of your laptop screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Heading");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addPersonDetails = new JButton("Add Person Details");
        addPersonDetails.setBounds(0,0,300,50);
        addPersonDetails.setBackground(new Color(0,0,102));
        addPersonDetails.setForeground(Color.white);
        addPersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonDetails.setMargin(new Insets(0,0,0,60)); // will shift the button towards right by 60
        addPersonDetails.addActionListener(this);
        p2.add(addPersonDetails);

        updatePersonalDetails = new JButton("Update Person Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30)); // will shift the button towards right by 60
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,115)); // will shift the button towards right by 60
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,25)); // will shift the button towards right by 60
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.white);
        checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackages.setMargin(new Insets(0,0,0,90)); // will shift the button towards right by 60
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0,250,300,50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.white);
        bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackage.setMargin(new Insets(0,0,0,100)); // will shift the button towards right by 60
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0,300,300,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.white);
        viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,100)); // will shift the button towards right by 60
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,110)); // will shift the button towards right by 60
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0,400,300,50);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.white);
        bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookHotel.setMargin(new Insets(0,0,0,115)); // will shift the button towards right by 60
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,450,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,50)); // will shift the button towards right by 60
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,105)); // will shift the button towards right by 60
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,125)); // will shift the button towards right by 60
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,120)); // will shift the button towards right by 60
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,130)); // will shift the button towards right by 60
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,150)); // will shift the button towards right by 60
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text  = new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.white);
        text.setFont(new Font("Railway",Font.PLAIN,55));
        image.add(text);
        setUndecorated(true);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addPersonDetails){
            new AddCustomer(username);
        }else if(e.getSource()==viewPersonalDetails){
            new ViewCustomerDetails(username);
        }else if(e.getSource()==updatePersonalDetails){
            new UpdateCustomerPersonalDetails(username);
        }else if(e.getSource()==checkPackages){
            new CheckPackage();
        }else if(e.getSource()==bookPackage){
            new BookPackage(username);
        }
        else if(e.getSource()==viewPackage){
            new ViewPackage(username);
        }else if (e.getSource()==viewHotels){
            new CheckHotels();
        }
        else if(e.getSource()==destinations){
            new Destinations();
        }
        else if(e.getSource()==bookHotel){
            new BookHotel(username);
        }
        else if (e.getSource()==viewBookedHotel){
            new ViewBookedHotel(username);
        }else if(e.getSource()==payments){
            new Payments();
        }
        else if(e.getSource()==deletePersonalDetails){
            new DeleteDetails(username);
        }
        else if(e.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==about){
            new About();
        }
    }
}
