package Travel.Management.System;

/**
 *
 * @author rishabburman
 */

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
//import java.awt.event.*;

//We will use multithreading for the progress bar
public class LoadingScreen extends JFrame implements Runnable{
    JProgressBar bar;
    Thread t;//We need to declare an object of class Thread explicitly
    String username;
    //Overriding run
    public void run(){
       try{
           for(int i=1;i<=101;i++){
               int m=bar.getMaximum(); //Will return max value of progress bar
               int n=bar.getValue();   //Will return current value
               if(n<m){
                   bar.setValue(bar.getValue()+1);
               }
               else{
                   i=101;
                   setVisible(false);
                   new Dashboard(username).setVisible(true);
               }
               Thread.sleep(50);
           }
       }catch(Exception e){
           
       } 
    }
       
    LoadingScreen(String user){
        
        username = user;
        t=new Thread(this);
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
        
        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setBounds(66,15,600,40);
        l1.setFont(new Font("Sans-Serif",Font.PLAIN,26));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        
        //Progress bar
        bar = new JProgressBar();
        bar.setBounds(150,320,300,10);
        bar.setVisible(true);
        bar.setStringPainted(true);
        //bar.setForeground(Color.BLUE);
        add(bar);
        
        
        JLabel l2 = new JLabel("Please wait while we take you into the server");
        l2.setBounds(160,290,600,20);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        l2.setForeground(Color.red);
        add(l2);
        
        t.start();
        
    }
    
    public static void main(String[] args) {
        new LoadingScreen("").setVisible(true);
    }
}
