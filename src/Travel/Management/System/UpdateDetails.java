
package Travel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateDetails extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    //JTextArea ta1;
    //JComboBox cb1;
    //JRadioButton r1,r2,r3;
    JButton b1,b2;
    UpdateDetails(String username){
        setBounds(400,100,750,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l10 = new JLabel("UPDATE YOUR DETAILS");
        l10.setBounds(30,10,450,40);
        l10.setFont(new Font("Sans-Serif",Font.PLAIN,28));
        add(l10);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30,60,100,30);
        add(l1);
        
        t1=new JTextField();
        t1.setBounds(150,60,180,30);
        add(t1);
        
        JLabel l2 = new JLabel("Name : ");
        l2.setBounds(30,110,100,30);
        add(l2);
        
        t2=new JTextField();
        t2.setBounds(150,110,180,30);
        add(t2);
        
        JLabel l3 = new JLabel("Email ID : ");
        l3.setBounds(30,160,100,30);
        add(l3);
        
        t3=new JTextField();
        t3.setBounds(150,160,180,30);
        add(t3);
        
        JLabel l4 = new JLabel("Mobile # : ");
        l4.setBounds(30,210,100,30);
        add(l4);
        
        t4=new JTextField();
        t4.setBounds(150,210,180,30);
        add(t4);
        
        JLabel l5 = new JLabel("ID : ");
        l5.setBounds(30,260,100,30);
        add(l5);
        
        t7=new JTextField();
        t7.setBounds(150,260,180,30);
        add(t7);
        
        JLabel l6 = new JLabel("Gender : ");
        l6.setBounds(30,310,100,30);
        add(l6);
        
        t8=new JTextField();
        t8.setBounds(150,310,180,30);
        add(t8);
        
        /*
        r1=new JRadioButton("Male");
        r1.setBounds(150,310,70,30);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(220,310,80,30);
        add(r2);
        
        r3=new JRadioButton("Others");
        r3.setBounds(300,310,80,30);
        add(r3);
        */
        
        JLabel l7 = new JLabel("Country : ");
        l7.setBounds(30,360,100,30);
        add(l7);
        
        t5=new JTextField();
        t5.setBounds(150,360,180,30);
        add(t5);
        
        JLabel l8 = new JLabel("Address : ");
        l8.setBounds(30,410,100,30);
        add(l8);
        
        t6=new JTextField();
        t6.setBounds(150,410,180,30);
        add(t6);
        
        b1 = new JButton("Update");
        b1.setBounds(30,550,100,50);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(230,550,100,50);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        //System.out.println(username);
        
        /*
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/images/add.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l9 = new JLabel(i3);
        l9.setBounds(30,600,200,100);
        add(l9);
        */
        
        //Following block of code already puts in username and name for add details
        try{
            Connection1 c = new Connection1();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                t1.setText(rs.getString("username"));
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("email"));
                t4.setText(rs.getString("mobile"));
                t7.setText(rs.getString("id"));
                t8.setText(rs.getString("gender"));
                t5.setText(rs.getString("country"));
                t6.setText(rs.getString("address"));
            }
            
        }catch(Exception e){
            
        }
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username = t1.getText();
            String name = t2.getText();
            String email = t3.getText();
            String mobile = t4.getText();
            String id = t7.getText();
            String gender = t8.getText();
            String country = t5.getText();
            String address = t6.getText();
        
            String q = "update customer set username = '"+username+"', name = '"+name+"', email = '"+email+"', mobile = '"+mobile+"', id = '"+id+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"'";
            try{
                Connection1 c = new Connection1();
                c.s.executeUpdate(q);
            
                JOptionPane.showMessageDialog(null,"Customer Details Updated!");
                this.setVisible(false);
            }catch(Exception e){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateDetails("").setVisible(true);
    }
}

