//package JavaProject1;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.Scanner;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//
//public class Employ_insersion extends JFrame implements ActionListener {
//
//	JLabel lbl_Insertion,lbl_EmpID,lbl_Name,lbl_Dep,lbl_Email,lbl_Address;
//	JTextField tf_EmpId,tf_Name,tf_Dep,tf_email,tf_address;
//	JButton bt1;
//	Employ_insersion(){
//		setSize(700,700);
//		setTitle("EMPY.INSERTION");
//		setLayout(null);
//		
//		lbl_Insertion=new JLabel("INSERTION");
//		lbl_Insertion.setBounds(220, 50, 150, 40);
//		add(lbl_Insertion);
//		lbl_EmpID=new JLabel("EMP.ID");
//		lbl_EmpID.setBounds(220, 120, 150, 40);
//		add(lbl_EmpID);
//		lbl_Name=new JLabel("Name");
//		lbl_Name.setBounds(220, 190, 150, 40);
//		add(lbl_Name);
//		lbl_Dep=new JLabel("Department");
//		lbl_Dep.setBounds(220, 260, 150, 40);
//		add(lbl_Dep);
//		lbl_Email=new JLabel("Email");
//		lbl_Email.setBounds(220, 330, 150, 40);
//		add(lbl_Email);
//		lbl_Address=new JLabel("Address");
//		lbl_Address.setBounds(220, 400, 150, 40);
//		add(lbl_Address);
//	
//		tf_EmpId=new JTextField();
//		tf_EmpId.setBounds(300, 120, 150, 40);
//		add(tf_EmpId);
//		tf_EmpId.addActionListener(this);
//		tf_Name=new JTextField();
//		tf_Name.setBounds(300, 190, 150, 40);
//		add(tf_Name);
//		tf_Name.addActionListener(this);
//		tf_Dep=new JTextField();
//		tf_Dep.setBounds(300, 260, 150, 40);
//		add(tf_Dep);
//		tf_Dep.addActionListener(this);
//		tf_email=new JTextField();
//		tf_email.setBounds(300, 330, 150, 40);
//		add(tf_email);
//		tf_email.addActionListener(this);
//		tf_address=new JTextField();
//		tf_address.setBounds(300, 400, 150, 40);
//		add(tf_address);
//		tf_address.addActionListener(this);
//	
//		
//
//		bt1=new JButton("save");
//		bt1.setBounds(260,550,150,40);
//		add(bt1);
//		bt1.addActionListener(this);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//	}
//	
//	public static void main(String[] args) {
//		
//		new Employ_insersion ();
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent p) {
//		
//	//	if(p.getSource()==bt1){
////			Connection con; PreparedStatement st;
////			try{
////				Class.forName("oracle.jdbc.driver.OracleDriver");
////				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
////				
////						
////				String sql="insert into EmployeeDetail values(?,?,?,?,?)";
////				st=con.prepareStatement(sql);
////				st.setString(1,String.valueOf(t1.getText()));
////				st.setString(2,t2.getText());
////				st.setString(3,String.valueOf(t3.getText()));
////				st.setString(4,t4.getText());
////				st.setString(5,t5.getText());
////				
////
////				int g=st.executeUpdate();
////				con.close();
////				JOptionPane.showMessageDialog(this,"Data Saved");
////			}
////			catch(Exception e){
////				System.out.println(e);
////			}
//			if(p.getSource()==bt1){
//				String ab=tf_EmpId.getText();
//				if( ab.length()==0){
//					JOptionPane.showMessageDialog(this,"incomplete data");
//				}
//				else{
//					Connection con; PreparedStatement st;
//					try{
//						Class.forName("oracle.jdbc.driver.OracleDriver");
//						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//						
//								
//						String sql="insert into EmployeeDetail values(?,?,?,?,?)";
//						st=con.prepareStatement(sql);
//						st.setString(1,String.valueOf(tf_EmpId.getText()));
//						st.setString(2,tf_Name.getText());
//						st.setString(3,String.valueOf(tf_Dep.getText()));
//						st.setString(4,tf_email.getText());
//						st.setString(5,tf_address.getText());
//						
//
//						int g=st.executeUpdate();
//						con.close();
//						JOptionPane.showMessageDialog(this,"Data Saved");
//					}
//					catch(Exception e){
//						System.out.println(e);
//					}
//				}
//	}
//
//}
//}




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employ_insersion extends JFrame implements ActionListener {
	int p43=0;
	JLabel a,a1,a2,a3,a4,a5;
	JTextField t1,t2,t3,t4,t5;
	JButton bt1,bt2;
	Employ_insersion(){
		setSize(700,700);
		setTitle("EMPY.INSERTION");
		setLayout(null);
		
		a=new JLabel("INSERTION");
		a.setBounds(220, 50, 150, 40);
		add(a);
		a1=new JLabel("EMP.ID");
		a1.setBounds(220, 120, 150, 40);
		add(a1);
		a2=new JLabel("Name");
		a2.setBounds(220, 190, 150, 40);
		add(a2);
		a3=new JLabel("Department");
		a3.setBounds(220, 260, 150, 40);
		add(a3);
		a4=new JLabel("Email");
		a4.setBounds(220, 330, 150, 40);
		add(a4);
		a5=new JLabel("Address");
		a5.setBounds(220, 400, 150, 40);
		add(a5);
	
		t1=new JTextField();
		t1.setBounds(300, 120, 150, 40);
		add(t1);
		t1.addActionListener(this);
		t2=new JTextField();
		t2.setBounds(300, 190, 150, 40);
		add(t2);
		t2.addActionListener(this);
		t3=new JTextField();
		t3.setBounds(300, 260, 150, 40);
		add(t3);
		t3.addActionListener(this);
		t4=new JTextField();
		t4.setBounds(300, 330, 150, 40);
		add(t4);
		t4.addActionListener(this);
		t5=new JTextField();
		t5.setBounds(300, 400, 150, 40);
		add(t5);
		t5.addActionListener(this);
	
		

		bt1=new JButton("save");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		bt2=new JButton("Ckeck");
		bt2.setBounds(400, 550, 150, 40);
		add(bt2);
		bt2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Employ_insersion ();
	}

	@Override
	public void actionPerformed(ActionEvent p) {
		
	//	if(p.getSource()==bt1){
//			Connection con; PreparedStatement st;
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				
//						
//				String sql="insert into EmployeeDetail values(?,?,?,?,?)";
//				st=con.prepareStatement(sql);
//				st.setString(1,String.valueOf(t1.getText()));
//				st.setString(2,t2.getText());
//				st.setString(3,String.valueOf(t3.getText()));
//				st.setString(4,t4.getText());
//				st.setString(5,t5.getText());
//				
//
//				int g=st.executeUpdate();
//				con.close();
//				JOptionPane.showMessageDialog(this,"Data Saved");
//			}
//			catch(Exception e){
//				System.out.println(e);
//			}
			if(p.getSource()==bt1){
				String ab=t1.getText();
				if( ab.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
								
						String sql="insert into EmployeeDetail values(?,?,?,?,?)";
						st=con.prepareStatement(sql);
						st.setString(1,"E"+t1.getText());
						st.setString(2,t2.getText());
						st.setString(3,t3.getText());
						st.setString(4,t4.getText());
						st.setString(5,t5.getText());
						

						int g=st.executeUpdate();
						con.close();
						JOptionPane.showMessageDialog(this,"Data Saved");
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
	}
			if (p.getSource()==bt2) {
				String b=t1.getText();
				
				Connection con; PreparedStatement st;ResultSet rs;
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					
							
					String sql="select * from Employeedetail where empid=?";
					st=con.prepareStatement(sql);
					st.setString(1,b);
					rs=st.executeQuery();
					if (rs.next()) {
						
							JOptionPane.showMessageDialog(this, "Not Ok");
						}
						else {
							JOptionPane.showMessageDialog(this, "Ok");
						}
					}
				
				catch(Exception e){
					System.out.println(e);
				}
				
			}

}
}