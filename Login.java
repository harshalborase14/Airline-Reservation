
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

	JTextField userT;
	JPasswordField passT;
	JButton submitB,closeB,resetB;
	
	public Login() {
		
		setLayout(null);
		
		JLabel userL = new JLabel("User Name");
		userL.setBounds(20,20,100,20);
		add(userL);
		
		userT = new JTextField();
		userT.setBounds(130,20,200,20);
		add(userT);
		
		JLabel passL = new JLabel("Password");
		passL.setBounds(20,60,100,20);
		add(passL);
		
		passT = new JPasswordField();
		passT.setBounds(130,60,200,20);
		add(passT);
		
		submitB = new JButton("Submit");
		submitB.setBounds(190,120,120,25);
		add(submitB);
		submitB.addActionListener(this);
		
		resetB = new JButton("Reset");
		resetB.setBounds(40,120,120,25);
		add(resetB);
		resetB.addActionListener(this);
		
		closeB = new JButton("Close");
		closeB.setBounds(115,160,120,25);
		add(closeB);
		closeB.addActionListener(this);
		
		setTitle("Airline Reservation System : Login");
		setBounds(485,200,400,250);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String username = userT.getText();
		String password = passT.getText();
		
		if(ae.getSource() == submitB)
		{
			if(username.equals("") || password.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Username or password id required");
			}
			try
			{
				Conn c = new Conn();
                String qry = "select * from login where username = '"+ username +"' and password = '"+ password +"';";
                ResultSet rs = c.s.executeQuery(qry);
                
                if(rs.next())
                {
                    setVisible(false);
                    new Dashboard();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				System.out.println(e);
			}
		}
		else if(ae.getSource() == resetB)
		{
			userT.setText("");
			passT.setText("");
		}
		else
		{
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}