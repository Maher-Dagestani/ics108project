import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //--------------------- display start message ---------------------
        PrintStartMessage.printStartMessage();
        
        //--------------------- initialize user interaction ---------------------
        Scanner scnr = new Scanner(System.in);
        person user;
        UserInteraction start = new UserInteraction(scnr);
        user = start.getUser();

        //--------------------- load existing data ---------------------
        Database.load(user);

        //--------------------- check user permissions ---------------------
        if (user.checkPermission()){
            new OrganizerMenue(user, scnr);
        }
        else{
            new StudentExperience(user, scnr);
        }

        //--------------------- save data on exit ---------------------
        Database.save(user, UserInteraction.venueList);
    }
}
