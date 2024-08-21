//package JavaProject1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.awt.color.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Registration extends JFrame implements ActionListener{

		JLabel lbl_USerRegistration,lbl_username,lbl_FirstName,lbl_LastName,lbl_Email,lbl_Password,lbl_confirmPassword;
		JTextField tf_UserName,tf_FirstName,tf_LastName,tf_Email,tf_Password,tf_ConfirmPassword;
		JButton bt1,bt2;
		Registration(){

			setSize(700,700);
			setTitle("REGISTRATION");
			setLayout(null);
			
			lbl_USerRegistration=new JLabel("USER REGISTRATION");
			lbl_USerRegistration.setBounds(190, 50, 400, 40);
			lbl_USerRegistration.setBackground(Color.WHITE);
			add(lbl_USerRegistration);
			lbl_USerRegistration.setFont(new Font("Arial",Font.PLAIN,30));
			
			lbl_username=new JLabel("USERNAME");
			lbl_username.setBounds(220, 120, 150, 40);
			add(lbl_username);
			
			tf_UserName=new JTextField();
			tf_UserName.setBounds(300, 120, 150, 40);
			add(tf_UserName);
			tf_UserName.addActionListener(this);
			
			lbl_FirstName=new JLabel("FIRST NAME");
			lbl_FirstName.setBounds(220, 190, 150, 40);
			add(lbl_FirstName);
			
			tf_FirstName=new JTextField();
			tf_FirstName.setBounds(300, 190, 150, 40);
			add(tf_FirstName);
			tf_FirstName.addActionListener(this);
			
			lbl_LastName=new JLabel("LAST NAME");
			lbl_LastName.setBounds(220, 260, 150, 40);
			add(lbl_LastName);
			
			tf_LastName=new JTextField();
			tf_LastName.setBounds(300, 260, 150, 40);
			add(tf_LastName);
			tf_LastName.addActionListener(this);
			
			lbl_Email=new JLabel("E_MAIL");
			lbl_Email.setBounds(220, 330, 150, 40);
			add(lbl_Email);
			
			tf_Email=new JTextField();
			tf_Email.setBounds(300, 330, 150, 40);
			add(tf_Email);
			tf_Email.addActionListener(this);
			
			lbl_Password=new JLabel("PASWORD");
			lbl_Password.setBounds(220, 400, 150, 40);
			add(lbl_Password);
			
			tf_Password=new JTextField();
			tf_Password.setBounds(300, 400, 150, 40);
			add(tf_Password);
			tf_Password.addActionListener(this);
			
			lbl_confirmPassword=new JLabel("CONFIRM PASSWORD");
			lbl_confirmPassword.setBounds(150, 470, 150, 40);
			add(lbl_confirmPassword);
			
			tf_ConfirmPassword=new JTextField();
			tf_ConfirmPassword.setBounds(300, 470, 150, 40);
			add(tf_ConfirmPassword);
			tf_ConfirmPassword.addActionListener(this);
			
	
			bt1=new JButton("Register");
			bt1.setBounds(230,550,150,40);
			add(bt1);
			bt1.addActionListener(this);
			bt2=new JButton("back to login");
			bt2.setBounds(430,550,150,40);
			add(bt2);
			bt2.addActionListener(this);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
	
	
	public static void main(String[] args) {
		
		new	Registration();
	}

	@Override
	public void actionPerformed(ActionEvent p) {
		
//		if(p.getSource()==bt1){
//			Connection con; PreparedStatement st;
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				Scanner sc=new Scanner(System.in);
//						
//				String sql="insert into registration values(?,?,?,?,?,?)";
//				
//				st=con.prepareStatement(sql);
//				st.setString(1,t1.getText());
//				st.setString(2,t2.getText());
//				st.setString(3,t3.getText());
//				st.setString(4,t4.getText());
//				st.setString(5,t5.getText());
//				st.setString(6,t6.getText());
//
//				int g=st.executeUpdate();
//				con.close();
//				JOptionPane.showMessageDialog(this,"Data Saved");
//			}
//			catch(Exception e){
//				System.out.println(e);
//			}
			if(p.getSource()==bt1){
				String ab=tf_UserName.getText();
				if( ab.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						Scanner sc=new Scanner(System.in);
								
						String sql="insert into registration values(?,?,?,?,?,?)";
						
						st=con.prepareStatement(sql);
						st.setString(1,tf_UserName.getText());
						st.setString(2,tf_FirstName.getText());
						st.setString(3,tf_LastName.getText());
						st.setString(4,tf_Email.getText());
						st.setString(5,tf_Password.getText());
						st.setString(6,tf_ConfirmPassword.getText());

						int g=st.executeUpdate();
						con.close();
						JOptionPane.showMessageDialog(this,"Data Saved");
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
			
			
	}
		if(p.getSource()==bt2){
			//new Login_vsm();
		}
		
		

}
}
