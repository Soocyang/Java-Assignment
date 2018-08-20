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
			Scanner sc = new Scanner(System.in);
			do {

				if (selection == 1) {
					do {
						System.out.print("--------- Registration for New Service ---------\n" +
								"1. New appointment\n" +
								"2. New service\n" +
								"3. New transaction\n" +
								"0. Return\n");
						System.out.print("Enter your choice : ");
						selection = sc.nextInt();
					}while(selection < 0 || selection > 3);

					if (selection == 1)
						Appointment.newAppointment(appointment, customers);
					else if (selection == 2)
						Services.newServices(services, appointment, technician);
					else if (selection == 3)
						Transaction.newTransaction(transaction, services); // Use S3001 to test discount.
					//else //Return

				} else if (selection == 2) {
					System.out.println("\n--------- View Service History ---------\n");
					System.out.println("Enter the car registration number to search for the service history.\n" +
							"Car Plate No : ");
					String carPlate = sc.next();
					int found =0;
					for (int i = 0; i < services.size(); i++)
					{
						if(carPlate.equals(services.get(i).getPlateNo())){
							System.out.print(services.get(i));
							found++;
						}
					}
					if (found == 0)
						System.out.print("No record for " + carPlate + " found.");
					else
						System.out.print("Found " + found + " record(s)");
				} else if (selection == 3) {
					System.out.println("\n--------- View Appointment History ---------\n");
					System.out.println("Enter the car registration number to search for the service history.\n" +
							"Car Plate No : ");
					String carPlate = sc.next();
					int found =0;
					for (int i = 0; i < services.size(); i++)
					{
						if(carPlate.equals(services.get(i).getPlateNo())){
							System.out.print(services.get(i));
							found++;
						}
					}
					if (found == 0)
						System.out.print("No record for " + carPlate + " found.");
					else
						System.out.print("Found " + found + " record(s)");
					
					
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
		do {
			System.out.print("Welcome to First Choice Car Service Center\n" + "------------------------------------------\n" +
					"1. Register new services\n" +
					"2. View Transaction History\n" +
					"3. View Appointment Records\n" +
					"4. View Technician Records\n" +
					"0. Exit\n");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
		}while(choice < 0 || choice > 4);
		sc.close();
		return choice;
	}

}
