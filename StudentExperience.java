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

        System.out.print("Available events: ");
        System.out.println("Choose an event (enter the event's name): ");
        for (Venue x:UserInteraction.venueList) {
            System.out.println("Venue: " + x.getName());
            for (Event y:x.getEvents()){
                System.out.println(" Event name: "  + y.getName() + " --- event date: " + y.getStartTime());
            }
        }
        System.out.print("Your choice: ");
        String chosenEventName = scnr.next();
	chosenEventName = scnr.nextLine();


        // ----------------------- this need testing/ it should add the event into the user events. 
        for (int i = 0; i < UserInteraction.venueList.size(); i++) {
            for (int j = 0; j < UserInteraction.venueList.get(i).getEvents().size(); j++) {
                if (UserInteraction.venueList.get(i).getEvents().get(j).getName().equals(chosenEventName)) {
                    thisPerson.addEvent(UserInteraction.venueList.get(i).getEvents().get(j));
                }
            }
        }




    }

// print current user ecvents
public void list(Scanner scnr, person thisPerson){
   ArrayList<Event> theList = thisPerson.getEvents();
    if(theList.size() == 0){System.out.println("you didnt join any events yet!");}
    else{
    for (Event x:theList) {
            System.out.println(x.getName());
        }
    }

}
     protected void loop(){

        
	while(true){
	System.out.println("Greetings, student. Enter \"s\" to join event. \"l\" to see your current events, \"q\" to quit");
        
        choice = scnr.next().charAt(0);
        if (Character.toLowerCase(choice) == 's') {
            joinEventExperience(scnr, thisPerson);
        }

        if (Character.toLowerCase(choice) == 'l') {
            list(scnr, thisPerson);
        }
	if (Character.toLowerCase(choice) == 'q') {
            break;
        }
        }

     }
    
}

