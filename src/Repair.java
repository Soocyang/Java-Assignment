public class Repair extends Services{
    private static int ID = 0; //Increment by one

    public Repair(Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S2%03d",++ID),appointment, plateNo, technician,"Repair", 100.00);
    }   //Constructor without desc

    public Repair(Appointment appointment, String plateNo, Technician technician, String serviceDesc) {
        super(String.format("S2%03d",++ID),appointment, plateNo, technician,serviceDesc, 100.00);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n';
    }
}

