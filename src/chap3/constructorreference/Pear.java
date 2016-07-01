package chap3.constructorreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import lombok.ToString;

@ToString
public class Pear {

    private static int count = 0;

    private final int id = count++;
    private final String color;

    public Pear(String color) {
        this.color = color;
    }

    private static List<Pear> mapPearsByColor(List<String> colors) {
        List<Pear> pears = new ArrayList<>();
        Function<String, Pear> pearApplier = Pear::new;
        for (String color : colors) {
            Pear pear = pearApplier.apply(color);
            pears.add(pear);
        }
        return pears;
    }

    public static void main(String[] args) {
        Function<String, Pear> pearSupplier = Pear::new;
        Function<String, Pear> lambdaPearSupplier =
                (String color) -> new Pear(color);
        /*
        System.out.println(pearSupplier.apply("red"));
        System.out.println(pearSupplier.apply("green"));
        System.out.println(pearSupplier.apply("blue"));
        System.out.println(pearSupplier.apply("yellow"));
         */

        List<String> colors = Arrays.asList("red", "blue", "green");
        List<Pear> pears = mapPearsByColor(colors);

        System.out.println(pears);
    }
}
