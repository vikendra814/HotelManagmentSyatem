package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    CustomerInfo(){

        JLabel l1=new JLabel("Id");
        l1.setBounds(41, 11, 46, 14);
        add(l1);


        JLabel l2=new JLabel("Id Number");
        l2.setBounds(130,10,70,20);
        add(l2);


        JLabel l3=new JLabel("Name");
        l3.setBounds(250,10,70,20);
        add(l3);


        JLabel l4=new JLabel("Gender");
        l4.setBounds(360,10,70,20);
        add(l4);


        JLabel l5=new JLabel("Country");
        l5.setBounds(470,10,70,20);
        add(l5);


        JLabel l6=new JLabel("Room Number");
        l6.setBounds(570,10,90,20);
        add(l6);

        JLabel l11=new JLabel("Food Package");
        l11.setBounds(670,10,90,20);
        add(l11);


        JLabel l7=new JLabel("Booking Days");
        l7.setBounds(780,10,90,20);
        add(l7);

        JLabel l8=new JLabel("Deposit");
        l8.setBounds(910,10,70,20);
        add(l8);

        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);

        b1=new JButton("Load Data");
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(350,560,120,30);
        add(b1);

        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(530,560,120,30);
        add(b2);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(350,170,1000,650);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            try {
                conn c=new conn();
                String str="select * from customer";
                ResultSet rs=c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(e);
            }
        }else {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CustomerInfo().setVisible(true);
    }
}
