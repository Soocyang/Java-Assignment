import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateTime {
	private static String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
			"Saturday" };
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

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, h:mm a");
		Calendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute);

		return String.format("%s %s", dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1],
				sdf.format(calendar.getTime()));
	}

	static DateTime newDateTime(){
		Scanner sc = new Scanner(System.in);
		// Prompt User Input Date and Time they wish to service car
		System.out.println();
		System.out.print("Enter date       : ");
		int day = sc.nextInt();
		System.out.print("Enter month      : ");
		int month = sc.nextInt();
		System.out.print("Enter year       : ");
		int year = sc.nextInt();
		System.out.print("Enter hour       : ");
		int hour = sc.nextInt();
		System.out.print("Enter minutes    : ");
		int minutes = sc.nextInt();

		return new DateTime(day,month,year,hour,minutes);
	}

	public boolean IsNationalDay() {
		if (this.day == 31 && this.month == 8) {
			return true;
		} else {
			return false;
		}
	}
}
