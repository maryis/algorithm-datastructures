package datastructure.sort;

import java.time.LocalDate;
import java.util.*;

import static java.time.LocalDate.now;

public class Quick {

    public static void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr, int s, int e) {
        if(s<e){
            int idx=partition(arr,s,e);
            sort(arr,s,idx-1);
            sort(arr,idx+1,e);
        }
    }

    private static int partition(int[] arr, int s, int e) {
        int piv=arr[e];
        int piv_idx=s;
        for(int i=s;i<e;i++){
            if(piv>arr[i]){
                swap(arr,i,piv_idx);
                piv_idx++;
            }
        }
        swap(arr,piv_idx,e);
        return piv_idx;
    }

    private static void swap(int[] arr, int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
        int[]arr={1,2,76,34,2};

        sort(arr);
        System.out.println( Arrays.stream(arr).reduce((a,b)->a+b).orElseGet(()->0));
        Arrays.stream(arr).forEach(System.out::println);
    }
}
