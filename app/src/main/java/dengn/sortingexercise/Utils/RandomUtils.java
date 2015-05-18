package dengn.sortingexercise.Utils;

/**
 * Created by OLEDCOMM on 12/05/2015.
 */
public class RandomUtils {

    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     */
    public static int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }


    /**
     *
     * @param array input Random Array
     * @return String of this Array
     */
    public static String getRandomArrayString(int[] array){
        StringBuilder randomArrayStringBuilder = new StringBuilder();
        randomArrayStringBuilder.append("{");
        for(int i=0;i<array.length-1;i++){
            randomArrayStringBuilder.append(String.valueOf(array[i]));
            randomArrayStringBuilder.append(", ");
        }
        randomArrayStringBuilder.append(String.valueOf(array[array.length-1]));
        randomArrayStringBuilder.append("}");
        return randomArrayStringBuilder.toString();
    }

    /**
     *
     * @param number array number
     * @param min setting min value
     * @param max setting max value
     * @return true if array number is smaller than MAX-MIN, otherwise false
     */
    public static boolean checkArrayNumberValid(int number, int min, int max){
        return (max - min) > number;
    }

    /**
     *
     * @param min setting min value
     * @param max setting max value
     * @return true if max > min, otherwise false
     */
    public static boolean checkMinSmallerMax(int min, int max){
        return min < max;
    }

    /**
     *
     * @param number input integer number
     * @return check if number>0 && number<Integer.MAX_VALUE
     */
    public static boolean checkIntEdge(int number){
        return number >= 0 && number < Integer.MAX_VALUE;
    }
}
