import java.util.Scanner;
import java.util.ArrayList;


public class StudentExperience {
    person thisPerson;
    String eventName;
    String sponcerDepartment;
    person sponcerPerson;
    String eventClassification;
    char choice;
    String venueClassification;
    boolean dupeCheck = false;
    String chosenVenue;
    Venue newVenue;
    Time startTime;
    Time endTime;
    
    int sYear;
    int sMonth;
    int sDay;
    int sHour;
    int sMinute;

    int eYear;
    int eMonth;
    int eDay;
    int eHour;
    int eMinute;

    person personTest;
    Scanner scnr;
    public StudentExperience(person thisPerson, Scanner scnr) {
        this.personTest = thisPerson;
        this.thisPerson = thisPerson;
	this.scnr = scnr;
	loop();
    }
    
//   =---------- this make user join events --------=
    public void joinEventExperience(Scanner scnr, person thisPerson) {

        System.out.print("\033[H\033[2J"); // this is used to clear the terminal
        System.out.flush();             // this is best practace
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                     AVAILABLE EVENTS");
        System.out.println("═══════════════════════════════════════════════════════════════");
        for (Venue x : UserInteraction.venueList) {
            System.out.println("\n📍 Venue: \u001B[36m" + x.getName() + "\u001B[0m");
            System.out.println("  ─────────────────────────────────────────────────────────────");
            if (x.getEvents().isEmpty()) {
                System.out.println("     (No events scheduled at this venue)");
            }
            for (Event y : x.getEvents()) {
                System.out.println("  • Event: \u001B[34m" + String.format("%-20s", y.getName()) + "\u001B[0m | Date: " + y.getStartTime());
            }
        }
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.print("\nChoose an event (enter the \u001B[36mexact name\u001B[0m): ");
        String chosenEventName = scnr.next();
        chosenEventName += scnr.nextLine();

        boolean found = false;
        for (int i = 0; i < UserInteraction.venueList.size(); i++) {
            for (int j = 0; j < UserInteraction.venueList.get(i).getEvents().size(); j++) {
                if (UserInteraction.venueList.get(i).getEvents().get(j).getName().equalsIgnoreCase(chosenEventName.trim())) {
                    thisPerson.addEvent(UserInteraction.venueList.get(i).getEvents().get(j));
                    System.out.println("\u001B[34m✔ Successfully joined:\u001B[0m " + chosenEventName);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("\u001B[31m(!) Event not found. Please check the name and try again.\u001B[0m");
        }
        System.out.println("\nPress \u001B[36mENTER\u001B[0m to continue...");
        scnr.nextLine();
    }

// print current user ecvents
public void list(Scanner scnr, person thisPerson){
   ArrayList<Event> theList = thisPerson.getEvents();
    System.out.print("\033[H\033[2J"); // this is used to clear the terminal
    System.out.flush();             // this is best practace
    System.out.println("\n═══════════════════════════════════════════════════════════════");
    System.out.println("                      YOUR EVENTS");
    System.out.println("═══════════════════════════════════════════════════════════════");
    if(theList.size() == 0) {
        System.out.println("\u001B[31m(i) You haven't joined any events yet!\u001B[0m");
    } else {
        for (Event x : theList) {
            System.out.println("  • \u001B[34m" + x.getName() + "\u001B[0m");
        }
    }
    System.out.println("───────────────────────────────────────────────────────────────");
    System.out.println("\nPress \u001B[36mENTER\u001B[0m to continue...");
    scnr.nextLine();
    scnr.nextLine();
}
     protected void loop(){

        
	while(true){
		try{
	System.out.print("\033[H\033[2J"); // this is used to clear the terminal
	System.out.flush();             // this is best practace
	System.out.println("\n═══════════════════════════════════════════════════════════════");
	System.out.println("                     STUDENT DASHBOARD");
	System.out.println("═══════════════════════════════════════════════════════════════");
	System.out.println("  [\u001B[36ms\u001B[0m] Join a new event");
	System.out.println("  [\u001B[36ml\u001B[0m] List your current events");
	System.out.println("  [\u001B[34mq\u001B[0m] Quit to main menu");
	System.out.print("\nYour selection: ");
        
        choice = scnr.next().charAt(0);
        if (Character.toLowerCase(choice) == 's') {
            joinEventExperience(scnr, thisPerson);
        } else if (Character.toLowerCase(choice) == 'l') {
            list(scnr, thisPerson);
        } else if (Character.toLowerCase(choice) == 'q') {
            break;
        }
		}
		catch(Exception e){System.out.println("\n\u001B[31m(!) Unrecognized input, please try again.\u001B[0m");}
        }

     }
    
}

