public class Services {
	private static int transactionCode = 1000; // auto generate
	private static int serviceID = 1000; // auto generate
	private Appointment appointment;
	private String plateNo;
	private String serviceType;
	private String serviceDesc;
	private Technician technician;

	public Services() {

	}

	public Services(Appointment appointment, String plateNo, String serviceType, String serviceDesc,
			Technician technician) {
		transactionCode++;
		serviceID++;
		this.appointment = appointment;
		this.plateNo = plateNo;
		this.serviceType = serviceType;
		this.serviceDesc = serviceDesc;
		this.technician = technician;

	}

	public String toString() {
		return String.format("Transaction ID : %d\n Service ID : %d\n %s\n %s\n %s\n %s\n %s\n", transactionCode,
				serviceID, appointment, plateNo, serviceType, serviceDesc, technician);
		
		//Write all this to file

	}

}
