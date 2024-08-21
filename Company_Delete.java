//package JavaProject1;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.util.*;


public class Company_Delete extends JFrame implements ActionListener{
	JLabel lbl_ComCode,lbl_Name,lbl_Address,lbl_Email,lbl_mobileNo;
	JTextField tf_Name,tf_Address,tf_Email,tf_MobileNo;
	JComboBox cb;
	JButton btn1,btn2;
	
	public Company_Delete() {
		setSize(700,700);
		setLayout(null);
		
		lbl_ComCode=new JLabel("Company Code");
		lbl_ComCode.setBounds(50,50,200,40);
		add(lbl_ComCode);

		cb=new JComboBox();
		cb.setBounds(200,50,100,40);
		fillStudentroll();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(400,50,100,40);
		add(btn1);
		btn1.addActionListener(this);

		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(50,100,200,40);
		add(lbl_Name); 

		tf_Name=new JTextField();
		tf_Name.setBounds(200,100,100,40);
		add(tf_Name);
		
		lbl_Address=new JLabel("Address");
		lbl_Address.setBounds(50,150,200,40);
		add(lbl_Address);
		
		tf_Address=new JTextField();
		tf_Address.setBounds(200,150,100,40);
		add(tf_Address);
		

		lbl_Email=new JLabel("Email id");
		lbl_Email.setBounds(50,200,200,40);
		add(lbl_Email);
		
		tf_Email=new JTextField();
		tf_Email.setBounds(200,200,200,40);
		add(tf_Email);
		
		lbl_mobileNo=new JLabel("Contact");
		lbl_mobileNo.setBounds(50,250,200,40);
		add(lbl_mobileNo);

		tf_MobileNo=new JTextField();
		tf_MobileNo.setBounds(200,250,100,40);
		add(tf_MobileNo);
		
		btn2=new JButton("Delete");
		btn2.setBounds(320,300,100,40);
		add(btn2);
		btn2.addActionListener(this);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Company_Delete();

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
				
				String sql="select name,address,emailid,contactno  from CompanyInfo where CompanyCode=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_Name.setText("");
				tf_Address.setText("");
				tf_Email.setText("");
				tf_MobileNo.setText("");
				if(rs.next()) {
					tf_Name.setText(rs.getString(1));
					tf_Address.setText(rs.getString(2));
					tf_Email.setText(rs.getString(3));
					tf_MobileNo.setText(rs.getString(4));
					
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
				String sql="delete from CompanyInfo where companyCode=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record deleted..");
				cb.removeAllItems();
				fillStudentroll();
				tf_Name.setText("");
				tf_Address.setText("");
				tf_Email.setText("");
				tf_MobileNo.setText("");
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
			String sql="select CompanyCode from CompanyInfo";
			
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
