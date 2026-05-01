// import java.util.ArrayList;
import java.util.Scanner;
public class OrganizerExperience {
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
    
    public OrganizerExperience(person thisPerson, Scanner scnr) {
        this.personTest = thisPerson;
        this.thisPerson = thisPerson;
        System.out.print("What do you want to do? (enter \"n\" to add a new event, \"s\" to see available events): ");
        choice = scnr.next().charAt(0);
        if (Character.toLowerCase(choice) == 'n') {
            addEventExperience(scnr, thisPerson);
        } else if (Character.toLowerCase(choice) == 's') {
            joinEventExperience(scnr, thisPerson);
        }
    }
    public void addEventExperience(Scanner scnr, person thisPerson) {
        Event newEvent;

        System.out.print("Enter event's name: ");
        eventName = scnr.nextLine();
        System.out.print("Enter the sponcer department: ");
        sponcerDepartment = scnr.nextLine();

        System.out.printf("\n\n now enter the details of the appointed supervisor from the sponcer department: \n");
        System.out.print("Enter the sponcer person's KFUPM ID: ");
        int sPId = scnr.nextInt();
        scnr.nextLine();
        System.out.print("Enter the sponcer person's name: ");
        String sPName = scnr.nextLine();
        sponcerPerson = new person(sPId, sPName, true);
        System.out.printf("\n\nEnter the event's classification\nEnter \"1\" if the event is sports\nEnter \"2\" if the event is social\nEnter \"3\" if the event is religious\nEnter \"4\" if the event is academic");
        eventClassification = scnr.nextLine();
        System.out.print("Choose from already existing venues (enter \"e\") or create new venue (enter \"n\"): ");
        choice = scnr.next().charAt(0);
        scnr.nextLine();
        if (Character.toLowerCase(choice) == 'e') {
            System.out.println("Choose from the following venues (please enter the ID as an integer, not the venue's name):");
            Venue venue1 = new Venue("sport", 21, "venue1");
            Venue venue2 = new Venue("lecture", 41, "venue2");
            Venue venue3 = new Venue("conference", 211, "venue3");
            Venue venue4 = new Venue("public", 234, "venue4");
            UserInteraction.venueList.add(venue1);
            UserInteraction.venueList.add(venue2);
            UserInteraction.venueList.add(venue3);
            UserInteraction.venueList.add(venue4);

            // int i;
            for (int i = 0; i < UserInteraction.venueList.size(); i++) {
                System.out.println("ID = " + (i + 1) + " --- Venue's name: " + UserInteraction.venueList.get(i).venueName);
            }
            System.out.print("Your choice: ");
            int existingVenuesChoice = scnr.nextInt();
            chosenVenue = UserInteraction.venueList.get(existingVenuesChoice).venueName;
            newVenue = UserInteraction.venueList.get(existingVenuesChoice);
            System.out.printf("\n\nSuccessfully chosen venue: " + chosenVenue + "\n\n");
        } else if (Character.toLowerCase(choice) == 'n') {
            String venueName;
            System.out.print("Enter the venue's name: ");
            venueName = scnr.nextLine();
            System.out.print("Enter max capacity (integers only): ");
            int maxCapacity = scnr.nextInt();
            System.out.printf("\nChoose venue classification:\nEnter \"1\" if the venue is a sports area\nEnter \"2\" if the venue is a lecture hall\nEnter \"3\" if the venue is a conference hall\nEnter \"4\" if the venue is a public space ");
            System.out.printf("\nYour answer: ");
            int venueTempNum = scnr.nextInt();
            if (venueTempNum == 1) {
                venueClassification = "sport";
            } else if (venueTempNum == 2) {
                venueClassification = "lecture";
            } else if (venueTempNum == 3) {
                venueClassification = "conference";
            } else if (venueTempNum == 4) {
                venueClassification = "public";
            }
            newVenue = new Venue(venueClassification, maxCapacity, venueName);
            
            for (int i = 0; i < UserInteraction.venueList.size(); i++) {
                if (UserInteraction.venueList.get(i).venueName == newVenue.venueName) {
                    dupeCheck = true;
                } 
            }
            if (dupeCheck == false) {
                UserInteraction.venueList.add(newVenue);
                chosenVenue = newVenue.venueName;
                System.out.println("New venue added successfully, and it has been chosen for your event, please continue: ");
            }
        }
        // getting start and end date and time
        System.out.printf("\n\n\n\nNow you need enter the start and end date of the event (all your answers should be entered as an a number): \n");
        System.out.println("Firstly, we will begin with the event's start date: ");
        System.out.print("Enter year (2000 - present): ");
        sYear = scnr.nextInt();
        System.out.print("Enter month (1 - 12): ");
        sMonth = scnr.nextInt();
        System.out.print("Enter day (make sure the day exists in the month and is entered as an integer): ");
        sDay = scnr.nextInt();
        System.out.print("Enter hour (24-hour system, 0 - 24): ");
        sHour = scnr.nextInt();
        System.out.print("Enter minute (0 - 60): ");
        sMinute = scnr.nextInt();

        System.out.printf("\n\n\n\nNow enter the event's end date: \n");
        System.out.print("Enter year (2000 - present): ");
        eYear = scnr.nextInt();
        System.out.print("Enter month (1 - 12): ");
        eMonth = scnr.nextInt();
        System.out.print("Enter day (make sure the day exists in the month and is entered as an integer): ");
        eDay = scnr.nextInt();
        System.out.print("Enter hour (24-hour system, 0 - 24): ");
        eHour = scnr.nextInt();
        System.out.print("Enter minute (0 - 60): ");
        eMinute = scnr.nextInt();
        int[] sDate =  {sYear, sMonth, sDay};
        int[] sTime =  {sHour, sMinute};
        startTime = new Time(sDate,sTime);

        int[] eDate =  {eYear, eMonth, eDay};
        int[] eTime =  {eHour, eMinute};
        endTime = new Time(eDate,eTime);

        newEvent = new Event(startTime, endTime, eventName, sponcerDepartment, sponcerPerson, eventClassification);
        newVenue.add(newEvent, thisPerson);
        System.out.printf("Event added successfully.");
    }
    public void joinEventExperience(Scanner scnr, person thisPerson) {
        Venue venue1 = new Venue("sport", 21, "venue1");
        Venue venue2 = new Venue("lecture", 41, "venue2");
        Venue venue3 = new Venue("conference", 211, "venue3");
        Venue venue4 = new Venue("public", 234, "venue4");
        UserInteraction.venueList.add(venue1);
        UserInteraction.venueList.add(venue2);
        UserInteraction.venueList.add(venue3);
        UserInteraction.venueList.add(venue4);

        System.out.print("Available events: ");
        Event event1 = new Event(startTime, endTime, "sndkfnjkdsf", sponcerDepartment, personTest, eventClassification);
        Event event2 = new Event(startTime, endTime, "eventName", sponcerDepartment, personTest, eventClassification);
        venue1.add(event1, personTest);
        venue3.add(event2, personTest);
        System.out.println("Choose an event (enter the event's name): ");
        for (Venue x:UserInteraction.venueList) {
            System.out.println("Venue: " + x.getName());
            for (Event y:x.getEvents()){
                System.out.println(" Event name: "  + y.getName() + " --- event date: " + y.getStartTime());
            }
        }
        System.out.print("Your choice: ");
        String chosenEventName = scnr.nextLine();
        for (int i = 0; i < UserInteraction.venueList.size(); i++) {
            for (int j = 0; j < UserInteraction.venueList.get(i).getEvents().size(); j++) {
                if (UserInteraction.venueList.get(i).getEvents().get(j).getName() == chosenEventName) {
                    thisPerson.addEvent(UserInteraction.venueList.get(i).getEvents().get(j));
                }
            }
        }
    }
}
