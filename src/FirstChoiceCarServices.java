import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstChoiceCarServices {
    public static void main(String[] args) {
        ArrayList<Customers> customers = new ArrayList<>();
        ArrayList<Technician> technician = new ArrayList<>();
        ArrayList<Appointment> appointment = new ArrayList<>();
        ArrayList<Services> services = new ArrayList<>();

        try {
            Customers.readFile(customers);
            Technician.readFile(technician);
            Appointment.readFile(appointment, customers);
            //Services.readFile(services, appointment, technician);

            Appointment.newAppointment(appointment, customers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
