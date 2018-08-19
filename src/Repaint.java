public class Repaint extends Services{
    private static int ID = 0; //Increment by one
    private double servicePrice = 150.00;

    public Repaint(Appointment appointment, Customers customers, String plateNo, Technician technician) {
        super(String.format("S1%03d",++ID),"Repaint",appointment, customers, plateNo, technician);
    }   //Constructor without desc

    public Repaint(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc) {
        super(String.format("S1%03d",++ID),serviceDesc,appointment, customers, plateNo, technician);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "servicePrice = " + servicePrice + '\n';
    }
    
    public double calcPrice() {
		
    	return servicePrice;
	}
}

