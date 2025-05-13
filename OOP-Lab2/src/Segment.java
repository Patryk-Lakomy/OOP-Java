import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Segment {
    private Point start;
    private Point end;
    public void setEnd(Point end) {
        this.end = end;
    }

    public void setStart(Point start) {
        this.start = start;
    }



    public Segment(Point p1, Point p2) {
        this.start = p1;
        this.end = p2;
    }
    public Segment(Segment seg){
        this.start =seg.start;
        this.end =seg.end;
    }

    public double length(){
        return sqrt(pow(end.getX() - start.getX(),2)+pow(end.getY() - start.getY(),2));
    }
    public static Segment TheLongest(List<Segment> list){
        Segment Longest =list.get(0);
        for (int i=0;i< list.size();i++) {
            if (list.get(i).length() >  Longest.length()){
                Longest= list.get(i);
            }
        }
        return Longest;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
