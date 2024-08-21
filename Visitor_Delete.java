//package JavaProject1;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.util.*;


public class Visitor_Delete extends JFrame implements ActionListener{
	
	JLabel lbl_Id,lbl_Name,lbl_MobileNo;
	JTextField tf_Name,tf_Mobile;
	JComboBox cb;
	JButton btn1,btn2;
	
	public Visitor_Delete() {
		setSize(700,700);
		setLayout(null);
		lbl_Id=new JLabel("ID");
		lbl_Id.setBounds(100, 50, 150, 40);
		add(lbl_Id);
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(100, 100, 150, 40);
		add(lbl_Name);
		lbl_MobileNo=new JLabel("Mobile no.");
		lbl_MobileNo.setBounds(100, 150, 150, 40);
		add(lbl_MobileNo);
		
		cb=new JComboBox();
		cb.setBounds(200,50,100,40);
		fillStudentroll();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(400,50,100,40);
		add(btn1);
		btn1.addActionListener(this);
		
		tf_Name=new JTextField();
		tf_Name.setBounds(200,100,100,40);
		add(tf_Name);
		
		tf_Mobile=new JTextField();
		tf_Mobile.setBounds(200,150,100,40);
		add(tf_Mobile);
		
		
		btn2=new JButton("Delete");
		btn2.setBounds(320,300,100,40);
		add(btn2);
		btn2.addActionListener(this);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Visitor_Delete();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==btn1) {
			Connection con;
			PreparedStatement st;
			ResultSet rs;
			int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				
				String sql="select name,mobileno from VisitorDetail where id=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_Name.setText("");
				tf_Mobile.setText("");
				
				if(rs.next()) {
					tf_Name.setText(rs.getString(1));
					tf_Mobile.setText(rs.getString(2));
				    
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Not Founds..");
					
				}
				con.close();
				
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
		
		if(ae.getSource()==btn2) {
			Connection con;
			PreparedStatement st;
			int x=Integer.parseInt(cb.getSelectedItem().toString());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="delete from VisitorDetail where id=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record deleted..");
				cb.removeAllItems();
				fillStudentroll();
				tf_Name.setText("");
				tf_Mobile.setText("");
				con.close();
				
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
	}
	void fillStudentroll() {
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select id from VisitorDetail";
			
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()) {
				cb.addItem(String.valueOf(rs.getInt(1)));
				
			}	
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

}

