import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jan", "Kowalski", LocalDate.of(1980, 1, 12));
        Person p6 = new Person("Jan", "Kowalski", LocalDate.of(1981, 1, 12));
        Person p7 = new Person("Jan", "Kowalski", LocalDate.of(1982, 1, 12));
        Person p2 = new Person("Kamil", "Nowak", LocalDate.of(1990, 11, 22));
        Person p3 = new Person("Bartłomiej", "Daniluk", LocalDate.of(1999, 1, 17));
        Person p4 = new Person("Tomasz", "Problem", LocalDate.of(2001, 1, 26));
        Person p5 = new Person("Cwel","Pedał",LocalDate.of(2137,6,9));
        List<Person> people= new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        //System.out.println(p1.adopt(p1));
        p1.adopt(p2);
        p1.adopt(p4);
        p1.adopt(p3);

        System.out.println("Najmłodsze dziecko p1 to :"+p1.getYoungestChild().getImie());
        for(Person p: p1.getChildren()){
            System.out.println("Imie dziecka p1 to "+p.getImie());
        }
//        Map<String,Person> Bis=Map.of();
//        Bis.put(p6.getImie()+" "+ p6.getNazwisko(), p6);
//        Bis.put(p2.getImie()+" "+p2.getNazwisko(),p2);
//        Bis.put(p3.getImie()+" "+p3.getNazwisko(),p3);
//        Bis.put(p4.getImie()+" "+p4.getNazwisko(),p4);
//        Bis.put(p1.getImie()+" "+ p1.getNazwisko(), p1);
//        Family Familia=new Family(Bis);
//        Familia.add(p5);
        //System.out.println(p1.getYoungestChild().getImie());
        //System.out.println(p1.getChildren().get(0).getImie());

        Family fam1 = new Family();
        fam1.add(p1, p2, p3,p4,p5,p6,p7);
        for(Person p :fam1.get("Jan Kowalski")){
            System.out.println(p.getImie()+" "+p.getNazwisko()+" "+p.getDataUrodzin());

        }
    }
}