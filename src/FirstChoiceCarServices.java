import java.util.Scanner;

public class FirstChoiceCarServices {

	public static void main(String[] args) {

		/* getCustomerInfo(); */

		getServiceDateAndTime(); // test method getService date and time

	}

	public static void getServiceDateAndTime() {

		Scanner scn = new Scanner(System.in);
		int day, month, year, hour, minutes;

		// Prompt User Input Date they wish to service car
		System.out.print("Enter date: ");
		day = scn.nextInt();
		System.out.print("Enter month: ");
		month = scn.nextInt();
		System.out.print("Enter year: ");
		year = scn.nextInt();
		System.out.print("Enter hour: ");
		hour = scn.nextInt();
		System.out.print("Enter minutes: ");
		minutes = scn.nextInt();

		// Pass to class
		DateServe dateOfService = new DateServe(day, month - 1, year);
		Appointment serviceAppoint = new Appointment(hour, minutes, dateOfService);

		// Validate for free inspection
		dateOfService.checkIsNationalDate(day, month);

		// Output
		System.out.println(serviceAppoint);
	}

	public static void getCustomerInfo() {
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
		sc.nextLine(); // Flushing
		System.out.printf("Enter car make               : "); // Car brand
		make = sc.nextLine();
		System.out.printf("Enter car model          : ");
		model = sc.nextLine();

		Name name = new Name(firstName, lastName);
		Car car = new Car(plateNo, color, year, make, model);
		Customers customers = new Customers(name, contactNo, car);

		System.out.println(customers.toString());
	}

}
