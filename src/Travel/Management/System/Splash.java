
package Travel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash {
    public static void main(String[] args)
    {
        SplashFrame frame = new SplashFrame();
        
        frame.setVisible(true);
        int x=1;
        for(int i=1;i<=385;i++,x++){
            frame.setLocation(400,200);
            frame.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){
                
            }
        }
        frame.setVisible(true);//setVisible is inside JFrame class
        //setVisible has a default value=false
    }
}

//Frame will be inside SplashFrame
class SplashFrame extends JFrame implements Runnable{
    // To use JFrame methods such as add()
    // Second mathod of multithreading
    Thread t1;    
    
    
    //Frames are always coded inside constructors because we want it to be the first thing compiled when the object of the class is called
    SplashFrame(){ 
        // Image Icon is inside Swing Package  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/images/splash.jpg")); 
        //ClassLoader is used to pick up resources from the system
        //getSystemResource is a static method in Classloader
        //Image class is in awt Package
        Image i2=i1.getImage().getScaledInstance(600,385,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //Cannot directly add ImageIconClass and hence we need to create a label first
        JLabel l1 = new JLabel(i3);//We put the image inside the label
        
        add(l1);
        
        setUndecorated(true);//To remove the task bar?
        t1=new Thread(this);
        t1.start();
       
        
    }
    //We need to override abstract methods
    public void run(){
        try{
            Thread.sleep(10000);
            this.setVisible(false);
            
            new Login().setVisible(true);
        }catch(Exception e ){
            
        }
    }

}