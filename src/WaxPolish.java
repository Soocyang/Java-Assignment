public class WaxPolish extends Services{
    private String serviceDesc;
    private double servicePrice = 190.00;

    public WaxPolish(Appointment appointment, Customers customers, String plateNo, Technician technician, String serviceDesc) {
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
		
    	if(super.getAppointment().getCustomer().getNoOfWP()>=5 && super.getAppointment().getCustomer().getNoOfWP()<=7) {
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
