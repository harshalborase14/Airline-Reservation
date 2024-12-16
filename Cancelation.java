import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;

public class Cancelation extends JFrame implements ActionListener {

	JButton showB,cancelB,backB;
	JTextField pnrT;
	JLabel nameinput,fcodeinput,dateinput,cancelcode;
	
	public Cancelation() {
		
		Random random = new Random();
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
		Image i2 = i1.getImage().getScaledInstance(420,320,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(550,50,450,420);
		add(img);
		
		JLabel heading  = new JLabel("CANCELATON");
		heading.setBounds(450, 20, 500, 40);
		heading.setFont(new Font("Tahoma",Font.PLAIN,34));
		add(heading);
		
		JLabel pnrnoL =  new JLabel("PNR Number");
		pnrnoL.setBounds(60,80,150,25);
		pnrnoL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(pnrnoL);
		
		pnrT = new JTextField();
		pnrT.setBounds(250,80,150,25);
		add(pnrT);
		
		showB = new JButton("Fetch");
		showB.setBounds(410,80,100,25);
		showB.setBackground(Color.BLACK);
		showB.setForeground(Color.WHITE);
		add(showB);
		showB.addActionListener(this);
		
		JLabel nameL =  new JLabel("Name");
		nameL.setBounds(60,130,150,25);
		nameL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nameL);
		
		nameinput = new JLabel();
		nameinput.setBounds(250,130,150,25);
		add(nameinput);
		
		JLabel cancelL =  new JLabel("Cancelation Number");
		cancelL.setBounds(60,180,150,25);
		cancelL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(cancelL);
		
		cancelcode = new JLabel(""+random.nextInt(1000000));
		cancelcode.setBounds(250,180,150,25);
		add(cancelcode);
		
		JLabel fcodeL =  new JLabel("Flight Code");
		fcodeL.setBounds(60,230,150,25);
		fcodeL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(fcodeL);
		
		fcodeinput = new JLabel();
		fcodeinput.setBounds(250,230,150,25);
		add(fcodeinput);
		
		JLabel dateL = new JLabel("Date");
		dateL.setBounds(60,280,150,25);
		dateL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(dateL);
		
		dateinput = new JLabel();
		dateinput.setBounds(250,280,150,25);
		add(dateinput);
		
		backB = new JButton("BACK");
		backB.setBounds(60,330,150,25);
		backB.setBackground(Color.BLACK);
		backB.setForeground(Color.WHITE);
		add(backB);
		backB.addActionListener(this);
		
		cancelB = new JButton("Cancel Ticket");
		cancelB.setBounds(250,330,150,25);
		cancelB.setBackground(Color.BLACK);
		cancelB.setForeground(Color.white);
		add(cancelB);
		cancelB.addActionListener(this);
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setBounds(130,70,1100,500);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==showB){
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("Select * from flight_booking where PNR ='"+pnrT.getText()+"';");
				if(rs.next()) {
					nameinput.setText(rs.getString("name"));
					fcodeinput.setText(rs.getString("flight_no"));
					dateinput.setText(rs.getString("date"));
				}
				else {
					JOptionPane.showMessageDialog(null, "User Not Found");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource() == cancelB){
			try {
				Conn c = new Conn();
				String qry1 = "insert into cancel values('"+pnrT.getText()+"','"+nameinput.getText()+"','"+cancelcode.getText()+"','"+fcodeinput.getText()+"','"+dateinput.getText()+"');";
				String qry2 = "delete from flight_booking where PNR = '"+pnrT.getText()+"';";
				c.s.executeUpdate(qry1);
				c.s.executeUpdate(qry2);
				JOptionPane.showMessageDialog(null, "Cancellation Done Successfully");
				setVisible(false);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Cancelation();
	}
}
