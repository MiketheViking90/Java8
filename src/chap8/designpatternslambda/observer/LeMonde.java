package chap8.designpatternslambda.observer;

public class LeMonde implements Observer {

    @Override
    public void notify(String event) {
        if (event.contains("wine")) {
            System.out.println("Paris news! " + event);
        }
    }

}
