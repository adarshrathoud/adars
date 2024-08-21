//package JavaProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sun.security.util.Length;

public class CheckOut_Insert extends JFrame implements ActionListener {

	JLabel lbl_CheckOut,lbl_GatePass,lbl_Check_Out;
	JTextField tf_GatePass,tf_CheckOut;
	JButton bt1;
	CheckOut_Insert(){
		setSize(700,700);
		setTitle("CHECK_OUT");
		setLayout(null);
		
		SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		lbl_CheckOut=new JLabel("CHECK_OUT");
		lbl_CheckOut.setBounds(220, 50, 150, 40);
		add(lbl_CheckOut);
		lbl_GatePass=new JLabel("GatePass");
		lbl_GatePass.setBounds(220, 120, 150, 40);
		add(lbl_GatePass);
		lbl_Check_Out=new JLabel("CheckOut");
		lbl_Check_Out.setBounds(220, 190, 150, 40);
		add(lbl_Check_Out);
		
		tf_GatePass=new JTextField();
		tf_GatePass.setBounds(300, 120, 150, 40);
		add(tf_GatePass);
		tf_GatePass.addActionListener(this);
		tf_CheckOut=new JTextField(String.valueOf(date));
		tf_CheckOut.setBounds(300, 190, 200, 40);
		add(tf_CheckOut);
		bt1=new JButton("save");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		
		new CheckOut_Insert();
	}

	@Override
	public void actionPerformed(ActionEvent p) {
		
         if(p.getSource()==bt1){
			Connection con; PreparedStatement st;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				Scanner sc=new Scanner(System.in);
						
				String sql="insert into CheckOut values(?,?)";
				
				st=con.prepareStatement(sql);
				st.setString(1,String.valueOf(tf_GatePass.getText()));
				st.setString(2,tf_CheckOut.getText());
			
				

				int g=st.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(this,"Data Saved");
			}
			catch(Exception e){
				//System.out.println(e);
				JOptionPane.showMessageDialog(this,"incomplete data");
			}
			
		
			
//			if(p.getSource()==bt1){
//				String ab=t1.getText();
//				if( ab.length()==0){
//					JOptionPane.showMessageDialog(this,"incomplete data");
//				}
//				else{
//					Connection con; PreparedStatement st;
//					try{
//						Class.forName("oracle.jdbc.driver.OracleDriver");
//						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//						Scanner sc=new Scanner(System.in);
//								
//						String sql="insert into CheckOut values(?,?)";
//						
//						st=con.prepareStatement(sql);
//						st.setString(1,String.valueOf(t1.getText()));
//						st.setString(2,t2.getText());
//					
//						int g=st.executeUpdate();
//						con.close();
//						JOptionPane.showMessageDialog(this,"Data Saved");
//					}
//					catch(Exception e){
//						System.out.println(e);
//					}
				}
				
			}
	}



