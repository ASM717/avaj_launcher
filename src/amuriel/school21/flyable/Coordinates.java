package amuriel.school21.flyable;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
//        setLongitude(longitude);
//        setLatitude(latitude);
//        setHeight(height);


//        if (height > 100)
//            this.height = 100;
//        else if (height < 0)
//            this.height = 0;
//        else
//            this.height = height;
//        if (latitude < 0)
//            latitude = 0;
//        if (longitude < 0)
//            longitude = 0;
//        this.longitude = longitude;
//        this.latitude = latitude;
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

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
