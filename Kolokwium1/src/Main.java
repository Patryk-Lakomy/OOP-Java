import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String,City> ZbiorMiast=new HashMap<>();
        ZbiorMiast=City.parseFile();
        City city1=new City("Lublin",2,"24.4539 N"," 54.3773 E");
        City city2=new City("Ateny",3,"37.9838 N", "23.7275 E");
        City city3=new City("Amsterdam",2,"52.3676 N"," 4.9041 E");
        City city4=new City("Bangkok",7,"13.7563 N", "100.5018 E");
        DigitalClock c1 = new DigitalClock(12,4,1,city1,DigitalClock.ClockVersion.EnglishClock);
        DigitalClock c2 = new DigitalClock(13,50,1,city2 ,DigitalClock.ClockVersion.EnglishClock);
        DigitalClock c3 = new DigitalClock(21,50,7,city3 ,DigitalClock.ClockVersion.EuropeanClock);
        DigitalClock c4 = new DigitalClock(12,6,0,city4 ,DigitalClock.ClockVersion.EuropeanClock);
        System.out.println(c1.ToStringDigital());
//        System.out.println(c2.ToStringDigital());
//        System.out.println(c3.ToStringDigital());
//        System.out.println(c4.ToStringDigital());

        //c1.SetCity(city4);
        //System.out.println(c1.ToStringDigital());
        LocalTime czasStrefowy = LocalTime.of(12, 0, 0);
        System.out.println(city1.localMeanTime(czasStrefowy));

        }
    }
