package ct.fp.example4.imperative;


class MyObserver implements Observer {

    public MyObserver(Observable observable) {

        observable.register(this);
    }

    @Override
    public void onEvent(Object event) {

        System.out.println("event = " + event);

    }

}


public class TestObserver {

    public static void main(String[] args) {

        Observable observable = new Observable();
        MyObserver observer = new MyObserver(observable);

        observable.sendEvent("Event dispatched using a traditional Observer!");

    }
}
