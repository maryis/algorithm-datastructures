package datastructure.sort;

public class InsertionSort {

    public void sort(int[] arr){

        int n = arr.length;
        for (int i=1;i<n; i++){
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > key){//move back if needed
                arr[j+1] = arr[j];//shift right to make space for key in its right place
                j--;//move back
            }
            arr[j+1] = key;
        }

    }
}
