import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Appointment {
	private Customers customer;
	private DateTime dateTime;
    private int preferService;

	public Appointment() {
	}

    public Appointment(Customers customer, DateTime dateTime, int preferService) {
        this.customer = customer;
        this.dateTime = dateTime;
        this.preferService = preferService;
    }

    

}
