package chap6.reduce;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import chap4.Dish;

public class CollectReduce {

    private List<Dish> menu = Dish.menu;

    private void reduceCount() {
        long count = menu.stream().collect(Collectors.counting());
        long simpleCount = menu.stream().count();
        System.out.println(count);
    }

    private void getLowestCalDish() {
        Comparator<Dish> compareCals = Comparator.comparingInt(Dish::getCalories);
        Dish lowCal = menu.stream().collect(Collectors.minBy(compareCals)).get();
        System.out.println(lowCal);
    }

    private void getAlphaDish() {
        Comparator<Dish> compareName = (d1, d2) -> d1.getName().compareTo(d2.getName());
        Dish alphaDish = menu.stream().collect(Collectors.minBy(compareName)).get();
        System.out.println(alphaDish);
    }

    public static void main(String[] args) {
        CollectReduce cr = new CollectReduce();
        cr.reduceCount();
        cr.getLowestCalDish();
        cr.getAlphaDish();
    }
}
