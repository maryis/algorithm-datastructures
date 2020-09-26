package  datastructure;

import  datastructure.sort.MergeSort;
import  datastructure.sort.QuickSort;

public class MainSort {
    public static void main(String[] args) {

        int[]arr={5,34,6,23,9};

        QuickSort.sort(arr,0,4);
        QuickSort.printArray(arr);

//        MergeSort.sort(arr,0,4);
//        MergeSort.printArray(arr);
    }
}
