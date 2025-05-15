import java.io.*;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class City {
    private String nameOfCity;

    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    private int timeZone;
    private String latitude;
    private String longitude;

    public String getNameOfCity() {
        return nameOfCity;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setNameOfCity(String nameOfCity) {
        this.nameOfCity = nameOfCity;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public static void generateAnalogClocksSvg(List<City> cities, AnalogClock clock) {
        String dirName = clock.toString();
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (City city : cities) {
            clock.setTime(city.getLocalTime());
            String svg = clock.toSvg();
            File svgFile = new File(dir, city.getName() + ".svg");
            try (FileWriter writer = new FileWriter(svgFile)) {
                writer.write(svg);
            } catch (IOException e) {
                System.err.println("Błąd zapisu pliku SVG dla miasta: " + city.getName());
            }
        }
    }
}
    public City(String nameOfCity, int timeZone, String latitude, String longitude) {
        this.nameOfCity = nameOfCity;
        this.timeZone = timeZone;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public LocalTime localMeanTime(LocalTime time){
        // Parsowanie długości geograficznej (np. "22.5684 E" lub "77.0428 W")
        String[] parts = longitude.trim().split(" ");
        double degrees = Double.parseDouble(parts[0].replace(',', '.'));
        if (parts[1].equalsIgnoreCase("W")) {
            degrees = -degrees;
        }

        // Oblicz przesunięcie godzinowe
        double offsetHours = (degrees / 180.0) * 12.0;
        int offsetSeconds = (int) Math.round(offsetHours * 3600);

        // Odejmij przesunięcie od czasu strefowego
        LocalTime localMean = time.minusSeconds(offsetSeconds);

        return localMean;
    };
    private static City parseLine(String line){
        String []result= (line.split(","));
        City city=new City(result[0],Integer.valueOf(result[1]),result[2],result[3]);
        return city;
    };
    public static Map<String,City> parseFile(){
        BufferedReader reader;
        String line = "";
        Map<String,City> mapOfCities = new java.util.HashMap<>(Map.of());
        try{
            reader=new BufferedReader(new FileReader("src/strefy.csv"));
            line =reader.readLine();
            while (line !=null){
                line= reader.readLine();
                System.out.println(line);
                if(line != null){
                    City city=City.parseLine(line);
                    mapOfCities.put(city.nameOfCity,city);
                }

            }
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return mapOfCities;
    };
}
