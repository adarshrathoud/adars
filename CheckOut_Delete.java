//package JavaProject1;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.util.*;


public class CheckOut_Delete extends JFrame implements ActionListener{
	JLabel lbl_ID,lbl_CheckOut;
	JTextField tf_CheckOut;
	JComboBox J_cb;
	JButton btn1,btn2;
	
	public CheckOut_Delete() {
		setSize(700,700);
		setLayout(null);
		
		lbl_ID=new JLabel("ID");
		lbl_ID.setBounds(100, 50, 150, 40);
		add(lbl_ID);
		lbl_CheckOut=new JLabel("CHECK_OUT");
		lbl_CheckOut.setBounds(100, 100, 150, 40);
		add(lbl_CheckOut);
		
		J_cb=new JComboBox();
		J_cb.setBounds(200,50,100,40);
		fillStudentroll();
		add(J_cb);
		btn1=new JButton("Find");
		btn1.setBounds(400,50,100,40);
		add(btn1);
		btn1.addActionListener(this);
		
		tf_CheckOut=new JTextField();
		tf_CheckOut.setBounds(200,100,200,40);
		add(tf_CheckOut);
		
		
		btn2=new JButton("Delete");
		btn2.setBounds(320,300,100,40);
		add(btn2);
		btn2.addActionListener(this);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new CheckOut_Delete();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==btn1) {
			Connection con;
			PreparedStatement st;
			ResultSet rs;
			int x=Integer.parseInt(J_cb.getSelectedItem().toString()); //id
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				
				String sql="select outtime from CheckOut where gatepass=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				rs=st.executeQuery();
				tf_CheckOut.setText("");
				
				if(rs.next()) {
					tf_CheckOut.setText(rs.getString(1));
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Not Founds..");
					
				}
				con.close();
				
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
		
		if(ae.getSource()==btn2) {
			Connection con;
			PreparedStatement st;
			int x=Integer.parseInt(J_cb.getSelectedItem().toString());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="delete from CheckOut where gatepass=?";
				st=con.prepareStatement(sql);
				st.setInt(1, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record deleted..");
				J_cb.removeAllItems();
				fillStudentroll();
				tf_CheckOut.setText("");
				con.close();
				
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
	}
	void fillStudentroll() {
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select gatepass from CheckOut";
			
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()) {
				J_cb.addItem(String.valueOf(rs.getInt(1)));
				
			}	
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

}

