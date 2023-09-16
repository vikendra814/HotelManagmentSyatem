package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l4;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;
    Login(){

        l4=new JLabel("Employee Login");
        l4.setFont(new Font("tahoma",Font.BOLD,20));
        l4.setForeground(Color.blue);
        l4.setBounds(200,0,200,30);
        add(l4);

        //lable 1
        l1=new JLabel("User Name");
        l1.setBounds(40,60,100,30);
        add(l1);

        //lable 2
        l2=new JLabel("Password");
        l2.setBounds(40,110,100,30);
        add(l2);

       //text fields
       t1=new JTextField();
       t1.setBounds(150,60,150,25);
       add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,110,150,25);
        add(t2);

        //button
        b1=new JButton("Login");
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

        b3=new JButton("Login As Admin");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(110,220,120,30);
        b3.addActionListener(this);
        add(b3);

        //image
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(350,10,200,200);
        add(l3);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(600,300,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c1 = new conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from employee_login where username='"+u+"' and password='"+v+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new EmployeeDashboard().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(this, "Invalid login","Error",JOptionPane.ERROR_MESSAGE);
                    //setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }else if(ae.getSource()==b3){
            new AdminLogin().setVisible(true);
            this.setVisible(false);

        }
    }

    public static void main(String[] args) {
Login lg=new Login();
    }

}


