import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstChoiceCarServices {
	public static void main(String[] args) {
		ArrayList<Customers> customers = new ArrayList<>();
		ArrayList<Technician> technician = new ArrayList<>();
		ArrayList<Appointment> appointment = new ArrayList<>();
		ArrayList<Services> services = new ArrayList<>();
		ArrayList<Transaction> transaction = new ArrayList<>();

		try {
			Customers.readFile(customers);
			Technician.readFile(technician);
			Appointment.readFile(appointment, customers);
			Services.readFile(services, appointment, technician);

			int selection = menu();
			do {

				if (selection == 1) {
					System.out.println("\n--------- Registration for New Service ---------\n");
					System.out.println("Please enter the details of the new service ...");
					// For registration
					
					Appointment.newAppointment(appointment, customers);
					Services.newServices(services, appointment, technician);
					Transaction.newTransaction(transaction, services);
					// Use S3001 to test discount.
					
					
				} else if (selection == 2) {
					System.out.println("\n--------- View Transaction History ---------\n");
					System.out.println("Enter the car registration number to search for the transaction");
					
					
					
				} else if (selection == 3) {
					System.out.println("\n--------- View Appointment Records ---------\n");
					
					
					
				} else if (selection == 4) {
					System.out.println("\n--------- View Technician Records ---------\n");
					
					
					
				}
				
				selection = menu();
			} while (selection != 0);

			
			
			
			System.out.println("Thank you for using the program!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int menu() {
		Scanner sc = new Scanner(System.in);
		int choice;

		System.out.print("Welcome to First Choice Car Service Center\n" + "------------------------------------------\n"
				+ "1. Register new services\n" + "2. View Transaction History\n" + "3. View Appointment Records\n"
				+ "4. View Technician Records\n" + "0. Exit\n");
		System.out.print("Enter your choice : ");
		choice = sc.nextInt();

		return choice;
	}

}
