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
        return customerID + "," + customerName.toFile() + "," + contactNo + "," + noOfWP;
    }
    @Override
    public String toString() {
        return "Customer ID            = " + customerID + '\n' +
                "Customer Name          = " + customerName + '\n' +
                "Customer Contact       = " + contactNo + '\n' +
                "Number of Wax & Polish = " + noOfWP + '\n';
    }
}