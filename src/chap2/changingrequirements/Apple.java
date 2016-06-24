package chap2.changingrequirements;

import java.util.Comparator;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Apple {

    private String color;
    private double weight;

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public static void main(String[] args) {
        Comparator<Apple> appleByColor =
            (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor());
    }

}
