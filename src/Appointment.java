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

    @Override
    public String toString() {
        return  customer + "\n" +
                "Date & Time = " + dateTime + "\n" +
                "preferred Service = " + preferService + "\n";
    }
}