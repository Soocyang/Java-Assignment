import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Appointment {
    private static int ID = 0; //Increment by one
    private String appointmentID; //Auto Generated from ID above
    private Customers customer;
    private DateTime dateTime;
    private int preferService;

    public Appointment() {
    }

    public Appointment(Customers customer, DateTime dateTime, int preferService) {
        this.appointmentID = String.format("A%04d", ++ID);
        this.customer = customer;
        this.dateTime = dateTime;
        this.preferService = preferService;
    }

    public Customers getCustomers() {
        return this.customer;
    }

    @Override
    public String toString() {
        String[] service = {"Maintenance", "Repair", "Repaint", "Wax and Polish"};
        return  "Appointment ID         = " + appointmentID + "\n" +
                customer +
                "Date & Time            = " + dateTime  + "\n" +
                "Prefer Service         = " + service[preferService-1] + "\n";
    }

    static void newAppointment(ArrayList<Appointment> appointment, ArrayList<Customers> customers) throws IOException {
        DateTime dateTime = DateTime.newDateTime(); //Get Time&Date
        Scanner sc = new Scanner(System.in);
        int custIndex;
        int userInput;

        do { //Get CustomerInfo
            System.out.print("Is this your first time visiting 'First Choice Car Services'?\n" +
                    "1. Yes\n" +
                    "2. No\n");
            userInput = sc.nextInt();
        }while(userInput != 1 && userInput != 2);

        if (userInput == 1) //Yes, new customer
            custIndex = Customers.newCustomer(customers);
        else //No, returning customer
            custIndex = Customers.findCustomer(customers);

        do { //Get Preferred Service
            System.out.print("What is your preferred service?\n"+
                    "1. Maintenance\n"+
                    "2. Repair\n"+
                    "3. Repaint\n"+
                    "4. Wax and Polish\n"+
                    "Enter index 1~4  : "
            );
            userInput = sc.nextInt();
        }while(userInput < 1 || userInput > 4);

        appointment.add(new Appointment(customers.get(custIndex), dateTime, userInput));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/appointmentInfo.csv", true));
            bw.write(String.format("A%04d",ID) + "," + (custIndex+1) + "," + dateTime.toFile() + "," + userInput + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(appointment.get(ID-1));
    }

    static void readFile(ArrayList<Appointment> appointment, ArrayList<Customers> customers) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data/appointmentInfo.csv"));
        String string;
        Scanner sc;
        while ((string = br.readLine()) != null) {
            sc = new Scanner(string).useDelimiter("\\s*,\\s*");
            sc.next(); //Ignoring the first field which contains AppointID.
            appointment.add(new Appointment(
                    customers.get(sc.nextInt()-1),
                    new DateTime(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()),
                    sc.nextInt()));
        }
        br.close();
    }

    public int getPreferService() {
        return preferService;
    }

    public DateTime getDateTime() {
        return dateTime;
    }
}