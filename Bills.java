/* Chastity Logue 6/15/2017
 * ask user for bill name and amount
 * add bills and find percentage of each from total
 * input income or payment amount
 * use percentage and take from payment
 */

import java.util.*;
import java.io.*;
import java.text.*;

public class Bills {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DecimalFormat var = new DecimalFormat("0.##");
		
		System.out.print("How many bills will we work with? " );
		int num = scan.nextInt();
		Integer[] bill = new Integer[num];
		String[] name = new String[num];
		
		System.out.println(" ");
		
		int i =0;
		while (i <num){
			System.out.print("What is this bill called? ");
			name[i] = scan.next();
			
			System.out.print("What is the cost of " + name[i] + "? ");
			bill[i] = scan.nextInt();
			System.out.println(" ");
			i++;
		}
		System.out.print("What will you pay towards the bills?");
		double pay = scan.nextDouble();
		
		System.out.println(" ");
		double ofPay = 0;
		double total = 0;
		for (i=0; i <bill.length; i++) {
			total += bill[i];
		}
		i=0;
		/*modified
		double lowest=0;
		String lowbillName = "";
		for (int j = 0; j<bill.length; j++) {
			if(bill[j] < bill[j+1]) {
				lowest = bill[j];
				lowbillName = name[j];
			}
		}
		System.out.println(lowest);
		System.out.println(lowbillName);
		if (lowest <75) {
			System.out.println("Would you like to pay off %s " + lowbillName);
			String ans = scan.nextLine();
			ans.toLowerCase();
			if(ans == "y") {
				pay -= lowest;
				
			}
		} //ERROR: ArrayIndexOutOfBoundsException
		modified*/
		System.out.println("From your payment: ");
		while(i<num) {
			double percentage = bill[i] / total;
			ofPay = percentage * pay;
			
			System.out.println("$" + var.format(ofPay) + " goes toward " + name[i]);
			System.out.println(var.format(percentage) + " percent goes towards this bill");
			i++;
		 }
		 //(var.format(othervariable))

	}
}
