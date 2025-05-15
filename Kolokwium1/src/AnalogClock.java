import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class AnalogClock {
    private LocalTime currentTime = LocalTime.now();
    private final List<ClockHand> hands = Arrays.asList(
            new HourHand(),
            new MinuteHand(),
            new SecondHand()
    );

    public void setCurrentTime() {
        this.currentTime = LocalTime.now();
        updateHands(this.currentTime);
    }

    public void setTime(LocalTime time) {
        this.currentTime = time;
        updateHands(this.currentTime);
    }

    private void updateHands(LocalTime time) {
        for (ClockHand hand : hands) {
            hand.setTime(time);
        }
    }

    public String toSvg() {
        StringBuilder svg = new StringBuilder();
        svg.append("<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\">");
        // Tarcza zegara
        svg.append("<circle cx=\"0\" cy=\"0\" r=\"90\" fill=\"white\" stroke=\"black\" stroke-width=\"4\"/>");
        // Wskazówki
        for (ClockHand hand : hands) {
            svg.append(hand.toSvg());
        }
        svg.append("</svg>");
        return svg.toString();
    }
}