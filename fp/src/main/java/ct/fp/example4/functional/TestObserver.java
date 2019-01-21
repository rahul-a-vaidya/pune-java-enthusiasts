package ct.fp.example4.functional;

public class TestObserver {

    public static void main(String[] args) {

        Observable observable = new Observable();

        observable.register(event -> System.out.println(event));

        observable.sendEvent("Event dispatched to a java.util.function.Consumer!");
    }
}
