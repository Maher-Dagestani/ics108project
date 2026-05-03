import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {
    private int id;
    private String userName;
    private boolean isOrganizer;
    char sOrO;
    person thisPerson;
    public static ArrayList<Venue> venueList = new ArrayList<>();
    
    public UserInteraction(Scanner scnr) {
		while(true){
			try{
        System.out.print("\033[H\033[2J"); // this is used to clear the terminal
        System.out.flush();             // this is best practace
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                 Welcome to the Event Manager");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.print("Please enter your \u001B[36mKFUPM ID\u001B[0m (numbers only): ");
        id = scnr.nextInt();
        scnr.nextLine();
        System.out.print("Please enter your \u001B[36mName\u001B[0m: ");
        userName = scnr.nextLine();
        System.out.print("Enter '\u001B[34ms\u001B[0m' for Student or '\u001B[34mo\u001B[0m' for Organizer: ");
        sOrO = scnr.next().charAt(0);

        if (Character.toLowerCase(sOrO) == 's') {
            isOrganizer = false;
        } else if (Character.toLowerCase(sOrO) == 'o') {
            isOrganizer = true;
        }
        thisPerson = new person(id, userName, isOrganizer);
        System.out.println("───────────────────────────────────────────────────────────────");
        break;
    }
        catch(Exception e){
            System.out.println("\n\u001B[31m(!) Invalid data entry. Please try again.\u001B[0m");
            System.out.println("Press \u001B[36mENTER\u001B[0m to continue...");
            scnr.nextLine(); // Clear buffer
            scnr.nextLine(); // Wait for input
        }
		
}
    }
	public person getUser(){
		return this.thisPerson;
        }
	

}
