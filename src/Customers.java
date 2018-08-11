public class Customers {
    private static int customerID = 1000; //Auto Generated, increment by one
    private Name customerName;
    private String contactNo;
    private Car car;
    private int noOfWP;

    public Customers(Name customerName, String contactNo, Car car) {
        customerID++;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.car = car;
        this.noOfWP = 0;
    }


    @Override
    public String toString() {
        return "Customers{" +
                "customerID=" + customerID +
                ", customerName=" + customerName +
                ", contactNo='" + contactNo + '\'' +
                ", car=" + car +
                ", noOfWP=" + noOfWP +
                '}';
    }
}