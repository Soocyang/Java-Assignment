import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstChoiceCarServices {
    public static void main(String[] args) {
        ArrayList<Customers> customers = new ArrayList<>();
        ArrayList<Technician> technician = new ArrayList<>();
        ArrayList<Appointment> appointment = new ArrayList<>();

        try {
            Customers.readFile(customers);
            Technician.readFile(technician);
            Appointment.readFile(appointment, customers);

            Appointment.newAppointment(customers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
