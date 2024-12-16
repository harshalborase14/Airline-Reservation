import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

	JMenuItem flightdetails,addcustomer,bookflight,journydetails,cancel,logout,boardingpass;
	JMenu detail,ticket;
	
	public Dashboard() {
		
		ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(0,0,1860,700);
		add(img);
		
		JLabel head = new JLabel("Welcome to Airline Reservation System");
        head.setBounds(190,70,1000,110);
        head.setFont(new Font("serif", Font.PLAIN,60));
        head.setForeground(Color.BLACK);
        img.add(head);
		
		JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0, 1920, 30);
        img.add(mb);
        
        detail = new JMenu("Details");
        mb.add(detail);
        ticket = new JMenu("Ticket");
        mb.add(ticket);
        
        flightdetails = new JMenuItem("Flight Details");
        addcustomer = new JMenuItem("Add Customer");
        bookflight = new JMenuItem("Book Flight");
        journydetails = new JMenuItem("Journy Details");
        cancel = new JMenuItem("Cancelation");
        logout = new JMenuItem("Logout");
        detail.add(flightdetails);
        detail.add(addcustomer);
        detail.add(bookflight);
        detail.add(journydetails);
        detail.add(cancel);
        detail.add(logout);
        
        boardingpass = new JMenuItem("Boarding Pass");
        ticket.add(boardingpass);
        
        flightdetails.addActionListener(this);
        addcustomer.addActionListener(this);
        bookflight.addActionListener(this);
        journydetails.addActionListener(this);
        cancel.addActionListener(this);
        boardingpass.addActionListener(this);
        logout.addActionListener(this);
        
		setTitle("Airline Reservation System : Dashboard");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == flightdetails)
		{
			new FlightInfo();
		}
		else if(ae.getSource() == addcustomer)
		{
			new AddCustomer();
		}
		else if(ae.getSource() == bookflight)
		{
			new BookFlight();
		}
		else if(ae.getSource() == journydetails)
		{
			new JournyDetails();
		}
		else if(ae.getSource() == cancel)
		{
			new Cancelation();
		}
		else if(ae.getSource() == boardingpass)
		{
			new BoardingPass();
		}
		else {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		new Dashboard();
	}
}