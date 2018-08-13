import java.io.*;
import java.lang.*;
import java.util.*;

public class CreateFile {
	private Formatter f;

	public void openFile() {

		try {
			f = new Formatter("test2.txt");

			System.out.println("Write into file...");
		} catch (Exception e) {
			System.out.println("ERROR 404");
		}
	}

	public void addRecords(int day, int month, int year, int hour, int min) {
		f.format("%s %s %s %s %s", day, month, year, hour, min);
	}
	
	public void closeFile() {
		f.close();
	}

	

}
