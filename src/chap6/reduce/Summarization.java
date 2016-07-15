package chap6.reduce;

import static java.util.stream.Collectors.summarizingInt;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import chap4.Dish;

public class Summarization {

    private List<Dish> menu = Dish.menu;

    void getCalories() {
        int calories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(calories);
    }

    void sumInts() {
        List<Integer> ints =  Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int sum = ints.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);
    }

    void summarizeCals() {
        IntSummaryStatistics sumStats = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(sumStats);
    }

    public static void main(String[] args) {
        Summarization sum = new Summarization();
        sum.getCalories();
        sum.sumInts();
        sum.summarizeCals();
    }

}
