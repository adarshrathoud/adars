//package JavaProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;


public class LoginSalary extends JFrame implements ActionListener,MouseMotionListener,KeyListener{
	JLabel lbl_Entry,lbl_Name,lbl_Password;
	JTextField tf_Name,tf_Password;
	JButton bt1,bt2;
	LoginSalary(){
		setSize(1900,1000);
		setTitle("My Insert frame");
		setLayout(null);
		lbl_Entry=new JLabel("Entry");
		lbl_Entry.setBounds(600, 20, 300, 40);
		add(lbl_Entry);
		lbl_Name=new JLabel("Enter Name Please : ");
		lbl_Name.setBounds(400, 100, 200, 40);
		add(lbl_Name);
		
		tf_Name=new JTextField();
		tf_Name.setBounds(700, 100, 200, 40);
		add(tf_Name);
		
		lbl_Password=new JLabel("Enter Password Please : ");
		lbl_Password.setBounds(400, 200, 200, 40);
		add(lbl_Password);
		
		tf_Password=new JTextField();
		tf_Password.setBounds(700, 200, 200, 40);
		add(tf_Password);
		
		bt1=new JButton("Login");
		bt1.setBounds(600, 300, 200, 40);
		add(bt1);
		bt2=new JButton("Cancel");
		bt2.setBounds(850, 300, 200, 40);
		add(bt2);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginSalary();
	}
	@Override
	public void actionPerformed(ActionEvent ar) {
		if (ar.getSource()==bt1){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from entry where name='"+tf_Name.getText()+"' and password ='"+tf_Password.getText()+"'";
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Login Successfully");	
					//new MenuSalary();
					new NewLoginForm();
				}else{
					JOptionPane.showMessageDialog(null, "Invalid UserName or Passward");
				}
			}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		}
		if (ar.getSource()==bt2){
			System.exit(1);
		}
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
}