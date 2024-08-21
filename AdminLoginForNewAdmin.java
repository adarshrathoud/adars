
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//
//public class AdminLoginForNewAdmin extends JFrame implements ActionListener,MouseMotionListener,KeyListener {
//	JLabel lbltitle,lblname,lblaadhar;
//	JTextField tfname,tfpassword;
//	JButton bt1,bt2;
//	AdminLoginForNewAdmin(){
//		setSize(1900,1000);
//		setTitle("My Insert frame");
//		setLayout(null);
//		lbltitle=new JLabel("Admin Entry");
//		lbltitle.setBounds(600, 20, 300, 40);
//		add(lbltitle);
//		lblname=new JLabel("Enter Name Please : ");
//		lblname.setBounds(400, 100, 200, 40);
//		add(lblname);
//		tfname=new JTextField();
//		tfname.setBounds(700, 100, 200, 40);
//		add(tfname);
//		lblaadhar=new JLabel("Enter Password Please : ");
//		lblaadhar.setBounds(400, 200, 200, 40);
//		add(lblaadhar);
//		tfpassword=new JTextField();
//		tfpassword.setBounds(700, 200, 200, 40);
//		add(tfpassword);
//		bt1=new JButton("Login");
//		bt1.setBounds(600, 300, 200, 40);
//		add(bt1);
//		bt2=new JButton("Cancel");
//		bt2.setBounds(850, 300, 200, 40);
//		add(bt2);
//		bt1.addActionListener(this);
//		bt2.addActionListener(this);
//		//setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//	
//	
//		
//	}
//	public static void main(String[] args) {
//		new AdminLoginForNewAdmin();
//
//	}
//
//	@Override
//	public void keyPressed(KeyEvent arg0) {
//		
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent arg0) {
//		
//		
//	}
//
//	@Override
//	public void keyTyped(KeyEvent arg0) {
//		
//		
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent arg0) {
//		
//		
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent arg0) {
//		
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent ar) {
//		if (ar.getSource()==bt1){
//			try{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
//				String sql="select * from admin where name='"+tfname.getText()+"' and password ='"+tfpassword.getText()+"'";
//				PreparedStatement ps= con.prepareStatement(sql);
//				ResultSet rs=ps.executeQuery();
//				if(rs.next()){
//					JOptionPane.showMessageDialog(null, "Login Successfully");	
//					//new MenuSalary();s
//					//new NewLoginForm();
//					new AdminNewForm();
//				}else{
//					JOptionPane.showMessageDialog(null, "Invalid UserName or Passward");
//				}
//			}
//		catch(Exception ex){
//			System.out.println(ex.toString());
//		}
//		}
//		if (ar.getSource()==bt2){
//			System.exit(1);
//		}
//		
//	}
//
//}





import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AdminLoginForNewAdmin extends JFrame implements ActionListener,MouseMotionListener,KeyListener {
	private static final Border Border = null;
	JLabel title,name,aadhar;
	JTextField tf1,tf2;
	JButton bt1,bt2;
	AdminLoginForNewAdmin(){
		setSize(1900,1000);
		setTitle("My Insert frame");
		setLayout(null);
		title=new JLabel("Admin Entry");
		title.setBounds(600, 20, 300, 70);
		title.setFont(new Font("Arial",Font.BOLD,50));
		title.setForeground(Color.RED);
		add(title);
		name=new JLabel("Enter Name Please : ");
		name.setBounds(400, 100, 200, 40);
		name.setFont(new Font("Arial",Font.BOLD,18));
		
		add(name);
		tf1=new JTextField();
		tf1.setBounds(700, 100, 200, 40);
		add(tf1);
		aadhar=new JLabel("Enter Password Please : ");
		aadhar.setBounds(400, 200, 200, 40);
		aadhar.setFont(new Font("Arial",Font.BOLD,17));

		add(aadhar);
		tf2=new JTextField();
		tf2.setBounds(700, 200, 200, 40);
		add(tf2);
		bt1=new JButton("Login");
		bt1.setBounds(600, 300, 200, 40);
		bt1.setFont(new Font("Arial",Font.BOLD,30));
		bt1.setForeground(Color.white);
		bt1.setBackground(Color.RED);
		add(bt1);
		
		bt2=new JButton("Cancel");
		bt2.setBounds(850, 300, 200, 40);
		bt2.setFont(new Font("Arial",Font.BOLD,30));
		bt2.setForeground(Color.white);
		bt2.setBackground(Color.GREEN);
		add(bt2);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
	
		
	}
	public static void main(String[] args) {
		new AdminLoginForNewAdmin();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ar) {
		if (ar.getSource()==bt1){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from admin where name='"+tf1.getText()+"' and password ='"+tf2.getText()+"'";
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Login Successfully");	
					//new MenuSalary();s
					//new NewLoginForm();
					new AdminNewForm();
				}else{
					JOptionPane.showMessageDialog(null, "Invalid UserName or Passward");
				}
			}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		}
		if (ar.getSource()==bt2){
			new NewLoginForm();
			
			System.exit(1);
		}
		
	}

}
