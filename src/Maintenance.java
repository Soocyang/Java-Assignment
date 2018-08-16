public class Maintenance extends Services {
    private String serviceDesc;
    private double servicePrice;

    public Maintenance(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc, double servicePrice) {
        super(appointment, customers, plateNo, technician);
        this.serviceDesc = "Maintenance";
        this.servicePrice = 0;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "serviceDesc  = " + serviceDesc + '\n' +
                "servicePrice = " + servicePrice + '\n';
    }
}

