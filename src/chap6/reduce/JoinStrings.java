package chap6.reduce;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import chap4.Dish;

public class JoinStrings {

    List<Dish> menu = Dish.menu;

    void getMenuDescriptions() {
        String descr = menu.stream()
                           .map(Dish::getName)
                           .collect(Collectors.joining(", "));
        System.out.println(descr);

        String setDescr = new HashSet<>(menu).stream()
                                             .map(Dish::getName)
                                             .collect(Collectors.joining(", "));
        System.out.println(setDescr);
    }

    public static void main(String[] args) {
        JoinStrings join = new JoinStrings();
        join.getMenuDescriptions();
    }
}
