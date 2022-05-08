package amuriel.school21.flyable;

import amuriel.school21.Logger;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected String type;
    protected Coordinates coordinates;
    protected String messagePrefix;
    private static long idCounter = 0L; //1

    protected Aircraft(String name, Coordinates coordinates) {
        setName(name);
        setCoordinates(coordinates);
        setId(nextId());
        setType();
        setMessagePrefix(getType() + "#" + getName() + "(" + getId() + ")");
    }

    public void coordinateDeltas(int x, int y, int z) { //longitude, latitude, height
        if (x != 0)
            this.coordinates.setLatitude(this.coordinates.getLatitude() + x);
        if (y != 0)
            this.coordinates.setLongitude(this.coordinates.getLongitude() + y);
        if (z != 0)
            this.coordinates.setHeight(this.coordinates.getHeight() + z);
    }

    public void logWeatherMessage(String message){
        Logger.getLogger().logMessage(getMessagePrefix() + ": " + message);
    }

    public long nextId() {
        return idCounter += 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType() {}

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getMessagePrefix() {
        return messagePrefix;
    }

    public void setMessagePrefix(String messagePrefix) {
        this.messagePrefix = messagePrefix;
    }
}
