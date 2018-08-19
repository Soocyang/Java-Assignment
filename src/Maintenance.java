public class Maintenance extends Services {
    private static int ID = 0; //Increment by one
    private double servicePrice = 90.00;

    public Maintenance(Appointment appointment, Customers customers, String plateNo, Technician technician) {
        super(String.format("S0%03d",++ID),"Maintenance",appointment, customers, plateNo, technician);
    }   //Constructor without desc

    public Maintenance(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc) {
        super(String.format("S0%03d",++ID),serviceDesc,appointment, customers, plateNo, technician);
    }   //Constructor with customer desc


    @Override
    public String toString() {
        return super.toString() + '\n' +
                "servicePrice = " + servicePrice + '\n';
    }
    
    public double calcPrice() {	// same as getServicePrice
		
    	return servicePrice;
	}
}

