package chap3.practice;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Apple {

    private int weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

}
