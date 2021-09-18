package  datastructure.sort;

import java.util.HashMap;
import java.util.Map;

public class QuickSort { //list of primitives   worst case: n^2   best case: n log n

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr, int start, int end) {

        if (start < end) {
            int piv_ind = partition(arr, start, end);
            sort(arr, start, piv_ind-1);
            sort(arr, piv_ind + 1, end);

        }
    }

    //find the right place for end cell
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int piv_ind = start;

        //we want to move all cells smaller than pivot to the left of pivot_idx so
        // we wsap them, and then update pivot_idx
        for (int i = start ; i < end; i++)
            if (arr[i] < pivot) { //if smaller, pivot_idx does next
                int temp = arr[i];
                arr[i] = arr[piv_ind];
                arr[piv_ind] = temp;

                piv_ind = piv_ind+1;
            }

        int temp = arr[end];
        arr[end] = arr[piv_ind];
        arr[piv_ind] = temp;

        return piv_ind;



    }
}
