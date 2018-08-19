public class Technician {
	private static int ID = 0; //Increment by one
    private String technicianID; //Auto Generated from ID above
    private Name technicianName;
    private int serviceHandle;
    
    public Technician(Name technicianName, int serviceHandle) {
        this.technicianID = String.format("T%04d",++ID);
        this.technicianName = technicianName;
        this.serviceHandle = serviceHandle;
    }
    
    public String toFile() {
    	return technicianID + "," + technicianName.toFile() + "," + serviceHandle;
    }

    @Override
    public String toString() {
        String[] service = {"Maintenance","Repair","Repaint","Wax and Polish"};
        return "Technician ID          = " + technicianID + '\n' +
                "Technician Name        = " + technicianName + '\n' +
                "Service Handle         = " + service[serviceHandle-1] + '\n';
    }
}