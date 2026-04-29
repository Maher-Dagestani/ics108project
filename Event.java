//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Event{

    //all values are private for capsulation princeple

    private String name;
    private Time startTime;
    private Time endTime;
    private String classification;
    private person sponcerPerson;
    private Venue sponcerDepartment;




    //-----------getter functions---------------
    public String getName() { return name; }
    public String getStartTime() { return startTime.toString(); }
    public String getEndTime() { return endTime.toString(); }
    public String getClassification() { return classification; }
    public person getSponcerPerson() { return sponcerPerson; }
    public Venue getSponcerDepartment() { return sponcerDepartment; }




    //------------------check for overlap -------------------------------
    public boolean overlap(Event event2){
        // their is no overlap if Event1 ends before Event2 starts, OR
        //Event1 starts after Event2 ends while
        // they DO NOT START AND END at same time
        int ev1end_ev2start   = this.endTime.compareTime(event2.startTime);
        int ev1start_ev2end   = this.startTime.compareTime(event2.endTime);
        int ev1start_ev2start = this.startTime.compareTime(event2.startTime);
        int ev1end_ev2end     = this.endTime.compareTime(event2.endTime);
        if (ev1end_ev2start <= 0 || ev1start_ev2end >= 0 ){
            if(ev1end_ev2end == 0 && ev1start_ev2start == 0) { //in case they are same time then OVERLAPING
                return true;
            }
            else{
                return false;}
            }
        else return true;
    }




    //-------------------------constructure--------------------------------
    public Event(Time startTime, Time endTime,
                 String name, Venue sponcerDepartment, person sponcer, String classification){

        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.sponcerDepartment = sponcerDepartment;
        this.sponcerPerson = sponcer;
        this.classification = classification;

    }



}
