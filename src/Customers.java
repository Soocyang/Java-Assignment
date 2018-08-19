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

    public String toFile() {
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
        int i = 0;
        while ((string = br.readLine()) != null) {
            sc = new Scanner(string).useDelimiter("\\s*,\\s*");
            sc.next(); //Ignoring the first field which contains customerID.
            customers.add(new Customers(new Name(sc.next(), sc.next()), sc.next(), sc.nextInt()));
            System.out.println(customers.get(i).toString());
            i++;
        }
        br.close();
    }

    static void appendFile(Customers customers) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("data/customerInfo.csv", true));
        bw.write(customers.toFile());
        bw.close();
    }
}