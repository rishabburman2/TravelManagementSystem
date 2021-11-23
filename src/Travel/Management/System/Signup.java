package Travel.Management.System;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author rishabburman
 */
public class Signup extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField t1,t2;
    JPasswordField t3,t4;
    Signup(){
        setBounds(350,250,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(138,79,255));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        //Username
        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma",Font.PLAIN,18));
        l1.setBounds(30,30,150,30);
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(200,30,250,30);
        t1.setFont(new Font("Tahoma",Font.PLAIN,18));
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);
        
        //Name
        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma",Font.PLAIN,18));
        l2.setBounds(30,70,150,30);
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(200,70,250,30);
        t2.setFont(new Font("Tahoma",Font.PLAIN,18));
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);
        
        //Password
        JLabel l3 = new JLabel("Password");
        l3.setFont(new Font("Tahoma",Font.PLAIN,18));
        l3.setBounds(30,110,150,30);
        p1.add(l3);
        
        t3 = new JPasswordField();
        t3.setBounds(200,110,250,30);
        t3.setFont(new Font("Tahoma",Font.PLAIN,18));
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        //ReEnter Password
        JLabel l4 = new JLabel("Confirm Password");
        l4.setFont(new Font("Tahoma",Font.PLAIN,18));
        l4.setBounds(30,150,150,30);
        p1.add(l4);
        
        t4 = new JPasswordField();
        t4.setBounds(200,150,250,30);
        t4.setFont(new Font("Tahoma",Font.PLAIN,18));
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);
        
        //Buttons for signup and back
        b1 = new JButton("Sign Up");
        b1.setBounds(70,250,150,50);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.addActionListener(this); // Specifies that we want an event to be performed on click of this button
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(270,250,150,50);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.addActionListener(this);
        p1.add(b2);
        
        //SignUp image
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/images/signup.jpg"));
        JLabel l5 = new JLabel(i2);
        l5.setBounds(600,50,225,225);
        add(l5);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = new String(t3.getPassword());
            String confirm = new String(t4.getPassword());
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+confirm+"')";
            try{
                Connection1 c = new Connection1();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created");
                
                
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
                
            }
            
            
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
