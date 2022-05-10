package amuriel.school21.flyable;

import amuriel.school21.Logger;
import amuriel.school21.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                coordinatesFunc(10, 0, 2);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a helicopter, its sunny.");
                break;
            case "RAIN":
                coordinatesFunc(5, 0, 0);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a helicopter, its raining.");
                break;
            case "FOG":
                coordinatesFunc(1, 0, 0);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a helicopter, its foggy.");
                break;
            case "SNOW":
                coordinatesFunc(0, 0, -12);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a helicopter, its snowing.");
                break;
            default:
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a helicopter, weather tower unresponsive");
                break;
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0) {
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
    public void setType() {
        this.type = "Helicopter";
    }
}
