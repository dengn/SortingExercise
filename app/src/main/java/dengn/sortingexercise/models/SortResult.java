package dengn.sortingexercise.models;

/**
 * Created by OLEDCOMM on 13/05/2015.
 */
public class SortResult {

    private int[] array;
    private long time;

    public SortResult(){}

    public SortResult(int[] array, long time){
        this.array = array;
        this.time = time;
    }

    public int[] getArray(){
        return array;
    }

    public void setArray(int[] array){
        this.array = array;
    }

    public long getTime(){
        return time;
    }

    public void setTime(long time){
        this.time = time;
    }
}
