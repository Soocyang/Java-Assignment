import java.io.*;
import java.util.Scanner;

public class FirstChoiceCarServices {

	public static void main(String[] args) {

		// getCustomerInfo();

		try {
			newAppointment();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // test method getService date and time
	 
		/*try { readAndStore(); //Read and Storing from file to variables/objects }
		catch (FileNotFoundException e) { e.printStackTrace(); }
		
		technician();*/
		 
		 
	}

	private static void newAppointment() throws IOException {
		char in;
		Customers customers;
        PreService preService;
		DateTime dateTime = newDateTime(); //Get Time&Date


		do { //Get CustomerInfo
            System.out.print("Is this your first time visiting 'First Choice Car Services'? (Y/N) : ");
            in = (char)System.in.read();
        }while(in != 'Y' && in != 'N');

		if (in == 'Y')
            customers = newCustomer();
        else
            //customers = findCustomer(); //TODO find customer here

        do { //Get Preferred Service
            System.out.print("What is your preferred service?\n"+
                    "1. Maintenance\n"+
                    "2. Repair\n"+
                    "3. Repaint\n"+
                    "4. Wax and Polish\n"+
                    "Enter index 1~4 : "
            );
            in = (char)System.in.read();
        }while(in < '1' || in > '4');

        if (in == '1')
            preService = new Maintenance();
        else if (in == '2')
            preService = new Repair();
        else if (in == '3')
            preService = new Repaint();
        else
            preService = new WaxPolish();

	}

    private static DateTime newDateTime(){
        Scanner sc = new Scanner(System.in);
        // Prompt User Input Date and Time they wish to service car
        System.out.print("Enter date : ");
        int day = sc.nextInt();
        System.out.print("Enter month : ");
        int month = sc.nextInt();
        System.out.print("Enter year : ");
        int year = sc.nextInt();
        System.out.print("Enter hour : ");
        int hour = sc.nextInt();
        System.out.print("Enter minutes : ");
        int minutes = sc.nextInt();

        return new DateTime(day,month,year,hour,minutes);
    }

    private static Customers newCustomer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first : ");
        String firstName = sc.next();
        System.out.print("Enter last : ");
        String lastName = sc.next();
        System.out.print("Enter contact : ");
        String contact = sc.next();

        Customers customers = new Customers(new Name(firstName, lastName),contact, 0);
        try {
            appendCustomerInfo(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    private static Customers findCustomer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter contact : ");
        String contact = sc.next();

        //find customer using their phone number?

        return new Customers(new Name("0","0"),"0",0);
    }

    public static void getCustomerInfo() {
		Scanner sc = new Scanner(System.in);
		try {
			Customers[] customers = readCustomerInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void appendCustomerInfo(Customers customers) throws IOException {
        BufferedWriter  bw = new BufferedWriter(new FileWriter("data/customerInfoOut.txt"));

		bw.write(customers.toFile()+'\n');

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
	/*public static void readAndStore() throws FileNotFoundException {
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

				DateTime dateOfService = new DateTime(d, m - 1, y);
				Appointment serviceAppoint = new Appointment(hh, min, dateOfService);

				System.out.println(serviceAppoint);
			}

			sc.close();

		} catch (Exception e) {
			throw e;
		}

	}*/

}
