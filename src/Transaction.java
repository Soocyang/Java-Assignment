
public class Transaction {
	private static int ID = 0; //Increment by one
    private String transactionCode; //Auto Generated from ID above
	private Services service;
	private double totalBill;
	
	public Transaction() {
	}
	
	public Transaction(Services service) {
	    this.transactionCode = String.format("T%04d",++ID);
		this.service=service;
	}
	
}
