//package JavaProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckOut_update extends JFrame implements ActionListener  {
	JLabel lbl_CheckOut,lbl_ID,lbl_Check_Out;
	JTextField t1,tf_CheckOut;
	JButton bt1,btn1,btn2;
	JComboBox cb;
	CheckOut_update(){
		setSize(700,700);
		setTitle("CHECK_IN");
		setLayout(null);
		
		SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		lbl_CheckOut=new JLabel("CHECK_OUT");
		lbl_CheckOut.setBounds(220, 50, 150, 40);
		add(lbl_CheckOut);
		lbl_ID=new JLabel("ID");
		lbl_ID.setBounds(220, 120, 150, 40);
		add(lbl_ID);
		lbl_Check_Out=new JLabel("CheckOut");
		lbl_Check_Out.setBounds(220, 190, 150, 40);
		add(lbl_Check_Out);
		
//		t1=new JTextField();
//		t1.setBounds(300, 120, 150, 40);
//		add(t1);
	//	t1.addActionListener(this);
		tf_CheckOut=new JTextField(String.valueOf(date));
		tf_CheckOut.setBounds(300, 190, 200, 40);
		add(tf_CheckOut);
		
		cb=new JComboBox();
		cb.setBounds(300, 120, 150, 40);
		fillStaffid();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(450, 50, 150, 40);
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
	private void fillStaffid() {
		Connection con;
		PreparedStatement st;ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select gatepass from CheckOut";
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
		new CheckOut_update();

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
						
				String sql="select outtime from CheckOut where gatepass=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				

				
				if (rs.next()){
					
					//t2.setText(String.valueOf(rs.getInt(1)));
//					t3.setText(String.valueOf(rs.getInt(2)));
					tf_CheckOut.setText(rs.getString(1));
//					t5.setText(rs.getString(4));
//					t6.setText(String.valueOf(rs.getInt(5)));
					
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
		if(p.getSource()==btn2){
			Connection con;
			PreparedStatement st;
			int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
			String y=tf_CheckOut.getText();   
//			int z1=Integer.parseInt(t3.getText()); 
//			String z=t4.getText(); // intime
//			String sa=t5.getText();// outitme
//			int ga=Integer.parseInt(t6.getText());// gatepass
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="update CheckOut set outtime=?  where gatepass=?";
				st=con.prepareStatement(sql);
				
				st.setString(1, y);				
//				st.setInt(2, z1);
//				st.setString(3, z);
//				st.setString(4, sa);
//				st.setInt(5, ga);
				st.setInt(6, x);
				
				
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "record Updated..");
				cb.removeAllItems();
				fillStaffid();
				tf_CheckOut.setText("");
//				t3.setText("");
//				t4.setText("");
//				t5.setText("");
//				t6.setText("");
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}

		}
		if(p.getSource()==bt1) {
			cb.removeAllItems();
			fillStaffid();
			
			tf_CheckOut.setText("");
//			t3.setText("");
//			t4.setText("");
//			t5.setText("");
//			t6.setText("");
			
		}
		
	}}


