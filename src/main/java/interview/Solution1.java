package interview;

/*
Problem Description

GIven three prime numbers A, B and C and an integer D.

You need to find the first(smallest) D integers which only have A, B, C or a combination of them as their prime factors.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution1 {
    public static int solve(int A, int B, int C, int D) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(A, 1);
        map.compute(B, (k, v) -> v == null ? 1 : v + 1);
        map.compute(C, (k, v) -> v == null ? 1 : v + 1);
        map.compute(D, (k, v) -> v == null ? 1 : v + 1);

        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey()+" "+ entry.getValue()));

        long notGood = map.entrySet().stream()
                .filter(entry -> entry.getValue()%2!=0)
                .count();

        int sum= map.entrySet().stream()
                .map(entry -> entry.getValue())
                .reduce(0, (a,b) ->a+b);


        return notGood > 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(1,2,3,4));
    }
}