package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RemoveRoom extends JFrame implements ActionListener {
    JLabel l1,l2,l4;
    Choice c1;
    JPasswordField t2;
    JButton b1,b2,b3;
    RemoveRoom(){
        l4=new JLabel("Remove Room");
        l4.setFont(new Font("tahoma",Font.BOLD,20));
        l4.setForeground(Color.blue);
        l4.setBounds(200,0,250,30);
        add(l4);

        //lable 1
        l1=new JLabel("Room no.");
        l1.setBounds(40,60,100,30);
        add(l1);

        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from rooms");
            while (rs.next()){
                c1.add(rs.getString("room"));
            }

        }catch(Exception e){}
        c1.setBounds(150,60,150,30);
        add(c1);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\Remove.png"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(350,10,200,200);
        add(l3);

        //button
        b1=new JButton("Remove");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40,170,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(180,170,120,30);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(600,300,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String userid=c1.getSelectedItem();
            conn c=new conn();
            String str="DELETE FROM rooms WHERE room='"+userid+"'";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Removed Successfully");
                setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==b2){
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveRoom().setVisible(true);
    }
}

