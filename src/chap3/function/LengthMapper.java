package chap3.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LengthMapper {

    public List<Integer> mapStrenghByLenght(List<String> values,
                                            Function<String, Integer> f) {
        List<Integer> lengths = new ArrayList<>();
        for (String val : values) {
            int len = f.apply(val);
            lengths.add(len);
        }
        return lengths;
    }
}
