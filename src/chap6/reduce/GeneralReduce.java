package chap6.reduce;

import java.util.List;
import java.util.stream.Collectors;

import chap4.Dish;

public class GeneralReduce {

    List<Dish> menu = Dish.menu;

    void generalSum() {
        int cals = menu.stream()
                       .map(Dish::getCalories)
                       .collect(Collectors.reducing(0, (a, b) -> a+b));
        System.out.println(cals);

        int simpleCals = menu.stream()
                             .collect(Collectors.reducing(
                                     0, Dish::getCalories, Integer::sum));
        System.out.println(simpleCals);
    }

    void hiCalDish() {
        Dish hiCal = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2).get();
        System.out.println(hiCal);

        Dish lowCalCollect = menu.stream()
                                .collect(Collectors.reducing(
                                        (d1, d2) -> (d1.getCalories() <  d2.getCalories()) ? d1 : d2))
                                .get();
        System.out.println(lowCalCollect);
    }

    void dishCount() {
        long cnt = menu.stream().count();
        long cnt2 = menu.stream().collect(Collectors.counting());
        System.out.println(cnt);
        System.out.println(cnt2);
    }

    void joinNames() {
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(", ")));
    }
    public static void main(String[] args) {
        GeneralReduce gr = new GeneralReduce();
        gr.generalSum();
        gr.hiCalDish();
        gr.dishCount();
        gr.joinNames();
    }
}
