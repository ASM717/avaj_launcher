package amuriel.school21;

import amuriel.school21.flyable.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
