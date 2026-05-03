import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Database {
    private static final String FILE_NAME = "database.txt";

    public static void save(person user, ArrayList<Venue> venues) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(venues.size() + "\n");
            
            for (Venue v : venues) {
                writer.write(v.getName() + "\n");
                writer.write(v.getMaxCapacity() + "\n");
                writer.write(v.getClassification() + "\n");
                
                ArrayList<Event> events = v.getEvents();
                writer.write(events.size() + "\n");
                for (Event e : events) {
                    writer.write(e.getName() + "\n");
                    writer.write(e.getSponcerDepartment() + "\n");
                    writer.write(e.getClassification() + "\n");
                    
                    Time startTime = e.getStartTimeObj();
                    Time endTime = e.getEndTimeObj();

                    writer.write(startTime.getDate()[0] + " " + startTime.getDate()[1] + " " + startTime.getDate()[2] + "\n");
                    writer.write(startTime.getHour()[0] + " " + startTime.getHour()[1] + "\n");
                    writer.write(endTime.getDate()[0] + " " + endTime.getDate()[1] + " " + endTime.getDate()[2] + "\n");
                    writer.write(endTime.getHour()[0] + " " + endTime.getHour()[1] + "\n");

                    writer.write(e.getSponcerPerson().getId() + "\n");
                    writer.write(e.getSponcerPerson().getName() + "\n");
                }
            }
            
            ArrayList<Event> userEvents = user.getEvents();
            writer.write(userEvents.size() + "\n");
            for (Event ue : userEvents) {
                writer.write(ue.getName() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("\n\u001B[31m(!) Data Save Error:\u001B[0m " + e.getMessage());
        }
    }

    public static void load(person user) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            Scanner reader = new Scanner(new FileInputStream(file));
            UserInteraction.venueList.clear();

            int venueCount = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < venueCount; i++) {
                String vName = reader.nextLine();
                int vCap = Integer.parseInt(reader.nextLine());
                String vClass = reader.nextLine();
                Venue v = new Venue(vClass, vCap, vName);
                
                int eventCount = Integer.parseInt(reader.nextLine());
                for (int j = 0; j < eventCount; j++) {
                    String eName = reader.nextLine();
                    String eDept = reader.nextLine();
                    String eClass = reader.nextLine();
                    
                    String[] d1 = reader.nextLine().split(" ");
                    String[] t1 = reader.nextLine().split(" ");
                    Time start = new Time(new int[]{Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer.parseInt(d1[2])}, 
                                         new int[]{Integer.parseInt(t1[0]), Integer.parseInt(t1[1])});
                    
                    String[] d2 = reader.nextLine().split(" ");
                    String[] t2 = reader.nextLine().split(" ");
                    Time end = new Time(new int[]{Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer.parseInt(d2[2])}, 
                                       new int[]{Integer.parseInt(t2[0]), Integer.parseInt(t2[1])});
                    
                    int spId = Integer.parseInt(reader.nextLine());
                    String spName = reader.nextLine();
                    person sponsor = new person(spId, spName, true);
                    
                    Event ev = new Event(start, end, eName, eDept, sponsor, eClass);
                    v.add(ev, sponsor);
                }
                UserInteraction.venueList.add(v);
            }

            int enrolledCount = Integer.parseInt(reader.nextLine());
            for (int k = 0; k < enrolledCount; k++) {
                String targetName = reader.nextLine();
                for (Venue v : UserInteraction.venueList) {
                    for (Event e : v.getEvents()) {
                        if (e.getName().equals(targetName)) {
                            user.addEvent(e);
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("\n\u001B[31m(i) Starting fresh session (data not found or reset).\u001B[0m");
        }
    }
}
