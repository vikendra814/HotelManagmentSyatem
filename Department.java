package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    Department(){

        JLabel l2=new JLabel("Department");
        l2.setBounds(150,10,100,20);
        add(l2);



        JLabel l3=new JLabel("Budget ");
        l3.setBounds(480, 10, 100, 20);
        add(l3);




        t1=new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);

        b1=new JButton("Submit");
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setBounds(180,400,120,30);
        add(b1);

        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(380,400,120,30);
        add(b2);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(500,200,700,480);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            try{
                String str="select * from department";
                conn c=new conn();
                ResultSet rs;
                rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Department().setVisible(true);
    }
}
