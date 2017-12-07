import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		
		
		JButton btnAdd = new JButton("+ Add...");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the Add Bill button!"); 
				//addBill(); function to add bills to panmiddle
			}
		});
// Middle Panel Below 
		
		JPanel panmiddle = new JPanel();
		panmiddle.setLayout(new GridLayout(15,5));
		
		JPanel pmLeft1 = new JPanel();
		JPanel pmLeft2 = new JPanel();
		JPanel pmMid = new JPanel();
		JPanel pmRight1 = new JPanel();
		JPanel pmRight2 = new JPanel();

		JLabel pmleft1 = new JLabel("Name");
		JLabel pmleft2 = new JLabel("Amount");
		JLabel pmmid = new JLabel("Amount Paid");
		JLabel pmright1 = new JLabel("Percent Paid");
		JLabel pmright2 = new JLabel("Total Remaining");
		

		panmiddle.add(pmLeft1);
		panmiddle.add(pmLeft2);
		panmiddle.add(pmMid);
		panmiddle.add(pmRight1);
		panmiddle.add(pmRight2);
		
		pmLeft1.add(pmleft1);
		pmLeft2.add(pmleft2);
		pmMid.add(pmmid);
		pmRight1.add(pmright1);
		pmRight2.add(pmright2);
		
		
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
				JOptionPane.showMessageDialog(null, "You've pressed the Pay button!"); 
				// Action to pay bills is done in here
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the Save... button!"); 
				// Action to pay bills is done in here
			}
		});
// Adding to c Container below 
		
		c.add(pannorth, BorderLayout.NORTH);
		c.add(panmiddle, BorderLayout.CENTER);
		c.add(pansouth, BorderLayout.SOUTH);
		pnLeft.add(btnAdd);
		psMid.add(btnPay);
		psRight.add(btnSave);
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
		frame.setVisible(true);
	}

}
