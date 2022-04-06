package Pharmacy_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminRights implements ActionListener  {   
    JFrame jf;
    JButton btnRegisterNewUser,btnDeleteUser;
    BoxLayout bl;
    JPanel jp;
    private JLabel forImg;
    AdminRights(){
        jf=new JFrame();
        jp=new JPanel();
        jp.setLayout(null);

    ImageIcon icon = new  ImageIcon("C:/Users/Lenovo/eclipse-workspace/firstHibernate/src/Pharamacy_Management_System/AdminRights.jpg");
    Image img=icon.getImage();
    Image tempImage=img.getScaledInstance(700,650,Image.SCALE_SMOOTH);
    icon=new ImageIcon(tempImage);
    forImg=new JLabel("",icon,JLabel.CENTER);
    forImg.setBounds(0, 0, 700, 650);
    jp.setBounds(0,0,700,500);
    jp.add(forImg);
    
        btnRegisterNewUser =  new JButton("Register New User");
        btnRegisterNewUser.setBounds(300,400,350,70);
        btnRegisterNewUser.setBackground(Color.WHITE);
        btnRegisterNewUser.addActionListener(this);
        btnRegisterNewUser.setFont(new Font("Tahoma", Font.BOLD,30));
        
        btnDeleteUser = new JButton("Delete Existing User");
        btnDeleteUser.setBounds(300,500,350,70);
        btnDeleteUser.setBackground(Color.WHITE);
        btnDeleteUser.addActionListener(this);
        btnDeleteUser.setFont(new Font("Tahoma",Font.BOLD, 30));
		
        jp.add(btnRegisterNewUser);
        jp.add(btnDeleteUser);
        jf.add(jp);
        jf.setSize(700,650);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){     
        if(ae.getSource()==btnDeleteUser){
            jf.dispose();
            new DeleteExistingUser(); 
        }        
        else if(ae.getSource()==btnRegisterNewUser){
            jf.dispose();
            new RegisterNewUser();
        }
    }
}
