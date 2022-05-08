package amuriel.school21.flyable;

import amuriel.school21.weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);
    String getMessagePrefix();//for tower mes
}
