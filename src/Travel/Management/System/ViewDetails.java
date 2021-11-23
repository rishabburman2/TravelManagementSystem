/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewDetails extends JFrame implements ActionListener{
    //JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    //JTextArea ta1;
    //JComboBox cb1;
    //JRadioButton r1,r2,r3;
    JButton b2;
    ViewDetails(String username){
        setBounds(250,250,950,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30,60,100,30);
        add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(180,60,100,30);
        add(l11);
        
        JLabel l2 = new JLabel("Name : ");
        l2.setBounds(30,110,100,30);
        add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(180,110,100,30);
        add(l12);
        
        JLabel l3 = new JLabel("Email ID : ");
        l3.setBounds(30,160,100,30);
        add(l3);
        
        JLabel l13 = new JLabel();
        l13.setBounds(180,160,200,30);
        add(l13);
        
        JLabel l4 = new JLabel("Mobile # : ");
        l4.setBounds(30,210,100,30);
        add(l4);
        
        JLabel l14 = new JLabel();
        l14.setBounds(180,210,100,30);
        add(l14);
        
        JLabel l5 = new JLabel("ID : ");
        l5.setBounds(530,60,100,30);
        add(l5);
        
        JLabel l15 = new JLabel();
        l15.setBounds(680,60,100,30);
        add(l15);
        
        JLabel l6 = new JLabel("Gender : ");
        l6.setBounds(530,110,100,30);
        add(l6);
        
        JLabel l16 = new JLabel();
        l16.setBounds(680,110,100,30);
        add(l16);
        
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
        l7.setBounds(530,160,100,30);
        add(l7);
        
        JLabel l17 = new JLabel();
        l17.setBounds(680,160,100,30);
        add(l17);
        
        JLabel l8 = new JLabel("Address : ");
        l8.setBounds(530,210,100,30);
        add(l8);
        
        JLabel l18 = new JLabel();
        l18.setBounds(680,210,100,30);
        add(l18);
        
        
        b2 = new JButton("Back");
        b2.setBounds(350,300,100,50);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
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
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("name"));
                l13.setText(rs.getString("email"));
                l14.setText(rs.getString("mobile"));
                l15.setText(rs.getString("id"));
                l16.setText(rs.getString("gender"));
                l17.setText(rs.getString("country"));
                l18.setText(rs.getString("address"));
            }
            
        }catch(Exception e){
            
        }
        
        
    }
    public void actionPerformed(ActionEvent ae){
        
     if(ae.getSource()==b2){
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args) {
        new ViewDetails("").setVisible(true);
    }
}
