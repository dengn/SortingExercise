package dengn.sortingexercise.Sort;

import android.os.SystemClock;

import dengn.sortingexercise.models.SortResult;

/**
 * Created by OLEDCOMM on 13/05/2015.
 */
public class ShellSort {

    public static final SortResult ShellSort(int[] randomArray) {

        long startTime = SystemClock.elapsedRealtimeNanos();

        double d1 = randomArray.length;
        int temp = 0;

        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int x = 0; x < d; x++) {

                for (int i = x + d; i < randomArray.length; i += d) {
                    int j = i - d;
                    temp = randomArray[i];
                    for (; j >= 0 && temp < randomArray[j]; j -= d) {
                        randomArray[j + d] = randomArray[j];
                    }
                    randomArray[j + d] = temp;
                }
            }

            if (d == 1) {
                break;
            }
        }

        long endTime = SystemClock.elapsedRealtimeNanos();

        return new SortResult(randomArray, endTime - startTime);
    }
}
