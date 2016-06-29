package chap3.consumer;

public class Rocket {

    private static int count = 0;
    private final int id = count++;
    private int countdown = 5;

    public void run() {
        while (countdown > 0) {
            System.out.println(id + ": " + countdown--);
        }
        System.out.println(id + ": LiftOff!");
    }
}
