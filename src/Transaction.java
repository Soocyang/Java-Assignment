import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    private static int ID = 0; //Increment by one
    private String transactionID; //Auto Generated from ID above
    private Services service;
    private double totalBill;

    public Transaction(Services service) {
        this.transactionID = String.format("B%04d", ++ID);
        this.service = service;
        if (service.getClass() == WaxPolish.class)
            this.totalBill = calcDiscountPrivileges();
        else
            this.totalBill = service.getServicePrice();
    }

    static void newTransaction(ArrayList<Transaction> transaction, ArrayList<Services> services) {
        Scanner sc = new Scanner(System.in);
        int userInput;
        String servicesInput;
        int servicesIndex = -1;
        boolean loop = true;
        do {
            System.out.print("Enter service code : ");
            servicesInput = sc.next();
            for (int i = 0; i < services.size(); i++) {
                if (servicesInput.equals(services.get(i).getServiceID())) {
                    servicesIndex = i;
                    do {
                        System.out.print(services.get(servicesIndex) +
                                "Continue transaction with above service?\n" +
                                "1. Yes\n" +
                                "2. No\n");
                        userInput = sc.nextInt();
                    } while (userInput != 1 && userInput != 2);
                    if (userInput == 1)
                        loop = false;
                    i = services.size();
                }
            }
        } while (loop);
        transaction.add(new Transaction(services.get(servicesIndex)));
        System.out.print(transaction.get(transaction.size() - 1));
    }

    private double calcDiscountPrivileges() {
        double servicePrice = service.getServicePrice();
        if (service.appointment.getCustomers().getNoOfWP() == 10) {
            return 0.00;
        } else if (service.appointment.getCustomers().getNoOfWP() >= 8) {
            return servicePrice * 0.7;
        } else if (service.appointment.getCustomers().getNoOfWP() >= 5) {
            return servicePrice * 0.9;
        }
        return servicePrice;
    }

    @Override
    public String toString() {
        return "Transaction ID         = " + transactionID + '\n' +
                service +
                "Total Bill             = " + totalBill + '\n';
    }
}
