import java.util.*;


public class FirstChoiceCarServices {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
    
		//Prompt User Input Date they wish to service car 
        System.out.print("Enter date: ");
        int date = scn.nextInt();
        System.out.print("Enter month: ");
        int month = scn.nextInt();
        System.out.print("Enter year: ");
        int year = scn.nextInt();
        
        //Passing date into class
        DateServe dateOfService = new DateServe(date, month-1, year);
        
        //First print, "date" only
        System.out.println(dateOfService);
        dateOfService.checkIsNationalDate(date, month);  // Validate for free inspection
        
        
        //Prompt input Appointment Time
        System.out.print("Enter hour: ");
        int hour = scn.nextInt();
        System.out.print("Enter minutes: ");
        int minutes = scn.nextInt();
        
        //Pass to class
        Appointment serviceAppoint = new Appointment(hour, minutes, dateOfService);
        
        //Second print, the whole appointment detail Date & Time
        System.out.println(serviceAppoint);
        
	}

}
