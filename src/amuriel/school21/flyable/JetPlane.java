package amuriel.school21.flyable;

import amuriel.school21.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    protected WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}
