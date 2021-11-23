package Travel.Management.System;

/**
 *
 * @author rishabburman
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3;
    JButton b1,b2;
    
    ForgetPassword(){
        setBounds(550,300,600,300);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(70,20,460,220);
        p1.setBackground(new Color(9, 255, 94));
        add(p1);
        
        //NOTE
        JLabel l = new JLabel("*Enter your username and name and click on submit to generate your password");
        l.setBounds(40,2,500,15);
        l.setFont(new Font("Tahoma",Font.ITALIC,10));
        p1.add(l);
        
        //Username
        JLabel l1 = new JLabel("Username");
        l1.setBounds(40,20,150,25);
        l1.setFont(new Font("Tahoma",Font.PLAIN,16));
        p1.add(l1);
        
        t1=new JTextField();
        t1.setBounds(180,20,220,25);
        t1.setFont(new Font("Tahoma",Font.PLAIN,16));
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);
        
        //Name
        JLabel l2 = new JLabel("Name");
        l2.setBounds(40,60,150,28);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        p1.add(l2);
        
        t2=new JTextField();
        t2.setBounds(180,60,220,28);
        t2.setFont(new Font("Tahoma",Font.PLAIN,16));
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);
        
        //New Password
        JLabel l3 = new JLabel("Password");
        l3.setBounds(40,100,150,28);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        p1.add(l3);
        
        t3=new JTextField();
        t3.setBounds(180,100,220,28);
        t3.setFont(new Font("Tahoma",Font.PLAIN,16));
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        b1 = new JButton("Back");
        b1.setBounds(38,150,125,50);
        b1.setFont(new Font("Tahoma",Font.PLAIN,16));
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("Submit");
        b2.setBounds(275,150,125,50);
        b2.setFont(new Font("Tahoma",Font.PLAIN,16));
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p1.add(b2);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        Connection1 c = new Connection1();
        
        if(ae.getSource()==b1){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource()==b2){
            try{
                String sql = "select * from account where username = '"+t1.getText()+"' and name = '"+t2.getText()+"'";
                ResultSet rs = c.s.executeQuery(sql);//executeQuery returns object of class ResultSet
                while(rs.next()){
                    t3.setText(rs.getString("password"));
                }
            }catch(Exception e){
                
            }
        }
    }
    
    
    public static void main(String[] args) {
        new ForgetPassword().setVisible(true);
    }
}
