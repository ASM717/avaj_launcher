package amuriel.school21;

import amuriel.school21.Logger;
import amuriel.school21.flyable.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Logger.getLogger().logMessage("Tower says: " + flyable.getMessagePrefix() + " registered to weather tower."); //maybe toString()
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.getLogger().logMessage("Tower says: " + flyable.getMessagePrefix() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        ArrayList<Flyable> list = new ArrayList<>(observers);
        for (Flyable f : list) {
            f.updateConditions();
        }
    }
}
