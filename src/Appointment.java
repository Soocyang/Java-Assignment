public class Appointment {
    private Customers customer;
    private DateTime dateTime;
    private int preferService;

    public Appointment() {
    }

    public Appointment(Customers customer, DateTime dateTime, int preferService) {
        this.customer = customer;
        this.dateTime = dateTime;
        this.preferService = preferService;
    }
    
    public Customers getCustomer() {
    	return customer;
    }

    @Override
    public String toString() {
        return  customer +
                "Date & Time            = " + dateTime  + "\n" +
                "Preferred Service      = " + preferService + "\n";
    }
}