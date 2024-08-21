//package JavaProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employe_insersion extends JFrame implements ActionListener {
	int p43=0;
	JLabel lbl_insertion,lbl_emp_id,lbl_Name,lbl_Dep,lbl_Email,lbl_Address;
	JTextField tf_EmpId,tf_Name,tf_Dep,tf_Email,tf_Address;
	JButton bt1,bt2;
	Employe_insersion(){
		setSize(700,700);
		setTitle("EMPLOYEE.INSERTION");
		setLayout(null);
		
		lbl_insertion=new JLabel("INSERTION");
		lbl_insertion.setBounds(220, 50, 150, 40);
		add(lbl_insertion);
		
		lbl_emp_id=new JLabel("EMP.ID");
		lbl_emp_id.setBounds(220, 120, 150, 40);
		add(lbl_emp_id);
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
	
		tf_EmpId=new JTextField();
		tf_EmpId.setBounds(300, 120, 150, 40);
		add(tf_EmpId);
		tf_EmpId.addActionListener(this);
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
	
		

		bt1=new JButton("save");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		bt2=new JButton("Ckeck");
		bt2.setBounds(400, 550, 150, 40);
		add(bt2);
		bt2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Employe_insersion ();
	}

	@Override
	public void actionPerformed(ActionEvent p) {
		
	//	if(p.getSource()==bt1){
//			Connection con; PreparedStatement st;
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				
//						
//				String sql="insert into EmployeeDetail values(?,?,?,?,?)";
//				st=con.prepareStatement(sql);
//				st.setString(1,String.valueOf(t1.getText()));
//				st.setString(2,t2.getText());
//				st.setString(3,String.valueOf(t3.getText()));
//				st.setString(4,t4.getText());
//				st.setString(5,t5.getText());
//				
//
//				int g=st.executeUpdate();
//				con.close();
//				JOptionPane.showMessageDialog(this,"Data Saved");
//			}
//			catch(Exception e){
//				System.out.println(e);
//			}
			if(p.getSource()==bt1){
				String ab=tf_EmpId.getText();
				if( ab.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
								
						String sql="insert into EmployeeDetail values(?,?,?,?,?)";
						st=con.prepareStatement(sql);
						st.setString(1,"E"+tf_EmpId.getText());
						st.setString(2,tf_Name.getText());
						st.setString(3,tf_Dep.getText());
						st.setString(4,tf_Email.getText());
						st.setString(5,tf_Address.getText());
						

						int g=st.executeUpdate();
						con.close();
						JOptionPane.showMessageDialog(this,"Data Saved");
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
	}
			if (p.getSource()==bt2) {
				String b=tf_EmpId.getText();
				
				Connection con; PreparedStatement st;ResultSet rs;
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					
							
					String sql="select * from Employeedetail where empid=?";
					st=con.prepareStatement(sql);
					st.setString(1,b);
					rs=st.executeQuery();
					if (rs.next()) {
						
							JOptionPane.showMessageDialog(this, "Not Ok");
						}
						else {
							JOptionPane.showMessageDialog(this, "Ok");
						}
					}
				
				catch(Exception e){
					System.out.println(e);
				}
				
			}

}
}