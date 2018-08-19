public class Maintenance extends Services {
    private static int ID = 0; //Increment by one

    public Maintenance(Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S0%03d",++ID),"Maintenance",appointment, plateNo, technician, 90.00);
    }   //Constructor without desc

    public Maintenance(String serviceDesc, Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S0%03d",++ID),serviceDesc,appointment, plateNo, technician, 90.00);
    }   //Constructor with customer desc


    @Override
    public String toString() {
        return super.toString() + '\n';
    }
}

