package Pharmacy_Management_System;
import javax.swing.*;
import java.lang.Thread;
import java.awt.*;

public class Pharm_Manag_Sys {  
    private JFrame jf;
    private JPanel header;
    private JLabel name,background;
    public Pharm_Manag_Sys(){
    jf=new JFrame("Pharamacy Management System");
 
    jf.setLayout(null);
    jf.setSize(700,650);

    header=new JPanel();
    header.setBackground(new Color(0,0,0,80));
    header.setBounds(0,0,700,100);
    name=new JLabel("Welcome to Pharamacy Managment System"); 
    name.setFont(new Font("Monotype Corsiva",Font.BOLD,40)); 
    name.setBounds(200,25,400,50); 
    name.setForeground(new Color(0,153,0));    
    header.add(name);
    jf.add(header);
    ImageIcon icon = new  ImageIcon("/Pharmacy_Management_System/Main.jpg");
    Image img=icon.getImage();
    Image tempImage=img.getScaledInstance(700,650,Image.SCALE_SMOOTH);
    icon=new ImageIcon(tempImage);
    background=new JLabel("",icon,JLabel.CENTER);
    background.add(header);
    background.setBounds(0, 0, 700, 650);
    
    jf.add(background);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
        Thread.currentThread();
        Thread.sleep(3000);
        }
        catch(Exception e){
            e.getMessage();
        }
     jf.dispose();
    new FrontPage();
    }
}
