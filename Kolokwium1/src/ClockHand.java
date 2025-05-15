import java.time.LocalTime;

public abstract class ClockHand {
    public abstract void setTime(LocalTime ltime);
    public abstract String toSvg();
}
