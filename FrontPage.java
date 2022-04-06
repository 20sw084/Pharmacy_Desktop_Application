package Pharmacy_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class FrontPage implements ActionListener {
  private JFrame jf;
  private JPanel jp1,jp2;
  private JLabel forImg;
  private JButton btnAdminLogin,btnUserLogin; 
  private Container c;
  public FrontPage() {
    jf = new JFrame();
    // c = jf.getContentPane();
    jp1 = new JPanel();
    jp1.setLayout(null);
    JMenu menu;
    JMenuItem i1;
    JMenuBar mb = new JMenuBar();
    menu = new JMenu(" BACK ");
    i1 = new JMenuItem("Back");
    i1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jf.dispose();
        new Pharm_Manag_Sys();
      }
    });
    menu.add(i1);
    mb.add(menu);
    jf.setJMenuBar(mb);
    jp1.setLayout(new FlowLayout()); 
    
    ImageIcon icon = new  ImageIcon("C:/Users/Lenovo/Documents/eclipse-workspace/firstHibernate/src/Pharamacy_Management_System/FrontPage.jpg");
    Image img=icon.getImage();
    Image tempImage=img.getScaledInstance(700,650,Image.SCALE_SMOOTH);
    icon=new ImageIcon(tempImage);
    forImg=new JLabel("",icon,JLabel.CENTER);
    // For Full
    // forImg.setBounds(0, 0, 685, 595);
    // For Vertical Buttons
    // forImg.setBounds(0, 0, 685, 595);
    // For Horizontal Buttons
    forImg.setBounds(0, 0, 675, 500);
    jp1.setBounds(0,0,700,500);

    jp1.add(forImg);

    btnUserLogin = new JButton("User Mode");
    // btnUserLogin.setVisible(true);
    btnUserLogin.setBackground(Color.WHITE);
    // btnUserLogin.setBounds(400,400,200,70);
    btnUserLogin.setBounds(40,515,200,70);
    btnUserLogin.addActionListener(this);
    btnUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));

    btnAdminLogin = new JButton("Admin Mode");
    // btnUserLogin.setVisible(true);
    btnAdminLogin.setBackground(Color.WHITE);
    // btnAdminLogin.setBounds(400,500,200,70);
    btnAdminLogin.setBounds(440,515,200,70);
    btnAdminLogin.addActionListener(this);
    btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
    jp2=new JPanel();
    jp2.setLayout(null);
    jp2.add(btnAdminLogin);
    jp2.add(btnUserLogin);
    jp2.setBounds(0,500,700,120);
    jf.add(jp1);
    jf.add(jp2);
    jf.setVisible(true);
    jf.setSize(700, 650);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == btnAdminLogin) {
      jf.dispose();
      new AdminLogin();
    } else if (ae.getSource() == btnUserLogin) {
      jf.dispose();
      new UserLogin();
    }
  }
}
