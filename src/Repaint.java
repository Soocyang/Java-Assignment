public class Repaint extends Services{
    private static int ID = 0; //Increment by one

    public Repaint(Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S1%03d",++ID),"Repaint",appointment, plateNo, technician, 150.00);
    }   //Constructor without desc

    public Repaint(String serviceDesc, Appointment appointment, String plateNo, Technician technician) {
        super(String.format("S1%03d",++ID),serviceDesc,appointment, plateNo, technician, 150.00);
    }   //Constructor with customer desc

    @Override
    public String toString() {
        return super.toString() + '\n';
    }
}

