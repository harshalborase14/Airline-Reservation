import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

import java.sql.*;

public class FlightInfo extends JFrame {
	
	public FlightInfo() {
				
		JTable flight = new JTable();
		flight.setBounds(0,0,800,500);
		add(flight);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from flight;");
			flight.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JScrollPane sb = new JScrollPane(flight);
		sb.setBounds(0,0,800,500);
		add(sb);
		
		setLayout(null);
		setBounds(270,100,800,500);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new FlightInfo();

	}

}
