
package Travel.Management.System;

import javax.swing.*;
import java.awt.*;

public class HotelImages extends JFrame implements Runnable{
    
    Thread t1;
    JLabel l1,l2,l3,l4,l5,l6;
    JLabel Label[] = new JLabel[]{l1,l2,l3,l4,l5,l6};
    HotelImages(){
        setBounds(250,150,950,600);
        
        ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null;
        ImageIcon[] image = new ImageIcon[]{i1,i2,i3,i4,i5,i6};
        
        ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null;
        ImageIcon[] KImage = new ImageIcon[]{k1,k2,k3,k4,k5,k6};
        
        Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null;
        Image JImage[] = new Image[]{j1,j2,j3,j4,j5,j6};
        for(int i=0;i<6;i++){
            image[i] = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/images/hotel"+(i+1)+".jpg"));
            JImage[i] = image[i].getImage().getScaledInstance(950,600,Image.SCALE_DEFAULT);
            KImage[i] = new ImageIcon(JImage[i]);
            this.Label[i] = new JLabel(KImage[i]);
            this.Label[i].setBounds(0,0,950,600);
            add(this.Label[i]);
        }
        
        
        t1 = new Thread(this);
        t1.start();
        
    }
    
    public void run(){
        for(int i=0;i<6;i++){
            try{
                this.Label[i].setVisible(true);
                Thread.sleep(2500);
                this.Label[i].setVisible(false);
                if(i==5)
                    i=0;
            }catch(Exception e){
                
            }
        }
    }
    
    public static void main(String[] args) {
        new HotelImages().setVisible(true);
    }
}
