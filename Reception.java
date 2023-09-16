package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
    Reception(){
        b1=new JButton("New Customer Form");
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(10,30,200,30);
        add(b1);

        b2=new JButton("Room");
        b2.addActionListener(this);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(10,70,200,30);
        add(b2);

        b3=new JButton("Department");
        b3.addActionListener(this);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(10,110,200,30);
        add(b3);

        b4=new JButton("All Employee Info");
        b4.addActionListener(this);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setBounds(10,150,200,30);
        add(b4);

        b5=new JButton("Customer Info");
        b5.addActionListener(this);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.setBounds(10,190,200,30);
        add(b5);

        b6=new JButton("Manager Info");
        b6.addActionListener(this);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setBounds(10,230,200,30);
        add(b6);

        b13=new JButton("Food Package Details");
        b13.addActionListener(this);
        b13.setBackground(Color.black);
        b13.setForeground(Color.white);
        b13.setBounds(10,270,200,30);
        add(b13);

        b14=new JButton("Create bill");
        b14.addActionListener(this);
        b14.setBackground(Color.black);
        b14.setForeground(Color.white);
        b14.setBounds(10,310,200,30);
        add(b14);

        b7=new JButton("Check Out");
        b7.setBackground(Color.black);
        b7.addActionListener(this);
        b7.setForeground(Color.white);
        b7.setBounds(10,350,200,30);
        add(b7);

        b8=new JButton("Update booking details");
        b8.addActionListener(this);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.setBounds(10,390,200,30);
        add(b8);

        b9=new JButton("Update Room Status");
        b9.addActionListener(this);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.setBounds(10,430,200,30);
        add(b9);

        b10=new JButton("Pick Up Services");
        b10.addActionListener(this);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.setBounds(10,470,200,30);
        add(b10);

        b11=new JButton("Search Rooms");
        b11.addActionListener(this);
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.setBounds(10,510,200,30);
        add(b11);

        b12=new JButton("Logout");
        b12.addActionListener(this);
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.setBounds(10,550,200,30);
        add(b12);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\fourth.jpg"));
        JLabel l1 =new JLabel(i1);
        l1.setBounds(250,0,500,600);
        add(l1);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(430,170,800,670);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
          new AddCustomer().setVisible(true);
          this.setVisible(false);
        }else if (ae.getSource()==b2){
          new Room().setVisible(true);
          this.setVisible(false);
        }
        else if (ae.getSource()==b3){
            new Department().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b4){
         new EmployeeInfo().setVisible(true);
         this.setVisible(false);
        }
        else if (ae.getSource()==b5){
            new CustomerInfo().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b6){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if (ae.getSource()==b7){
            new CheckOut().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b8){
            new UpdateCheck().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b9){
            new UpdateRoom().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b10){
            new Pickup().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b11){
            new SearchRoom().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b13){
            new FoodPackage().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b14){
            new Bill().setVisible(true);
            this.setVisible(false);

        }
        else if (ae.getSource()==b12){
          setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
}
