import java.util.*;
static void quickSort(int low, int high) {
        if (low < high) {
            comparisons += 1;

            int j = partition(low, high);
            quickSort(low, j - 1);
            quickSort(j + 1, high);
        }
    }

    static int partition(int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            comparisons += 1;

            while (i < high && arr[i] <= pivot) {
                comparisons += 2;

                i = i + 1;
            }

            while (j > low && arr[j] >= pivot) {
                comparisons += 2;

                j = j - 1;
            }
            if (i < j) {
                comparisons += 1;

                interchange(i, j);
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }