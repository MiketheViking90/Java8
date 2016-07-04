package chap3;

import java.util.function.Function;

public class Letter {

    private static String addHeader(String text) {
        return "Dear Jim, " + text;
    }

    private static String addBody(String text) {
        return  text + "\n\tHow are you?";
    }

    private static String addFooter(String text) {
        return text + "\nBest, Jim ";
    }

    public static void main(String[] args) {
        String text = "";
        Function<String, String> withHeader = Letter::addHeader;
        Function<String, String> composeLetter =
                withHeader.andThen(Letter::addBody).andThen(Letter::addFooter);
        String letter = composeLetter.apply("");
        System.out.println(letter);
    }
}
