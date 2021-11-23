
package Travel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author rishabburman
 */
public class BookFlight extends JFrame implements ActionListener{
    
    JComboBox c1,c2;
    JTextField t1,t2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b1,b2,b3;

    BookFlight(String username){
        setBounds(250,150,950,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        l1 = new JLabel("BOOK FLIGHT");
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
        
        l4 = new JLabel("Enter Date : ");
        l4.setFont(new Font("Tahoma",Font.PLAIN,18));
        l4.setBounds(100,150,200,20);
        add(l4);
        
        t2 = new JTextField("YYYY-MM-DD");
        t2.setBounds(300,150,200,20);
        add(t2);
        
        l5 = new JLabel("Number of seats :");
        l5.setFont(new Font("Tahoma",Font.PLAIN,18));
        l5.setBounds(100,200,200,20);
        add(l5);
        
        t1 = new JTextField();
        t1.setBounds(300,200,200,20);
        add(t1);
        
        
        l11 = new JLabel("Enter Source :");
        l11.setFont(new Font("Tahoma",Font.PLAIN,18));
        l11.setBounds(100,250,200,20);
        add(l11);
        
        c1 = new JComboBox();
        c1=new JComboBox(new String[] {"Delhi" , "Mumbai" , "Goa" , "Calcutta" , "Chennai" , "Jaipur"});
        c1.setBounds(300,250,200,20);
        add(c1);
        
        
        l6 = new JLabel("Enter Destination : ");
        l6.setFont(new Font("Tahoma",Font.PLAIN,18));
        l6.setBounds(100,300,200,20);
        add(l6);
        
        c2 = new JComboBox();
        c2=new JComboBox(new String[] {"Delhi" , "Mumbai" , "Goa" , "Calcutta" , "Chennai" , "Jaipur"});
        c2.setBounds(300,300,200,20);
        add(c2);
        
        
        l12 = new JLabel("Email : ");
        l12.setFont(new Font("Tahoma",Font.PLAIN,18));
        l12.setBounds(100,350,200,20);
        add(l12);
        
        
        //Database
        l13 = new JLabel();
        l13.setFont(new Font("Tahoma",Font.PLAIN,18));
        l13.setBounds(300,350,200,20);
        add(l13);
        
        
        l7 = new JLabel("Mobile Number : ");
        l7.setFont(new Font("Tahoma",Font.PLAIN,18));
        l7.setBounds(100,400,200,20);
        add(l7);
        
        //To be taken from database
        l8 = new JLabel();
        l8.setFont(new Font("Tahoma",Font.PLAIN,18));
        l8.setBounds(300,400,100,20);
        add(l8);
        
        l9 = new JLabel("Total Price : ");
        l9.setFont(new Font("Tahoma",Font.PLAIN,18));
        l9.setBounds(100,450,200,20);
        add(l9);
        
        //To be taken from database
        l10 = new JLabel();
        l10.setFont(new Font("Tahoma",Font.PLAIN,18));
        l10.setBounds(300,450,100,20);
        add(l10);
        
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
                l8.setText(rs.getString("mobile"));
                l13.setText(rs.getString("email"));
                
            }
        }catch(Exception e){
            
        }
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Connection1 c = new Connection1();
                ResultSet rs = c.s.executeQuery("select*from flight where source = '"+c1.getSelectedItem()+"' and destination = '"+c2.getSelectedItem()+"'");
                while(rs.next()){
                    int seats = Integer.parseInt(rs.getString("seats"));
                    int price = Integer.parseInt(rs.getString("price"));
                    
                    int seatsbook = Integer.parseInt(t1.getText());
                    
                    String date = t2.getText();
                    //String food = (String)c3.getSelectedItem();
                    
                    if(seatsbook > 0 && (seats - seatsbook)>=0){
                        int total=0;
                        total=total + (seatsbook*price);
                        l10.setText(""+total);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please enter valid number of seats to be booked");
                    }
                }
            }catch(Exception e){
                
            }
        }
        else if(ae.getSource()==b2){
            try{
                Connection1 c = new Connection1();
                c.s.executeUpdate("insert into bookflight values('"+l3.getText()+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c1.getSelectedItem()+"', '"+c2.getSelectedItem()+"', '"+l8.getText()+"', '"+l10.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Flight Booked Successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b3){
            this.setVisible(false);
        }
    }
   
    public static void main(String[] args) {
        new BookFlight("").setVisible(true);
    }
    
}


