public class Repair extends Services{
    private static int ID = 0; //Increment by one

    public Repair(Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S2%03d",++ID),"Repair",appointment, plateNo, technician, 100.00);
    }   //Constructor without desc

    public Repair(String serviceDesc, Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S2%03d",++ID),serviceDesc,appointment, plateNo, technician, 100.00);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n';
    }
}

