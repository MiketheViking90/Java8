package chap14.functionaldatastructures;

public class TrainJourney {

    public int price;
    public TrainJourney onward;

    public TrainJourney(int price, TrainJourney onward) {
        this.price = price;
        this.onward = onward;
    }

    public static TrainJourney link(TrainJourney a, TrainJourney b) {
        TrainJourney t = a;
        while (t.onward != null) {
            t = t.onward;
        }
        t.onward = b;
        return a;
    }

    public static void main(String[] args) {
        TrainJourney e = new TrainJourney(5, null);
        TrainJourney d = new TrainJourney(4, e);
        TrainJourney c = new TrainJourney(3, null);
        TrainJourney b = new TrainJourney(2, c);
        TrainJourney a = new TrainJourney(1, b);
    }

}
