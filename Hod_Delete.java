//package JavaProject1;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.util.*;


public class Hod_Delete extends JFrame implements ActionListener{
	
	JLabel lbl_Hod_Id,lbl_UserName,lbl_Dep;
	JTextField tf_UserName,tf_Dep;
	JComboBox cb;
	JButton btn1,btn2;
	
	public Hod_Delete() {
		setSize(700,700);
		setLayout(null);
		

		lbl_Hod_Id= new JLabel("HodId");
		add(lbl_Hod_Id);
		lbl_Hod_Id.setBounds(110, 50, 100,40 );
		lbl_Hod_Id.setFont(new Font("Arial",Font.PLAIN,20));
		
		cb=new JComboBox();
		cb.setBounds(200,50,100,40);
		fillStudentroll();
		add(cb);
		
		btn1=new JButton("Find");
		btn1.setBounds(400,50,100,40);
		add(btn1);
		btn1.addActionListener(this);
		
		lbl_UserName= new JLabel("USERNAME");
		add(lbl_UserName);
		lbl_UserName.setBounds(100, 100, 100,30 );
		lbl_UserName.setFont(new Font("Arial",Font.PLAIN,15));
		
		tf_UserName=new JTextField();
		tf_UserName.setBounds(200,100,100,40);
		add(tf_UserName);

		lbl_Dep= new JLabel("Department");
		add(lbl_Dep);
		lbl_Dep.setBounds(100, 150, 100,30 );
		lbl_Dep.setFont(new Font("Arial",Font.PLAIN,15));
				
		tf_Dep=new JTextField();
		tf_Dep.setBounds(200,150,100,40);
		add(tf_Dep);
		
		
		btn2=new JButton("Delete");
		btn2.setBounds(320,300,100,40);
		add(btn2);
		btn2.addActionListener(this);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Hod_Delete();

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
				
				String sql="select name,department from hod where hodid=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_UserName.setText("");
				tf_Dep.setText("");
				
				if(rs.next()) {
					tf_UserName.setText(rs.getString(1));
					tf_Dep.setText(rs.getString(2));
					
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
				String sql="delete from hod where hodid=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record deleted..");
				cb.removeAllItems();
				fillStudentroll();
				tf_UserName.setText("");
				tf_Dep.setText("");
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
			String sql="select hodid from hod";
			
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

