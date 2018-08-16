public class Repaint extends Services{
    private String serviceDesc;
    private double servicePrice;

    public Repaint(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc, double servicePrice) {
        super(appointment, customers, plateNo, technician);
        this.serviceDesc = "Maintenance";
        this.servicePrice = 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "serviceDesc='" + serviceDesc + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }
}

