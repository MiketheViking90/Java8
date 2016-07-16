package chap6.grouping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import chap4.Dish;
import chap4.Dish.Type;

public class Group {

    List<Dish> menu = Dish.menu;

    void groupByType() {
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }

    void classifyByLevel() {
        Function<Dish, String> levelClassifier = getLevelClassifier();
        Map<String, List<Dish>> dishesByLevel = menu.stream().collect(Collectors.groupingBy(levelClassifier));
        System.out.println(dishesByLevel);
    }

    void groupByTypeThenLevel() {
        Function<Dish, String> levelClassifer = getLevelClassifier();

        Map<Type, Map<String, List<Dish>>> map = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(levelClassifer)));
        System.out.println(map);
    }

    Function<Dish, String> getLevelClassifier() {
        return (Dish d) -> {
                    if (d.getCalories() <= 400)
                        return "low";
                    else if (d.getCalories() <= 700)
                        return "middle";
                    else return "high";
                };
    }
    public static void main(String[] args) {
        Group gp = new Group();
        gp.groupByType();
        gp.classifyByLevel();
        gp.groupByTypeThenLevel();
    }
}
