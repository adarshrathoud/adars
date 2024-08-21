//package JavaProject1;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class VisitorAutomaticId extends JFrame implements ActionListener{

	int n=(int) Math.ceil(Math.random()*100000);
	
		JLabel lbl_VEntry,lbl_id,lbl_name,lbl_workpurpose,lbl_EmpName,lbl_Intime,lbl_outTime,lbl_dep,lbl_mobileNo,lbl_address,lbl_email;	;
		JTextField tf_VEntry,t2,t3,t4,t5,t6,t7,t8,t9,t10;
		JButton bt1,bt2;
		VisitorAutomaticId(){

			setSize(900,900);
			setTitle("VISITOR ENTRY");
			setLayout(null);
			
			SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date=new Date();
			
			lbl_VEntry=new JLabel("Visitor Entry");
			lbl_VEntry.setBounds(200, 10, 400, 40);
			lbl_VEntry.setBackground(Color.WHITE);
			add(lbl_VEntry);
			lbl_VEntry.setFont(new Font("Arial",Font.PLAIN,30));
			lbl_id=new JLabel("Id");
			lbl_id.setBounds(150, 60, 150, 40);
			add(lbl_id);
			lbl_name=new JLabel("Name");
			lbl_name.setBounds(150, 110, 150, 40);
			add(lbl_name);
			lbl_workpurpose=new JLabel("Work Purpose");
			lbl_workpurpose.setBounds(150, 160, 150, 40);
			add(lbl_workpurpose);
			lbl_EmpName=new JLabel("Employee Name");
			lbl_EmpName.setBounds(150, 210, 150, 40);
			add(lbl_EmpName);
			lbl_Intime=new JLabel("In-Time");
			lbl_Intime.setBounds(150, 270, 150, 40);
			add(lbl_Intime);
			lbl_outTime=new JLabel("Out-Time");
			lbl_outTime.setBounds(150, 350, 150, 40);
			add(lbl_outTime);
			lbl_dep=new JLabel("Department");
			lbl_dep.setBounds(150, 410, 150, 40);
			add(lbl_dep);
			lbl_mobileNo=new JLabel("Mobile No");
			lbl_mobileNo.setBounds(150, 480, 150, 40);
			add(lbl_mobileNo);
			lbl_address=new JLabel("Address");
			lbl_address.setBounds(150, 550, 150, 40);
			add(lbl_address);
			lbl_email=new JLabel("Email");
			lbl_email.setBounds(150, 610, 150, 40);
			add(lbl_email);
			
			
			tf_VEntry=new JTextField("V"+String.valueOf(n));
			tf_VEntry.setBounds(300, 60, 150, 40);
			add(tf_VEntry);
			tf_VEntry.addActionListener(this);
			t2=new JTextField();
			t2.setBounds(300, 110, 150, 40);
			add(t2);
			t2.addActionListener(this);
			t3=new JTextField();
			t3.setBounds(300, 160, 150, 40);
			add(t3);
			t3.addActionListener(this);
			t4=new JTextField();
			t4.setBounds(300, 210, 150, 40);
			add(t4);
			t4.addActionListener(this);
			t5=new JTextField(String.valueOf(date));
			t5.setBounds(300, 270, 200, 40);
			add(t5);
			t5.addActionListener(this);
			t6=new JTextField();
			t6.setBounds(300, 350, 200, 40);
			add(t6);
			t6.addActionListener(this);
//			t5=new JTextField();
//			t5.setBounds(300, 270, 150, 40);
//			add(t5);
//			t5.addActionListener(this);
//			t6=new JTextField();
//			t6.setBounds(300, 350, 150, 40);
//			add(t6);
//			t6.addActionListener(this);
			t7=new JTextField();
			t7.setBounds(300, 410, 150, 40);
			add(t7);
			t7.addActionListener(this);
			t8=new JTextField();
			t8.setBounds(300, 480, 150, 40);
			add(t8);
			t8.addActionListener(this);
			t9=new JTextField();
			t9.setBounds(300, 550, 150, 40);
			add(t9);
			t9.addActionListener(this);
			t10=new JTextField();
			t10.setBounds(300, 610, 150, 40);
			add(t10);
			t10.addActionListener(this);
			
			bt1=new JButton("Register");
			bt1.setBounds(550,550,150,40);
			add(bt1);
			bt1.addActionListener(this);
//			bt2=new JButton("back to login");
//			bt2.setBounds(430,550,150,40);
//			add(bt2);
//			bt2.addActionListener(this);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new	VisitorAutomaticId();
	
	}
	

	@Override
	public void actionPerformed(ActionEvent p) {
		// TODO Auto-generated method stub
		if(p.getSource()==bt1){
			String ab=tf_VEntry.getText();
			String ac=t2.getText();
			String ad=t3.getText();
			String ae=t4.getText();
			String af=t5.getText();
			String ag=t6.getText();
			String ah=t7.getText();
			String aj=t8.getText();
			String ak=t9.getText();
			String am=t10.getText();
			if( ab.length()==0||ac.length()==0||ad.length()==0||ae.length()==0||af.length()==0||ag.length()==0||ah.length()==0||aj.length()==0||ak.length()==0||am.length()==0){
				JOptionPane.showMessageDialog(this,"incomplete data");
			}
			else{
				Connection con; PreparedStatement st;
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
							
					String sql="insert into visitorEntry values(?,?,?,?,?,?,?,?,?,?)";
					st=con.prepareStatement(sql);
					st.setString(1,"E"+tf_VEntry.getText());
					st.setString(2,t2.getText());
					st.setString(3,t3.getText());
					st.setString(4,t4.getText());
					st.setString(5,t5.getText());
					st.setString(6,t6.getText());
					st.setString(7,t7.getText());
					st.setString(8,t8.getText());
					st.setString(9,t9.getText());
					st.setString(10,t10.getText());
					

					int g=st.executeUpdate();
					con.close();
					JOptionPane.showMessageDialog(this,"Data Saved");
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
}
}
}
