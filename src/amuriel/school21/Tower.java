package amuriel.school21;

import amuriel.school21.flyable.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Logger.getLogger().addLoggerLine("Tower says: " + flyable.prefix() + " registered to weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.getLogger().addLoggerLine("Tower says: " + flyable.prefix() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        ArrayList<Flyable> list = new ArrayList<>(observers);
        for (Flyable f : list) {
            f.updateConditions();
        }
    }
}
