package amuriel.school21.flyable;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    Coordinates(int longitude, int latitude, int height) {
        if (height > 100)
            this.height = 100;
        else if (height < 0)
            this.height = 0;
        else
            this.height = height;
        if (latitude < 0)
            latitude = 0;
        if (longitude < 0)
            longitude = 0;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
