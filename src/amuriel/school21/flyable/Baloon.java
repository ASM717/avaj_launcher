package amuriel.school21.flyable;

import amuriel.school21.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    protected WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}
