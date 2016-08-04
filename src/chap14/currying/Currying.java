package chap14.currying;

import java.util.function.DoubleUnaryOperator;

public class Currying {

    public double converter(double val, double coeff, double base) {
        return (coeff * val) + base;
    }

    DoubleUnaryOperator convertCelsiusToFahrenheight() {
        return curriedConverter(9.0/5, 32.0);
    }

    DoubleUnaryOperator convertKmToMiles() {
        return curriedConverter(0.6214, 0.0);
    }

    private DoubleUnaryOperator curriedConverter(double coeff, double base) {
        return (double x) -> (coeff * x) + base;
    }

    public static void main(String[] args) {
        Currying converter = new Currying();
        double celsius = 25;
        double f = converter.convertCelsiusToFahrenheight().applyAsDouble(celsius);
        System.out.println(f);

        double kilo = 42.2;
        double miles = converter.convertKmToMiles().applyAsDouble(kilo);
        System.out.println(miles);
    }

}
