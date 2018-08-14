import java.io.File;
import java.util.Scanner;

public class FirstChoiceCarServices {

	public static void main(String[] args) {

		/* getCustomerInfo(); */

		getServiceDateAndTime(); 	// test method getService date and time
		
		readAndStore();			//Read and Storing from file to variables/objects
		
		/*technician();*/
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

		//Test writing into file
		CreateFile cf = new CreateFile();

		cf.openFile();
		cf.addRecords(day, month, year, hour, minutes);
		cf.closeFile();
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
	
	public static void technician() {
		Scanner sc = new Scanner(System.in);
		String firstName;
		String lastName;
		String serviceType;

		

		System.out.printf("Enter first name         : ");
		firstName = sc.nextLine();
		System.out.printf("Enter last name          : ");
		lastName = sc.nextLine();
		System.out.printf("Enter Service Type      : ");
		serviceType = sc.nextLine();
		
		sc.nextLine(); // Flushing

		Name name = new Name(firstName, lastName);
		Services service = new Services(serviceType);
		Technician technician = new Technician(name, service);

		
	}
	
	
	//This method is used to test file reading --> only for date and time
	public static void readAndStore() {
		Scanner sc;
		try {
			sc = new Scanner(new File("test2.txt"));

			System.out.println("Reading...");

			while (sc.hasNext()) {

				int d = sc.nextInt();
				int m = sc.nextInt();
				int y = sc.nextInt();
				int hh = sc.nextInt();
				int min = sc.nextInt();

				DateServe dateOfService = new DateServe(d, m - 1, y);
				Appointment serviceAppoint = new Appointment(hh, min, dateOfService);

				System.out.println(serviceAppoint);
			}

			sc.close();

		} catch (Exception e) {
			System.out.println("ERROR 404");
		}

	}

}
