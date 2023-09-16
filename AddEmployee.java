package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    AddEmployee(){
        JLabel  name=new JLabel("Name");
        name.setFont(new Font("tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);

        t1=new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);

        JLabel  age=new JLabel("Age");
        age.setFont(new Font("tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);

        t2=new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);

        JLabel  gender=new JLabel("Gender");
        gender.setFont(new Font("tahoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);

        r1=new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setFont(new Font("tahoma",Font.PLAIN,14));
        r1.setBounds(200,130,70,30);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setFont(new Font("tahoma",Font.PLAIN,14));
        r2.setBounds(280,130,70,30);
        add(r2);

        JLabel  job=new JLabel("Job");
        job.setFont(new Font("tahoma",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        add(job);

        String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1=new JComboBox(str);
        c1.setBackground(Color.white);
        c1.setBounds(200,180,150,30);
        add(c1);

        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("tahoma",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);

        t3=new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);

        JLabel phone=new JLabel("Phone");
        phone.setFont(new Font("tahoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);

        t4=new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);

        JLabel adhar=new JLabel("Aadhar");
        adhar.setFont(new Font("tahoma",Font.PLAIN,17));
        adhar.setBounds(60,330,120,30);
        add(adhar);

        t5=new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);

        JLabel email=new JLabel("E-mail");
        email.setFont(new Font("tahoma",Font.PLAIN,17));
        email.setBounds(60,380,120,30);
        add(email);

        t6=new JTextField();
        t6.setBounds(200,380,150,30);
        add(t6);

        b1=new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(200,420,150,30);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\tenth.jpg"));
        Image i2= i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1 =new JLabel(i3);
        l1.setBounds(380,60,450,450);
        add(l1);

        JLabel l2=new JLabel("Add Employee Details");
        l2.setForeground(Color.blue);
        l2.setBounds(420,30,400,30);
        l2.setFont(new Font("tahoma",Font.PLAIN,30));
        add(l2);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(420,200,850,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String adhar=t5.getText();
        String email=t6.getText();
        String gender=null;
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Null value not allowed", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Null value not allowed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (adhar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Null value not allowed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String job = (String) c1.getSelectedItem();

            conn c = new conn();

            String str = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + adhar + "','" + email + "')";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Employee Added");
                setVisible(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "enter number only in Mobile And Aadhar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}

