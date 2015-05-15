package dengn.sortingexercise.Sort;

import android.os.SystemClock;

import dengn.sortingexercise.models.SortResult;

/**
 * Created by OLEDCOMM on 13/05/2015.
 */
public class SelectionSort {

    public static SortResult SelectionSort(int[] randomArray){

        long startTime = SystemClock.elapsedRealtimeNanos();

        for(int i=0;i<randomArray.length;i++){
            int temp = randomArray[i];
            int minValueIndex = getMinValueIndex(randomArray, i);
            if(minValueIndex!=i) {
                randomArray[i] = randomArray[minValueIndex];
                randomArray[minValueIndex] = temp;
            }
        }

        long endTime = SystemClock.elapsedRealtimeNanos();

        return new SortResult(randomArray, endTime-startTime);
    }

    private static int getMinValueIndex(int[] array, int index){
        int minIndex = index;
        for(int i=index+1;i<array.length;i++){
            if(array[minIndex]>array[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }
}
