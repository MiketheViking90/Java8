package chap5.findingandmatching;

import java.util.List;
import java.util.Optional;

import chap4.Dish;

public class DishFindAndMatch {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        boolean isVeggieFriendly = menu.stream().anyMatch(Dish::isVegetarian);
        if (isVeggieFriendly) {
            System.out.println("menu is veggie friendly");
        }

        boolean allLowCalorie =
                menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(allLowCalorie);

        boolean noneHighCalorie =
                menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(noneHighCalorie);

        Optional<Dish> veggie = menu.stream().filter(Dish::isVegetarian).findAny();
        Optional<Dish> firstVeggie = menu.stream().filter(Dish::isVegetarian).findFirst();
        System.out.println(veggie);
        System.out.println(firstVeggie);
    }
}
