import java.time.LocalTime;

public class HourHand extends ClockHand {
    private double angle = 0.0;

    @Override
    public void setTime(LocalTime ltime) {
        int hour = ltime.getHour() % 12;
        int minute = ltime.getMinute();
        int second = ltime.getSecond();
        // Każda godzina to 30 stopni, każda minuta to 0.5 stopnia, każda sekunda to 1/120 stopnia
        this.angle = hour * 30.0 + minute * 0.5 + second * (0.5 / 60.0);
    }

    @Override
    public String toSvg() {
        int length = 50;
        int strokeWidth = 5;
        String color = "black";
        return String.format(
                "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-%d\" stroke=\"%s\" stroke-width=\"%d\" transform=\"rotate(%.2f)\" />",
                length, color, strokeWidth, angle
        );
    }
}