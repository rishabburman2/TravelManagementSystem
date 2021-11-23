/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Management.System;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame implements ActionListener{
    
    String user;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JButton b1,b2;
    DeleteDetails(String username){
        
        user = username;
        setBounds(250,150,950,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("DELETE CUSTOMER");
        heading.setBounds(350,10,300,30);
        heading.setFont(new Font("Sans-Serif",Font.PLAIN,24));
        add(heading);
        
        l1 = new JLabel("Username");
        l1.setBounds(30,90,150,20);
        l1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l1);
        
        l2 = new JLabel();
        l2.setBounds(230,90,250,20);
        l2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l2);
        
        l3 = new JLabel("Name");
        l3.setBounds(30,140,150,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l3);
        
        l4 = new JLabel();
        l4.setBounds(230,140,250,20);
        l4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l4);
        
        l5 = new JLabel("Email");
        l5.setBounds(30,190,150,20);
        l5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l5);
        
        l6 = new JLabel();
        l6.setBounds(230,190,250,20);
        l6.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l6);
        
        l7 = new JLabel("Mobile");
        l7.setBounds(30,240,150,20);
        l7.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l7);
        
        l8 = new JLabel();
        l8.setBounds(230,240,250,20);
        l8.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l8);
        
        l9 = new JLabel("ID");
        l9.setBounds(30,290,150,20);
        l9.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l9);
        
        l10 = new JLabel();
        l10.setBounds(230,290,250,20);
        l10.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l10);
        
        l11 = new JLabel("Gender");
        l11.setBounds(30,340,250,20);
        l11.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l11);
        
        l12 = new JLabel();
        l12.setBounds(230,340,250,20);
        l12.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l12);
        
        l13 = new JLabel("Country");
        l13.setBounds(30,390,150,20);
        l13.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l13);
        
        l14 = new JLabel();
        l14.setBounds(230,390,250,20);
        l14.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l14);
        
        l15 = new JLabel("Address");
        l15.setBounds(30,440,150,20);
        l15.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l15);
        
        l16 = new JLabel();
        l16.setBounds(230,440,250,20);
        l16.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l16);
        
        b1 = new JButton("DELETE");
        b1.setBounds(150,490,100,40);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Tahoma",Font.PLAIN,16));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("BACK");
        b2.setBounds(300,490,100,40);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.PLAIN,16));
        b2.addActionListener(this);
        add(b2);
        
        try{
            Connection1 c = new Connection1();
            ResultSet rs = c.s.executeQuery("select*from customer where username = '"+username+"'");
            while(rs.next()){
                l2.setText(rs.getString("username"));
                l4.setText(rs.getString("name"));
                l6.setText(rs.getString("email"));
                l8.setText(rs.getString("mobile"));
                l10.setText(rs.getString("id"));
                l12.setText(rs.getString("gender"));
                l14.setText(rs.getString("country"));
                l16.setText(rs.getString("address"));                                          
            }
        }catch(Exception e){
            
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Connection1 c = new Connection1();
                c.s.executeUpdate("delete from account where username = '"+user+"'");
                c.s.executeUpdate("delete from customer where username = '"+user+"'");
                c.s.executeUpdate("delete from book where username = '"+user+"'");
                c.s.executeUpdate("delete from bookflight where username = '"+user+"'");
                JOptionPane.showMessageDialog(null,"Account Deleted");
                System.exit(0);
            }catch(Exception e){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new DeleteDetails("").setVisible(true);
    }
}
