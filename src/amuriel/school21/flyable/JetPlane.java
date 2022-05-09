package amuriel.school21.flyable;

import amuriel.school21.Logger;
import amuriel.school21.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                coordinateDeltas(0, 10, 2);
//                logWeatherMessage("I'm a jet, its sunny.");
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a jet, its sunny.");
                break;
            case "RAIN":
                coordinateDeltas(0, 5, 0);
//                logWeatherMessage("I'm a jet, its raining.");
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a jet, its raining.");
                break;
            case "FOG":
                coordinateDeltas(0, 1, 0);
//                logWeatherMessage("I'm a jet, its foggy.");
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a jet, its foggy.");
                break;
            case "SNOW":
                coordinateDeltas(0, 0, -7);
//                logWeatherMessage("I'm a jet, its snowing.");
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a jet, its snowing.");
                break;
            default:
//                logWeatherMessage("I'm a jet, ... weather tower unresponsive");
                Logger.getLogger().logMessage(getMessagePrefix() + ": I'm a jet, ... weather tower unresponsive");
                break;
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0){
            this.coordinates.setHeight(0);
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
        this.type = "JetPlane";
    }
}
