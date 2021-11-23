
package Travel.Management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
    Dashboard(String user){
        this.username = user;
        setExtendedState(JFrame.MAXIMIZED_BOTH);//This will make your frame to the size of screen
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBounds(0,0,1440,60);
        p1.setLayout(null);
        p1.setBackground(new Color(60, 187, 177));
        add(p1);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,50,250,900);
        p2.setBackground(new Color(60,187,177));
        add(p2);
        
        JLabel l3 = new JLabel("Travel and Tourism Management System");
        l3.setBounds(520,100,600,50);
        l3.setFont(new Font("Sans-Serif",Font.PLAIN,30));
        add(l3);
        
        JPanel p3 = new JPanel();
        p3.setBounds(680,700,300,40);
        p3.setBackground(Color.WHITE);
        add(p3);
        JLabel l4 = new JLabel("Hope you have a great trip :)");
        //l4.setBounds(700,700,300,30);
        l4.setFont(new Font("Tahoma",Font.PLAIN,22));
        p3.add(l4);
        
        //Various Buttons in dashboard
        b1 = new JButton("Add details");
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBackground(new Color(60,187,177));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.setBounds(0,5,250,50);
        b1.setMargin(new Insets(0,0,0,110));
        b1.addActionListener(this);
        p2.add(b1);
        
        b2 = new JButton("Update details");
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBackground(new Color(60,187,177));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.setBounds(0,55,250,50);
        b2.setMargin(new Insets(0,0,0,80));
        b2.addActionListener(this);
        p2.add(b2);
        
        b3 = new JButton("View details");
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBackground(new Color(60,187,177));
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.setBounds(0,105,250,50);
        b3.setMargin(new Insets(0,0,0,100));
        b3.addActionListener(this);
        p2.add(b3);
        
        b4 = new JButton("Delete details");
        b4.setOpaque(true);
        b4.setBorderPainted(false);
        b4.setBackground(new Color(60,187,177));
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4.setBounds(0,155,250,50);
        b4.setMargin(new Insets(0,0,0,85));
        b4.addActionListener(this);
        p2.add(b4);
        
        /*
        b5 = new JButton("Check Flights");
        b5.setOpaque(true);
        b5.setBorderPainted(false);
        b5.setBackground(new Color(60,187,177));
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Tahoma",Font.PLAIN,20));
        b5.setBounds(0,205,250,50);
        b5.setMargin(new Insets(0,0,0,92));
        b5.addActionListener(this);
        p2.add(b5);
        */
        
        b6 = new JButton("Book Flights");
        b6.setOpaque(true);
        b6.setBorderPainted(false);
        b6.setBackground(new Color(60,187,177));
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Tahoma",Font.PLAIN,20));
        b6.setBounds(0,255,250,50);
        b6.setMargin(new Insets(0,0,0,98));
        b6.addActionListener(this);
        p2.add(b6);
        
        b7 = new JButton("View Booked Flight");
        b7.setOpaque(true);
        b7.setBorderPainted(false);
        b7.setBackground(new Color(60,187,177));
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("Tahoma",Font.PLAIN,20));
        b7.setBounds(0,305,250,50);
        b7.setMargin(new Insets(0,0,0,35));
        b7.addActionListener(this);
        p2.add(b7);
        
        /*
        b8 = new JButton("View Hotels");
        b8.setOpaque(true);
        b8.setBorderPainted(false);
        b8.setBackground(new Color(60,187,177));
        b8.setForeground(Color.WHITE);
        b8.setFont(new Font("Tahoma",Font.PLAIN,20));
        b8.setBounds(0,355,250,50);
        b8.setMargin(new Insets(0,0,0,100));
        b8.addActionListener(this);
        p2.add(b8);
        */
        
        b9 = new JButton("Book Hotel");
        b9.setOpaque(true);
        b9.setBorderPainted(false);
        b9.setBackground(new Color(60,187,177));
        b9.setForeground(Color.WHITE);
        b9.setFont(new Font("Tahoma",Font.PLAIN,20));
        b9.setBounds(0,405,250,50);
        b9.setMargin(new Insets(0,0,0,108));
        b9.addActionListener(this);
        p2.add(b9);
        
        b10 = new JButton("View Booked Hotel");
        b10.setOpaque(true);
        b10.setBorderPainted(false);
        b10.setBackground(new Color(60,187,177));
        b10.setForeground(Color.WHITE);
        b10.setFont(new Font("Tahoma",Font.PLAIN,20));
        b10.setBounds(0,455,250,50);
        b10.setMargin(new Insets(0,0,0,35));
        b10.addActionListener(this);
        p2.add(b10);
        
        
        b11 = new JButton("View Hotels");
        b11.setOpaque(true);
        b11.setBorderPainted(false);
        b11.setBackground(new Color(60,187,177));
        b11.setForeground(Color.WHITE);
        b11.setFont(new Font("Tahoma",Font.PLAIN,20));
        b11.setBounds(0,505,250,50);
        b11.setMargin(new Insets(0,0,0,95));
        b11.addActionListener(this);
        p2.add(b11);
        
        
        b12 = new JButton("Payment");
        b12.setOpaque(true);
        b12.setBorderPainted(false);
        b12.setBackground(new Color(60,187,177));
        b12.setForeground(Color.WHITE);
        b12.setFont(new Font("Tahoma",Font.PLAIN,20));
        b12.setBounds(0,555,250,50);
        b12.setMargin(new Insets(0,0,0,128));
        b12.addActionListener(this);
        p2.add(b12);
        
        b13 = new JButton("About Us");
        b13.setOpaque(true);
        b13.setBorderPainted(false);
        b13.setBackground(new Color(60,187,177));
        b13.setForeground(Color.WHITE);
        b13.setFont(new Font("Tahoma",Font.PLAIN,20));
        b13.setBounds(0,705,250,50);
        b13.setMargin(new Insets(0,0,0,120));
        b13.addActionListener(this);
        p2.add(b13);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/images/dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1440,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//Because we cant put an Image object inside a label
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1440,900);//My Screen size is 1440 x 900
        add(l1);
        
        JLabel l2 = new JLabel("DASHBOARD");
        l2.setBounds(700,18,200,30);
        l2.setFont(new Font("Raleway",Font.PLAIN,30));
        p1.add(l2);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddDetails(username).setVisible(true);
        }
        else if(ae.getSource()==b2){
            new UpdateDetails(username).setVisible(true);
        }
        else if(ae.getSource()==b3){
            new ViewDetails(username).setVisible(true);
        }
        else if(ae.getSource()==b4){
            new DeleteDetails(username).setVisible(true);
        }
        
        else if(ae.getSource()==b6){
            new BookFlight(username).setVisible(true);
        }
        else if(ae.getSource()==b7){
            new ViewBookedFlight(username).setVisible(true);
        }
        else if(ae.getSource()==b9){
            new BookHotel(username).setVisible(true);
        }
        else if(ae.getSource()==b10){
            new ViewBookedHotel(username).setVisible(true);
        }
        else if(ae.getSource()==b11){
            new HotelImages().setVisible(true);
        }
        else if(ae.getSource()==b12){
            new Payment().setVisible(true);
        }
        else if(ae.getSource()==b13){
            new About().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Dashboard("").setVisible(true);
    }
}
