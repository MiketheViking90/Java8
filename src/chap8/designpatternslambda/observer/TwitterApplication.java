package chap8.designpatternslambda.observer;

public class TwitterApplication {

    public static void main(String[] args) {
        notifyTest();
        notifyLambda();
    }

    private static void notifyTest() {
        Observer nyt = new NYTimes();
        Observer guardian = new Guardian();
        Observer leMonde = new LeMonde();

        Feed twitter = new Feed();
        twitter.register(nyt);
        twitter.register(guardian);
        twitter.register(leMonde);

        twitter.notifyObservers("money wine queen");
        twitter.notifyObservers("money in wine");
        twitter.notifyObservers("queen with money");
    }

    private static void notifyLambda() {
        Feed twitter = new Feed();

        twitter.register((String tweet) -> {
            if (tweet.contains("money")) {
                System.out.println("Breaking news in NYC! " + tweet);
            }
        });

        twitter.register((String tweet) -> {
            if (tweet.contains("queen")) {
                System.out.println("Breaking news in London! " + tweet);
            }
        });

        twitter.notifyObservers("money wine queen");
        twitter.notifyObservers("money in wine");
        twitter.notifyObservers("queen with money");
    }
}
