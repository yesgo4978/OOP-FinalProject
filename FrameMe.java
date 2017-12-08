import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;


class Frame extends JFrame{ 
	Scanner scan;

// Menu Bar Below
	public void setupMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu savemnu = new JMenu("Save");
		JMenuItem fopen = new JMenuItem("Open");
		JMenuItem save1 = new JMenuItem("Save as Text"); 
		JMenuItem save2 = new JMenuItem("Save as JSON");
		JMenuItem save3 = new JMenuItem("Save as XML");	
		
		fopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the Open button!"); 
				//Optional addition, address this last if you have time, if not, comment out/remove
			}
		});
		
		save1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the save button!"); 
				//Text save
			}
		});
		
		save2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the save2 button!"); 
				//JSON Save
			}
		});		
		
		save3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the save3 button!"); 
				//XML Save
			}
		});
		
		JMenuItem fexit = new JMenuItem("Exit"); //the serialization
		fexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menu.add(file);
		file.add(fopen);
		file.add(savemnu);
		savemnu.add(save1);
		savemnu.add(save2);
		savemnu.add(save3);
		file.add(fexit);
		setJMenuBar(menu);
	}
	
// Creating/Setting up frame and components below 
	
	public void setupScreen() {
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Bill Plan Application");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		
		JPanel pannorth = new JPanel();
		pannorth.setLayout(new GridLayout(1,3));
		JPanel pnLeft = new JPanel();
		JPanel pnMid = new JPanel();		//unused, but keep for positioning
		JPanel pnRight = new JPanel();		//unused, but keep for positioning
		pannorth.add(pnLeft);
		pannorth.add(pnMid);	//unused, but keep for positioning
		pannorth.add(pnRight);	//unused, but keep for positioning
		
		
		JButton btnAdd = new JButton("+ Add Bill");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //modified
				String billName = JOptionPane.showInputDialog(null, "What is the name of this bill?");
				String bt = JOptionPane.showInputDialog(null, "What is the total cost?");
				double billTotal = Double.parseDouble(bt);
				Bill bill = new Bill(billName,billTotal);
			}//modified
		});
	
		
// Middle Panel Below 
		
		
		JPanel panmiddle = new JPanel();
		panmiddle.setLayout(new GridLayout(1,2));
		
		// Top Middle Panel 
		
		JPanel pmn = new JPanel();
		pmn.setLayout(new GridLayout(1,5));
		
		JPanel pmn1 = new JPanel();
		JPanel pmn2 = new JPanel();
		JPanel pmn3 = new JPanel();
		JPanel pmn4 = new JPanel();
		JPanel pmn5 = new JPanel();

		JLabel pmnleft1 = new JLabel("Name");
		JLabel pmnleft2 = new JLabel("Amount");
		JLabel pmnmid = new JLabel("Amount Paid");
		JLabel pmnright1 = new JLabel("Percent Paid");
		JLabel pmnright2 = new JLabel("Total Remaining");

		panmiddle.add(pmn1);
		panmiddle.add(pmn2);
		panmiddle.add(pmn3);
		panmiddle.add(pmn4);
		panmiddle.add(pmn5);
		
		
		pmn1.add(pmnleft1);
		pmn2.add(pmnleft2);
		pmn3.add(pmnmid);
		pmn4.add(pmnright1);
		pmn5.add(pmnright2);

		//Lower Middle Panel
		
		JPanel pms = new JPanel();
		pms.setLayout(new BorderLayout());
		
// South Panel Below
		
		JPanel pansouth = new JPanel();
		pansouth.setLayout(new GridLayout(1,3));
		JPanel psLeft = new JPanel();
		JPanel psMid = new JPanel();
		JPanel psRight = new JPanel();
		pansouth.add(psLeft);
		pansouth.add(psMid);
		pansouth.add(psRight);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paidTotal = JOptionPane.showInputDialog(null, "How much are you paying today?"); 
				// Action to pay bills is done in here
				
			}
		});
		
		
// Adding to c Container below 
		
		
		c.add(pannorth, BorderLayout.NORTH);
		c.add(panmiddle, BorderLayout.CENTER);
		c.add(pansouth, BorderLayout.SOUTH);
		
		panmiddle.add(pmn);
		panmiddle.add(pms);
		
		pnLeft.add(btnAdd);
		psMid.add(btnPay);
		setupMenu();

// Putting the Frame together below
		
	}
	public Frame() {
		setupScreen();
	}
}

// Setting frame visible below, main below

public class FrameMe {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(650,600);
		frame.setVisible(true);
	}
}