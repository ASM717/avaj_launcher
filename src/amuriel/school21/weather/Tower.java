package amuriel.school21.weather;

import amuriel.school21.flyable.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
//    private int count;

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            System.out.println("Tower says: " + flyable.toString() + " registered to weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
//        count--;
        System.out.println("Tower says: " + flyable.toString() + " unregistered from weather tower.");
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
