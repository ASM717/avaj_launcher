package amuriel.school21;

import amuriel.school21.flyable.Coordinates;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int id = Math.abs(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());
//        seed += new Random().nextInt(100);
        return weather[id % 4];
    }
}
