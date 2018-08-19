public abstract class Services {
    private String serviceID; //Auto Generated from ID above
    private String serviceDesc;
    private Appointment appointment;
	private Customers customers;
	private String plateNo;
	private Technician technician;

	public Services() {
	}

	public Services(String serviceID, String serviceDesc, Appointment appointment, Customers customers, String plateNo, Technician technician) {
		this.serviceID = serviceID;
		this.serviceDesc = serviceDesc;
	    this.appointment = appointment;
		this.customers = customers;
		this.plateNo = plateNo;
		this.technician = technician;
	}

    @Override
    public String toString() {
        return "Service ID             = " + serviceID + '\n' +
                "Service Description    = " + serviceDesc + '\n' +
                appointment +
                customers +
                "Plate Number           = " + plateNo + '\n' +
                technician;
    }
	
	public Customers getCustomers() {
		return customers;
	}
	

	public abstract double calcPrice();


}
