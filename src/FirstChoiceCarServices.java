import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstChoiceCarServices {
    public static void main(String[] args) {
        ArrayList<Customers> customers = new ArrayList<>();
        ArrayList<Technician> technician = new ArrayList<>();

        try {
            Customers.readFile(customers);
            Technician.readFile(technician);
            Appointment.newAppointment(customers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
