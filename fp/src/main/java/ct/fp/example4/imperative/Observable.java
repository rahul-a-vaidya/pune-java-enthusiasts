package ct.fp.example4.imperative;

import java.util.HashSet;
import java.util.Set;

public class Observable {

    private final Set<Observer> observers = new HashSet<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void sendEvent(Object event) {
        for (Observer observer : observers) {
            observer.onEvent( event );
        }
    }
}
