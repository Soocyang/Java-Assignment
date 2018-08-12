import java.util.Scanner;

public class FirstChoiceCarServices {

    public static void main(String[] args) {

        getCustomerInfo();

        getServiceDateAndTime();  //test method getService date and time

    }

    public static void getServiceDateAndTime() {

        Scanner scn = new Scanner(System.in);

        // Prompt User Input Date they wish to service car
        System.out.print("Enter date: ");
        int date = scn.nextInt();
        System.out.print("Enter month: ");
        int month = scn.nextInt();
        System.out.print("Enter year: ");
        int year = scn.nextInt();

        // Passing date into class
        DateServe dateOfService = new DateServe(date, month - 1, year);

        // First print, "date" only
        System.out.println(dateOfService);
        dateOfService.checkIsNationalDate(date, month); // Validate for free inspection

        // Prompt input Appointment Time
        System.out.print("Enter hour: ");
        int hour = scn.nextInt();
        System.out.print("Enter minutes: ");
        int minutes = scn.nextInt();

        // Pass to class
        Appointment serviceAppoint = new Appointment(hour, minutes, dateOfService);

        // Second print, the whole appointment detail Date & Time
        System.out.println(serviceAppoint);
    }

    public static void getCustomerInfo(){
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        String contactNo;
        String plateNo;
        String color;
        int year;
        String make;
        String model;

        System.out.printf("Enter first name         : ");
        firstName = sc.nextLine();
        System.out.printf("Enter last name          : ");
        lastName = sc.nextLine();
        System.out.printf("Enter contact number     : ");
        contactNo = sc.nextLine();
        System.out.printf("Enter plate number       : ");
        plateNo = sc.nextLine();
        System.out.printf("Enter color of your car  : ");
        color = sc.nextLine();
        System.out.printf("Enter year of purchase   : ");
        year = sc.nextInt();
        sc.nextLine();    //Flushing
        System.out.printf("Enter car make               : "); //Defuk is make? // Car brand
        make = sc.nextLine();
        System.out.printf("Enter car model          : ");
        model = sc.nextLine();

        Name name = new Name(firstName, lastName);				//Missing Name Class??
        Car car = new Car(plateNo, color, year, make, model);
        Customers customers = new Customers(name, contactNo, car);

        System.out.println(customers.toString());
    }

}
