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
                coordinateDeltas(10, 0, 2);
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a helicopter, its sunny.");
                break;
            case "RAIN":
                coordinateDeltas(5, 0, 0);
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a helicopter, its raining.");
                break;
            case "FOG":
                coordinateDeltas(1, 0, 0);
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a helicopter, its foggy.");
                break;
            case "SNOW":
                coordinateDeltas(0, 0, -12);
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a helicopter, its snowing.");
                break;
            default:
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a helicopter, ... weather tower unresponsive");
                break;
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0) {
            this.coordinates.setHeight(0);
//            logWeatherMessage("landing.");
            Logger.getLogger().logMessage(getMessagePrefix() + " landing.");
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
