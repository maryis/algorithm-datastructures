package  algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class arrayPermutation {

    public static void main(String[] args) {

        System.out.println("enter n for having permutation of len n:");
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr={1,2,3};

        int[] result = new int[len];
        permutateN(arr, result, len, 0);//level 0 of tree

        System.out.println("permutation of array without repeat:");
        permutate(arr,0, arr.length);
    }

    private static void permutate(int[] arr, int start, int end) {
        if(start==end) {
            Arrays.stream(arr).forEach(item -> System.out.printf(Integer.toString(item)));
            System.out.printf("\n");
        }
        for(int i=start;i<end;i++){
            swap(arr, i,start);
            permutate(arr,start+1,end);
            swap(arr, i,start);
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }

    private static  void permutateN(int[] arr, int[] res, int len, int level) {

        if (level == len) { //leaf
            for (int i : res) {
                System.out.print(i);
            }
            System.out.println("\n");
            return;
        }

        for (int i = 0; i < arr.length ; i++) {
            res[level] = arr[i];
            permutateN(arr, res, len, level + 1);

        }

    }
}
