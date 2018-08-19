import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers {
    private static int ID = 0; //Increment by one
    private String customerID; //Auto Generated from ID above
    private Name customerName;
    private String contactNo;
    private int noOfWP;

    public Customers(Name customerName, String contactNo, int noOfWP) {
        this.customerID = String.format("C%04d",++ID);
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.noOfWP = noOfWP;
    }

    public String getCustomerID() {
        return customerID;
    }

    public Name getCustomerName() {
        return customerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public int getNoOfWP() {
        return noOfWP;
    }

    public void setNoOfWP(int noOfWP) {
        this.noOfWP = noOfWP;
    }

    private String toFile(){
        return customerID + "," + customerName.toFile() + "," + contactNo + "," + noOfWP + "\n";
    }

    @Override
    public String toString() {
        return "Customer ID            = " + customerID + '\n' +
                "Customer Name          = " + customerName + '\n' +
                "Customer Contact       = " + contactNo + '\n' +
                "Number of Wax & Polish = " + noOfWP + '\n';
    }

    static void readFile(ArrayList<Customers> customers) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data/customerInfo.csv"));
        String string;
        Scanner sc;
        while ((string = br.readLine()) != null) {
            sc = new Scanner(string).useDelimiter("\\s*,\\s*");
            sc.next(); //Ignoring the first field which contains customerID.
            customers.add(new Customers(new Name(sc.next(), sc.next()), sc.next(), sc.nextInt()));
        }
        br.close();
    }

    static int newCustomer(ArrayList<Customers> customers){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name : ");
        String firstName = sc.next();
        System.out.print("Enter last last  : ");
        String lastName = sc.next();
        System.out.print("Enter contact no : ");
        String contact = sc.next();

        customers.add(new Customers(new Name(firstName, lastName),contact, 0));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/customerInfo.csv", true));
            bw.write(customers.get(ID-1).toFile());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ID-1;
    }

    static int findCustomer(ArrayList<Customers> customers){
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