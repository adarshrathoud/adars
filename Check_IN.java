//package JavaProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Date;
public class Check_IN extends JFrame implements ActionListener {
	JLabel lbl_CheckIn,lbl_Id,lbl_EmpId,lbl_DepId,lbl_In_Time,lbl_Out_Time,lbl_Gatepass;
	JTextField tf_Id,tf_EmpId,tf_DepId,tf_InTime,tf_OutTime,tf_Gatepass;
	JButton bt1;
	Check_IN(){
		setSize(700,700);
		setTitle("CHECK_IN");
		setLayout(null);
		
		SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		lbl_CheckIn=new JLabel("CHECK_IN");
		lbl_CheckIn.setBounds(220, 50, 150, 40);
		add(lbl_CheckIn);
		lbl_Id=new JLabel("ID");
		lbl_Id.setBounds(220, 120, 150, 40);
		add(lbl_Id);
		lbl_EmpId=new JLabel("Emp_ID");
		lbl_EmpId.setBounds(220, 190, 150, 40);
		add(lbl_EmpId);
		lbl_DepId=new JLabel("Departement ID");
		lbl_DepId.setBounds(200, 260, 150, 40);
		add(lbl_DepId);
		lbl_In_Time=new JLabel("InTime");
		lbl_In_Time.setBounds(220, 330, 150, 40);
		add(lbl_In_Time);
		lbl_Out_Time=new JLabel("OutTime");
		lbl_Out_Time.setBounds(220, 400, 150, 40);
		add(lbl_Out_Time);
		lbl_Gatepass=new JLabel("Gatepass");
		lbl_Gatepass.setBounds(220, 470, 150, 40);
		add(lbl_Gatepass);
		
		tf_Id=new JTextField();
		tf_Id.setBounds(300, 120, 150, 40);
		add(tf_Id);
		tf_Id.addActionListener(this);
		tf_EmpId=new JTextField();
		tf_EmpId.setBounds(300, 190, 150, 40);
		add(tf_EmpId);
		tf_EmpId.addActionListener(this);
		tf_DepId=new JTextField();
		tf_DepId.setBounds(300, 260, 150, 40);
		add(tf_DepId);
		tf_DepId.addActionListener(this);
		tf_InTime=new JTextField(String.valueOf(date));
		tf_InTime.setBounds(300, 330, 200, 40);
		add(tf_InTime);
		tf_InTime.addActionListener(this);
		tf_OutTime=new JTextField();
		tf_OutTime.setBounds(300, 400, 150, 40);
		add(tf_OutTime);
		tf_OutTime.addActionListener(this);
		tf_Gatepass=new JTextField();
		tf_Gatepass.setBounds(300, 470, 150, 40);
		add(tf_Gatepass);
		tf_Gatepass.addActionListener(this);
		

		bt1=new JButton("save");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static <SimpleDateFormate> void main(String[] args) {
		// TODO Auto-generated method stub
		new Check_IN();
		 
		
	}
	@Override
	public void actionPerformed(ActionEvent p) {
		
//		if(p.getSource()==bt1){
//			Connection con; PreparedStatement st;
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				Scanner sc=new Scanner(System.in);
//						
//				String sql="insert into checkIn values(?,?,?,?,?,?)";
//				
//				st=con.prepareStatement(sql);
//				st.setString(1,String.valueOf(t1.getText()));
//				st.setString(2,String.valueOf(t2.getText()));
//				st.setString(3,String.valueOf(t3.getText()));
//				st.setString(4,String.valueOf(t4.getText()));
//				st.setString(5,String.valueOf(t5.getText()));
//				st.setString(6,String.valueOf(t6.getText()));
//
//				int g=st.executeUpdate();
//				con.close();
//				JOptionPane.showMessageDialog(this,"Data Saved");
//			}
//			catch(Exception e){
//				System.out.println(e);
//			}
		if(p.getSource()==bt1){
			String ab=tf_Id.getText();
			if( ab.length()==0){
				JOptionPane.showMessageDialog(this,"incomplete data");
			}
			else{
				if(p.getSource()==bt1){
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						Scanner sc=new Scanner(System.in);
								
						String sql="insert into checkIn values(?,?,?,?,?,?)";
						
						st=con.prepareStatement(sql);
						st.setString(1,String.valueOf(tf_Id.getText()));
						st.setString(2,String.valueOf(tf_EmpId.getText()));
						st.setString(3,String.valueOf(tf_DepId.getText()));
						st.setString(4,String.valueOf(tf_InTime.getText()));
						st.setString(5,String.valueOf(tf_OutTime.getText()));
						st.setString(6,String.valueOf(tf_Gatepass.getText()));

						int g=st.executeUpdate();
						con.close();
						JOptionPane.showMessageDialog(this,"Data Saved");
					}
					catch(Exception e){
						System.out.println(e);
					}
			}
			
	}

}
	}}


//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//
//import java.util.Date;
//public class Check_IN extends JFrame implements ActionListener {
//	JLabel a,a1,a2,a3,a4,a5,a6;
//	JTextField t1,t2,t3,t4,t5,t6;
//	JButton bt1,bt2;
//	Check_IN(){
//		setSize(700,700);
//		setTitle("CHECK_IN");
//		setLayout(null);
//		
//		SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date date=new Date();
//		a=new JLabel("CHECK_IN");
//		a.setBounds(220, 50, 150, 40);
//		add(a);
//		a1=new JLabel("ID");
//		a1.setBounds(220, 120, 150, 40);
//		add(a1);
//		a2=new JLabel("Emp_ID");
//		a2.setBounds(220, 190, 150, 40);
//		add(a2);
//		a3=new JLabel("Departement");
//		a3.setBounds(220, 260, 150, 40);
//		add(a3);
//		a4=new JLabel("InTime");
//		a4.setBounds(220, 330, 150, 40);
//		add(a4);
//		a5=new JLabel("OutTime");
//		a5.setBounds(220, 400, 150, 40);
//		add(a5);
//		a6=new JLabel("Gatepass");
//		a6.setBounds(220, 470, 150, 40);
//		add(a6);
//		
//		t1=new JTextField();
//		t1.setBounds(300, 120, 150, 40);
//		add(t1);
//		t1.addActionListener(this);
//		t2=new JTextField();
//		t2.setBounds(300, 190, 150, 40);
//		add(t2);
//		t2.addActionListener(this);
//		t3=new JTextField();
//		t3.setBounds(300, 260, 150, 40);
//		add(t3);
//		t3.addActionListener(this);
//		t4=new JTextField(String.valueOf(date));
//		t4.setBounds(300, 330, 150, 40);
//		add(t4);
//		t4.addActionListener(this);
//		t5=new JTextField();
//		t5.setBounds(300, 400, 150, 40);
//		add(t5);
//		t5.addActionListener(this);
//		t6=new JTextField();
//		t6.setBounds(300, 470, 150, 40);
//		add(t6);
//		t6.addActionListener(this);
//		
//		bt1=new JButton("save");
//		bt1.setBounds(260,550,150,40);
//		add(bt1);
//		bt1.addActionListener(this);
//		JLabel labnext=new JLabel("Status");
//		labnext.setBounds(680, 150, 150, 40);
//		add(labnext);
//		bt2=new JButton();
//		bt2.setBounds(620, 190, 150, 150);
//		
//		add(bt2);
//		bt2.addActionListener(this);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//	}
//	public static <SimpleDateFormate> void main(String[] args) {
//		// TODO Auto-generated method stub
//		new Check_IN();
//		 
//		
//	}
//	@Override
//	public void actionPerformed(ActionEvent p) {
//		// TODO Auto-generated method stub
//		if(p.getSource()==bt1){
//			Connection con; PreparedStatement st;
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				Scanner sc=new Scanner(System.in);
//						
//				String sql="insert into checkIn values(?,?,?,?,?,?)";
//				
//				st=con.prepareStatement(sql);
//				st.setString(1,String.valueOf(t1.getText()));
//				st.setString(2,String.valueOf(t2.getText()));
//				st.setString(3,String.valueOf(t3.getText()));
//				st.setString(4,String.valueOf(t4.getText()));
//				st.setString(5,String.valueOf(t5.getText()));
//				st.setString(6,String.valueOf(t6.getText()));
//				
//				int g=st.executeUpdate();
//				con.close();
//				JOptionPane.showMessageDialog(this,"Data Saved");
//			}
//			catch(Exception e){
//				System.out.println(e);
//			}
//			
//	}
//
//}
//}
