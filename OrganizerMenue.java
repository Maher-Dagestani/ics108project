import java.util.Scanner;

public class OrganizerMenue extends StudentExperience {

    public OrganizerMenue(person thisPerson, Scanner scnr) {
        super(thisPerson, scnr);
    }

    @Override
    protected void loop() {
        while (true) {
            System.out.println("Greetings, Organizer. Enter \"s\" to join event, \"l\" to see your events, \"n\" to add new event, \"q\" to quit");
            
            choice = scnr.next().charAt(0);
            scnr.nextLine(); // clear buffer

            if (Character.toLowerCase(choice) == 's') {
                joinEventExperience(scnr, thisPerson);
            } else if (Character.toLowerCase(choice) == 'l') {
                list(scnr, thisPerson);
            } else if (Character.toLowerCase(choice) == 'n') {
                addEventExperience(scnr, thisPerson);
            } else if (Character.toLowerCase(choice) == 'q') {
                break;
            }
        }
    }

    public void addEventExperience(Scanner scnr, person thisPerson) {
        while(true){
        try{
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

            for (int i = 0; i < UserInteraction.venueList.size(); i++) {
                System.out.println("ID = " + (i + 1) + " --- Venue's name: " + UserInteraction.venueList.get(i).venueName);
            }
            System.out.print("Your choice: ");
            int existingVenuesChoice = scnr.nextInt() - 1; 
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
                if (UserInteraction.venueList.get(i).venueName.equals(newVenue.venueName)) {
                    dupeCheck = true;
                } 
            }
            if (dupeCheck == false) {
                UserInteraction.venueList.add(newVenue);
                chosenVenue = newVenue.venueName;
                System.out.println("New venue added successfully, and it has been chosen for your event, please continue: ");
            }
        }
        
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
        System.out.printf("Event added successfully.\n");
        break;
        }
        catch(Exception e){System.out.println("wrong input!! try again!");}
        scnr.nextLine();
        }


            
    }
}
