package Pharmacy_Management_System;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class Interface extends UserLogin {
  private JPanel header, leftPanel, middPanel,middPanel1_ManageMedicine, middPanel2_CheckStock, middPanel3_SaleRecord, middPanel4, middPanel_RecommendedProducts, middPanel41;
  private JLabel name;
  private int idFound,j;
  private Connection conn,conn5;
  private int idFound1;
  public JFrame jf;
  private int stockCheckerAgainst;
  private ResultSet res05, res1, res2, res3, res4, res5, res6, res7, res8;
  private Statement stmt,stmt5;
  PreparedStatement Pstatement;
  int qCount,sCount;
  String dataPanel2[][],dataPanel3[][], dataPanel4[][], dataPanel5[][];
  String columnsPanel2[],columnsPanel3[], columnPanel4[], columnPanel5[];
  private JLabel jl0, jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, dateLabel;
  private JTextField jtf0, jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8;
  private JButton jb1, jb2, jb3, jb4;
  JButton jbManageMedicine, jbCheckStock, jbSaleRecord, btnCustomerDeal , btnRecommendedProducts, btnLogout;
  public Interface(String userName) {
    
    jframe.dispose();
    idFound = 0;
    jf = new JFrame("Main Page");
    conn = null;
    
    
    // Query for reminder of low stock.
    try{  
    	Connection con=DriverManager.getConnection(  
    	"jdbc:mysql://localhost:3306/pharmacydb","root","root");  
    	Statement stmt=con.createStatement();  
    	ResultSet rs=stmt.executeQuery("select COUNT(*) from pharmacydb.stock");  
    	rs.next();
    	qCount=rs.getInt(1);    	
    	Connection con0=DriverManager.getConnection(  
    	"jdbc:mysql://localhost:3306/pharmacydb","root","root");  
    	Statement stmt0=con0.createStatement();  
    	ResultSet rs0=stmt0.executeQuery("SELECT MIN(medicineqty) FROM pharmacydb.stock;");  
    	rs0.next();
    	sCount=rs0.getInt(1);
    	if(qCount<10 && sCount<10) {
    		JOptionPane.showMessageDialog(jf,"Stock is Low!!!","Reminder",JOptionPane.WARNING_MESSAGE);
    	}
    	}
    catch(Exception e){ 
    	System.out.println(e);
    }  
 
    
    //Panels

    header = new JPanel();

    leftPanel = new JPanel();

    middPanel = new JPanel();

    middPanel1_ManageMedicine =new JPanel();

    middPanel2_CheckStock = new JPanel();

    middPanel3_SaleRecord = new JPanel();

    middPanel4 = new JPanel();

    middPanel41 = new JPanel();

    middPanel_RecommendedProducts = new JPanel();
    
    middPanel1_ManageMedicine.setVisible(false);

    middPanel2_CheckStock.setVisible(false);
    
    middPanel3_SaleRecord.setVisible(false);
   
    middPanel4.setVisible(false);
    
    middPanel.setVisible(true);
    
    middPanel_RecommendedProducts.setVisible(false);
    
    
    //Panel 1 Panel

    // Container c;
    // jf1 = new JFrame("Management Frame");
    // c = jf1.getContentPane();
    // jf1.setLocation(100, 100);
    // jf1.setVisible(true);
    middPanel1_ManageMedicine.setBounds(140,70,560,580);
    middPanel1_ManageMedicine.setBackground(Color.WHITE);
    middPanel1_ManageMedicine.setLayout(null); 
    // jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    jl0 = new JLabel("Medicine ID");
    jl0.setBounds(20, 20, 250, 30);
    jl1 = new JLabel("Medicine Name");
    jl1.setBounds(20, 60, 250, 30);
    jl2 = new JLabel("Medicine Type");
    jl2.setBounds(20, 100, 250, 30);
    jl3 = new JLabel("Medicine Company");
    jl3.setBounds(20, 140, 250, 30);
    jl4 = new JLabel("Medicine Quantity");
    jl4.setBounds(20, 180, 250, 30);
    jl5 = new JLabel("Medicine Price");
    jl5.setBounds(20, 220, 250, 30);
    jl6 = new JLabel("Medicine MFG.Date");
    jl6.setBounds(20, 260, 250, 30);
    jl7 = new JLabel("Medicine EXP.Date");
    jl7.setBounds(20, 300, 250, 30);
    jl8 = new JLabel("Medicine Weight(mgs)");
    jl8.setBounds(20, 340, 250, 30);

    Font f = new Font("SERIF", Font.PLAIN, 20);
    jl0.setFont(f);
    jl1.setFont(f);
    jl2.setFont(f);
    jl3.setFont(f);
    jl4.setFont(f);
    jl5.setFont(f);
    jl6.setFont(f);
    jl7.setFont(f);
    jl8.setFont(f);
    middPanel1_ManageMedicine.add(jl0);
    middPanel1_ManageMedicine.add(jl1);
    middPanel1_ManageMedicine.add(jl2);
    middPanel1_ManageMedicine.add(jl3);
    middPanel1_ManageMedicine.add(jl4);
    middPanel1_ManageMedicine.add(jl5);
    middPanel1_ManageMedicine.add(jl6);
    middPanel1_ManageMedicine.add(jl7);
    middPanel1_ManageMedicine.add(jl8);
    // jtf1=new JTextField();
    // jtf1.setBounds(350,100,320,50);
    // jtf1.setFont(f);
    // c.add(jtf1);
    // jtf2=new JTextField();
    // jtf2.setBounds(350,150,320,50);
    // jtf2.setFont(f);
    // c.add(jtf2);
    // String[] str={"SELECT","Male","Female","Other"};
    // jcb1=new JComboBox(str);
    // jcb1.setFont(f);
    // jcb1.setBounds(350,200,320,50);
    // c.add(jcb1);
    // jpf1=new JPasswordField();
    // jpf1.setBounds(350,250,320,50);
    // jpf1.setFont(f);
    // c.add(jpf1);
    // jpf2=new JPasswordField();
    // jpf2.setBounds(350,300,320,50);
    // jpf2.setFont(f);
    // c.add(jpf2);
    // jtf3=new JTextField();
    // jtf3.setBounds(350,350,320,50);
    // jtf3.setFont(f);
    // c.add(jtf3);
    // String s[]={"Select","A+","A-","B+","B-","AB+","AB-","O+","O-"};
    // jcb2=new JComboBox(s);
    // jcb2.setBounds(350,400,320,50);
    // jcb2.setFont(f);
    // c.add(jcb2);

    jtf0 = new JTextField();
    jtf0.setBounds(250, 20, 240, 30);
    jtf0.setFont(f);
    middPanel1_ManageMedicine.add(jtf0);
    jtf1 = new JTextField();
    jtf1.setBounds(250, 60, 240, 30);
    jtf1.setFont(f);
    middPanel1_ManageMedicine.add(jtf1);
    
    
//    JComboBox combobox = new JComboBox(new Object[]{"","Ester", "Jordi",
//            "Jordina", "Jorge", "Sergi"});;
//            combobox.setBounds(250, 60, 240, 30);
//            combobox.setFont(f);
//            AutoCompleteDecorator decorator;
//            AutoCompleteDecorator.decorate(combobox);
    
//    JComboBox TabletCombobox = new JComboBox(new Object[]{""});
//    String pattern=TabletCombobox.getSelectedItem().toString();
//    System.out.println(pattern);
//    //TabletCombobox.setSelectedItem(pattern);
//
//    //AutoCompleteDecorator decorator;
//    //AutoCompleteDecorator.decorate(TabletCombobox);
//    try
//    {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb","root","root");
//        Statement st=con.createStatement();
//        String Query="select name from stock";
//        ResultSet rs=st.executeQuery(Query);
//        int i=1;
//        while(rs.next())
//        {
//            TabletCombobox.addItem(rs.getString(1));
//        }
//    }
//    catch(Exception e)
//    {
//        System.err.println(e);
//    }
//    
    
//  middPanel1_ManageMedicine.add(TabletCombobox);
  
    jtf2 = new JTextField();
    jtf2.setBounds(250, 100, 240, 30);
    jtf2.setFont(f);
    middPanel1_ManageMedicine.add(jtf2);
    jtf3 = new JTextField();
    jtf3.setBounds(250, 140, 240, 30);
    jtf3.setFont(f);
    middPanel1_ManageMedicine.add(jtf3);
    jtf4 = new JTextField();
    jtf4.setBounds(250, 180, 240, 30);
    jtf4.setFont(f);
    middPanel1_ManageMedicine.add(jtf4);
    jtf5 = new JTextField();
    jtf5.setBounds(250, 220, 240, 30);
    jtf5.setFont(f);
    middPanel1_ManageMedicine.add(jtf5);
    jtf6 = new JTextField();
    jtf6.setBounds(250, 260, 240, 30);
    jtf6.setFont(f);
    middPanel1_ManageMedicine.add(jtf6);
    jtf7 = new JTextField();
    jtf7.setBounds(250, 300, 240, 30);
    jtf7.setFont(f);
    middPanel1_ManageMedicine.add(jtf7);
    jtf8 = new JTextField();
    jtf8.setBounds(250, 340, 240, 30);
    jtf8.setFont(f);
    middPanel1_ManageMedicine.add(jtf8);

    jb1 = new JButton("ADD");
    jb1.setBounds(10, 400, 95, 50);
    jb1.setBackground(Color.WHITE);
    jb1.setFont(new Font("SERIF", Font.PLAIN, 24));
    jb1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        Connection conn = null;
        try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
          //    PreparedStatement ps=conn.prepareStatement("Insert into student values  ?,? ");
          //    ps.setString(1,"20SW042");
          //    ps.setString(1,"Asad Ali Gadehi");  
          stmt = conn.createStatement();
          res4 = stmt.executeQuery("SELECT medicinename,medicinetype From Stock");
          while (res4.next()) {
            if (res4.getString(1).equalsIgnoreCase(jtf1.getText()) && res4.getString(2).equalsIgnoreCase(jtf2.getText())) {
              //   System.out.println(res.getString(2));
              //   System.out.println(res.getString(3));
              idFound++;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              JOptionPane.showMessageDialog(middPanel1_ManageMedicine, "Already Added there.", " Error " + res4.getString(1), JOptionPane.ERROR_MESSAGE);
              jtf1.setText(null);
              jtf2.setText(null);
              jtf3.setText(null);
              jtf4.setText(null);
              jtf5.setText(null);
              jtf6.setText(null);
              jtf7.setText(null);
              jtf8.setText(null);
              jf.dispose();
              // break;
            } else {}
          }
          if (idFound == 0) {
            Pstatement = conn.prepareStatement("insert into pharmacydb.Stock values(?,?,?,?,?,?,?,cast(?  as date),?)");
            // PreparedStatement Pstatement=conn.prepareStatement("insert into pharmacydb.Stock values(?,?,?,?,?,?,?,cast(?  as date),?)");
            //Specifying the values of it's parameter
            Pstatement.setInt(1, 0);
            Pstatement.setString(2, jtf1.getText());
            Pstatement.setString(3, jtf2.getText());
            Pstatement.setString(4, jtf3.getText());
            Pstatement.setInt(5, Integer.parseInt(jtf4.getText()));
            Pstatement.setFloat(6, Float.parseFloat(jtf5.getText()));
            Date mfgDate = Date.valueOf(jtf6.getText()); //converting string into sql date  
            Date expDate = Date.valueOf(jtf7.getText()); //converting string into sql date  
            Pstatement.setDate(7, mfgDate); //"2021-09-09"
            Pstatement.setDate(8, expDate); //Date.valueOf(jtf6.getText().toString()));
            Pstatement.setInt(9, Integer.parseInt(jtf8.getText()));
            Pstatement.executeUpdate();
            JOptionPane.showMessageDialog(middPanel1_ManageMedicine, "Added Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
          }
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    middPanel1_ManageMedicine.add(jb1);
    jb2 = new JButton("CLEAR");
    // jb1.setBounds(1, 400, 95, 50);
    jb2.setBackground(Color.WHITE);
    jb2.setBounds(110, 400, 120, 50);
    jb2.setFont(new Font("SERIF", Font.PLAIN, 24));
    jb2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        try {
          jtf0.setText(null);
          jtf1.setText(null);
          jtf2.setText(null);
          jtf3.setText(null);
          jtf4.setText(null);
          jtf5.setText(null);
          jtf6.setText(null);
          jtf7.setText(null);
          jtf8.setText(null);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    middPanel1_ManageMedicine.add(jb2);
    jb3 = new JButton("DELETE");    
    jb3.setBackground(Color.WHITE);
    jb3.setBounds(236, 400, 150, 50);
    jb3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        Connection conn = null;
        try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
          //    PreparedStatement ps=conn.prepareStatement("Insert into student values  ?,? ");
          //    ps.setString(1,"20SW042");
          //    ps.setString(1,"Asad Ali Gadehi");  
          stmt = conn.createStatement();
          res5 = stmt.executeQuery("SELECT medicinename,medicinetype From Stock");
          while (res5.next()) {
            if (res5.getString(1).equalsIgnoreCase(jtf1.getText()) && res5.getString(2).equalsIgnoreCase(jtf2.getText())) {
              idFound++;
              JOptionPane.showMessageDialog(middPanel1_ManageMedicine, "Already Added there.", " Error " + res5.getString(1), JOptionPane.ERROR_MESSAGE);
              jtf1.setText(null);
              jtf2.setText(null);
              jtf3.setText(null);
              jtf4.setText(null);
              jtf5.setText(null);
              jtf6.setText(null);
              jtf7.setText(null);
              jtf8.setText(null);
              jf.dispose();
              // break;
            } else {}
          }
          if (idFound != 0) {
            // PreparedStatement Pstatement=conn.prepareStatement("insert into pharmacydb.Stock values(?,?,?,?,?,?,?,cast(?  as date),?)");
            //Specifying the values of it's parameter
            stmt = conn.createStatement();
            res6 = stmt.executeQuery("SELECT medicinename,medicinetype From Stock");
            while (res6.next()) {
              if (res6.getString(1).equalsIgnoreCase(jtf1.getText()) && res6.getString(2).equalsIgnoreCase(jtf2.getText())) {
                Pstatement = conn.prepareStatement("DELETE * FROM stock WHERE medicinename =" + res6.getString(2));
                Pstatement.executeUpdate();
              }
            }
            JOptionPane.showMessageDialog(middPanel1_ManageMedicine, "Deleted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
          }
          if (idFound == 0) {
            JOptionPane.showMessageDialog(middPanel1_ManageMedicine, "No Record Found.", " Error", JOptionPane.ERROR_MESSAGE);
          }
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    jb3.setFont(new Font("SERIF", Font.PLAIN, 26));
    middPanel1_ManageMedicine.add(jb3);
    jb4 = new JButton("UPDATE");
    jb4.setBackground(Color.WHITE);
    jb4.setBounds(390, 400, 150, 50);
    jb4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        int qty = 0;
        Connection conn = null;
        try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
          //    PreparedStatement ps=conn.prepareStatement("Insert into student values  ?,? ");
          //    ps.setString(1,"20SW042");
          //    ps.setString(1,"Asad Ali Gadehi");  
          stmt = conn.createStatement();
          res7 = stmt.executeQuery("SELECT medicinename,medicinetype,medicineqty From Stock");
          while (res7.next()) {
            if (res7.getString(1).equalsIgnoreCase(jtf1.getText()) && res7.getString(2).equalsIgnoreCase(jtf2.getText())) {
              idFound++;
              qty = res7.getInt(3);
              // JOptionPane.showMessageDialog(jf1,"Already Added there."," Error "+res.getString(1),JOptionPane.ERROR_MESSAGE);
              //   jtf1.setText(null);
              //   jtf2.setText(null);
              //   jtf3.setText(null);
              //   jtf4.setText(null);
              //   jtf5.setText(null);
              //   jtf6.setText(null);
              //   jtf7.setText(null);
              //   jtf8.setText(null);
              // jf.dispose();
              // break;
            } else {}
          }
          if (idFound != 0) {
            // PreparedStatement Pstatement=conn.prepareStatement("insert into pharmacydb.Stock values(?,?,?,?,?,?,?,cast(?  as date),?)");
            //Specifying the values of it's parameter
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
            stmt = conn.createStatement();
            res8 = stmt.executeQuery("SELECT * From Stock");
            //--=--=========+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            while (res8.next()) {
              // System.out.println("Medicine    mil   rahi   h   agar   update   krdo"); 
              // System.out.println(jtf1.getText());
              // System.out.println(jtf2.getText());
              if (res8.getString(2).equalsIgnoreCase(jtf1.getText()) && res8.getString(3).equalsIgnoreCase(jtf2.getText())) {

                String updateQuery = "UPDATE pharmacydb.stock SET idstock=? ,medicinetype=?,company=?,medicineqty=?,medicinepriceperunit=?,mfgdate=?,expdate=?,weightinmgs=?  WHERE medicinename =? ";
                Pstatement = conn.prepareStatement(updateQuery);
                //       PreparedStatement Pstatement = conn.prepareStatement("UPDATE pharmacydb.stock SET idstock="+jtf0.getText()+",medicinename= "+jtf1.getText()+",medicinetype= "+jtf2.getText()+",company="+jtf3.getText()+",medicineqty="+jtf4.getText()+",medicinepriceperunit="+qty+jtf5.getText()+",mfgdate="+jtf6.getText()+",expdate="+jtf7.getText()+",weightinmgs="+jtf8.getText()+"WHERE medicinename =" + res2.getString(2)); 

                Pstatement.setInt(1, Integer.parseInt(jtf0.getText()));

                Pstatement.setString(2, jtf2.getText());
                Pstatement.setString(3, jtf3.getText());
                Pstatement.setInt(4, qty + Integer.parseInt(jtf4.getText()));
                Pstatement.setFloat(5, Float.parseFloat(jtf5.getText()));
                Date mfgDate = Date.valueOf(jtf6.getText()); //converting string into sql date  
                Date expDate = Date.valueOf(jtf7.getText()); //converting string into sql date  
                Pstatement.setDate(6, mfgDate); //"2021-09-09"
                Pstatement.setDate(7, expDate); //Date.valueOf(jtf6.getText().toString()));
                Pstatement.setInt(8, Integer.parseInt(jtf8.getText()));
                Pstatement.setString(9, jtf1.getText());
                int rows = Pstatement.executeUpdate();
                System.out.println("rows    " + rows);
                JOptionPane.showMessageDialog(middPanel1_ManageMedicine, "Updated Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
              }
            }
          }
          if (idFound == 0) {
            JOptionPane.showMessageDialog(middPanel1_ManageMedicine, "No Record Found.", " Error", JOptionPane.ERROR_MESSAGE);
          }
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    jb4.setFont(new Font("SERIF", Font.PLAIN, 24));
    middPanel1_ManageMedicine.add(jb4);
    // middPanel=new JPanel();
    // jf2.setLayout(null);
    // jf2=new JFrame("New-One");  
    // JLabel jl0=new JLabel("Medicine ID");
    // jl0.setBounds(20,40,150,30);
    // JLabel jl1=new JLabel("Medicine Name");
    // jl1.setBounds(20,80,150,30);
    // JLabel jl2=new JLabel("Medicine Type");
    // jl2.setBounds(20,120,150,30);
    // JLabel jl3=new JLabel("Medicine Company");
    // jl3.setBounds(20,160,150,30);
    // JLabel jl4=new JLabel("Medicine Quantity");
    // jl4.setBounds(20,200,150,30);
    // JLabel jl5=new JLabel("Medicine MFG.Date");
    // jl5.setBounds(20,240,150,30);
    // JLabel jl6=new JLabel("Medicine EXP.Date");
    // jl6.setBounds(20,280,150,30);
    // JLabel jl7=new JLabel("Medicine Weight");
    // jl7.setBounds(20,320,150,30);

    // JTextField jtf0=new JTextField();
    // jtf0.setBounds(200,40,150,30);
    // JTextField jtf1=new JTextField();
    // jtf1.setBounds(200,80,150,30);
    // JTextField jtf2=new JTextField();
    // jtf2.setBounds(200,120,150,30);
    // JTextField jtf3=new JTextField();
    // jtf3.setBounds(200,160,150,30);
    // JTextField jtf4=new JTextField();
    // jtf4.setBounds(200,200,150,30);
    // JTextField jtf5=new JTextField();
    // jtf5.setBounds(200,240,150,30);
    // JTextField jtf6=new JTextField();
    // jtf6.setBounds(200,280,150,30);
    // JTextField jtf7=new JTextField();
    // jtf7.setBounds(200,320,150,30);
    // middPanel.add(jl0);
    // middPanel.add(jtf0);
    // middPanel.add(jl1);
    // middPanel.add(jtf1);
    // middPanel.add(jl2);
    // middPanel.add(jtf2);
    // middPanel.add(jl3);
    // middPanel.add(jtf3);
    // middPanel.add(jl4);
    // middPanel.add(jtf4);
    // middPanel.add(jl5);
    // middPanel.add(jtf5);
    // middPanel.add(jl6);
    // middPanel.add(jtf6);
    // middPanel.add(jl7);
    // middPanel.add(jtf7);
    // jf2.add(middPanel);
    // jf2.setVisible(true);
    // jf2.setSize(700,650);
    // jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // middPanel1_ManageMedicine.setBounds(140,70,560,580);
    // middPanel1_ManageMedicine.setBackground(Color.WHITE);
    // middPanel1_ManageMedicine.setLayout(new FlowLayout()); 
    jf.add(middPanel1_ManageMedicine);


    //Panel 2 Panel

    middPanel2_CheckStock.setLayout(new FlowLayout());
    //middPanel.setSize(700,650);
    middPanel2_CheckStock.setBackground(Color.WHITE);
    middPanel2_CheckStock.setBounds(140, 70, 560, 580);
    columnsPanel2 = new String[9];
    columnsPanel2[0] = "ID";
    columnsPanel2[1] = "Name";
    columnsPanel2[2] = "Type";
    columnsPanel2[3] = "Company";
    columnsPanel2[4] = "Quantity";
    columnsPanel2[5] = "Price";
    columnsPanel2[6] = "MFG Date";
    columnsPanel2[7] = "EXP Date";
    columnsPanel2[8] = "Weight(mgs)";
    dataPanel2 = new String[100][9];
    JTable jtab,jtab1,jtable;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
      stmt = conn.createStatement();
      res1 = stmt.executeQuery("SELECT * FROM pharmacydb.Stock");
      int i = 0;
      while (res1.next()) {
        dataPanel2[i][0] = res1.getString(1);
        dataPanel2[i][1] = res1.getString(2);
        dataPanel2[i][2] = res1.getString(3);
        dataPanel2[i][3] = res1.getString(4);
        dataPanel2[i][4] = res1.getString(5);
        dataPanel2[i][5] = res1.getString(6);
        dataPanel2[i][6] = res1.getString(7);
        dataPanel2[i][7] = res1.getString(8); 
        dataPanel2[i][8] = res1.getString(9);
        i++;
      }
      jtab = new JTable(dataPanel2, columnsPanel2);
      JScrollPane sp = new JScrollPane(jtab);
      // sp.setPreferredSize(new Dimension(300,300));
      middPanel2_CheckStock.add(sp);
      // middPanel3_SaleRecord.add(jtab);
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    jf.add(middPanel2_CheckStock);

     //Panel 3 Panel

     middPanel3_SaleRecord.setLayout(null);
     middPanel3_SaleRecord.setLayout(new FlowLayout());
     //middPanel.setSize(700,650);
     middPanel3_SaleRecord.setBackground(Color.WHITE);
     middPanel3_SaleRecord.setBounds(140, 70, 560, 580);
     columnsPanel3 = new String[6];
     columnsPanel3[0] = "ID";
     columnsPanel3[1] = "Name";
     columnsPanel3[2] = "Type";
     columnsPanel3[3] = "Quantity";
     columnsPanel3[4] = "Price Per Unit";
     columnsPanel3[5] = "Total Price";
     dataPanel3 = new String[100][6];
     try {
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
       stmt = conn.createStatement();
       res1 = stmt.executeQuery("SELECT * FROM pharmacydb.salerecord");
       int i = 0;
       while (res1.next()) {
         dataPanel3[i][0] = res1.getString(1);
         dataPanel3[i][1] = res1.getString(2);
         dataPanel3[i][2] = res1.getString(3);
         dataPanel3[i][3] = res1.getString(4);
         dataPanel3[i][4] = res1.getString(5);
         dataPanel3[i][5] = res1.getString(6);
         i++;
       }
       jtab1 = new JTable(dataPanel3, columnsPanel3);
       JScrollPane sp1 = new JScrollPane(jtab1);
       // sp.setPreferredSize(new Dimension(300,300));
       middPanel3_SaleRecord.add(sp1);
       // middPanel3_SaleRecord.add(jtab);
       conn.close();
     } catch (Exception e) {
       e.printStackTrace();
     }
     jf.add(middPanel3_SaleRecord);
 

    //Panel 4 Deal Customer Panel
    j=0;
    stockCheckerAgainst = 0;
    middPanel4.setLayout(null);
    middPanel4.setBackground(Color.WHITE);
    middPanel4.setBounds(140, 70, 560, 580);
    JButton medicineAddButtonOfPanel4 = new JButton("ADD");
    medicineAddButtonOfPanel4.setBackground(Color.WHITE);
    medicineAddButtonOfPanel4.setBounds(150, 170, 60, 30);
    JLabel medicineNameLabelOfPanel4 = new JLabel();
    medicineNameLabelOfPanel4.setText("Medicine Name");
    medicineNameLabelOfPanel4.setBounds(20, 10, 100, 30);
    JLabel medicineTypeLabelOfPanel4 = new JLabel();
    medicineTypeLabelOfPanel4.setText("Medicine type");
    medicineTypeLabelOfPanel4.setBounds(20, 60, 100, 30);
    JLabel medicineQuantityLabelOfPanel4 = new JLabel();
    medicineQuantityLabelOfPanel4.setText("Medicine Quantity");
    medicineQuantityLabelOfPanel4.setBounds(20, 110, 130, 30);
    Object[] list = new Object[100];
    try {
    Connection c=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/pharmacydb","root","root"); 
    		Statement st=c.createStatement();  
    		ResultSet rtst=st.executeQuery("select medicinename from pharmacydb.stock");  
    		int count=0;
    		while(rtst.next())  {
    		list[count++]=rtst.getString(1);  
    		}
    		c.close();  
    	}
    catch(Exception e){
    		System.out.println(e);
    	}  

    JComboBox medicineNameTextFieldOfPanel4 =new JComboBox(list);
    medicineNameTextFieldOfPanel4.setBounds(200, 10, 100, 30);
    
    AutoCompleteDecorator.decorate(medicineNameTextFieldOfPanel4);
    
//    JTextField medicineNameTextFieldOfPanel4 = new JTextField();
//    medicineNameTextFieldOfPanel4.setBounds(200, 10, 100, 30);
    
    JTextField medicineTypeTextFieldOfPanel4 = new JTextField();
    medicineTypeTextFieldOfPanel4.setBounds(200, 60, 100, 30);
    JTextField medicineQuantityTextFieldOfPanel4 = new JTextField();
    medicineQuantityTextFieldOfPanel4.setBounds(200, 110, 100, 30);

    middPanel41.setBounds(0, 220, 550, 250);
    middPanel41.setSize(550, 250);
    middPanel41.setLayout(new FlowLayout());
    middPanel41.setBackground(Color.WHITE);

    dataPanel4 = new String[100][5];
    columnPanel4 = new String[5];
    columnPanel4[0] = "NAME";
    columnPanel4[1] = "Type";
    columnPanel4[2] = "Quantity";
    columnPanel4[3] = "Price Per Unit";
    columnPanel4[4] = "Total Price";
    j = 0;
    jtable = new JTable(dataPanel4, columnPanel4);
    JScrollPane tableContainer = new JScrollPane(jtable);
    middPanel41.add(tableContainer, BorderLayout.SOUTH);

    medicineAddButtonOfPanel4.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        try {

        	if(qCount<10 && sCount<10) {
        		JOptionPane.showMessageDialog(jf,"Stock is Low!!!","Reminder",JOptionPane.WARNING_MESSAGE);
        	}
        	
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
          stmt = conn.createStatement();
          // Statement stmt2 = con.createStatement();
          // Statement stmnt=con.createStatement();
          res2 = stmt.executeQuery("SELECT medicinename,medicinetype,medicineqty,medicinepriceperunit FROM pharmacydb.Stock");
          while (res2.next()) {
            if (res2.getString(1).equalsIgnoreCase((String) medicineNameTextFieldOfPanel4.getSelectedItem()) && res2.getString(2).equalsIgnoreCase(medicineTypeTextFieldOfPanel4.getText())) {
              idFound1++;
            }
          }
          if (idFound1 != 0) {
            res2 = stmt.executeQuery("SELECT medicinename,medicinetype,medicineqty,medicinepriceperunit FROM pharmacydb.Stock");
            while (res2.next()) {
              if (res2.getString(1).equalsIgnoreCase((String) medicineNameTextFieldOfPanel4.getSelectedItem()) && res2.getString(2).equalsIgnoreCase(medicineTypeTextFieldOfPanel4.getText())) {
              if (res2.getInt(3) > Integer.parseInt(medicineQuantityTextFieldOfPanel4.getText())) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
                stmt = conn.createStatement();
                res3 = stmt.executeQuery("SELECT medicinename,medicinetype,medicineqty,medicinepriceperunit FROM pharmacydb.Stock");
                
                while (res3.next()) {
                  if (res3.getString(1).equalsIgnoreCase((String) medicineNameTextFieldOfPanel4.getSelectedItem()) && res3.getString(2).equalsIgnoreCase(medicineTypeTextFieldOfPanel4.getText())) {
                    // System.out.println("Iteration   "+j);
                    dataPanel4[j][0] = res3.getString(1);
                    dataPanel4[j][1] = res3.getString(2);
                    dataPanel4[j][2] = medicineQuantityTextFieldOfPanel4.getText();
                    dataPanel4[j][3] = res3.getString(4);
                    // TypeTester tt=new TypeTester();
                    int mqty = Integer.parseInt(medicineQuantityTextFieldOfPanel4.getText());
                    // tt.printType("qty must be int now     "+mqty);
                    float priceOf1 = Float.parseFloat(res3.getString(4));
                    // tt.printType("res3.getString(4) must be String now     "+res3.getString(4));
                    // tt.printType("price must be float now     "+priceOf1);
                    // tt.printType("t.price must be float now     "+(mqty*priceOf1));
                    dataPanel4[j][4] = Float.toString(mqty * priceOf1);
                      ++j;
                      medicineNameTextFieldOfPanel4.setSelectedItem(null);
                      medicineTypeTextFieldOfPanel4.setText(null);
                      medicineQuantityTextFieldOfPanel4.setText(null);
                    //         String updateQuery = "UPDATE pharmacydb.stock SET idstock=? ,medicinetype=?,company=?,medicineqty=?,medicinepriceperunit=?,mfgdate=?,expdate=?,weightinmgs=?  WHERE medicinename =? ";
                    //         PreparedStatement Pstatement = con.prepareStatement(updateQuery);
                    //  // PreparedStatement Pstatement = conn.prepareStatement("UPDATE pharmacydb.stock SET idstock="+jtf0.getText()+",medicinename= "+jtf1.getText()+",medicinetype= "+jtf2.getText()+",company="+jtf3.getText()+",medicineqty="+jtf4.getText()+",medicinepriceperunit="+qty+jtf5.getText()+",mfgdate="+jtf6.getText()+",expdate="+jtf7.getText()+",weightinmgs="+jtf8.getText()+"WHERE medicinename =" + res2.getString(2)); 

                    //          Pstatement.setInt(1, Integer.parseInt(jtf0.getText()));

                    //         Pstatement.setString(2,jtf2.getText());
                    //         Pstatement.setString(3,jtf3.getText());
                    //         Pstatement.setString(9,jtf1.getText());
                    //         int rows=     Pstatement.executeUpdate();
                    //      System.out.println("rows    "+rows);   
                    // JOptionPane.showMessageDialog(jf, "Updated Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                  }
                }

                JTable jtable = new JTable(dataPanel4, columnPanel4);
                JScrollPane tableContainer = new JScrollPane(jtable);
                middPanel41.add(tableContainer, BorderLayout.SOUTH);
                middPanel4.add(middPanel41);
              } 
              else {
                stockCheckerAgainst++;
              }
            }
            else{

            }
            }
          }
          if (stockCheckerAgainst != 0) {
            JOptionPane.showMessageDialog(middPanel4, "Quantity provided is not available in stock .", "Invalid", JOptionPane.WARNING_MESSAGE);
          }
          if (idFound1 == 0) {
            JOptionPane.showMessageDialog(middPanel4, "No Record Found.", "Error", JOptionPane.ERROR_MESSAGE);
          }

          // System.out.println("Roll No"+"\t\t"+"Name");
          // while(res.next()){
          //     System.out.println(res.getString(1)+"\t\t"+res.getString(2));
          // }
          conn.close();
        } catch (Exception ex) {
          System.out.println(ex.getMessage());
        }
      }
    });

    middPanel4.add(medicineNameLabelOfPanel4);
    middPanel4.add(medicineTypeLabelOfPanel4);
    middPanel4.add(medicineQuantityLabelOfPanel4);
    middPanel4.add(medicineNameTextFieldOfPanel4);
    middPanel4.add(medicineTypeTextFieldOfPanel4);
    middPanel4.add(medicineQuantityTextFieldOfPanel4);
    middPanel4.add(medicineAddButtonOfPanel4);

    middPanel4.add(middPanel41);
    JButton printRecieptButton=new JButton("Print Reciept");    
    printRecieptButton.setBackground(Color.WHITE);
    printRecieptButton.setBounds(410,480, 125, 25);
            
    printRecieptButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
//              String name,type;
//              int quantity;
//              Float pricePerUnit,totalPrice;
       try{  
        // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
        // // stmt = conn.createStatement();
        //     for(int i=0;i<jtable.getRowCount();i++){ 
        //       name=jtable.getValueAt(i,0).toString();
        //       type=jtable.getValueAt(i,1).toString();
        //       quantity=Integer.parseInt(jtable.getValueAt(i,2).toString());
        //       pricePerUnit=Float.parseFloat(jtable.getValueAt(i,3).toString());
        //       totalPrice=Float.parseFloat(jtable.getValueAt(i,4).toString());
              
        //       String query="Insert into salerecord values  ?,?,?,?,?,? ";
        //       PreparedStatement ps=conn.prepareStatement(query);
        //       ps.setInt(1,0);
        //       ps.setString(2,name);
        //       ps.setString(3,type);
        //       ps.setInt(4,quantity);
        //       ps.setFloat(5,pricePerUnit);
        //       ps.setFloat(6,totalPrice);
        //       ps.executeUpdate();
        //     }
        //     conn.close();




        //   // DefaultTableModel model =new DefaultTableModel(data,columnNames);
        //   // JTable table=new JTable();
        //   DefaultTableModel tblModel=(DefaultTableModel)jtable.getModel();
        //     if(tblModel.getRowCount()==0){
        //         JOptionPane.showMessageDialog(middPanel41,"Table is Empty"); 
        //     }
        //     else{
        //       String name,type;
        //       int quantity;
        //       Float pricePerUnit,totalPrice;
        //   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
        // // stmt = conn.createStatement();
        //   // Statement stmt2 = con.createStatement();
        //   // Statement stmnt=con.createStatement();
        //   // while (res2.next()) {
            
        //           String query="Insert into salerecord values  ?,?,?,?,?,? ";
        //         PreparedStatement ps=conn.prepareStatement(query);
        //     for(int i=0;i<tblModel.getRowCount();i++){
        //         name=tblModel.getValueAt(i,0).toString();
        //         type=tblModel.getValueAt(i,1).toString();
        //         quantity=(int) tblModel.getValueAt(i,2);
        //         pricePerUnit=(Float) tblModel.getValueAt(i,3);
        //         totalPrice=(Float) tblModel.getValueAt(i,4);
        //         //   String query="Insert into salerecord values  ?,?,?,?,?,? ";
        //         // PreparedStatement ps=conn.prepareStatement(query);
        //          ps.setInt(1,0);
        //          ps.setString(2,name);
        //          ps.setString(3,type  );
        //          ps.setInt(4,quantity);
        //          ps.setFloat(5,pricePerUnit);
        //          ps.setFloat(6,totalPrice);
        //           ps.execute();
        //     }
        //           JOptionPane.showMessageDialog(middPanel41,"Data Inserted Successfully.");
        //           tblModel.setRowCount(0);
        //       // j++;
        //   }
                BufferedWriter out=new BufferedWriter(new FileWriter("C:/Users/Lenovo/Documents/JavaProjects/src/Pharamacy_Management_System/DataFile.txt")); 
                
                  out.write("**********************************************************\n"); 
                  out.write("                XYZ  PHARMACY  STORE\n"); 
                  out.write("**********************************************************\n"); 
                  out.write("Cashier: "+userName.toUpperCase()+"\n"); 
                  out.write("Invoice Date: "+Date()+"\n");
                  out.write("\n\n**********************************************************\n"); 
                  out.write("Name                Qty    Price    Amount\n"); 

                  //   Write Data in it

                  out.write("**********************************************************\n"); 
                  out.write("No Return/Refund of Fridge Item. Thanks for Visiting here.\n"); 



                out.close();

                File printFile = new File("C:/Users/Lenovo/Documents/JavaProjects/src/Pharamacy_Management_System/DataFile.txt");

                Desktop desktop = Desktop.getDesktop();
                desktop.print(printFile);

      }
      catch(Exception e){
            e.printStackTrace();
      }
    }
    });
    middPanel4.add(printRecieptButton);
    
//    Panel 5    

    middPanel_RecommendedProducts.setLayout(new FlowLayout());
    //middPanel.setSize(700,650);
    middPanel_RecommendedProducts.setBackground(Color.WHITE);
    middPanel_RecommendedProducts.setBounds(140, 70, 560, 580);
    columnPanel5 = new String[2];
    columnPanel5[0] = "ID";
    columnPanel5[1] = "Name";
    dataPanel5 = new String[100][2];
    JTable jtable1;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
      stmt = conn.createStatement();
      res05 = stmt.executeQuery("select name, sum(quantity) from pharmacydb.salerecord group by name order by sum(quantity) desc limit 100;");
      int i = 0;
      while (res05.next()) {
        dataPanel5[i][0] = Integer.toString(i+1);
        dataPanel5[i][1] = res05.getString(1);
        i++;
      }
      jtable1 = new JTable(dataPanel5, columnPanel5);
      JScrollPane sp = new JScrollPane(jtable1);
      // sp.setPreferredSize(new Dimension(300,300));
      middPanel_RecommendedProducts.add(sp);
      // middPanel3_SaleRecord.add(jtab);
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    jf.add(middPanel_RecommendedProducts);

    
    // LocalTime dt=LocalTime.now();
    // middPanel4.add(dt);
    // JLabel jl=new JLabel("kkjggjkhgh");
    // jl.setBounds(500,100, 200, 100);
    // jl.add(dt);
    // dateClass dc=new dateClass();
    // jl=dc.labelReturn();
    // dc.start();
    // middPanel.add(dateLabel);
    // middPanel4.add(jl);
    jf.add(middPanel4);

    //  middPanel4.add(dateLabel);
    // middPanel4.add(jb);
    // dateClass dc=new dateClass();

    // header.setBackground(new Color(0,0,0,80));
    header.setBackground(new Color(0,153,0)); 
    header.setBounds(0, 0, 700, 70);

    JMenu menu;
    JMenuItem i1;
    JMenuBar mb = new JMenuBar();
    menu = new JMenu(" BACK ");
    i1 = new JMenuItem("Back");
    i1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jf.dispose();
        new UserLogin();
      }
    });
    menu.add(i1);
    mb.add(menu);
    jf.setJMenuBar(mb);

    name = new JLabel("Welcome " + userName.toUpperCase());
    name.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
    name.setBounds(150, 25, 600, 50);
    name.setForeground(Color.WHITE);
    header.add(name);
    // ImageIcon icon = new  ImageIcon("/caps.jpg");
    // Image img=icon.getImage();
    // Image tempImage=img.getScaledInstance(700,650, Image.SCALE_SMOOTH);
    // icon=new ImageIcon(tempImage);
    // JLabel background=new JLabel("",icon,JLabel.CENTER);
    // background.add(header);
    // background.setBounds(0, 0, 700, 650);
    // jf.add(background);
    jf.add(header);
    JLabel dashLabel = new JLabel("Dashboard");
    dashLabel.setFont(new Font("SERIF", Font.BOLD, 30));
    dashLabel.setForeground(Color.WHITE);
    // dashLabel.setBackground(Color.WHITE);
    leftPanel.setBackground(new Color(0,153,0));
    leftPanel.setBounds(0, 0, 140, 650);
    BoxLayout bl = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
    leftPanel.setLayout(bl);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 80)));
    leftPanel.add(dashLabel);
    JLabel dottedLine = new JLabel("____________________");
    leftPanel.add(dottedLine);
    jbManageMedicine = new JButton("Manage Medicine");
    // jf.setBackground(Color.WHITE);
    Border emptyBorder = BorderFactory.createEmptyBorder();
    jbManageMedicine.setBorder(emptyBorder);
    jbManageMedicine.setBackground(new Color(0,153,0));
    jbManageMedicine.setForeground(Color.WHITE);
    jbManageMedicine.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        middPanel.setVisible(true);
        middPanel1_ManageMedicine.setVisible(true);
        middPanel2_CheckStock.setVisible(false);
        middPanel3_SaleRecord.setVisible(false);
        middPanel4.setVisible(false);
        middPanel_RecommendedProducts.setVisible(false);
       } });
    jbCheckStock = new JButton("Check Stock");
    jbCheckStock.setForeground(Color.WHITE);
    jbCheckStock.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        middPanel.setVisible(true);
        middPanel1_ManageMedicine.setVisible(false);
        middPanel2_CheckStock.setVisible(true);
        middPanel3_SaleRecord.setVisible(false);
        middPanel4.setVisible(false);
        middPanel_RecommendedProducts.setVisible(false);
      }
    });
    jbCheckStock.setBorder(emptyBorder);
    jbCheckStock.setBackground(new Color(0,153,0));
    jbSaleRecord = new JButton("Sale Record");    
    jbSaleRecord.setForeground(Color.WHITE);
    jbSaleRecord.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        middPanel.setVisible(true);
        middPanel1_ManageMedicine.setVisible(false);
        middPanel2_CheckStock.setVisible(false);
        middPanel3_SaleRecord.setVisible(true);
        middPanel4.setVisible(false);
        middPanel_RecommendedProducts.setVisible(false);
      }
    });
    jbSaleRecord.setBorder(emptyBorder);
    jbSaleRecord.setBackground(new Color(0,153,0));
    btnCustomerDeal = new JButton("Deal Customer");
    btnCustomerDeal.setForeground(Color.WHITE);
    btnCustomerDeal.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        middPanel.setVisible(true);
        middPanel1_ManageMedicine.setVisible(false);
        middPanel2_CheckStock.setVisible(false);
        middPanel3_SaleRecord.setVisible(false);
        middPanel4.setVisible(true);
        middPanel_RecommendedProducts.setVisible(false);
      }
    });
    btnCustomerDeal.setBorder(emptyBorder);
    btnCustomerDeal.setBackground(new Color(0,153,0));
    btnLogout = new JButton("Logout");
    btnLogout.setForeground(Color.WHITE);
    btnLogout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        // jf.dispose();
        new FrontPage();
      }
    });
    btnLogout.setBorder(emptyBorder);
    btnLogout.setBackground(new Color(0,153,0));
    jbManageMedicine.setSize(200, 50);
    jbCheckStock.setSize(200, 50);
    jbSaleRecord.setSize(200, 50);
    btnCustomerDeal.setSize(200, 50);
    btnLogout.setSize(200, 50);
    

    btnRecommendedProducts = new JButton("Recommends");
    btnRecommendedProducts.setBorder(emptyBorder);
    btnRecommendedProducts.setBackground(new Color(0,153,0));
    btnRecommendedProducts.setSize(200, 50);
    
    btnRecommendedProducts.setForeground(Color.WHITE);
    btnRecommendedProducts.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        // jf.dispose();
          middPanel.setVisible(true);
          middPanel1_ManageMedicine.setVisible(false);
          middPanel2_CheckStock.setVisible(false);
          middPanel3_SaleRecord.setVisible(false);
          middPanel4.setVisible(false);
          middPanel_RecommendedProducts.setVisible(true);
      }
    });
    
    leftPanel.setBackground(new Color(0,153,0));
    leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    leftPanel.add(jbManageMedicine);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    leftPanel.add(jbCheckStock);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    leftPanel.add(jbSaleRecord);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    leftPanel.add(btnCustomerDeal);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    leftPanel.add(btnRecommendedProducts);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    leftPanel.add(btnLogout);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    jf.add(leftPanel);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
    jf.setSize(700, 650);
  }

// public void actionPerformed(ActionEvent ae){
//     if(ae.getSource()==jbManageMedicine){
//         // jf.dispose();
//         // new ManageMedicine();
//         middPanel=new JPanel();
//     }
//     if(ae.getSource()==jbCheckStock){
//         // jf.dispose();
//         // new CheckStock(); 
//         // middPanel;         

//         // jf.dispose(); 
//         //  middPanel=new JPanel();
//         // showStock();

//         // Object[][] data={{"R11","R12"},{"R21","R22"}};
//         // String[] columnNames={"C1","C2"};
//         // DefaultTableModel model=new DefaultTableModel(data,columnNames);
//         // JTable jt=new JTable(); 
//          //while(res.next()){  
//         //     jl=new JLabel(res.getString(1)+"  "+res.getString(2)+"  "+res.getString(3)+"  "+res.getString(4)+"  "+res.getString(5)+"  "+res.getString(6)+"  "+res.getString(7)+"  "+res.getString(8)+"  "+res.getString(9)); 
//         //     jl.setBounds(140,70,500,50);
//         //     jl.setFont(new Font("SERIF",Font.PLAIN,30));
//         //     middPanel.setBackground(Color.WHITE);
//         //     middPanel.add(jl);
//         // 
//         // String id=String.valueOf(res.getInt("idstock"));
//         // String name=res.getString("medicinename");
//         // String type=res.getString("medicinetype");
//         // String comp=res.getString("company");
//         // String qty=String.valueOf(res.getInt("medicineqty"));
//         // String mppu=res.getString("medicinepriceperunit");
//         // String mfg=res.getString("mfgdate");
//         // String exp=res.getString("expdate");  
//         // String wimgs=String.valueOf(res.getInt("weightinmgs"));    
//         // // String[] columnNames={"ID","Name","Type","Company","Quantity","Price Per Unit","MFG.Date","EXP.Date","Weight(mgs)"};
//         // String[] data ={id,name,type,comp,qty,mppu,mfg,exp,wimgs};



//         // model.addRow(data);       
//         // }   
//         // middPanel.add(new JScrollPane(jt)); 
//     //     middPanel.setBackground(Color.white);
//     //     jf2.add(middPanel);
//     //     conn.close();
//     //     jf2.setSize(700,650);
//     //     jf2.setVisible(true);
//     //     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     //     jf2.validate();
//     // } 
//     //     catch(Exception e){
//     //             e.printStackTrace();
//     //         }
//     }
//     else if (ae.getSource()==jbSaleRecord){
//         // jf.dispose();
//         // new SaleRecord();

//     }
//     else if(ae.getSource()==btnCustomerDeal){
//         // jf.dispose();
//         // new CustomerDeal();

//     }
//     else if(ae.getSource()==btnLogout){
//         jf.dispose();
//         new FrontPage();
//     }
//   // }

//   public ArrayList < Stock > stockListMethod() {
//     ArrayList < Stock > stocksList = new ArrayList < > ();
//     try {
//       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
//       Statement stmt5 = conn.createStatement();
//       ResultSet res = stmt5.executeQuery("SELECT * From stock");
//       // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
//       // stmt6 = conn.createStatement();
//       Stock stockObj;
//       while (res.next()) {
//         stockObj = new Stock(res.getInt("idstock"),
//           res.getString("medicinename"),
//           res.getString("medicinetype"),
//           res.getString("company"),
//           res.getInt("medicineqty"),
//           res.getFloat("medicinepriceperunit"),
//           res.getString("mfgdate"),
//           res.getString("expdate"),
//           res.getInt("weightinmgs"));
//         stocksList.add(stockObj);
//         //  DefaultTableModel model
//         //  //=new DefaultTableModel(data,columnNames);

//         //  //DefaultTableModel tblModel
//         //  =(DefaultTableModel)jt.getModel();

//         // model.addRow(data);
//       }
//       // middPanel.add(new JScrollPane(jt)); 
//       // middPanel.setBackground(Color.white);
//       // jf2.add(middPanel);
//       // // conn.close();
//       // jf2.setSize(700,650);
//       // jf2.setVisible(true);
//       // jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       // jf2.validate();
//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//     return stocksList;
//   }
// }
// // }






// 756 line 

public static String Date(){
  String str;
  SimpleDateFormat format;
  java.util.Date d;
  d=new java.util.Date();
  format=new SimpleDateFormat("E,MM/dd/yyyy HH:mm:ss");
  str=format.format(d);
  return str;
}
}
