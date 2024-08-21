//package JavaProject1;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
//import java.awt.color.*;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//public class AdminNewForm extends JFrame implements ActionListener{
//
//	int n=(int) Math.ceil(Math.random()*100000);
//	
//		JLabel lbl_adminEntry,lbl_Id,lbl_empName,lbl_InTime,lbl_OutTime,lbl_dep,lbl_mobileNo,lbl_Address,lbl_Email,a9,a10;
//		JTextField tf_Id,tf_name,tf_InTime,tf_OutTime,tf_dep,tf_mobileNo,tf_Address,tf_Email,t9,t10;
//		JButton bt1,bt2;
//		AdminNewForm(){
//
//			setSize(900,900);
//			setTitle("Admin Entry");
//			setLayout(null);
//
//			SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//			Date date=new Date();
//			
//			lbl_adminEntry=new JLabel("Admin Entry");
//			lbl_adminEntry.setBounds(200, 30, 400, 40);
//			lbl_adminEntry.setBackground(Color.WHITE);
//			add(lbl_adminEntry);
//			lbl_adminEntry.setFont(new Font("Arial",Font.PLAIN,30));
//			lbl_Id=new JLabel("Id");
//			lbl_Id.setBounds(150, 90, 150, 40);
//			add(lbl_Id);
//			lbl_empName=new JLabel("Employee Name");
//			lbl_empName.setBounds(150, 150, 150, 40);
//			add(lbl_empName);
//			lbl_InTime=new JLabel("In-Time");
//			lbl_InTime.setBounds(150, 210, 150, 40);
//			add(lbl_InTime);
//			lbl_OutTime=new JLabel("Out-Time");
//			lbl_OutTime.setBounds(150, 260, 150, 40);
//			add(lbl_OutTime);
//			lbl_dep=new JLabel("Department");
//			lbl_dep.setBounds(150, 330, 150, 40);
//			add(lbl_dep);
//			lbl_mobileNo=new JLabel("Mobile No");
//			lbl_mobileNo.setBounds(150, 390, 150, 40);
//			add(lbl_mobileNo);
//			lbl_Address=new JLabel("Address");
//			lbl_Address.setBounds(150, 450, 150, 40);
//			add(lbl_Address);
//			lbl_Email=new JLabel("Email");
//			lbl_Email.setBounds(150, 510, 150, 40);
//			add(lbl_Email);
//
//			
//			tf_Id=new JTextField("E"+String.valueOf(n));
//			tf_Id.setBounds(300, 90, 150, 40);
//			add(tf_Id);
//			tf_Id.addActionListener(this);
//			tf_name=new JTextField();
//			tf_name.setBounds(300, 150, 150, 40);
//			add(tf_name);
//			tf_name.addActionListener(this);
//			tf_InTime=new JTextField(String.valueOf(date));
//			tf_InTime.setBounds(300, 200, 200, 40);
//			add(tf_InTime);
//			tf_InTime.addActionListener(this);
//			tf_OutTime=new JTextField();
//			tf_OutTime.setBounds(300, 270, 200, 40);
//			add(tf_OutTime);
//			tf_OutTime.addActionListener(this);
//			tf_dep=new JTextField();
//			tf_dep.setBounds(300, 330, 150, 40);
//			add(tf_dep);
//			tf_dep.addActionListener(this);
//			tf_mobileNo=new JTextField();
//			tf_mobileNo.setBounds(300, 390, 150, 40);
//			add(tf_mobileNo);
//			tf_mobileNo.addActionListener(this);
//			tf_Address=new JTextField();
//			tf_Address.setBounds(300, 450, 150, 40);
//			add(tf_Address);
//			tf_Address.addActionListener(this);
//			tf_Email=new JTextField();
//			tf_Email.setBounds(300, 510, 150, 40);
//			add(tf_Email);
//			tf_Email.addActionListener(this);
//			
//
//			bt1=new JButton("Register");
//			bt1.setBounds(230,570,150,40);
//			add(bt1);
//			bt1.addActionListener(this);
//
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
//			setVisible(true);
//		}
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new	AdminNewForm();
//	
//	}
//	
//
//	@Override
//	public void actionPerformed(ActionEvent p) {
//		// TODO Auto-generated method stub
//		if(p.getSource()==bt1){
//			String ab=tf_Id.getText();
//			String ac=tf_name.getText();
//			String ad=tf_InTime.getText();
//			String ae=tf_OutTime.getText();
//			String af=tf_dep.getText();
//			String ag=tf_mobileNo.getText();
//			String ah=tf_Address.getText();
//			String aj=tf_Email.getText();
//
//			if( ab.length()==0||ac.length()==0||ad.length()==0||ae.length()==0||af.length()==0||ag.length()==0||ah.length()==0||aj.length()==0){
//				JOptionPane.showMessageDialog(this,"incomplete data");
//			}
//			else{
//				Connection con; PreparedStatement st;
//				try{
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//							
//					String sql="insert into Registration values(?,?,?,?,?,?,?,?)";
//					st=con.prepareStatement(sql);
//					st.setString(1,"E"+tf_Id.getText());
//					st.setString(2,tf_name.getText());
//					st.setString(3,tf_InTime.getText());
//					st.setString(4,tf_OutTime.getText());
//					st.setString(5,tf_dep.getText());
//					st.setString(6,tf_mobileNo.getText());
//					st.setString(7,tf_Address.getText());
//                  	st.setString(8,tf_Email.getText());
//			
//
//					int g=st.executeUpdate();
//					con.close();
//					JOptionPane.showMessageDialog(this,"Data Saved");
//				}
//				catch(Exception e){
//					System.out.println(e);
//				}
//			}
//}
//}
//}






import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.color.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class AdminNewForm extends JFrame implements ActionListener{

	int n=(int) Math.ceil(Math.random()*100000);
	
		JLabel a,lblId,lblEmpName,lblDOB,lblInTime,lblG,lblDID,lblMobileNo,lbllblAddress,lblEmail,a10;
		JTextField txtId,txtEmpName,txtDOB,txtGen,txtDepId,txtmobileno,txtAddress,txtEmail,txtInTime,t10;
		JButton btn1,btn2,btfind;
		JRadioButton rm,rf;
		ButtonGroup bg;
		JLabel lblmess;
		AdminNewForm(){

			setSize(900,900);
			setTitle("Admin Entry");
			setLayout(null);

			SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date=new Date();

			a=new JLabel("Admin Entry");
			a.setBounds(200, 30, 400, 40);
			a.setBackground(Color.WHITE);
			add(a);
			a.setFont(new Font("Arial",Font.BOLD,30));
			
			btfind=new JButton("Search");
			btfind.setBounds(500, 90, 80, 40);
			add(btfind);
			btfind.addActionListener(this);
			lblmess=new JLabel("Status");
			lblmess.setBounds(630, 90, 100, 40);
			add(lblmess);
			
			
			lblId=new JLabel("Id");
			lblId.setBounds(150, 90, 150, 40);
			add(lblId);
			lblEmpName=new JLabel("Employee Name");
			lblEmpName.setBounds(150, 150, 150, 40);
			add(lblEmpName);
			lblDOB=new JLabel("D.O.B");
			lblDOB.setBounds(150, 210, 150, 40);
			add(lblDOB);
			lblInTime=new JLabel("In-Time");
			lblInTime.setBounds(150, 270, 150, 40);
			add(lblInTime);
			lblG=new JLabel("Gender");
			lblG.setBounds(150, 330, 150, 40);
			add(lblG);
			lblDID=new JLabel("DepartmentId");
			lblDID.setBounds(150, 390, 150, 40);
			add(lblDID);
			lblMobileNo=new JLabel("Mobile no");
			lblMobileNo.setBounds(150, 440, 150, 40);
			add(lblMobileNo);
			lbllblAddress=new JLabel("Address");
			lbllblAddress.setBounds(150, 490, 150, 40);
			add(lbllblAddress);
			lblEmail=new JLabel("Email");
			lblEmail.setBounds(150, 540, 150, 40);
			add(lblEmail);

			
			txtId=new JTextField("E"+String.valueOf(n));
			txtId.setBounds(300, 90, 150, 40);
			add(txtId);
			txtId.addActionListener(this);
			
			txtEmpName=new JTextField();
			txtEmpName.setBounds(300, 150, 150, 40);
			add(txtEmpName);
			txtEmpName.addActionListener(this);
			
			txtDOB=new JTextField();
			txtDOB.setBounds(300, 210, 150, 40);
			add(txtDOB);
			txtDOB.addActionListener(this);
			
			txtInTime=new JTextField(String.valueOf(date));
			txtInTime.setBounds(300, 270, 190, 40);
			add(txtInTime);
			txtInTime.addActionListener(this);
			
			bg=new ButtonGroup();
			rm=new JRadioButton("Male");
			rm.setBounds(250, 330, 100, 50);
			add(rm);
			rf=new JRadioButton("Female");
			rf.setBounds(350, 330, 100, 50);
			add(rf);
			bg.add(rm);
			bg.add(rf);
			
			txtDepId=new JTextField();
			txtDepId.setBounds(300, 390, 150, 40);
			add(txtDepId);
			txtDepId.addActionListener(this);
			
			txtmobileno=new JTextField();
			txtmobileno.setBounds(300, 440, 150, 40);
			add(txtmobileno);
			txtmobileno.addActionListener(this);
			
			txtAddress=new JTextField();
			txtAddress.setBounds(300, 490, 150, 40);
			add(txtAddress);
			txtAddress.addActionListener(this);
			
			txtEmail=new JTextField();
			txtEmail.setBounds(300, 540, 150, 40);
			add(txtEmail);
			txtEmail.addActionListener(this);
			

			btn1=new JButton("Register");
			btn1.setBounds(230,620,200,50);
			add(btn1);
			btn1.setFont(new Font("Arial",Font.BOLD,30));
			btn1.addActionListener(this);
			
			btn2=new JButton("CLOSE");
			btn2.setBounds(460,620,200,50);
			add(btn2);
			btn2.setFont(new Font("Arial",Font.BOLD,30));
			btn2.addActionListener(this);

//			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
	
	


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new	AdminNewForm();
		
		}

		

		@Override
		public void actionPerformed(ActionEvent p) {
			
			if(p.getSource()==btn1){

				Connection con; 
				PreparedStatement st;
				ResultSet rs;
				String q=txtId.getText(); 
				String r=txtEmpName.getText();
				String s=null;
				if (rm.isSelected())
				{
					s="Male";
				}
				else
				{
					s="FeMale";
				}
				
				String aa=txtInTime.getText();
				String ad=txtDOB.getText();
				System.out.println("pass 1.");
				String af=txtDepId.getText();
				String ag=txtmobileno.getText();
				String ah=txtAddress.getText();
				String aj=txtEmail.getText();
				System.out.println("pass 2.");
				try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
								
						String sql="insert into registration values(?,?,?,?,?,?,?,?,?)";
						st=con.prepareStatement(sql);
						st.setString(1,"E"+txtId.getText());
						st.setString(2,txtEmpName.getText());
						st.setString(3,txtInTime.getText());
						st.setString(4,txtDOB.getText());
						st.setString(5,s);
						st.setString(6,txtDepId.getText());
						st.setString(7,txtmobileno.getText());
						st.setString(8,txtAddress.getText());
	                  	st.setString(9,txtEmail.getText());
				

						int g=st.executeUpdate();
						
						JOptionPane.showMessageDialog(this,"Record Save");
						txtId.setText("");
						txtEmpName.setText("");
						txtInTime.setText("");
						rm.setSelected(false);
						rf.setSelected(false);
						txtDOB.setText("");
						
						txtDepId.setText("");
						txtmobileno.setText("");
						txtAddress.setText("");
						txtEmail.setText("");
						con.close();
					}
					catch(Exception e){
						System.out.println(e.toString());
					}
				new Mainwindow();
					}
			if(p.getSource()==btn2)
			{	
				
				System.exit(1);
				}
			
			if(p.getSource()==btfind)
			{
				try {
				Connection con; 
				PreparedStatement st;
				ResultSet rs;
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					
					String sql="select count(*) from registration where empid=?";
					st=con.prepareStatement(sql);
					String q=txtId.getText(); 
					st.setString(1, q);
					rs=st.executeQuery();
					if (rs.next())
					{
					int x=rs.getInt(1);
					if (x==0)
					{
						lblmess.setText("FINE GO");
						lblmess.setForeground(java.awt.Color.GREEN);
					}
					else
					{
						lblmess.setText("ALREADY PRESENT");
						lblmess.setForeground(java.awt.Color.RED);
					}
					}
					else
					{

						lblmess.setText("FINE GO");
						lblmess.setForeground(java.awt.Color.GREEN);
						
					}
				}
				catch(Exception ex) {
				System.out.println(ex.toString());	
				}
			
		}
		}

	}
