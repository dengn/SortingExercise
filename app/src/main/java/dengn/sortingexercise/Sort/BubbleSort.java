package dengn.sortingexercise.Sort;

import android.os.SystemClock;

import dengn.sortingexercise.models.SortResult;

/**
 * Created by OLEDCOMM on 13/05/2015.
 */
public class BubbleSort {

    public static final SortResult BubbleSort(int[] randomArray) {
        long startTime = SystemClock.elapsedRealtimeNanos();

        for(int i=0;i<randomArray.length;i++){
            for(int j=0;j<randomArray.length-1-i;j++){
                if(randomArray[j]>randomArray[j+1]){
                    int temp = randomArray[j+1];
                    randomArray[j+1] = randomArray[j];
                    randomArray[j] = temp;
                }
            }
        }

        long endTime = SystemClock.elapsedRealtimeNanos();

        return new SortResult(randomArray, endTime - startTime);
    }
}
