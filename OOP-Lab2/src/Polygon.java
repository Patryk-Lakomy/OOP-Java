import java.util.ArrayList;
import java.util.List;

public class Polygon {
    List<Point> listuniusiunia=new ArrayList<>();

    public Polygon(List<Point> listuniusiunia) {
        List<Point>listNew=new ArrayList<>();
        for(int i=0;i<listuniusiunia.size();i++){
            listNew.add(listuniusiunia.get(i));
        }
        this.listuniusiunia = listNew;
    }
// shallow copy -reference only
//    public Polygon(Polygon poly){
//        this.listuniusiunia=poly.listuniusiunia;
//    }
//    deep copy - need new objects
    public Polygon(Polygon poly){
        List<Point> listcopy=new ArrayList<>();
        for (int i = 0; i < listuniusiunia.size() ; i++) {
            Point tomasz=new Point(listuniusiunia.get(i).getX(),listuniusiunia.get(i).getY());
            listcopy.add(tomasz);
        }
    }


    public String toString() {
        String start = "";
        for(int i=0;i<listuniusiunia.size();i++) {
            start += "Punkt "+i+" ma wartość x równą " + listuniusiunia.get(i).getX()
                    + " oraz wartość y równą " + listuniusiunia.get(i).getY() +"\n";
        }
        return start;
    }

    public String toSvg(){
        String start="<polygon points= ";
            for(int i=0;i<listuniusiunia.size();i++) {
                start+=listuniusiunia.get(i).getX()+" , "+listuniusiunia.get(i).getY();
            }
            start+=" style="+"fill:lime;stroke:purple;stroke-width:3"+"/>";
        return start;
    }
}
