import java.util.*;

public class Merge{
	public int[] arr;
	public void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }
	
	public void merge(int low, int mid, int high) {
        int n = high - low + 1;
        int[] t_arr = new int[n];
        int i = low, j = mid + 1, k = 0;
        while ((i <= mid) && (j <= high)) {

            if (arr[i] <= arr[j]) {

                t_arr[k] = arr[i];
                i++;
            } else {

                t_arr[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            // Put remaining elements from left subpart (if any) to temporary array.

            t_arr[k] = arr[i];
            i++;
            k++;
        }
        while (j <= high) {
            // Put remaining elements from right subpart (if any) to temporary array
            t_arr[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0; k < n; k++) {
            // Copy Elements from temporary array to original array.
            arr[low + k] = t_arr[k];
        }
    }
	
	public static void main(String[] args){
		int[] arr = {5,4,3,2,1};
		Merge m = new Merge();
		m.arr = arr;
		m.mergeSort(0,4);
		for(int i=0; i<5;i++){
			System.out.print(" " + arr[i]);
		}
	}
}