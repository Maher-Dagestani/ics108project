import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        person user;
        Scanner scnr = new Scanner(System.in);
        UserInteraction start = new UserInteraction(scnr);
        user = start.getUser();

        Database.load(user);

        if (user.checkPermission()){
            new OrganizerMenue(user, scnr);
        }
        else{
            new StudentExperience(user, scnr);
        }

        Database.save(user, UserInteraction.venueList);
    }
}
