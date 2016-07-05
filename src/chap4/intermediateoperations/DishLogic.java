package chap4.intermediateoperations;

import java.util.List;
import java.util.stream.Collectors;

import chap4.Dish;

public class DishLogic {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        List<String> heavyDishNames = menu.stream()
                                          .filter(d -> {
                                                      System.out.println("Filtering " + d.getName());
                                                      return d.getCalories() > 300;
                                                  })
                                          .map(d -> {
                                                      System.out.println("mapping " + d.getName());
                                                      return d.getName();
                                                  })
                                          .limit(3)
                                          .collect((Collectors.toList()));
        System.out.println(heavyDishNames);
    }
}
