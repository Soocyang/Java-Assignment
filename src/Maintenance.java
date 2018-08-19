public class Maintenance extends Services {
    private String serviceDesc;
    private double servicePrice = 90.00;

    public Maintenance(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc) {
        super(appointment, customers, plateNo, technician);
        this.serviceDesc = "Maintenance";
    }
    
    @Override
    public String toString() {
        return super.toString() + '\n' +
                "serviceDesc  = " + serviceDesc + '\n' +
                "servicePrice = " + servicePrice + '\n';
    }
    
    public double calcPrice() {	// same as getServicePrice
		
    	return servicePrice;
	}
}

