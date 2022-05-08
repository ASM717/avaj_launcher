package amuriel.school21;

import amuriel.school21.flyable.AircraftFactory;
import amuriel.school21.flyable.Flyable;
import amuriel.school21.weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            String line = bufferedReader.readLine();
            if (line == null)
                throw new ErrorException("The scenario file could not be read.");
            if (!isNumber(line.split(" ")[0]))
                throw new ErrorException("The scenario file is in the wrong format.");
            int cntTotalSim = Integer.parseInt(line.split(" ")[0]);
            if (cntTotalSim <= 0)
                throw new ErrorException("The simulation count is invalid.");

            WeatherTower weatherTower = new WeatherTower();
            while ((line = bufferedReader.readLine()) != null) {
                Flyable flyable = AircraftFactory.newAircraft(
                        line.split(" ")[0],
                        line.split(" ")[1],
                        Integer.parseInt(line.split(" ")[2]),
                        Integer.parseInt(line.split(" ")[3]),
                        Integer.parseInt(line.split(" ")[4])
                );
                weatherTower.register(flyable);
                flyable.registerTower(weatherTower);
            }
            for (int i = 0; i < cntTotalSim; ++i) {
                weatherTower.changeWeather();
            }
            Logger.getLogger().logMessagesToFile();
        } catch (ErrorException | IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isNumber(String string){
        for (int i = 0; i < string.length(); i++){
            if(!Character.isDigit(string.charAt(i)))
                return false;
        }
        return true;
    }

}
