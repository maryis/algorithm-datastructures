package  datastructure.sort;

public class HeapSort {
    //time xomplexity for every situation: nlogn (linearithmic)
    public static void main(String[] args) {

        int[]arr={5,34,6,23,9};

        heapSort(arr,arr.length,0);
        printArray(arr);

    }

    private static void heapSort(int[] arr, int length, int nod) {

        //make a heap tree (every node is max of its children)
        for(int i=length/2-1;i>=0;i--)
            heapify(arr,length,i);

        //every time get the max from arr[0]
        //put it in the end of array, and heapify array without end section
        for(int i=length-1;i>0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }


    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
    private static void heapify(int[] arr, int length, int i) {
        int max=i;
        int l=i*2+1;
        int r=i*2+2;

        if(l<length && arr[l]>arr[max])
            max=l;
        if(r<length && arr[r]>arr[max])
            max=r;

        if(max!=i){
            swap(arr,i,max);
            heapify(arr,length,max);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
