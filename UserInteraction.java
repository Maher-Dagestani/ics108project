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
        System.out.print("Enter your KFUPM ID (numbers only): ");
        id = scnr.nextInt();
        scnr.nextLine();
        System.out.print("Enter your Name: ");
        userName = scnr.nextLine();
        System.out.print("Enter \"s\" if you are a student or enter \"o\" if you are an organizer:");
        sOrO = scnr.next().charAt(0);

        if (Character.toLowerCase(sOrO) == 's') {
            isOrganizer = false;
        } else if (Character.toLowerCase(sOrO) == 'o') {
            isOrganizer = true;
        }
        thisPerson = new person(id, userName, isOrganizer);
    }
	public person getUser(){
		return this.thisPerson;
    }

}
