//package JavaProject1;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.*;
public class Visitor_UpdateFind extends JFrame implements ActionListener {
	
	JComboBox cb;
	JLabel lbl_Find_Update,lbl_Id,lbl_Name,lbl_MobileNO;
	JTextField tf_Name,tf_MobileNo;
	JButton bt1,btn1,btn2;

	Visitor_UpdateFind(){
		setSize(700,700);
		setTitle("Employee update and find");
		setLayout(null);
		lbl_Find_Update=new JLabel("FIND AND UPDATE");
		lbl_Find_Update.setBounds(220, 50, 150, 40);
		add(lbl_Find_Update);
		lbl_Id=new JLabel("ID");
		lbl_Id.setBounds(220, 120, 150, 40);
		add(lbl_Id);
		cb=new JComboBox();
		cb.setBounds(300, 120, 150, 40);
		fillStaffid();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(450, 50, 150, 40);
		add(btn1);
		btn1.addActionListener(this);
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(220, 190, 150, 40);
		add(lbl_Name);
		
		tf_Name=new JTextField();
		tf_Name.setBounds(300, 190, 150, 40);
		add(tf_Name);
		tf_Name.addActionListener(this);
		
		lbl_MobileNO=new JLabel("Mobile Number");
		lbl_MobileNO.setBounds(220, 260, 150, 40);
		add(lbl_MobileNO);
	
		tf_MobileNo=new JTextField();
		tf_MobileNo.setBounds(300, 260, 150, 40);
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
				String sql="select id from VisitorDetail";
	
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
		Visitor_UpdateFind obj=new Visitor_UpdateFind();
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
						
				String sql="select name,mobileno from VisitorDetail where id=?";
				
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_Name.setText("");
				tf_MobileNo.setText("");
				if (rs.next()){
					tf_Name.setText(rs.getString(1));
					tf_MobileNo.setText(rs.getString(2));
				
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
//		if(p.getSource()==btn2) {
//			Connection con;
//			PreparedStatement st;
//			int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
//			String y=t1.getText();  //name
//			String z=t2.getText();  //Course
//		
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				
//				String sql="update VisitorDetail set name=?,mobileno=? where id=?";
//				st=con.prepareStatement(sql);
//				
//				st.setString(1, y);
//				st.setString(2, z);
//				st.setInt(3, x);
//			
//				int g=st.executeUpdate();
//				
//				JOptionPane.showMessageDialog(this, "Update data...");
//				cb.removeAllItems();
//				fillStaffid();
//				t1.setText("");
//				t2.setText("");	
//			}
//			catch(Exception ex) {
//				System.out.println(ex.toString());
//			}
			
			if(p.getSource()==btn2){
				String ab=tf_Name.getText();
	            String bc=tf_MobileNo.getText();
				if( ab.length()==0||bc.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con;
					PreparedStatement st;
					int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
					String y=tf_Name.getText();  //name
					String z=tf_MobileNo.getText();  //Course
				
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						
						String sql="update VisitorDetail set name=?,mobileno=? where id=?";
						st=con.prepareStatement(sql);
						
						st.setString(1, y);
						st.setString(2, z);
						st.setInt(3, x);
					
						int g=st.executeUpdate();
						
						JOptionPane.showMessageDialog(this, "Update data...");
						cb.removeAllItems();
						fillStaffid();
						tf_Name.setText("");
						tf_MobileNo.setText("");	
					}
					catch(Exception ex) {
						System.out.println(ex.toString());
					}
				}
			
		}

		if(p.getSource()==bt1) {
			cb.removeAllItems();
			fillStaffid();
			
			tf_Name.setText("");
			tf_MobileNo.setText("");
		}
		

	  }
	}