import java.util.ArrayList;

public class Venue {
    private String name;
    private String type;
    private String venueName;
    private int maxCapacity;
    private ArrayList<Event> events;
    private String classification;

    public Venue(String classification, int maxCapacity, String venueName){
        this.maxCapacity = maxCapacity;
        this.classification = classification;
        this.venueName = venueName;
        this.events = new ArrayList<>();
    }


    public Event checkOverlap(Event event){
        // this check for overlap before adding

        OverlapChecker overlap = new OverlapChecker();
        return overlap.checkOverlap(event, events);
    }
    public Event add(Event event, person person){

        Event overlap = checkOverlap(event);
        if (overlap == null && person.checkPermission()) { //this check for overlap and makes sure user is organizer
            events.add(event);
        }
        return overlap;
    }
    public void delete(Event event, person person){
        if(person.checkPermission()) {
            events.remove(event);
        }
    }
    public ArrayList<Event> getEvents(){
        return this.events;
    }

}
