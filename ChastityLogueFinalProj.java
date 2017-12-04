/* Chastity Logue
 * This should only be the view, the showing and user interaction
 * It includes the Frame which holds the menu and the frame
 * Which in turn hold the menu options save, or serialization
 * And hopefully the percentage options
 * The frame sets up the screen, the main method actually creates it
 * The original Bills file is in DadsProgram file
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Frame extends JFrame{ //the view
	Scanner scan;
	public void setupMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		
		JMenuItem save1 = new JMenuItem("Save 1"); //these are for
		save1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//can I use JOptionPane.showMessageDialog for input from user?
				JOptionPane.showMessageDialog(null, "You've pressed the save button!"); 
				//serialization 1
			}
		});
		file.add(save1);
		JMenuItem save2 = new JMenuItem("Save 2"); //the serialization
		save2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the other save button!");
				//serialization 2
				//showInputDialog
			}
		});
		file.add(save2);
		
		
		menu.add(file);
		setJMenuBar(menu);
	}
	public void setupScreen() {
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Bill Plan Application");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel south = new JPanel(); //this is where I want to put the final payments
		
		setupMenu();
	}
	public Frame() {//this is a default constructor
		setupScreen();
	}
}

public class ChastityLogueFinalProj {//only to show the screen
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}

}

/*The Controller (or the mediator)
 * get (grab from the model and send to the view)
 *    send cost/pay (set) to model
 * set (grab from the get)
 *    send cost/pay to get
 *constructor
 *toString (set "From your payment $var.format(pay) goes toward (stringName)")
 *use var.format(pay) to get 0.00
 */

/*The Model (all da math!)
 * use the get method
 * get the bill array and the double pay
 * make a constant MAX
 * add all the bills together
 * for (int i = 0; i<bill.length; i++) {
 *    total += bill[i]; //also find the lowest bill
 *    if (bill[i] <50&&pay > 500
 *}
 *for (int j = 0; i<bill.length; i++){
 *    if this bill is less than 50 and pay is greater than MAX and (total - this) bill is 
 *    greater than MAX
 *percentage chosen for certain bills
 *some for loop to go through bills after a button (10% 20%...) is pressed to keep everything
 *at 100%
 *percentage * pay
 */ 