package  datastructure.sort;

public class  MergeSort { //list of objects  worst,average,best time: n log n

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

    }

    private static void merge(int[] arr, int start, int mid, int end) {

        int left_size = mid - start + 1;
        int right_size = end - mid;


        int[] leftArr = new int[left_size];
        int[] rightArr = new int[right_size];

        for (int i = 0; i < left_size; i++)
            leftArr[i] = arr[start + i];

        for (int i = 0; i < right_size; i++)
            rightArr[i] = arr[mid + 1 + i];

        int left_idx = 0;
        int right_idx = 0;
        int k = start;

        while (left_idx < left_size && right_idx < right_size) {

            if (leftArr[left_idx] <= rightArr[right_idx]) {
                arr[k] = leftArr[left_idx];
                k++;
                left_idx++;

            } else {
                arr[k] = rightArr[right_idx];
                k++;
                right_idx++;
            }
        }

        while (left_idx < left_size) {
            arr[k] = leftArr[left_idx];
            k++;
            left_idx++;
        }

        while (right_idx < right_size) {
            arr[k] = rightArr[right_idx];
            k++;
            right_idx++;
        }

    }


}
