package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FoodPackage extends JFrame implements ActionListener {

        JTable t1;
        JButton b1,b2;
    FoodPackage(){
            JLabel l1=new JLabel("Normal Food Package");
            l1.setBounds(10, 11, 140, 20);
            add(l1);


            JLabel l2=new JLabel("High Food Package");
            l2.setBounds(190,10,120,20);
            add(l2);


            JLabel l3=new JLabel("Premium Food Package");
            l3.setBounds(340,10,140,20);
            add(l3);


            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\food.jpeg"));
            Image i2 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel icon =new JLabel(i3);
            icon.setBounds(430,0,800,600);
            add(icon);

            t1=new JTable();
            t1.setBounds(0,40,500,400);
            add(t1);

            b1=new JButton("Load Data");
            b1.addActionListener(this);
            b1.setBackground(Color.black);
            b1.setForeground(Color.white);
            b1.setBounds(100,460,120,30);
            add(b1);

            b2=new JButton("Back");
            b2.addActionListener(this);
            b2.setBackground(Color.black);
            b2.setForeground(Color.white);
            b2.setBounds(250,460,120,30);
            add(b2);

            getContentPane().setBackground(Color.white);
            setLayout(null);
            setBounds(250,170,1050,600);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource()==b1){
                try {
                    conn c=new conn();
                    String str="select * from foodpackage";
                    ResultSet rs=c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception e){
                    System.out.println(e);
                }

            }else if(ae.getSource()==b2){
                new Reception().setVisible(true);
                this.setVisible(false);
            }

        }

        public static void main(String[] args) {
            new FoodPackage().setVisible(true);
        }
    }


