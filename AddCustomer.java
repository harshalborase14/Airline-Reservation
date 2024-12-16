import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

	JTextField nameT,nationT,idT,addressT,phoneT;
	JRadioButton male,female;
	JButton submitB;
	
	public AddCustomer() 
	{
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
		JLabel img = new JLabel(i1);
		img.setBounds(450,80,280,400);
		add(img);
		
		JLabel heading  = new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(220, 20, 500, 35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,34));
		add(heading);
		
		JLabel nameL = new JLabel("Name");
		nameL.setBounds(60, 80, 150, 25);
		nameL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nameL);
		
		nameT = new JTextField();
		nameT.setBounds(220,80,150,25);
		add(nameT);
		
		JLabel nationL = new JLabel("Nationality");
		nationL.setBounds(60, 130, 150, 25);
		nationL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nationL);
		
		nationT = new JTextField();
		nationT.setBounds(220,130,150,25);
		add(nationT);
		
		JLabel idL = new JLabel("Adhar No.");
		idL.setBounds(60, 180, 150, 25);
		idL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(idL);
		
		idT = new JTextField();
		idT.setBounds(220,180,150,25);
		add(idT);
		
		JLabel genderL = new JLabel("Gender");
		genderL.setBounds(60,230,150,20);
		genderL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(genderL);
		
		male = new JRadioButton("Male");
		male.setBounds(220,230,80,20);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(305,230,80,20);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup grp = new ButtonGroup();
		grp.add(male);
		grp.add(female);
		
		JLabel addressL = new JLabel("Address");
		addressL.setBounds(60, 280, 150, 25);
		addressL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(addressL);
		
		addressT = new JTextField();
		addressT.setBounds(220, 280, 150, 25);
		add(addressT);
		
		JLabel PhoneL = new JLabel("Phone No.");
		PhoneL.setBounds(60, 330, 150, 25);
		PhoneL.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(PhoneL);
		
		phoneT = new JTextField();
		phoneT.setBounds(220, 330, 150, 25);
		add(phoneT);
		
		submitB = new JButton("Submit");
		submitB.setBounds(180,385,100,30);
		submitB.setBackground(Color.BLACK);
		submitB.setForeground(Color.WHITE);
		submitB.addActionListener(this);
		add(submitB);
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setBounds(225,100,900,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name = nameT.getText();
		String nationality = nationT.getText();
		String id = idT.getText();
		String address = addressT.getText();
		String phone = phoneT.getText();
		
		String gender = null;
		if(male.isSelected())
			gender = "Male";
		else if(female.isSelected())
			gender = "Female";
		else
		{
			JOptionPane.showMessageDialog(null, "Please Select Your Gender");
		}
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name is Required");
		}
		else if(nationality.equals("")) {
			JOptionPane.showMessageDialog(null, "Nationality is required");
		}
		else if(id.equals("")) {
			JOptionPane.showMessageDialog(null, "ID is required");
		}
		else if(address.equals("")) {
			JOptionPane.showMessageDialog(null, "Address is required");
		}
		else if(phone.equals("")) {
			JOptionPane.showMessageDialog(null,"Phone Number is required");
		}
		else
		{
			try
            {
                Conn c = new Conn();

                String qry = "insert into customer values('"+name+"','"+nationality+"','"+id+"','"+gender+"','"+address+"','"+phone+"');";
                c.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Record added successfully");
                setVisible(false);
            }   
            catch(Exception e)
            {
                System.out.println(e);
            }
		}
	}

	public static void main(String[] args) {
		
		new AddCustomer();

	}
}