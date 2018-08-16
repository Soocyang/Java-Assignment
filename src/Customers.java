public class Customers {
    private static int customerID = 1000; //Auto Generated, increment by one
    private Name customerName;
    private String contactNo;
    private int noOfWP;

    public Customers(Name customerName, String contactNo, int noOfWP) {
        customerID++;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.noOfWP = noOfWP;
    }

    public static int getCustomerID() {
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
        return customerID + "," + customerName + "," + contactNo + "," + noOfWP;
    }

    @Override
    public String toString() {
        return "customer ID = " + customerID +'\n' +
                "customerName = " + customerName +'\n' +
                "contactNo   = " + contactNo + '\n' +
                "Number of Wax & Polish = " + noOfWP +'\n';
    }
}