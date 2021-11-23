/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author rishabburman
 */
public class BookHotel extends JFrame implements ActionListener{
    
    JComboBox c1,c2,c3;
    JTextField t1,t2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JButton b1,b2,b3;
    BookHotel(String username){
        setBounds(250,150,950,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        l1 = new JLabel("BOOK HOTEL");
        l1.setFont(new Font("Tahoma",Font.PLAIN,40));
        l1.setBounds(340,20,300,50);
        add(l1);
        
        l2 = new JLabel("Username : ");
        l2.setFont(new Font("Tahoma",Font.PLAIN,18));
        l2.setBounds(100,100,200,20);
        add(l2);
        
        //To be taken from database
        l3 = new JLabel();
        l3.setFont(new Font("Tahoma",Font.PLAIN,18));
        l3.setBounds(300,100,100,20);
        add(l3);
        
        l4 = new JLabel("Select Hotel : ");
        l4.setFont(new Font("Tahoma",Font.PLAIN,18));
        l4.setBounds(100,150,200,20);
        add(l4);
        
        c1 = new JComboBox();
        c1=new JComboBox(new String[] {"Westin" , "The Taj" , "Jaypee Continental" , "Leela Palace" , "Holiday Inn"});
        c1.setBounds(300,150,200,20);
        add(c1);
        
        l5 = new JLabel("Number of rooms :");
        l5.setFont(new Font("Tahoma",Font.PLAIN,18));
        l5.setBounds(100,200,200,20);
        add(l5);
        
        t1 = new JTextField();
        t1.setBounds(300,200,200,20);
        add(t1);
        
        l6 = new JLabel("Number of days :");
        l6.setFont(new Font("Tahoma",Font.PLAIN,18));
        l6.setBounds(100,250,200,20);
        add(l6);
        
        t2 = new JTextField();
        t2.setBounds(300,250,200,20);
        add(t2);
        
        l7 = new JLabel("Choice of Room : ");
        l7.setFont(new Font("Tahoma",Font.PLAIN,18));
        l7.setBounds(100,300,200,20);
        add(l7);
        
        c2 = new JComboBox();
        c2=new JComboBox(new String[] {"Single Occupancy" , "Double Occupancy" , "Deluxe" , "Master Suite" , "Presidential Suite"});
        c2.setBounds(300,300,200,20);
        add(c2);
        
        l8 = new JLabel("Breakfast/Dinner : ");
        l8.setFont(new Font("Tahoma",Font.PLAIN,18));
        l8.setBounds(100,350,200,20);
        add(l8);
        
        c3 = new JComboBox();
        c3=new JComboBox(new String[] {"Only Breakfast" , "Breakfast and Dinner" , "None"});
        c3.setBounds(300,350,200,20);
        add(c3);
        
        l9 = new JLabel("Mobile Number : ");
        l9.setFont(new Font("Tahoma",Font.PLAIN,18));
        l9.setBounds(100,400,200,20);
        add(l9);
        
        //To be taken from database
        l10 = new JLabel();
        l10.setFont(new Font("Tahoma",Font.PLAIN,18));
        l10.setBounds(300,400,100,20);
        add(l10);
        
        l11 = new JLabel("Total Price : ");
        l11.setFont(new Font("Tahoma",Font.PLAIN,18));
        l11.setBounds(100,450,200,20);
        add(l11);
        
        //To be taken from database
        l12 = new JLabel();
        l12.setFont(new Font("Tahoma",Font.PLAIN,18));
        l12.setBounds(300,450,100,20);
        add(l12);
        
        b1 = new JButton("Check price");
        b1.setBounds(100,500,125,50);
        b1.setOpaque(true);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Book");
        b2.setBounds(250,500,125,50);
        b2.setOpaque(true);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBounds(400,500,125,50);
        b3.setOpaque(true);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBorderPainted(false);
        b3.addActionListener(this);
        add(b3);
        
        
        try{
            Connection1 c = new Connection1();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                l3.setText(rs.getString("username"));
                l10.setText(rs.getString("mobile"));
                //l12.setText(rs.getString("username"));
                
            }
        }catch(Exception e){
            
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Connection1 c = new Connection1();
                ResultSet rs = c.s.executeQuery("select*from hotel where name = '"+c1.getSelectedItem()+"'");
                while(rs.next()){
                    int single = Integer.parseInt(rs.getString("single"));
                    int doub = Integer.parseInt(rs.getString("doub"));
                    int deluxe = Integer.parseInt(rs.getString("deluxe"));
                    int master = Integer.parseInt(rs.getString("master"));
                    int presidential = Integer.parseInt(rs.getString("presidential"));
                    int breakfast = Integer.parseInt(rs.getString("breakfast"));
                    int breakdinner = Integer.parseInt(rs.getString("breakdinner"));
                    
                    int rooms = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());
                    
                    String room = (String)c2.getSelectedItem();
                    String food = (String)c3.getSelectedItem();
                    
                    if(rooms * days > 0){
                        int total=0;
                        if(room.equals("Single Occupancy")){
                            total+=single;
                        }
                        if(room.equals("Double Occupancy")){
                            total+=doub;
                        }
                        if(room.equals("Deluxe")){
                            total+=deluxe;
                        }
                        if(room.equals("Master Suite")){
                            total+=master;
                        }
                        if(room.equals("Presidential Suite")){
                            total+=presidential;
                        }
                        if(food.equals("Only Breakfast")){
                            total+=breakfast;
                        }
                        if(food.equals("Breakfast and Dinner")){
                            total+=breakdinner;
                        }
                        total = total * rooms * days;
                        l12.setText(""+total);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please enter valid number of days and people");
                    }
                }
            }catch(Exception e){
                
            }
        }
        else if(ae.getSource()==b2){
            try{
                Connection1 c = new Connection1();
                c.s.executeUpdate("Insert into book values('"+l3.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l10.getText()+"', '"+l12.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
            }catch(Exception e){
                
            }
        }
        else if(ae.getSource()==b3){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookHotel("").setVisible(true);
    }
    
}


