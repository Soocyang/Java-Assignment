public class WaxPolish extends Services{
    private static int ID = 0; //Increment by one

    public WaxPolish(Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S3%03d",++ID),appointment, plateNo, technician,"Wax and Polish", 190.00);
    }   //Constructor without desc

    public WaxPolish(Appointment appointment, String plateNo, Technician technician, String serviceDesc) {
        super(String.format("S3%03d",++ID),appointment, plateNo, technician,serviceDesc, 190.00);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n';
    }
    
    public double calcPrice() {
        double servicePrice = 190;
        if(super.appointment.getCustomers().getNoOfWP() == 10) {
            super.servicePrice = 0.00;
        }
        else if(super.appointment.getCustomers().getNoOfWP()>=8) {
            super.servicePrice = servicePrice * 0.7 ;
        }
        else if(super.appointment.getCustomers().getNoOfWP()>=5) {
            super.servicePrice = servicePrice * 0.9;
    	}
    	return servicePrice;
	}
}
