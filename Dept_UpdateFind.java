//package JavaProject1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dept_UpdateFind extends JFrame implements ActionListener{
	JComboBox cb;
	JLabel lbl_Find_Update,lbl_DepID,lbl_Name,lbl_HodId,a4,a5;
	JTextField tf_Name,tf_HodId,t4,t5;
	JButton bt1,btn1,btn2;
	Dept_UpdateFind(){
		setSize(700,700);
		setTitle("Department update and find");
		setLayout(null);
		lbl_Find_Update=new JLabel("FIND AND UPDATE");
		lbl_Find_Update.setBounds(160, 50, 150, 40);
		lbl_Find_Update.setFont(new Font("Arial",Font.PLAIN,15));
		add(lbl_Find_Update);
		
		lbl_DepID=new JLabel("Department_ID");
		lbl_DepID.setBounds(200, 120, 150, 40);
		add(lbl_DepID);
		
		lbl_Name=new JLabel("Name");
		lbl_Name.setBounds(220, 190, 150, 40);
		add(lbl_Name);
		
		tf_Name=new JTextField();
		tf_Name.setBounds(300, 190, 150, 40);
		add(tf_Name);
		tf_Name.addActionListener(this);
		
		lbl_HodId=new JLabel("HOD.ID");
		lbl_HodId.setBounds(220, 260, 150, 40);
		add(lbl_HodId);
		
		tf_HodId=new JTextField();
		tf_HodId.setBounds(300, 260, 150, 40);
		add(tf_HodId);
		
		cb=new JComboBox();
		cb.setBounds(300, 120, 150, 40);
		fillStaffid();
		add(cb);

		btn1=new JButton("Find");
		btn1.setBounds(500, 120, 150, 40);
		add(btn1);
		btn1.addActionListener(this);
		
		bt1=new JButton("clear");
		bt1.setBounds(260,550,150,40);
		add(bt1);
		bt1.addActionListener(this);
		
		btn2=new JButton("Update");
		btn2.setBounds(500, 550, 150, 40);
		add(btn2);
		btn2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	 void fillStaffid() {
		 Connection con;
			PreparedStatement st;ResultSet rs;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select DEPARTMENTID from Department";
				st=con.prepareStatement(sql);
				rs=st.executeQuery();
				while(rs.next())
				{
					cb.addItem(String.valueOf(rs.getInt(1)));
				}
			}
			catch(Exception e){}	
		
	}
	public static void main(String[] args) {
		new Dept_UpdateFind();
	}

	@Override
	public void actionPerformed(ActionEvent p) {
		if(p.getSource()==btn1){
			Connection con; PreparedStatement st; ResultSet rs;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
				Scanner sc=new Scanner(System.in);
						
				String sql="select NAME,HODID from Department where DEPARTMENTID=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_Name.setText("");
				tf_HodId.setText("");
				
			
				if (rs.next()){
					
					tf_Name.setText(rs.getString(1));
					tf_HodId.setText(String.valueOf(rs.getInt(2)));
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Not found..");
				}

				
				con.close();
				
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
		
	}
//		if(p.getSource()==btn2){
//			Connection con;
//			PreparedStatement st;
//			int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
//			String y=t2.getText(); // name 
//			int sa=Integer.parseInt(t3.getText()); // hodid
//			
//			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				String sql="update Department set NAME=?,HODID=? where DEPARTMENTID=?";
//				st=con.prepareStatement(sql);
//				st.setString(1, y);
//				st.setInt(2, sa);
//				st.setInt(3, x);
//				
//				
//				int g=st.executeUpdate();
//				JOptionPane.showMessageDialog(this, "record Updated..");
//				cb.removeAllItems();
//				fillStaffid();
//				t2.setText("");
//				t3.setText("");
//				
//			}
//			catch(Exception ex) {
//				System.out.println(ex.toString());
//			}
			if(p.getSource()==btn2){
				String ab=tf_Name.getText();
	            String bc=tf_HodId.getText();
				if( ab.length()==0||bc.length()==0){
					JOptionPane.showMessageDialog(this,"incomplete data");
				}
				else{
					Connection con;
					PreparedStatement st;
					int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
					String y=tf_Name.getText(); // name 
					int sa=Integer.parseInt(tf_HodId.getText()); // hodid
					
					
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						String sql="update Department set NAME=?,HODID=? where DEPARTMENTID=?";
						st=con.prepareStatement(sql);
						st.setString(1, y);
						st.setInt(2, sa);
						st.setInt(3, x);
						
						
						int g=st.executeUpdate();
						JOptionPane.showMessageDialog(this, "record Updated..");
						cb.removeAllItems();
						fillStaffid();
						tf_Name.setText("");
						tf_HodId.setText("");
						
					}
					catch(Exception ex) {
						System.out.println(ex.toString());
					}
				}

		}
		if(p.getSource()==bt1){
			cb.removeAllItems();
			fillStaffid();
			tf_Name.setText("");
			tf_HodId.setText("");
			
			
		}
		
	}

}
