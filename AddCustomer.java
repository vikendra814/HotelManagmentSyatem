package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    JComboBox c1,c3;
    Choice c2;
    JRadioButton r1,r2;

    AddCustomer(){
        JLabel l1=new JLabel("New Customer Form");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("tahoma",Font.PLAIN,20));
        add(l1);

        JLabel l2=new JLabel("ID");
        l2.setBounds(35,90,100,20);
        add(l2);

        c1=new JComboBox(new String[]{"Passport","Voter-id Card","Driving License","Aadhar Card"});
        c1.setBackground(Color.white);
        c1.setBounds(200,90,150,20);
        add(c1);

        JLabel l3=new JLabel("Number");
        l3.setBounds(35,130,100,20);
        add(l3);

        t1=new JTextField();
        t1.setBackground(Color.white);
        t1.setBounds(200,130,150,25);
        add(t1);

        JLabel l4=new JLabel("Name");
        l4.setBounds(35,170,100,20);
        add(l4);

        t2=new JTextField();
        t2.setBackground(Color.white);
        t2.setBounds(200,170,150,25);
        add(t2);

        JLabel l5=new JLabel("Gender");
        l5.setBounds(35,210,100,20);
        add(l5);

        r1=new JRadioButton("Male");
        r1.setBounds(200,210,60,25);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(270,210,80,25);
        add(r2);

        JLabel l6=new JLabel("Country");
        l6.setBounds(35,250,100,20);
        add(l6);

        t3=new JTextField();
        t3.setBackground(Color.white);
        t3.setBounds(200,250,150,25);
        add(t3);

        JLabel l7=new JLabel("Allocated Room");
        l7.setBounds(35,290,100,20);
        add(l7);

        c2=new Choice();
        try{
            conn c = new conn();
            String str="select * from rooms where available='Available'";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

            c2.setBounds(200,290,150,25);
            add(c2);

        JLabel l10=new JLabel("Food Package");
        l10.setBounds(35,330,100,20);
        add(l10);

        c3=new JComboBox(new String[]{"Normal","High","Premium",});
        c3.setBackground(Color.white);
        c3.setBounds(200,330,150,20);
        add(c3);

        JLabel l8=new JLabel("Booking Days");
        l8.setBounds(35,360,100,20);
        add(l8);

        t4=new JTextField();
        t4.setBackground(Color.white);
        t4.setBounds(200,360,150,25);
        add(t4);

        JLabel l9=new JLabel("Deposit");
        l9.setBounds(35,400,100,20);
        add(l9);

        t5=new JTextField();
        t5.setBackground(Color.white);
        t5.setBounds(200,400,150,25);
        add(t5);

        b1=new JButton("Add Customer");
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(50,440,120,20);
        add(b1);

        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(200,440,120,20);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\customer.jpeg"));
        Image i2= i1.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon =new JLabel(i3);
        icon.setBounds(400,50,400,400);
        add(icon);


        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(440,200,800,550);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String id = (String) c1.getSelectedItem();
            String food = (String) c3.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();

            String gender ="null";
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }
            String country = t3.getText();
            String room = (String) c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Null value not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (country.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Null value not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            }
                else {

                String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + food + "','" + status + "','" + deposit + "')";
                String str1 = "update rooms set available ='Occupied' where room='" + room + "'";
                try {
                    conn c = new conn();
                    c.s.executeUpdate(str);
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(this, "Customer Added Successfully", "Acknowledgment", JOptionPane.INFORMATION_MESSAGE);
                    new Reception().setVisible(true);
                    this.setVisible(false);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "enter number only in number,Booking Days And Deposit", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } if (ae.getSource() == b2) {
                new Reception().setVisible(true);
                this.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }
}

