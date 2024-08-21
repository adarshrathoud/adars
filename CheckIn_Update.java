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

public class CheckIn_Update extends JFrame implements ActionListener {
	JComboBox cb;
	JLabel lbl_CheckIn,lbl_Id,lbl_EmpId,lbl_DepId,lbl_InTime,lbl_OutTime,lbl_GatePass;
	JTextField tf_EmpId,tf_DepId,tf_InTime,tf_OutTime,tf_GatePass;
	JButton bt1,btn1,btn2;
	
	CheckIn_Update(){
		setSize(700,700);
		setTitle("Check IN update");
		setLayout(null);
		
		SimpleDateFormat form =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		lbl_CheckIn=new JLabel("CHECK IN");
		lbl_CheckIn.setBounds(220, 50, 150, 40);
		add(lbl_CheckIn);
		lbl_Id=new JLabel("ID");
		lbl_Id.setBounds(220, 120, 150, 40);
		add(lbl_Id);
		lbl_EmpId=new JLabel("Emp_ID");
		lbl_EmpId.setBounds(220, 190, 150, 40);
		add(lbl_EmpId);
		lbl_DepId=new JLabel("Departement ID");
		lbl_DepId.setBounds(200, 260, 150, 40);
		add(lbl_DepId);
		lbl_InTime=new JLabel("InTime");
		lbl_InTime.setBounds(220, 330, 150, 40);
		add(lbl_InTime);
		lbl_OutTime=new JLabel("OutTime");
		lbl_OutTime.setBounds(220, 400, 150, 40);
		add(lbl_OutTime);
		lbl_GatePass=new JLabel("Gatepass");
		lbl_GatePass.setBounds(220, 470, 150, 40);
		add(lbl_GatePass);
		
		
		cb=new JComboBox();
		cb.setBounds(300, 120, 150, 40);
		fillStaffid();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(450, 50, 150, 40);
		add(btn1);
		btn1.addActionListener(this);
		tf_EmpId=new JTextField();
		tf_EmpId.setBounds(300, 190, 150, 40);
		add(tf_EmpId);
		tf_EmpId.addActionListener(this);
		tf_DepId=new JTextField();
		tf_DepId.setBounds(300, 260, 150, 40);
		add(tf_DepId);
		tf_DepId.addActionListener(this);
		tf_InTime=new JTextField(String.valueOf(date));
		tf_InTime.setBounds(300, 330, 200, 40);
		add(tf_InTime);
		tf_InTime.addActionListener(this);
		tf_OutTime=new JTextField();
		tf_OutTime.setBounds(300, 400, 150, 40);
		add(tf_OutTime);
		tf_OutTime.addActionListener(this);
		tf_GatePass=new JTextField();
		tf_GatePass.setBounds(300, 470, 150, 40);
		add(tf_GatePass);
		tf_GatePass.addActionListener(this);
		

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
				String sql="select id from CheckIn";
				st=con.prepareStatement(sql);
				rs=st.executeQuery();
				while(rs.next())
				{
					cb.addItem(String.valueOf(rs.getInt(1)));
				}
			}
			catch(Exception e){}
		
	}
	
	
	public static void main(String[] args){
		new CheckIn_Update();
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
						
				String sql="select empid,departmentid,intime,outtime,gatepass from CheckIn where id=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				
				tf_EmpId.setText("");
				tf_DepId.setText("");
				tf_InTime.setText("");
				tf_OutTime.setText("");
				tf_GatePass.setText("");
				
//				st.setString(2,t2.getText());
//				st.setString(3,t3.getText());
//				st.setString(4,String.valueOf(t4.getText()));
//				st.setString(5,String.valueOf(t5.getText()));
//				st.setString(6,t6.getText());
				
				if (rs.next()){
					
					tf_EmpId.setText(String.valueOf(rs.getInt(1)));
					tf_DepId.setText(String.valueOf(rs.getInt(2)));
					tf_InTime.setText(rs.getString(3));
					tf_OutTime.setText(rs.getString(4));
					tf_GatePass.setText(String.valueOf(rs.getInt(5)));
					
					
//					t2.setText(rs.getString(1));
//					t3.setText(rs.getString(2));
//					t4.setText(rs.getString(3));
//					t5.setText(rs.getString(4));
//					t6.setText(rs.getString(5));
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
			String ab=tf_EmpId.getText();
			String ac=tf_DepId.getText();
			if( ab.length()==0||ac.length()==0){
				JOptionPane.showMessageDialog(this,"incomplete data");
			}
			else{
				Connection con; PreparedStatement st;
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					
							
					String sql="update CompanyInfo set name=?,address=?,emailid=?,contactno=? where companycode=?";
					st=con.prepareStatement(sql);
					st.setString(1,String.valueOf(tf_EmpId.getText()));
					st.setString(2,tf_DepId.getText());
					st.setString(3,String.valueOf(tf_InTime.getText()));
					st.setString(4,tf_OutTime.getText());
					st.setString(5,tf_GatePass.getText());
					

					int g=st.executeUpdate();
					con.close();
					JOptionPane.showMessageDialog(this,"Data Saved");
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
//			Connection con;
//			PreparedStatement st;
//			int x=Integer.parseInt(cb.getSelectedItem().toString()); //id
//			int y=Integer.parseInt(t2.getText());   
//			int z1=Integer.parseInt(t3.getText()); 
//			String z=t4.getText(); // intime
//			String sa=t5.getText();// outitme
//			int ga=Integer.parseInt(t6.getText());// gatepass
//			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				String sql="update CompanyInfo set name=?,address=?,emailid=?,contactno=? where companycode=?";
//				st=con.prepareStatement(sql);
//				
//				st.setInt(1, y);				
//				st.setInt(2, z1);
//				st.setString(3, z);
//				st.setString(4, sa);
//				st.setInt(5, ga);
//				
//				
//				
//				int g=st.executeUpdate();
//				JOptionPane.showMessageDialog(this, "record Updated..");
//				cb.removeAllItems();
//				fillStaffid();
//				t2.setText("");
//				t3.setText("");
//				t4.setText("");
//				t5.setText("");
//				t6.setText("");
//			}
//			catch(Exception ex) {
//				System.out.println(ex.toString());
//			}

		}
		if(p.getSource()==bt1) {
			cb.removeAllItems();
			fillStaffid();
			
			tf_EmpId.setText("");
			tf_DepId.setText("");
			tf_InTime.setText("");
			tf_OutTime.setText("");
			tf_GatePass.setText("");
			
		}
		
		

		
	}
}