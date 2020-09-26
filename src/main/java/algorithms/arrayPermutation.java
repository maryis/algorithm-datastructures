package  algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class arrayPermutation {

    static int len;
    static int[] arr1;
    static int[] arr;

    public static void main(String[] args) {

        System.out.println("enter n for having premutation of len n:");
        Scanner scanner = new Scanner(System.in);
        len = scanner.nextInt();

        arr=new int[2];
        arr[0]=2; arr[1] = 3;
        arr1 = new int[len];

        printpermutation(0);//level 0 of tree

        System.out.println("premutation of array without repeat:");
        printpermutation(0,arr.length);
    }

    private static void printpermutation(int start, int end) {
        if(start==end) {
            Arrays.stream(arr).forEach(item -> System.out.printf(Integer.toString(item)));
            System.out.printf("\n");
        }
        for(int i=start;i<end;i++){
            swap(i,start);
            printpermutation(start+1,end);
            swap(i,start);
        }
    }

    private static void swap(int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }

    private static  void printpermutation(int l) {

        if (l == len) { //leaf
            for (int i : arr1) {
                System.out.print(i);
            }
            System.out.println("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            arr1[l] = arr[i];
            printpermutation(l + 1);

        }

    }
}
