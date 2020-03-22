package leetcode.middle.test801To1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-03-22
 * @time 12:47
 **/
public class Test945 {
    public static void main(String[] args) {
        int i = minIncrementForUnique1(new int[]{2,2,2,1});
        System.out.println(i);
    }
    public static int minIncrementForUnique(int[] a) {
        int count =0;
        Arrays.sort(a);
        for (int i = 1; i <a.length ; i++) {
            if (a[i]==a[i-1]){
                int value = a[i];
                int compareIndex =i;
                while (compareIndex+1<a.length&&a[compareIndex+1]-a[i]<=1){
                    int temp = a[compareIndex];
                    a[compareIndex]=a[compareIndex+1];
                    a[compareIndex+1] = temp;
                    compareIndex++;
                }
                a[compareIndex] = a[compareIndex-1]+1;
                count+=a[compareIndex]-value;
            }
            if (a[i]==a[i-1])i--;
        }
        return count;
    }


    public static int minIncrementForUnique1(int[] a) {
        int count =0;
        Arrays.sort(a);
        for (int i = 1; i <a.length ; i++) {
            if (a[i]<=a[i-1]){
                count +=a[i-1]-a[i]+1;
                a[i] = a[i-1]+1;
            }
        }
        return count;
    }
}
