import java.util.ArrayList;

public class OverlapChecker {


 public Event checkOverlap(Event event, ArrayList<Event> events){
     for(Event x:events){
        if(event.overlap(x) == true){
            return x;
        }
     }
     return null;
    }
}
