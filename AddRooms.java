package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JTextField t1,t2;
    JComboBox c1,c2,c3,c4;
    JButton b1,b2;
    public AddRooms(){
        JLabel l1=new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma",Font.BOLD,16));
        l1.setBounds(150,20,100,20);
        add(l1);

        JLabel room=new JLabel("Room Number");
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        room.setBounds(60,80,120,30);
        add(room);
        t1=new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);

        JLabel Available=new JLabel("Available");
        Available.setFont(new Font("Tahoma",Font.PLAIN,16));
        Available.setBounds(60,130,120,30);
        add(Available);

        c1=new JComboBox(new String[]{"Available","Occupied"});
        c1.setBackground(Color.white);
        c1.setBounds(200,130,150,30);
        add(c1);

        JLabel status=new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma",Font.PLAIN,16));
        status.setBounds(60,180,120,30);
        add(status);

        c2=new JComboBox(new String[]{"Cleaned","Dirty"});
        c2.setBackground(Color.white);
        c2.setBounds(200,180,150,30);
        add(c2);

        JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(60,230,120,30);
        add(price);

        t2=new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);

        JLabel type=new JLabel("Bed Type");
        type.setFont(new Font("Tahoma",Font.PLAIN,16));
        type.setBounds(60,280,120,30);
        add(type);

        c3=new JComboBox(new String[]{"Single Bed","Double Bed"});
        c3.setBackground(Color.white);
        c3.setBounds(200,280,150,30);
        add(c3);

        JLabel ac=new JLabel("Ac Available");
        ac.setFont(new Font("Tahoma",Font.PLAIN,16));
        ac.setBounds(60,330,120,30);
        add(ac);


        c4=new JComboBox(new String[]{"Yes","No"});
        c4.setBackground(Color.white);
        c4.setBounds(200,330,150,30);
        add(c4);

        b1=new JButton("Add Room");
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,380,130,30);
        add(b1);

        b2=new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,380,130,30);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem\\icons\\twelve.jpg"));
        JLabel l5 =new JLabel(i1);
        l5.setBounds(400,30,500,380);
        add(l5);

        getContentPane().setBackground(Color.white);

        setBounds(400,200,940,500);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            String room=t1.getText();
            String available=(String) c1.getSelectedItem();
            String status=(String) c2.getSelectedItem();
            String price=t2.getText();
            String type=(String) c3.getSelectedItem();
            String ac=(String) c4.getSelectedItem();

            conn c=new conn();
            try{
                String str="insert into rooms values('"+room+"', '"+available+"','"+status+"','"+price+"','"+type+"','"+ac+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added");
                this.setVisible(false);

            }catch (Exception e){
                JOptionPane.showMessageDialog( this, "Room Number And Price is Only Number","Error",JOptionPane.ERROR_MESSAGE);
            }

        }else  if (ae.getSource()==b2){
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
