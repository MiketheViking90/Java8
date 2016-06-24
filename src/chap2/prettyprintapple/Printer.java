package chap2.prettyprintapple;

import java.util.Arrays;
import java.util.List;

import chap2.changingrequirements.Apple;

public class Printer {

    public void print(List<Apple> inventory,
                      AppleFormatter formatter) {
        for (Apple a : inventory) {
            String appleStr = formatter.format(a);
            System.out.println(appleStr);
        }
    }

    private void printAnon(List<Apple> inventory) {
        for (Apple a : inventory) {
            String appleStr = new AppleFormatter() {
                @Override
                public String format(Apple apple) {
                    return apple.getColor();
                }
            }.format(a);

            System.out.println(appleStr);
        }
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple("green", 170);
        Apple apple2 = new Apple("red", 100);
        Apple apple3 = new Apple("green", 100);
        Apple apple4 = new Apple("red", 180);
        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3, apple4);
        Printer printer = new Printer();

        printer.print(inventory, new WeightFormatter());
        printer.print(inventory, new ColorFormatter());
        printer.print(inventory, new WeightCategoryFormatter());

        printer.printAnon(inventory);
    }

}
