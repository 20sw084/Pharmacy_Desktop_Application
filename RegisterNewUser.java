package Pharmacy_Management_System;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class RegisterNewUser extends JFrame implements ActionListener{ 
    private JFrame jf;
    private JLabel jl0,jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    private JTextField jtf1,jtf2,jtf3;
    private JPasswordField jpf1,jpf2;
    private JButton jb1,jb2;
    private JComboBox jcb1,jcb2;
    private Container c;
    RegisterNewUser(){
        jf=new JFrame("Registration Form"); 
        c=jf.getContentPane();
        jf.setLocation(100,100);
        jf.setSize(700,650);
        c.setBackground(Color.WHITE);
        // c.setBackground(new Color(0,153,0));
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jl0=new JLabel("Registeration Form"); 
        jl1=new JLabel("NAME"); 
        jl2=new JLabel("FATHER NAME");
        jl3=new JLabel("GENDER"); 
        jl4=new JLabel("PASSWORD");
        jl5=new JLabel("CONFIRM PASSWORD");
        jl6=new JLabel("AGE");
        jl7=new JLabel("BLOOD GROUP"); 
        jl0.setBounds(150,0, 400, 100);
        jl1.setBounds(10,100,350,50);
        jl2.setBounds(10,150,350,50);
        jl3.setBounds(10,200,350,50);
        jl4.setBounds(10,250,350,50);
        jl5.setBounds(10,300,350,50); 
        jl6.setBounds(10,350,350,50);
        jl7.setBounds(10,400,350,50);
        Font f=new Font("SERIF",Font.PLAIN,30);
        jl0.setFont(new Font("SERIF",Font.ITALIC,50));
        jl1.setFont(f);
        jl2.setFont(f);
        jl3.setFont(f);
        jl4.setFont(f);
        jl5.setFont(f);
        jl6.setFont(f);
        jl7.setFont(f);
        jl0.setForeground(new Color(0,153,0));
        jl1.setForeground(new Color(0,153,0));
        jl2.setForeground(new Color(0,153,0));
        jl3.setForeground(new Color(0,153,0));
        jl4.setForeground(new Color(0,153,0));
        jl5.setForeground(new Color(0,153,0));
        jl6.setForeground(new Color(0,153,0));
        jl7.setForeground(new Color(0,153,0));
        c.add(jl0);
        c.add(jl1);
        c.add(jl2);
        c.add(jl3);
        c.add(jl4);
        c.add(jl5);
        c.add(jl6);
        c.add(jl7);
        jtf1=new JTextField();
        jtf1.setBounds(350,100,320,50);
        jtf1.setFont(f);
        jtf1.setForeground(new Color(0,153,0));
        c.add(jtf1);
        jtf2=new JTextField();
        jtf2.setBounds(350,150,320,50);
        jtf2.setFont(f);
        jtf2.setForeground(new Color(0,153,0));
        c.add(jtf2);
        String[] str={"SELECT","Male","Female","Other"};
        jcb1=new JComboBox(str);
        jcb1.setFont(f);
        jcb1.setForeground(new Color(0,153,0));
        jcb1.setBounds(350,200,320,50);
        c.add(jcb1);
        jpf1=new JPasswordField();
        jpf1.setBounds(350,250,320,50);
        jpf1.setFont(f);
        jpf1.setForeground(new Color(0,153,0));
        c.add(jpf1);
        jpf2=new JPasswordField();
        jpf2.setBounds(350,300,320,50);
        jpf2.setFont(f);
        jpf2.setForeground(new Color(0,153,0));
        c.add(jpf2);
        jtf3=new JTextField();
        jtf3.setBounds(350,350,320,50);
        jtf3.setFont(f);
        jtf3.setForeground(new Color(0,153,0));
        c.add(jtf3);
        String s[]={"Select","A+","A-","B+","B-","AB+","AB-","O+","O-"};
        jcb2=new JComboBox(s);
        jcb2.setBounds(350,400,320,50);
        jcb2.setForeground(new Color(0,153,0));
        jcb2.setFont(f);
        c.add(jcb2);
        jb1=new JButton("Register");
        jb1.setBounds(40,500,200,50);
        jb1.addActionListener(this);
        jb1.setBackground(Color.WHITE);
        jb1.setForeground(new Color(0,153,0));
        jb1.setFont(new Font("SERIF",Font.BOLD,30));
        c.add(jb1);
        jb2=new JButton("Reset");
        jb2.setBounds(300,500,200,50);
        jb2.addActionListener(this);
        jb2.setBackground(Color.WHITE);
        jb2.setForeground(new Color(0,153,0));
        jb2.setFont(new Font("SERIF",Font.BOLD,30));
        c.add(jb2);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) { 
        if(ae.getSource()==jb1)
        {   
            if(!(jtf1.getText().equals("")))
            {
            String p1 = jpf1.getText();
            String p2 = jpf2.getText();
          
        if(p1.equals(p2))
        {   
            Connection conn=null;
        int idFound=0;
        try{
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb","root","root"); 
        Statement stmt=conn.createStatement();
        ResultSet res =stmt.executeQuery("SELECT name,password From UserRecord"); 
        while(res.next()){  
            if(res.getString(1).equalsIgnoreCase(jtf1.getText())){          
           idFound++;
            }
        }
        if(idFound==0){
            PreparedStatement Pstatement=conn.prepareStatement("insert into pharmacydb.UserRecord values(?,?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,null);
                Pstatement.setString(2,jtf1.getText());
                Pstatement.setString(3,jtf2.getText());
                Pstatement.setString(4,jcb1.getSelectedItem().toString());
                Pstatement.setString(5,jpf1.getText());
                Pstatement.setString(6,jtf3.getText());
                Pstatement.setString(7,jcb2.getSelectedItem().toString());
                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(jf,"Registered Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
            // int rowsAffected=stmt.executeUpdate("INSERT INTO `pharmacydb`.`UserRecord` (`name`, `fathername`, `gender`, `password`, `city`, `email`) VALUES ('jtf1.getText()','jtf2.getText()','jcb.getSelectedItem()','jpf1.getText()','jtf3.getText()','jtf4.getText()');");
            // JOptionPane.showMessageDialog(jf,rowsAffected+" Rows Affected.  Registered Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(jf,"Invalid UserName or Password","Error",JOptionPane.ERROR_MESSAGE);
            // jtf1.setText(null);
            // jpf1.setText(null);
        }
        else {
            JOptionPane.showMessageDialog(jf,"User Already Exists.Try for Different One ","Error",JOptionPane.ERROR_MESSAGE);
        }
        conn.close();
        }
        catch(Exception e){ 
            System.out.println(e.getMessage());
        }
        }
        else{
        JOptionPane.showMessageDialog(jf,"Passwords didnt Matched","Alert",JOptionPane.WARNING_MESSAGE);  
        }
        }
        else{
            JOptionPane.showMessageDialog(jf,"User Name should not be Empty","Error",JOptionPane.WARNING_MESSAGE);
        }
        jtf1.setText(null);
        jtf2.setText(null);
        jtf3.setText(null);
        jcb2.setSelectedIndex(0);
        jpf1.setText(null);
        jpf2.setText(null);
        jcb1.setSelectedIndex(0);        
        }
        else if(ae.getSource()==jb2){    
          jtf1.setText(null);
          jtf2.setText(null);
          jtf3.setText(null);
          jcb2.setSelectedIndex(0);
          jpf1.setText(null);
          jpf2.setText(null);
          jcb1.setSelectedIndex(0);
        }
    }
}
