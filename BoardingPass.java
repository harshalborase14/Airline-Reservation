import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BoardingPass extends JFrame implements ActionListener {

	JTextField pnrT;
	JLabel nameinput,srcinput,destinput,fnameinput,fcodeinput,dateinput;
	JButton enter;
	
	public BoardingPass() {
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/airindia.png"));
		Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(550,0,450,420);
		add(img);
		
		JLabel heading  = new JLabel("INDIAN AIRLINE");
		heading.setBounds(350, 10, 500, 40);
		heading.setFont(new Font("Tahoma",Font.PLAIN,34));
		add(heading);
		
		JLabel heading2 = new JLabel("Boarding Pass");
		heading2.setBounds(390,60,300,30);
		heading2.setFont(new Font("Tahoma",Font.BOLD,23));
		heading2.setForeground(Color.BLUE);
		add(heading2);
		
		JLabel pnrL = new JLabel("PNR NUMBER");
		pnrL.setBounds(50,100,150,25);
		pnrL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(pnrL);
		
		pnrT = new JTextField();
		pnrT.setBounds(200,100,150,25);
		add(pnrT);
		
		enter = new JButton("Enter");
		enter.setBounds(365,100,150,25);
		enter.setBackground(Color.BLACK);
		enter.setForeground(Color.WHITE);
		enter.addActionListener(this);
		add(enter);
		
		JLabel nameL = new JLabel("NAME");
		nameL.setBounds(50,150,150,25);
		nameL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nameL);
		
		nameinput = new JLabel();
		nameinput.setBounds(200,150,100,25);
		add(nameinput);
		
		JLabel srcL = new JLabel("SRC");
		srcL.setBounds(50,200,150,25);
		srcL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(srcL);
		
		srcinput = new JLabel();
		srcinput.setBounds(200,200,100,25);
		add(srcinput);
		
		
		JLabel fnameL = new JLabel("FLIGHT NAME");
		fnameL.setBounds(50,250,150,25);
		fnameL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(fnameL);
		
		fnameinput = new JLabel();
		fnameinput.setBounds(200,250,100,25);
		add(fnameinput);
		
		JLabel dateL = new JLabel("DATE");
		dateL.setBounds(50,300,150,25);
		dateL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(dateL);
		
		dateinput = new JLabel();
		dateinput.setBounds(200,300,100,25);
		add(dateinput);
		
		JLabel destL = new JLabel("DST");
		destL.setBounds(335,200,150,25);
		destL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(destL);
		
		destinput = new JLabel();
		destinput.setBounds(510,200,100,25);
		add(destinput);
		
		JLabel fcodeL = new JLabel("FLIGHT CODE");
		fcodeL.setBounds(335,250,150,25);
		fcodeL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(fcodeL);
		
		fcodeinput = new JLabel();
		fcodeinput.setBounds(510,250,100,25);
		add(fcodeinput);
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(175,150,1000,450);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String qry = "select * from flight_booking where PNR = '"+pnrT.getText()+"';";
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(qry);
			if(rs.next()) {
				nameinput.setText(rs.getString("name"));
				srcinput.setText(rs.getString("source"));
				destinput.setText(rs.getString("destination"));
				fnameinput.setText(rs.getString("flight_name"));
				fcodeinput.setText(rs.getString("flight_no"));
				dateinput.setText(rs.getString("date"));
			}
			else {
				JOptionPane.showMessageDialog(null, "User Not Found");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		new BoardingPass();
	}

}
