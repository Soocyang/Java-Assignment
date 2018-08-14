import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateServe {
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private static String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wedesday", "Thursday", "Friday", "Saturday" };
	private int day;
	private int month;
	private int year;

	public DateServe() {

	}

	public DateServe(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		Calendar calendar = new GregorianCalendar(year, month, day);

		return String.format("%s %s", dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1],
				sdf.format(calendar.getTime()));
	}

	public void checkIsNationalDate(int day, int month) {
		int nationalDay = 31;
		int nationalMonth = 8;
		if (day == nationalDay && month == nationalMonth) {
			System.out.println("IS NATIONAL DAY!!");
		} else {
			System.out.println("Sorry, you're not applicable for free inspection...");
		}

	}

}
