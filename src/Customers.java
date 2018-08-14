public class Customers {
    private static int customerID = 1000; //Auto Generated, increment by one
    private Name customerName;
    private String contactNo;
    private int noOfWP;

    public Customers(Name customerName, String contactNo) {
        customerID++;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.noOfWP = 0;
    }


    @Override
    public String toString() {
        return "Customers{" +
                "customerID=" + customerID +
                ", customerName=" + customerName +
                ", contactNo='" + contactNo + '\'' +
                ", noOfWP=" + noOfWP +
                '}';
    }
}