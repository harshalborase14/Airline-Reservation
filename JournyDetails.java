
import java.awt.*;
import net.proteanit.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class JournyDetails extends JFrame implements ActionListener {
	
	JTable table;
	JTextField pnrT,adharT;
	JButton showB,show;
	
	public JournyDetails() {
		
		JLabel pnr = new JLabel("PNR Details");
		pnr.setFont(new Font("Tahoma",Font.PLAIN,16));
		pnr.setBounds(50,50,100,25);
		add(pnr);
		
		pnrT = new JTextField();
		pnrT.setBounds(160,50,120,25);
		add(pnrT);
		
		showB = new JButton("Show");
		showB.setBackground(Color.BLACK);
		showB.setForeground(Color.WHITE);
		showB.setBounds(290,50,120,25);
		showB.addActionListener(this);
		add(showB);
		
		JLabel or = new JLabel("OR");
		or.setFont(new Font("Tahoma",Font.BOLD,12));
		or.setBounds(470,50,100,25);
		add(or);
		
		JLabel adharL = new JLabel("Adhar No.");
		adharL.setFont(new Font("Tahoma",Font.PLAIN,16));
		adharL.setBounds(530,50,100,25);
		add(adharL);
		
		adharT = new JTextField();
		adharT.setBounds(640,50,120,25);
		add(adharT);
		
		show = new JButton("Show");
		show.setBackground(Color.BLACK);
		show.setForeground(Color.WHITE);
		show.setBounds(770,50,120,25);
		show.addActionListener(this);
		add(show);
		
		table = new JTable();
		table.setBounds(0,100,1000,500);
		add(table);
		
		JScrollPane sb = new JScrollPane(table);
		sb.setBounds(0,100,1000,500);
		add(sb);
		
		setLayout(null);
		setBounds(170,100,1000,500);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==showB)
		{
			try
			{
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from flight_booking where PNR = '"+pnrT.getText()+"';");
				
				if(!rs.isBeforeFirst()) {
					JOptionPane.showMessageDialog(null, "Information not found");
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			try
			{
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from flight_booking where adhar_no = '"+adharT.getText()+"';");
				
				if(!rs.isBeforeFirst()) {
					JOptionPane.showMessageDialog(null, "Information not found");
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
	}

	public static void main(String[] args) {
		
		new JournyDetails();

	}

}
