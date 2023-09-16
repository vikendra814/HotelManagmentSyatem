package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Bill extends JFrame implements ActionListener {

            JButton b1,b2,b3;
            Choice c1;
            JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Bill(){
                JLabel l1=new JLabel("Hotel Taj Bill");
                l1.setFont(new Font("tahoma", Font.PLAIN,20));
                l1.setForeground(Color.blue);
                l1.setBounds(130,30,200,30);
                add(l1);

                JLabel l2=new JLabel("Customer ID");
                l2.setBounds(30,90,100,20);
                add(l2);

                c1=new Choice();
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from customer");
                    while (rs.next()){
                        c1.add(rs.getString("number"));
                    }

                }catch(Exception e){}
                c1.setBounds(200,80,150,25);
                add(c1);

                JLabel l3=new JLabel("Room Number");
                l3.setBounds(30,120,100,20);
                add(l3);

                t1=new JTextField();
                t1.setBounds(200,120,150,25);
                add(t1);

                JLabel l4=new JLabel("Name");
                l4.setBounds(30,160,100,20);
                add(l4);

                t2=new JTextField();
                t2.setBounds(200,160,150,25);
                add(t2);

                JLabel l5=new JLabel("Booking Days");
                l5.setBounds(30,200,100,20);
                add(l5);

                t3=new JTextField();
                t3.setBounds(200,200,150,25);
                add(t3);


                JLabel l6=new JLabel(" Food Package");
                l6.setBounds(30,240,100,20);
                add(l6);

                t6=new JTextField();
                t6.setBounds(200,240,150,25);
                add(t6);


                JLabel l9=new JLabel("24H Food Price");
                l9.setBounds(30,280,100,20);
                add(l9);

                t7=new JTextField();
                t7.setBounds(200,280,150,25);
                add(t7);

                JLabel l10=new JLabel(" 24H Room Price ");
                l10.setBounds(30,320,100,20);
                add(l10);

                t8=new JTextField();
                t8.setBounds(200,320,150,25);
                add(t8);



                JLabel l11=new JLabel(" Total Price ");
                l11.setBounds(30,360,100,20);
                add(l11);

                t9=new JTextField();
                t9.setBounds(200,360,150,25);
                add(t9);






                JLabel l8=new JLabel("Amount Paid");
                l8.setBounds(30,400,100,20);
                add(l8);

                t4=new JTextField();
                t4.setBounds(200,400,150,25);
                add(t4);

                JLabel l7=new JLabel("Pending Amount");
                l7.setBounds(30,440,100,20);
                add(l7);

                t5=new JTextField();
                t5.setBounds(200,440,150,25);
                add(t5);

                b1=new JButton("Create");
                b1.setForeground(Color.white);
                b1.setBackground(Color.black);
                b1.setBounds(30,480,100,30);
                b1.addActionListener(this);
                add(b1);


                b2=new JButton("Back");
                b2.setForeground(Color.white);
                b2.setBackground(Color.black);
                b2.setBounds(240,480,100,30);
                b2.addActionListener(this);
                add(b2);


                getContentPane().setBackground(Color.white);
                setLayout(null);
                setBounds(590,200,400,600);
                setVisible(true);
            }

            public void actionPerformed(ActionEvent ae){
                if (ae.getSource()==b1){
                    try{
                        String room=null;
                        String deposit=null;
                        int amountPaid=0;
                        String price=null;
                        int fprice=0;
                        int tprice;
                        conn c=new conn();
                        String id=c1.getSelectedItem();
                        String str="select * from customer where number='"+id+"'";
                        ResultSet rs=c.s.executeQuery(str);
                        while (rs.next()){
                            t1.setText(rs.getString("room"));
                            t2.setText(rs.getString("name"));
                            t3.setText(rs.getString("bookingdays"));
                            t4.setText(rs.getString("deposite"));
                            t6.setText(rs.getString("foodpackage"));
                            room=rs.getString("room");
                            deposit=rs.getString("deposite");
                            if (t6.getText().equals("Normal")){
                                fprice=500;
                            }else if (t6.getText().equals("High")){
                                fprice=750;
                            }
                            else if (t6.getText().equals("Premium")){
                                fprice=1000;
                            }
                            t7.setText(Integer.toString(fprice));
                        }
                        ResultSet rs2=c.s.executeQuery("select * from rooms where room='"+room+"'");
                        while (rs2.next()){
                            price=rs2.getString("price");
                            tprice=Integer.parseInt(price)*Integer.parseInt(t3.getText())+(fprice*Integer.parseInt(t3.getText()));
                            amountPaid=tprice - Integer.parseInt(deposit);
                            t8.setText(price);
                            t9.setText(Integer.toString(tprice));

                            t5.setText(Integer.toString(amountPaid));
                        }

                    }catch(Exception e){
                        System.out.println(e);
                    }

                }else if (ae.getSource()==b2){
                    new Reception().setVisible(true);
                    this.setVisible(false);
                }

            }

            public static void main(String[] args) {
                new Bill().setVisible(true);

            }
        }

