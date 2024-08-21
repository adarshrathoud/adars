//package JavaProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Company_Insert extends JFrame implements ActionListener {

	JLabel lbl_Com_info,lbl_ComCode,lbl_Name,lbl_Address,lbl_Email,lbl_MobileNo;
	JTextField tf_ComCode,tf_Name,tf_Address,tf_EMail,tf_MobileNo;
	JButton bt1;
	Company_Insert(){
		setSize(700,700);
		setTitle("COMPANY_INFO");
		setLayout(null);
		
		lbl_Com_info=new JLabel("COMPANY_INFORMATION");
		lbl_Com_info.setBounds(220, 50, 150, 40);
		add(lbl_Com_info);
		lbl_ComCode=new JLabel("Company_Code");
		lbl_ComCode.setBounds(180, 120, 150, 40);
		add(lbl_ComCode);
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(220, 190, 150, 40);
		add(lbl_Name);
		lbl_Address=new JLabel("Address");
		lbl_Address.setBounds(220, 260, 150, 40);
		add(lbl_Address);
		lbl_Email=new JLabel("Email");
		lbl_Email.setBounds(220, 330, 150, 40);
		add(lbl_Email);
		lbl_MobileNo=new JLabel("contact no");
		lbl_MobileNo.setBounds(220, 400, 150, 40);
		add(lbl_MobileNo);
	
		tf_ComCode=new JTextField();
		tf_ComCode.setBounds(300, 120, 150, 40);
		add(tf_ComCode);
		tf_ComCode.addActionListener(this);
		tf_Name=new JTextField();
		tf_Name.setBounds(300, 190, 150, 40);
		add(tf_Name);
		tf_Name.addActionListener(this);
		tf_Address=new JTextField();
		tf_Address.setBounds(300, 260, 150, 40);
		add(tf_Address);
		tf_Address.addActionListener(this);
		tf_EMail=new JTextField();
		tf_EMail.setBounds(300, 330, 150, 40);
		add(tf_EMail);
		tf_EMail.addActionListener(this);
		tf_MobileNo=new JTextField();
		tf_MobileNo.setBounds(300, 400, 150, 40);
		add(tf_MobileNo);
		tf_MobileNo.addActionListener(this);

		
//
		bt1=new JButton("sove");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Company_Insert();
	}
	@Override
	public void actionPerformed(ActionEvent m) {
		
	//	if(m.getSource()==bt1){
//			Connection con; PreparedStatement st;
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				Scanner sc=new Scanner(System.in);
//						
//				String sql="insert into CompanyInfo values(?,?,?,?,?)";
//				
//				st=con.prepareStatement(sql);
//				st.setString(1,String.valueOf(t1.getText()));
//				st.setString(2,t2.getText());
//				st.setString(3,t3.getText());
//				st.setString(4,t3.getText());
//				st.setString(5,String.valueOf(t5.getText()));
//				
//
//				int g=st.executeUpdate();
//				con.close();
//				JOptionPane.showMessageDialog(this,"Data Saved");
//			}
//			catch(Exception e){
//				System.out.println(e);
//			}
			if(m.getSource()==bt1){
				String ab=tf_ComCode.getText();
				if( ab.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
			}
				else{
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						Scanner sc=new Scanner(System.in);
								
						String sql="insert into CompanyInfo values(?,?,?,?,?)";
						
						st=con.prepareStatement(sql);
						st.setString(1,String.valueOf(tf_ComCode.getText()));
						st.setString(2,tf_Name.getText());
						st.setString(3,tf_Address.getText());
						st.setString(4,tf_Address.getText());
						st.setString(5,String.valueOf(tf_MobileNo.getText()));
						

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
