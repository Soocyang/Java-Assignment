public class WaxPolish extends Services{
    private static int ID = 0; //Increment by one

    public WaxPolish(Appointment appointment, String plateNo, Technician technician, String serviceDesc) {
        super(String.format("S3%03d",++ID),appointment, plateNo, technician,serviceDesc, 190.00);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n';
    }
}
