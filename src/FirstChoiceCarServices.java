import java.io.*;
import java.util.Scanner;

public class FirstChoiceCarServices {

	public static void main(String[] args) {

		getCustomerInfo();

		/*
		 * 
		 * getServiceDateAndTime(); // test method getService date and time
		 * 
		 * try { readAndStore(); //Read and Storing from file to variables/objects }
		 * catch (FileNotFoundException e) { e.printStackTrace(); }
		 * 
		 * technician();
		 * 
		 */
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

		// Test writing into file
		/*
		 * CreateFile cf = new CreateFile();
		 *
		 * cf.openFile(); cf.addRecords(day, month, year, hour, minutes);
		 * cf.closeFile();
		 */
	}

	public static void getCustomerInfo() {
		Scanner sc = new Scanner(System.in);
		// String firstName;
		// String lastName;
		// String contactNo;
		// String plateNo;
		// String color;
		// int year;
		// String make;
		// String model;
		//
		// System.out.printf("Enter first name : ");
		// firstName = sc.nextLine();
		// System.out.printf("Enter last name : ");
		// lastName = sc.nextLine();
		// System.out.printf("Enter contact number : ");
		// contactNo = sc.nextLine();
		// System.out.printf("Enter plate number : ");
		// plateNo = sc.nextLine();

		// Name name = new Name(firstName, lastName); //Missing Name Class??
		// Car car = new Car(plateNo, color, year, make, model);
		// Customers customers = new Customers(name, contactNo, car);

		try {
			Customers[] customers = readCustomerInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void appendCustomerInfo(Customers customers) throws IOException {
        BufferedWriter  bw = new BufferedWriter(new FileWriter("data/customerInfoOut.txt"));

		bw.write(customers.toString()+'\n');

		bw.close();
	}

	private static Customers[] readCustomerInfo() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/customerInfo.csv"));
		String string;
		Scanner sc;
		int i = 0;
		Customers[] customers = new Customers[100];
		while ((string = br.readLine()) != null) {
			sc = new Scanner(string).useDelimiter("\\s*,\\s*");
            sc.next();
			customers[i] = new Customers(new Name(sc.next(), sc.next()), sc.next(), sc.nextInt());
			System.out.println(customers[i].toString());
			i++;
		}
		br.close();
		return customers;
	}

	
	/*public static void technician() {						//This method need to restructure
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

	}*/

	// This method is used to test file reading --> only for date and time    // Will leave it as reference only
	public static void readAndStore() throws FileNotFoundException {
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
			throw e;
		}

	}

}
