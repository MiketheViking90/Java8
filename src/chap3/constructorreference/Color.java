package chap3.constructorreference;

import lombok.ToString;

@ToString
public class Color {

    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Color> colorFunction = Color::new;
        Color color = colorFunction.apply(5, 23, 4);
        System.out.println(color);
    }
}
