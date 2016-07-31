package chap10.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Properties {

    private Map<String, String> props = new HashMap<>();

    void setProperty(String key, String value) {
        props.put(key,  value);
    }

    public int getValueAsDurationInSeconds(String key) {
        String value = props.get(key);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        return 0;
    }

    public int getValueAsDurationInSeconds_NullSafe(String key) {
        String value = props.get(key);
        return Optional.ofNullable(value)
                       .map(Integer::parseInt)
                       .filter(d -> d > 0)
                       .orElse(0);
    }

    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("a", "4");
        prop.setProperty("b", "fake");
        prop.setProperty("c", "-3");

        int aVal = prop.getValueAsDurationInSeconds_NullSafe("a");
        System.out.println(aVal);
        int cVal = prop.getValueAsDurationInSeconds_NullSafe("c");
        System.out.println(cVal);

    }
}
