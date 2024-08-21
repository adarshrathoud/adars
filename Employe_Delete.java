//package JavaProject1;
import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class Employe_Delete extends JFrame implements ActionListener{
	JLabel lbl_Deletion,lbl_EmpId,lbl_Name,lbl_Dep,lbl_Email,lbl_Address;
	JTextField t,t1,tf_Name,tf_Dep,tf_Email,tf_Address;
	
	JComboBox cb;
	JButton btn1,btn2;
	
	public Employe_Delete() {
		setSize(700,700);
		setLayout(null);
		lbl_Deletion=new JLabel("DELETION");
		lbl_Deletion.setBounds(220, 50, 150, 40);
		lbl_Deletion.setFont(new Font("Arial",Font.PLAIN,15));
		add(lbl_Deletion);
		lbl_EmpId=new JLabel("EMP.ID");
		lbl_EmpId.setBounds(220, 120, 150, 40);
		add(lbl_EmpId);
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
		
		cb=new JComboBox();
		cb.setBounds(300, 120, 150, 40);
		fillStudentroll();
		add(cb);
		
		btn1=new JButton("Find");
		btn1.setBounds(500,120,100,40);
		add(btn1);
		btn1.addActionListener(this);
	
//		t1=new JTextField();
//		t1.setBounds(300, 120, 150, 40);
//		add(t1);
//		t1.addActionListener(this);
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
		
		btn2=new JButton("Delete");
		btn2.setBounds(320,500,100,40);
		add(btn2);
		btn2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Employe_Delete();

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
				
				String sql="select name,departmentId,email,address from EmployeeDetail where empid=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_Name.setText("");
				tf_Dep.setText("");
				tf_Email.setText("");
				tf_Address.setText("");
				if(rs.next()) {
					tf_Name.setText(rs.getString(1));
					tf_Dep.setText(String.valueOf(rs.getInt(2)));
					tf_Email.setText(rs.getString(3));
				    tf_Address.setText(rs.getString(4));
					
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
				String sql="delete from EmployeeDetail where empid=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record deleted..");
				cb.removeAllItems();
				fillStudentroll();
				tf_Name.setText("");
				tf_Dep.setText("");
				tf_Email.setText("");
				tf_Address.setText("");
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
			String sql="select empid from EmployeeDetail";
			
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
