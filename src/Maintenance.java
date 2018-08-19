public class Maintenance extends Services {
    private static int ID = 0; //Increment by one

    public Maintenance(Appointment appointment, String plateNo, Technician technician, String serviceDesc) {
        super(String.format("S0%03d", ++ID), appointment, plateNo, technician, serviceDesc, 90.00);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n';
    }
}

