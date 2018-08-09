import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FirstChoiceCarServices {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
    
        System.out.print("Enter date: ");
        int date = scn.nextInt();
        System.out.print("Enter month: ");
        int month = scn.nextInt();
        System.out.print("Enter year: ");
        int year = scn.nextInt();
        System.out.print("Enter hour: ");
        int hour = scn.nextInt();
        System.out.print("Enter minutes: ");
        int minutes = scn.nextInt();
        
        DateServe dateOfService = new DateServe(date, month-1, year, hour, minutes);
        
        dateOfService.getDateServe();
	}

}
