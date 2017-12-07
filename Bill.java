public class Bill {
	private String billName;
	private int billTotal;
	private int amountPaid;
	private int percentPaid;
	private int totalRemaining;
	public Bill(String billName, int billTotal) {
		this.billName = billName;
		setBillTotal(billTotal);
		setAmountPaid(0);
		setTotalRemaining();
		setPercentPaid();
	}
	public void setBillName(String billName) {
		this.billName = billName;
	}
	public String getBillName() {
		return billName;
	}
	public void setBillTotal(int billTotal) {
		if (billTotal < 0) {
			billTotal = 0;
		}
		this.billTotal = billTotal;
	}
	public int getBillTotal() {
		return billTotal;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
		setTotalRemaining();
		setPercentPaid();
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	private void setPercentPaid() {
		percentPaid = (totalRemaining / billTotal) * 100;
	}
	public int getPercentPaid() {
		return percentPaid;
	}
	private void setTotalRemaining() {
		totalRemaining = billTotal - amountPaid;
	}
}