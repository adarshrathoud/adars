//package JavaProject1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.*;

public class Employe_UpdateFind extends JFrame implements ActionListener {
	JComboBox cb;
	JLabel lbl_Update_Find,lbl_EmpId,lbl_Name,lbl_Dep,lbl_Email,lbl_Address;
	JTextField tf_EmpId,tf_Name,tf_Dep,tf_Email,tf_Address;
	JButton bt1,btn1,btn2;

	Employe_UpdateFind(){
		setSize(700,700);
		setTitle("Employee update and find");
		setLayout(null);
		
		lbl_Update_Find=new JLabel("FIND AND UPDATE");
		lbl_Update_Find.setBounds(160, 50, 150, 40);
		lbl_Update_Find.setFont(new Font("Arial",Font.PLAIN,15));
		add(lbl_Update_Find);
		
		lbl_EmpId=new JLabel("EMP ID");
		lbl_EmpId.setBounds(220, 120, 150, 40);
		add(lbl_EmpId);
		
		cb=new JComboBox();
		cb.setBounds(300, 120, 150, 40);
		fillStaffid();
		add(cb);
		
		btn1=new JButton("Find");
		btn1.setBounds(470, 120, 150, 40);
		add(btn1);
		btn1.addActionListener(this);
		
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(220, 190, 150, 40);
		add(lbl_Name);
		
		lbl_Dep=new JLabel("Department");
		lbl_Dep.setBounds(220, 260, 150, 40);
		add(lbl_Dep);
		
		lbl_Email=new JLabel("Email");
		lbl_Email.setBounds(220, 330, 150, 40);
		add(lbl_Email);
		
		lbl_Address=new JLabel("Address");
		lbl_Address.setBounds(220, 400, 150, 40);
		add(lbl_Address);

		tf_Name=new JTextField();
		tf_Name.setBounds(300, 190, 150, 40);
		add(tf_Name);
		tf_Name.addActionListener(this);
		tf_Dep=new JTextField();
		tf_Dep.setBounds(300, 260, 150, 40);
		add(tf_Dep);
		tf_Dep.addActionListener(this);
		tf_Email=new JTextField();
		tf_Email.setBounds(300, 330, 150, 40);
		add(tf_Email);
		tf_Email.addActionListener(this);
		tf_Address=new JTextField();
		tf_Address.setBounds(300, 400, 150, 40);
		add(tf_Address);
		tf_Address.addActionListener(this);
		
		
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
				String sql="select EMPID from EmployeeDetail";
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
	new Employe_UpdateFind();

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
						
				String sql="select NAME,DEPARTMENTID,EMAIL,ADDRESS from EmployeeDetail where EMPID=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_Name.setText("");
				tf_Dep.setText("");
				tf_Email.setText("");
				tf_Address.setText("");
			
				if (rs.next()){
					tf_Name.setText(rs.getString(1));
					tf_Dep.setText(String.valueOf(rs.getInt(2)));
					tf_Email.setText(rs.getString(3));
					tf_Address.setText(rs.getString(4));
				}
				else {
					JOptionPane.showMessageDialog(this, "Not found..");
				}

				
				con.close();
				
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
//			int sa=Integer.parseInt(t3.getText()); // depid
//			String z=t4.getText(); // email
//			String z1=t5.getText();//address
//			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				String sql="update EmployeeDetail set NAME=?,DEPARTMENTID=?,EMAIL=?,ADDRESS=? where EMPID=?";
//				st=con.prepareStatement(sql);
//				st.setString(1, y);
//				st.setInt(2, sa);
//				st.setString(3, z);
//				st.setString(4, z1);
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
	            String bc=tf_Dep.getText();
				if( ab.length()==0||bc.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con;
					PreparedStatement st;
					int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
					String y=tf_Name.getText(); // name 
					int sa=Integer.parseInt(tf_Dep.getText()); // depid
					String z=tf_Email.getText(); // email
					String z1=tf_Address.getText();//address
					
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						String sql="update EmployeeDetail set NAME=?,DEPARTMENTID=?,EMAIL=?,ADDRESS=? where EMPID=?";
						st=con.prepareStatement(sql);
						st.setString(1, y);
						st.setInt(2, sa);
						st.setString(3, z);
						st.setString(4, z1);
						st.setInt(5, x);
						
						int g=st.executeUpdate();
						JOptionPane.showMessageDialog(this, "record Updated..");
						cb.removeAllItems();
						fillStaffid();
						tf_Name.setText("");
						tf_Dep.setText("");
						tf_Email.setText("");
						tf_Address.setText("");
					}
					catch(Exception ex) {
						System.out.println(ex.toString());
					}	
				}

		}
		if(p.getSource()==bt1){
			cb.removeAllItems();
			fillStaffid();
			tf_Name.setText("");
			tf_Dep.setText("");
			tf_Email.setText("");
			tf_Address.setText("");
			
		}
		
		

	}}
