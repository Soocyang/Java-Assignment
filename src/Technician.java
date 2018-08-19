import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Technician {
    private static int ID = 0; //Increment by one
    private String technicianID; //Auto Generated from ID above
    private Name technicianName;
    private int serviceHandle;

    public Technician(Name technicianName, int serviceHandle) {
        this.technicianID = String.format("T%04d", ++ID);
        this.technicianName = technicianName;
        this.serviceHandle = serviceHandle;
    }

    public String toFile() {
        return technicianID + "," + technicianName.toFile() + "," + serviceHandle + "\n";
    }

    @Override
    public String toString() {
        String[] service = {"Maintenance", "Repair", "Repaint", "Wax and Polish"};
        return "Technician ID          = " + technicianID + '\n' +
                "Technician Name        = " + technicianName + '\n' +
                "Service Handle         = " + service[serviceHandle - 1] + '\n';
    }

    static void readFile(ArrayList<Technician> technician) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data/technicianInfo.csv"));
        String string;
        Scanner sc;
        while ((string = br.readLine()) != null) {
            sc = new Scanner(string).useDelimiter("\\s*,\\s*");
            sc.next(); //Ignoring the first field which contains TechnicianID.
            technician.add(new Technician(new Name(sc.next(), sc.next()), sc.nextInt()));
        }
        br.close();
    }
}