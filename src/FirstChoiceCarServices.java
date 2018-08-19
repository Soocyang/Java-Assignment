import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstChoiceCarServices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customers> customers = new ArrayList<>();
        ArrayList<Technician> technician = new ArrayList<>();
        try {
            Customers.readFile(customers);
            Technician.readFile(technician);
            newAppointment(customers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void newAppointment(ArrayList<Customers> customers) throws IOException {
        PreService preService;
		DateTime dateTime = newDateTime(); //Get Time&Date
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
            custIndex = newCustomer(customers);
        else //No, returning customer
            custIndex = findCustomer(customers);

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

    private static DateTime newDateTime(){
        Scanner sc = new Scanner(System.in);
        // Prompt User Input Date and Time they wish to service car
        System.out.println();
        System.out.print("Enter date       : ");
        int day = sc.nextInt();
        System.out.print("Enter month      : ");
        int month = sc.nextInt();
        System.out.print("Enter year       : ");
        int year = sc.nextInt();
        System.out.print("Enter hour       : ");
        int hour = sc.nextInt();
        System.out.print("Enter minutes    : ");
        int minutes = sc.nextInt();

        return new DateTime(day,month,year,hour,minutes);
    }

    private static int newCustomer(ArrayList<Customers> customers){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name : ");
        String firstName = sc.next();
        System.out.print("Enter last last  : ");
        String lastName = sc.next();
        System.out.print("Enter contact no : ");
        String contact = sc.next();

        customers.add(new Customers(new Name(firstName, lastName),contact, 0));
        int lastIndex = customers.size()-1;
        try {
            Customers.appendFile(customers.get(lastIndex));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastIndex;
    }

    private static int findCustomer(ArrayList<Customers> customers){
        Scanner sc = new Scanner(System.in);
        String contact;
        int in, index;
        do {
            System.out.print("Enter contact : ");
            contact = sc.next();
            for(int i = 0;i < customers.size(); i++){
                if(customers.get(i).getContactNo().equals(contact)){
                    System.out.print(customers.get(i).toString());
                    index = i;
                    return index;
                }
            }
            System.out.print("Customer record not found, do you want to try again?\n" +
                    "1. Yes\n" +
                    "2. No\n");
            in = sc.nextInt();
        }while(in == 1);
        return newCustomer(customers);
    }
}
