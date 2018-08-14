public class Services {
    private String serviceID;
    private String serviceType;
    private String serviceDesc;
    private double price;

    public Services() {

    }

    public Services(String serviceID, String serviceType, String serviceDesc, double price) {
        this.serviceID = serviceID;
        this.serviceType = serviceType;
        this.serviceDesc = serviceDesc;
        this.price = price;

    }
    
    public Services(String serviceType) {
    	this.serviceType = serviceType;
    }

}
