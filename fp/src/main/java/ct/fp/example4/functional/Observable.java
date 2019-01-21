package ct.fp.example4.functional;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Observable {

    private final Set<Consumer<Object>> observers = new HashSet<>();

    public void register(Consumer<Object> observer) {
        observers.add(observer);
    }

    public void unregister(Consumer<Object> observer) {

        observers.remove(observer);
    }

    public void sendEvent(Object event) {
        observers.forEach(obs -> obs.accept(event));
    }
}
