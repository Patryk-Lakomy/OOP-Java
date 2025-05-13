import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private List<Polygon> polyList=new ArrayList<>();
    private int counter=0;
    public void setPolyList(List<Polygon> polyList) {
        this.polyList = polyList;
    }

    public List<Polygon> getPolyList() {
        return polyList;
    }

    public SvgScene(List<Polygon> polyList) {
        this.polyList = polyList;
    }//;
    public void addPolygon(Polygon popopoly){
      if (polyList.size()<3){
          polyList.add(popopoly);
      }
      else {
          if(counter==3)counter=0;
          polyList.get(counter);
          polyList.set(counter,popopoly);
          counter++;
       }
    }
    public String toSvg(){
        String start="<polygon points= ";
        for(int i=0;i<polyList.size();i++) {
            start+=polyList.get(i).toSvg();
        }
        start+=" style="+"fill:lime;stroke:purple;stroke-width:3"+"/>";
        return start;
    }
    public void save(String path,String result){
        File file=new File(path);
        try {
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(result);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
