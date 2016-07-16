package chap6.partitioning;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import chap4.Dish;

public class Partition {

    List<Dish> menu = Dish.menu;

    void partitionVeggie() {
        Map<Boolean, List<Dish>> vegMap = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(vegMap.get(true));
        System.out.println(vegMap.get(false));
    }

    void mapVeggie() {
        List<Dish> vegMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(vegMenu);
    }

    void partitionThenMap() {
        Map<Boolean, List<String>> paritionMap =
                menu.stream().collect(partitioningBy(Dish::isLowCalorie,
                        mapping(Dish::getName, toList())));
        System.out.println(paritionMap.get(true));
        System.out.println(paritionMap.get(false));
    }

    void partThenGroup() {
        System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,
                groupingBy(Dish::getType))).get(true));

    }
    public static void main(String[] args) {
        Partition p = new Partition();
        p.partitionVeggie();
        p.mapVeggie();
        p.partitionThenMap();
        p.partThenGroup();
    }
}
