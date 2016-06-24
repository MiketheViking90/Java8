package chap2.changingrequirements;

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

}
