import java.time.LocalTime;

public class MinuteHand extends ClockHand {
    private double angle = 0.0;

    @Override
    public void setTime(LocalTime ltime) {
        int minute = ltime.getMinute();
        int second = ltime.getSecond();
        // Każda minuta to 6 stopni, każda sekunda to 0.1 stopnia
        this.angle = minute * 6.0 + second * 0.1;
    }

    @Override
    public String toSvg() {
        int length = 70;
        int strokeWidth = 3;
        String color = "blue";
        return String.format(
                "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-%d\" stroke=\"%s\" stroke-width=\"%d\" transform=\"rotate(%.2f)\" />",
                length, color, strokeWidth, angle
        );
    }
}