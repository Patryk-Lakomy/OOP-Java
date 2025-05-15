public class DeathCauseStatistic {
    public DeathCauseStatistic(double[] deathCount, String code) {
        this.deathCount = deathCount;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private String code;
    private double []deathCount;

    public static DeathCauseStatistic fromCsvLine(String line){
        
    };

}
