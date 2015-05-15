package dengn.sortingexercise.Sort;

import android.os.SystemClock;

import dengn.sortingexercise.models.SortResult;

/**
 * Created by OLEDCOMM on 13/05/2015.
 */
public class QuickSort {

    public static SortResult QuickSort(int[] randomArray){

        long startTime = SystemClock.elapsedRealtimeNanos();

        qsort(randomArray, 0, randomArray.length-1);

        long endTime = SystemClock.elapsedRealtimeNanos();

        return new SortResult(randomArray, endTime-startTime);
    }

    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //split the array to two parts
            qsort(arr, low, pivot-1);                   //recursion sort of left sub array
            qsort(arr, pivot+1, high);                  //recursion sort of right sub array
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //pivot record
        while (low<high){
            while (low<high && arr[high]>=pivot) {
                --high;
            }
            arr[low]=arr[high];             //exchange values smaller than pivot to left
            while (low<high && arr[low]<=pivot) {
                ++low;
            }
            arr[high] = arr[low];           //exchange values higher than pivot to right
        }

        arr[low] = pivot;

        return low;
    }
}
