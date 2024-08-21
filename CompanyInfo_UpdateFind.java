//package JavaProject1;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.*;

public class CompanyInfo_UpdateFind extends JFrame implements ActionListener {
	JComboBox cb;
	JLabel lbl_Find_Update,lbl_ComCode,lbl_Name,lbl_Address,lbl_Email,lbl_MobileNo;
	JTextField tf_ComCOde,tf_Name,tf_Address,tf_Email,tf_MobileNo;
	JButton bt1,btn1,btn2;

	CompanyInfo_UpdateFind(){
		setSize(700,700);
		setTitle("Company update and find");
		setLayout(null);
		lbl_Find_Update=new JLabel("FIND AND UPDATE");
		lbl_Find_Update.setBounds(220, 50, 150, 40);
		add(lbl_Find_Update);
		lbl_ComCode=new JLabel("Company Code");
		lbl_ComCode.setBounds(180, 120, 150, 40);
		add(lbl_ComCode);
		cb=new JComboBox();
		cb.setBounds(300, 120, 150, 40);
		fillStaffid();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(450, 50, 150, 40);
		add(btn1);
		btn1.addActionListener(this);
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(180, 190, 150, 40);
		add(lbl_Name);
		lbl_Address=new JLabel("Address");
		lbl_Address.setBounds(180, 260, 150, 40);
		add(lbl_Address);
		lbl_Email=new JLabel("Email");
		lbl_Email.setBounds(180, 330, 150, 40);
		add(lbl_Email);
		lbl_MobileNo=new JLabel("Contact Number");
		lbl_MobileNo.setBounds(180, 400, 150, 40);
		add(lbl_MobileNo);
	
//		t1=new JTextField();
//		t1.setBounds(300, 120, 150, 40);
//		add(t1);
//		t1.addActionListener(this);
		tf_Name=new JTextField();
		tf_Name.setBounds(300, 190, 150, 40);
		add(tf_Name);
		tf_Name.addActionListener(this);
		tf_Address=new JTextField();
		tf_Address.setBounds(300, 260, 150, 40);
		add(tf_Address);
		tf_Address.addActionListener(this);
		tf_Email=new JTextField();
		tf_Email.setBounds(300, 330, 150, 40);
		add(tf_Email);
		tf_Email.addActionListener(this);
		tf_MobileNo=new JTextField();
		tf_MobileNo.setBounds(300, 400, 150, 40);
		add(tf_MobileNo);
		tf_MobileNo.addActionListener(this);
		
		
		bt1=new JButton("clear");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		btn2=new JButton("Update");
		btn2.setBounds(500, 550, 150, 40);
		add(btn2);
		btn2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	 void fillStaffid() {
		 Connection con;
			PreparedStatement st;ResultSet rs;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select companycode from CompanyInfo";
				st=con.prepareStatement(sql);
				rs=st.executeQuery();
				while(rs.next())
				{
					cb.addItem(String.valueOf(rs.getInt(1)));
				}
			}
			catch(Exception e){}
		
	}
	public static void main(String[] args) {
	new CompanyInfo_UpdateFind();

	}
	@Override
	public void actionPerformed(ActionEvent p) {
		if(p.getSource()==btn1){
			Connection con; PreparedStatement st; ResultSet rs;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
				Scanner sc=new Scanner(System.in);
						
				String sql="select name,address,emailid,contactno from CompanyInfo where companycode=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
//				st.setString(1,String.valueOf(t1.getText()));
				tf_Name.setText("");
				tf_Address.setText("");
				tf_Email.setText("");
				tf_MobileNo.setText("");
//				st.setString(2,t2.getText());
//				st.setString(3,String.valueOf(t3.getText()));
//				st.setString(4,t4.getText());
//				st.setString(5,t5.getText());
				
				if (rs.next()){
					tf_Name.setText(rs.getString(1));
					tf_Address.setText(rs.getString(2));
					tf_Email.setText(rs.getString(3));
					tf_MobileNo.setText(rs.getString(4));
				}
				else {
					JOptionPane.showMessageDialog(this, "Not found..");
				}

				//int g=st.executeUpdate();
				con.close();
				//JOptionPane.showMessageDialog(this,"Data Saved");
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
		
	}
//		if(p.getSource()==btn2){
//			Connection con;
//			PreparedStatement st;
//			int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
//			String y=t2.getText(); // name 
//			String z1=t3.getText(); //address
//			String z=t4.getText(); // email
//			String sa=t5.getText();// depid
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				String sql="update CompanyInfo set name=?,address=?,emailid=?,contactno=? where companycode=?";
//				st=con.prepareStatement(sql);
//				st.setString(1, y);
//				st.setString(3, z);
//				st.setString(2, z1);
//				st.setString(4, sa);
//				st.setInt(5, x);
//				
//				int g=st.executeUpdate();
//				JOptionPane.showMessageDialog(this, "record Updated..");
//				cb.removeAllItems();
//				fillStaffid();
//				t2.setText("");
//				t3.setText("");
//				t4.setText("");
//				t5.setText("");
//			}
//			catch(Exception ex) {
//				System.out.println(ex.toString());
//			}

			if(p.getSource()==btn2){
				String ab=tf_Name.getText();
	            String bc=tf_Address.getText();
				if( ab.length()==0||bc.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con;
					PreparedStatement st;
					int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
					String y=tf_Name.getText(); // name 
					String z1=tf_Address.getText(); //address
					String z=tf_Email.getText(); // email
					String sa=tf_MobileNo.getText();// depid
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						String sql="update CompanyInfo set name=?,address=?,emailid=?,contactno=? where companycode=?";
						st=con.prepareStatement(sql);
						st.setString(1, y);
						st.setString(3, z);
						st.setString(2, z1);
						st.setString(4, sa);
						st.setInt(5, x);
						
						int g=st.executeUpdate();
						JOptionPane.showMessageDialog(this, "record Updated..");
						cb.removeAllItems();
						fillStaffid();
						tf_Name.setText("");
						tf_Address.setText("");
						tf_Email.setText("");
						tf_MobileNo.setText("");
					}
					catch(Exception ex) {
						System.out.println(ex.toString());
					}
	
				}
			
		
		if(p.getSource()==bt1) {
			cb.removeAllItems();
			fillStaffid();
			
			tf_Name.setText("");
			tf_Address.setText("");
			tf_Email.setText("");
			tf_MobileNo.setText("");
		}
			}
		

	}}