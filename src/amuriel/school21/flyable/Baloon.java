package amuriel.school21.flyable;

import amuriel.school21.weather.WeatherTower;

import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;
    private HashMap<String, String> reports = new HashMap<>();

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                coordinateDeltas(2, 0, 4);
                logWeatherMessage("I'm a baloon, its sunny.");
                break;
            case "RAIN":
                coordinateDeltas(0, 0, 5);
                logWeatherMessage("I'm a baloon, its raining.");
                break;
            case "FOG":
                coordinateDeltas(0, 0, 3);
                logWeatherMessage("I'm a baloon, its foggy.");
                break;
            case "SNOW":
                coordinateDeltas(0, 0, 15);
                logWeatherMessage("I'm a baloon, its snowing.");
                break;
            default:
                logWeatherMessage("I'm a baloon, ... weather tower unresponsive");
                break;
        }

        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0){
            this.coordinates.setHeight(0);
            logWeatherMessage("landing.");
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
//        this.weatherTower.register(this);
    }

    @Override
    public void setType(){
        this.type = "Baloon";
    }
}
