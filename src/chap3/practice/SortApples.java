package chap3.practice;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortApples {

    private List<Apple> inventory;

    public SortApples() {
        Apple apple1 = new Apple(5, "red");
        Apple apple2 = new Apple(4, "green");
        Apple apple3 = new Apple(3, "blue");
        Apple apple4 = new Apple(2, "blue");

        inventory = Arrays.asList(apple1, apple2, apple3, apple4);
    }

    public void sortApples(Comparator<Apple> compare) {
        inventory.sort(compare);
    }

    public void sortApples() {
        Comparator<Apple> comparator = comparing(
                (Apple a) -> a.getWeight());
        inventory.sort(comparator);
    }

    public void sortApplesAnonClass() {
        inventory.sort(new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                } else if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                } else {
                    return 0;
                }
            }

        });
    }

    public void sortApplesLambda() {
        Comparator<Apple> comparing =
                Comparator.comparing((Apple a) -> a.getWeight());
        inventory.sort(comparing);
    }

    public void sortApplesMethodReference() {
        inventory.sort(comparing(Apple::getWeight));
    }

    public List<Apple> getApples() {
        return Collections.unmodifiableList(inventory);
    }

    public static void main(String[] args) {
        SortApples apples = new SortApples();
        System.out.println(apples.getApples());

        apples.sortApples();
        System.out.println(apples.getApples());

        Comparator<Apple> colorComparator = comparing(Apple::getColor);
        apples.sortApples(colorComparator);
        System.out.println(apples.getApples());

        apples.sortApples(colorComparator
                          .reversed()
                          .thenComparing(Apple::getWeight));
        System.out.println(apples.getApples());
    }
}
