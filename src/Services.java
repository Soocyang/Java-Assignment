import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Services {
    private String serviceID; //Auto Generated from ID above
    protected Appointment appointment;
	private String plateNo;
	private Technician technician;
    private String serviceDesc;
    protected double servicePrice;

	public Services() {
	}

	public Services(String serviceID, Appointment appointment, String plateNo, Technician technician, String serviceDesc, double servicePrice) {
		this.serviceID = serviceID;
	    this.appointment = appointment;
		this.plateNo = plateNo;
		this.technician = technician;
        this.serviceDesc = serviceDesc;
        this.servicePrice = servicePrice;
	}

   @Override
    public String toString() {
        return "Service ID             = " + serviceID + '\n' +
                appointment +
                "Plate Number           = " + plateNo + '\n' +
                technician +
                "Service Description    = " + serviceDesc + '\n' +
                "Service Price          = " + servicePrice + '\n';
    }

    static void newServices(ArrayList<Services> services, ArrayList<Appointment> appointment, ArrayList<Technician> technician) {
        Scanner sc = new Scanner(System.in);
        int userInput;
        int serviceType;
        String plateNo;
        String serviceDesc;
        int appointmentIndex = -1;
        int technicianIndex = -1;
        boolean loop = true;

        do { //Get CustomerInfo
            System.out.print("Please enter appointment number : \n");
            userInput = sc.nextInt();
            if (userInput < 0 || userInput >= appointment.size()){
                System.out.print("Value out of range or invalid, please try again.");
            }
            else {
                appointmentIndex = userInput-1;
                do {
                    System.out.print(appointment.get(appointmentIndex) +
                            "Begin service above appointment?\n" +
                            "1. Yes\n" +
                            "2. No\n");
                    userInput = sc.nextInt();
                }while(userInput != 1 && userInput != 2);
                if (userInput == 1)
                    loop = false;
            }
        }while(loop);

        loop = true;
        do {
            serviceType = appointment.get(appointmentIndex).getPreferService();
            for (int i = 0; i < technician.size(); i++){
                if(serviceType == technician.get(i).getServiceHandle())
                    System.out.print(technician.get(i));
            }
            System.out.print("Please select a technician for the service.\n" +
                    "Enter technician's ID : T");
            userInput = sc.nextInt();
            if(userInput < 0 || userInput >= technician.size()){
                System.out.print("Value out of range or invalid, please try again.");
            }
            else {
                technicianIndex = userInput-1;
                do {
                    System.out.print(technician.get(technicianIndex) +
                            "Continue appointment with above technician?\n" +
                            "1. Yes\n" +
                            "2. No\n");
                    userInput = sc.nextInt();
                }while(userInput != 1 && userInput != 2);
                if (userInput == 1)
                    loop = false;
            }
        }while(loop);

        System.out.print("Get Plate Number : ");
        plateNo = sc.next();

        System.out.print("Enter service description : ");
        serviceDesc = sc.next();

        services.add(Services.createService(serviceType,appointment.get(appointmentIndex),plateNo,technician.get(technicianIndex), serviceDesc));
        int i = services.size()-1;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/servicesInfo.csv", true));
            bw.write(services.get(i).serviceID + "," +
                    (appointmentIndex + 1) + "," +
                    plateNo+ "," +
                    (technicianIndex + 1) + "," +
                    serviceDesc + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(services.get(i));
    }

    static void readFile(ArrayList<Services> services, ArrayList<Appointment> appointment, ArrayList<Technician> technician) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data/servicesInfo.csv"));
        String string;
        Scanner sc;
        char serviceType;
        Appointment appointmentID;
        String plateNo;
        Technician technicianID;
        String serviceDesc;

        int i = 0;
        while ((string = br.readLine()) != null) {
            sc = new Scanner(string).useDelimiter("\\s*,\\s*");
            serviceType = sc.next().charAt(1);
            appointmentID = appointment.get(sc.nextInt()-1);
            plateNo = sc.next();
            technicianID = technician.get(sc.nextInt()-1);
            serviceDesc = sc.next();

            services.add(Services.createService(serviceType,appointmentID,plateNo,technicianID,serviceDesc));

            System.out.print(services.get(i));
            i++;
        }
        br.close();
    }

    public static Services createService(int serviceType, Appointment appointmentID, String plateNo, Technician technicianID, String serviceDesc){
        if (serviceType == '0') {
            return new Maintenance(appointmentID,plateNo,technicianID,serviceDesc);
        }
        else if (serviceType == '1'){
            return new Repaint(appointmentID,plateNo,technicianID,serviceDesc);
        }
        else if (serviceType == '2'){
            return new Repair(appointmentID,plateNo,technicianID,serviceDesc);
        }
        else{ //serviceType == '3'
            return new WaxPolish(appointmentID,plateNo,technicianID,serviceDesc);
        }
    }
}
