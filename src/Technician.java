public class Technician {
	private static int technicianID = 100; //Auto Generated, increment by one
    private Name technicianName;
    private Services serviceHandle;
    
    
    public Technician(Name technicianName, Services serviceHandle) {
    	technicianID++;
        this.technicianName = technicianName;
        this.serviceHandle = serviceHandle;
    }
    
    public String toString() {
    	return technicianID + "," + technicianName + "," + serviceHandle;
    }
}