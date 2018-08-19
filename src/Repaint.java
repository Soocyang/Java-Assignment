public class Repaint extends Services{
    private String serviceDesc;
    private double servicePrice = 150.00;

    public Repaint(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc) {
        super(appointment, customers, plateNo, technician);
        this.serviceDesc = "Maintenance";
 
    }

    @Override
    public String toString() {
        return super.toString() +
                "serviceDesc='" + serviceDesc + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }
    
    public double calcPrice() {
		
    	return servicePrice;
	}
}

