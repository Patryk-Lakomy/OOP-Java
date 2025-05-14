import java.sql.SQLOutput;
import java.util.*;

public class Family {
    public Family() {
        this.familyMembers = new HashMap<>();
    }

    public Map<String,List<Person>> familyMembers;



//    public void add(Person osoba){
//        String key= osoba.getImie()+" "+osoba.getNazwisko();
//        if (this.familyMembers.containsKey(key)){
//            System.out.println("Duplikat");
//            return;
//        }
//        this.familyMembers.put(key,osoba);
//    }
//    public void add(Person... osoba){
//        for (Person p:osoba){
//            String key=p.getImie()+" "+p.getNazwisko();
//                if(this.familyMembers.containsKey(key)){
//                    System.out.println("Duplikat");
//                    return;
//                }
//            this.familyMembers.put(key,p);
//        }
//    }
public void add(Person... persons){
    for (Person p: persons) {
        String key = p.getImie() + " " + p.getNazwisko();
        if(familyMembers.containsKey(key)){
            familyMembers.get(key).add(p);
        }
        else {
            this.familyMembers.putIfAbsent(key, new ArrayList<>());
            this.familyMembers.get(key).add(p);
        }
    }
}
    public List<Person> get(String key) {
        List<Person> people=this.familyMembers.get(key);

        if (people==null || people.isEmpty())return null;
        people.sort(Comparator.reverseOrder());
        return people;
    }
}
