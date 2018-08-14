import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Appointment {
	private int hour;
	private int minutes;
	private DateServe appDay;

	public Appointment() {
	}

	public Appointment(int hour, int minutes, DateServe appoinmentDay) {
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

		return String.format("Service Date and Time : %s %s", sdf.format(calendar.getTime()), appDay);
	}
	
	public void setHour(int hour) {
		this.hour=hour;
	}
	
	public void setMinutes(int minutes) {
		this.minutes=minutes;
	}

}
