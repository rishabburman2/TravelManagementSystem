/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class About extends JFrame implements ActionListener{
    String s;
    JButton b;
    About(){
        
        s = "The objective of the Travel and Tourism Management System project is to develop a system that : \n" +
             "Automates the processes and activities of a travel and tourism agency \n"+
             "The purpose is to design a system using which one can perform all operations related to traveling and sight-seeing.\n"+
             "The system allows one to easily access the relevant information and make necessary travel arrangements.\n"+
             "Users can decide about places they want to visit and make bookings online for travel and accommodation.";
        
        setBounds(250,150,950,600);
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        
        
        JLabel l1 = new JLabel("Travel and Tourism Managemt System");
        l1.setBounds(250,10,500,80);
        l1.setFont(new Font("Tahoma", Font.PLAIN,25));
        add(l1);
        
        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20,100,450,300);
        add(t1);
        
        b = new JButton("Back");
        b.setBounds(420,500,100,50);
        b.addActionListener(this);
        add(b);
    }
    
    public static void main(String[] args) {
        new About().setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            this.setVisible(false);
            
        }
    }
}
