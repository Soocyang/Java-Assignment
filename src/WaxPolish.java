public class WaxPolish extends Services{
    private static int ID = 0; //Increment by one
    private double servicePrice = 190.00;

    public WaxPolish(Appointment appointment, Customers customers, String plateNo, Technician technician) {
        super(String.format("S3%03d",++ID),"Wax and Polish",appointment, customers, plateNo, technician);
    }   //Constructor without desc

    public WaxPolish(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc) {
        super(String.format("S3%03d",++ID),serviceDesc,appointment, customers, plateNo, technician);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "servicePrice = " + servicePrice + '\n';
    }
    
    public double calcPrice() {
		
    	if(super.getCustomers().getNoOfWP()>=5 && super.getCustomers().getNoOfWP()<=7) {
    		this.servicePrice = servicePrice - (servicePrice*0.1) ;
    		
    	}
    	else if(super.getCustomers().getNoOfWP()>=8 && super.getCustomers().getNoOfWP()<=9) {
    		this.servicePrice = servicePrice - (servicePrice*0.3) ;

    	}
    	else if(super.getCustomers().getNoOfWP() == 10) {
    		this.servicePrice = 0.00;
    	}
    	else
    		return this.servicePrice;
    	
    	   	
    	return servicePrice;
	}
}
