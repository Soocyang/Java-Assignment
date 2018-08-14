
public class Inspection extends Services {
	private static int inspectionCode = 1000; // auto generate

	public Inspection() {

	}

	public Inspection(Customers customer, Appointment appointment, String plateNo, String serviceType,
			String serviceDesc, Technician technician) {

		super(customer, appointment, plateNo, serviceType, serviceDesc, technician);
		inspectionCode++;
	}

	public String toString() {

		return String.format("Inspection Code %d \n %s", inspectionCode, super.toString());

	}

}
