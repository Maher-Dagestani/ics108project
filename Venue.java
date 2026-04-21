import java.util.ArrayList;



/* to use the code:
first make new venue using "new Venue("string classification")

to add new event:
1- first create startaTime and endTime using new Time(int[] date, int[] time)
    example new Time({2026,5,5}, {9, 30})

2-create event by new Event( startTime,  endTime, name,  sponcerDepartment,  sponcerPerson,  classification)
3- check for overlap using venue.checkOverlap(event)
    this return null if thier is no overlap and if thier is overlap it return the overlaping event

4- add evet using venue.add(event)


------------------------------------------------------------------------------------------------------------
other functionalities:
venue.delete(event) to remove event
venue.getEvents() return an arraylist full of the events in the venue

-----using the event---
 * event.getName()              returns the event name
 * event.getStartTime()         returns start time as String
 * event.getEndTime()           returns end time as String
 * event.getClassification()    returns the classification
 * event.getSponcerPerson()     returns the sponcer person name
 * event.getSponcerDepartment() returns the sponcer department name



this code (venue) + Event + Time is written by 𝔐𝔞𝔥𝔢𝔯 𝔇𝔞𝔤𝔢𝔰𝔱𝔞𝔫𝔦*/

public class Venue {
    private String name;
    private String type;
    private int maxCapacity;
    private ArrayList<Event> events;
    private String classification;

    public Venue(String classification){
        this.classification = classification;
    }


    public Event checkOverlap(Event event){
        // this check for overlap before adding
        for(Event x:events){
            if(event.overlap(x) == true){
                 return x;
            }
        }
        return null;
    }
    public void add(Event event){
        events.add(event);
    }
    public void delete(Event event){
        events.remove(event);
    }
    public ArrayList<Event> getEvents(){
        return this.events;
    }

}
