package HotelManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class hotelManagementSystem extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;

    public hotelManagementSystem() {

        setSize(1365,850);          // setContentPane(300,300,1366,390);   frame size
        setLayout(null);
        setLocation(100,10);

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);



        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\will-funfun-bAK9wQghnHI-unsplash.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1365, 800,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
        lid.setBounds(450,10,1500,100);
        lid.setFont(new Font("serif",Font.HANGING_BASELINE,40));
        lid.setForeground(Color.blue);
        l1.add(lid);

        b1.setBounds(1180,750,150,40);
        l1.setBounds(0, 0, 1365, 800);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setVisible(true);

        while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(800); //1000 = 1 second
            }catch(Exception e){}
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }

    public void actionPerformed(ActionEvent ae){
       new Login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        hotelManagementSystem window = new hotelManagementSystem();
        window.setVisible(true);
    }
}
