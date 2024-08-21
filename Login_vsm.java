//package JavaProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Login_vsm extends JFrame implements ActionListener {
     
	JLabel lbl_Login,lbl_UserName,lbl_Password;
	JTextField tf_UserName,tf_PassWord;
	JButton bt1,bt2;

	

	Login_vsm() {
	
		setSize(700,700);
		setTitle("ADMIN");
		setLayout(null);
			
		lbl_Login= new JLabel("LOGIN");
		add(lbl_Login);
		lbl_Login.setBounds(130, 30, 100,40 );
		lbl_Login.setFont(new Font("Arial",Font.PLAIN,30));
	
		
		lbl_UserName= new JLabel("USERNAME");
		add(lbl_UserName);
		lbl_UserName.setBounds(60, 90, 100,40 );
		
		lbl_Password= new JLabel("PASSWORD");
		add(lbl_Password);
		lbl_Password.setBounds(60, 150, 100,40 );
		
		tf_UserName= new JTextField();
		add(tf_UserName);
		tf_UserName.setBounds(140, 90, 130, 35);
		
		tf_PassWord= new JTextField("");
		add(tf_PassWord);
		tf_PassWord.addActionListener(this);
		tf_PassWord.setBounds(140, 150, 130, 35);
		
		bt1= new JButton("Sign In");
		add(bt1);
		bt1.addActionListener(this);
		bt1.setBounds(70,210,100,40);
		bt2= new JButton("Register");
		add(bt2);
		bt2.addActionListener(this);
		bt2.setBounds(190,210,100,40);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login_vsm();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt2){
			Registration obj=new Registration();
//			obj.setVisible(true);
		}
//		if(ae.getSource()==bt1){
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//			String sql="select * from Registration where username='"+t1.getText()+"' and passward ='"+t2.getText()+"'";
//			PreparedStatement ps= con.prepareStatement(sql);
//			ResultSet rs=ps.executeQuery();
//			
//			if(rs.next()){
//				JOptionPane.showMessageDialog(null, "Success");
//			//Delete obj=new Delete();
//				
//				
//			}else{
//				JOptionPane.showMessageDialog(null, "Invalid UserName and Passward");
//				
//			}
//			
//			
//		} catch (Exception e) {
//			System.out.println(e.toString());
//	}
		if(ae.getSource()==bt1){
			String ab=tf_UserName.getText();
			if( ab.length()==0){
				JOptionPane.showMessageDialog(this,"incomplete data");
			}
			else{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select * from Registration where username='"+tf_UserName.getText()+"' and passward ='"+tf_PassWord.getText()+"'";
					PreparedStatement ps= con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Success");
					//Delete obj=new Delete();
						
						
					}else{
						JOptionPane.showMessageDialog(null, "Invalid UserName and Passward");
						
					}
					
					
				} catch (Exception e) {
					System.out.println(e.toString());
			}	
			}
		
		}
		
	}

}
