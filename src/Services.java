public abstract class Services {
	private static int serviceID = 1000; // auto generate
	private Appointment appointment;
	private Customers customers;
	private String plateNo;
	private Technician technician;

	public Services() {
	}

	public Services(Appointment appointment, Customers customers, String plateNo, Technician technician) {
		serviceID++;
		this.appointment = appointment;
		this.customers = customers;
		this.plateNo = plateNo;
		this.technician = technician;
	}

	@Override
	public String toString() {
		return "Services{" + "appointment=" + appointment + ", customers=" + customers + ", plateNo='" + plateNo + '\''
				+ ", technician=" + technician + '}';
	}
	
	public Customers getCustomers() {
		return customers;
	}
	

	public abstract double calcPrice();

}
