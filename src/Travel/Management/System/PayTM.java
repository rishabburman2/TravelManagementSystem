/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Management.System;

import javax.swing.*;
import java.awt.event.*;

public class PayTM extends JFrame implements ActionListener{
    JButton b;
    PayTM(){
        
        
        //setLayout(null);
        JEditorPane j = new JEditorPane(); 
        j.setEditable(false);
        try{
            j.setPage("https://paytm.com/credit-card-bill-payment");
        }catch(Exception e){
            j.setContentType("text/html");
            j.setText("<html>Error 404</html>");
        }
        
        JScrollPane js= new JScrollPane(j);
        getContentPane().add(js);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        setBounds(250,150,950,600);
        add(j);
        
        b=new JButton("Back");
        b.setBounds(400,500,50,50);
        b.addActionListener(this);
        j.add(b);
    }
    
    public static void main(String[] args) {
        new PayTM().setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            this.setVisible(false);
        }
    }
}
