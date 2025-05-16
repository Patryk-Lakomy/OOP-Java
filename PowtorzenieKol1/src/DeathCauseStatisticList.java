import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> ArrayofDCS=new ArrayList<>();

    public void repopulate(String path){
        BufferedReader reader;
        String line = "";
        try{
            reader=new BufferedReader(new FileReader(path));
            line =reader.readLine();
            while (line !=null){
                line= reader.readLine();
                //System.out.println(line);
                if(line != null){
                   ArrayofDCS.add(DeathCauseStatistic.fromCsvLine(line));
                }
            }
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n) {
        // Znajdź indeks grupy wiekowej dla podanego wieku
        int ageBracketIndex = -1;
        for (int i = 0; i < DeathCauseStatistic.AgeBracketDeaths.AGE_BRACKETS.length; i++) {
            int min = DeathCauseStatistic.AgeBracketDeaths.AGE_BRACKETS[i][0];
            int max = DeathCauseStatistic.AgeBracketDeaths.AGE_BRACKETS[i][1];
            if (age >= min && (max == -1 || age <= max)) {
                ageBracketIndex = i;
                break;
            }
        }
        if (ageBracketIndex == -1) {
            return new ArrayList<>();
        }

        // Posortuj choroby według liczby zgonów w tej grupie wiekowej (malejąco)
        List<DeathCauseStatistic> sorted = new ArrayList<>(ArrayofDCS);
        sorted.sort((a, b) -> Integer.compare(
                b.DeathCauseStatistic.AgeBracketDeaths.getDeathCounts(ageBracketIndex),
                a.DeathCauseStatistic.AgeBracketDeaths.getDeathCounts(ageBracketIndex)
        ));

        // Zwróć n pierwszych elementów
        return sorted.subList(0, Math.min(n, sorted.size()));
    }
}
