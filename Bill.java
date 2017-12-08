import java.util.ArrayList;

public class Bill {
	public static double remainder;
	public static void pay(ArrayList<MakeBill> bills,double payment) {
		double finalTotal = 0;
		double percent = 0;
		remainder = payment;
		for(int i = 0; i<bills.size(); i++) {
			finalTotal +=bills.get(i).getBillTotal();
		}
		for(int i=0; i<bills.size(); i++) {
			percent = bills.get(i).getBillTotal() / finalTotal;
			bills.get(i).setAmountPaid(percent*payment);
			
			if(bills.get(i).getBillTotal() < bills.get(i).getAmountPaid()) {
				bills.get(i).setAmountPaid(bills.get(i).getBillTotal());
		}
		remainder -= bills.get(i).getAmountPaid();
		}
	}
}
