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

public class Dept_Holidays_Insert extends JFrame implements ActionListener{

	JLabel lbl_DepId,lbl_Holiday;
	JTextField tf_DepId,tf_Holiday;
	JButton bt1;
	Dept_Holidays_Insert(){
		
		setSize(700,700);
		setTitle("DEPT.HOlidays_INSERTION");
		setLayout(null);
		
		lbl_DepId=new JLabel("Dept.ID");
		lbl_DepId.setBounds(220, 120, 150, 40);
		add(lbl_DepId);
		
		tf_DepId=new JTextField();
		tf_DepId.setBounds(300, 120, 150, 40);
		add(tf_DepId);
		tf_DepId.addActionListener(this);
		
		lbl_Holiday=new JLabel("Holiday");
		lbl_Holiday.setBounds(220, 190, 150, 40);
		add(lbl_Holiday);
		
		
		tf_Holiday=new JTextField();
		tf_Holiday.setBounds(300, 190, 150, 40);
		add(tf_Holiday);
		
		
		
		
		bt1=new JButton("sove");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		
		new Dept_Holidays_Insert();
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
//				String sql="insert into departmentCalender values(?,?)";
//				
//				st=con.prepareStatement(sql);
//				st.setString(1,String.valueOf(t1.getText()));
//				st.setString(2,t2.getText());
//			
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
				String ab=tf_DepId.getText();
				if( ab.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				} 
				else{
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						Scanner sc=new Scanner(System.in);
								
						String sql="insert into departmentCalender values(?,?)";
						
						st=con.prepareStatement(sql);
						st.setString(1,String.valueOf(tf_DepId.getText()));
						st.setString(2,tf_Holiday.getText());
					
						

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
