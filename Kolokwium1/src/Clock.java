import java.time.LocalDate;
import java.time.LocalTime;

public class Clock {
    int hour;
    int minutes;
    int seconds;
    private City city;
    public Clock(int hour, int minutes, int seconds,City city) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
        this.city=city;
        setTime();
    }
    public void SetCity(City city){
        if(this.city.getTimeZone()<city.getTimeZone()){
            int add=this.city.getTimeZone()-city.getTimeZone();
            System.out.println(add);
            this.hour=this.hour+add;
        }
        else if(this.city.getTimeZone()>city.getTimeZone()){
            int remove=this.city.getTimeZone()-city.getTimeZone();
            System.out.println(remove);
            this.hour=this.hour-remove;
        }
        this.city=city;
    }

    public void setCurrentTime(){
        LocalTime setCTime=LocalTime.now();
    }
    public void setTime(){
        if (seconds>59){
            throw new IllegalArgumentException("Zmienna seconds nie mieści sie w zakresie 60");
        }
        else if(minutes>59){
            throw new IllegalArgumentException("Zmienna minutes nie mieści sie w zakresie 60");
        }
        else if(hour>23){
            throw new IllegalArgumentException("Zmienna hour nie mieści sie w zakresie 24");
        }
    }

    public String ToStringClock(){
      return String.format("%02d",hour)+":"+String.format("%02d",minutes)+":"+String.format("%02d",seconds);
    };
}
