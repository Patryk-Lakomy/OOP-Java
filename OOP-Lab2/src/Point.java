public class Point {
    private float x;
    private float y;


    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point(){
        this.x=0;
        this.y=0;
    }

    public String toString() {
        return "Ten punkt ma wartość x równą " + x + " oraz wartość y równą " + y;
    }

    public String toSVG(){
      return "<circle cx=\""+ this.x+ "\" cy=\""+ this.y+ "\" r=\"5\" fill=\"black\" />";
    }

    public void translate(float dx,float dy){
        this.x=x+dx;
        this.y=y+dy;
    }

    public Point translated(float dx,float dy){
       Point nowy=new Point(this.x+dx,this.y+dy);
       return nowy;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }


}

