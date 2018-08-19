import java.io.IOException;
import java.util.ArrayList;

public class FirstChoiceCarServices {
    public static void main(String[] args) {
        ArrayList<Customers> customers = new ArrayList<>();
        ArrayList<Technician> technician = new ArrayList<>();
        ArrayList<Appointment> appointment = new ArrayList<>();
        ArrayList<Services> services = new ArrayList<>();
        ArrayList<Transaction> transaction = new ArrayList<>();

        try {
            Customers.readFile(customers);
            Technician.readFile(technician);
            Appointment.readFile(appointment, customers);
            Services.readFile(services, appointment, technician);

            Appointment.newAppointment(appointment, customers);
            Services.newServices(services, appointment, technician);
            Transaction.newTransaction(transaction, services); //Use S3001 to test discount.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
