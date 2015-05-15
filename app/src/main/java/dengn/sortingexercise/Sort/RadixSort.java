package dengn.sortingexercise.Sort;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

import dengn.sortingexercise.models.SortResult;

/**
 * Created by OLEDCOMM on 13/05/2015.
 */
public class RadixSort {

    public static SortResult RadixSort(int[] randomArray){

        long startTime = SystemClock.elapsedRealtimeNanos();

        //digits length
        int digits = getMaxRadix(randomArray);
        for(int i=0;i<digits;i++){
            ArrayList<ArrayList<Integer>> rebuildDigits= new ArrayList<ArrayList<Integer>>();

            //Init arrayList to a 10 digits arraylist
            for(int j=0;j<10;j++){
                rebuildDigits.add(new ArrayList<Integer>());
            }
            for(int j=0;j<randomArray.length;j++){
                int insertIndex = randomArray[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10, i);
                rebuildDigits.get(insertIndex).add(randomArray[j]);
            }

            ArrayList<Integer> orderedArray = new ArrayList<Integer>();
            //Resume rebuildDigits back to array
            for(int j=0;j<rebuildDigits.size();j++){
                for(int k=0;k<rebuildDigits.get(j).size();k++){
                    orderedArray.add(rebuildDigits.get(j).get(k));
                }
            }
            for(int j=0;j<randomArray.length;j++){
                randomArray[j] = orderedArray.get(j);
            }
        }

        long endTime = SystemClock.elapsedRealtimeNanos();

        return new SortResult(randomArray, endTime - startTime);
    }

    private static int getMaxRadix(int[] array){
        int maxNumber = array[0];
        for(int i=1;i<array.length;i++){
            if(maxNumber<array[i]){
                maxNumber = array[i];
            }
        }
        int digits = 0;
        while(maxNumber>0){
            maxNumber/=10;
            digits++;
        }
        return digits;
    }

    public static SortResult RadixSortProposed(int[] array){

        long startTime = SystemClock.elapsedRealtimeNanos();
        //首先确定排序的趟数;
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        int time=0;
        //判断位数;
        while(max>0){
            max/=10;
            time++;
        }

        //建立10个队列;
        List<ArrayList> queue=new ArrayList<ArrayList>();
        for(int i=0;i<10;i++){
            ArrayList<Integer>queue1=new ArrayList<Integer>();
            queue.add(queue1);
        }

        //进行time次分配和收集;
        for(int i=0;i<time;i++){
            //分配数组元素;
            for(int j=0;j<array.length;j++){
                //得到数字的第time+1位数;
                int x=array[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10, i);
                ArrayList<Integer>queue2=queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);
            }
            int count=0;//元素计数器;
            //收集队列元素;
            for(int k=0;k<10;k++){
                while(queue.get(k).size()>0){
                    ArrayList<Integer>queue3=queue.get(k);
                    array[count]=queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }

        long endTime = SystemClock.elapsedRealtimeNanos();
        return new SortResult(array, endTime - startTime);

    }
}
