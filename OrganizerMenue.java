import java.util.Scanner;

public class OrganizerMenue extends StudentExperience {

    public OrganizerMenue(person thisPerson, Scanner scnr) {
        super(thisPerson, scnr);
    }

    @Override
    protected void loop() {
        while (true) {
            System.out.print("\033[H\033[2J"); // this is used to clear the terminal
            System.out.flush();             // this is best practace
            System.out.println("\n═══════════════════════════════════════════════════════════════");
            System.out.println("                    ORGANIZER DASHBOARD");
            System.out.println("═══════════════════════════════════════════════════════════════");
            System.out.println("  [\u001B[36ms\u001B[0m] Join an existing event");
            System.out.println("  [\u001B[36ml\u001B[0m] List your current events");
            System.out.println("  [\u001B[36mn\u001B[0m] Add a new event to a venue");
            System.out.println("  [\u001B[34mq\u001B[0m] Quit to main menu");
            System.out.print("\nYour selection: ");
            
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
        System.out.print("\033[H\033[2J"); // this is used to clear the terminal
        System.out.flush();             // this is best practace
        Event newEvent;
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                     CREATE NEW EVENT");
        System.out.println("═══════════════════════════════════════════════════════════════");

        System.out.print("Enter event's \u001B[36mname\u001B[0m: ");
        eventName = scnr.nextLine();
        System.out.print("Enter the \u001B[36msponsoring department\u001B[0m: ");
        sponcerDepartment = scnr.nextLine();

        System.out.println("\n--- Supervisor Details ---");
        System.out.print("Supervisor \u001B[36mKFUPM ID\u001B[0m: ");
        int sPId = scnr.nextInt();
        scnr.nextLine();
        System.out.print("Supervisor \u001B[36mName\u001B[0m: ");
        String sPName = scnr.nextLine();
        sponcerPerson = new person(sPId, sPName, true);

        System.out.println("\n--- Event Classification ---");
        System.out.println(" [\u001B[34m1\u001B[0m] Sports  [\u001B[34m2\u001B[0m] Social  [\u001B[34m3\u001B[0m] Religious  [\u001B[34m4\u001B[0m] Academic");
        System.out.print("Selection: ");
        eventClassification = scnr.nextLine();

        System.out.println("\n--- Venue Selection ---");
        System.out.print("Use [\u001B[34me\u001B[0m]xisting venue or create [\u001B[34mn\u001B[0m]ew venue? ");
        choice = scnr.next().charAt(0);
        scnr.nextLine();

        if (Character.toLowerCase(choice) == 'e') {
            System.out.println("\nSelect a venue from the list:");
            if (UserInteraction.venueList.isEmpty()) {
                // Initializing default venues if list is empty for demonstration/fallback
                UserInteraction.venueList.add(new Venue("sport", 21, "Main Stadium"));
                UserInteraction.venueList.add(new Venue("lecture", 41, "Building 24 Hall"));
                UserInteraction.venueList.add(new Venue("conference", 211, "Exhibition Center"));
            }

            for (int i = 0; i < UserInteraction.venueList.size(); i++) {
                System.out.println("  [\u001B[36m" + (i + 1) + "\u001B[0m] " + UserInteraction.venueList.get(i).venueName);
            }
            System.out.print("Your choice: ");
            int existingVenuesChoice = scnr.nextInt() - 1; 
            chosenVenue = UserInteraction.venueList.get(existingVenuesChoice).venueName;
            newVenue = UserInteraction.venueList.get(existingVenuesChoice);
            System.out.println("\u001B[34m✔ Venue selected:\u001B[0m " + chosenVenue);
        } else if (Character.toLowerCase(choice) == 'n') {
            String venueName;
            System.out.print("New venue \u001B[36mname\u001B[0m: ");
            venueName = scnr.nextLine();
            System.out.print("Max \u001B[36mcapacity\u001B[0m: ");
            int maxCapacity = scnr.nextInt();
            System.out.println("\nVenue Classification:");
            System.out.println(" [\u001B[34m1\u001B[0m] Sports  [\u001B[34m2\u001B[0m] Lecture  [\u001B[34m3\u001B[0m] Conference  [\u001B[34m4\u001B[0m] Public");
            System.out.print("Your answer: ");
            int venueTempNum = scnr.nextInt();
            if (venueTempNum == 1) venueClassification = "sport";
            else if (venueTempNum == 2) venueClassification = "lecture";
            else if (venueTempNum == 3) venueClassification = "conference";
            else venueClassification = "public";

            newVenue = new Venue(venueClassification, maxCapacity, venueName);
            
            for (int i = 0; i < UserInteraction.venueList.size(); i++) {
                if (UserInteraction.venueList.get(i).venueName.equals(newVenue.venueName)) {
                    dupeCheck = true;
                } 
            }
            if (!dupeCheck) {
                UserInteraction.venueList.add(newVenue);
                chosenVenue = newVenue.venueName;
                System.out.println("\u001B[34m✔ New venue added and selected.\u001B[0m");
            }
        }
        
        System.out.println("\n--- Event Timing ---");
        System.out.println("(Please enter numerical values)");
        System.out.println("\u001B[36mSTART DATE:\u001B[0m");
        System.out.print("  Year: "); sYear = scnr.nextInt();
        System.out.print("  Month: "); sMonth = scnr.nextInt();
        System.out.print("  Day: "); sDay = scnr.nextInt();
        System.out.print("  Hour: "); sHour = scnr.nextInt();
        System.out.print("  Min: "); sMinute = scnr.nextInt();

        System.out.println("\u001B[36mEND DATE:\u001B[0m");
        System.out.print("  Year: "); eYear = scnr.nextInt();
        System.out.print("  Month: "); eMonth = scnr.nextInt();
        System.out.print("  Day: "); eDay = scnr.nextInt();
        System.out.print("  Hour: "); eHour = scnr.nextInt();
        System.out.print("  Min: "); eMinute = scnr.nextInt();
        
        int[] sDate =  {sYear, sMonth, sDay};
        int[] sTime =  {sHour, sMinute};
        startTime = new Time(sDate,sTime);

        int[] eDate =  {eYear, eMonth, eDay};
        int[] eTime =  {eHour, eMinute};
        endTime = new Time(eDate,eTime);
        // ----------this check if start time is smaller than end time ---------------
        if(OverlapChecker.checkOverlap(startTime, endTime){throw Exception("Start time is bigger than end time");}


        // this check for overlap in the same venue
        newEvent = new Event(startTime, endTime, eventName, sponcerDepartment, sponcerPerson, eventClassification);
        Event overlapEvent = newVenue.add(newEvent, thisPerson);
        if(overlapEvent != null){throw Exception("Overlap with" + overlapEvent.getName()); } 
        System.out.println("\n\u001B[34m✔ Event '" + eventName + "' added successfully!\u001B[0m");
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("\nPress \u001B[36mENTER\u001B[0m to continue...");
        scnr.nextLine();
        scnr.nextLine();
        break;
        }
        catch(Exception e){
            System.out.println("\n\u001B[31m(!) Invalid entry or error. " + e.message() + ".\u001B[0m");
            System.out.println("Press \u001B[36mENTER\u001B[0m to continue...");
            scnr.nextLine();
            scnr.nextLine();
        }
        scnr.nextLine();
        }


            
    }
}
