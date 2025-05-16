public class DeathCauseStatistic {
    public int[] getDeathCouseStatistic() {
        return deathCouseStatistic;
    }

    public DeathCauseStatistic(String code, int[] deathCouseStatistic) {
        this.code = code;
        this.deathCouseStatistic = deathCouseStatistic;
    }

    public String getCode() {
        return code;
    }

    private String code;
    private int []deathCouseStatistic;

    public static DeathCauseStatistic fromCsvLine(String line){
        String []result= (line.split(","));
        String trim=result[0].trim();
        int []count = new int[0];
        for (int i = 1; i < result.length; i++) {
        count[i]= Integer.valueOf(result[i]);
        }
        DeathCauseStatistic dCS=new DeathCauseStatistic(trim,count);
        return dCS;
    };

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }

        public AgeBracketDeaths returnAge(int wiek){
            for (int i = 0; i < AGE_BRACKETS.length; i++) {
                if(wiek>AGE_BRACKETS[i][0]){
                   int amout= deathCouseStatistic[i];
                   AgeBracketDeaths aBD=new AgeBracketDeaths(AGE_BRACKETS[i][0],AGE_BRACKETS[i][1],amout);
                   return aBD;
                }
            }
            return null;
        };
        public static final int[][] AGE_BRACKETS = {
                {0, 4}, {5, 9}, {10, 14}, {15, 19}, {20, 24},
                {25, 29}, {30, 34}, {35, 39}, {40, 44}, {45, 49},
                {50, 54}, {55, 59}, {60, 64}, {65, 69}, {70, 74},
                {75, 79}, {80, 84}, {85, 89}, {90, 94}, {95, 200}
        };

        public int getDeathCount() {
            return deathCount;
        }
    }


}
