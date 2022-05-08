package amuriel.school21.flyable;

import amuriel.school21.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN" -> {
                coordinateDeltas(0, 10, 2);
                logWeatherMessage("I'm a jet, its sunny.");
            }
            case "RAIN" -> {
                coordinateDeltas(0, 5, 0);
                logWeatherMessage("I'm a jet, its raining.");
            }
            case "FOG" -> {
                coordinateDeltas(0, 1, 0);
                logWeatherMessage("I'm a jet, its foggy.");
            }
            case "SNOW" -> {
                coordinateDeltas(0, 0, 7);
                logWeatherMessage("I'm a jet, its snowing.");
            }
            default -> logWeatherMessage("I'm a jet, ... weather tower unresponsive");
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
    }
}
