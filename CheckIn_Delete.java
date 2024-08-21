//package JavaProject1;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.util.*;


public class CheckIn_Delete extends JFrame implements ActionListener{
	JLabel lbl_Id,lbl_EmpId,lbl_DepId,lbl_InTime,lbl_OutTime,lbl_Gatepass;
	JTextField tf_EmpId,tf_DepId,tf_InTime,tf_OutTime,tf_GatePass;
	JComboBox cb;
	JButton btn1,btn2;
	
	public CheckIn_Delete() {
		setSize(700,700);
		setLayout(null);
		lbl_Id=new JLabel("ID");
		lbl_Id.setBounds(100, 50, 150, 40);
		add(lbl_Id);
		lbl_EmpId=new JLabel("Emp_ID");
		lbl_EmpId.setBounds(100, 100, 150, 40);
		add(lbl_EmpId);
		lbl_DepId=new JLabel("Departement ID");
		lbl_DepId.setBounds(100, 150, 150, 40);
		add(lbl_DepId);
		lbl_InTime=new JLabel("InTime");
		lbl_InTime.setBounds(100, 200, 150, 40);
		add(lbl_InTime);
		lbl_OutTime=new JLabel("OutTime");
		lbl_OutTime.setBounds(100, 250, 150, 40);
		add(lbl_OutTime);
		lbl_Gatepass=new JLabel("Gatepass");
		lbl_Gatepass.setBounds(100, 300, 150, 40);
		add(lbl_Gatepass);
		
		cb=new JComboBox();
		cb.setBounds(200,50,100,40);
		fillStudentroll();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(400,50,100,40);
		add(btn1);
		btn1.addActionListener(this);
		
		tf_EmpId=new JTextField();
		tf_EmpId.setBounds(200,100,100,40);
		add(tf_EmpId);
		
		tf_DepId=new JTextField();
		tf_DepId.setBounds(200,150,100,40);
		add(tf_DepId);
		
		tf_InTime=new JTextField();
		tf_InTime.setBounds(200,200,100,40);
		add(tf_InTime);
		tf_OutTime=new JTextField();
		tf_OutTime.setBounds(200,250,100,40);
		add(tf_OutTime);
		
		tf_GatePass=new JTextField();
		tf_GatePass.setBounds(200,300,100,40);
		add(tf_GatePass);
		
		btn2=new JButton("Delete");
		btn2.setBounds(320,300,100,40);
		add(btn2);
		btn2.addActionListener(this);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new CheckIn_Delete();

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
				
				String sql="select empId,departmentId,inTime,outTime,gatePass from CheckIn where id=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_EmpId.setText("");
				tf_DepId.setText("");
				tf_InTime.setText("");
				tf_OutTime.setText("");
				tf_GatePass.setText("");
				if(rs.next()) {
					tf_EmpId.setText(rs.getString(1));
					tf_DepId.setText(rs.getString(2));
					tf_InTime.setText(rs.getString(3));
					tf_OutTime.setText(rs.getString(4));
				    tf_GatePass.setText(rs.getString(5));
					
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
				String sql="delete from CheckIn where id=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record deleted..");
				cb.removeAllItems();
				fillStudentroll();
				tf_EmpId.setText("");
				tf_DepId.setText("");
				tf_InTime.setText("");
				tf_OutTime.setText("");
				tf_GatePass.setText("");
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
			String sql="select id from CheckIn";
			
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
