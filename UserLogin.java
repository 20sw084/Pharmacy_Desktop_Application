package Pharmacy_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.sql.*;
import java.awt.event.*;

public class UserLogin implements ActionListener { 
    public JFrame jframe;
    private JLabel jl0,jl1,jl2; 
    private JTextField jtf1;
    public String userName;
    public int idFound;
    private JPasswordField jpf1;
    private JButton jb1; 
    private Container c;
    public UserLogin(){
        idFound=0;
        jframe=new JFrame("User Login");
        jframe.setLayout(null);
        c=jframe.getContentPane();
        c.setForeground(new Color(0,153,0));
        c.setBackground(Color.WHITE);
        jpf1=new JPasswordField();
        
        JMenu menu;  
        JMenuItem i1;
        JMenuBar mb=new JMenuBar();  
        menu=new JMenu(" BACK ");  
        i1=new JMenuItem("Back"); 
        i1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){ 
            jframe.dispose();
            new FrontPage();
        }
        });
        menu.add(i1);
        mb.add(menu);  
        jframe.setJMenuBar(mb);  

        jl0=new JLabel("User Login");
        jl0.setFont(new Font("Serif",Font.ITALIC+Font.BOLD,45)); 
        jl0.setForeground(new Color(0,153,0));  
        jl0.setBounds(10,10,300,100); 
        c.add(jl0);
        
        jl1=new JLabel("User ID:"); 
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
        jb1.setForeground(new Color(0,153,0));  
        jb1.setBackground(Color.WHITE);  
        jb1.setBounds(180,450,200,50);
        jb1.addActionListener(this);
        c.add(jb1);

        jframe.setVisible(true);
        jframe.setSize(700,650);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){  
        Connection conn=null;
        try{
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb","root","root"); 
        }
        catch(SQLException sqle) {  
           System.out.println( sqle.getMessage());
        }
        try{
        Statement stmt=conn.createStatement();
        ResultSet res =stmt.executeQuery("SELECT name,password From UserRecord"); 
        while(res.next()){            
            if(res.getString(1).equalsIgnoreCase(jtf1.getText()) && res.getString(2).equals(jpf1.getText())){
            //System.out.println(res.getString(1)+"\t\t"+res.getString(2));
            JOptionPane.showMessageDialog(jframe,"Login Successful","Welcome "+res.getString(1),JOptionPane.OK_OPTION);
            userName=jtf1.getText();
            jtf1.setText(null);
            jpf1.setText(null);
            idFound++;
            break;
            }
        }
        if(idFound==0){
            JOptionPane.showMessageDialog(jframe," Invalid UserName or Password ","Error",JOptionPane.ERROR_MESSAGE);
            jtf1.setText(null);
            jpf1.setText(null);
        }
        if(idFound==1){
            conn.close();
            jframe.dispose();
            new Interface(userName);
        } 
        // conn.close();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
    }  
}
