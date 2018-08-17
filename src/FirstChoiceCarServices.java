import java.io.*;
import java.util.Scanner;

public class FirstChoiceCarServices {
	public static void main(String[] args) {

		getCustomerInfo();
        System.out.print("The next customer ID starts from : " + Customers.getCustomerID());
		try {
			newAppointment();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	private static void newAppointment() throws IOException {
		Customers customers;
        PreService preService;
		DateTime dateTime = newDateTime(); //Get Time&Date
        Scanner sc = new Scanner(System.in);
        int in;

        do { //Get CustomerInfo
            System.out.print("Is this your first time visiting 'First Choice Car Services'?\n" +
                    "1. Yes\n" +
                    "2. No\n");
            in = sc.nextInt();
        }while(in != 1 && in != 2);

		// if (in == 1) //Yes, new customer
            customers = newCustomer();
        // else //No, returning customer
            //customers = findCustomer(); //TODO find customer here

        do { //Get Preferred Service
            System.out.print("What is your preferred service?\n"+
                    "1. Maintenance\n"+
                    "2. Repair\n"+
                    "3. Repaint\n"+
                    "4. Wax and Polish\n"+
                    "Enter index 1~4 : "
            );
            in = sc.nextInt();
        }while(in < 1 || in > 4);

        Appointment appointment = new Appointment(customers, dateTime, in);
        System.out.print(appointment.toString());
	}

    private static DateTime newDateTime(){
        Scanner sc = new Scanner(System.in);
        // Prompt User Input Date and Time they wish to service car
        System.out.println();
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
        System.out.print("Enter first name : ");
        String firstName = sc.next();
        System.out.print("Enter last last : ");
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
        BufferedWriter  bw = new BufferedWriter(new FileWriter("data/customerInfoOut.csv", true));

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
}
