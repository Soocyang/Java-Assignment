public class WaxPolish extends Services{
    private static String serviceDesc  = "Wax and Polish";
    private static double servicePrice = 0;

    public WaxPolish(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc, double servicePrice) {
        super(appointment, customers, plateNo, technician);
    }

    @Override
    public String toString() {
        return super.toString() +
                "serviceDesc='" + serviceDesc + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }
}
