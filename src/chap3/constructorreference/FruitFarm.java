package chap3.constructorreference;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FruitFarm {

    private static Map<String, Supplier<Fruit>> inputToFruitMap = new HashMap<>();
    static {
        inputToFruitMap.put("apple", Apple::new);
        inputToFruitMap.put("banana", Banana::new);
        inputToFruitMap.put("peach", Peach::new);
        inputToFruitMap.put("pear", Pear::new);
        inputToFruitMap.put("orange", Orange::new);
    }

    static abstract class Fruit{};

    static class Pear extends Fruit{};

    static class Peach extends Fruit{};

    static class Apple extends Fruit{};

    static class Banana extends Fruit{};

    static class Orange extends Fruit{};

}
