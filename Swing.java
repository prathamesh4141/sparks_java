import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;  
public class Swing extends JFrame implements ActionListener
{
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JPasswordField p1 = new JPasswordField();
	Button b=new Button("Submit"); 
	public Swing()
	{
		setTitle("Registration Window");
		setSize(500,500);
		Color color1 = new Color(82,255,255);
		getContentPane().setBackground(color1);
		setLayout(null);  
		
		 //Color color2 = new Color(232,232,232);
		 JLabel l = new JLabel("Registration Form");
		 Font font1 = new Font("Time New Roman",Font.BOLD,25);
		 l.setBounds(60,32,250,40); 
		 l.setFont(font1);
		 add(l);
		
		Font font2 = new Font("Time New Roman",Font.BOLD,18);
	    JLabel l1 = new JLabel("Name :-");
	    l1.setBounds(60,62,130,40); 
	    l1.setFont(font2);
	    add(l1);
	    t1.setBounds(180,70,200,25); 
	    add(t1);
	    
	    JLabel l2 = new JLabel("Email ID :-");
	    l2.setBounds(60,90,130,40); 
	    l2.setFont(font2);
	    add(l2);
	    t2.setBounds(180,100,200,25); 
	    add(t2);
	    
	    JLabel l3 = new JLabel("Mobile No :-");
	    l3.setBounds(60,120,130,40); 
	    l3.setFont(font2);
	    add(l3);
	    t3.setBounds(180,130,200,25); 
	    add(t3);
	    
	    JLabel l4 = new JLabel("Username :-");
	    l4.setBounds(60,150,130,40); 
	    l4.setFont(font2);
	    add(l4);
	    t4.setBounds(180,160,200,25); 
	    add(t4);
	    
	    JLabel l5 = new JLabel("Password :-");
	    l5.setBounds(60,180,130,40);
	    l5.setFont(font2);
	    add(l5);
	    p1.setBounds(180,190,200,25); 
	    add(p1);
	     
	    b.setBounds(135,250,210,40); 
	    b.setBackground(Color.BLACK);
	    b.setForeground(Color.WHITE);
	    Font font = new Font("Time New Roman",Font.BOLD,20);
	    b.setFont(font);
	    add(b);
	    b.addActionListener((ActionListener) this); 
	    
	    setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/db1","root","");
			if(e.getSource()==b)
			{
				String name = t1.getText();
				String emailid = t2.getText();
				String mobileno = t3.getText();
				String username = t4.getText();
				String password = p1.getText();
				PreparedStatement stmt=con.prepareStatement("insert into reg values(?,?,?,?,?)");
				stmt.setString(1,name);
				stmt.setString(2, emailid);
				stmt.setString(3, mobileno);
				stmt.setString(4, username);
				stmt.setString(5, password);
				stmt.executeUpdate();  
			}
			else
			{
				System.out.println("Please Check Your Connection");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) 
	{
		new Swing();
	}
}
