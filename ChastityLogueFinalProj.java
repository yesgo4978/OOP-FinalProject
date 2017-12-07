/* Yesenia - (what you did) visual design
* Chastity - (what you did) original design
* Gabe - (what you did)  
* Jeff - (what you did)
* lots of brainstorming
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

/*This should be the view, the showing and user interaction
* It includes the Frame which holds the menu and the frame
* Which in turn hold the menu options save, open, load...
* The frame sets up the screen, the main method actually creates it
*/

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
 *    send cost/pay/billArray (set) to model
 * set (grab from the get)
 *    send cost/pay/billArray to get/
 *constructor
 *toString (set "From your payment $var.format(pay) goes toward (stringName)")
 *use var.format(pay) to get 0.00
 */

/*The Model (all da math!)
* public class Model {
*   //fuck these tabs
*   grab the array with the get method
*   grab the double pay
*   add the bills together 
*   double total = 0;
*   double min = 100 //some max number
*   for (int i = 0; i<bill.length; i++) {
*      total += bill[i]; //also find the lowest bill
*      if(bill[i] < min) {
*         min = bill[i];
*      }//if{end
*   }//for{end
*   if(payLowest.isChecked) {//right notation?
*      pay -= min;
*   }//if{end
*   double toPay;
*   double percentage;
*   for(int i =0; i<bill.length[i]; i++ { //screw all these for loops D:
*      percentage = bill[i]/total;
*      ofPay = percentage *pay;
*   }//endForLoop
*   //give controller percentage for view
*   //give controller ofPay
*   //clicked pay
*   
*}//class }end
* I tried to use:
* while(i<num) { //num being the number of bills
*   bill[i] = bill[i] - ofPay //but it didn't repopulate
* }
* and then:
* while(i<num) {
*   System.out.print("New Amount of " +name[i]);
*   System.out.println(" is %.2d) + bill[i]); 
* } //but this didn't work, not sure why
 */ 
