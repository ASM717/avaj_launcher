package amuriel.school21.weather;

import amuriel.school21.Logger;
import amuriel.school21.flyable.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
//    private int count;

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Logger.getLogger().logMessage("Tower says: " + flyable.getMessagePrefix() + " registered to weather tower."); //maybe toString()
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
//        count--;
        Logger.getLogger().logMessage("Tower says: " + flyable.getMessagePrefix() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
//        count = 0;
//        while (count < observers.size()) {
//            observers.get(count).updateConditions();
//            count++;
//        }
        ArrayList<Flyable> list = new ArrayList<>(observers);
        for (Flyable f : list) {
            f.updateConditions();
        }
    }
}
