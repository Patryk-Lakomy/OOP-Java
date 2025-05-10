import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
            Point st=new Point(6,3);
            Point fl=new Point(3,8);
            Point el=new Point(5,6);
            Point bis=new Point(12,6);
            Segment bombel=new Segment(st,fl);
            Segment happyEnd=new Segment(el,bis);
        System.out.println(st.toString());
        System.out.println(fl.toSVG());
        System.out.println(el.translated(3,6));
        List <Segment> lista=new ArrayList<>();
        lista.add(bombel);
        lista.add(happyEnd);
        System.out.println(lista.indexOf(Segment.TheLongest(lista)));



        }
    }
