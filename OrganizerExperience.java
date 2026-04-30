// import java.util.ArrayList;
import java.util.Scanner;
public class OrganizerExperience {    
    char choice;
    
    public OrganizerExperience(person thisPerson, Scanner scnr) {
        System.out.print("What do you want to do? (enter \"n\" to add a new event, \"s\" to see available events): ");
        choice = scnr.next().charAt(0);
        if (Character.toLowerCase(choice) == 'n') {
            addEventExperience(scnr);
        } else if (Character.toLowerCase(choice) == 's') {
            seeEventExperience(scnr);
        }
    }
    public void addEventExperience(Scanner scnr) {
        System.out.print("Choose from already existing venues (enter \"e\") or create new venue (enter \"n\"): ");
        choice = scnr.next().charAt(0);
        scnr.nextLine();
        if (Character.toLowerCase(choice) == 'e') {

        } else if (Character.toLowerCase(choice) == 'n') {
            String venueName;
            System.out.print("Enter the venue's name: ");
            venueName = scnr.nextLine();
            System.out.print("Enter max capacity (integers only): ");
            int maxCapacity = scnr.nextInt();
            System.out.printf("\nChoose venue classification:\nEnter \"1\" if the venue is a sports area\nEnter \"2\" if the venue is a lecture hall\nEnter \"3\" if the venue is a conference hall\nEnter \"4\" if the venue is a public space ");
            int venueTempNum = scnr.nextInt();
        }
    }
    public void seeEventExperience(Scanner scnr) {

    }
}
