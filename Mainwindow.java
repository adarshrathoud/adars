//package JavaProject1;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Mainwindow extends JFrame implements ActionListener {
	
	JMenu JM_Admin,JM_ComInfo,JM_Dep,JM_Dep_calender,JM_EmpDetails,JM_VisitorDetail,JM_hod;
	JMenuItem JMI_Insert,JMI_insert,JMI_insert2,JMI_insert3,JMI_insert4,JMI_insert5,JMI_insert6,
	          JMI_Delete,JMI_delete,JMI_delete2,JMI_delete3,JMI_delete4,JMI_delete5,JMI_delete6,
			  JMI_Update_Find,JMI_update_find,JMI_find_update2,JMI_find_update3,JMI_update_find4,JMI_update_find5,JMI_update_find6;
	JMenuBar JMenuBar;
	JButton JBtn_insert,JBtn_insert2,JBtn_delete,JBtn_delete2,JBtn_update,JBtn_update2;
	JLabel lbl_CheckIn,lbl_CheckOut;
	Mainwindow(){
		setSize(700,700);
		setTitle("MAIN");
		setLayout(null);

		JM_Admin=new JMenu("Admin");
		add(JM_Admin);
		
		JMI_Insert=new JMenuItem("INSERT");
		JMI_Insert.addActionListener(this);
		
		JMI_Delete=new JMenuItem("DELETE");
		JMI_Delete.addActionListener(this);
		
		JMI_Update_Find=new JMenuItem("FIND & UPDATE");
		JMI_Update_Find.addActionListener(this);
		
		JM_Admin.add(JMI_Insert);
		JM_Admin.addSeparator();
		JM_Admin.add(JMI_Delete);
		JM_Admin.addSeparator();
		JM_Admin.add(JMI_Update_Find);
		JM_Admin.addSeparator();
		
		
		
		JM_ComInfo=new JMenu("Company Information");
		add(JM_ComInfo);
		
		JMI_insert=new JMenuItem("INSERT");
		JMI_insert.addActionListener(this);
		
		JMI_delete=new JMenuItem("DELETE");
		JMI_delete.addActionListener(this);
		
		JMI_update_find=new JMenuItem("FIND & UPDATE");
		JMI_update_find.addActionListener(this);
		
		JM_ComInfo.add(JMI_insert);
		JM_ComInfo.addSeparator();
		JM_ComInfo.add(JMI_delete);
		JM_ComInfo.addSeparator();
		JM_ComInfo.add(JMI_update_find);
		JM_ComInfo.addSeparator();
		
		JM_Dep=new JMenu("Department");
		add(JM_Dep);
		
		JMI_insert2=new JMenuItem("INSERT");
		JMI_insert2.addActionListener(this);
		
		JMI_delete2=new JMenuItem("DELETE");
		JMI_delete2.addActionListener(this);
		
		JMI_find_update2=new JMenuItem("FIND & UPDATE");
		JMI_find_update2.addActionListener(this);
		
		JM_Dep.add(JMI_insert2);
		JM_Dep.addSeparator();
		
		JM_Dep.add(JMI_delete2);
		JM_Dep.addSeparator();
		
		JM_Dep.add(JMI_find_update2);
		JM_Dep.addSeparator();
		
		
		
		JM_Dep_calender=new JMenu("DepatmentCalender");
		add(JM_Dep_calender);
		
		JMI_insert3=new JMenuItem("INSERT");
		JMI_insert3.addActionListener(this);
		
		JMI_delete3=new JMenuItem("DELETE");
		JMI_delete3.addActionListener(this);
		
		JMI_find_update3=new JMenuItem("FIND & UPDATE");
		JMI_find_update3.addActionListener(this);
		
		JM_Dep_calender.add(JMI_insert3);
		JM_Dep_calender.addSeparator();
		
		JM_Dep_calender.add(JMI_delete3);
		JM_Dep_calender.addSeparator();
		
		JM_Dep_calender.add(JMI_find_update3);
		JM_Dep_calender.addSeparator();
		
		
		JM_EmpDetails=new JMenu("Employee Details");
		add(JM_EmpDetails);
		
		JMI_insert4=new JMenuItem("INSERT");
		JMI_insert4.addActionListener(this);
		
		
		JMI_delete4=new JMenuItem("DELETE");
		JMI_delete4.addActionListener(this);
		
		JMI_update_find4=new JMenuItem("FIND & UPDATE");
		JMI_update_find4.addActionListener(this);
		
		JM_EmpDetails.add(JMI_insert4);
		JM_EmpDetails.addSeparator();
		
		JM_EmpDetails.add(JMI_delete4);
		JM_EmpDetails.addSeparator();
		
		JM_EmpDetails.add(JMI_update_find4);
		JM_EmpDetails.addSeparator();
		
		
		JM_VisitorDetail=new JMenu("Visitor Details");
		add(JM_VisitorDetail);
		
		JMI_insert5=new JMenuItem("INSERT");
		JMI_insert5.addActionListener(this);
		
		JMI_delete5=new JMenuItem("DELETE");
		JMI_delete5.addActionListener(this);
		
		JMI_update_find5=new JMenuItem("FIND & UPDATE");
		JMI_update_find5.addActionListener(this);
		
		JM_VisitorDetail.add(JMI_insert5);
		JM_VisitorDetail.addSeparator();
		
		JM_VisitorDetail.add(JMI_delete5);
		JM_VisitorDetail.addSeparator();
		
		JM_VisitorDetail.add(JMI_update_find5);
		JM_VisitorDetail.addSeparator();
		
		
		lbl_CheckIn=new JLabel("CHECK IN");
		add(lbl_CheckIn);
		lbl_CheckIn.setFont(new Font("Arial",Font.PLAIN,25));
		lbl_CheckIn.setBounds(60,120,250,40);
		
		JBtn_insert=new JButton("INSERT");
		JBtn_insert.setBounds(65,200,100,40);
		JBtn_insert.addActionListener(this);
		
		JBtn_delete=new JButton("DELETE");
		JBtn_delete.setBounds(65,270,100,40);
		JBtn_delete.addActionListener(this);
		
		JBtn_update=new JButton("UPDATE");
		JBtn_update.setBounds(65,340,100,40);
		JBtn_update.addActionListener(this);
		
		add(JBtn_insert);
		add(JBtn_delete);
		add(JBtn_update);
		
		
		
		lbl_CheckOut=new JLabel("CHECK OUT");
		add(lbl_CheckOut);
		lbl_CheckOut.setFont(new Font("Arial",Font.PLAIN,25));
		lbl_CheckOut.setBounds(220, 120, 250, 40);
		
		JBtn_insert2=new JButton("INSERT");
		JBtn_insert2.setBounds(220,200,100,40);
		JBtn_insert2.addActionListener(this);
		
		JBtn_delete2=new JButton("DELETE");
		JBtn_delete2.setBounds(220,270,100,40);
		JBtn_delete2.addActionListener(this);
		
		JBtn_update2=new JButton("UPDATE");
		JBtn_update2.setBounds(220,340,100,40);
		JBtn_update2.addActionListener(this);
		
		add(JBtn_insert2);
		add(JBtn_delete2);
		add(JBtn_update2);
		
		JM_hod=new JMenu("HOD");
		add(JM_hod);
		JM_hod.setBounds(1050,120,100,40);
		
		JMI_insert6=new JMenuItem("INSERT");
		JMI_insert6.addActionListener(this);
		
		JMI_delete6=new JMenuItem("DELETE");
		JMI_delete6.addActionListener(this);
		
		JMI_update_find6=new JMenuItem("FIND & UPDATE");
		JMI_update_find6.addActionListener(this);
		
		JM_hod.add(JMI_insert6);
		JM_hod.addSeparator();
		JM_hod.add(JMI_delete6);
		JM_hod.addSeparator();
		JM_hod.add(JMI_update_find6);
		JM_hod.addSeparator();
	
		
		
        JMenuBar=new JMenuBar();
        JMenuBar.add(JM_Admin);
        JMenuBar.add(JM_ComInfo);
        JMenuBar.add(JM_Dep);
        JMenuBar.add(JM_Dep_calender);
        JMenuBar.add(JM_EmpDetails);
        JMenuBar.add(JM_VisitorDetail);
//        b1.add(a7);
//        b1.add(a8);
        JMenuBar.add(JM_hod);
        
        setJMenuBar(JMenuBar);
//        add(b1);
//        b1.setBounds(130, 200, 300, 35);
//        b1.setSize(60,35);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mainwindow();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==JMI_Insert){
			Registration r1=new Registration();
			r1.setVisible(true);
		}
		if(ae.getSource()==JMI_insert){
			new Company_Insert();
		}
		if(ae.getSource()==JMI_insert2){
			 new Dept_Insert();
		}
		if(ae.getSource()==JMI_insert3){
			new Dept_Holidays_Insert();
		}
		if(ae.getSource()==JMI_insert4){
			new Employ_insersion ();
		}
		if(ae.getSource()==JMI_insert5){
			new Visitor_Insert();
		}
		if(ae.getSource()==JBtn_insert){
			new Check_IN();
		}
		if(ae.getSource()==JBtn_insert2){
			new CheckOut_Insert();
		}
		
		if(ae.getSource()==JMI_insert6){
			
			 new Dept_Insert();
		}
		if(ae.getSource()==JMI_update_find4) {
			Employe_UpdateFind obj=new Employe_UpdateFind();
		}

		if(ae.getSource()==JMI_delete) {
			Company_Delete obj=new Company_Delete();
		}
		
		if(ae.getSource()==JMI_delete2) {
			Depart_delete obj=new Depart_delete();
		}
		if(ae.getSource()==JMI_delete4) {
			Employe_Delete obj=new Employe_Delete();
		}
		if(ae.getSource()==JMI_delete5) {
			Visitor_Delete obj=new Visitor_Delete();
		}
		if(ae.getSource()==JMI_delete6) {
			Hod_Delete obj=new Hod_Delete();
		}
		if(ae.getSource()==JBtn_delete2) {
			CheckOut_Delete obj=new CheckOut_Delete();
		}
		if(ae.getSource()==JBtn_delete) {
			CheckIn_Delete obj=new CheckIn_Delete();
		}
		if(ae.getSource()==JMI_update_find) {
			new CompanyInfo_UpdateFind();	
		}
		if(ae.getSource()==JMI_find_update2) {
			Dept_UpdateFind obj=new Dept_UpdateFind();
		}
		if(ae.getSource()==JMI_update_find4) {
			Employe_UpdateFind obj=new Employe_UpdateFind();
		}
		if(ae.getSource()==JMI_update_find5) {
			Visitor_UpdateFind obj=new Visitor_UpdateFind();
		}
		if(ae.getSource()==JMI_update_find6) {
			Hod_UpdateFInd obj=new Hod_UpdateFInd();
		}
		
		
		
		
	}

}