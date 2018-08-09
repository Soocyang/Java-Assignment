import java.lang.*;
import java.text.*;
import java.util.*;

public class DateServe {
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minutes;
	private static int NationalDay = 31;
	private static int NationalMonth = 7;

	public DateServe() {

	}

	public DateServe(int day, int month, int year, int hour, int minutes) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minutes = minutes;
	}

	public void getDateServe() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy h:mm a ");

		Calendar calendar = new GregorianCalendar(year, month, day, hour, minutes);

		
		// update a date
	/*	calendar.set(Calendar.YEAR, year); 
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, day);
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minutes);*/

		System.out.println("Service Date : " + sdf.format(calendar.getTime()));
		checkIsNationalDate(day,month);
	}
	
	public void checkIsNationalDate(int day, int month) {
		
		if(day == NationalDay && month == NationalMonth) {
			System.out.println("IS NATIONAL DAY!!");
		}
		else {
			System.out.println("Sorry, you're not applicable for free inspection...");
		}
		
		
		
	}
	
	

}
