package chap3.consumer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerUser<T> {

    public void forEach(Collection<T> values, Consumer<T> consumer) {
        for (T t : values) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        List<String> vals = Arrays.asList("a", "b", "c", "d");

        ConsumerUser<String> stringConsumer = new ConsumerUser<>();
        Consumer<String> printerConsumer = (String str) -> System.out.println(str);
        stringConsumer.forEach(vals, printerConsumer);

        List<Rocket> rockets = Arrays.asList(
                                        new Rocket(),
                                        new Rocket(),
                                        new Rocket(),
                                        new Rocket(),
                                        new Rocket());
        ConsumerUser<Rocket> rocketConsumer = new ConsumerUser<>();
        Consumer<Rocket> rocketLauncher = (Rocket r) -> r.run();
        rocketConsumer.forEach(rockets, rocketLauncher);
    }
}
