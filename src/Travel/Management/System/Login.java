package Travel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//This for ActionListener
import java.sql.*;//ResultSet Class is present inside
//Color class is in awt 
/**
 *
 * @author rishabburman
 */
public class Login extends JFrame implements ActionListener{
    
    JButton b1,b2,b3; // Declared here so that they can be used outside Login() as well
    JTextField t1;
    JPasswordField t2;
    
    Login(){
        
        setLayout(null);//Default : BorderLayout
        getContentPane().setBackground(Color.WHITE);
        //getContentPane selects the whole frame 
        setBounds(400,200,685,385);
        // SetSize takes 2 arguments : length and width respectively to set size of frame
        // SetLocation takes two arguments distance from left and distance from top respectively
        // SetBounds takes 4 arguments and is a combination of location and size. The first two arguments are for location
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.CYAN);
        p1.setBounds(0,0,300,385);//setBounds for p1
        p1.setLayout(null);
        add(p1);//add() adds the panel onto the frame
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/images/login.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(300,385,Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2);
        JLabel l1=new JLabel(i1);
        l1.setBounds(50,80,200,200);
        p1.add(l1);
        
        //Panel for username and password
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(340,0,300,385);
        add(p2);
        
        //Label and textfield for username
        JLabel l2 = new JLabel("Username");
        l2.setBounds(40,50,100,15);
        p2.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(37,70,200,30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);
        
        //Label and textfield for password
        JLabel l3 = new JLabel("Password");
        l3.setBounds(40,140,100,15);
        p2.add(l3);
        
        //We use PasswordField for hiding the password
        t2 = new JPasswordField();
        t2.setBounds(37,160,200,30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);
        
        //Button to login and signup
        b1 = new JButton("Login");
        b1.setBounds(35,230,100,40);
        b1.setBackground(Color.CYAN);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        p2.add(b1);
        
        b2 = new JButton("Sign Up");
        b2.setBounds(140,230,100,40);
        b2.setBackground(Color.CYAN);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        p2.add(b2);
        
        
        //Button for forgot password
        b3 = new JButton("Forgot Password?");
        b3.setBounds(38,280,200,40);
        b3.setBackground(Color.WHITE);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        p2.add(b3);
        
        setVisible(true);
    }
    
    //Overriding ActionListener class' actionPerformed() because its an abstract method
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            try{
                String username = t1.getText();
                String password = new String(t2.getPassword());
                String sql = "select*from account where username = '"+username+"'AND password = '"+password+"'";
                Connection1 c = new Connection1();
                ResultSet rs = c.s.executeQuery(sql);
                //rs.next() jumps from column to column of the selected row
                //rs.next() will only work if we find the selected values inside our database
                if(rs.next()){
                    this.setVisible(false);
                    new LoadingScreen(username).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login Details");
                }
            }catch(Exception e){
                
            }
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
        else if(ae.getSource() == b3){
            this.setVisible(false);
            new ForgetPassword().setVisible(true);
        }    
        
    }
    public static void main(String[] args) {
        new Login();
    }
}
