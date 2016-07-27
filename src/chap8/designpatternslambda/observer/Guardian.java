package chap8.designpatternslambda.observer;

public class Guardian implements Observer {

    @Override
    public void notify(String event) {
        if (event.contains("queen")) {
            System.out.println("London news! " + event);
        }
    }

}
