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

public class Visitor_Insert extends JFrame implements ActionListener {

	JLabel lbl_Id,lbl_Name,lbl_MobileNo;
	JTextField tf_Id,tf_Name,tf_Address;
	JButton bt1;
	Visitor_Insert(){
		
		setSize(700,700);
		setTitle("Visitor detail");
		setLayout(null);
		
		lbl_Id=new JLabel("ID");
		lbl_Id.setBounds(220, 120, 150, 40);
		add(lbl_Id);
		
		tf_Id=new JTextField();
		tf_Id.setBounds(300, 120, 150, 40);
		add(tf_Id);
		tf_Id.addActionListener(this);
		
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(220, 190, 150, 40);
		add(lbl_Name);
		
		tf_Name=new JTextField();
		tf_Name.setBounds(300, 190, 150, 40);
		add(tf_Name);
		tf_Name.addActionListener(this);
		
		lbl_MobileNo=new JLabel("Mobile no.");
		lbl_MobileNo.setBounds(220, 260, 150, 40);
		add(lbl_MobileNo);
		
		tf_Address=new JTextField();
		tf_Address.setBounds(300, 260, 150, 40);
		add(tf_Address);
		tf_Address.addActionListener(this);
		
		bt1=new JButton("save");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Visitor_Insert();
	}
	@Override
	public void actionPerformed(ActionEvent p) {
		// TODO Auto-generated method stub
//		if(p.getSource()==bt1){
//			Connection con; PreparedStatement st;
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				Scanner sc=new Scanner(System.in);
//						
//				String sql="insert into VisitorDetails values(?,?,?)";
//				
//				st=con.prepareStatement(sql);
//				st.setString(1,String.valueOf(t1.getText()));
//				st.setString(2,t2.getText());
//				st.setString(3,String.valueOf(t3.getText()));
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
				String ab=tf_Id.getText();
				if( ab.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						Scanner sc=new Scanner(System.in);
								
						String sql="insert into VisitorDetail values(?,?,?)";
						
						st=con.prepareStatement(sql);
						st.setString(1,String.valueOf(tf_Id.getText()));
						st.setString(2,tf_Name.getText());
						st.setString(3,String.valueOf(tf_Address.getText()));
						

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
