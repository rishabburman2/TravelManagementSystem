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

public class ViewBookedFlight extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    JButton b1;
    ViewBookedFlight(String username){
        setBounds(250,150,950,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("VIEW BOOKED FLIGHT");
        l1.setBounds(310,20,300,50);
        l1.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(l1);
        
        l2 = new JLabel("Username : ");
        l2.setFont(new Font("Tahoma",Font.PLAIN,18));
        l2.setBounds(100,100,200,20);
        add(l2);
        
        //To be taken from database
        l3 = new JLabel();
        l3.setFont(new Font("Tahoma",Font.PLAIN,18));
        l3.setBounds(300,100,200,20);
        add(l3);
        
        l4 = new JLabel("Number of Seats : ");
        l4.setFont(new Font("Tahoma",Font.PLAIN,18));
        l4.setBounds(100,150,200,20);
        add(l4);
        
        //To be taken from database
        l5 = new JLabel();
        l5.setFont(new Font("Tahoma",Font.PLAIN,18));
        l5.setBounds(300,150,200,20);
        add(l5);
        
        l6 = new JLabel("Date of Flight : ");
        l6.setFont(new Font("Tahoma",Font.PLAIN,18));
        l6.setBounds(100,200,200,20);
        add(l6);
        
        //To be taken from database
        l7 = new JLabel();
        l7.setFont(new Font("Tahoma",Font.PLAIN,18));
        l7.setBounds(300,200,200,20);
        add(l7);
        
        l8 = new JLabel("Source : ");
        l8.setFont(new Font("Tahoma",Font.PLAIN,18));
        l8.setBounds(100,250,200,20);
        add(l8);
        
        //To be taken from database
        l9 = new JLabel();
        l9.setFont(new Font("Tahoma",Font.PLAIN,18));
        l9.setBounds(300,250,200,20);
        add(l9);
        
        l10 = new JLabel("Destination : ");
        l10.setFont(new Font("Tahoma",Font.PLAIN,18));
        l10.setBounds(100,300,200,20);
        add(l10);
        
        //To be taken from database
        l11 = new JLabel();
        l11.setFont(new Font("Tahoma",Font.PLAIN,18));
        l11.setBounds(300,300,200,20);
        add(l11);
        
        l12 = new JLabel("Mobile Number: ");
        l12.setFont(new Font("Tahoma",Font.PLAIN,18));
        l12.setBounds(100,350,200,20);
        add(l12);
        
        //To be taken from database
        l13 = new JLabel();
        l13.setFont(new Font("Tahoma",Font.PLAIN,18));
        l13.setBounds(300,350,200,20);
        add(l13);
        
        l14 = new JLabel("Total Price : ");
        l14.setFont(new Font("Tahoma",Font.PLAIN,18));
        l14.setBounds(100,400,200,20);
        add(l14);
        
        //To be taken from database
        l15 = new JLabel();
        l15.setFont(new Font("Tahoma",Font.PLAIN,18));
        l15.setBounds(300,400,200,20);
        add(l15);
        
        
        
        b1 = new JButton("Back");
        b1.setBounds(380,500,125,50);
        b1.setOpaque(true);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);
        
        try{
            Connection1 c = new Connection1(); 
            ResultSet rs = c.s.executeQuery("select*from bookflight where username = '"+username+"'");
            while(rs.next()){
                l3.setText(rs.getString(1));
                l5.setText(rs.getString(2));
                l7.setText(rs.getString(3));
                l9.setText(rs.getString(4));
                l11.setText(rs.getString(5));
                l13.setText(rs.getString(6));
                l15.setText(rs.getString(7));
                
                
            }
        }catch(Exception e){
            
        }
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new ViewBookedFlight("").setVisible(true);
    }
}
