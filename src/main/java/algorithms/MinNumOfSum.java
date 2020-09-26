package algorithms;

import java.util.*;

public class MinNumOfSum {

    //min number of sum operation using arr elements to get end from start
    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr,2);
        int start = 2;
        int end = 16;

        int min = getMin(arr, start, end);
        System.out.println(min);
    }


    private static int getMin(int[] arr, int start, int end) {

        Queue<Integer> queue = new LinkedList<Integer>();
        ((LinkedList<Integer>) queue).add(start);
        Map<Integer, Integer> map = new HashMap<>();
        int level = 0;
        map.put(start, 0);

        while (!queue.isEmpty()) {
            int n = queue.remove();
            if (n == end)
                return map.get(n);
            for (int i = 0; i < arr.length; i++) {

                if (!map.containsKey(arr[i] + n)) {
                    queue.add(arr[i] + n);
                    map.put(arr[i] + n, level + 1);
                }
            }
            level++;
        }
        return -1;

    }

}
