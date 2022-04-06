package Pharmacy_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;

public class AdminLogin implements ActionListener { 
    private JFrame jf;
    private JLabel jl0,jl1,jl2; 
    private JTextField jtf1;
    private JPasswordField jpf1;
    private JButton jb1; 
    private Container c;
    public AdminLogin(){
        jf=new JFrame("Admin Login");
        jf.setLayout(null);
        
        jf.setForeground(new Color(0,153,0));
        jf.setBackground(Color.WHITE);

        c=jf.getContentPane();
        jpf1=new JPasswordField();
        jl0=new JLabel("Admin Login");
        jl0.setFont(new Font("Serif",Font.ITALIC+Font.BOLD,45));   
        jl0.setForeground(new Color(0,153,0));
        jl0.setBounds(10,10,300,100); 
        c.add(jl0);
        
        jl1=new JLabel("Admin ID:"); 
        jl1.setFont(new Font("Serif",Font.PLAIN,24));   
        jl1.setForeground(new Color(0,153,0));
        jl1.setBounds(10,200,150,60); 
        c.add(jl1);

        jl2=new JLabel("Password:"); 
        jl2.setFont(new Font("Serif",Font.PLAIN,24)); 
        jl2.setForeground(new Color(0,153,0));  
        jl2.setBounds(10,300,150,60); 
        c.add(jl2);

        jtf1=new JTextField();
        jtf1.setFont(new Font("Serif",Font.PLAIN,24));
        jtf1.setForeground(new Color(0,153,0));
        jtf1.setBounds(210,200,200,50);
        c.add(jtf1);

        jpf1=new JPasswordField();
        jpf1.setFont(new Font("Serif",Font.PLAIN,24));
        jpf1.setForeground(new Color(0,153,0));
        jpf1.setBounds(210,300,200,50);
        c.add(jpf1);

        jb1=new JButton("Login");
        jb1.setFont(new Font("Serif",Font.BOLD,24));
        jb1.setBounds(180,450,200,50);
        jb1.setForeground(new Color(0,153,0));
        jb1.setBackground(Color.WHITE);
        jb1.addActionListener(this);
        c.add(jb1);
            
        // jf.setBackground(new Color(0,153,0));
        jf.setVisible(true);
        jf.setSize(700,650);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){  
        if(jtf1.getText().equalsIgnoreCase("Admin")&&jpf1.getText().equals("admin")){
            JOptionPane.showMessageDialog(jf,"Access Granted.","Success",JOptionPane.INFORMATION_MESSAGE);
            jf.dispose();
            new AdminRights();
        }
        else{
            JOptionPane.showMessageDialog(jf,"Access Denied.","Error",JOptionPane.WARNING_MESSAGE);
        }
    }  
}
