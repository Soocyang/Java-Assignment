import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Appointment {
    private Customers customer;
    private DateTime dateTime;
    private int preferService;

    public Appointment() {
    }

    public Appointment(Customers customer, DateTime dateTime, int preferService) {
        this.customer = customer;
        this.dateTime = dateTime;
        this.preferService = preferService;
    }

    @Override
    public String toString() {
        return  customer +
                "Date & Time            = " + dateTime  + "\n" +
                "Preferred Service      = " + preferService + "\n";
    }

    static void newAppointment(ArrayList<Customers> customers) throws IOException {
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

        Appointment appointment = new Appointment(customers.get(custIndex), dateTime, userInput);
        System.out.print(appointment);
    }
}