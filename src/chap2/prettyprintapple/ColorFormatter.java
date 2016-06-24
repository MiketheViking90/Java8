package chap2.prettyprintapple;

import chap2.changingrequirements.Apple;

public class ColorFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        return apple.getColor();
    }

}
