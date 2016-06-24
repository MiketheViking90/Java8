package chap2.prettyprintapple;

import chap2.changingrequirements.Apple;

public class WeightFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        return String.valueOf(apple.getWeight());
    }

}
