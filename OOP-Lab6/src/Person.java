import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable{
    private String imie;
    private String nazwisko;
    private LocalDate dataUrodzin;
    private Set<Person> childrenSet;
    private LocalDate dataŚmierci;

    public Person(String imie, String nazwisko, LocalDate dataUrodzin,LocalDate dataŚmierci) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzin = dataUrodzin;
        this.childrenSet=new HashSet<>();
        this.dataŚmierci=dataŚmierci;
    }

    public boolean adopt(Person children){
        if (children == null || children == this)return false;
        childrenSet.add(children);
        return true;
    }
//    zad 2
//    public Person getYoungestChild(){
//        Person youngest=null;
//        if (!childrenSet.isEmpty())return null;
//        else{
//            for(Person p:childrenSet){
//                if (youngest==null)youngest=p;
//                if(p.dataUrodzin.isAfter(youngest.dataUrodzin)){
//                    youngest=p;
//                }
//            }
//        }
//        return youngest;
//    }zad z compare to
public Person getYoungestChild(){
    if (this.childrenSet == null )return null;
    Person youngest= this.childrenSet.iterator().next();
    for(Person p:this.childrenSet){
        if (youngest.dataUrodzin.compareTo(p.dataUrodzin)<0){
            youngest=p;
        }
    }
    return youngest;
    }
    public List<Person> getChildren(){
        List<Person> sortedChildren= new ArrayList<>(this.childrenSet);
        Collections.sort(sortedChildren, Collections.reverseOrder());
    return sortedChildren;
    }


    public int compareTo(Person other){
        if (this.dataUrodzin.isBefore(other.dataUrodzin)) return 1;
        else if(this.dataUrodzin.isAfter(other.dataUrodzin)) return -1;
        else return 0;
    }

    public Person fromCsvLine(String line){
        //Marek Kowalski,15.05.1899,25.06.1957,,
        

        return
    };
    public  String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public LocalDate getDataUrodzin() {
        return dataUrodzin;
    }

    public Set<Person> getChildrenSet() {
        return childrenSet;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setDataUrodzin(LocalDate dataUrodzin) {
        this.dataUrodzin = dataUrodzin;
    }

    public void setChildrenSet(Set<Person> childrenSet) {
        this.childrenSet = childrenSet;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
