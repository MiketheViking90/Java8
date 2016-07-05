package chap4.terminalopertaions;

import java.util.List;

import chap4.Dish;

public class DishTerminalLogic {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        menu.stream()
            .map(Dish::getName)
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
