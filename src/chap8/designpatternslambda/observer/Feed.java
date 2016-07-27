package chap8.designpatternslambda.observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }


}
