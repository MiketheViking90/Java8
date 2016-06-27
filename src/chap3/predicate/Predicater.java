package chap3.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicater<T> {

    public List<T> filter(List<T> vals, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : vals) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d");
        Predicater<String> stringPredicater = new Predicater<>();

        Predicate<String> nullFilter = (String str) -> (str != null);
        List<String> filtered = stringPredicater.filter(strings, nullFilter);
        System.out.println(filtered);

        Predicate<String> afterBFilter = (String str) -> (str.compareTo("b") >= 1);
        filtered = stringPredicater.filter(strings, afterBFilter);
        System.out.println(filtered);
    }

}
