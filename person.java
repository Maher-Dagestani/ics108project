import java.util.ArrayList;

public class person {
    protected int id;
    protected String name;
    protected ArrayList<Event> events;
    protected boolean isOrganizer; // if true then can create/delete new venues/events and edit



    public person(int id, String name, boolean isOrganizer){
        this.id = id;
        this.name = name;
        this.isOrganizer = isOrganizer;
        this.events = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }


    // this calls overlap checker first to make sure student dont add 2 events that overlap into their schedual, and
    //add it if their is no overlap and return the overlaped event if their is overlap without adding event to shcedual
    public Event addEvent(Event event){
            Event overlap = checkOverlap(event);
            if (overlap == null) {
                events.add(event);
            }
            return overlap;
    }



    public boolean checkPermission(){
        return this.isOrganizer;
    }

    public Event checkOverlap(Event event){
        OverlapChecker overlap = new OverlapChecker();
        return overlap.checkOverlap(event, events);
    }


}
