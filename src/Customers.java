public class Customers {
    private static int customerID = 0; //Auto Generated, increment by one
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
        return String.format("%04d,%s,%s,%d\n",customerID,customerName,contactNo,noOfWP);
    }

    @Override
    public String toString() {
        return String.format("Customer ID            = C%04d\n",customerID) +
                "Customer Name          = " + customerName +'\n' +
                "Customer Contact       = " + contactNo + '\n' +
                "Number of Wax & Polish = " + noOfWP +'\n';
    }
}