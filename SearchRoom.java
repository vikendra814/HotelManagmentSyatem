package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JComboBox c1;
    JCheckBox c2,c3;
    JButton b1,b2;
    JTable t1;
    SearchRoom(){
        JLabel l1=new JLabel("Search For Room");
        l1.setFont(new Font("tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(400,30,200,30);
        add(l1);

        JLabel l2=new JLabel("Room Bed Type");
        l2.setBounds(50,100,100,20);
        add(l2);

        c1=new JComboBox(new String[]{"Single Bed","Double Bed"});
        c1.setBounds(150,100,150,20);
        c1.setBackground(Color.white);
        add(c1);

        c2=new JCheckBox("Only Display Available");
        c2.setBackground(Color.white);
        c2.setBounds(650,100,150,25);
        add(c2);

        c3=new JCheckBox("Only Display Ac Rooms");
        c3.setBackground(Color.white);
        c3.setBounds(420,100,170,25);
        add(c3);

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(50, 160, 100, 20);
        add(l3);


        JLabel l4=new JLabel("Availability");
        l4.setBounds(240,160,100,20);
        add(l4);


        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(370,160,100,20);
        add(l5);

        JLabel l6=new JLabel("Price");
        l6.setBounds(570,160,100,20);
        add(l6);


        JLabel l8=new JLabel("Bed Type");
        l8.setBounds(720,160,100,20);
        add(l8);


        JLabel l9=new JLabel("Ac Available");
        l9.setBounds(880,160,100,20);
        add(l9);

       t1=new JTable();
       t1.setBounds(0,200,1000,300);
       add(t1);

       b1=new JButton("Submit");
       b1.setForeground(Color.white);
       b1.addActionListener(this);
       b1.setBackground(Color.black);
       b1.setBounds(300,520,120,30);
       add(b1);

        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(500,520,120,30);
        add(b2);
        getContentPane().setBackground(Color.white);

       setLayout(null);
       setBounds(350,170,1000,600);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            try{
                String str="select * from rooms where bed_type='"+c1.getSelectedItem()+"'";
                String str2="select * from Rooms where available='Available' And bed_type='"+c1.getSelectedItem()+"'";
                String str3="select * from Rooms where ac='Yes' And bed_type='"+c1.getSelectedItem()+"'" ;
                conn c=new conn();
                ResultSet rs;
                if (c2.isSelected()){
                    rs=c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                }
                else  if (c3.isSelected()){
                    rs=c.s.executeQuery(str3);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                }

                else{
                    rs=c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }



            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
new SearchRoom().setVisible(true);
    }
}
