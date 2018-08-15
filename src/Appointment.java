import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Appointment {
	private Customers customer;
	private int hour;
	private int minutes;
	private DateServe appDay;

	public Appointment() {
	}

	public Appointment(Customers customer, int hour, int minutes, DateServe appoinmentDay) {
		this.customer=customer;
		this.hour = hour;
		this.minutes = minutes;
		this.appDay = appoinmentDay;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		Calendar calendar = new GregorianCalendar();

		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.AM_PM, Calendar.AM);

		return String.format("Customer : %s \nService Date and Time : %s %s", customer, sdf.format(calendar.getTime()), appDay);
	}
	
	public void setHour(int hour) {
		this.hour=hour;
	}
	
	public void setMinutes(int minutes) {
		this.minutes=minutes;
	}

}
