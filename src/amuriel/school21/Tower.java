package amuriel.school21;

import amuriel.school21.flyable.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private int count;

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            System.out.println("amuriel.school21.Tower says: registr");
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        count--;
        System.out.println("amuriel.school21.Tower says: unregistr");
    }

    protected void conditionsChanged() {
        count = 0;
        while (count < observers.size()) {
            observers.get(count).updateConditions();
            count++;
        }
    }

}
