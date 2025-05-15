public class DigitalClock extends Clock{

    private ClockVersion version;
    private String toString;
    public DigitalClock(int hour, int minutes, int seconds,City city,ClockVersion version) {
        super(hour, minutes, seconds,city);
        this.version=version;
    }

    enum ClockVersion{
        EnglishClock,//12
        EuropeanClock;//24
    };

    public String ToStringDigital(){
        if(version==ClockVersion.EuropeanClock){
           return super.ToStringClock();
        }
        else{
            if(hour>12) {
                toString =(hour-12)+":"+String.format("%02d",minutes)+":"+String.format("%02d",seconds)+" PM";

            }
            else {
                 toString =hour+":"+String.format("%02d",minutes)+":"+String.format("%02d",seconds)+" AM";
            }
            return toString;
        }
    };


}
