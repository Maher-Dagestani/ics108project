import java.util.Scanner;

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
    
    public StudentExperience(person thisPerson, Scanner scnr) {
        this.personTest = thisPerson;
        this.thisPerson = thisPerson;
        System.out.print("Greetings, student. Enter \"s\" to see and join available events): ");
        choice = scnr.next().charAt(0);
        if (Character.toLowerCase(choice) == 's') {
            joinEventExperience(scnr, thisPerson);
        }
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

