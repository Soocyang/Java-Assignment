import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Services {
    private String serviceID; //Auto Generated from ID above
    private String serviceDesc;
    protected Appointment appointment;
	private String plateNo;
	private Technician technician;
    protected double servicePrice;

	public Services() {
	}

	public Services(String serviceID, String serviceDesc, Appointment appointment, String plateNo, Technician technician, double servicePrice) {
		this.serviceID = serviceID;
		this.serviceDesc = serviceDesc;
	    this.appointment = appointment;
		this.plateNo = plateNo;
		this.technician = technician;
        this.servicePrice = servicePrice;
	}

   @Override
    public String toString() {
        return "Service ID             = " + serviceID + '\n' +
                "Service Description    = " + serviceDesc + '\n' +
                appointment +
                "Plate Number           = " + plateNo + '\n' +
                technician +
                "Service Price          = " + servicePrice + '\n';
    }

    static void newServices(ArrayList<Services> services, ArrayList<Appointment> appointment, ArrayList<Technician> technician) {

    }

    static void readFile(ArrayList<Services> services, ArrayList<Appointment> appointment, ArrayList<Technician> technician) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data/servicesInfo.csv"));
        String string;
        Scanner sc;
        char serviceType;
        String serviceDesc;
        Appointment appointmentID;
        String plateNo;
        Technician technicianID;

        int i = 0;
        while ((string = br.readLine()) != null) {
            sc = new Scanner(string).useDelimiter("\\s*,\\s*");
            serviceType = sc.next().charAt(1);
            serviceDesc = sc.next();
            appointmentID = appointment.get(sc.nextInt()-1);
            plateNo = sc.next();
            technicianID = technician.get(sc.nextInt()-1);

            if (serviceType == '0') {
                services.add(new Maintenance(serviceDesc,appointmentID,plateNo,technicianID));
            }
            else if (serviceType == '1'){
                services.add(new Repaint(serviceDesc,appointmentID,plateNo,technicianID));
            }
            else if (serviceType == '2'){
                services.add(new Repair(serviceDesc,appointmentID,plateNo,technicianID));
            }
            else{ //serviceType == '3'
                services.add(new WaxPolish(serviceDesc,appointmentID,plateNo,technicianID));
            }

            System.out.print(services.get(i));
            i++;
        }
        br.close();
    }
}
