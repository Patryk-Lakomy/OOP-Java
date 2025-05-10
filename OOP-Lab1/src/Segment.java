import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Segment {
    public Point p1;
    public Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double length(){
        return sqrt(pow(p2.x-p1.x,2)+pow(p2.y-p1.y,2));
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
}
