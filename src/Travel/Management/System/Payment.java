/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    JButton b1,b2;
    Payment(){
        setBounds(450,200,600,466);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/images/paytm.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 466, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,600,466);
        add(l1);
        
        b1=new JButton("Pay");
        b1.setBounds(197,260,80,35);
        b1.addActionListener(this);
        l1.add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(310,260,80,35);
        b2.addActionListener(this);
        l1.add(b2);
    }
    
    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            this.setVisible(false);
            new PayTM().setVisible(true);
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
}
