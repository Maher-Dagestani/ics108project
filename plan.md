
# class events:

### variables (make them private for capsulation & high mark)


- name
- int[] list start time (should contain hours based on 24h system and minutes, e.g. {23,30})
- int[] list start date (should {2026,5,23})
- end date (same format of start date)
- end time (same format of start time)
- classification (e.g. sprots, social, religiosm, acadimic)
- sponcer (the department which organized the event)
- sponcer (the person organizing the event)

### functions:
- get functions:
    neccesary to acsess the varuables, create one for each variable (e.g. getName, getStartDate, etc..)
- public function overlap:
  takes another event as argument, check for overlap in time, return true if thier is and false if not
- constructure
- setTime to change start/end time/date

-------------------------------------------------------

# abstract class venue:
### variables (keep them all private)
- venue name
- venue type (A venue is either a sports
area (such as an athletic field), a lecture hall, a conference hall, or a public space.)
- max capacity
- events arraylist


### functions:
- create constucter
- add function to add an event into the list:
- which first check for any overlap in events arraylist and if thier is no it add the event if their is overlap it prompt the user to change the time
--------------
# extended classes:
for the following, just extend the class venue:
- make class sportsArea
- make class lectureHall
- make class  a conferenceHall
- make class publicSpace. 


--------------------------
## class main:



- should contain the main loop (user can exit by typing q)
-where all the venues are stored in an array list


### functions:
- add basic functions to create newevents and add them to the arraylist in the right venue class
- add function to print the events
 
### also...
make it consule app and make the output pretty...


----------------------------------------------------------
# important:
- comment your code, always write some short comments explaining what you made and update the readme!
- no ai! code yourself
- follow the object oriented principles (Encapsulation, Abstraction, Inheritance, and Polymorphism)
