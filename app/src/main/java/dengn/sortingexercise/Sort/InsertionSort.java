package dengn.sortingexercise.Sort;

import android.os.SystemClock;

import dengn.sortingexercise.models.SortResult;

/**
 * Created by OLEDCOMM on 13/05/2015.
 */
public class InsertionSort {

    public static SortResult InsertionSort(int[] randomArray){

        long startTime = SystemClock.elapsedRealtimeNanos();

        int data_len = randomArray.length;
        for(int i=0;i<data_len;i++){
            int temp = randomArray[i];
            int replace_index = -1;
            for(int j=0;j<i;j++){
                if(temp<randomArray[j]){
                    replace_index = j;
                    break;
                }
            }
            if(replace_index>=0) {
                for (int k = i; k > replace_index; k--) {
                    randomArray[k] = randomArray[k-1];
                }
                randomArray[replace_index]=temp;
            }
        }

        long endTime = SystemClock.elapsedRealtimeNanos();

        return new SortResult(randomArray, endTime-startTime);
    }

    public static final SortResult InsertionSortProposed(int[] randomArray){

        long startTime = SystemClock.elapsedRealtimeNanos();

        int temp=0;
        for(int i=1;i<randomArray.length;i++){
            int j=i-1;
            temp=randomArray[i];
            for(;j>=0&&temp<randomArray[j];j--){
                randomArray[j+1]=randomArray[j];  //Moves values forward
            }
            randomArray[j+1]=temp;
        }

        long endTime = SystemClock.elapsedRealtimeNanos();

        return new SortResult(randomArray, endTime-startTime);
    }
}
