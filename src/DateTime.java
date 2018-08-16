import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTime {
	private static String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wedesday", "Thursday", "Friday", "Saturday" };
	private int day;
	private int month;
	private int year;
    private int hour;
    private int minute;

	public DateTime() {

	}

    public DateTime(int day, int month, int year, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy h:mm a");
		Calendar calendar = new GregorianCalendar(year, month, day, hour, minute);

		calendar.set(Calendar.HOUR, this.hour);
		calendar.set(Calendar.MINUTE, this.minute);
		calendar.set(Calendar.AM_PM, Calendar.AM);

		return String.format("%s %s", dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1],
				sdf.format(calendar.getTime()));
	}

	public boolean checkIsNationalDate() {
		if (this.day == 31 && this.month == 8) {
			System.out.println("IS NATIONAL DAY!!");
			return true;
		} else {
			System.out.println("Sorry, you're not applicable for free inspection...");
		    return false;
		}

	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}
}
