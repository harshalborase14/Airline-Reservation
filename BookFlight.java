import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import com.toedter.calendar.JDateChooser;
import java.util.Random;
public class BookFlight extends JFrame implements ActionListener {

	Random random = new Random();
	JTextField idT;
	JButton submitB,fetchB,flightB;
	JLabel nameinput,nationalityinput,addressinput,genderinput,fnameinput,fcodeinput;
	Choice sourceC,destC;
	JDateChooser dateC;
	
	public BookFlight() 
	{
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
		Image i2 = i1.getImage().getScaledInstance(420,320,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(550,80,450,420);
		add(img);
		
		JLabel heading  = new JLabel("Book Flight");
		heading.setBounds(220, 20, 500, 40);
		heading.setFont(new Font("Tahoma",Font.PLAIN,34));
		add(heading);
		
		JLabel idL = new JLabel("Adhar No.");
		idL.setBounds(60, 80, 150, 25);
		idL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(idL);
		
		idT = new JTextField();
		idT.setBounds(220,80,150,25);
		add(idT);
		
		fetchB = new JButton("Fetch");
		fetchB.setBackground(Color.BLACK);
		fetchB.setForeground(Color.WHITE);
		fetchB.setBounds(380,80,120,25);
		fetchB.addActionListener(this);
		add(fetchB);
		
		JLabel nameL = new JLabel("Name");
		nameL.setBounds(60, 130, 150, 25);
		nameL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nameL);
		
		nameinput = new JLabel();
		nameinput.setBounds(220,130,150,25);
		add(nameinput);
		
		JLabel addressL = new JLabel("Address");
		addressL.setBounds(60, 180, 150, 25);
		addressL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(addressL);
		
		addressinput = new JLabel();
		addressinput.setBounds(220,180,150,25);
		add(addressinput);
		
		JLabel genderL = new JLabel("Gender");
		genderL.setBounds(60,230,150,25);
		genderL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(genderL);
		
		genderinput = new JLabel();
		genderinput.setBounds(220,230,150,25);
		add(genderinput);
		
		JLabel sourceL = new JLabel("Source");
		sourceL.setBounds(60,280,150,25);
		sourceL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(sourceL);
		
		sourceC = new Choice();
		sourceC.setBounds(220,280,150,25);
		add(sourceC);
		sourceC.add("Delhi");
		
		JLabel destL = new JLabel("Destination");
		destL.setBounds(60,330,150,25);
		destL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(destL);
		
		destC = new Choice();
		destC.setBounds(220,330,150,25);
		add(destC);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from flight;");
			
			while(rs.next())
			{
				
				destC.add(rs.getString("destination"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		flightB = new JButton("Fetch Flight");
		flightB.setBounds(380,330,120,25);
		flightB.setBackground(Color.BLACK);
		flightB.setForeground(Color.WHITE);
		flightB.addActionListener(this);
		add(flightB);
		
		JLabel fnameL = new JLabel("Flight Name");
		fnameL.setBounds(60,380,150,25);
		fnameL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(fnameL);
		
		fnameinput = new JLabel();
		fnameinput.setBounds(220,380,150,25);
		add(fnameinput);
		
		JLabel fcodeL = new JLabel("Flight Code");
		fcodeL.setBounds(60,430,150,25);
		fcodeL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(fcodeL);
		
		fcodeinput = new JLabel();
		fcodeinput.setBounds(220,430,150,25);
		add(fcodeinput);
		
		JLabel dateL = new JLabel("Date of Travel");
		dateL.setBounds(60,480,150,25);
		dateL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(dateL);
		
		dateC = new JDateChooser();
		dateC.setBounds(220,480,150,25);
		add(dateC);
		
		submitB = new JButton("Book Flight");
		submitB.setBounds(220,530,150,25);
		submitB.setBackground(Color.BLACK);
		submitB.setForeground(Color.WHITE);
		submitB.addActionListener(this);
		add(submitB);
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setBounds(130,50,1100,630);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		Conn c = new Conn();
		
		if(ae.getSource()==fetchB)
		{
			String id = idT.getText();
			
			try
			{
				ResultSet rs = c.s.executeQuery("Select * from customer where adhar_no = '"+id+"';");
				
				if(rs.next())
				{
					nameinput.setText(rs.getString("name"));
					addressinput.setText(rs.getString("address"));
					genderinput.setText(rs.getString("gender"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Can not find user");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==flightB) {
			String source = sourceC.getSelectedItem();
			String destination = destC.getSelectedItem();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from flight where source = '"+source+"' and destination='"+destination+"';");
				if(rs.next()) {
					fnameinput.setText(rs.getString("f_name"));
					fcodeinput.setText(rs.getString("f_code"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Can not find Flight");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			String id = idT.getText();
			String name = nameinput.getText();
			String address = addressinput.getText();
			String gender = genderinput.getText();
			String source = sourceC.getSelectedItem();
			String destionation = destC.getSelectedItem();
			String fname = fnameinput.getText();
			String fcode = fcodeinput.getText();
			String date = ((JTextField)dateC.getDateEditor().getUiComponent()).getText();
			String pnrno = ""+random.nextInt(1000000);
			
			try {
				String qry = "insert into flight_booking values('PNR-"+pnrno+"','TIC-"+random.nextInt(100000)+"','"+id+"','"+name+"','"+address+"','"+gender+"','"+source+"','"+destionation+"','"+fcode+"','"+fname+"','"+date+"');";
				c.s.executeUpdate(qry);
				JOptionPane.showMessageDialog(null, "Flight Booked Successfully\nYour PNR Number : PNR-"+pnrno);
				setVisible(false);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		
		new BookFlight();

	}
}