package chap3.methodreference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSorter {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Sam", "Frodo", "Gandalf", "Aragorn", "tree", "elf");
        Comparator<String> reverseCompare =(String s1, String s2) -> s2.compareTo(s1);
        words.sort(reverseCompare);
        System.out.println(words);

        words.sort(String::compareToIgnoreCase);
        System.out.println(words);
    }
}
