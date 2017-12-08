import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*Yesenia worked on the Panel and Frame
 * Which includes all the panels, the text, the buttons
 * And using the ArrayList to fill the middle panel
 * She also created the beautiful artwork that brands Chas's awesome code-child.
 * Chastity worked on the Bill class 
 * Which includes the math portion of the code
 * As well as the btnPay and btnAdd action listeners
 */

//MakeBill creates one bill as it's called
class MakeBill {
	private double billTotal;
	private double amountPaid;
	private double percentPaid;
	private double payment;
	private double totalRemaining;
	private String billName;
	
	public double getBillTotal() {
		return billTotal;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public double getPercentPaid() {
		return percentPaid;
	}
	public double getPayment() {
		return payment;
	}
	public double getTotalRemaining() {
		return totalRemaining;
	}
	public String getBillName() {
		return billName;
	}
	public void setBillTotal(double billTotal) {
		this.billTotal = billTotal;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
		setPercentPaid();
		setTotalRemaining();
	}
	private void setPercentPaid() {
		percentPaid = (amountPaid/billTotal) *100;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	private void setTotalRemaining() {
		totalRemaining = billTotal - amountPaid;
		if(totalRemaining < 0) { 
			totalRemaining = 0;
		}
	}
	public void setBillName(String billName) {
		this.billName = billName;
	}
	@Override
	public String toString() {
		return String.format("  %s \t               %.2f \t\t %.2f \t          %.2f%% \t\t%.2f",billName,billTotal,amountPaid,percentPaid,totalRemaining);
	}
}


class BillPanel extends JPanel {	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}
class SavingBill {
	public boolean saveBillsText() {
		try {// as text
			
			return saveBillsText();
		}catch (Exception ex) {
			return false;
		}
	}
		public boolean saveBillsJSON() {
			try {
				
				return saveBillsJSON();
			}catch(Exception ex) {
				return false;
			}
		}
		public boolean saveBillsXML() {
			try{
				
				return saveBillsXML();
			}catch(Exception ex) {
				return false;
			}
		}
		public boolean loadBills(File f) {
			try{
				
				return true;
			}catch(Exception ex){
				return false;
			}
		}
}



class PMSPanel extends JPanel {
	private JTextArea funbox;
	private ArrayList<MakeBill> bills;
	public void setText(String t) {
		funbox.setText(t);
	}
	public void updateList() {
		String text = "";
		for (MakeBill mb : bills) {
			text = text + "\n" + mb.toString();
		}
		funbox.setText(text);
	}
	public PMSPanel(ArrayList<MakeBill> bills) {
		this.bills = bills;
		setLayout(new BorderLayout());
		funbox = new JTextArea();
		add(funbox);
		funbox.setEditable(false);
		funbox.setText("Hello");
		funbox.setBounds(35, 5,200,200);
		funbox.setSize(580,600);
		funbox.setText("Welcome to Bill Buddy! \n\nPlease click the 'add bill' button to begin your Bill Buddy Experience! \n\n Have a WONDERFUL day.");
	}
}



class Frame extends JFrame {
	private JTextArea funbox;
	public ArrayList<MakeBill> bills;
	private PMSPanel pms;
	MakeBill bill = new MakeBill();
	
	public void setupMenu()  throws IOException {
		setIconImage(new ImageIcon (getClass().getResource("BillDaddy.png")).getImage()); // changes the java picture :^)
		
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem savemnu = new JMenuItem("Save");
		
// saves file
		savemnu.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		/*JMenuItem fopen = new JMenuItem("Open");

		fopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You've pressed the Open button!"); 
				
				
				JFileChooser jfc = new JFileChooser();
				if(jfc.showOpenDialog(null) ==JFileChooser.APPROVE_OPTION){
					SavingBill sb = new SavingBill();
					
					
				}
			}
		});
		
		file.add(fopen);
		*/
// exits application
		JMenuItem fexit = new JMenuItem("Exit"); 
		fexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		file.add(savemnu);
		file.add(fexit);
		menu.add(file);
		setJMenuBar(menu);
	}
	public void setupScreen() throws IOException {
		bills = new ArrayList<MakeBill>();
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Bill Buddy");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

// NORTH PANEL
		
		JPanel pannorth = new JPanel();
		pannorth.setLayout(new GridLayout());
		
		// Panels within North Panel; two of them are meant to be placeholders.
		JPanel pnLeft = new JPanel();
		JPanel pnMid = new JPanel();
		JPanel pnRight = new JPanel();
		pannorth.add(pnLeft);
		pannorth.add(pnMid);
		pannorth.add(pnRight);
		
//btnAdd gives user option to add a bill. A new bill is created and then added to the arraylist. It is then updated to reflect the new addition.
		JButton btnAdd = new JButton("+ Add Bill");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String billName = JOptionPane.showInputDialog(null,"What is the name of this bill");
				String bt = JOptionPane.showInputDialog(null,"What is the total cost?");
				double billTotal = Double.parseDouble(bt);
				MakeBill newBill = new MakeBill();
				newBill.setBillName(billName);
				newBill.setBillTotal(billTotal);
				bills.add(newBill);
				pms.updateList();		
			}
		});
		
// MIDDLE PANEL; sets up middle panel
		
		JPanel panmiddle = new JPanel();
		panmiddle.setLayout(new BorderLayout());

// MIDDLE PANEL, NORTH; inserts a panel to the north of the middle panel
		pms = new PMSPanel(bills);
		JPanel pmn = new JPanel();
		pmn.setLayout(new GridLayout(1,5));
		
		// creates panels
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
		
		// adds labels to the panel that was added in the middle panel 
		pmn1.add(pmnleft1);
		pmn2.add(pmnleft2);
		pmn3.add(pmnmid);
		pmn4.add(pmnright1);
		pmn5.add(pmnright2);
		
		// adds panels to the north middle panel
		pmn.add(pmn1);
		pmn.add(pmn2);
		pmn.add(pmn3);
		pmn.add(pmn4);
		pmn.add(pmn5);
		

		
// MIDDLE PANEL, SOUTH
		
		pms.setLayout(new BorderLayout());
		panmiddle.add(pms, BorderLayout.SOUTH);
		
		
// SOUTH PANEL 
		
		JPanel pansouth = new JPanel();
		pansouth.setLayout(new GridLayout(1,3));
		
		//creates panels that will eventually be added to the south panel
		JPanel psLeft = new JPanel();
		JPanel psMid = new JPanel();
		JPanel psRight = new JPanel();
		
		// adds panels to south panel
		pansouth.add(psLeft);
		pansouth.add(psMid);
		pansouth.add(psRight);
		
		// creates the "Pay" button
		JButton btnPay = new JButton("Pay");
		// the action listener for the pay button is made below. It updates the total in the text area but telling the remainder of the bill left to pay
		// and the percentage paid. It subtracts the amount of the bill from the total
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paidTotal = JOptionPane.showInputDialog(null,"How much are you paying today?");
				double payment = Double.parseDouble(paidTotal);
				bill.setAmountPaid(payment);
				for(int i = 0; i<bills.size(); i++) {
					System.out.print(bills.get(i).getBillName()+ " ");
					System.out.println(bills.get(i).getBillTotal());
				}
				Bill.pay(bills,payment);
				for(int i = 0; i<bills.size(); i++) {
					System.out.println(bills.get(i).toString());
				}
				if (Bill.remainder > 0) {
					System.out.println(Bill.remainder);
				}
				pms.updateList();
			}
		});
		// adds the middle north and middle south panels to the middle panel
		panmiddle.add(pmn, BorderLayout.NORTH);
		panmiddle.add(pms, BorderLayout.CENTER);
		
		// adds the buttons to their respective panels
		pnLeft.add(btnAdd);
		psMid.add(btnPay);
		
		
		// adds panels to the container and to the region they will belong to 
		c.add(pannorth, BorderLayout.NORTH);
		c.add(panmiddle, BorderLayout.CENTER);
		c.add(pansouth, BorderLayout.SOUTH);
		
		setupMenu();
	}
	// sets up the screen
	public Frame() throws IOException {
		setupScreen();
	}
}
// the main; sets the frame visible and the frame size 
public class FrameMe {
	public static void main(String[] args) throws IOException {
		Frame frame = new Frame();
		frame.setSize(650,600);
		frame.setVisible(true);
		
	}
	
}