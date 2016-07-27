package chap8.designpatternslambda.observer;

public interface Subject {

    void register(Observer observer);

    void notifyObservers(String tweet);

}
