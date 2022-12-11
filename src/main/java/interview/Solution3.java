package interview;

import java.util.*;

/*
Problem Description

Given are Three arrays A, B and C.

Return the sorted list of numbers that are present in at least 2 out of the 3 arrays.



Problem Constraints
1 <= |A|, |B|, |C| <= 100000

1 <= A[i], B[i], C[i] <= 100000

A, B, C may or may not have pairwise distinct elements.
 */
public class Solution3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        ArrayList<Integer> l = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();

        A.stream().forEach(i -> counter.put(i, 1));

        Set<Integer> setB = new HashSet<>(B);

        setB.stream().forEach(i -> counter.compute(i, (k, v) -> v == null ? 1 : v + 1));

        Set<Integer> setC = new HashSet<>(C);

        setC.stream().forEach(i -> counter.compute(i, (k, v) -> v == null ? 1 : v + 1));

        counter.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    l.add(entry.getKey());
                });

        return l;
    }
}
