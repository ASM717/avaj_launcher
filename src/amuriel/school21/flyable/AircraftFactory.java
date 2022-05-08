package amuriel.school21.flyable;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        return switch (type) {
            case "Helicopter" -> new Helicopter(name, coordinates);
            case "JetPlane" -> new JetPlane(name, coordinates);
            case "Baloon" -> new Baloon(name, coordinates);
            default -> null;
        };
    }
}
