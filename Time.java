public class Time {
    private int[] date = new int[3];
    private int[] hour = new int[2];

    public Time(int[] date, int[] hour){
        this.date = date;
        this.hour = hour;
    }
    public int[] getDate(){return this.date;}
    public int[] getHour() {return this.hour;}


    //----------------------------compare 2 times---------------------------------------------
    public int compareTime(Time time2){
        int[] date1 = this.getDate();
        int[] date2 = time2.getDate();
        int[] hour1 = this.getHour();
        int[] hour2 = time2.getHour();

        //compare the dates
        for(int i = 0; i < 3; i++){
            if (date1[i] > date2[i]){return 1;}
            else if(date1[i] < date2[i]){return -1;}
        }

        //if dates are equal, compare the hours:
        for(int i = 0; i < 2; i++){
            if(hour1[i] > hour2[i]){return 1;}
            else if(hour1[i] < hour2[i]){return -1;}
        }
        // if all the above are false then they are equal so:
        return 0;
    }







    //----------------------------return time as string----------------------
    public String toString(){
        String timeData = "Date: ";
        for(int i = 0; i < this.getDate().length; i++){
            if (i == 0){timeData = timeData + this.getDate()[i];}
            else{timeData = timeData + "/" + this.getDate();}
        }
        for(int i = 0; i < this.getHour().length; i++){
            if (i == 0){timeData = timeData + "\n time: "+ this.getHour()[i];}
            else{timeData = timeData + ":" + this.getDate();}
        }
        return timeData;

    }
}
