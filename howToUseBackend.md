

# to use the backend code:


## for organizers
----------------------------------------
you can create a new user profile using:
    new person(int id, String name, boolean isOrganizer)
    PLS NOTE: making isOrganizer true allow user to create new events

then you need to create a Venue (or use existing ones)
    new Venue(String classification, int maxCapacity )

now to create an event you should first create startaTime and endTime using
    new Time(int[] date, int[] time)
    example new Time({2026,5,5}, {9, 30})


2-create event by
    new Event(Time startTime, Time endTime, String name, Venue sponcerDepartment, person sponcer, String classification)


4- add evet using venue.add(event, person), note this return null if added sucsessfully and return an event of which their
  is overlap with in case of overlap without adding the event to the storage, also person should have isOrganizer to add sucsessfully

  IMPORTANT: if user is not organizer he shouldnt even see this oprion in the main!!

## for not organizers
 --------------------------------------------
 now not organizers can participate in events by using
      person.addEvent(Event event)
   which return null if added sucsessfully and return an event that overlap withen the user schedual (and
   that indecate the ecent was not added sucsessfully)

and can also check the events a user participating in using:
person.getEvents()


------------------------------------------------------------------------------------------------------------
## other functionalities:


### using person
---------
  person.getId() return id as int
  person.getName() return name as string
  person. checkPermission() return true if user is organizer and false if not

### using venue
-------------------
venue.delete(event, person) to remove event (also check for permission first)
venue.getEvents() return an arraylist full of the events in the venue


### for events
--------
 * event.getName()              returns the event name
 * event.getStartTime()         returns start time as String
 * event.getEndTime()           returns end time as String
 * event.getClassification()    returns the classification
 * event.getSponcerPerson()     returns the sponcer person name
 * event.getSponcerDepartment() returns the sponcer department name



this code (venue) + Event + Time + person + OverlapChecker  is written by 𝔐𝔞𝔥𝔢𝔯 𝔇𝔞𝔤𝔢𝔰𝔱𝔞𝔫𝔦
