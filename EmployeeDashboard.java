package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeDashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2,m3,m4,m5;
    JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11;
    EmployeeDashboard() {
        mb=new JMenuBar();
        add(mb);

        m1=new JMenu("Hotel Management");
        m1.setFont(new Font("tahoma",Font.BOLD,15));
        mb.add(m1);

        m2=new JMenu("Customer Menu");
        m2.setFont(new Font("tahoma",Font.BOLD,15));
        mb.add(m2);

        m3=new JMenu("Room Menu");
        m3.setFont(new Font("tahoma",Font.BOLD,15));
        mb.add(m3);

        m4=new JMenu("PickUp Services");
        m4.setFont(new Font("tahoma",Font.BOLD,15));
        mb.add(m4);

        m5=new JMenu("Logout");
        m5.setFont(new Font("tahoma",Font.BOLD,15));
        mb.add(m5);

        i1=new JMenuItem("Reception");
        i1.setFont(new Font("tahoma",Font.PLAIN,15));
        i1.addActionListener(this);
        m1.add(i1);

        i2=new JMenuItem("Add New Customer");
        i2.setFont(new Font("tahoma",Font.PLAIN,15));
        i2.addActionListener(this);
        m2.add(i2);

        i3=new JMenuItem("Customer Information");
        i3.setFont(new Font("tahoma",Font.PLAIN,15));
        i3.addActionListener(this);
        m2.add(i3);

        i4=new JMenuItem("Customer CheckOut");
        i4.setFont(new Font("tahoma",Font.PLAIN,15));
        i4.addActionListener(this);
        m2.add(i4);

        i5=new JMenuItem("All Room Info.");
        i5.setFont(new Font("tahoma",Font.PLAIN,15));
        i5.addActionListener(this);
        m3.add(i5);

        i6=new JMenuItem("Update Room Status");
        i6.setFont(new Font("tahoma",Font.PLAIN,15));
        i6.addActionListener(this);
        m3.add(i6);

        i7=new JMenuItem("Search Room");
        i7.setFont(new Font("tahoma",Font.PLAIN,15));
        i7.addActionListener(this);
        m3.add(i7);

        i8=new JMenuItem("Driver Details");
        i8.setFont(new Font("tahoma",Font.PLAIN,15));
        i8.addActionListener(this);
        m4.add(i8);

        i9=new JMenuItem("Logout");
        i9.setFont(new Font("tahoma",Font.PLAIN,15));
        i9.addActionListener(this);
        m5.add(i9);


        mb.setBounds(0,0,1950,30);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\pexels-konstantinos-eleftheriadis-2034335.jpg"));
        Image i2= i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1 =new JLabel(i3);
        l1.setBounds(0,0,1950,1000);
        add(l1);

        JLabel l2= new JLabel("The Taj Group Welcomes You");
        l2.setBounds(500,80,1000,50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tacoma",Font.PLAIN,46));
        l1.add(l2);


        setLayout(null);
        setBounds(0,0,1950,1020);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);
        }else if (ae.getActionCommand().equals("Add New Customer")){
            new AddCustomer().setVisible(true);
        }
        else if (ae.getActionCommand().equals("Customer Information")){
            new CustomerInfo().setVisible(true);
        }
        else if (ae.getActionCommand().equals("Customer CheckOut")){
            new CheckOut().setVisible(true);
        }
        else if (ae.getActionCommand().equals("All Room Info.")){
            new Room().setVisible(true);
        }
        else if (ae.getActionCommand().equals("Update Room Status")){
            new UpdateRoom().setVisible(true);
        }
        else if (ae.getActionCommand().equals("Search Room")){
            new SearchRoom().setVisible(true);
        }
        else if (ae.getActionCommand().equals("Driver Details")){
            new Pickup().setVisible(true);
        }
        else if (ae.getActionCommand().equals("Logout")){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EmployeeDashboard().setVisible(true);
    }
}

