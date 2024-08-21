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

public class hod extends JFrame implements ActionListener {
	JLabel lbl_Hod_id,lbl_Name,lbl_Dep;
	JTextField tf_HodId,tf_Name,tf_Dep;
	JButton btn1,btn2;
	hod (){
		setSize(700,700);
		setTitle("H.O.D Details");
		setLayout(null);
		
		lbl_Hod_id=new JLabel("H.O.D ID");
		lbl_Hod_id.setBounds(220, 120, 150, 40);
		add(lbl_Hod_id);
		
		tf_HodId=new JTextField();
		tf_HodId.setBounds(300, 120, 150, 40);
		add(tf_HodId);
		
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(220, 190, 150, 40);
		add(lbl_Name);
		
		tf_Name=new JTextField();
		tf_Name.setBounds(300, 190, 150, 40);
		add(tf_Name);
		
		lbl_Dep=new JLabel("Department");
		lbl_Dep.setBounds(220, 260, 150, 40);
		add(lbl_Dep);
		
		tf_Dep=new JTextField();
		tf_Dep.setBounds(300, 260, 150, 40);
		add(tf_Dep);
		 btn1=new JButton("save");
		 btn1.setBounds(260,550,150,40);
		 add(btn1);
		 btn1.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new hod ();		

	}
	@Override
	public void actionPerformed(ActionEvent p) {
//		if(p.getSource()==btn1){
//		Connection con; PreparedStatement st;
//		try{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//			Scanner sc=new Scanner(System.in);
//					
//			String sql="insert into hod values(?,?,?)";
//			
//			st=con.prepareStatement(sql);
//			st.setString(1,String.valueOf(t1.getText()));
//			st.setString(2,t2.getText());
//			st.setString(3,t3.getText());
//			
//
//			int g=st.executeUpdate();
//			con.close();
//			JOptionPane.showMessageDialog(this,"Data Saved");
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
		
		
		if(p.getSource()==btn1){
			String ab=tf_Name.getText();
            String bc=tf_Dep.getText();
			if( ab.length()==0||bc.length()==0){
				JOptionPane.showMessageDialog(this,"incomplete data");
			}
			else{
				if(p.getSource()==btn1){
					Connection con; PreparedStatement st;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						Scanner sc=new Scanner(System.in);
								
						String sql="insert into hod values(?,?,?)";
						
						st=con.prepareStatement(sql);
						st.setString(1,String.valueOf(tf_HodId.getText()));
						st.setString(2,tf_Name.getText());
						st.setString(3,tf_Dep.getText());
						

						int g=st.executeUpdate();
						con.close();
						JOptionPane.showMessageDialog(this,"Data Saved");
					}
					catch(Exception e){
						System.out.println(e);
					}
			}
		
	}

}}}
