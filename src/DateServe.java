import java.lang.*;
import java.text.*;
import java.util.*;

public class DateServe {
	private int day;
	private int month;
	private int year;
	/*private int hour;
	private int minutes;*/
	private static int NationalDay = 31;
	private static int NationalMonth = 8;
	private static String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wedesday", "Thursday", "Friday", "Saturday" };

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

		return String.format("%s %s", dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK)-1], sdf.format(calendar.getTime()));
		
	}

	public void checkIsNationalDate(int day, int month) {

		if (day == NationalDay && month == NationalMonth) {
			System.out.println("IS NATIONAL DAY!!");
		} else {
			System.out.println("Sorry, you're not applicable for free inspection...");
		}
		
		

	}

}
