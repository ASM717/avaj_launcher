package amuriel.school21.flyable;

import amuriel.school21.Logger;
import amuriel.school21.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                coordinatesFunc(2, 0, 4);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a baloon, its sunny.");
                break;
            case "RAIN":
                coordinatesFunc(0, 0, -5);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a baloon, its raining.");
                break;
            case "FOG":
                coordinatesFunc(0, 0, -3);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a baloon, its foggy.");
                break;
            case "SNOW":
                coordinatesFunc(0, 0, -15);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a baloon, its snowing.");
                break;
            default:
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a baloon, weather tower unresponsive");
                break;
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0){
            this.coordinates.setHeight(0);
            Logger.getLogger().addLoggerLine(prefix() + " landing.");
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public void setType(){
        this.type = "Baloon";
    }
}
