package chap2.prettyprintapple;

import chap2.changingrequirements.Apple;

public class WeightCategoryFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        double weight = apple.getWeight();

        String weightClass = classifyWeight(weight);
        return "A " + weightClass + ", " + apple.getColor() + " apple";
    }

    private String classifyWeight(double weight) {
        return (weight > 150) ? "heavy" : "light";
    }

}
