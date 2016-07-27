package chap8.designpatternslambda.observer;

public class NYTimes implements Observer {

    @Override
    public void notify(String event) {
        if (event.contains("money")) {
            System.out.println("NY news! " + event);
        }
    }

}
