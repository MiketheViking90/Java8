package chap13.functionalinpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSubsets {

    public List<List<Integer>> findSubsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> sol = new ArrayList<>();
            sol.add(Collections.emptyList());
            return sol;
        }

        int first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> sub1 = findSubsets(rest);
        List<List<Integer>> sub2 = insertToList(first, sub1);

        return concatLists(sub1, sub2);
    }

    private List<List<Integer>> insertToList(int first, List<List<Integer>> sub1) {
        List<List<Integer>> sol = new ArrayList<>();

        for (List<Integer> val : sub1) {
            List<Integer> copy = new ArrayList<>(val);
            copy.add(first);
            sol.add(copy);
        }
        return sol;
    }

    private List<List<Integer>> concatLists(List<List<Integer>> sol1, List<List<Integer>> sol2) {
        List<List<Integer>> combinedList = new ArrayList<>(sol1);
        combinedList.addAll(sol2);
        return combinedList;
    }

    public static void main(String[] args) {
        FindSubsets fs = new FindSubsets();
        List<Integer> vals = new ArrayList<>(Arrays.asList(1, 4, 9));
        List<List<Integer>> combos = fs.findSubsets(vals);
        System.out.println(combos);
    }

}
